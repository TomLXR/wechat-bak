package com.gasq.bdp.logn.component;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gasq.bdp.logn.utils.ConfigUtil;
/**  
* 类说明   
*  
* @author laody 
* @date 2018年2月5日
*/
@Aspect
@Component
public class AccessIntecepter {
	public static final Log logger = LogFactory.getLog(AccessIntecepter.class);
	public static final String errorUrl="redirect:/error";
	public static final Map<String, String> AccessUrl=new HashMap<>();
	static {
		// 允许进入的页面url 配置
		AccessUrl.put("/error","y" );
		AccessUrl.put("/success","y" );
		AccessUrl.put("/accessopenId","y" );
		AccessUrl.put("/gotoregist","y" );

	}
	
	@Pointcut("@within(org.springframework.stereotype.Controller)")
	private void anyMethod() {
	}// 定义一个切入点

	/**用戶日志记录前置
	 * @param joinPoint
	 */
	@Before("anyMethod() && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void before(JoinPoint joinPoint) {
		if(logger.isDebugEnabled()){
			logger.info("-------进入了控制器方法");
		}
	}

	
	public HttpServletRequest getRequest(){
		
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	} 
	
	
	
	public HttpServletResponse  getResponse(){
		
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
	} 
    /**
     * 用戶日志记录环绕
     * @param joinPoint
     * @return
     */
    @Around("anyMethod() && @annotation(org.springframework.web.bind.annotation.RequestMapping) ")
       public Object around(JoinPoint joinPoint){

  	
  	  	 Object o=null;

          
/*          try {

        	  if(StringUtils.isEmpty(AccessUrl.get("dispatchurl")) ||  !AccessUrl.get(dispatchurl).equals("y")){
        		  	if(session.getAttribute("user")==null){
        		  		o=((ProceedingJoinPoint) joinPoint).proceed();
        		  		o="gotoregist";
        		  	}else{
        		  		o=((ProceedingJoinPoint) joinPoint).proceed();
        		  	}
        	  }else{
        		  o=((ProceedingJoinPoint) joinPoint).proceed();
        	  }
        	  
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

         try {
			o=((ProceedingJoinPoint) joinPoint).proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           return o;
       }
	
	
	/**用戶日志记录后置
	 * @param joinPoint
	 * @throws IOException 
	 */
	@After("anyMethod() && @annotation(org.springframework.web.bind.annotation.RequestMapping) ")
	public void doAfter(JoinPoint joinPoint) throws IOException {

		if(logger.isDebugEnabled()){


			logger.info("------完成了服务接口请求-----");
			
			
		}
		
		
	 	
	}

	
	
	
	
}
