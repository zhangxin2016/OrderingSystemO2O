package com.zx.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.model.Storestype;
import com.zx.model.StorestypeExample;
import com.zx.service.StorestypeService;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by Xin on 2017/3/27.
 * 店铺类别管理
 */
@Controller
public class StorestypeController {
    @Autowired
    private StorestypeService storestypeService;

    //全部店铺类别展示
    //分页功能
    @RequestMapping("/getAllStorestype")
    public ModelAndView getAllStorestype(@RequestParam(value="currentPage",defaultValue="1") Integer currentPage,
                             @RequestParam(value="lineSize",defaultValue="5") Integer lineSize ,
                             @RequestParam(value="keyWord",defaultValue="") String keyWord, HttpServletRequest request)
    {
        ModelAndView mv=new ModelAndView("back/Storestype/storestypeList")  ;
        Map<String,Object> map=null;
        try{
            map=this.storestypeService.findAll(currentPage, lineSize, keyWord)   ;

            System.out.println("map.get(storestypes)"+map.get("storestypes"));
            mv.addObject("storestypes", map.get("storestypes"));
            /**
             * 下面的分页参数一定要传过去,不然没法使用分页插件
             */
            mv.addObject("pageInfo", map.get("pageInfo"));

            System.out.printf("map.get(pageInfo)"+map.get("pageInfo"));
            mv.addObject("lineSizes", new int[]{5,10,15,20,25,30});

            mv.addObject("keyWord", keyWord)  ;
        }catch(Exception e){
            //mv.setViewName("err");
            System.out.printf("店铺类别列表出现异常！");
        }
        return mv  ;
    }
    //添加店铺类别
    @RequestMapping("/insertStorestype")
    public String insert(Storestype storestype){
        storestypeService.insert(storestype);
        return "redirect:getAllStorestype.html";
    }
    //跳转到添加店铺类别页面
    @RequestMapping("/addStorestype")
    public String addStorestype(){
        return "/back/Storestype/addStorestype";
    }
    //删除店铺类别
    @RequestMapping("/deleteStorestype")
    public String deleteByPrimaryKey(Storestype storestype,HttpServletRequest request){
        System.out.println("Stypeid============"+storestype.getStypeid());
        storestypeService.deleteByPrimaryKey(storestype.getStypeid());
        return "redirect:getAllStorestype.html";
    }

    //根据ID获取需要修改的店铺类别
    @RequestMapping("/getStorestypeId")
    public String selectByPrimaryKey(Storestype storestype, ModelMap modelMap, HttpServletRequest request){
        Storestype storestype1 = storestypeService.selectByPrimaryKey(storestype.getStypeid());
        modelMap.put("storestype", storestype1);
        return "back/Storestype/updateStorestype";
    }
    //修改店铺类别
    @RequestMapping("/updateStorestype")
    public String updateStorestype(Storestype storestype){
        storestypeService.updateByPrimaryKey(storestype);
        System.out.println("storestype"+storestype);

        return "redirect:getAllStorestype.html";
    }

}
