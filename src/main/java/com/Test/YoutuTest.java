package com.Test;

import com.youtu.Youtu;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xin on 2017/6/1.
 */
public class YoutuTest {
    // appid, secretid secretkey请到http://open.youtu.qq.com/获取
    // 请正确填写把下面的APP_ID、SECRET_ID和SECRET_KEY
    public static final String APP_ID = "10081183";
    public static final String SECRET_ID = "AKIDqZ6ScbCyNaqyueaZkjW7VhldqumTiF8v";
    public static final String SECRET_KEY = "mRtAF9qLfmgVEk4ECyYv65sTr45va5BA";
    public static void main(String[] args) {

        try {
            Youtu faceYoutu = new Youtu(APP_ID, SECRET_ID, SECRET_KEY,Youtu.API_YOUTU_END_POINT);
            JSONObject respose;
            //respose= faceYoutu.FaceCompareUrl("http://open.youtu.qq.com/content/img/slide-1.jpg","http://open.youtu.qq.com/content/img/slide-1.jpg");
            //respose = faceYoutu.DetectFace("C:\\work\\zhangx\\work_data\\roboticleanring\\java_sdk\\test.jpg",1);
            respose = faceYoutu.ImageTag("E:\\CourseDesign\\picture\\c33a07d8-def8-427a-b78e-ffc17378046c.jpg");
            //respose = faceYoutu.FoodDetect("E:\\pic\\timg.jpg");
            //get respose
            JSONArray respose1 = (JSONArray) respose.get("tags");
            List<String> list = new ArrayList<String>();
            for (int i = 0;i<respose1.length();i++){
                JSONObject ob = (JSONObject) respose1.get(i);
                list.add(ob.get("tag_name").toString());
            }
            System.out.println(list);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
