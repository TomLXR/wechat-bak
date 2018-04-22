package com.gasq.bdp.logn.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtils {

	static ObjectMapper mapper = null;

	public static boolean is(Boolean b) {
		return b != null && b.booleanValue();
	}

	public static boolean isEmpty(Object v) {
		return isEmpty(v, true);
	}

	public static boolean isEmpty(Object v, boolean trim) {
		if (v == null)
			return true;
		if (v instanceof String) {
			String sv = (String) v;
			return trim ? sv.trim().length() == 0 : sv.length() == 0;
		} else {
			return false;
		}
	}

	public static String getArrayToString(String[] array, String split) {
		if (isEmpty(array))
			return "";
		String str = "";
		for (int i = 0; i < array.length; i++) {
			if (isEmpty(array[i]))
				continue;
			str += array[i] + split;
		}
		if (str.length() > 0)
			str = str.substring(0, str.length() - split.length());
		return str;
	}

	public static String createUUID() {
		return DigestUtils.md5DigestAsHex(createUUID(1).toString().getBytes());
	}

	public static String[] createUUID(int size) {
		if (size <= 0)
			return null;
		String uuids[] = new String[size];
		for (int i = 0; i < size; i++) {
			uuids[i] = UUID.randomUUID().toString();
		}
		return uuids;
	}

	/**
	 * 将字符串转换为数据库可执行的字符串 处理数据库字符串字段 eg:aaaaa/aaaaa,bbbbb
	 * 
	 * @param str
	 *            eg：123ace---->'123ace'
	 */
	public static String changeStrToSqlValue(String str, String tag) {
		if (str.length() <= 0)
			return null;
		if (str.indexOf(tag) != -1) {
			String[] s = str.split(tag);
			str = "";
			for (int i = 0; i < s.length; i++) {
				if (i == 0)
					str = "'" + s[i] + "'";
				else
					str += ",'" + s[i] + "'";
			}
		} else
			str = "'" + str + "'";
		return str;
	}

	/**
	 * 获取随机数
	 * 
	 * @param digit
	 *            位数
	 * @return
	 */
	public static String getRandomcode(int digit) {
		int max = 10;
		int min = 1;
		for (int i = 1; i < digit; i++) {
			max = max * 10;
			min = min * 10;
		}
		Random random = new Random();
		int s = random.nextInt(max) % (max - min + 1) + min;
		return s + "";
	}

	public static String encodeStr(String str) {
		try {
			return new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String BeanToJSON(Object obj) {
		String str = null;
		try {
			if (mapper == null) {
				mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			}
			str = mapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	public static Object JsonToBean(String jsonstr, Class<?> cls) {
		try {
			if (mapper == null) {
				mapper = new ObjectMapper();
			}
			return mapper.readValue(jsonstr, cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 两个数据相除 并保留两位小数
	 * 
	 * @param str1
	 * @param str2
	 * @return result
	 */
	public static String divideTempResult(String str1, String str2) {
		String temp = "0";
		try {
			if (StringUtils.isEmpty(str1) && StringUtils.isEmpty(str2)) {

				BigDecimal tempStr1 = new BigDecimal(str1);
				BigDecimal tempStr2 = new BigDecimal(str2);

				BigDecimal tempResult = tempStr1.divide(tempStr2, 2, BigDecimal.ROUND_HALF_UP);

				temp = tempResult + "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

	/**
	 * 加密 MD5
	 * 
	 * @param str
	 * @return
	 */
	public static String change2MD5(String str) {
		if (str == null || str.equals(""))
			return null;
		return DigestUtils.md5DigestAsHex(str.getBytes());
	}

	/**
	 * 解密 MD5
	 * 
	 * @param md5
	 * @param str
	 * @return
	 */
	public static Boolean MD5Check(String md5, String str) {
		if (md5 == null || md5.equals(""))
			return null;
		if (str == null || str.equals(""))
			return null;
		String newmd5 = DigestUtils.md5DigestAsHex(str.getBytes());
		if (md5.equals(newmd5))
			return true;
		return false;
	}

	/**
	 * 转换DOUBLE类型保留后几位小数
	 * 
	 * @param d
	 * @param subindex
	 * @return
	 */
	public static double transformDouble(double d, int subindex) {
		BigDecimal bd = new BigDecimal(d);
		double f1 = bd.setScale(subindex, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}

	/**
	 * 转换DOUBLE类型保留后几位小数
	 * 
	 * @param d
	 * @param subindex
	 * @return
	 */
	public static double transformStringToDouble(String strd, int subindex) {
		BigDecimal bd = new BigDecimal(strd);
		double f1 = bd.setScale(subindex, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}

	public static Map<String, Object> checkSqlEnable(String sql) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (isEmpty(sql)) {
			map.put("status", false);
			map.put("mssg", "语句不能为空！");
			return map;
		} else if (sql.toLowerCase().indexOf("drop") != -1 || sql.toLowerCase().indexOf("database") != -1 || sql.toLowerCase().indexOf("use") != -1 || sql.toLowerCase().indexOf("alter") != -1) {
			map.put("status", false);
			map.put("mssg", "此语句没有权限执行！");
			return map;
		} else {
			map.put("status", true);
			return map;
		}
	}

	public static void main(String[] args) {
		String text = "{rect1:{type:\"end\",text:{text:\"结束\"}, attr:{ x:385, y:317, width:100, height:50}, props:{text:{value:\"结束\"},temp1:{value:\"\"},temp2:{value:\"\"},temp3:{value:\"\"}}}}";
		// String json = "{states:{rect1:{type:'end',text:{text:'结束'}, attr:{
		// x:385, y:317, width:100, height:50},
		// props:{text:{value:'结束'},temp1:{value:'null'},temp2:{value:'null'},temp3:{value:'null'}}},rect2:{type:'start',text:{text:'开始'},
		// attr:{ x:384, y:10, width:101, height:50},
		// props:{text:{value:'开始'},temp1:{value:'null'},temp2:{value:'null'},temp3:{value:'null'}}},rect3:{type:'task',text:{text:'任务2'},
		// attr:{ x:384, y:209, width:103, height:50},
		// props:{text:{value:'任务2'},temp1:{value:'null'},temp2:{value:'null'},temp3:{value:'null'}}},rect4:{type:'task',text:{text:'任务1'},
		// attr:{ x:386, y:116, width:100, height:50},
		// props:{text:{value:'任务1'},temp1:{value:'null'},temp2:{value:'null'},temp3:{value:'null'}}}},paths:{path5:{from:'rect2',to:'rect4',
		// dots:[],text:{text:''},textPos:{x:37,y:-4},
		// props:{text:{value:''}}},path6:{from:'rect4',to:'rect3',
		// dots:[],text:{text:''},textPos:{x:56,y:-1},
		// props:{text:{value:''}}},path7:{from:'rect3',to:'rect1',
		// dots:[],text:{text:''},textPos:{x:24,y:-5},
		// props:{text:{value:''}}}},props:{props:{name:{value:'新建流程'},key:{value:''},desc:{value:''}}}}";
		Map<String, Object> map = (Map<String, Object>) CommonUtils.JsonToBean(text, Map.class);
		System.out.println(map.toString());
	}

}
