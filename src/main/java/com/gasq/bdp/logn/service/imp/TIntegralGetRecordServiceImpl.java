package com.gasq.bdp.logn.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gasq.bdp.logn.mapper.TIntegralGetRecordMapper;
import com.gasq.bdp.logn.model.TIntegralGetRecord;
import com.gasq.bdp.logn.model.TIntegralGetRecordExample;
import com.gasq.bdp.logn.service.TIntegralGetRecordService;

@Service
public class TIntegralGetRecordServiceImpl implements TIntegralGetRecordService {

	@Resource
	private TIntegralGetRecordMapper tIntegralGetRecordMapper;

	public TIntegralGetRecordMapper gettIntegralGetRecordMapper() {
		return tIntegralGetRecordMapper;
	}

	public void settIntegralGetRecordMapper(TIntegralGetRecordMapper tIntegralGetRecordMapper) {
		this.tIntegralGetRecordMapper = tIntegralGetRecordMapper;
	}

	@Override
	public int countByExample(TIntegralGetRecordExample example) {
		return tIntegralGetRecordMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TIntegralGetRecordExample example) {
		return tIntegralGetRecordMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		return tIntegralGetRecordMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(TIntegralGetRecord record) {
		return tIntegralGetRecordMapper.insert(record);
	}

	@Override
	public int insertSelective(TIntegralGetRecord record) {
		return tIntegralGetRecordMapper.insertSelective(record);
	}

	@Override
	public List<TIntegralGetRecord> selectByExample(TIntegralGetRecordExample example) {
		return tIntegralGetRecordMapper.selectByExample(example);
	}

	@Override
	public TIntegralGetRecord selectByPrimaryKey(Long id) {
		return tIntegralGetRecordMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(TIntegralGetRecord record, TIntegralGetRecordExample example) {
		return tIntegralGetRecordMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TIntegralGetRecord record, TIntegralGetRecordExample example) {
		return tIntegralGetRecordMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TIntegralGetRecord record) {
		return tIntegralGetRecordMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TIntegralGetRecord record) {
		return tIntegralGetRecordMapper.updateByPrimaryKey(record);
	}
}