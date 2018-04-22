package com.gasq.bdp.logn.model;
import java.math.BigDecimal;
import java.util.List;


/**  
* 类说明   
*  
* @author laody 
* @date 2018年3月15日
*/
public class TProjectBase {
	protected BigDecimal amount=new BigDecimal("0");
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	protected List<TFeature> listFeature;
	protected boolean isenough=true;

	public boolean isIsenough() {
		return isenough;
	}

	public void setIsenough(boolean isenough) {
		this.isenough = isenough;
	}

	public List<TFeature> getListFeature() {
		return listFeature;
	}

	public void setListFeature(List<TFeature> listFeature) {
		this.listFeature = listFeature;
	}
	
	

}
