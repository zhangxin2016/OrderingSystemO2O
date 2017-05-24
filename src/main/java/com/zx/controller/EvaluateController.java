package com.zx.controller;

import com.alibaba.fastjson.JSONObject;
import com.zx.model.Detailorder;
import com.zx.model.Evaluate;
import com.zx.model.Order;
import com.zx.model.UserBuy;
import com.zx.service.DetailOrderService;
import com.zx.service.EvaluateService;
import com.zx.service.OrderService;
import com.zx.util.TextAntispamDetectionSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Xin on 2017/5/11.
 */
@Controller
public class EvaluateController {
    @Autowired
    private EvaluateService evaluateService;
    @Autowired
    private DetailOrderService detailOrderService;
    @Autowired
    private OrderService ordersService;
    /*
    * 转到买家添加评论页面
    */
    @RequestMapping("/toBuyAddEvaluate")
    public String toBuyAddEvaluate(Integer doid,HttpSession session,
                                   HttpServletRequest request) throws Exception {
        request.setAttribute("doid",doid);
        return "front/evaluate/leavemessage";
    }
    /*
     * 买家添加评论
     */
    @RequestMapping("/addBuyEvaluate")
    public String addBuyEvaluate(Map<String,Object> map, HttpSession session,
                                HttpServletRequest request) throws Exception{
        Integer doid = Integer.valueOf(request.getParameter("doid"));
        Detailorder detailorder = detailOrderService.findDetailOrderByDoid(doid);
        Detailorder detailorder1 = new Detailorder();
        detailorder1.setDoid(doid);
        detailorder1.setAdid(detailorder.getAdid());
        detailorder1.setDonum(detailorder.getDonum());
        detailorder1.setDopri(detailorder.getDopri());
        detailorder1.setDostatus(3);
        detailorder1.setFid(detailorder.getFid());
        detailorder1.setOid(detailorder.getOid());
        detailorder1.setDodate(detailorder.getDodate());
        detailorder1.setDodelete(detailorder.getDodelete());
        detailorder1.setDomessage(detailorder.getDomessage());
        detailOrderService.updateDetailOrder(detailorder1);
        String ebuycontent = request.getParameter("ebuycontent");
        Evaluate evaluate = new Evaluate();
        evaluate.setDoid(doid);
        evaluate.setEbuycontent(ebuycontent);
        evaluate.setEbuydate(new Date());
        evaluateService.addEvaluate(evaluate);
        map.put("close", "close");//将 close 置入request 域，前台判断 request 域有 close 时候就关闭弹出层
        return "front/evaluate/leavemessage";
    }
    @RequestMapping("/checkEvaluateContent.html")
    public void checkEvaluateContent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //从前台获取json中的name和pass值
        String ebuycontent = request.getParameter("ebuycontent");
        //定义返回数据
        int result = 0;
        //new一个json存放返回数据
        JSONObject json = new JSONObject();
        //判断u是否为空
        if(ebuycontent == ""){
            //没输入参数，返回错误0
            json.put("result", result);
            response.getWriter().print(json);
        }else if(ebuycontent != ""){
            TextAntispamDetectionSample textAntispamDetectionSample = new TextAntispamDetectionSample();
            boolean contentresult = textAntispamDetectionSample.checkContent(ebuycontent);
            if(contentresult == true){
                result = 2;
                json.put("result", result);
                response.getWriter().print(json);
            }else if (contentresult == false){
                result = 1;
                json.put("result", result);
                response.getWriter().print(json);
            }
        }
        response.getWriter().flush();
        response.getWriter().close();
    }

    /*
    * 转到商家回复评论页面
    */
    @RequestMapping("/toSellAddEvaluate")
    public String toSellAddEvaluate(Integer eid,HttpSession session,
                                   HttpServletRequest request) throws Exception {
        request.setAttribute("eid",eid);
        return "front/evaluate/replymessage";
    }
    /*
     * 商家回复评论
     */
    @RequestMapping("/addSellEvaluate")
    public String addSellEvaluate(Map<String,Object> map, HttpSession session,
                                 HttpServletRequest request) throws Exception{
        Integer eid = Integer.valueOf(request.getParameter("eid"));
        String esellcontent = request.getParameter("esellcontent");
        Evaluate evaluate = evaluateService.findEvaluateByEid(eid);
        Evaluate evaluate1 = new Evaluate();
        evaluate1.setEbuydate(evaluate.getEbuydate());
        evaluate1.setDoid(evaluate.getDoid());
        evaluate1.setEbuycontent(evaluate.getEbuycontent());
        evaluate1.setEdelete(0);
        evaluate1.setEid(eid);
        evaluate1.setEsellcontent(esellcontent);
        evaluate1.setEselldate(new Date());
        evaluateService.updateEvaluate(evaluate1);
        map.put("close", "close");//将 close 置入request 域，前台判断 request 域有 close 时候就关闭弹出层
        return "front/evaluate/replymessage";
    }
    @RequestMapping("/getAllEvaluateBack")
    public ModelAndView getAllEvaluateBack(@RequestParam(value="currentPage",defaultValue="1") Integer currentPage,
                                   @RequestParam(value="lineSize",defaultValue="5") Integer lineSize ,
                                   @RequestParam(value="keyWord",defaultValue="") String keyWord, HttpServletRequest request)
    {
        ModelAndView mv=new ModelAndView("back/evaluate/evaluateList");
        Map<String,Object> map=null;
        try{
            map=this.evaluateService.findAllEvaluateBack(currentPage, lineSize, keyWord);
            System.out.println("map.get(evaluateListBack)"+map.get("evaluateListBack"));
            mv.addObject("evaluateListBack", map.get("evaluateListBack"));
            /**
             * 下面的分页参数一定要传过去,不然没法使用分页插件
             */
            System.out.println("");
            mv.addObject("pageInfo", map.get("pageInfo"));
            mv.addObject("lineSizes", new int[]{5,10,15,20,25,30});
            mv.addObject("keyWord", keyWord)  ;
        }catch(Exception e){
            //mv.setViewName("err");
            System.out.printf("评论列表出现异常！");
        }
        return mv  ;
    }
    /*
        管理员删除评论
     */
    @RequestMapping("/deleteEvaluate")
    public String deleteEvaluate(Integer eid, HttpServletRequest request){
        Evaluate evaluate = new Evaluate();
        evaluate.setEid(eid);
        evaluate.setEdelete(1);
        evaluateService.deleteEvaluate(evaluate);
        return "redirect:getAllEvaluateBack.html";
    }
    /*
        用户查看我的评论
     */
    @RequestMapping("/userFindMyEvaluate")
    public String userFindMyEvaluate(Integer eid, HttpServletRequest request,HttpSession session) throws Exception {
        if (session.getAttribute("user")!=null) {
            UserBuy user = (UserBuy) session.getAttribute("user");
            List<Order> orderList = ordersService.orderByUser(user.getUid());
            List<Detailorder> detailorderListAll = new ArrayList<Detailorder>();
            List<Evaluate> evaluateList = new ArrayList<Evaluate>();
            for (Order order:orderList){
                List<Detailorder> detailorderList = detailOrderService.findDetailOrderList1(order.getOid());
                for(Detailorder detailorder:detailorderList){
                    detailorderListAll.add(detailorder);
                }
            }
            for(Detailorder detailorder:detailorderListAll){
                Evaluate evaluate = evaluateService.findEvaluateByDoid(detailorder.getDoid());
                if (evaluate!=null){
                    evaluateList.add(evaluate);
                }

            }
            request.setAttribute("myEvaluateList",evaluateList);
            return "front/user/userevaluatelist";
        }else{
            return "front/login";
        }
    }
}
