package com.zx.util;

/**
 * Created by zhangx on 2017/5/9.
 */
import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.green.model.v20161216.TextAntispamDetectionRequest;
import com.aliyuncs.green.model.v20161216.TextAntispamDetectionResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import java.util.*;
public class TextAntispamDetectionSample{
    public boolean checkContent(String content){
        boolean result = false;
    //public static void main(String[] args) throws Exception {
        //请替换成你自己的accessKeyId、accessKeySecret
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIQGRV98bCNGHi","RaycBvjdd0BoAhP9e5fO4x06qvxyCV");
        IAcsClient client = new DefaultAcsClient(profile);
        TextAntispamDetectionRequest textAntispamDetectionRequest = new TextAntispamDetectionRequest();
        //为防中文乱码，务必设置编码类型为utf-8
        textAntispamDetectionRequest.setEncoding("UTF-8");
        textAntispamDetectionRequest.setConnectTimeout(3000);
        textAntispamDetectionRequest.setReadTimeout(4000);
        //设置待检测文本
        List<Map<String, Object>> dataItems = new ArrayList<Map<String, Object>>();
        Map<String, Object> dataItem2 = new HashMap<String, Object>();
        dataItem2.put("dataId", UUID.        randomUUID().toString()); //数据id
        dataItem2.put("content", content); //要检测的文本内容
        dataItem2.put("postId", "1111");  //发贴人的id, 可选, postId与postTime需同时填或者不填
        dataItem2.put("postTime", new Date().getTime());//发帖时间, 可选, postId与postTime需同时填后者不填
        dataItems.add(dataItem2);
        textAntispamDetectionRequest.setDataItems(JSON.toJSONString(dataItems));
        /**
         * 设置自定义关键词的词库ID, 词库和关键词的定义前往绿网控制台定义和添加(https://yundun.console.aliyun.com/?p=cts#/greenWeb/config2),
         * 词库ID在添加词库时会自动生成,显示在控制台
         * 默认新增的词库自动在本接口生效, 如果想部分词库有用,请将以下参数指定改词库的ID
         */
        //textAntispamDetectionRequest.setCustomDicts(Arrays.asList("11001", "11002"));
        //textAntispamDetectionRequest.setCustomDicts(Arrays.asList("143007"));
        //超时设置

        textAntispamDetectionRequest.setConnectTimeout(4000);
        textAntispamDetectionRequest.setReadTimeout(4000);
        try {
            TextAntispamDetectionResponse textAntispamDetectionResponse = client.getAcsResponse(textAntispamDetectionRequest);
            result = textAntispamDetectionResponse.getTextAntispamResults().get(0).getIsSpam();
            //restulttextAntispamResults;
            System.out.println(result);
            if ("Success".equals(textAntispamDetectionResponse.getCode())) {
                List<TextAntispamDetectionResponse.TextAntispamResult> textAntispamResults = textAntispamDetectionResponse.getTextAntispamResults();
                for (TextAntispamDetectionResponse.TextAntispamResult textAntispamResult : textAntispamResults) {
                    if(textAntispamResult.getIsSpam() != null && textAntispamResult.getIsSpam()){
                        //命中的情况下做处理
                        //do something
                    }
                }
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
