package com.zx.controller;

import com.zx.model.Stores;
import com.zx.model.UserSell;
import com.zx.service.StoresService;
import com.zx.service.UserSellService;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Xin on 2017/4/11.
 */
@Controller
public class UserSellController {
    @Autowired
    private UserSellService userService;
    @Autowired
    private StoresService storesService;
    @RequestMapping("/userSellToLogin.html")
    public String login(){
        return "front/stores/storeslogin";
    }
    @RequestMapping("userSellToRegister.html")
    public String userBuyRegister(){
        return "front/stores/userSellRegister";
    }
    @RequestMapping("/userSellLogin.html")
    public String userlogin(HttpSession session, UserSell inuser,HttpServletRequest request) throws Exception{
        //根据用户输入的用户名和密码查找用户信息
        UserSell user = userService.getUserByNameAndPass(inuser);
        Stores stores = storesService.getStoresByUsid(user.getUsid());
        //设置session，将user传入
        session.setAttribute("userSell", user);
        request.setAttribute("stores",stores);
        return "redirect:getStoresBySellId.html";
    }
    /**
     * @title :checkUserSellLogin
     * @description :对登录的用户名和密码进行验证
     * @throws IOException
     */
    @RequestMapping("/checkUserSellLogin.html")
    public void checkUserSellLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //从前台获取json中的name和pass值
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        //将name和pass装入新的User实体，用于验证
        UserSell user = new UserSell();
        user.setUsname(name);
        user.setUspassword(pass);
        //返回user
        UserSell u = userService.getUserByNameAndPass(user);
        //定义返回数据
        int result = 0;
        //new一个json存放返回数据
        JSONObject json = new JSONObject();
        //判断u是否为空
        if(u == null){
            //用户名或密码错误，返回错误0
            json.put("result", result);
            response.getWriter().print(json);
        }else if(u != null){
            //用户名或密码正确，返回正确1
            result = 1;
            json.put("result", result);
            response.getWriter().print(json);
        }
        response.getWriter().flush();
        response.getWriter().close();
    }

    /**
     * @title :logout
     * @description :用户退出登录
     */
    @RequestMapping("/userSellLogout.html")
    public String logout(HttpSession session){
        //清空session
        session.invalidate();
        return "redirect:user/testJson.html";
    }

    /**
     * @title :checkUserSellRegister
     * @description :验证用户是否已经注册
     */
    @RequestMapping("/checkUserSellRegister.html")
    public void checkUserSellRegister(HttpServletRequest request,HttpServletResponse response) throws IOException{
        //接收页面json用户输入的用户名
        String name = request.getParameter("name");
        //查找数据库中有没有该用户
        UserSell user = userService.checkRegister(name);
        JSONObject json = new JSONObject();
        //有该用户返回json为0
        int result = 0;
        //没有该用户返回json为1
        if(user==null){
            result = 1;
        }
        //放入json
        json.put("result", result);
        //传到前台
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();
    }
    /**
     * @title :register
     * @description :注册页面验证完用户信息之后，保存到数据库
     */
    @RequestMapping("/userSellRegister.html")
    public String userSellRegister(HttpServletRequest request,HttpSession session) throws Exception{
        String username = request.getParameter("usname");
        String password = request.getParameter("uspassword");
        String registerTel = request.getParameter("usphone");
        String utruename = request.getParameter("ustruename");
        String uidcard = request.getParameter("usidcard");
        //String usaddress = request.getParameter("usaddress");
        String sheng = request.getParameter("sheng");
        String shi = request.getParameter("shi");
        String qu = request.getParameter("qu");
        String xiangxi = request.getParameter("xiangxi");
        String usaddress = sheng + shi + qu + xiangxi;
        UserSell user = new UserSell();
        user.setUsname(username);
        user.setUspassword(password);
        user.setUsphone(registerTel);
        user.setUsidcard(uidcard);
        user.setUstruename(utruename);
        user.setUsaddress(usaddress);
        userService.register(user);
        //将user放入session
        //session.setAttribute("user", user);
        return "redirect:userSellToLogin.html";
    }
    @RequestMapping("/getAllUserSellBack")
    public ModelAndView getAllUserSellBack(@RequestParam(value="currentPage",defaultValue="1") Integer currentPage,
                                   @RequestParam(value="lineSize",defaultValue="5") Integer lineSize ,
                                   @RequestParam(value="keyWord",defaultValue="") String keyWord, HttpServletRequest request)
    {
        ModelAndView mv=new ModelAndView("back/usersell/usersellList");
        Map<String,Object> map=null;
        try{
            map=this.userService.findAllUserSellBack(currentPage, lineSize, keyWord);
            System.out.println("map.get(userSellsList)"+map.get("userSellsList"));
            mv.addObject("userSellsList", map.get("userSellsList"));
            /**
             * 下面的分页参数一定要传过去,不然没法使用分页插件
             */
            mv.addObject("pageInfo", map.get("pageInfo"));
            System.out.printf("map.get(pageInfo)"+map.get("pageInfo"));
            mv.addObject("lineSizes", new int[]{5,10,15,20,25,30});
            mv.addObject("keyWord", keyWord)  ;
        }catch(Exception e){
            //mv.setViewName("err");
            System.out.printf("商家列表出现异常！");
        }
        return mv  ;
    }
    @RequestMapping("/getStoresByUserSell")
    public String getStoresByUserSell(Integer usid,HttpSession session, HttpServletRequest request) throws Exception {
        System.out.println("usid======"+usid);
        UserSell userSell = userService.findStoresByUserSell(usid);
        request.setAttribute("storesListByUserSell",userSell);
        return "back/usersell/findstoresByUs";
    }

    /*
    * 转到商家修改信息页面
    */
    @RequestMapping("/toEditUserSellInStores")
    public String toEditUserSellInStores(Integer usid,HttpServletRequest request) throws Exception {
        UserSell userSell = userService.findStoresByUserSell(usid);
        request.setAttribute("userSellEdit",userSell);
        return "front/stores/userselledit";
    }
    /*
     * 前端商家修改信息
     */
    @RequestMapping("/frontEditUserSellByStores")
    public String frontEditUserSellByStores(Map<String,Object> map,HttpSession session,
                                HttpServletRequest request) throws Exception {
        Integer usid = Integer.parseInt(request.getParameter("usid"));
        String usname = request.getParameter("usname");
        String ustruename = request.getParameter("ustruename");
        String uspassword = request.getParameter("uspassword");
        String usidcard = request.getParameter("usidcard");
        String usphone = request.getParameter("usphone");
        String usaddress = request.getParameter("usaddress");
        UserSell userSell = new UserSell();
        userSell.setUsaddress(usaddress);
        userSell.setUsdel(0);
        userSell.setUsid(usid);
        userSell.setUsidcard(usidcard);
        userSell.setUsname(usname);
        userSell.setUstruename(ustruename);
        userSell.setUsphone(usphone);
        userSell.setUspassword(uspassword);
        userService.updateUserSell(userSell);
        map.put("close", "close");
        return "front/stores/userselledit";
    }

}
