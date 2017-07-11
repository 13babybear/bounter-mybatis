package com.bounter.mybatis.extension;

/**
 * 基于ThreadLocal实现的动态数据源容器，保证DynamicDataSource的线程安全性
 * @author simon
 *
 */
public class DynamicDataSourceHolder {
	
	private static final ThreadLocal<String> dataSourceHolder = new ThreadLocal<>();
	
	public static void setDataSource(String dataSourceKey) {
		dataSourceHolder.set(dataSourceKey);
	}

	public static String getDataSource() {
		return dataSourceHolder.get();
	}

	public static void clearDataSource() {
		dataSourceHolder.remove();
	}
}
