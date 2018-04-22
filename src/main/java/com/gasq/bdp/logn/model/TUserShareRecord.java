package com.gasq.bdp.logn.model;

import java.util.Date;

public class TUserShareRecord  {
    private Date registerTime;

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
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