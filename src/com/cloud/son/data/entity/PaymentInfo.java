package com.cloud.son.data.entity;

/**
 * Created by wengshinan on 15/6/28.
 */
public class PaymentInfo {

    private PayType type;
    private Currency currency;
    private int payAmount; //分
    private String serialno;

    public PayType getType() {
        return type;
    }

    public void setType(PayType type) {
        this.type = type;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public enum PayType {
        ALIPAY,
        WECHAT,
        OTHERS,
    }

    public enum Currency {
        RMB,
        DOLLERS,
        OTHERS,
    }
}
