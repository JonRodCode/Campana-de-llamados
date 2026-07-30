package messaging;

import model.Campaign;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RabbitCampaignEventPublisher implements CampaignEventPublisher {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${campaign.messaging.exchange}")
    private String exchangeName;

    @Value("${campaign.messaging.routing-key}")
    private String routingKey;

    @Override
    public void publishCampaignStatusChanged(Campaign campaign) {
        CampaignStatusChangedEvent event = new CampaignStatusChangedEvent(
                campaign.getId(),
                campaign.getStatus().getCode(),
                LocalDateTime.now()
        );
        rabbitTemplate.convertAndSend(exchangeName, routingKey, event);
    }
}
