package com.gasq.bdp.logn.service;

import java.util.List;

import com.gasq.bdp.logn.model.TUserCashBackConsumeRecord;
import com.gasq.bdp.logn.model.TUserCashBackConsumeRecordExample;
import com.gasq.bdp.logn.model.TUserCashBackConsumeRecordKey;

public interface TUserCashBackConsumeRecordService {
	int countByExample(TUserCashBackConsumeRecordExample example);

	int deleteByExample(TUserCashBackConsumeRecordExample example);

	int deleteByPrimaryKey(TUserCashBackConsumeRecordKey key);

	int insert(TUserCashBackConsumeRecord record);

	int insertSelective(TUserCashBackConsumeRecord record);

	List<TUserCashBackConsumeRecord> selectByExample(TUserCashBackConsumeRecordExample example);

	TUserCashBackConsumeRecord selectByPrimaryKey(TUserCashBackConsumeRecordKey key);

	int updateByExampleSelective(TUserCashBackConsumeRecord record, TUserCashBackConsumeRecordExample example);

	int updateByExample(TUserCashBackConsumeRecord record, TUserCashBackConsumeRecordExample example);

	int updateByPrimaryKeySelective(TUserCashBackConsumeRecord record);

	int updateByPrimaryKey(TUserCashBackConsumeRecord record);
}