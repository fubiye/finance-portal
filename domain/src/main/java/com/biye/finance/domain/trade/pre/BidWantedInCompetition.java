package com.biye.finance.domain.trade.pre;

import com.biye.finance.domain.Security;
import com.biye.finance.domain.trade.Transaction;

import java.util.Date;
import java.util.List;


/**
 * BWIC - Bid wanted in competition
 * @see https://www.investopedia.com/terms/b/bwic.asp
 *
 */
public interface BidWantedInCompetition<T extends Security> {
    String getBwicId();
    List<Transaction<T>> getTxns();
    Date getDueDate();
    Date getBidWinStart();
    Date getBidWinEnd();
}
