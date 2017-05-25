package com.zx.controller;

import com.alibaba.fastjson.JSONObject;
import com.zx.model.Food;
import com.zx.model.Stores;
import com.zx.service.FoodService;
import com.zx.service.StoresService;
import com.zx.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserCotroller {
	@Autowired
	private FoodService foodService;
	@Autowired
	private StoresService storesService;
	private String IPADDRESS = "http://ip.chemdrug.com/";
	@RequestMapping("/back.html")
	public String test(){
		System.out.println(">>>>>>>>>>>>>test.html");
		return "back/login";
	 }
	
	//@ResponseBody
	@RequestMapping("frontindex.html")
	public String frontindex(ModelMap modelMap, HttpSession session) throws Exception {
		GetIp fetcher=new GetIp(IPADDRESS);
		System.out.println(fetcher.getMyExternalIpAddress());
		AddressPort addressPort = new AddressPort();
		String result = addressPort.addressByIp(fetcher.getMyExternalIpAddress());
		JSONObject jsStr = JSONObject.parseObject(result);
		Unicode unicode = new Unicode();
		String province = unicode.decodeUnicode(jsStr.getString("province"));
		String city = unicode.decodeUnicode(jsStr.getString("city"));
		System.out.println("city:"+city);
		List<Stores> storesList = storesService.getStoresByAddress(city);
		List<Integer> stidList = new ArrayList<Integer>();
		List<Food> foodsListByStid = new ArrayList<Food>();
		List<Food> foodsList = new ArrayList<Food>();
		List<Food> foodsListBySalesvolume = new ArrayList<Food>();
		List<Food> foodsListByCollection = new ArrayList<Food>();
		for(int k = 0; k< storesList.size(); k++) {
			//System.out.println("stores:"+storesList.get(k));
			stidList.add(storesList.get(k).getStid());
		}
		//遍历店铺ID
		for(int i = 0; i < stidList.size(); i++) {
			foodsList = foodService.findAllByStid(stidList.get(i));
			for(int j = 0;j<foodsList.size();j++){
				foodsListByStid.add(foodsList.get(j));
			}
		}
		//System.out.println("根据fcollection排序：");
		Collections.sort(foodsListByStid, new sortList<Food>("Fcollection",false));
		if (foodsListByStid.isEmpty() || foodsListByStid == null) {
			System.out.println("没有数据");
		}
		readList(foodsListByStid,foodsListByCollection);
		//System.out.println("根据fsalesvolume排序：");
		Collections.sort(foodsListByStid, new sortList<Food>("Fsalesvolume",false));
		readList(foodsListByStid,foodsListBySalesvolume);
		//首页店铺收藏前三位
		List<Stores> storesListindex = storesService.findStoresByAddressOrderByUcollDesc(city);
		List<Stores> storesListIndex = new ArrayList<Stores>();
		int t = 0;
		for (Stores stores:storesListindex){
			if (t<3){
				storesListIndex.add(stores);
			}
			t++;
		}
		modelMap.put("storesListIndex",storesListIndex);
		modelMap.put("foodsListByStid", foodsListByStid);
		modelMap.put("foodsListBySalesvolume", foodsListBySalesvolume);
		modelMap.put("foodsListByCollection", foodsListByCollection);
		session.setAttribute("cityNow",city);
		return "front/index";
	}
	@RequestMapping("userBuylogin.html")
	public String userBuyLogin(){
		return "front/login";
	}
	@RequestMapping("userBuyRegister.html")
	public String userBuyRegister(){
		return "front/register";
	}

	private void readList(List<Food> foodsListByStid,List<Food> foodsListSort){
		int t = 0;
		for (Food food : foodsListByStid) {
			if (t<3) {
				//System.out.println(food);
				foodsListSort.add(food);
			}
			t++;
		}
	}
}
