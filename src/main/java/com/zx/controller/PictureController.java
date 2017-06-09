package com.zx.controller;

import com.youtu.Youtu;
import com.zx.model.Food;
import com.zx.service.FoodService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by Xin on 2017/6/1.
 */
@Controller
public class PictureController {
    @Autowired
    private FoodService foodService;
    public static final String APP_ID = "10081183";
    public static final String SECRET_ID = "AKIDqZ6ScbCyNaqyueaZkjW7VhldqumTiF8v";
    public static final String SECRET_KEY = "mRtAF9qLfmgVEk4ECyYv65sTr45va5BA";
    Vector<Thread> threads = new Vector<Thread>();
    @RequestMapping("searchForByPic")
    public String searchForByPic(MultipartFile items_pic, HttpSession session, HttpServletRequest request) throws Exception {
        String originalFilename = items_pic.getOriginalFilename();
        Youtu faceYoutu = new Youtu(APP_ID, SECRET_ID, SECRET_KEY,Youtu.API_YOUTU_END_POINT);
        List<String> listFileUpload = new ArrayList<String>();
        List<String> pictureList = new ArrayList<String>();
        List<Food> foodList = new ArrayList<Food>();
        if(items_pic!=null && originalFilename!=null && originalFilename.length()>0){
            String pic_path = "E:\\CourseDesign\\pictureSearch\\";
            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            File newFile = new File(pic_path+newFileName);
            items_pic.transferTo(newFile);
            try {
                JSONObject respose;
                respose = faceYoutu.ImageTag(pic_path+newFileName);
                JSONArray respose1 = (JSONArray) respose.get("tags");
                for (int i = 0;i<respose1.length();i++){
                    JSONObject ob = (JSONObject) respose1.get(i);
                    listFileUpload.add(ob.get("tag_name").toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(session.getAttribute("allPictureMap")==null){
            System.out.println("重新查找图片方法查询图片");
            File file = new File("E:\\CourseDesign\\picture\\");
            if (file.exists()) {
                File[] files = file.listFiles();
                if (files.length == 0) {
                    System.out.println("文件夹是空的!");
                } else {
                    getPictureList(files,listFileUpload,faceYoutu,pictureList);
                    for (Thread iThread : threads) {
                        try {
                            // 等待所有线程执行完毕
                            iThread.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("主线执行。");
                }
            }
        }else{
            System.out.println("session方法查询图片");
            Map<String,List<String>> pictureListMap = (Map<String, List<String>>) session.getAttribute("allPictureMap");
            for (Map.Entry<String,List<String>> entry : pictureListMap.entrySet()) {
                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
                List<String> result = getSameList(listFileUpload,entry.getValue());
                if (result.size()>1){
                    pictureList.add(entry.getKey());
                }
            }
        }
        System.out.println("pictureList==="+pictureList);
        for(String fpic:pictureList){
            List<Food> foodList1 = foodService.findFoodByFpic(fpic);
            for (Food food:foodList1){
                foodList.add(food);
            }
        }
        System.out.println("foodList==="+foodList);
        request.setAttribute("foodListByFpic",foodList);
        return "front/food/searchfoodByFpic";
    }
    /*
     *   遍历所有图片
     */
    public  List<String> getPictureList(File[] files,List<String> listFileUpload,Youtu faceYoutu,List<String> pictureList){
        for (File file2 : files) {
            Thread iThread = new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            JSONObject respose;
                            if (file2.isDirectory()) {
                                System.out.println("文件夹:" + file2.getAbsolutePath());
                            } else {
                                //System.out.println("文件:" + file2.getAbsolutePath());
                                try {
                                    System.out.println("子线程" + Thread.currentThread() + "执行完毕");
                                    respose = faceYoutu.ImageTag(file2.getAbsolutePath());
                                    JSONArray respose1 = (JSONArray) respose.get("tags");
                                    List<String> listFileLocal = new ArrayList<String>();
                                    for (int i = 0;i<respose1.length();i++){
                                        JSONObject ob = (JSONObject) respose1.get(i);
                                        listFileLocal.add(ob.get("tag_name").toString());
                                    }
                                    List<String> result = getSameList(listFileUpload,listFileLocal);
                                    //Boolean a = (listFileUpload.size() == listFileLocal.size()) && listFileUpload.containsAll(listFileLocal);
                                    //System.out.println("result===="+result);
                                    System.out.println(file2+"result====="+result);
                                    if (result.size()>1){
                                        String[] splitFile=file2.getAbsolutePath().split("\\\\");
                                        //System.out.println("文件名字："+splitFile[splitFile.length-1]);
                                        pictureList.add(splitFile[splitFile.length-1]);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
            threads.add(iThread);
            iThread.start();
        }
        System.out.println("pictureList==="+pictureList);
        return pictureList;
    }


    /*
     *   获取list相同元素
     */
    private  List<String> getSameList(List<String> list1, List<String> list2) {
        List<String> diff = new ArrayList<String>();
        List<String> maxList = list1;
        List<String> minList = list2;
        if(list2.size()>list1.size()||list2.size()==list1.size())
        {
            maxList = list2;
            minList = list1;
        }
        Map<String,Integer> map = new HashMap<String,Integer>(maxList.size());
        for (String string : maxList) {
            map.put(string, 1);
        }
        for (String string : minList) {
            if(map.get(string)!=null)
            {
                map.put(string, 2);
                continue;
            }
        }
        for(Map.Entry<String, Integer> entry:map.entrySet())
        {
            if(entry.getValue()==2)
            {
                diff.add(entry.getKey());
            }
        }
        return diff;
    }
}
