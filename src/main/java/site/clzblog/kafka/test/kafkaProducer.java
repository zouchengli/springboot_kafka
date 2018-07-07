/*
package site.clzblog.kafka.test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;

*/
/**
 * @Desc
 * @Author chengli.zou
 * @CreateDate 7/7/18
 *//*

public class kafkaProducer extends Thread {
    private String topic;

    public kafkaProducer(String topic) {
        super();
        this.topic = topic;
    }


    @Override
    public void run() {
        Producer producer = createProducer();
        int i = 0;
        while (true) {
            producer.send(new KeyedMessage<Integer, String>(topic, "message: " + i++));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Producer createProducer() {
        Properties properties = new Properties();
        properties.put("zookeeper.connect", "114.116.76.24:2181,122.112.248.30:2181,118.25.67.74:2181");//声明zk
        properties.put("serializer.class", StringEncoder.class.getName());
        properties.put("metadata.broker.list", "114.116.76.24:9092,122.112.248.30:9092,118.25.67.74:9092");// 声明kafka broker
        return new Producer<Integer, String>(new ProducerConfig(properties));
    }


    public static void main(String[] args) {
        new kafkaProducer("test").start();// 使用kafka集群中创建好的主题 test

    }
}
*/
