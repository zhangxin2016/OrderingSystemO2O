package com.zx.controller;

import com.alibaba.fastjson.JSONObject;
import com.zx.model.Food;
import com.zx.model.Stores;
import com.zx.service.FoodService;
import com.zx.service.StoresService;
import com.zx.util.AddressPort;
import com.zx.util.GetIp;
import com.zx.util.Unicode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    //全部店铺类别展示
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

    @RequestMapping("/getFoodById")
    public String getFoodById(HttpServletRequest request,Integer fid) throws Exception{
        Food food = foodService.findFoodById(fid);
        request.setAttribute("food", food);
        return "/front/food/detailFood";
    }
}
