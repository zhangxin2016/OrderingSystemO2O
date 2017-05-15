package com.zx.controller;

import com.zx.model.Address;
import com.zx.model.UserBuy;
import com.zx.service.AddressService;
import com.zx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Xin on 2017/5/1.
 */
@Controller
public class AddressController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;
    @RequestMapping("addressByUid")
    public String addressByUid(HttpSession session, ModelMap modelMap){
        UserBuy user = (UserBuy) session.getAttribute("user");
        List<Address> listAddress = addressService.getuid(user.getUid());
        modelMap.put("listAddress",listAddress);
        return "front/user/useraddress";
    }
    /*
    * 转到用户添加地址
    */
    @RequestMapping("/toUserAddAddress")
    public String toUserAddAddress(HttpServletRequest request) throws Exception {
        return "front/user/useraddaddress";
    }
    /*
    * 用户添加地址
    */
    @RequestMapping("/userAddAddress")
    public String userAddAddress(HttpSession session,HttpServletRequest request) throws Exception {
        UserBuy user = (UserBuy) session.getAttribute("user");
        String sheng = request.getParameter("sheng");
        String shi = request.getParameter("shi");
        String qu = request.getParameter("qu");
        String xiangxi = request.getParameter("xiangxi");
        String adcon = sheng +" "+ shi +" "+ qu +" "+ xiangxi;
        String adname = request.getParameter("adname");
        String adtel = request.getParameter("adtel");
        Address address = new Address();
        address.setAdcon(adcon);
        address.setAdname(adname);
        address.setAdtel(adtel);
        address.setUid(user.getUid());
        addressService.add(address);
        request.setAttribute("close","close");
        return "front/user/useraddaddress";
    }

    @RequestMapping("/userDeleteAddress")
    public String userDeleteAddress(HttpSession session,HttpServletRequest request,Integer adid) throws Exception {
        Address address = new Address();
        address.setAddelete(1);
        address.setAdid(adid);
        addressService.delete(address);
        return "redirect:addressByUid.html";
    }

    /*
    * 转到用户添加地址
    */
    @RequestMapping("/toUserUpdateAddress")
    public String toUserUpdateAddress(HttpServletRequest request,Integer adid) throws Exception {
        Address address=addressService.getadid(adid);
        String[] storesAddress = address.getAdcon().split(" ");
        request.setAttribute("sheng",storesAddress[0]);
        request.setAttribute("shi",storesAddress[1]);
        request.setAttribute("qu",storesAddress[2]);
        request.setAttribute("xiangxi",storesAddress[3]);
        request.setAttribute("userUpdateAddress",address);
        return "front/user/userupdateaddress";
    }
    @RequestMapping("/userUpdateAddress")
    public String userUpdateAddress(HttpSession session,HttpServletRequest request,Integer adid) throws Exception {
        Address address = new Address();
        address.setAddelete(0);
        address.setAdid(adid);
        String sheng = request.getParameter("sheng");
        String shi = request.getParameter("shi");
        String qu = request.getParameter("qu");
        String xiangxi = request.getParameter("xiangxi");
        String adcon = sheng +" "+ shi +" "+ qu +" "+ xiangxi;
        String adname = request.getParameter("adname");
        String adtel = request.getParameter("adtel");
        address.setAdtel(adtel);
        address.setAdname(adname);
        address.setAdcon(adcon);
        addressService.update(address);
        request.setAttribute("close","close");
        return "front/user/userupdateaddress";
    }
}
