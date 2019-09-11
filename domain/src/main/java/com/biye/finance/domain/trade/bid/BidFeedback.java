package com.biye.finance.domain.trade.bid;

public class BidFeedback {
    private Bid bid;
    private String feedback;
    private int rank;
    private int numOfBids;

    public Bid getBid() {
        return bid;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getNumOfBids() {
        return numOfBids;
    }

    public void setNumOfBids(int numOfBids) {
        this.numOfBids = numOfBids;
    }
}
