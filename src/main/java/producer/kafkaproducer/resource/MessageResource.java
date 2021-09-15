package producer.kafkaproducer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import producer.kafkaproducer.model.Message;

@RestController
@RequestMapping("kafka")
public class MessageResource {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @PostMapping("/send")
    public boolean enviarMensagem (@RequestBody Message message){
        try{
            kafkaTemplate.send("exemplo", message.getMessage());
            System.out.println(message.getMessage());
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
