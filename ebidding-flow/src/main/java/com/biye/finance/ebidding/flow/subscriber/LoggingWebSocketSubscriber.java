package com.biye.finance.ebidding.flow.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class LoggingWebSocketSubscriber {

    private Logger logger = LoggerFactory.getLogger(LoggingWebSocketSubscriber.class);

    public void debugSubscribe(Flux<String> publisher){
        publisher.subscribe(s ->{
            logger.debug(s);
        });
    }

}
