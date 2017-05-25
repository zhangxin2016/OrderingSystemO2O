package com.zx.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.model.Detailorder;
import com.zx.model.Evaluate;
import com.zx.model.Food;
import com.zx.model.Stores;
import com.zx.service.DetailOrderService;
import com.zx.service.EvaluateService;
import com.zx.service.FoodService;
import com.zx.service.StoresService;
import com.zx.util.AddressPort;
import com.zx.util.GetIp;
import com.zx.util.Page;
import com.zx.util.Unicode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Xin on 2017/3/27.
 */
@Controller
public class FoodController {

    @Autowired
    private FoodService foodService;
    @Autowired
    private StoresService storesService;
    @Autowired
    private DetailOrderService detailOrderService;
    @Autowired
    private EvaluateService evaluateService;

    private String IPADDRESS = "http://ip.chemdrug.com/";
    Jedis jedis = new Jedis("120.76.114.25",6379,30000);
    //后台全部食品展示
    //分页功能
    @RequestMapping("/getAllFoodFront")
    public ModelAndView getAllFood(@RequestParam(value="currentPage",defaultValue="1") Integer currentPage,
                                         @RequestParam(value="lineSize",defaultValue="5") Integer lineSize ,
                                         @RequestParam(value="keyWord",defaultValue="") String keyWord, HttpServletRequest request)
    {
        ModelAndView mv=new ModelAndView("back/food/foodsList");
        Map<String,Object> map=null;
        try{
            map=this.foodService.getAllFood(currentPage, lineSize, keyWord);
            System.out.println("map.get(foods)"+map.get("foods"));
            mv.addObject("foods", map.get("foods"));
            /**
             * 下面的分页参数一定要传过去,不然没法使用分页插件
             */
            mv.addObject("pageInfo", map.get("pageInfo"));

            System.out.printf("map.get(pageInfo)"+map.get("pageInfo"));
            mv.addObject("lineSizes", new int[]{5,10,15,20,25,30});

            mv.addObject("keyWord", keyWord)  ;
        }catch(Exception e){
            //mv.setViewName("err");
            System.out.printf("菜品列表列表出现异常！");
        }
        return mv  ;
    }
    /*
     * 后端根据菜品ID获取店铺信息
     */

    @RequestMapping("/getStoresByFood")
    public String getStoresByFood(Integer fid,HttpSession session, HttpServletRequest request) throws Exception {
        System.out.println("stid======"+fid);
        Food food = foodService.findStoresByFood(fid);
        request.setAttribute("findstoresByFood",food);
        return "back/food/findstoresbyfood";
    }

