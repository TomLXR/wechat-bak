package com.gasq.bdp.logn.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gasq.bdp.logn.mapper.TProjectConsumeRecordMapper;
import com.gasq.bdp.logn.model.TProjectConsumeRecord;
import com.gasq.bdp.logn.model.TProjectConsumeRecordExample;
import com.gasq.bdp.logn.service.TProjectConsumeRecordService;

@Service
public class TProjectConsumeRecordServiceImpl implements TProjectConsumeRecordService {

	@Resource
	private TProjectConsumeRecordMapper tProjectConsumeRecordMapper;

	public TProjectConsumeRecordMapper gettProjectConsumeRecordMapper() {
		return tProjectConsumeRecordMapper;
	}

	public void settProjectConsumeRecordMapper(TProjectConsumeRecordMapper tProjectConsumeRecordMapper) {
		this.tProjectConsumeRecordMapper = tProjectConsumeRecordMapper;
	}

	@Override
	public int countByExample(TProjectConsumeRecordExample example) {
		return tProjectConsumeRecordMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TProjectConsumeRecordExample example) {
		return tProjectConsumeRecordMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		return tProjectConsumeRecordMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(TProjectConsumeRecord record) {
		return tProjectConsumeRecordMapper.insert(record);
	}

	@Override
	public int insertSelective(TProjectConsumeRecord record) {
		return tProjectConsumeRecordMapper.insertSelective(record);
	}

	@Override
	public List<TProjectConsumeRecord> selectByExample(TProjectConsumeRecordExample example) {
		return tProjectConsumeRecordMapper.selectByExample(example);
	}

	@Override
	public TProjectConsumeRecord selectByPrimaryKey(Long id) {
		return tProjectConsumeRecordMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(TProjectConsumeRecord record, TProjectConsumeRecordExample example) {
		return tProjectConsumeRecordMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TProjectConsumeRecord record, TProjectConsumeRecordExample example) {
		return tProjectConsumeRecordMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TProjectConsumeRecord record) {
		return tProjectConsumeRecordMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TProjectConsumeRecord record) {
		return tProjectConsumeRecordMapper.updateByPrimaryKey(record);
	}
}