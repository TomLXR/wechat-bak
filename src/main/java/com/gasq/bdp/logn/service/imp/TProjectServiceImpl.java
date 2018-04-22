package com.gasq.bdp.logn.service.imp;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gasq.bdp.logn.mapper.TProjectMapper;
import com.gasq.bdp.logn.model.TProject;
import com.gasq.bdp.logn.model.TProjectExample;
import com.gasq.bdp.logn.model.TProjectExample.Criteria;
import com.gasq.bdp.logn.service.TProjectService;

@Service
public class TProjectServiceImpl implements TProjectService {

	@Resource
	private TProjectMapper tProjectMapper;

	public TProjectMapper gettProjectMapper() {
		return tProjectMapper;
	}

	public void settProjectMapper(TProjectMapper tProjectMapper) {
		this.tProjectMapper = tProjectMapper;
	}

	@Override
	public long countByExample(TProjectExample example) {
		return tProjectMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TProjectExample example) {
		return tProjectMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		return tProjectMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(TProject record) {
		return tProjectMapper.insert(record);
	}

	@Override
	public int insertSelective(TProject record) {
		return tProjectMapper.insertSelective(record);
	}

	@Override
	public List<TProject> selectByExample(TProjectExample example) {
		return tProjectMapper.selectByExample(example);
	}

	@Override
	public TProject selectByPrimaryKey(Long id) {
		return tProjectMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(TProject record, TProjectExample example) {
		return tProjectMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TProject record, TProjectExample example) {
		return tProjectMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TProject record) {
		return tProjectMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TProject record) {
		return tProjectMapper.updateByPrimaryKey(record);
	}
	/**
	 * 判断是否有更多的打折商品可以显示
	 * 默认没有 false
	 * 
	 */
	@Override
	public boolean isMoreEnable(int end){
		boolean isMore=false;
		TProjectExample exmple=new TProjectExample();
		Criteria criteria = exmple.createCriteria();
		criteria.andStatusEqualTo((byte)1);
		criteria.andDiscountLessThan(new BigDecimal(1));
		Long count = tProjectMapper.countByExample(exmple);
		// 判断是否已经全部显示完
		if(count.intValue()>end){
			isMore=true;
		}
		return isMore;
		
	}
	
	
	
	/**
	 * 判断是否有更多的有效商品可以显示
	 * 默认没有 false
	 * 
	 */	
	@Override
	public boolean isMoreAllEnable(int end){
		boolean isMore=false;
		TProjectExample exmple=new TProjectExample();
		Criteria criteria = exmple.createCriteria();
		criteria.andStatusEqualTo((byte)1);
		Long count = tProjectMapper.countByExample(exmple);
		System.out.println(end);
		System.out.println(count);
		if(count.intValue()>end){
			isMore=true;
		}
		return isMore;
		
	}
	
}