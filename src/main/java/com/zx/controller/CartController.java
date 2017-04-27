package com.zx.controller;

import com.zx.model.Cart;
import com.zx.model.Food;
import com.zx.model.UserBuy;
import com.zx.service.CartService;
import com.zx.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 2017/4/23.
 */
@Controller
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private FoodService foodService;
    private String prid;
    List<Cart> cartListByLot = new ArrayList<Cart>();
    @RequestMapping("/addFoodCart")
    public void addCart(HttpServletResponse response, Cart cart, HttpServletRequest request, @RequestParam("foodId") int foodid, @RequestParam("outcarnum") int num, HttpSession session)throws Exception{
        List<Cart> cartList = new ArrayList<Cart>();
        List<Integer> listCartFid = new ArrayList<Integer>();
        cartList = cartService.findCartList(cart);
        System.out.println("num++++++++++"+num);
        UserBuy user = (UserBuy) session.getAttribute("user");
        Food foods = foodService.findFoodById(foodid);
        System.out.println("foods>>>>>>>>>>>"+foods);
        for(Cart cartAll:cartList){
            System.out.println(cartAll);
            cartAll.getFid();
            listCartFid.add(cartAll.getFid());
            System.out.println("----------------------"+cartAll.getFid());
        }
        Cart cartByFid = new Cart();
        if(listCartFid.contains(foods.getFid())==true){
            cartByFid = cartService.findCartByFid(foods.getFid());
            System.out.println("cart1===================="+cartByFid);
            //cartByFid.getNum();
            //cartByFid.getCtotal();
            //cartByFid.setNum(num);
            cartByFid.setNum(num+cartByFid.getNum());
            cartByFid.setCtotal(foods.getFprice()*num+cartByFid.getCtotal());
            cartService.updateCart(cartByFid);
            int count = cartService.findCountCart(user.getUid());
            response.getWriter().print(count);
        }if(listCartFid.contains(foods.getFid())==false) {
            cartByFid.setNum(num);
            cartByFid.setCtotal(foods.getFprice()*num);
            cartByFid.setFid(foods.getFid());
            cartByFid.setUid(user.getUid());
            cartService.addCart(cartByFid);
            int count = cartService.findCountCart(user.getUid());
            response.getWriter().print(count);
        }
    }
    @RequestMapping("/getUserAllCartList")
    public String getUserAllCart(HttpServletRequest request,Integer uid,HttpSession session) throws Exception{
        UserBuy user = (UserBuy) session.getAttribute("user");
        List<Cart> cartList = cartService.findCartListByUid(user.getUid());
        request.setAttribute("cartList", cartList);
        return "/front/food/cartList";
    }
    @RequestMapping("/cartAddCount")
    public void cartAddCount(HttpServletResponse response,@RequestParam("cartId") int cartId,@RequestParam("outcarnum") int num) throws Exception{
        Cart cart = cartService.findCartByCid(cartId);
        Food food = foodService.findFoodById(cart.getFid());
        Cart cart1 = new Cart();
        cart1.setCid(cartId);
        cart1.setNum(cart.getNum()+1);
        cart1.setCtotal(cart.getCtotal()+food.getFprice());
        cartService.updateCart(cart1);
        Cart cart2 = cartService.findCartByCid(cartId);
        Integer count = cart2.getCtotal();
        response.getWriter().print(count);
    }
    @RequestMapping("/cartLessCount")
    public void cartLessCount(HttpServletResponse response,@RequestParam("cartId") int cartId,@RequestParam("outcarnum") int num) throws Exception{
        Cart cart = cartService.findCartByCid(cartId);
        Food food = foodService.findFoodById(cart.getFid());
        Cart cart1 = new Cart();
        cart1.setCid(cartId);
        cart1.setNum(cart.getNum()-1);
        cart1.setCtotal(cart.getCtotal()-food.getFprice());
        cartService.updateCart(cart1);
        Cart cart2 = cartService.findCartByCid(cartId);
        Integer count = cart2.getCtotal();
        response.getWriter().print(count);
    }
    @RequestMapping("/cartcount")
    public void cartcount(HttpServletResponse response,@RequestParam("cartId") int cartId) throws Exception{
        Cart cart = cartService.findCartByCid(cartId);
        Integer count1 = cart.getCtotal();
        response.getWriter().print(count1);
    }
    @RequestMapping("/deleteCartLotSize")
    public String deleteCartLotSize(HttpSession session,HttpServletRequest request)throws Exception{
        cartListByLot.clear();
        String prid = request.getParameter("prid");
        System.out.println("=======================");
        String[] arry=prid.split(",");
        for (int i = 0; i < arry.length; i++) {
            String id=arry[i];
            Cart cart = cartService.findCartByCid(Integer.parseInt(id));
            cartListByLot.add(cart);
            System.out.println(id);
        }
        for(Cart cart:cartListByLot){
            System.out.println(cart);
            cartService.findCartList(cart);
        }
        UserBuy user = (UserBuy) session.getAttribute("user");
        request.setAttribute("cartListByLot", cartListByLot);
        System.out.println("============>>>>>>>>>>>>>"+request.getAttribute("cartListByLot"));
		/*request.removeAttribute("cartList");*/
        System.out.println("cartListByLot>>>>>>>>>>>>>"+cartListByLot);
        return "/front/food/cartOrder";
    }
}