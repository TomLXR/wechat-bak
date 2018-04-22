package com.gasq.bdp.logn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gasq.bdp.logn.model.TIntegralGetRule;
import com.gasq.bdp.logn.model.TIntegralGetRuleExample;

public interface TIntegralGetRuleMapper {
	int countByExample(TIntegralGetRuleExample example);

	int deleteByExample(TIntegralGetRuleExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TIntegralGetRule record);

	int insertSelective(TIntegralGetRule record);

	List<TIntegralGetRule> selectByExample(TIntegralGetRuleExample example);

	TIntegralGetRule selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TIntegralGetRule record, @Param("example") TIntegralGetRuleExample example);

	int updateByExample(@Param("record") TIntegralGetRule record, @Param("example") TIntegralGetRuleExample example);

	int updateByPrimaryKeySelective(TIntegralGetRule record);

	int updateByPrimaryKey(TIntegralGetRule record);
}