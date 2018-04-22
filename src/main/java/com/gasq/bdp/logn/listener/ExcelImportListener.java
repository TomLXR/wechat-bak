package com.gasq.bdp.logn.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**  
* 类说明   excel 导入batch作业的监听
*  
* @author laody 
* @date 2018年1月16日
*/
public class ExcelImportListener implements JobExecutionListener {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public void beforeJob(JobExecution jobExecution) {
		
		logger.info("-----------开始导入");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		logger.info("-----------导入完毕");

	}

}
