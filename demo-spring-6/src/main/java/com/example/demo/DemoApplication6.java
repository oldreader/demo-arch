package com.example.demo;

import com.example.demo.bus.EsbDemoReceiver;
import com.example.demo.receiver.DemoReceiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DemoApplication6 {

    static final String topicExchangeName = "spring-boot-exchange-demo-6";

    static final String esbTopicExchangeName = "esb-spring-boot-exchange-demo-6";

    static final String queueName = "spring-boot-demo-6";

    static final String esbQueueName = "esb-spring-boot-demo-6";

    @Bean
    Queue queue6() {
        return new Queue(queueName, false);
    }

    @Bean
    Queue esbQueue6() {
        return new Queue(esbQueueName, false);
    }

    @Bean
    TopicExchange exchange6() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    TopicExchange esbExchange6() {
        return new TopicExchange(esbTopicExchangeName);
    }

    @Bean
    Binding binding6(Queue queue6, TopicExchange exchange6) {
        return BindingBuilder.bind(queue6).to(exchange6).with("foo.bar.#");
    }

    @Bean
    Binding esbBinding6(Queue esbQueue6, TopicExchange esbExchange6) {
        return BindingBuilder.bind(esbQueue6).to(esbExchange6).with("esb.bar.#");
    }

    @Bean
    SimpleMessageListenerContainer container6(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter6) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter6);
        return container;
    }

    @Bean
    SimpleMessageListenerContainer esbContainer6(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter esbListenerAdapter6) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(esbQueueName);
        container.setMessageListener(esbListenerAdapter6);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter6(DemoReceiver demoReceiver) {
        return new MessageListenerAdapter(demoReceiver, "receiveMessage");
    }

    @Bean
    MessageListenerAdapter esbListenerAdapter6(EsbDemoReceiver demoReceiver) {
        return new MessageListenerAdapter(demoReceiver, "receiveMessage");
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DemoApplication6.class, args);
    }
}
