package com.bounter.mybatis.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.bounter.mybatis.extension.DynamicDataSourceHolder;

/**
 * 数据源切面，通过dao方法前缀决定访问读、写数据源
 * @author simon
 *
 */
@Component
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DataSourceAspect {
	
	//读库数据源key
	private static final String DATASOURCE_KEY_READ = "read";
	//查询方法清单
	String[] queryMethods = {"find","get","query","count","select"};
	
	/**
	 * dao层方法执行前选择数据源
	 * @param point
	 */
	@Before("execution(* com.bounter.mybatis.dao..*.*(..))")
	public void before(JoinPoint point) {
		// 获取到当前执行的方法名  
        String methodName = point.getSignature().getName();
        //匹配查询方法
        for(String queryMethod : queryMethods) {
        	if(methodName.startsWith(queryMethod)) {
        		//查询方法设置数据源为读库
        		DynamicDataSourceHolder.setDataSource(DATASOURCE_KEY_READ);
        		break;
        	}
        }
	}

	/**
	 * dao层方法执行完后清空数据源选择
	 * @param point
	 */
	@After("execution(* com.bounter.mybatis.dao..*.*(..))")
	public void after(JoinPoint point) {
		DynamicDataSourceHolder.clearDataSource();
	}
}
