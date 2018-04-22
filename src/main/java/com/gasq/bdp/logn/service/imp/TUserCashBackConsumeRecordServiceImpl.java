package com.gasq.bdp.logn.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gasq.bdp.logn.mapper.TUserCashBackConsumeRecordMapper;
import com.gasq.bdp.logn.model.TUserCashBackConsumeRecord;
import com.gasq.bdp.logn.model.TUserCashBackConsumeRecordExample;
import com.gasq.bdp.logn.model.TUserCashBackConsumeRecordKey;
import com.gasq.bdp.logn.service.TUserCashBackConsumeRecordService;

@Service
public class TUserCashBackConsumeRecordServiceImpl implements TUserCashBackConsumeRecordService {

	@Resource
	private TUserCashBackConsumeRecordMapper tUserCashBackConsumeRecordMapper;

	public TUserCashBackConsumeRecordMapper gettUserCashBackConsumeRecordMapper() {
		return tUserCashBackConsumeRecordMapper;
	}

	public void settUserCashBackConsumeRecordMapper(TUserCashBackConsumeRecordMapper tUserCashBackConsumeRecordMapper) {
		this.tUserCashBackConsumeRecordMapper = tUserCashBackConsumeRecordMapper;
	}

	@Override
	public int countByExample(TUserCashBackConsumeRecordExample example) {
		return tUserCashBackConsumeRecordMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TUserCashBackConsumeRecordExample example) {
		return tUserCashBackConsumeRecordMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TUserCashBackConsumeRecordKey key) {
		return tUserCashBackConsumeRecordMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TUserCashBackConsumeRecord record) {
		return tUserCashBackConsumeRecordMapper.insert(record);
	}

	@Override
	public int insertSelective(TUserCashBackConsumeRecord record) {
		return tUserCashBackConsumeRecordMapper.insertSelective(record);
	}

	@Override
	public List<TUserCashBackConsumeRecord> selectByExample(TUserCashBackConsumeRecordExample example) {
		return tUserCashBackConsumeRecordMapper.selectByExample(example);
	}

	@Override
	public TUserCashBackConsumeRecord selectByPrimaryKey(TUserCashBackConsumeRecordKey key) {
		return tUserCashBackConsumeRecordMapper.selectByPrimaryKey(key);
	}

	@Override
	public int updateByExampleSelective(TUserCashBackConsumeRecord record, TUserCashBackConsumeRecordExample example) {
		return tUserCashBackConsumeRecordMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TUserCashBackConsumeRecord record, TUserCashBackConsumeRecordExample example) {
		return tUserCashBackConsumeRecordMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TUserCashBackConsumeRecord record) {
		return tUserCashBackConsumeRecordMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TUserCashBackConsumeRecord record) {
		return tUserCashBackConsumeRecordMapper.updateByPrimaryKey(record);
	}
}