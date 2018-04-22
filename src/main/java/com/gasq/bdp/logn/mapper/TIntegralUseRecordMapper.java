package com.gasq.bdp.logn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gasq.bdp.logn.model.TIntegralUseRecord;
import com.gasq.bdp.logn.model.TIntegralUseRecordExample;
import com.gasq.bdp.logn.model.TIntegralUseRecordKey;

public interface TIntegralUseRecordMapper {
	int countByExample(TIntegralUseRecordExample example);

	int deleteByExample(TIntegralUseRecordExample example);

	int deleteByPrimaryKey(TIntegralUseRecordKey key);

	int insert(TIntegralUseRecord record);

	int insertSelective(TIntegralUseRecord record);

	List<TIntegralUseRecord> selectByExample(TIntegralUseRecordExample example);

	TIntegralUseRecord selectByPrimaryKey(TIntegralUseRecordKey key);

	int updateByExampleSelective(@Param("record") TIntegralUseRecord record, @Param("example") TIntegralUseRecordExample example);

	int updateByExample(@Param("record") TIntegralUseRecord record, @Param("example") TIntegralUseRecordExample example);

	int updateByPrimaryKeySelective(TIntegralUseRecord record);

	int updateByPrimaryKey(TIntegralUseRecord record);
}