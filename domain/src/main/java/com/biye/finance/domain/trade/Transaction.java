package com.biye.finance.domain.trade;

import com.biye.finance.domain.Security;

public interface Transaction<T extends Security> {
    String getTxnId();
    T getUnderlyingAsset();
    int getSize();
}
