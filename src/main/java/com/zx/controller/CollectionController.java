package com.zx.controller;

import com.zx.model.Collectionuser;
import com.zx.model.Food;
import com.zx.model.Stores;
import com.zx.model.UserBuy;
import com.zx.service.CollectionService;
import com.zx.service.FoodService;
import com.zx.service.StoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Xin on 2017/5/14.
 */
@Controller
public class CollectionController {
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private FoodService foodService;
    @Autowired
    private StoresService storesService;
    @RequestMapping("/addCollectionFood")
    public void addCollectionFood(HttpServletRequest request, HttpSession session,HttpServletResponse response,
                                  @RequestParam("foodId") int foodid) throws Exception {
        UserBuy userBuy = (UserBuy) session.getAttribute("user");
        //Integer fid = Integer.parseInt(request.getParameter("fid"));
        Food food1 = foodService.findFoodById(foodid);
        Food food = new Food();
        food.setFcollection(food1.getFcollection()+1);
        food.setFid(foodid);
        foodService.updateFood(foodid,food);
        System.out.println("food+======="+food);
        Collectionuser collection = new Collectionuser();
        collection.setUid(userBuy.getUid());
        collection.setFid(foodid);
        collection.setColldate(new Date());
        System.out.println("collection========="+collection);
        List<Collectionuser> collectionuserList = collectionService.findCollectionListByUid(userBuy.getUid());
        System.out.println("uid"+userBuy.getUid());
        System.out.println("collectionuserList"+collectionuserList);
        int result = 0;
        for(Collectionuser collectionuser:collectionuserList){
            System.out.println("Fid========"+collectionuser.getFid());
            System.out.println("foodid========"+foodid);
            if (collectionuser.getFid() == foodid) {
                result = 1;
            }
        }
        if(result == 1){
            response.getWriter().print(result);
        }else{
            collectionService.addCollection(collection);
            response.getWriter().print(result);
        }
    }
    @RequestMapping("/findCollectionListByUid")
    public String findCollectionListByUid(HttpServletRequest request, HttpSession session){
        UserBuy userBuy = (UserBuy) session.getAttribute("user");
        List<Collectionuser> collectionList = collectionService.findCollectionListByUid(userBuy.getUid());
        request.setAttribute("collectionList",collectionList);
        return "front/user/usercollectionfood";
    }
    @RequestMapping("/deleteCollectionFood")
    public void deleteCollectionFood(Integer collid,HttpServletRequest request, HttpSession session){
        Collectionuser collection = new Collectionuser();
        collection.setColldelete(1);
        collection.setCollid(collid);
        collectionService.deleteCollectionFood(collection);
    }

    @RequestMapping("/addCollectionStores")
    public void addCollectionStores(HttpServletRequest request, HttpSession session,HttpServletResponse response,
                                  @RequestParam("storesid") int storesid) throws Exception {
        UserBuy userBuy = (UserBuy) session.getAttribute("user");
        //Integer fid = Integer.parseInt(request.getParameter("fid"));
        Stores stores = storesService.getStoresByStid(storesid);
        Stores stores1 = new Stores();
        stores1.setStid(storesid);
        stores1.setUscoll(stores.getUscoll()+1);
        storesService.updateStorseByStid(stores1);
        Collectionuser collection = new Collectionuser();
        collection.setUid(userBuy.getUid());
        collection.setStid(storesid);
        collection.setColldate(new Date());
        System.out.println("collection========="+collection);
        List<Collectionuser> collectionuserList = collectionService.findCollectionStoresListByUid(userBuy.getUid());
        System.out.println("uid"+userBuy.getUid());
        System.out.println("collectionuserList"+collectionuserList);
        int result = 0;
        for(Collectionuser collectionuser:collectionuserList){
            if(collectionuser.getStid()==storesid){
                result = 1;
            }
        }
        if(result == 0){
            collectionService.addCollection(collection);
            response.getWriter().print(result);
        }else{
            response.getWriter().print(result);
        }
    }
}
