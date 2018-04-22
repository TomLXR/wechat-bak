
package com.gasq.bdp.logn.service;

import java.util.List;

import com.gasq.bdp.logn.model.TProjectConsumeRecord;
import com.gasq.bdp.logn.model.TProjectConsumeRecordExample;

public interface TProjectConsumeRecordService {
	int countByExample(TProjectConsumeRecordExample example);

	int deleteByExample(TProjectConsumeRecordExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TProjectConsumeRecord record);

	int insertSelective(TProjectConsumeRecord record);

	List<TProjectConsumeRecord> selectByExample(TProjectConsumeRecordExample example);

	TProjectConsumeRecord selectByPrimaryKey(Long id);

	int updateByExampleSelective(TProjectConsumeRecord record, TProjectConsumeRecordExample example);

	int updateByExample(TProjectConsumeRecord record, TProjectConsumeRecordExample example);

	int updateByPrimaryKeySelective(TProjectConsumeRecord record);

	int updateByPrimaryKey(TProjectConsumeRecord record);
}