    /*
     *根据ID获取食物
     */
    @RequestMapping("/getFoodById")
    public String getFoodById(HttpServletRequest request,Integer fid) throws Exception{
        String foodString = jedis.get("foodid"+fid);
        if (foodString!=null){
            Food food = JSON.parseObject(foodString,Food.class);
            System.out.println("redisfood======"+food);
            request.setAttribute("food", food);
            detailFood(request,food);
        }else{
            Food food = foodService.findFoodById(fid);
            System.out.println("mysqlfood======"+food);
            request.setAttribute("food", food);
            JSONObject json = (JSONObject) JSONObject.toJSON(food);
            String jsonString =json.toString();
            jedis.set("foodid"+food.getFid(),jsonString);
            detailFood(request,food);
        }
        //Food food = foodService.findFoodById(fid);
        return "/front/food/detailFood";
    }
    public void detailFood(HttpServletRequest request,Food food) throws Exception{
        List<Evaluate> evaluateList = new ArrayList<Evaluate>();
        List<Detailorder> detailorderList = detailOrderService.findDetailListByFid(food.getFid());
        for (Detailorder detailorder : detailorderList) {
            Evaluate evaluate = evaluateService.findEvaluateByDoid(detailorder.getDoid());
            if (evaluate != null) {
                evaluateList.add(evaluate);
            }
        }
        request.setAttribute("foodDetailEvaluateList",evaluateList);
        String city = getCity();
        List<Stores> storesList = storesService.getStoresByAddress(city);
        List<Food> foodList1 = new ArrayList<Food>();
        int x = 0;
        for(Stores stores:storesList){
            List<Food> foodList = foodService.findAllByStid(stores.getStid());
            for (Food food1:foodList){
                if (x<2){
                    foodList1.add(food1);
                }
                x++;
            }
        }
        request.setAttribute("foodListLook",foodList1);
    }
    public String getCity() throws Exception{
        GetIp fetcher=new GetIp(IPADDRESS);
        System.out.println(fetcher.getMyExternalIpAddress());
        AddressPort addressPort = new AddressPort();
        String result = addressPort.addressByIp(fetcher.getMyExternalIpAddress());
        JSONObject jsStr = JSONObject.parseObject(result);
        Unicode unicode = new Unicode();
        String province = unicode.decodeUnicode(jsStr.getString("province"));
        String city = unicode.decodeUnicode(jsStr.getString("city"));
        return city;
    }
    /*
    * 转到添加菜品页面
    */
    @RequestMapping("/toAddFoodsByStores")
    public String toAddFoodsByStores(Integer stid,HttpSession session, HttpServletRequest request) throws Exception {
        System.out.println("stid:====="+stid);
        request.setAttribute("stid",stid);
        return "front/stores/foodadd";
    }
    /*
     *店铺增加菜品
     */
    @RequestMapping("/addStoresFood")
    public String addStoresFood(MultipartFile items_pic,Integer a, Integer stid, Map<String,Object> map,
                                HttpSession session, HttpServletRequest request) throws Exception{
        if(a!=null){
            System.out.println("stid:====="+stid);
            request.setAttribute("stid",stid);
            //return "front/stores/storesadd";
        }else{
            String fname = request.getParameter("fname");
            Integer fprice = Integer.valueOf(request.getParameter("fprice"));
            Integer stidToAddFood = Integer.valueOf(request.getParameter("stid"));
            Food food = new Food();
            String originalFilename = items_pic.getOriginalFilename();
            if(items_pic!=null && originalFilename!=null && originalFilename.length()>0){
                String pic_path = "E:\\CourseDesign\\picture\\";
                String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
                File newFile = new File(pic_path+newFileName);
                items_pic.transferTo(newFile);
                food.setFpic(newFileName);
            }
            food.setStid(stid);
            food.setFname(fname);
            food.setFprice(fprice);
            food.setStid(stidToAddFood);
            System.out.println("food==="+food);
            foodService.addFood(food);
            System.out.println("foodId==========="+food.getFid());
            Food food1 = foodService.findFoodById(food.getFid());
            JSONObject json = (JSONObject) JSONObject.toJSON(food1);
            String foodString=json.toString();
            jedis.set("foodid"+food1.getFid(),foodString);
            System.out.println("food1+============"+food1);
            map.put("close", "close");//将 close 置入request 域，前台判断 request 域有 close 时候就关闭弹出层
        }
        return "front/stores/foodadd";
    }
    /*
    * 转到商家修改菜品页面
    */
    @RequestMapping("/toEditFoodsByStores")
    public String toEditFoodsByStores(Integer fid,HttpServletRequest request) throws Exception {
        System.out.println("fid======"+fid);
        Food editFoodByStid = foodService.findFoodById(fid);
        request.setAttribute("editFoodByStid",editFoodByStid);
        System.out.println("editFoodByStid:====="+editFoodByStid);
        return "front/stores/foodedit";
    }
    /*
     * 前端商家修改菜品
     */
    @RequestMapping("/frontEditFood")
    public String frontEditFood(Integer a,Integer fid,Map<String,Object> map,HttpSession session,
                                HttpServletRequest request,MultipartFile items_pic) throws Exception {
        if(a!=null){
            System.out.println("fid======"+fid);
            Food editFoodByStid = foodService.findFoodById(fid);
            request.setAttribute("editFoodByStid",editFoodByStid);
            System.out.println("editFoodByStid:====="+editFoodByStid);
            return "front/stores/foodedit";
        }else{
            String fname = request.getParameter("fname");
            Integer fprice = Integer.parseInt(request.getParameter("fprice"));
            //String fpic = request.getParameter("fpic");
            Integer fid1 = Integer.parseInt(request.getParameter("fid"));
            Integer stid = Integer.parseInt(request.getParameter("stid"));
            Integer fcollection = Integer.parseInt(request.getParameter("fcollection"));
            Integer fsalesvolume = Integer.parseInt(request.getParameter("fsalesvolume"));
            Integer fstatus = Integer.parseInt(request.getParameter("fstatus"));
            Food food = new Food();
            String originalFilename = items_pic.getOriginalFilename();
            if(items_pic!=null && originalFilename!=null && originalFilename.length()>0){
                String pic_path = "E:\\CourseDesign\\picture\\";
                String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
                File newFile = new File(pic_path+newFileName);
                items_pic.transferTo(newFile);
                food.setFpic(newFileName);
            }
            food.setStid(stid);
            food.setFname(fname);
            food.setFprice(fprice);
            food.setFid(fid1);
            food.setFcollection(fcollection);
            food.setFsalesvolume(fsalesvolume);
            food.setFstatus(fstatus);
            food.setFdelete(0);
            foodService.updateFood(fid1,food);
            JSONObject json = (JSONObject) JSONObject.toJSON(food);
            String foodString=json.toString();
            jedis.set("foodid"+fid1,foodString);
            map.put("close", "close");//将 close 置入request 域，前台判断 request 域有 close 时候就关闭弹出层
            System.out.println("editfood:===="+food);
        }
        return "front/stores/foodedit";
    }

