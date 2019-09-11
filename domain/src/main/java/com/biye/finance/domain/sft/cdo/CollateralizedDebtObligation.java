package com.biye.finance.domain.sft.cdo;

import com.biye.finance.domain.Identifier;
import com.biye.finance.domain.Security;

public class CollateralizedDebtObligation implements Security {

    private Identifier identifier;

    @Override
    public Identifier getIdentifier() {
        return null;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }
}
