package com.zx.controller;

import com.zx.demo.demo1.GeetestConfig;
import com.zx.sdk.GeetestLib;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Xin on 2017/5/2.
 */
@Controller
public class StartCaptchaController extends HttpServlet {
    @RequestMapping("/StartCaptcha.html")
    public void StartCaptcha(HttpServletRequest request,
                 HttpServletResponse response) throws ServletException, IOException {
        GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key(),
                GeetestConfig.isnewfailback());
        String resStr = "{}";
        //自定义userid
        String userid = "test";
        //进行验证预处理
        int gtServerStatus = gtSdk.preProcess(userid);
        //将服务器状态设置到session中
        request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
        //将userid设置到session中
        request.getSession().setAttribute("userid", userid);
        resStr = gtSdk.getResponseStr();
        PrintWriter out = response.getWriter();
        out.println(resStr);
    }
}
