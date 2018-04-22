package com.gasq.bdp.logn.model;

public class TUserShareRecordKey {
	private Long userId;

	private Long registerUserId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRegisterUserId() {
		return registerUserId;
	}

	public void setRegisterUserId(Long registerUserId) {
		this.registerUserId = registerUserId;
	}
}