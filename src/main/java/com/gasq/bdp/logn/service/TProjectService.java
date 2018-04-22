package com.gasq.bdp.logn.service;

import java.util.List;

import com.gasq.bdp.logn.model.TProject;
import com.gasq.bdp.logn.model.TProjectExample;

public interface TProjectService {
	long countByExample(TProjectExample example);

	int deleteByExample(TProjectExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TProject record);

	int insertSelective(TProject record);

	List<TProject> selectByExample(TProjectExample example);

	TProject selectByPrimaryKey(Long id);

	int updateByExampleSelective(TProject record, TProjectExample example);

	int updateByExample(TProject record, TProjectExample example);

	int updateByPrimaryKeySelective(TProject record);

	int updateByPrimaryKey(TProject record);
	
	boolean isMoreEnable(int end);
	
	boolean isMoreAllEnable(int end);

}