package com.gasq.bdp.logn.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gasq.bdp.logn.mapper.TUserCashBackRecordMapper;
import com.gasq.bdp.logn.model.TUserCashBackRecord;
import com.gasq.bdp.logn.model.TUserCashBackRecordExample;
import com.gasq.bdp.logn.model.TUserCashBackRecordKey;
import com.gasq.bdp.logn.service.TUserCashBackRecordService;

@Service
public class TUserCashBackRecordServiceImpl implements TUserCashBackRecordService {

	@Resource
	private TUserCashBackRecordMapper tUserCashBackRecordMapper;

	public TUserCashBackRecordMapper gettUserCashBackRecordMapper() {
		return tUserCashBackRecordMapper;
	}

	public void settUserCashBackRecordMapper(TUserCashBackRecordMapper tUserCashBackRecordMapper) {
		this.tUserCashBackRecordMapper = tUserCashBackRecordMapper;
	}

	@Override
	public int countByExample(TUserCashBackRecordExample example) {
		return tUserCashBackRecordMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TUserCashBackRecordExample example) {
		return tUserCashBackRecordMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(TUserCashBackRecordKey key) {
		return tUserCashBackRecordMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(TUserCashBackRecord record) {
		return tUserCashBackRecordMapper.insert(record);
	}

	@Override
	public int insertSelective(TUserCashBackRecord record) {
		return tUserCashBackRecordMapper.insertSelective(record);
	}

	@Override
	public List<TUserCashBackRecord> selectByExample(TUserCashBackRecordExample example) {
		return tUserCashBackRecordMapper.selectByExample(example);
	}

	@Override
	public TUserCashBackRecord selectByPrimaryKey(TUserCashBackRecordKey key) {
		return tUserCashBackRecordMapper.selectByPrimaryKey(key);
	}

	@Override
	public int updateByExampleSelective(TUserCashBackRecord record, TUserCashBackRecordExample example) {
		return tUserCashBackRecordMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TUserCashBackRecord record, TUserCashBackRecordExample example) {
		return tUserCashBackRecordMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TUserCashBackRecord record) {
		return tUserCashBackRecordMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TUserCashBackRecord record) {
		return tUserCashBackRecordMapper.updateByPrimaryKey(record);
	}
}