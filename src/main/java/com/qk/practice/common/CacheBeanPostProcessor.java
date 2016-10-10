package com.qk.practice.common;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CacheBeanPostProcessor implements BeanPostProcessor {
	
	private static Logger logger = Logger.getLogger(CacheBeanPostProcessor.class);
 	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		logger.info("===Bean intialization: " + beanName);
		try {  
            if(bean instanceof CommonTimer) {   
            	((CommonTimer)bean).loadCache();
            }
        } catch (Exception e) {  
             e.printStackTrace();  
        }   
        return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		logger.info("===Bean after intialization: " + beanName);
		return null;
	}

}
