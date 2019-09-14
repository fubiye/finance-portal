package com.biye.finance.ebidding.flow.conf;

import com.biye.finance.ebidding.flow.subscriber.LoggingWebSocketSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.TopicProcessor;

import javax.annotation.PostConstruct;

@Configuration
public class WebSocketTopicsConfiguration{

    @Autowired
    private LoggingWebSocketSubscriber subscriber;

    @Bean
    @Qualifier("ws-topic-broadcaster")
    public TopicProcessor<String> broadcaster(){
        return TopicProcessor.<String>builder().share(true).build();
    }

    @Bean
    @Qualifier("ws-topic-public")
    public Flux<String> publicTopic(){
        return broadcaster().publish().autoConnect();
    }

    @PostConstruct
    public void init(){
        subscriber.debugSubscribe(publicTopic());
    }
}
