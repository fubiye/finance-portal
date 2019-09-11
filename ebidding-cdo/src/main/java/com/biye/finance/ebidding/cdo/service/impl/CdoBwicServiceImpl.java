package com.biye.finance.ebidding.cdo.service.impl;

import com.biye.finance.domain.Identifier;
import com.biye.finance.domain.SimpleIdentifier;
import com.biye.finance.domain.sft.cdo.CollateralizedDebtObligation;
import com.biye.finance.domain.trade.SimpleTransaction;
import com.biye.finance.domain.trade.Transaction;
import com.biye.finance.domain.trade.pre.BidWantedInCompetition;
import com.biye.finance.domain.trade.pre.SimpleBwic;
import com.biye.finance.ebidding.flow.service.BwicService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CdoBwicServiceImpl implements BwicService<CollateralizedDebtObligation> {
    @Override
    public Flux<BidWantedInCompetition<CollateralizedDebtObligation>> getLiveBwics() {
        return Flux.just(createBwic());
    }

    private BidWantedInCompetition<CollateralizedDebtObligation> createBwic(){
        SimpleBwic<CollateralizedDebtObligation> bwic = new SimpleBwic<CollateralizedDebtObligation>();
        bwic.setBwicId("001000");
        bwic.setDueDate(new Date());
        bwic.setBidWinStart(new Date());
        bwic.setBidWinEnd(new Date());
        List<Transaction<CollateralizedDebtObligation>> txns = new ArrayList<>();
        SimpleTransaction<CollateralizedDebtObligation> txn = new SimpleTransaction<>();
        txn.setSize(100000000);
        txn.setTxnId("102774221000");
        CollateralizedDebtObligation cdo = new CollateralizedDebtObligation();
        cdo.setIdentifier(generateIdentifier());
        txn.setUnderlyingAsset(cdo);
        txns.add(txn);
        bwic.setTxns(txns);
        return bwic;
    }


    private Identifier generateIdentifier(){
        SimpleIdentifier identifier = new SimpleIdentifier();
        identifier.setId("163072101");
        identifier.setCusip("163072101");
        return identifier;
    }
}
