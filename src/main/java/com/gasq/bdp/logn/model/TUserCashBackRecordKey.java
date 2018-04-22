package com.gasq.bdp.logn.model;

public class TUserCashBackRecordKey {
	private Long userId;

	private Long supUserId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getSupUserId() {
		return supUserId;
	}

	public void setSupUserId(Long supUserId) {
		this.supUserId = supUserId;
	}
}