package com.gasq.bdp.logn.service;

import java.util.List;

import com.gasq.bdp.logn.model.TFeatureExample;
import com.gasq.bdp.logn.model.TFeature;;

/**  
* 类说明   
*  
* @author laody 
* @date 2018年2月2日
*/
public interface TFeatureService {
	long countByExample(TFeatureExample example);

	int deleteByExample(TFeatureExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TFeature record);

	int insertSelective(TFeature record);

	List<TFeature> selectByExample(TFeatureExample example);

	TFeature selectByPrimaryKey(Long id);

	int updateByExampleSelective(TFeature record,TFeatureExample example);

	int updateByExample(TFeature record,TFeatureExample example);

	int updateByPrimaryKeySelective(TFeature record);

	int updateByPrimaryKey(TFeature record);

}
