package com.gasq.bdp.logn.service;

import java.util.List;
import com.gasq.bdp.logn.model.TUserSignExt;
import com.gasq.bdp.logn.model.TUserSignExtExample;

/**  
* 类说明   
*  
* @author laody 
* @date 2018年3月9日
*/
public interface TUserSignExtService {
    int insert(TUserSignExt record);

    int insertSelective(TUserSignExt record);
    
    int deleteByPrimaryKey(Long id);
    
    List<TUserSignExt> selectByExample(TUserSignExtExample example);
    
    
    int updateByExampleSelective( TUserSignExt record,  TUserSignExtExample example);

}
