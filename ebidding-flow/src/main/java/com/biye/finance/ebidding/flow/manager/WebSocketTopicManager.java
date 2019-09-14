package com.biye.finance.ebidding.flow.manager;

import com.biye.finance.ebidding.flow.Identifiable;
import reactor.core.publisher.Flux;

public interface WebSocketTopicManager {
    Flux<String> getWebSocketPublisher(Identifiable identifiable);
    void publishTo(Identifiable identifiable, String text);
}
