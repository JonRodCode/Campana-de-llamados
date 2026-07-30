package config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${campaign.messaging.exchange}")
    private String exchangeName;

    @Value("${campaign.messaging.queue}")
    private String queueName;

    @Value("${campaign.messaging.routing-key}")
    private String routingKey;

    @Bean
    public TopicExchange campaignExchange() {
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Queue campaignStatusChangedQueue() {
        return new Queue(queueName, true);
    }

    @Bean
    public Binding campaignStatusChangedBinding() {
        return BindingBuilder.bind(campaignStatusChangedQueue()).to(campaignExchange()).with(routingKey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new JacksonJsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter jsonMessageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter);
        return rabbitTemplate;
    }
}
