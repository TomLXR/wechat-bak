package com.gasq.bdp.logn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gasq.bdp.logn.model.TUserMoneyConsumeRecord;
import com.gasq.bdp.logn.model.TUserMoneyConsumeRecordExample;
import com.gasq.bdp.logn.model.TUserMoneyConsumeRecordKey;

public interface TUserMoneyConsumeRecordMapper {
	int countByExample(TUserMoneyConsumeRecordExample example);

	int deleteByExample(TUserMoneyConsumeRecordExample example);

	int deleteByPrimaryKey(TUserMoneyConsumeRecordKey key);

	int insert(TUserMoneyConsumeRecord record);

	int insertSelective(TUserMoneyConsumeRecord record);

	List<TUserMoneyConsumeRecord> selectByExample(TUserMoneyConsumeRecordExample example);

	TUserMoneyConsumeRecord selectByPrimaryKey(TUserMoneyConsumeRecordKey key);

	int updateByExampleSelective(@Param("record") TUserMoneyConsumeRecord record, @Param("example") TUserMoneyConsumeRecordExample example);

	int updateByExample(@Param("record") TUserMoneyConsumeRecord record, @Param("example") TUserMoneyConsumeRecordExample example);

	int updateByPrimaryKeySelective(TUserMoneyConsumeRecord record);

	int updateByPrimaryKey(TUserMoneyConsumeRecord record);
}