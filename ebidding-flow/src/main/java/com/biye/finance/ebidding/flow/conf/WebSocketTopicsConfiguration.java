package com.biye.finance.ebidding.flow.conf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.TopicProcessor;

@Configuration
public class WebSocketTopicsConfiguration {

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

}
