package com.zx.service;

import com.zx.chart.DetailChartSal;
import com.zx.chart.FoodChart;
import com.zx.model.OrderChart;

import java.util.List;

/**
 * Created by Xin on 2017/5/21.
 */
public interface ChartService {
    List<OrderChart> findchartByDate();

    List<FoodChart> findFoodChart();

    List<DetailChartSal> findDetailOrderChartSal();

    List<OrderChart> findUserChartByDate();
}
