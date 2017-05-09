package com.zx.controller;

import com.zx.model.Address;
import com.zx.model.UserBuy;
import com.zx.service.AddressService;
import com.zx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping("addressgetuid")
    public String getuid(HttpSession session, ModelMap modelMap){
        UserBuy user = (UserBuy) session.getAttribute("user");
        List<Address> listar = addressService.getuid(user.getUid());
        modelMap.put("listar",listar);
        return "Reception/address";
    }
}