    /*
     * 前端商家删除菜品
     */
    @RequestMapping("/frontDeleteFood")
    public String frontDeleteFood(Integer fid) throws Exception {
        foodService.deleteFoodByFid(fid);
        jedis.del("foodid"+fid);
        return "redirect:getStoresBySellId.html";
    }
    /*
     * 前端搜索菜品
     */
    @RequestMapping("/frontSearchFoodByName")
    public String frontSearchFood(String fname,HttpSession session,
                                  HttpServletRequest request) throws Exception {
        GetIp fetcher=new GetIp(IPADDRESS);
        AddressPort addressPort = new AddressPort();
        String result = addressPort.addressByIp(fetcher.getMyExternalIpAddress());
        JSONObject jsStr = JSONObject.parseObject(result);
        Unicode unicode = new Unicode();
        String city = unicode.decodeUnicode(jsStr.getString("city"));
        System.out.println("city:"+city);
        List<Stores> storesList = storesService.getStoresByAddress(city);
        List<Food> foodListByNameAndStid = new ArrayList<Food>();
        for(Stores stores : storesList){
            Food food = new Food();
            food.setStid(stores.getStid());
            food.setFname(fname);
            List<Food> listFood = foodService.findFoodListByNameAndStid(food);
            for (Food food1:listFood){
                foodListByNameAndStid.add(food1);
            }
        }
       request.setAttribute("foodslistFrontSearch",foodListByNameAndStid);
        return "front/food/searchfood";
    }
    /*
     * 前端展示所有菜品
     * 已经弃用
     */
    @RequestMapping("/frontFindAllFood")
    public String frontFindAllFood(String fname,HttpSession session,HttpServletRequest request) throws Exception {
        GetIp fetcher=new GetIp(IPADDRESS);
        AddressPort addressPort = new AddressPort();
        String result = addressPort.addressByIp(fetcher.getMyExternalIpAddress());
        JSONObject jsStr = JSONObject.parseObject(result);
        Unicode unicode = new Unicode();
        String city = unicode.decodeUnicode(jsStr.getString("city"));
        System.out.println("city:"+city);
        List<Stores> storesList = storesService.getStoresByAddress(city);
        List<Food> foodAllListByStid = new ArrayList<Food>();
        for(Stores stores : storesList){
            List<Food> listFood = foodService.findAllByStid(stores.getStid());
            for (Food food1:listFood){
                foodAllListByStid.add(food1);
            }
        }
        System.out.println("foodAllListByStid=============="+foodAllListByStid);
        request.setAttribute("foodAllListByStid",foodAllListByStid);
        return "front/food/foodlist";
    }

    /*
     * 前端展示所有菜品(分页)
     */
    @RequestMapping("/frontFindAllFoodFenye")
    public String frontFindAllFoodFenye(Map<String,Object> map ,HttpServletRequest request) throws Exception {
        GetIp fetcher=new GetIp(IPADDRESS);
        AddressPort addressPort = new AddressPort();
        String result = addressPort.addressByIp(fetcher.getMyExternalIpAddress());
        JSONObject jsStr = JSONObject.parseObject(result);
        Unicode unicode = new Unicode();
        String city = unicode.decodeUnicode(jsStr.getString("city"));
        System.out.println("city:"+city);
        String currentPage=request.getParameter("currentPage");
        int i = 0;
        Page page = new Page(city,foodService.findFoodByStoresCount(city), 6);
        if(currentPage == null){
            List<Food> foodslistFront = foodService.findFoodByStores(page);
            map.put("foodslistFront", foodslistFront);
            i=1;
        }else{
            i=Integer.parseInt(currentPage);
            page.setCurrentPage(i);
            List<Food> foodslistFront = foodService.findFoodByStores(page);
            map.put("foodslistFront", foodslistFront);
        }
        map.put("page", page);
        map.put("i", i); // 将键和值放在Map中
        return "front/food/foodlist";
    }
}
