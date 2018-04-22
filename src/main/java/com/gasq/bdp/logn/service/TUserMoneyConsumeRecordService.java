package com.gasq.bdp.logn.service;

import java.util.List;

import com.gasq.bdp.logn.model.TUserMoneyConsumeRecord;
import com.gasq.bdp.logn.model.TUserMoneyConsumeRecordExample;
import com.gasq.bdp.logn.model.TUserMoneyConsumeRecordKey;

public interface TUserMoneyConsumeRecordService {
	int countByExample(TUserMoneyConsumeRecordExample example);

	int deleteByExample(TUserMoneyConsumeRecordExample example);

	int deleteByPrimaryKey(TUserMoneyConsumeRecordKey key);

	int insert(TUserMoneyConsumeRecord record);

	int insertSelective(TUserMoneyConsumeRecord record);

	List<TUserMoneyConsumeRecord> selectByExample(TUserMoneyConsumeRecordExample example);

	TUserMoneyConsumeRecord selectByPrimaryKey(TUserMoneyConsumeRecordKey key);

	int updateByExampleSelective(TUserMoneyConsumeRecord record, TUserMoneyConsumeRecordExample example);

	int updateByExample(TUserMoneyConsumeRecord record, TUserMoneyConsumeRecordExample example);

	int updateByPrimaryKeySelective(TUserMoneyConsumeRecord record);

	int updateByPrimaryKey(TUserMoneyConsumeRecord record);
}