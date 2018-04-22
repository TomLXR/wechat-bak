package com.gasq.bdp.logn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gasq.bdp.logn.model.TUserShareRule;
import com.gasq.bdp.logn.model.TUserShareRuleExample;

public interface TUserShareRuleMapper {
	int countByExample(TUserShareRuleExample example);

	int deleteByExample(TUserShareRuleExample example);

	int deleteByPrimaryKey(Integer shareType);

	int insert(TUserShareRule record);

	int insertSelective(TUserShareRule record);

	List<TUserShareRule> selectByExample(TUserShareRuleExample example);

	TUserShareRule selectByPrimaryKey(Integer shareType);

	int updateByExampleSelective(@Param("record") TUserShareRule record, @Param("example") TUserShareRuleExample example);

	int updateByExample(@Param("record") TUserShareRule record, @Param("example") TUserShareRuleExample example);

	int updateByPrimaryKeySelective(TUserShareRule record);

	int updateByPrimaryKey(TUserShareRule record);
}