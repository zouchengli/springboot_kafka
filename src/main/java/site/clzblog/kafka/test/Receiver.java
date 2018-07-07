package site.clzblog.kafka.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @Desc
 * @Author chengli.zou
 * @CreateDate 7/8/18
 */
@Component
public class Receiver {
    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);

    @KafkaListener(topics = "${app.topic.sensetime.name0}")
    public void receive1(@Payload String message, @Headers MessageHeaders headers) {
        LOG.info("================================================================");
        LOG.info("received message='{}'", message);
        headers.keySet().forEach(key -> LOG.info("{}: {}", key, headers.get(key)));
    }

    //@KafkaListeners({@KafkaListener(topics = "${app.topic.sensetime.name1}"), @KafkaListener(topics = "${app.topic.sensetime.name2}")})
    public void receives(@Payload String message) {
        LOG.info("================================================================");
        LOG.info("received message='{}'", message);
    }

}
