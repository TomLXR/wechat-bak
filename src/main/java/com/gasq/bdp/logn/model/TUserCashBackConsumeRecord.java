package com.gasq.bdp.logn.model;

import java.math.BigDecimal;

public class TUserCashBackConsumeRecord extends TUserCashBackConsumeRecordKey {
	private BigDecimal money;

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}
}