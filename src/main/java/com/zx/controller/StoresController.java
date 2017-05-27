package com.zx.controller;

import com.alibaba.fastjson.JSONObject;
import com.zx.model.*;
import com.zx.service.*;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Xin on 2017/3/27.
 */
@Controller
public class StoresController {
    @Autowired
    private StoresService storesService;
    @Autowired
    private StorestypeService storestypeService;
    @Autowired
    private FoodService foodService;
    @Autowired
    private DetailOrderService detailOrderService;
    @Autowired
    private EvaluateService evaluateService;
    @Autowired
    private UserSellService userSellService;
    private String IPADDRESS = "http://ip.chemdrug.com/";
    @RequestMapping("/getStoresBySellId")
    public String getStoresBySellId(Map<String,Object> map,HttpSession session, HttpServletRequest request) throws Exception {
        if (session.getAttribute("userSell")!=null) {
            List<Food> foodList = new ArrayList<Food>();
            List<Evaluate> evaluatesListByDoid = new ArrayList<Evaluate>();
            UserSell userSell = (UserSell) session.getAttribute("userSell");
            //System.out.println("userSell:==="+userSell);
            Stores stores = storesService.getStoresByUsid(userSell.getUsid());
            request.setAttribute("inMyStores", stores);
            //System.out.println("inMyStores===="+stores);
            String currentPage = request.getParameter("currentPage");
            int i = 0;
            if (stores != null) {
                //根据店铺展示商品（分页）
                Page page = new Page(stores.getStid(), foodService.findFoodCountByStid(stores.getStid()), 4);
                if (currentPage == null) {
                    foodList = foodService.findFoodByStid(page);
                    map.put("foodList", foodList);
                    i = 1;
                } else {
                    i = Integer.parseInt(currentPage);
                    page.setCurrentPage(i);
                    foodList = foodService.findFoodByStid(page);
                    map.put("foodList", foodList);
                }
                map.put("page", page);
                map.put("i", i); // 将键和值放在Map中

                //评论
                for (Food food : foodList) {
                    List<Detailorder> detailorderList = detailOrderService.findDetailListByFid(food.getFid());
                    for (Detailorder detailorder : detailorderList) {
                        Evaluate evaluate = evaluateService.findEvaluateByDoid(detailorder.getDoid());
                        if (evaluate != null) {
                            evaluatesListByDoid.add(evaluate);
                        }
                    }
                }
                request.setAttribute("evaluatesListByDoid", evaluatesListByDoid);
                //System.out.println("evaluatesListByDoid============="+evaluatesListByDoid);
                //订单状态（商家发货）
                List<Detailorder> detailorderList1 = new ArrayList<Detailorder>();
                List<Food> foodsListByDetailOrder = new ArrayList<Food>();
                foodsListByDetailOrder = foodService.findAllByStid(stores.getStid());
                for (Food food : foodsListByDetailOrder) {
                    List<Detailorder> detailorderListByFid = detailOrderService.findDetailListByFid(food.getFid());
                    if (detailorderListByFid != null) {
                        for (Detailorder detailorder : detailorderListByFid) {
                            detailorderList1.add(detailorder);
                        }
                    }
                }
                System.out.println("foodsListByDetailOrder=====" + foodList);
                System.out.println("detailorderList====" + detailorderList1);
                request.setAttribute("detailorderList", detailorderList1);
            }

            //商家信息
            UserSell userSell1 = userSellService.findStoresByUserSell(userSell.getUsid());
            request.setAttribute("userSellInformation",userSell1);
            return "front/stores/mystores";
        }else{
            return "front/stores/storeslogin";
        }
    }
    @RequestMapping("/toAddStores")
    public String toAddStores(HttpSession session, HttpServletRequest request) throws Exception {
        List<Storestype> storestypeList = storestypeService.findAllStorestype();
        request.setAttribute("storestypeList",storestypeList);
        System.out.println("storestypeList:====="+storestypeList);
        return "front/stores/storesadd";
    }
    /**
     * @Description  TODO
     * 前台进行添加店铺操作的时候跳转的处理方法，显示添加店铺弹窗页面
     */
    @RequestMapping("/addstores")
    public String addstores(MultipartFile items_pic,Map<String,Object> map,HttpSession session, HttpServletRequest request) throws IOException {
        if (session.getAttribute("userSell")!=null){
            UserSell userSell = (UserSell) session.getAttribute("userSell");
            List<Storestype> storestypeList = storestypeService.findAllStorestype();
            request.setAttribute("storestypeList",storestypeList);
            Stores stores = new Stores();
            String originalFilename = items_pic.getOriginalFilename();
            if(items_pic!=null && originalFilename!=null && originalFilename.length()>0){
                String pic_path = "E:\\CourseDesign\\picture\\";
                String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
                File newFile = new File(pic_path+newFileName);
                items_pic.transferTo(newFile);
                stores.setStdesc(newFileName);
            }
            String sheng = request.getParameter("sheng");
            String shi = request.getParameter("shi");
            String qu = request.getParameter("qu");
            String xiangxi = request.getParameter("xiangxi");
            String staddress = sheng +" "+ shi +" "+ qu +" "+ xiangxi;
            String stname = request.getParameter("stname");
            Integer stypeid = Integer.parseInt(request.getParameter("stypeid"));
            stores.setStaddress(staddress);
            stores.setStname(stname);
            stores.setStypeid(stypeid);
            stores.setUsid(userSell.getUsid());
            storesService.addStores(stores);
            map.put("close", "close");//将 close 置入request 域，前台判断 request 域有 close 时候就关闭弹出层
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>order-send:submit");
            //return "redirect:getStoresBySellId.html";
            return "front/stores/storesadd";
        }else{
            map.put("close", "close");
            return "front/stores/storeslogin";
        }
    }
    @RequestMapping("/toEditStores")
    public String toEditStores(Integer stid,HttpSession session, HttpServletRequest request) throws Exception {
        System.out.println("stid======"+stid);
        Stores stores=storesService.getStoresByStid(stid);
        String[] storesAddress = stores.getStaddress().split(" ");
        request.setAttribute("sheng",storesAddress[0]);
        request.setAttribute("shi",storesAddress[1]);
        request.setAttribute("qu",storesAddress[2]);
        request.setAttribute("xiangxi",storesAddress[3]);
        request.setAttribute("editstores",stores);
        List<Storestype> storestypeEditList = storestypeService.findAllStorestype();
        request.setAttribute("storestypeEditList",storestypeEditList);
        System.out.println("editstores:====="+stores);
        return "front/stores/storesedit";
    }
    @RequestMapping("/editstores")
    public String editstores(MultipartFile items_pic,Integer stid,Map<String,Object> map,HttpSession session, HttpServletRequest request) throws IOException {
        if(session.getAttribute("userSell")!=null){
            UserSell userSell = (UserSell) session.getAttribute("userSell");
            String sheng = request.getParameter("sheng");
            String shi = request.getParameter("shi");
            String qu = request.getParameter("qu");
            String xiangxi = request.getParameter("xiangxi");
            String staddress = sheng +" "+ shi +" "+ qu +" "+ xiangxi;
            String stname = request.getParameter("stname");
            Integer stypeid = Integer.parseInt(request.getParameter("stypeid"));
            Stores stores = new Stores();
            String originalFilename = items_pic.getOriginalFilename();
            if(items_pic!=null && originalFilename!=null && originalFilename.length()>0){
                String pic_path = "E:\\CourseDesign\\picture\\";
                String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
                File newFile = new File(pic_path+newFileName);
                items_pic.transferTo(newFile);
                stores.setStdesc(newFileName);
            }
            stores.setStdelete(0);
            stores.setUscoll("0");
            stores.setStid(Integer.parseInt(request.getParameter("stid")));
            stores.setStaddress(staddress);
            stores.setStname(stname);
            stores.setStypeid(stypeid);
            stores.setUsid(userSell.getUsid());
            System.out.println("stores===="+stores);
            storesService.updateStorseByStid(stores);
            map.put("close", "close");//将 close 置入request 域，前台判断 request 域有 close 时候就关闭弹出层
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>edit:submit");
            //return "redirect:getStoresBySellId.html";
            return "front/stores/storesedit";
        }else {
            map.put("close", "close");
            return "front/stores/storeslogin";
        }
    }
    /*
     * 前端搜索店铺
     */
    @RequestMapping("/frontSearchStoresByName")
    public String frontSearchFood(String fname,HttpSession session,
                                  HttpServletRequest request) throws Exception {
        String city = getCity();
        List<Stores> storesList = storesService.getStoresByAddress(city);
        List<Stores> storesListByNameAndStid = new ArrayList<Stores>();
        for(Stores stores : storesList){
            Stores stores1 = new Stores();
            stores1.setStid(stores.getStid());
            //fname:前台搜索框name为fname.
            stores1.setStname(fname);
            System.out.println("stores1:======="+stores1);
            List<Stores> listStores = storesService.findStoresListByNameAndStid(stores1);
            System.out.println("listStores:======="+listStores);
            for (Stores stores2:listStores){
                storesListByNameAndStid.add(stores2);
            }
        }
        //热门商家
        List<Stores> storesList1 = storesService.findStoresByAddressOrderByUcollDesc(city);
        List<Stores> storesListTwo = new ArrayList<Stores>();
        int t = 0;
        for (Stores stores:storesList1){
            if (t<2){
                storesListTwo.add(stores);
            }
            t++;
        }
        request.setAttribute("storesListTwo",storesListTwo);
        System.out.println("storesListByNameAndStid======"+storesListByNameAndStid);
        request.setAttribute("storesListByNameAndStid",storesListByNameAndStid);
        return "front/food/searchstores";
    }
    //根据食物ID 进入店铺
    @RequestMapping("/userBuyToStores")
    public String userBuyToStores(Map<String,Object> map,HttpSession session, HttpServletRequest request,Integer fid,Integer stid) throws Exception {
        String city = getCity();
        Food food = foodService.findFoodById(fid);
        Stores stores = new Stores();
        if(food!=null){
            stores = storesService.getStoresByStid(food.getStid());
        }else{
            stores = storesService.getStoresByStid(stid);
        }
        System.out.println("stores:==="+stores);
        request.setAttribute("userSellStores",stores);
        List<Food> foodList = new ArrayList<Food>();
        String currentPage=request.getParameter("currentPage");
        int i = 0;
        if (stores!=null) {
            //根据店铺展示商品（分页）
            Page page = new Page(stores.getStid(),foodService.findFoodCountByStid(stores.getStid()), 4);
            if(currentPage == null){
                foodList = foodService.findFoodByStid(page);
                map.put("foodListByUserBuyToStores", foodList);
                i=1;
            }else{
                i=Integer.parseInt(currentPage);
                page.setCurrentPage(i);
                foodList = foodService.findFoodByStid(page);
                map.put("foodListByUserBuyToStores", foodList);
            }
            map.put("page", page);
            map.put("i", i); // 将键和值放在Map中
        }
        //评论
        List<Evaluate> evaluatesListByDoid = new ArrayList<Evaluate>();
        for(Food food1 : foodList) {
            List<Detailorder> detailorderList = detailOrderService.findDetailListByFid(food1.getFid());
            for(Detailorder detailorder : detailorderList) {
                Evaluate evaluate = evaluateService.findEvaluateByDoid(detailorder.getDoid());
                if (evaluate!=null){
                    evaluatesListByDoid.add(evaluate);
                }
            }
        }
        //热门商家
        List<Stores> storesList1 = storesService.findStoresByAddressOrderByUcollDesc(city);
        List<Stores> storesListTwo = new ArrayList<Stores>();
        int t = 0;
        for (Stores stores1:storesList1){
            if (t<2){
                storesListTwo.add(stores1);
            }
            t++;
        }
        request.setAttribute("storesListTwo",storesListTwo);
        request.setAttribute("evaluatesListFromUser",evaluatesListByDoid);
        return "front/stores/userbuystores";
    }

