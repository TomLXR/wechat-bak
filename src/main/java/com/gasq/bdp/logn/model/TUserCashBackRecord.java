package com.gasq.bdp.logn.model;

import java.math.BigDecimal;

public class TUserCashBackRecord extends TUserCashBackRecordKey {
	private BigDecimal money;

	private Long ruleId;

	private BigDecimal discount;

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
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
}