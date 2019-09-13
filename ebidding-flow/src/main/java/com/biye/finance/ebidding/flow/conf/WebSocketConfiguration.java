package com.biye.finance.ebidding.flow.conf;

import com.biye.finance.ebidding.flow.handler.SimpleWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebSocketConfiguration {

    @Bean
    public WebSocketHandler webSocketHandler(){
        return new SimpleWebSocketHandler();
    }

    @Bean
    public HandlerMapping webSocketMapping(){
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
        mapping.setUrlMap(getUrlMap());
        return mapping;
    }

    public Map<String, WebSocketHandler> getUrlMap(){
        Map<String, WebSocketHandler> urlMap = new HashMap<>();
        urlMap.put("/ws",webSocketHandler());
        return urlMap;
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter(){
        return new WebSocketHandlerAdapter();
    }
}
