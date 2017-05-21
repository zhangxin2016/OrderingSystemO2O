package com.zx.controller;

import com.alibaba.fastjson.JSON;
import com.zx.chart.DetailChartSal;
import com.zx.chart.FoodChart;
import com.zx.model.OrderChart;
import com.zx.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Xin on 2017/5/21.
 */
@Controller
public class ChartController {
    @Autowired
    private ChartService chartService;
    @RequestMapping("findDetailChartByDate")
    public String findDetailChartByDate(HttpServletRequest request,HttpServletResponse response) throws Exception {

        return "back/chart/detailordercharts";
    }
    @RequestMapping("detailOrderChartByDate")
    public void detailOrderChartByDate(HttpServletRequest request,HttpServletResponse response) throws Exception{
        List<OrderChart> orderChartList = chartService.findchartByDate();
        String json = JSON.toJSONString(orderChartList);
        System.out.println("json========"+json);
        response.getWriter().print(json);
    }
    @RequestMapping("detailOrderChartSal")
    public void detailOrderChartSal(HttpServletRequest request,HttpServletResponse response) throws Exception{
        List<DetailChartSal> detailChartSalList = chartService.findDetailOrderChartSal();
        String jsonDetailChartSalList = JSON.toJSONString(detailChartSalList);
        response.setContentType("text/xml;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        System.out.println("jsonDetailChartSalList========"+jsonDetailChartSalList);
        response.getWriter().print(jsonDetailChartSalList);
    }

    @RequestMapping("toFindFoodChart")
    public String toFindFoodChart(HttpServletRequest request,HttpServletResponse response)throws Exception{
        return "back/chart/foodcharts";
    }
    @RequestMapping("findFoodChart")
    public void findFoodChart(HttpServletRequest request,HttpServletResponse response) throws Exception{

        List<FoodChart> foodChartList = chartService.findFoodChart();
        String jsonFoodChartList = JSON.toJSONString(foodChartList);
        response.setContentType("text/xml;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        System.out.println("jsonFoodChartList========"+jsonFoodChartList);
        response.getWriter().print(jsonFoodChartList);
    }

    @RequestMapping("userChartByDate")
    public void userChartByDate(HttpServletRequest request,HttpServletResponse response) throws Exception{
        List<OrderChart> userChartList = chartService.findUserChartByDate();
        String jsonUserChartList = JSON.toJSONString(userChartList);
        response.setContentType("text/xml;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        System.out.println("jsonUserChartList========"+jsonUserChartList);
        response.getWriter().print(jsonUserChartList);
    }
}
