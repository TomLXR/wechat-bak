package com.gasq.bdp.logn.service;
import java.util.List;

import org.slf4j.Logger;

import com.gasq.bdp.logn.model.LtnCustomerAmountBean;
import com.gasq.bdp.logn.model.TLtnCustomerConsumptonAmount;
import com.gasq.bdp.logn.model.TProjectConsumeRecord;
import com.gasq.bdp.logn.model.TUserShareRule;
/**  
* 类说明     根据订单同步积分
*  
* @author laody 
* @date 2017年12月5日
*/
public interface MergeScoreService {
	/**
	 * 从订单数据算取积分
	 * @return 成功数量
	 */
	int merge(); 
	/**
	 * 获取当前的积分返点层级
	 * @return 层级数
	 */
	int getLevel();
	
	/**
	 * 获取未返点的消费记录信息
	 * @return 消费记录
	 */
	/*List<TProjectConsumeRecord> getConsumeRecord();*/
	
	
	/**返回层级描述信息
	 * @return
	 */
	List<TUserShareRule> getLevelList();
	
	void recordIntoDB(TLtnCustomerConsumptonAmount CustomerAmountBean) throws Exception;
	
	void mergeUserScore() throws Exception;
}
