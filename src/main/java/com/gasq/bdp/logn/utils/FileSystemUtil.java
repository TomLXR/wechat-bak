package com.gasq.bdp.logn.utils;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**  
* 类说明   控制文件系统的工具类型
*  
* @author laody 
* @date 2018年1月16日
*/
@Configuration
@Component
public class FileSystemUtil{
	
	/**
	 * 文件被上传的目录
	 */
	@Value("${uploadPath}")
	public String uploadPath;

	
	/**
	 * 文件导入数据库的目录
	 */
	@Value("${importPath}")
	public String importPath;

	
	public String getUploadPath() {
		return uploadPath;
	}


	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}


	public String getImportPath() {
		return importPath;
	}


	public void setImportPath(String importPath) {
		this.importPath = importPath;
	}


	/**判断当前的文件系统
	 * @return
	 */
	public  boolean  isWindows(){
		String property = System.getProperty("os.name");
		if(StringUtils.contains(property, "Windows")) return true;
		return false;
	}


	/**dir 遍历调度目录
	 * @return
	 */
	public  List<File>  dirDerictory(String path){
		File dir=new File(path);
		if(!dir.exists()||!dir.isDirectory()){
			return null;
		}
		return Arrays.asList(dir.listFiles());

	}
	

}
