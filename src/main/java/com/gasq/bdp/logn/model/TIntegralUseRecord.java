package com.gasq.bdp.logn.model;

import java.util.Date;

public class TIntegralUseRecord extends TIntegralUseRecordKey {
	private Long userId;

	private Long integral;

	private Date useDateTime;

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

	public Date getUseDateTime() {
		return useDateTime;
	}

	public void setUseDateTime(Date useDateTime) {
		this.useDateTime = useDateTime;
	}
}