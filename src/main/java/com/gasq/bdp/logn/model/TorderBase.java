package com.gasq.bdp.logn.model;

import java.util.ArrayList;
import java.util.List;

public class TorderBase {
	protected Integer end;
	protected List<TProject> plist=new ArrayList<>();
	protected int amount=0;
	protected int tmoney=0;
	protected int total=0;
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTmoney() {
		return tmoney;
	}

	public void setTmoney(int tmoney) {
		this.tmoney = tmoney;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public List<TProject> getPlist() {
		return plist;
	}

	public void setPlist(List<TProject> plist) {
		this.plist = plist;
	}
	

}
