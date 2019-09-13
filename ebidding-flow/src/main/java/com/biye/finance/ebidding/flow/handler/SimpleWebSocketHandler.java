package com.biye.finance.ebidding.flow.handler;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

public class SimpleWebSocketHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        return session.send(session.receive().
                map(msg -> session.textMessage("SERVER RECEIVED:" + msg.getPayloadAsText())));
    }
}
