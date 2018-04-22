package com.gasq.bdp.logn.service;

import java.util.List;

import com.gasq.bdp.logn.model.TUserShareRule;
import com.gasq.bdp.logn.model.TUserShareRuleExample;

public interface TUserShareRuleService {
	int countByExample(TUserShareRuleExample example);

	int deleteByExample(TUserShareRuleExample example);

	int deleteByPrimaryKey(Integer shareType);

	int insert(TUserShareRule record);

	int insertSelective(TUserShareRule record);

	List<TUserShareRule> selectByExample(TUserShareRuleExample example);

	TUserShareRule selectByPrimaryKey(Integer shareType);

	int updateByExampleSelective(TUserShareRule record, TUserShareRuleExample example);

	int updateByExample(TUserShareRule record, TUserShareRuleExample example);

	int updateByPrimaryKeySelective(TUserShareRule record);

	int updateByPrimaryKey(TUserShareRule record);
}