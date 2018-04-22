package com.gasq.bdp.logn.utils;

import java.util.Map;
/**
 * @author laody
 *
 */
public class CacheContainer {
	private static ThreadLocal<String> openId=new ThreadLocal<String>();
	public static ThreadLocal<Map<String, Object>> token=new ThreadLocal<Map<String, Object>>();
	public static ThreadLocal<Map<String, Object>> jsapi=new ThreadLocal<Map<String, Object>>();
}
