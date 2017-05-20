package com.zx.test;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;

/**
 * Created by Xin on 2017/5/19.
 */
public class Redis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("120.76.114.25",6379,30000);
        String string= "{\"codeDesc\":\"Success\",\"code\":0,\"requestId\":9301049,\"message\":\"\"}";
       // jedis.set("json","123");

        //jedis.del("json");
        String json = jedis.get("foodid3");
        //JSONObject jsonObject = JSONObject.parseObject(json);
        System.out.println(json);
    }


}
