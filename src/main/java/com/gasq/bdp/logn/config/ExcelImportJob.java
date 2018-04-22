package com.gasq.bdp.logn.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import com.gasq.bdp.logn.listener.ExcelImportListener;
import com.gasq.bdp.logn.utils.BeanAccessorUtil;
import com.gasq.bdp.logn.utils.ExcelUtil;
import com.gasq.bdp.logn.utils.FileSystemUtil;

/**  
* 类说明    excelimport 作业的job配置 springbatch 配置类
*  
* @author laody 
* @date 2018年1月16日
*/

@Configuration
@Component
@EnableBatchProcessing
public class ExcelImportJob implements LineCommand{
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private JobBuilderFactory  jobBuilderFactory;
	private StepBuilderFactory  stepBuilderFactory;
	private JobLauncher  jobLauncher;
	private FileSystemUtil fileSystemUtil;
	public JobBuilderFactory getJobBuilderFactory() {
		return jobBuilderFactory;
	}

	public void setJobBuilderFactory(JobBuilderFactory jobBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory;
	}

	public StepBuilderFactory getStepBuilderFactory() {
		return stepBuilderFactory;
	}

	public void setStepBuilderFactory(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory;
	}

	public JobLauncher getJobLauncher() {
		return jobLauncher;
	}

	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}

	public FileSystemUtil getFileSystemUtil() {
		return fileSystemUtil;
	}

	public void setFileSystemUtil(FileSystemUtil fileSystemUtil) {
		this.fileSystemUtil = fileSystemUtil;
	}

	public RunTimeContainer getRunTimeContainer() {
		return runTimeContainer;
	}

	public void setRunTimeContainer(RunTimeContainer runTimeContainer) {
		this.runTimeContainer = runTimeContainer;
	}

	private RunTimeContainer runTimeContainer;
	public ExcelImportJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			JobLauncher jobLauncher,FileSystemUtil fileSystemUtil,RunTimeContainer runTimeContainer) {
		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
		this.jobLauncher = jobLauncher;
		this.fileSystemUtil=fileSystemUtil;
		this.runTimeContainer=runTimeContainer;
	}
	
	@Bean
	public Runtime getRuntime(){
		return Runtime.getRuntime();  
	}
	
	@Bean
	public Job getExcelJob(){
		return jobBuilderFactory
				.get("importExcel")
				.start(getPrepareStep())
				.next(getImportStep())
				.listener(new ExcelImportListener())
				.build();
	}
	
	@Bean
	public Step getPrepareStep(){
		return stepBuilderFactory.get("prepare").allowStartIfComplete(true).tasklet((stepContribution , chunkContext)->{
			//FileSystemUtil fileSystemUtil = (FileSystemUtil) BeanAccessorUtil.getBean(FileSystemUtil.class);
			String[] reg=new String[]{"*.xls","*.xlsx"};
			String uploadPath = fileSystemUtil.getUploadPath();
			String importPath = fileSystemUtil.getImportPath();
			List<File> uploads = fileSystemUtil.dirDerictory(uploadPath);
			// 如果有数据文件就移动数据文件 到import 目录下面
			int exitCode=-1;
			if(uploads!=null&&uploads.size()>0){
				
				for(File file:uploads){
					file.renameTo(new File(importPath+File.separator+file.getName()));
				}
				//调用系统命令 如move 只能指定外部脚本 不方便
				//if(fileSystemUtil.isWindows()) exitCode=runTimeContainer.executeRegExpMove(MOVE_WINDOW, reg, uploadPath, importPath);
				//if(!fileSystemUtil.isWindows()) exitCode=runTimeContainer.executeRegExpMove(MOVE_LINUX, reg, uploadPath, importPath);


			}
/*			if(exitCode!=0){
				return RepeatStatus.CONTINUABLE;
			}*/
			return RepeatStatus.FINISHED;
		}).build();
	}
	
	
	@Bean
	public Step getImportStep(){
		return stepBuilderFactory.get("import").allowStartIfComplete(true).tasklet((stepContribution , chunkContext)->{
			 List<File> dir = fileSystemUtil.dirDerictory(fileSystemUtil.getImportPath());
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
						//printSheet(sheet);
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
						// 以后添加自定的数据持久化逻辑  BeanAccessorUtil step 根据 此类获取容器中的类实例
						

					}
				 }
			 }
			return RepeatStatus.FINISHED;
		}).build();
	}
}
