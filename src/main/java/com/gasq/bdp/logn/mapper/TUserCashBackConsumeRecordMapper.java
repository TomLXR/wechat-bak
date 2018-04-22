package com.gasq.bdp.logn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gasq.bdp.logn.model.TUserCashBackConsumeRecord;
import com.gasq.bdp.logn.model.TUserCashBackConsumeRecordExample;
import com.gasq.bdp.logn.model.TUserCashBackConsumeRecordKey;

public interface TUserCashBackConsumeRecordMapper {
	int countByExample(TUserCashBackConsumeRecordExample example);

	int deleteByExample(TUserCashBackConsumeRecordExample example);

	int deleteByPrimaryKey(TUserCashBackConsumeRecordKey key);

	int insert(TUserCashBackConsumeRecord record);

	int insertSelective(TUserCashBackConsumeRecord record);

	List<TUserCashBackConsumeRecord> selectByExample(TUserCashBackConsumeRecordExample example);

	TUserCashBackConsumeRecord selectByPrimaryKey(TUserCashBackConsumeRecordKey key);

	int updateByExampleSelective(@Param("record") TUserCashBackConsumeRecord record, @Param("example") TUserCashBackConsumeRecordExample example);

	int updateByExample(@Param("record") TUserCashBackConsumeRecord record, @Param("example") TUserCashBackConsumeRecordExample example);

	int updateByPrimaryKeySelective(TUserCashBackConsumeRecord record);

	int updateByPrimaryKey(TUserCashBackConsumeRecord record);
}