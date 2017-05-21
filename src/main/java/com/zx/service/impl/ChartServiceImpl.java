package com.zx.service.impl;

import com.zx.chart.DetailChartSal;
import com.zx.chart.FoodChart;
import com.zx.mapper.DetailorderMapper;
import com.zx.mapper.FoodMapper;
import com.zx.mapper.UserBuyMapper;
import com.zx.model.OrderChart;
import com.zx.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Xin on 2017/5/21.
 */
@Service
public class ChartServiceImpl implements ChartService {
    @Autowired
    private DetailorderMapper detailorderMapper;
    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private UserBuyMapper userBuyMapper;
    @Override
    public List<OrderChart> findchartByDate() {
        return detailorderMapper.chartByDate();
    }

    @Override
    public List<FoodChart> findFoodChart() {
        return foodMapper.chartByFood();
    }

    @Override
    public List<DetailChartSal> findDetailOrderChartSal() {
        return detailorderMapper.DetailOrderChart();
    }

    @Override
    public List<OrderChart> findUserChartByDate() {
        return userBuyMapper.chartUserByDate();
    }
}
