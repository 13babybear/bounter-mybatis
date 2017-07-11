package com.bounter.mybatis.extension;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 自定义的Spring 动态数据源扩展类,用来实现Master、Slave数据源动态切换
 * @author simon
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		//使用DynamicDataSourceHolder保证线程安全
		return DynamicDataSourceHolder.getDataSource();
	}

}
