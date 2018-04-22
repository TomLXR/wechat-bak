package com.gasq.bdp.logn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gasq.bdp.logn.model.TProjectConsumeRecord;
import com.gasq.bdp.logn.model.TProjectConsumeRecordExample;

public interface TProjectConsumeRecordMapper {
	int countByExample(TProjectConsumeRecordExample example);

	int deleteByExample(TProjectConsumeRecordExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TProjectConsumeRecord record);

	int insertSelective(TProjectConsumeRecord record);

	List<TProjectConsumeRecord> selectByExample(TProjectConsumeRecordExample example);

	TProjectConsumeRecord selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TProjectConsumeRecord record, @Param("example") TProjectConsumeRecordExample example);

	int updateByExample(@Param("record") TProjectConsumeRecord record, @Param("example") TProjectConsumeRecordExample example);

	int updateByPrimaryKeySelective(TProjectConsumeRecord record);

	int updateByPrimaryKey(TProjectConsumeRecord record);
}