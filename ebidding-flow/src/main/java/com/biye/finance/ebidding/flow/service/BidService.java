package com.biye.finance.ebidding.flow.service;

import com.biye.finance.domain.trade.bid.Bid;

import java.util.List;

public interface BidService {
    List<? extends Bid> getLiveBids();
}
