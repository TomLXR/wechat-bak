package com.gasq.bdp.logn.service;

import java.util.List;

import com.gasq.bdp.logn.model.TIntegralUseRecord;
import com.gasq.bdp.logn.model.TIntegralUseRecordExample;
import com.gasq.bdp.logn.model.TIntegralUseRecordKey;

public interface TIntegralUseRecordService {
	int countByExample(TIntegralUseRecordExample example);

	int deleteByExample(TIntegralUseRecordExample example);

	int deleteByPrimaryKey(TIntegralUseRecordKey key);

	int insert(TIntegralUseRecord record);

	int insertSelective(TIntegralUseRecord record);

	List<TIntegralUseRecord> selectByExample(TIntegralUseRecordExample example);

	TIntegralUseRecord selectByPrimaryKey(TIntegralUseRecordKey key);

	int updateByExampleSelective(TIntegralUseRecord record, TIntegralUseRecordExample example);

	int updateByExample(TIntegralUseRecord record, TIntegralUseRecordExample example);

	int updateByPrimaryKeySelective(TIntegralUseRecord record);

	int updateByPrimaryKey(TIntegralUseRecord record);
}