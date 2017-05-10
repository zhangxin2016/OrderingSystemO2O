package com.zx.controller;

import com.zx.model.Food;
import com.zx.model.Stores;
import com.zx.model.Storestype;
import com.zx.model.UserSell;
import com.zx.service.FoodService;
import com.zx.service.StoresService;
import com.zx.service.StorestypeService;
import com.zx.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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
    @RequestMapping("/getStoresBySellId")
    public String getStoresBySellId(Map<String,Object> map,HttpSession session, HttpServletRequest request) throws Exception {
        UserSell userSell = (UserSell) session.getAttribute("userSell");
        System.out.println("userSell:==="+userSell);
        Stores stores = storesService.getStoresByUsid(userSell.getUsid());
        request.setAttribute("inMyStores",stores);
        System.out.println("inMyStores===="+stores);
        String currentPage=request.getParameter("currentPage");
        int i = 0;
        if (stores!=null) {
            //根据店铺展示商品（分页）
            Page page = new Page(stores.getStid(),foodService.findFoodCountByStid(stores.getStid()), 4);
            if(currentPage == null){
                List<Food> foodList = foodService.findFoodByStid(page);
                map.put("foodList", foodList);
                i=1;
            }else{
                i=Integer.parseInt(currentPage);
                page.setCurrentPage(i);
                List<Food> foodList = foodService.findFoodByStid(page);
                map.put("foodList", foodList);
            }
            map.put("page", page);
            map.put("i", i); // 将键和值放在Map中
        }
        return "front/stores/mystores";
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
    public String addstores(MultipartFile items_pic,Integer a,Map<String,Object> map,HttpSession session, HttpServletRequest request) throws IOException {
        if(a!=null){
            List<Storestype> storestypeList = storestypeService.findAllStorestype();
            request.setAttribute("storestypeList",storestypeList);
            System.out.println("storestypeList:====="+storestypeList);
            //return "front/stores/storesadd";
        }else{
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
        }
        return "front/stores/storesadd";
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
    public String editstores(MultipartFile items_pic,Integer a,Integer stid,Map<String,Object> map,HttpSession session, HttpServletRequest request) throws IOException {
        if(a!=null){
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
        }else{
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
        }
        return "front/stores/storesedit";
    }
}
