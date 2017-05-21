package com.zx.util;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;
import kafka.serializer.StringDecoder;
import kafka.utils.VerifiableProperties;
import lombok.extern.log4j.Log4j2;

import java.util.*;

/**
 * Created by Xin on 2017/5/21.
 * 测试消费者 是否指定partition
 * 高级消费者
 */
@Log4j2
public class KafkaConsumer {
    private final ConsumerConnector consumer;
    //private final String vcTestTopic ="kafkatopic";
    private final String vcTestTopic ="ordertopic";
    private KafkaConsumer() {
        Properties props = new Properties();
        props.put("zookeeper.connect", "120.76.114.25:2181");
        //group 代表一个消费组（核心配置）
        props.put("group.id", "zxTest");//代表哪一个消费者所在的组
        //zk连接超时
        props.put("zookeeper.session.timeout.ms", "4000");//连接zookeeper超时时间
        //ZooKeeper集群中leader（partrtion）和follower(相当于leader替补)之间的同步实际
        props.put("zookeeper.sync.time.ms", "200");
        //因为auto.commit.enable默认为true,
        //consumer会定时地将数据offset写入到zookeeper上
        //(时间间隔由auto.commit.interval.ms决定，默认1分钟)
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.commit.enable","true");
        //如果偏移超出范围，该怎么办。
        //最小：自动将偏移重置为最小偏移
        //最大：自动将偏移重置为最大偏移
        //任何其他：抛出异常到消费者
        /*smallest, 将offset设为当前所能用的最小的offset。 注意不一定是0。
        largest, 将offset设为当前可用的最大的offset。也就是consumer将只处理最新写入的消息。 默认值。
        其它， 校验失败，抛出kafka.common.InvalidConfigException异常。 看起来只能设置这两个值*/
        props.put("auto.offset.reset", "smallest"); //largest smallest
        //序列化类
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        ConsumerConfig config = new ConsumerConfig(props);
        consumer =   kafka.consumer.Consumer.createJavaConsumerConnector(config);
    }
    void consume() {
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(vcTestTopic, new Integer(1));//可以定义多个partition
        //encoding:String
        StringDecoder keyDecoder = new StringDecoder(new VerifiableProperties());
        StringDecoder valueDecoder = new StringDecoder(new VerifiableProperties());
        //创建一个消息处理的流，包含所有的topic，使用默认的Decoder，高级消费者常用
        //高层的API中比较常用的就是public List<KafkaStream<byte[], byte[]>> createMessageStreamsByFilter(TopicFilter topicFilter);
        //和public void commitOffsets();
        Map<String, List<KafkaStream<String, String>>> consumerMap =
                consumer.createMessageStreams(topicCountMap,keyDecoder,valueDecoder);
        KafkaStream<String, String> stream = consumerMap.get(vcTestTopic).get(0);
        ConsumerIterator<String, String> it = stream.iterator();
        while (it.hasNext()){
            MessageAndMetadata<String,String> m = it.next();
            //log.debug(m.message());
            System.out.println(m.message());
        }
    }
    public static void main(String[] args){
        new KafkaConsumer().consume();
    }

}
