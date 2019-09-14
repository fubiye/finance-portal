package com.biye.finance.ebidding.flow.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.TopicProcessor;

@Component
public class WebSocketScheduler {
    private Logger logger = LoggerFactory.getLogger(WebSocketScheduler.class);
    private static final String PING = String.valueOf((char)0x01);

    @Autowired
    private TopicProcessor<String> broadcasterTopicProcessor;

    @Scheduled(cron = "*/5 * * * * *")
    public void keepConnection(){
        logger.info("Start broadcasting to keep connection...");
        broadcasterTopicProcessor.onNext(System.currentTimeMillis() + " - " + PING);
    }
}
