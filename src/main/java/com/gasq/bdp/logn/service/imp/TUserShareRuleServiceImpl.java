package com.gasq.bdp.logn.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gasq.bdp.logn.mapper.TUserShareRuleMapper;
import com.gasq.bdp.logn.model.TUserShareRule;
import com.gasq.bdp.logn.model.TUserShareRuleExample;
import com.gasq.bdp.logn.service.TUserShareRuleService;

@Service
public class TUserShareRuleServiceImpl implements TUserShareRuleService {

	@Resource
	private TUserShareRuleMapper tUserShareRuleMapper;

	public TUserShareRuleMapper gettUserShareRuleMapper() {
		return tUserShareRuleMapper;
	}

	public void settUserShareRuleMapper(TUserShareRuleMapper tUserShareRuleMapper) {
		this.tUserShareRuleMapper = tUserShareRuleMapper;
	}

	@Override
	public int countByExample(TUserShareRuleExample example) {
		return tUserShareRuleMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TUserShareRuleExample example) {
		return tUserShareRuleMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer shareType) {
		return tUserShareRuleMapper.deleteByPrimaryKey(shareType);
	}

	@Override
	public int insert(TUserShareRule record) {
		return tUserShareRuleMapper.insert(record);
	}

	@Override
	public int insertSelective(TUserShareRule record) {
		return tUserShareRuleMapper.insertSelective(record);
	}

	@Override
	public List<TUserShareRule> selectByExample(TUserShareRuleExample example) {
		return tUserShareRuleMapper.selectByExample(example);
	}

	@Override
	public TUserShareRule selectByPrimaryKey(Integer shareType) {
		return tUserShareRuleMapper.selectByPrimaryKey(shareType);
	}

	@Override
	public int updateByExampleSelective(TUserShareRule record, TUserShareRuleExample example) {
		return tUserShareRuleMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TUserShareRule record, TUserShareRuleExample example) {
		return tUserShareRuleMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TUserShareRule record) {
		return tUserShareRuleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TUserShareRule record) {
		return tUserShareRuleMapper.updateByPrimaryKey(record);
	}
}