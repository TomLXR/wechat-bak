package com.gasq.bdp.logn.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gasq.bdp.logn.mapper.TIntegralUseRecordMapper;
import com.gasq.bdp.logn.model.TIntegralUseRecord;
import com.gasq.bdp.logn.model.TIntegralUseRecordExample;
import com.gasq.bdp.logn.model.TIntegralUseRecordKey;
import com.gasq.bdp.logn.service.TIntegralUseRecordService;

@Service
public class TIntegralUseRecordServiceImpl implements TIntegralUseRecordService {

	@Resource
	private TIntegralUseRecordMapper tIntegralUseRecordMapper;

	public TIntegralUseRecordMapper gettIntegralUseRecordMapper() {
		return tIntegralUseRecordMapper;
	}

	public void settIntegralUseRecordMapper(TIntegralUseRecordMapper tIntegralUseRecordMapper) {
		this.tIntegralUseRecordMapper = tIntegralUseRecordMapper;
	}

	@Override
	public int countByExample(TIntegralUseRecordExample example) {
		return tIntegralUseRecordMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TIntegralUseRecordExample example) {
		return tIntegralUseRecordMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TIntegralUseRecordKey key) {
		return tIntegralUseRecordMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TIntegralUseRecord record) {
		return tIntegralUseRecordMapper.insert(record);
	}

	@Override
	public int insertSelective(TIntegralUseRecord record) {
		return tIntegralUseRecordMapper.insertSelective(record);
	}

	@Override
	public List<TIntegralUseRecord> selectByExample(TIntegralUseRecordExample example) {
		return tIntegralUseRecordMapper.selectByExample(example);
	}

	@Override
	public TIntegralUseRecord selectByPrimaryKey(TIntegralUseRecordKey key) {
		return tIntegralUseRecordMapper.selectByPrimaryKey(key);
	}

	@Override
	public int updateByExampleSelective(TIntegralUseRecord record, TIntegralUseRecordExample example) {
		return tIntegralUseRecordMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TIntegralUseRecord record, TIntegralUseRecordExample example) {
		return tIntegralUseRecordMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TIntegralUseRecord record) {
		return tIntegralUseRecordMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TIntegralUseRecord record) {
		return tIntegralUseRecordMapper.updateByPrimaryKey(record);
	}
}