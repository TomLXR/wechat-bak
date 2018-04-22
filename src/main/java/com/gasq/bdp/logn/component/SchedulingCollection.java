package com.gasq.bdp.logn.component;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import com.gasq.bdp.logn.config.ExcelImportJob;
import com.gasq.bdp.logn.config.RunTimeContainer;
import com.gasq.bdp.logn.service.MergeScoreService;
import com.gasq.bdp.logn.utils.ExcelUtil;
import com.gasq.bdp.logn.utils.FileSystemUtil;

/**
 * 定时任务配置类 调度类
 */
@Component
@Import(value={ExcelImportJob.class})
@EnableBatchProcessing
public class SchedulingCollection {
	
	@Autowired
	private RunTimeContainer runTimeContainer;
	@Autowired
	private FileSystemUtil fileSystemUtil;
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private MergeScoreService  mergeScoreService;
	@Autowired
	private JobBuilderFactory  jobBuilderFactory;
	@Autowired
	private StepBuilderFactory  stepBuilderFactory;
	@Autowired
	private JobLauncher  jobLauncher;
	
	
	
	@Autowired
	private Job job;
	// @Scheduled(cron = "0 0/5 * * * ?") // 每天1点执行
	 public String doCountOrderCost() {
	 logger.info("---------------微信积分同步开始--------------");
	
	 mergeScoreService.merge();
	 return "server is closed!";
	 }
	 
	 
	/* @Scheduled(cron = "0/15 * * * * ?") */ 
	    //@Scheduled(cron = "0 0 1 * * *") // 每天1点执行
	 public String doImportExcelData() {
	 logger.info("---------------导入excel开始--------------");
/*	 List<File> dir = fileSystemUtil.dirDerictory(fileSystemUtil.getImportPath());
	 if(dir!=null&&dir.size()>0){
		 for(File file:dir){
			 //文件的名称
			 String fileName=file.getName();
			 //文件的后缀
			String extension= file.getName().substring(fileName.lastIndexOf(".")+1,fileName.length());
			if(fileName.endsWith(".xls")||fileName.endsWith(".xlsx")){
				Workbook wb;
				try {
					wb = ExcelUtil.getWorkBook(extension,new FileInputStream(file));
				} catch (IOException e) {
					 logger.info("---------------"+e.getMessage());
					continue;
				}
				Sheet sheet = wb.getSheetAt(0);
				printSheet(sheet);
				// 以后添加自定的数据持久化逻辑  BeanAccessorUtil step 根据 此类获取容器中的类实例
				

			}
		 }
	 }*/
	 try {
		jobLauncher.run(job,new JobParametersBuilder().toJobParameters());
	} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
			| JobParametersInvalidException e) {

		if(logger.isDebugEnabled()){
			logger.info("----------"+e.getMessage());
		}
	}
	 	
	 return "server is closed!";
	 }

	 public void printSheet(Sheet sheet){
			int rowCount=sheet.getPhysicalNumberOfRows();
			int columnCount=0;
			Row row;
			Cell cell;
			if(rowCount>0){
				for(int i=0;i<rowCount;i++){
					row = sheet.getRow(i);
					columnCount=row.getPhysicalNumberOfCells();
					for(int j=0;j<columnCount;j++){
						cell= row.getCell(j);
						System.out.println(ExcelUtil.getCellValue(cell));
					}
				}
			}
	 }
}