package com.gasq.bdp.logn.model;

import java.math.BigDecimal;

public class TUserMoneyConsumeRecord extends TUserMoneyConsumeRecordKey {
	private BigDecimal money;

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}
}