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
public class DemoApplication7 {

    static final String topicExchangeName = "spring-boot-exchange-demo-7";

    static final String esbTopicExchangeName = "esb-spring-boot-exchange-demo-7";

    static final String queueName = "spring-boot-demo-7";

    static final String esbQueueName = "esb-spring-boot-demo-7";

    @Bean
    Queue queue7() {
        return new Queue(queueName, false);
    }

    @Bean
    Queue esbQueue7() {
        return new Queue(esbQueueName, false);
    }

    @Bean
    TopicExchange exchange7() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    TopicExchange esbExchange7() {
        return new TopicExchange(esbTopicExchangeName);
    }

    @Bean
    Binding binding7(Queue queue7, TopicExchange exchange7) {
        return BindingBuilder.bind(queue7).to(exchange7).with("foo.bar.#");
    }

    @Bean
    Binding esbBinding7(Queue esbQueue7, TopicExchange esbExchange7) {
        return BindingBuilder.bind(esbQueue7).to(esbExchange7).with("esb.bar.#");
    }

    @Bean
    SimpleMessageListenerContainer container7(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter7) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter7);
        return container;
    }

    @Bean
    SimpleMessageListenerContainer esbContainer7(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter esbListenerAdapter7) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(esbQueueName);
        container.setMessageListener(esbListenerAdapter7);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter7(DemoReceiver demoReceiver) {
        return new MessageListenerAdapter(demoReceiver, "receiveMessage");
    }

    @Bean
    MessageListenerAdapter esbListenerAdapter7(EsbDemoReceiver demoReceiver) {
        return new MessageListenerAdapter(demoReceiver, "receiveMessage");
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DemoApplication7.class, args);
    }
}
