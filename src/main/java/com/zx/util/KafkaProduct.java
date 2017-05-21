package com.zx.util;

import com.alibaba.fastjson.JSON;
import kafka.producer.KeyedMessage;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import kafka.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.Serializable;
import java.util.Properties;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by Xin on 2017/5/21.
 */
@Log4j2
public class KafkaProduct implements Serializable {
    private Producer<String,String> producer;
    /*public static void main(String[] args) throws InterruptedException {
        //new KafkaProduct().produceMsg();
        Thread.sleep(10000);
    }*/
    public KafkaProduct(){
        Properties props = new Properties();
        props.put("metadata.broker.list", "120.76.114.25:9092");
        props.put("bootstrap.servers", "120.76.114.25:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        ProducerConfig config = new ProducerConfig(props);
        producer =  new KafkaProducer<String,String>(props);
    }


    public void produceMsg(String msg,String vcTestTopic){
        // 构建发送的消息
        //Student student = new Student(2,"zhangsan","1234567","22b5c0e1-844b-4d06-916b-b661855156b21483064975648","oxWE2syQ67lowi4JVlbU4fw6X7d8","o7pf_t0tnbEoDFZjJ764kyfsdR9E","46497107fa23","add",5);
        //String msg = JSON.toJSONString("大家好123");
        //String vcTestTopic ="kafkatopic";
        System.out.println("发送消息：" + msg);

        KeyedMessage<String,String> data = new KeyedMessage<>(vcTestTopic, msg, msg);
        ProducerRecord<String, String> producerRecord =
                new ProducerRecord<>(vcTestTopic, 0,msg, msg.toString());
        producer.send(producerRecord, (recordMetadata, e) -> {
            if (null != e) {
                log.warn("welfareToAna jsonObject:{}", msg, e);
            }
            log.debug("welfareToAna partition:{} offset:{} userInfo:{}",
                    recordMetadata.partition(), recordMetadata.offset(), msg);
        });
        if (producer != null) {
            producer.close();
        }
    }
}
