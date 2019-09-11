package com.biye.finance.domain.trade.pre;

import com.biye.finance.domain.Security;
import com.biye.finance.domain.trade.Transaction;

import java.util.Date;
import java.util.List;

public class SimpleBwic<T extends Security> implements BidWantedInCompetition<T> {

    private String bwicId;
    private List<Transaction<T>> txns;
    private Date dueDate;
    private Date bidWinStart;
    private Date bidWinEnd;

    @Override
    public String getBwicId() {
        return bwicId;
    }

    public void setBwicId(String bwicId) {
        this.bwicId = bwicId;
    }

    @Override
    public List<Transaction<T>> getTxns() {
        return txns;
    }

    public void setTxns(List<Transaction<T>> txns) {
        this.txns = txns;
    }

    @Override
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public Date getBidWinStart() {
        return bidWinStart;
    }

    public void setBidWinStart(Date bidWinStart) {
        this.bidWinStart = bidWinStart;
    }

    @Override
    public Date getBidWinEnd() {
        return bidWinEnd;
    }

    public void setBidWinEnd(Date bidWinEnd) {
        this.bidWinEnd = bidWinEnd;
    }
}
