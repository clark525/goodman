package com.hangc.goodman.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 配置项加载类
 * 
 * @author pengdingqi, wuhang
 *
 */
public class ConfUtil {

	public static final String CONF_FILE_NAME = "system.conf";

	public static final Properties properties = new Properties();

	static {
		loadData();
	}

	/**
	 * 获取配置项入口
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		return properties.getProperty(key);
	}

	private static String loadData() {
		String returnName = "";
		String path = ConfUtil.class.getClassLoader().getResource("").getPath() + CONF_FILE_NAME;
		try (InputStreamReader in = new InputStreamReader(new FileInputStream(path), "utf-8")) {
			properties.load(in);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return returnName;
	}
	
}
