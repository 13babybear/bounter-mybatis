package com.bounter.mybatis.extension;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.bounter.mybatis.util.EncodeUtil;
import com.bounter.mybatis.util.SymmetricCryptoUtil;

/**
 * 自定义的Spring属性配置文件扩展类，用来实现加密属性解密
 * 加密方式：AES
 * @author simon
 *
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	//指定需要加密的属性
	private String[] propertyNames = {"db.master.password","db.slave.password"};

	/**
	 * 解密指定propertyName的属性值
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 */
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		//过滤出需要解密的属性
		for (String p : propertyNames) {
			if (p.equalsIgnoreCase(propertyName)) {
				try {
					//返回AES解密后的字符串
					return new String(SymmetricCryptoUtil.decryptAESWithDefaultKey(EncodeUtil.decodeBase64(propertyValue)));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return super.convertProperty(propertyName, propertyValue);
	}

}
