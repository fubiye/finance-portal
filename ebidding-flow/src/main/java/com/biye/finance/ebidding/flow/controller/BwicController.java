package com.biye.finance.ebidding.flow.controller;

import com.biye.finance.domain.Security;
import com.biye.finance.domain.trade.pre.BidWantedInCompetition;
import com.biye.finance.ebidding.flow.service.BwicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/bwic")
public class BwicController {

    @Autowired
    private BwicService<? extends Security> bwicService;

    @GetMapping("/live")
    Flux<? extends BidWantedInCompetition<?>> getLiveBwic(){
        return bwicService.getLiveBwics();
    }
}
