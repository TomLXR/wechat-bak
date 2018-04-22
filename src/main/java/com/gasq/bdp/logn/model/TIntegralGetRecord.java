package com.gasq.bdp.logn.model;

import java.math.BigDecimal;
import java.util.Date;

public class TIntegralGetRecord {
    private Long id;

    private Long supUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupUserId() {
        return supUserId;
    }

    public void setSupUserId(Long supUserId) {
        this.supUserId = supUserId;
    }
	
    private Long userId;

    private Long integral;

    private Date getDateTime;

    private Long recordId;

    private Date validDate;

    private Long hasUsedIntegral;

    private Long notUsedIntegral;

    private Long ruleId;

    private BigDecimal discount;

    private Date avaDateTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getIntegral() {
        return integral;
    }

    public void setIntegral(Long integral) {
        this.integral = integral;
    }

    public Date getGetDateTime() {
        return getDateTime;
    }

    public void setGetDateTime(Date getDateTime) {
        this.getDateTime = getDateTime;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Long getHasUsedIntegral() {
        return hasUsedIntegral;
    }

    public void setHasUsedIntegral(Long hasUsedIntegral) {
        this.hasUsedIntegral = hasUsedIntegral;
    }

    public Long getNotUsedIntegral() {
        return notUsedIntegral;
    }

    public void setNotUsedIntegral(Long notUsedIntegral) {
        this.notUsedIntegral = notUsedIntegral;
    }

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Date getAvaDateTime() {
        return avaDateTime;
    }

    public void setAvaDateTime(Date avaDateTime) {
        this.avaDateTime = avaDateTime;
    }
}