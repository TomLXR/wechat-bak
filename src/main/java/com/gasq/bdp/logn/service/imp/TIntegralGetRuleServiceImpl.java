package com.gasq.bdp.logn.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gasq.bdp.logn.mapper.TIntegralGetRuleMapper;
import com.gasq.bdp.logn.model.TIntegralGetRule;
import com.gasq.bdp.logn.model.TIntegralGetRuleExample;
import com.gasq.bdp.logn.service.TIntegralGetRuleService;

@Service
public class TIntegralGetRuleServiceImpl implements TIntegralGetRuleService {

	@Resource
	private TIntegralGetRuleMapper tIntegralGetRuleMapper;

	public TIntegralGetRuleMapper gettIntegralGetRuleMapper() {
		return tIntegralGetRuleMapper;
	}

	public void settIntegralGetRuleMapper(TIntegralGetRuleMapper tIntegralGetRuleMapper) {
		this.tIntegralGetRuleMapper = tIntegralGetRuleMapper;
	}

	@Override
	public int countByExample(TIntegralGetRuleExample example) {
		return tIntegralGetRuleMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TIntegralGetRuleExample example) {
		return tIntegralGetRuleMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		return tIntegralGetRuleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(TIntegralGetRule record) {
		return tIntegralGetRuleMapper.insert(record);
	}

	@Override
	public int insertSelective(TIntegralGetRule record) {
		return tIntegralGetRuleMapper.insertSelective(record);
	}

	@Override
	public List<TIntegralGetRule> selectByExample(TIntegralGetRuleExample example) {
		return tIntegralGetRuleMapper.selectByExample(example);
	}

	@Override
	public TIntegralGetRule selectByPrimaryKey(Long id) {
		return tIntegralGetRuleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(TIntegralGetRule record, TIntegralGetRuleExample example) {
		return tIntegralGetRuleMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TIntegralGetRule record, TIntegralGetRuleExample example) {
		return tIntegralGetRuleMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TIntegralGetRule record) {
		return tIntegralGetRuleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TIntegralGetRule record) {
		return tIntegralGetRuleMapper.updateByPrimaryKey(record);
	}
}