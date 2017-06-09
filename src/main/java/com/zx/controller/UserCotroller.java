package com.zx.controller;

import com.alibaba.fastjson.JSONObject;
import com.youtu.Youtu;
import com.zx.model.Detailorder;
import com.zx.model.Food;
import com.zx.model.Stores;
import com.zx.service.DetailOrderService;
import com.zx.service.FoodService;
import com.zx.service.StoresService;
import com.zx.util.*;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserCotroller {
	@Autowired
	private FoodService foodService;
	@Autowired
	private StoresService storesService;
	@Autowired
	private DetailOrderService detailOrderService;
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
		//首页订单滚动显示
		List<Detailorder> detailorderListIndex = detailOrderService.finddetailOrderListFrontIndex();
		List<Detailorder> detailorderListFrontIndex = new ArrayList<Detailorder>();
		detailorderListFrontIndex = detailorderListIndex.subList(detailorderListIndex.size()-5, detailorderListIndex.size());
		modelMap.put("detailorderListFrontIndex",detailorderListFrontIndex);
		session.setAttribute("cityNow",city);
		if(session.getAttribute("allPictureMap")==null){
			youtu(session);
		}
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
	public static final String APP_ID = "10081183";
	public static final String SECRET_ID = "AKIDqZ6ScbCyNaqyueaZkjW7VhldqumTiF8v";
	public static final String SECRET_KEY = "mRtAF9qLfmgVEk4ECyYv65sTr45va5BA";
	Vector<Thread> threads = new Vector<Thread>();
	Map<String,List<String>> pictureListMap = new HashMap<String,List<String>>();
	public void youtu(HttpSession session){
		Youtu faceYoutu = new Youtu(APP_ID, SECRET_ID, SECRET_KEY,Youtu.API_YOUTU_END_POINT);
		File file = new File("E:\\CourseDesign\\picture\\");
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files.length == 0) {
				System.out.println("文件夹是空的!");
			} else {
				getPictureList(files,faceYoutu,session);
				for (Thread iThread : threads) {
					try {
						// 等待所有线程执行完毕
						iThread.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("主线执行。");
				System.out.println("pictureListMap======="+pictureListMap);
			}
		}
	}
	public  void getPictureList(File[] files, Youtu faceYoutu,HttpSession session){
		for (File file2 : files) {
			Thread iThread = new Thread(
					new Runnable() {
						@Override
						public void run() {
							org.json.JSONObject respose;
							if (file2.isDirectory()) {
								System.out.println("文件夹:" + file2.getAbsolutePath());
							} else {
								try {
									System.out.println("子线程" + Thread.currentThread() + "执行完毕");
									respose = faceYoutu.ImageTag(file2.getAbsolutePath());
									JSONArray respose1 = (JSONArray) respose.get("tags");
									List<String> listFileLocal = new ArrayList<String>();
									for (int i = 0;i<respose1.length();i++){
										org.json.JSONObject ob = (org.json.JSONObject) respose1.get(i);
										listFileLocal.add(ob.get("tag_name").toString());
									}
									String[] splitFile=file2.getAbsolutePath().split("\\\\");
									pictureListMap.put(splitFile[splitFile.length-1],listFileLocal);
									session.setAttribute("allPictureMap",pictureListMap);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					});
			threads.add(iThread);
			iThread.start();
		}
	}

}
