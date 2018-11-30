package com.example.springbootemo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lvixn
 * @date 2018/11/29 18:00
 */
//用来配置队列、交换器、路由等高级信息
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue HelloQueue(){
        return new Queue("hello");
    }

    @Bean Queue neoQueue(){
        return  new Queue("neo");
    }

    @Bean Queue objectQueue(){
        return  new Queue("object");
    }
/*
    配置topic
    topic 是RabbitMQ中最灵活的一种方式，可以根据routing_key自由的绑定不同的队列
*/
    final static String message="topic.message";
    final static String messages="topic.messages";

    @Bean
    public Queue queueMessage(){
        return new Queue(RabbitMQConfig.message);
    }

    @Bean
    public Queue queueMessages(){
        return new Queue(RabbitMQConfig.messages);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange("exchange");
    }

    //匹配队列topic.message
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage,TopicExchange topicExchange){
        return BindingBuilder.bind(queueMessage).to(topicExchange).with("topic.message");
    }

    //同时匹配两个队列
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages,TopicExchange topicExchange){
        return BindingBuilder.bind(queueMessages).to(topicExchange).with("topic.#");
    }

    /*
    Fanout 相关配置
    Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息。
     */
    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }

}
