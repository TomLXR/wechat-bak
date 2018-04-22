package com.gasq.bdp.logn.utils;

import java.lang.annotation.Annotation;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**  
* 类说明    bean的获取类
*  
* @author laody 
* @date 2018年1月16日
*/
@Component
public class BeanAccessorUtil  implements ApplicationContextAware{
	private static ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		BeanAccessorUtil.applicationContext=applicationContext;
		
	}
	


	/**根据bean id 获取bean 实例
	 * @param id
	 * @return
	 */
	public static Object getBean(String id){
		return applicationContext.getBean(id);
	}

	
	/**根据bean 类型 获取bean 实例
	 * @param clazz
	 * @return
	 */
	public static Object getBean(Class<?> clazz){
		return applicationContext.getBean(clazz);
	}
	
	
	/**根据注解获取bean实例
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getBeansWithAnnotation(Class<?> clazz){
		return applicationContext.getBeansWithAnnotation(((Class<? extends Annotation>) clazz));
	}
	

	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getBeansOfType(Class<?> clazz){
		return (Map<String, Object>) applicationContext.getBeansOfType(clazz);
	}
}
