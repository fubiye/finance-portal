package com.biye.finance.domain.trade.bid;

public class BlindBidFeedback extends BidFeedback {
    private double coverPrice;

    public double getCoverPrice() {
        return coverPrice;
    }

    public void setCoverPrice(double coverPrice) {
        this.coverPrice = coverPrice;
    }
}