    /*
     *  后端展示所有店铺
     */
    @RequestMapping("/getAllStores")
    public ModelAndView getAllStores(@RequestParam(value="currentPage",defaultValue="1") Integer currentPage,
                                         @RequestParam(value="lineSize",defaultValue="5") Integer lineSize ,
                                         @RequestParam(value="keyWord",defaultValue="") String keyWord, HttpServletRequest request)
    {
        ModelAndView mv=new ModelAndView("back/Stores/storesList");
        Map<String,Object> map=null;
        try{
            map=this.storesService.findAllStores(currentPage, lineSize, keyWord);
            System.out.println("map.get(stores)"+map.get("stores"));
            mv.addObject("stores", map.get("stores"));
            mv.addObject("pageInfo", map.get("pageInfo"));
            System.out.printf("map.get(pageInfo)"+map.get("pageInfo"));
            mv.addObject("lineSizes", new int[]{5,10,15,20,25,30});
            mv.addObject("keyWord", keyWord);
        }catch(Exception e){
            System.out.printf("店铺列表出现异常！");
        }
        return mv;
    }
    /*
     * 后端根据店铺ID获取信息
     */

    @RequestMapping("/getStoresByStid")
    public String getStoresByStid(Integer stid,HttpSession session, HttpServletRequest request) throws Exception {
        System.out.println("stid======"+stid);
        Stores stores = storesService.findStoresByStid(stid);
        request.setAttribute("findstores",stores);
        return "back/Stores/findstores";
    }
    /*
     * 商家注销店铺
     */
    @RequestMapping("/deleteStoresByUserSell")
    public String deleteStoresByUserSell(Integer stid,HttpSession session, HttpServletRequest request) throws Exception {
        System.out.println("stid======"+stid);
        Stores stores = new Stores();
        stores.setStid(stid);
        stores.setStdelete(1);
        storesService.deleteStoresByUserSell(stores);
        List<Food> foodList = foodService.findAllByStid(stid);
        for(Food food1 : foodList){
            foodService.deleteFoodByFid(food1.getFid());
        }
        return "redirect:getStoresBySellId.html";
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
}
