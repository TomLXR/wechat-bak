package com.gasq.bdp.logn.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gasq.bdp.logn.mapper.TUserMoneyConsumeRecordMapper;
import com.gasq.bdp.logn.model.TUserMoneyConsumeRecord;
import com.gasq.bdp.logn.model.TUserMoneyConsumeRecordExample;
import com.gasq.bdp.logn.model.TUserMoneyConsumeRecordKey;
import com.gasq.bdp.logn.service.TUserMoneyConsumeRecordService;

@Service
public class TUserMoneyConsumeRecordServiceImpl implements TUserMoneyConsumeRecordService {

	@Resource
	private TUserMoneyConsumeRecordMapper tUserMoneyConsumeRecordMapper;

	public TUserMoneyConsumeRecordMapper gettUserMoneyConsumeRecordMapper() {
		return tUserMoneyConsumeRecordMapper;
	}

	public void settUserMoneyConsumeRecordMapper(TUserMoneyConsumeRecordMapper tUserMoneyConsumeRecordMapper) {
		this.tUserMoneyConsumeRecordMapper = tUserMoneyConsumeRecordMapper;
	}

	@Override
	public int countByExample(TUserMoneyConsumeRecordExample example) {
		return tUserMoneyConsumeRecordMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TUserMoneyConsumeRecordExample example) {
		return tUserMoneyConsumeRecordMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TUserMoneyConsumeRecordKey key) {
		return tUserMoneyConsumeRecordMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TUserMoneyConsumeRecord record) {
		return tUserMoneyConsumeRecordMapper.insert(record);
	}

	@Override
	public int insertSelective(TUserMoneyConsumeRecord record) {
		return tUserMoneyConsumeRecordMapper.insertSelective(record);
	}

	@Override
	public List<TUserMoneyConsumeRecord> selectByExample(TUserMoneyConsumeRecordExample example) {
		return tUserMoneyConsumeRecordMapper.selectByExample(example);
	}

	@Override
	public TUserMoneyConsumeRecord selectByPrimaryKey(TUserMoneyConsumeRecordKey key) {
		return tUserMoneyConsumeRecordMapper.selectByPrimaryKey(key);
	}

	@Override
	public int updateByExampleSelective(TUserMoneyConsumeRecord record, TUserMoneyConsumeRecordExample example) {
		return tUserMoneyConsumeRecordMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TUserMoneyConsumeRecord record, TUserMoneyConsumeRecordExample example) {
		return tUserMoneyConsumeRecordMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TUserMoneyConsumeRecord record) {
		return tUserMoneyConsumeRecordMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TUserMoneyConsumeRecord record) {
		return tUserMoneyConsumeRecordMapper.updateByPrimaryKey(record);
	}
}