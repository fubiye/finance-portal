package com.biye.finance.domain.trade;

import com.biye.finance.domain.Security;

public class SimpleTransaction<T extends Security> implements Transaction<T> {

    private String txnId;
    private T underlyingAsset;
    private int size;

    @Override
    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    @Override
    public T getUnderlyingAsset() {
        return underlyingAsset;
    }

    public void setUnderlyingAsset(T underlyingAsset) {
        this.underlyingAsset = underlyingAsset;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
