package com.biye.finance.ebidding.flow.manager.impl;

import com.biye.finance.ebidding.flow.Identifiable;
import com.biye.finance.ebidding.flow.manager.WebSocketTopicManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.TopicProcessor;

import java.util.HashMap;
import java.util.Map;

@Component
public class SimpleWebSocketTopicManager implements WebSocketTopicManager {

    private Map<String, TopicProcessor<String>> idToPrivateTopic = new HashMap<>();
    private Map<String, Flux<String>> idToPrivateTopicPublisher = new HashMap<>();

    @Autowired
    @Qualifier("ws-topic-public")
    private Flux<String> publicTopic;

    @Override
    public Flux<String> getWebSocketPublisher(Identifiable identifiable) {
        return Flux.merge(publicTopic,getMyPrivateTopic(identifiable));
    }

    private synchronized Flux<String> getMyPrivateTopic(Identifiable identifiable){
        String id = identifiable.getId();
        Flux<String> topic = idToPrivateTopicPublisher.get(id);
        if(null == topic){
            TopicProcessor<String> processor = TopicProcessor.<String>builder().share(true).build();
            idToPrivateTopic.put(id,processor);

            topic = processor.publish().autoConnect();
            idToPrivateTopicPublisher.put(id, topic);
        }
        return topic;
    }
}
