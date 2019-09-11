package com.biye.finance.domain;

public class SimpleIdentifier implements Identifier {

    private String id;
    private String cusip;
    private String isin;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    @Override
    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    @Override
    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }
}
