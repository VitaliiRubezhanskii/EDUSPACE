package com.vrubizha.eduspace.configuration.rabbitMQ;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
@Slf4j
public class RabbitMqListener {

    private final static Logger logger=LoggerFactory.getLogger(RabbitMqListener.class);

    @RabbitListener(queues = "FriendRequest")
    public void processQueue1(String message) {
        logger.info("Received from queue 1: " + message);
    }
}
