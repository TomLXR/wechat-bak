package com.gasq.bdp.logn.service;

import java.util.List;

import com.gasq.bdp.logn.model.TUserCashBackRecord;
import com.gasq.bdp.logn.model.TUserCashBackRecordExample;
import com.gasq.bdp.logn.model.TUserCashBackRecordKey;

public interface TUserCashBackRecordService {
	int countByExample(TUserCashBackRecordExample example);

	int deleteByExample(TUserCashBackRecordExample example);

	int deleteByPrimaryKey(TUserCashBackRecordKey key);

	int insert(TUserCashBackRecord record);

	int insertSelective(TUserCashBackRecord record);

	List<TUserCashBackRecord> selectByExample(TUserCashBackRecordExample example);

	TUserCashBackRecord selectByPrimaryKey(TUserCashBackRecordKey key);

	int updateByExampleSelective(TUserCashBackRecord record, TUserCashBackRecordExample example);

	int updateByExample(TUserCashBackRecord record, TUserCashBackRecordExample example);

	int updateByPrimaryKeySelective(TUserCashBackRecord record);

	int updateByPrimaryKey(TUserCashBackRecord record);
}