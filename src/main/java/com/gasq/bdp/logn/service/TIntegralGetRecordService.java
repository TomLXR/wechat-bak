package com.gasq.bdp.logn.service;

import java.util.List;

import com.gasq.bdp.logn.model.TIntegralGetRecord;
import com.gasq.bdp.logn.model.TIntegralGetRecordExample;

public interface TIntegralGetRecordService {
	int countByExample(TIntegralGetRecordExample example);

	int deleteByExample(TIntegralGetRecordExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TIntegralGetRecord record);

	int insertSelective(TIntegralGetRecord record);

	List<TIntegralGetRecord> selectByExample(TIntegralGetRecordExample example);

	TIntegralGetRecord selectByPrimaryKey(Long id);

	int updateByExampleSelective(TIntegralGetRecord record,TIntegralGetRecordExample example);

	int updateByExample(TIntegralGetRecord record,TIntegralGetRecordExample example);

	int updateByPrimaryKeySelective(TIntegralGetRecord record);

	int updateByPrimaryKey(TIntegralGetRecord record);
}