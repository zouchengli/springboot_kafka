package site.clzblog.kafka.test;

import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Desc
 * @Author chengli.zou
 * @CreateDate 7/7/18
 */
public class kafkaProducerTest {
    private static Logger LOG = LoggerFactory.getLogger(kafkaProducerTest.class);

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "114.116.76.24:9092,122.112.248.30:9092,118.25.67.74:9092");
        props.put("retries", 3);
        props.put("linger.ms", 1);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
        for (int i = 0; i < 1; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<String, String>("tests", "11", "今天天气不错哟yoyo=======>" + i);
            producer.send(record, new Callback() {
                public void onCompletion(RecordMetadata metadata, Exception e) {
                    if (e != null)
                        System.out.println("the producer has a error:" + e.getMessage());
                    else {
                        System.out.println("The offset of the record we just sent is: " + metadata.offset());
                        System.out.println("The partition of the record we just sent is: " + metadata.partition());
                    }
                }
            });
            try {
                Thread.sleep(1000);
                // producer.close();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }
}
