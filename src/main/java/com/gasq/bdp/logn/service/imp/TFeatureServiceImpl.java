package com.gasq.bdp.logn.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasq.bdp.logn.mapper.TFeatureMapper;
import com.gasq.bdp.logn.model.TFeature;
import com.gasq.bdp.logn.model.TFeatureExample;
import com.gasq.bdp.logn.service.TFeatureService;

/**  
* 类说明   
*  
* @author laody 
* @date 2018年2月2日
*/
@Service
public class TFeatureServiceImpl implements TFeatureService {
	@Autowired
	private TFeatureMapper  tFeatureMapper;
	@Override
	public long countByExample(TFeatureExample example) {
		
		return tFeatureMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TFeatureExample example) {
		
		return tFeatureMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		
		return tFeatureMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(TFeature record) {

		return tFeatureMapper.insert(record);
	}

	@Override
	public int insertSelective(TFeature record) {
		
		return tFeatureMapper.insertSelective(record);
	}

	@Override
	public List<TFeature> selectByExample(TFeatureExample example) {

		return tFeatureMapper.selectByExample(example);
	}

	@Override
	public TFeature selectByPrimaryKey(Long id) {

		return tFeatureMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(TFeature record, TFeatureExample example) {

		return tFeatureMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TFeature record, TFeatureExample example) {

		return tFeatureMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TFeature record) {

		return tFeatureMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TFeature record) {
		
		return tFeatureMapper.updateByPrimaryKey(record);
	}

}
