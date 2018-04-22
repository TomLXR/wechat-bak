/**
 * 
 */
package com.gasq.bdp.logn.model;

import java.util.List;

/**
 * @author Ju_weigang
 * @时间 2018年2月8日下午6:06:07
 * @项目路径 com.gasq.bdp.logn.model
 * @描述 
 */
public class LtnCustomerAmountBean {
	
    private TLtnCustomer customer;
    private List<TLtnCustomerConsumptonAmount> amountlist;
	public TLtnCustomer getCustomer() {
		return customer;
	}
	public void setCustomer(TLtnCustomer customer) {
		this.customer = customer;
	}
	public List<TLtnCustomerConsumptonAmount> getAmountlist() {
		return amountlist;
	}
	public void setAmountlist(List<TLtnCustomerConsumptonAmount> amountlist) {
		this.amountlist = amountlist;
	}
	public LtnCustomerAmountBean(TLtnCustomer customer, List<TLtnCustomerConsumptonAmount> amountlist) {
		super();
		this.customer = customer;
		this.amountlist = amountlist;
	}
    
}
