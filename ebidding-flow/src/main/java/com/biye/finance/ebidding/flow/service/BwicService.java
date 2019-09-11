package com.biye.finance.ebidding.flow.service;

import com.biye.finance.domain.Security;
import com.biye.finance.domain.trade.pre.BidWantedInCompetition;

import java.util.List;

public interface BwicService<T extends Security> {
    List<BidWantedInCompetition<T>> getLiveBwics();
}
