package com.zx.util;



import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.util.StringUtils;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangx on 2017/4/14.
 */
public class AddressPort {
    public String addressByIp(String  ipaddress) throws Exception {
        //新浪接口
        String  path="http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip="+ipaddress;
        URL url = new URL( path);
        URLConnection conn = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK"));
        String line = null;
        StringBuffer result = new StringBuffer();
        while((line = reader.readLine()) != null)
        {
            result.append(line);
        }
        reader.close();
        String res  = String.valueOf(result);
        return res;
    }
    public static void main(String[] args) {
        String  path="http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=111.198.232.219";


    }

}
