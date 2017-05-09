package com.zx.controller;

import com.alibaba.fastjson.JSONObject;
import com.zx.model.Food;
import com.zx.model.Stores;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Xin on 2017/3/27.
 */
@Controller
public class FoodController {

    @Autowired
    private FoodService foodService;
    @Autowired
    private StoresService storesService;

    private String IPADDRESS = "http://ip.chemdrug.com/";
    //全部食品展示
    //分页功能
    @RequestMapping("/getAllFoodFront")
    public ModelAndView getAllFood(@RequestParam(value="currentPage",defaultValue="1") Integer currentPage,
                                         @RequestParam(value="lineSize",defaultValue="5") Integer lineSize ,
                                         @RequestParam(value="keyWord",defaultValue="") String keyWord, HttpServletRequest request)
    {
        ModelAndView mv=new ModelAndView("front/food/");
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
     *根据ID获取食物
     */
    @RequestMapping("/getFoodById")
    public String getFoodById(HttpServletRequest request,Integer fid) throws Exception{
        Food food = foodService.findFoodById(fid);
        request.setAttribute("food", food);
        return "/front/food/detailFood";
    }
    /*
     *店铺增加菜品
     */
    @RequestMapping("/addStoresFood")
    public String addStoresFood(Integer a,Integer stid, Map<String,Object> map, HttpSession session, HttpServletRequest request) throws Exception{
        if(a!=null){
            System.out.println("stid:====="+stid);
            request.setAttribute("stid",stid);
            //return "front/stores/storesadd";
        }else{
            String fname = request.getParameter("fname");
            Integer fprice = Integer.valueOf(request.getParameter("fprice"));
            String fpic = request.getParameter("fpic");
            Integer stidToAddFood = Integer.valueOf(request.getParameter("stid"));
            Food food = new Food();
            food.setStid(stid);
            food.setFname(fname);
            food.setFprice(fprice);
            food.setFpic(fpic);
            food.setStid(stidToAddFood);
            System.out.println("food==="+food);
            foodService.addFood(food);
            map.put("close", "close");//将 close 置入request 域，前台判断 request 域有 close 时候就关闭弹出层
        }
        return "front/stores/foodadd";
    }
    /*
     * 前端商家修改菜品
     */
    @RequestMapping("/frontEditFood")
    public String frontEditFood(Integer a,Integer fid,Map<String,Object> map,HttpSession session, HttpServletRequest request) throws Exception {
        if(a!=null){
            System.out.println("fid======"+fid);
            Food editFoodByStid = foodService.findFoodById(fid);
            request.setAttribute("editFoodByStid",editFoodByStid);
            System.out.println("editFoodByStid:====="+editFoodByStid);
        }else{
            String fname = request.getParameter("fname");
            Integer fprice = Integer.parseInt(request.getParameter("fprice"));
            String fpic = request.getParameter("fpic");
            Integer fid1 = Integer.parseInt(request.getParameter("fid"));
            Integer stid = Integer.parseInt(request.getParameter("stid"));
            Integer fcollection = Integer.parseInt(request.getParameter("fcollection"));
            Integer fsalesvolume = Integer.parseInt(request.getParameter("fsalesvolume"));
            Integer fstatus = Integer.parseInt(request.getParameter("fstatus"));
            Food food = new Food();
            food.setStid(stid);
            food.setFname(fname);
            food.setFprice(fprice);
            food.setFpic(fpic);
            food.setFid(fid1);
            food.setFcollection(fcollection);
            food.setFsalesvolume(fsalesvolume);
            food.setFstatus(fstatus);
            food.setFdelete(0);
            foodService.updateFood(fid1,food);
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
        return "redirect:getStoresBySellId.html";
    }
}
