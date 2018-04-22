package com.gasq.bdp.logn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gasq.bdp.logn.model.TUserCashBackRecord;
import com.gasq.bdp.logn.model.TUserCashBackRecordExample;
import com.gasq.bdp.logn.model.TUserCashBackRecordKey;

public interface TUserCashBackRecordMapper {
	int countByExample(TUserCashBackRecordExample example);

	int deleteByExample(TUserCashBackRecordExample example);

	int deleteByPrimaryKey(TUserCashBackRecordKey key);

	int insert(TUserCashBackRecord record);

	int insertSelective(TUserCashBackRecord record);

	List<TUserCashBackRecord> selectByExample(TUserCashBackRecordExample example);

	TUserCashBackRecord selectByPrimaryKey(TUserCashBackRecordKey key);

	int updateByExampleSelective(@Param("record") TUserCashBackRecord record, @Param("example") TUserCashBackRecordExample example);

	int updateByExample(@Param("record") TUserCashBackRecord record, @Param("example") TUserCashBackRecordExample example);

	int updateByPrimaryKeySelective(TUserCashBackRecord record);

	int updateByPrimaryKey(TUserCashBackRecord record);
}