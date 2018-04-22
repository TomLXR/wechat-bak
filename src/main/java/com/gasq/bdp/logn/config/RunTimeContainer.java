package com.gasq.bdp.logn.config;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**  
* 类说明   命令行执行 工具类
*  
* @author laody 
* @date 2018年1月16日
*/
@Component
@Configuration
public class RunTimeContainer {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private Runtime runtime;
	@Bean
	public Runtime getRuntime() {
		return Runtime.getRuntime();
	}

	public int execute(String commond) throws IOException{
		int exitValue=-1;
		try {
			Process process =runtime.exec(commond);
			exitValue=process.exitValue();

		} catch (Exception e) {
			if(logger.isDebugEnabled()){
				logger.info("-------------"+commond+"   "+e.getMessage());
			}
		}
		return exitValue;
	}
	
	
	
	public int execute(String commond,String[] args){
		int exitValue=-1;
		try {
			for(int i=0;i<args.length;i++){
				String arg=args[i];
				arg=arg.replaceAll("/", File.separator);
				args[i]=arg;
			}
			Process process =runtime.exec(commond,args);
			exitValue=process.exitValue();
		} catch (Exception e) {
			if(logger.isDebugEnabled()){
				logger.info("-------------"+commond+" --"+String.join(",",args)+"  "+e.getMessage());
			}
			
		}
		return exitValue;
	}
	
	
	/**
	 * @param commond
	 * @param reg
	 * @param args
	 * @return
	 */
	public int executeRegExpMove(String commond,String[] reg,String sourcePath ,String descPath){
		try {
			Runtime.getRuntime().exec("notepad");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int exitValue=-1;
		if(!sourcePath.endsWith("/")){
			sourcePath+="/";
			if(File.separator.equals("\\")){
				sourcePath=sourcePath.replaceAll("/", "\\\\");
			}
			
		}
		if(!descPath.endsWith("/")){
			descPath+="/";
			
			if(File.separator.equals("\\")){
				descPath=descPath.replaceAll("/", "\\\\");
			}
			
		}
		try {
			for(int i=0;i<reg.length;i++){
				if(StringUtils.isEmpty(reg[i])){
					exitValue=0;
				}else{
					System.out.println(commond+"  "+String.join("  ", new String[]{sourcePath+reg[i],descPath}));
					if(File.separator.equals("\\")){
						System.out.println(commond+String.join(" ", (new String[]{" ","/-Y",sourcePath+reg[i],descPath})));
						exitValue=runtime.exec(commond+String.join(" ", (new String[]{" ","/-Y",sourcePath+reg[i],descPath}))).exitValue();
					}else{
						System.out.println(commond+String.join(" ",new String[]{" ","-f",sourcePath+reg[i],descPath}));
						exitValue=runtime.exec(commond+String.join(" ",new String[]{" ","-f",sourcePath+reg[i],descPath})).exitValue();
					}
					
				}
				
			}
			

		} catch (Exception e) {
			if(logger.isDebugEnabled()){
				logger.info("-------------"+commond+"  "+e.getMessage());
			}
			
		}
		return exitValue;
	}
	
}
