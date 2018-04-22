package com.gasq.bdp.logn.service;

import java.util.List;



import com.gasq.bdp.logn.model.TOrder;
import com.gasq.bdp.logn.model.TOrderExample;
import com.gasq.bdp.logn.model.TProject;
import com.gasq.bdp.logn.model.TUser;

/**  
* 类说明   
*  
* @author laody 
* @date 2018年3月15日
*/
public interface TOrderService {
	public  List<TOrder> selectByExample(TOrderExample example);
    public long countByExample(TOrderExample example);
    public  int insertSelective(TOrder record);
    public String getPayCode();
    public int updateByExampleSelective(TOrder record,TOrderExample example);
    public int deleteByPrimaryKey(Long id);
    public void settle(TUser user,TOrder order) throws Exception;
    public boolean checkOrderProjectEnoughAndPersistent(TUser user,Long id);
    public Long getUnSettleOrderCt(TUser user);
    public void cartSubDel(TUser user,Long id,String all);
    public int getCarCt(TUser user);
    public int fixorderStatus(TUser user,TProject project,Boolean isChecked);
    
    
    
}
