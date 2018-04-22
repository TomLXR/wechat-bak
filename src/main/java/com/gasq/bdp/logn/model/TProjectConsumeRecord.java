package com.gasq.bdp.logn.model;

import java.math.BigDecimal;

public class TProjectConsumeRecord {
    private Long recordId;

    private Long userId;

    private Long projectId;

    private BigDecimal money;

    private BigDecimal paymentMoney;

    private String paymentType;

    private Byte isBack;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getPaymentMoney() {
        return paymentMoney;
    }

    public void setPaymentMoney(BigDecimal paymentMoney) {
        this.paymentMoney = paymentMoney;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    public Byte getIsBack() {
        return isBack;
    }

    public void setIsBack(Byte isBack) {
        this.isBack = isBack;
    }
}