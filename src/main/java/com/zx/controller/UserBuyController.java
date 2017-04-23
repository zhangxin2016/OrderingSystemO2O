package com.zx.controller;

import com.zx.model.UserBuy;
import com.zx.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Xin on 2017/3/15.
 */

@Controller
public class UserBuyController {
    @Autowired
    private UserService userService;
    /**
     * @title :checkLogin
     * @description :对登录的用户名和密码进行验证
     * @throws IOException
     */
    @RequestMapping("/CheckLogin.html")
    public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //从前台获取json中的name和pass值
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        //将name和pass装入新的User实体，用于验证
        UserBuy user = new UserBuy();
        user.setUname(name);
        user.setUpassword(pass);
        //返回user
        UserBuy u = userService.getUserByNameAndPass(user);
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

    @RequestMapping("/Userlogin.html")
    public String userlogin(HttpSession session, UserBuy inuser) throws Exception{
        //根据用户输入的用户名和密码查找用户信息
        UserBuy user = userService.getUserByNameAndPass(inuser);
        //设置session，将user传入
        session.setAttribute("user", user);

        /*//根据用户id查到购物车
        List<Cart> cartList = cartService.getCartBuyUid(user.getUid());
        //根据商品id展示商品列表
        List<Item> itemList = new ArrayList<Item>();
        for (Cart cart2 : cartList) {
            Item i = cartService.getItemBySku(cart2.getSku());
            itemList.add(i);
        }
        //商品参数集合
        Map<Integer,List<ParamPojo>> map=new HashMap<Integer,List<ParamPojo>>();
        for (Item i : itemList) {
            Item item = cartService.getItemBySku(i.getSku());
            Itemparam byId = itemParamService.getById(item.getPid());
            List<ParamPojo> pojos1 = JsonUtils.jsonToList(byId.getParamValue(), ParamPojo.class);
            map.put(i.getSku(), pojos1);
        }

        session.setAttribute("cartNum", itemList.size());
        session.setAttribute("pojos", map);
        session.setAttribute("itemList", itemList);
        session.setAttribute("cList", cartList);
        */
        //return "redirect:Member_User.html";
        return "redirect:user/frontindex.html";
    }

    /**
     * @title :logout
     * @description :用户退出登录
     */
    @RequestMapping("/Logout.html")
    public String logout(HttpSession session){
        //清空session
        session.invalidate();
        return "redirect:user/testJson.html";
    }


    /**
     * @title :register
     * @description :注册页面验证完用户信息之后，保存到数据库
     */
    @RequestMapping("/Register.html")
    public String register(HttpServletRequest request,HttpSession session) throws Exception{
        String username = request.getParameter("uname");
        String password = request.getParameter("upassword");
        String registerTel = request.getParameter("uphone");
        Integer uage = Integer.parseInt(request.getParameter("uage"));
        System.out.println("age"+uage);
        String utruename = request.getParameter("utruename");
        String uidcard = request.getParameter("uidcard");
        String usex = request.getParameter("usex");
        String umail = request.getParameter("umail");
        UserBuy user = new UserBuy();
        user.setUname(username);
        user.setUpassword(password);
        user.setUphone(registerTel);
        user.setUage(uage);
        user.setUidcard(uidcard);
        user.setUtruename(utruename);
        user.setUsex(usex);
        user.setUmail(umail);
        userService.register(user);
        //将user放入session
        //session.setAttribute("user", user);
        return "redirect:user/userBuylogin.html";
    }

    /**
     * @title :checkRegister
     * @description :验证用户是否已经注册
     */
    @RequestMapping("/CheckRegister.html")
    public void checkRegister(HttpServletRequest request,HttpServletResponse response) throws IOException{
        //接收页面json用户输入的用户名
        String name = request.getParameter("name");
        //查找数据库中有没有该用户
        UserBuy user = userService.checkRegister(name);
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
     * @title :sendMessage
     * @description :向目标手机发送手机验证码
     */
    private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";

    @RequestMapping("/SendMessage.html")
    public void sendMessage( HttpServletRequest request, HttpServletResponse response){
        //接收手机验证码
        String phone = request.getParameter("phone");
        System.out.println(phone+"====phone");
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(Url);

        //client.getParams().setContentCharset("GBK");
        client.getParams().setContentCharset("UTF-8");
        method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=UTF-8");

        Integer mobile_code = (int)((Math.random()*9+1)*100000);
        String str = mobile_code.toString();
        //向前台传验证码验证用户输入是否正确
        JSONObject json = new JSONObject();

        json.put("phoneCode", str);

        String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");
        System.out.println(content);
        NameValuePair[] data = {//提交短信
                new NameValuePair("account", "C04592023"),
                new NameValuePair("password", "986c0ef208ceaa636146a26e352763d3"), //密码可以使用明文密码或使用32位MD5加密
                //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
                new NameValuePair("mobile", phone),
                new NameValuePair("content", content),
        };

        method.setRequestBody(data);

        try {
            client.executeMethod(method);

            String SubmitResult =method.getResponseBodyAsString();

            Document doc = DocumentHelper.parseText(SubmitResult);
            Element root = doc.getRootElement();


            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String smsid = root.elementText("smsid");


            System.out.println(code);
            System.out.println(msg);
            System.out.println(smsid);

            if("2".equals(code)){
                System.out.println("短信提交成功");
            }
            json.put("code", code);
            response.getWriter().print(json);
            response.getWriter().flush();
            response.getWriter().close();

        } catch (HttpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    @RequestMapping("/Login.html")
    public String login(){

        return "front/Login";
    }
}
