package producer.kafkaproducer.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import producer.kafkaproducer.service.KafkaService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kafka")
public class KafkaResource {

    private final KafkaService kafkaService;

    @GetMapping("/send")
    public void send(){
        kafkaService.send("Mensagem para envio.");
    }

}
