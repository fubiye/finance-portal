package com.biye.finance.ebidding.flow.handler;

import com.biye.finance.ebidding.flow.Identifiable;
import com.biye.finance.ebidding.flow.manager.WebSocketTopicManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleWebSocketHandler implements WebSocketHandler {

    @Autowired
    private WebSocketTopicManager manager;

    private AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        User user = getUser(session);
        Mono<Void> output = session.send(manager.getWebSocketPublisher(user).map(txtMsg -> session.textMessage(txtMsg)));
        Mono<Void> input = handleReceive(user, session);
        return Mono.zip(output,input).then();
    }

    public Mono<Void> handleReceive(User user,WebSocketSession session){
        return session.receive().doOnNext(wsMessasge -> manager.publishTo(user,wsMessasge.getPayloadAsText())).then();
    }

    private List<String> ids = Arrays.asList("user1", "user2");
    private User getUser(WebSocketSession session){
        int id = atomicInteger.getAndIncrement();
        return id % 2 == 0 ? new User(ids.get(1)) : new User(ids.get(0));
    }

    class User implements Identifiable {
        private String id;

        User(String id){
            this.id = id;
        }

        @Override
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
