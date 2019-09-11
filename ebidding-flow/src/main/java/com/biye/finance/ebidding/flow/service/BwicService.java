package com.biye.finance.ebidding.flow.service;

import com.biye.finance.domain.Security;
import com.biye.finance.domain.trade.pre.BidWantedInCompetition;
import reactor.core.publisher.Flux;


public interface BwicService<T extends Security> {
    Flux<BidWantedInCompetition<T>> getLiveBwics();
}
