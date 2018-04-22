package com.gasq.bdp.logn.service;

import java.util.List;

import com.gasq.bdp.logn.model.TIntegralGetRule;
import com.gasq.bdp.logn.model.TIntegralGetRuleExample;

public interface TIntegralGetRuleService {
	int countByExample(TIntegralGetRuleExample example);

	int deleteByExample(TIntegralGetRuleExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TIntegralGetRule record);

	int insertSelective(TIntegralGetRule record);

	List<TIntegralGetRule> selectByExample(TIntegralGetRuleExample example);

	TIntegralGetRule selectByPrimaryKey(Long id);

	int updateByExampleSelective(TIntegralGetRule record, TIntegralGetRuleExample example);

	int updateByExample(TIntegralGetRule record, TIntegralGetRuleExample example);

	int updateByPrimaryKeySelective(TIntegralGetRule record);

	int updateByPrimaryKey(TIntegralGetRule record);
}