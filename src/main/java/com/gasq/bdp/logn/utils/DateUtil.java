package com.gasq.bdp.logn.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能说明：日期时间操作类
 */
public class DateUtil {
	private final static Logger logger = LoggerFactory.getLogger(DateUtil.class);
	public static Locale DEFAULT_LOCALE = Locale.CHINA;
	public static final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd";
	public static final String DATE_NO_FLAG_DATE_FORMAT = "yyyyMMdd";
	public static final String DATE_NO_FLAG_DATE_TIME_FORMAT = "yyyyMMddHHmmss";
	public static final String TIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_TIME_ALL = "yyyyMMdd-HHmmss";
	private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // 默认的日期格式
	private static final SimpleDateFormat dfForExcel = new SimpleDateFormat("MM/dd/yyyy"); // 默认的日期格式
	private static final SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 默认的时间格式

	/**
	 * 
	 * 方法描述：把日期字符串转换为Date类型的日期，如把"2011-11-16"转换后为Wed Nov 16 00:00:00 CST 2011
	 * 
	 * @param str
	 * @return Date
	 */
	public static Date parseStr(String str) {
		SimpleDateFormat format = new SimpleDateFormat(DATE_DEFAULT_FORMAT);
		try {
			return format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return new Date();
		}

	}

	/**
	 * 
	 * 方法描述：把日期字符串转换为Date类型的日期，如把"2011-11-16"转换后为Wed Nov 16 00:00:00 CST 2011
	 * 
	 * @param str
	 * @return Date
	 */
	public static Date parseStr(String str, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return new Date();
		}

	}

	/**
	 * 
	 * 
	 * @param str
	 * @return Date
	 */
	public static String getDateStr(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 
	 * 
	 * @param str
	 * @return Date
	 */
	public static String getDateStr(Date date) {
		String format = DATE_DEFAULT_FORMAT;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 
	 * 
	 * @param str
	 * @return Date
	 */
	public static String getDateTimeStr(Date date) {
		String format = TIME_DEFAULT_FORMAT;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 
	 * 
	 * @param str
	 * @return Date
	 */
	public static String getDateStr(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.format(new Date());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 
	 * 方法描述:date格式化为日期字符串（默认方法）
	 * 
	 * @param date
	 *            需要格式化的日期
	 * @return 按照yyyy-MM-dd格式化后的日期字符串
	 */
	public static String dateToString(Date date) {
		return dateToString(date, null, null);
	}

	/**
	 * 
	 * 方法描述:将date格式化为日期字符串
	 * 
	 * @param date
	 *            需要格式化的日期
	 * @param format
	 *            格式化字符串 形式。 如yyyy-MM-dd、yyyy-MM-dd HH:mm:ss
	 * @param locale
	 *            本地
	 * @return format格式化的日期字符串
	 */
	public static String dateToString(Date date, String format, Locale locale) {
		if (date == null)
			return "";
		if (locale == null)
			locale = DEFAULT_LOCALE;
		if (format == null)
			format = DATE_DEFAULT_FORMAT;
		SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
		return sdf.format(date);
	}

	/**
	 * 
	 * 方法描述:date格式化为时间字符串（默认方法）
	 * 
	 * @param date
	 *            需要格式化的日期
	 * @return 按照yyyy-MM-dd HH:mm:ss格式化后的日期字符串
	 */
	public static String timeToString(Date date) {
		return timeToString(date, null, null);
	}

	/**
	 * 
	 * 方法描述:将date格式化为时间字符串
	 * 
	 * @param date
	 *            需要格式化的日期
	 * @param format
	 *            格式化字符串 形式。 如yyyy-MM-dd、yyyy-MM-dd HH:mm:ss
	 * @param locale
	 *            本地
	 * @return format格式化后的时间字符串
	 */
	public static String timeToString(Date date, String format, Locale locale) {
		if (date == null)
			return "";
		if (locale == null)
			locale = DEFAULT_LOCALE;
		if (format == null)
			format = TIME_DEFAULT_FORMAT;
		SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
		return sdf.format(date);
	}

	/**
	 * 
	 * 方法描述:将date格式为时间字符串 eg:2010-04-20 08：01：10
	 * 
	 * @param date
	 *            需要格式化的日期
	 * @return 按照yyyy-MM-dd HH:mm:ss格式化后的时间字符串
	 */
	public static String formatTime(Date date) {
		return time.format(date);
	}

	/**
	 * 
	 * 方法描述:将日期字符串解析为date
	 * 
	 * @param source
	 *            被解析的日期字符串"yyyy-MM-dd"
	 * @return date yyyy-MM-dd
	 */
	public static java.sql.Date praseSqlDate(String source) {
		try {
			return new java.sql.Date(df.parse(source).getTime());
		} catch (ParseException e) {
			logger.error("不能转换成日期的字符串 :: " + source, e);
			return null;
		}
	}

	/**
	 * 
	 * 方法描述:将日期字符串解析为date
	 * 
	 * @param source
	 *            被解析的日期字符串，格式如下： MM/dd/yyyy
	 * @return date 格式如下：yyyy-MM-dd
	 */
	public static java.sql.Date praseSqlDateForExcel(String source) {
		try {
			return new java.sql.Date(dfForExcel.parse(source).getTime());
		} catch (ParseException e) {
			logger.error("不能转换成日期的字符串 :: " + source, e);
			return null;
		}
	}

	/**
	 * 
	 * 方法描述:将时间字符串解析为date
	 * 
	 * @param source
	 *            被解析的时间字符串， 格式为：yyyy-MM-dd HH:mm:ss
	 * @return date，格式如下：yyyy-MM-dd
	 */
	public static java.sql.Date praseSqlTime(String source) {
		try {
			return new java.sql.Date(time.parse(source).getTime());
		} catch (ParseException e) {
			logger.error("不能转换成日期的字符串 :: " + source, e);
			return null;
		}
	}

	/**
	 * 
	 * 方法描述：时间类型转换 Date to Calendar
	 * 
	 * @param date
	 * @return Calendar
	 */
	public static Calendar dateToCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;

	}

	/**
	 * 
	 * 方法描述：时间类型转换 String to Calendar
	 * 
	 * @param date
	 * @return Calendar
	 */
	public static Calendar strToCalendar(String time) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(time);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;

	}

	/**
	 * 功能函数说明：将Calendar按需转成字符串
	 * 
	 * @author
	 * @created 2014-5-26 下午6:03:52
	 * @updated
	 * @param calendar
	 * @param format
	 * @return
	 */
	public static String CalendarToString(Calendar calendar, String format) {
		if (StringUtils.isBlank(format)) {
			format = DATE_DEFAULT_FORMAT;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(calendar.getTime());
	}

	/**
	 * 
	 * 方法描述：时间类型转换 String to Calendar
	 * 
	 * @param date
	 * @return Calendar
	 */
	public static Calendar strToCalendar(String time, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = sdf.parse(time);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;

	}

	/**
	 * 
	 * 方法描述:获得当前月
	 * 
	 * @return String 当前月字符串 1-9的范围内增加了0前缀
	 */
	public static String getCurrentMonth() {
		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH) + 1;
		if (month == 13)
			month = 12;
		String monthstr = month + "";
		if (monthstr.length() == 1) {
			monthstr = "0" + month;
		}
		return monthstr.toString();
	}

	/**
	 * 
	 * 方法描述:获得当前年 字符串
	 * 
	 * @return 当前年字符串
	 */
	public static String getCurrentYear() {
		Calendar cal = new GregorianCalendar();
		int year = cal.get(Calendar.YEAR);
		return String.valueOf(year);
	}

	/**
	 * 
	 * 方法描述:获得当前日期字符串 yyyy-mm-dd
	 * 
	 * @return 当前日期字符串，格式为：yyyy-mm-dd
	 */
	public static String getCurrentDate() {
		Date b = new Date();
		String date = "";
		try {
			date = df.format(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 
	 * 方法描述:获得当前日期字符串 yyyy-mm-dd HH:mm:dd
	 * 
	 * @return 当前日期字符串，格式为：yyyy-mm-dd HH:mm:dd
	 */
	public static String getAllCurrentDate() {
		Date b = new Date();
		String date = "";
		try {
			df.applyPattern("yyyy-MM-dd HH:mm:ss");
			date = df.format(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 
	 * 方法描述:获得当前日期字符串mm/dd/yyyy
	 * 
	 * @return 当前日期字符串，格式为：mm/dd/yyyy
	 */
	public static String getCurrentDateForExcel(String format) {
		Date b = new Date();
		String date = "";
		try {
			date = dfForExcel.format(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 
	 * 方法描述:获取系统当前时间,格式为： Mon Nov 14 11:08:10 CST 2011
	 * 
	 * @return Date 系统当前时间
	 */
	public static Date getSysCurrentDate() {
		return new Date(System.currentTimeMillis());
	}

	/***
	 * 
	 * 方法描述：得到两个日期间相差的月数
	 * 
	 * @param beginDate
	 *            开始时间, 格式为：yyyy-mm-dd
	 * @param endDate
	 *            结束时间, 格式为：yyyy-mm-dd
	 * @return 两个日期间相差的月
	 * @throws ParseException
	 */
	public static int getDistanceMonth(String beginDate, String endDate) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(DATE_DEFAULT_FORMAT);
		Date bDate = format.parse(beginDate);
		Date eDate = format.parse(endDate);
		return getDistanceMonth(bDate, eDate);
	}

	/***
	 * 
	 * 方法描述：得到两个日期间相差的月数
	 * 
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @param dateFmt
	 *            日期格式：如yyyy-mm-dd,mm/dd/yyyy
	 * @return 两个日期间相差的月数
	 * @throws ParseException
	 */
	public static int getDistanceMonth(String beginDate, String endDate, String dateFmt) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(dateFmt);
		Date bDate = format.parse(beginDate);
		Date eDate = format.parse(endDate);
		return getDistanceMonth(bDate, eDate);
	}

	/***
	 * 
	 * 方法描述：得到两个日期间相差的月数
	 * 
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return 两个日期间相差的月数
	 * @throws ParseException
	 */
	public static int getDistanceMonth(Date beginDate, Date endDate) throws ParseException {
		int result = 0;
		Calendar d1 = new GregorianCalendar();
		d1.setTime(beginDate);
		Calendar d2 = new GregorianCalendar();
		d2.setTime(endDate);
		int y2 = d2.get(Calendar.YEAR);
		if (d1.get(Calendar.YEAR) <= y2) {
			result = d2.get(Calendar.MONTH) - d1.get(Calendar.MONTH);
			while (d1.get(Calendar.YEAR) != y2) {
				result += 12;
				d1.add(Calendar.YEAR, 1);
			}
		} else {
			result = d2.get(Calendar.MONTH) - d1.get(Calendar.MONTH);
			while (d1.get(Calendar.YEAR) != y2) {
				result -= 12;
				d1.add(Calendar.YEAR, -1);
			}
		}
		return result;
	}

	/**
	 * 方法描述:转换结束时间，例如2012-5-17 00:00:00转换为2012-5-17 23:59:59
	 * 
	 * @param endTimeOld
	 *            老的结束时间
	 */
	public static void convertEndTime(Calendar endTimeOld) {
		endTimeOld.set(Calendar.HOUR, 23);
		endTimeOld.set(Calendar.MINUTE, 59);
		endTimeOld.set(Calendar.SECOND, 59);
	}

	/**
	 * 方法描述:转换结束时间，例如2012-5-17 00:00:00转换为2012-5-17 23:59:59
	 * 
	 * @param endTimeOld
	 *            老的结束时间
	 */
	public static void convertStartTime(Calendar endTimeOld) {
		endTimeOld.set(Calendar.HOUR, 0);
		endTimeOld.set(Calendar.MINUTE, 0);
		endTimeOld.set(Calendar.SECOND, 0);
	}

	/**
	 * 方法描述:转换结束时间，例如2012-5-17 00:00:00转换为2012-5-17 23:59:59
	 * 
	 * @param endTimeOld
	 *            老的结束时间
	 */
	public static Date convertDateEndTime(Date endTimeOld) {
		Calendar newDate = dateToCalendar(endTimeOld);
		convertEndTime(newDate);
		return newDate.getTime();
	}

	/**
	 * 拼接日期 如果天不写默认为传入月份中最后一天
	 * 
	 * @param year
	 * @param month
	 * @param date
	 * @param b
	 *            为true时 返回月份中的最后一天，false：为第一天
	 * @return
	 */
	public static Date concatDate(Integer year, Integer month, Integer date, boolean b) {
		Calendar c = Calendar.getInstance();
		if (date == null || date <= 0) {
			c.set(Calendar.YEAR, year);
			c.set(Calendar.MONTH, month - 1);
			int lastDay = 0;
			if (b) {
				lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
			} else {
				lastDay = c.getActualMinimum(Calendar.DAY_OF_MONTH);
			}
			c.set(Calendar.DATE, lastDay);
		} else {
			c.set(year, month - 1, date);
		}
		return c.getTime();
	}

	public static Object getDateStr1(String value) {
		String format = DATE_DEFAULT_FORMAT;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(value);
			return sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Object getDateTimeStr(String value) {
		String format = TIME_DEFAULT_FORMAT;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(value);
			return sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取当前日期其他的日期
	 * 
	 * @param difdate
	 *            天数 正数：在当前时间之上添加的天数 ，负数反之
	 * @return
	 */
	public static String getDiyStrDateTime(int difdate) {
		Date date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, difdate);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_DEFAULT_FORMAT);
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * 获取当前日期其他的日期
	 * 
	 * @param difdate
	 *            天数 正数：在当前时间之上添加的天数 ，负数反之
	 * @param format
	 *            返回格式 eg DateUtil.DATE_DEFAULT_FORMAT
	 * @return
	 */
	public static String getDiyStrDateTime(int difdate, String format) {
		Date date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, difdate);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dateString = formatter.format(date);
		return dateString;
	}
	
	
	public static int getWeekOfDay(Date date){
		Calendar c= Calendar.getInstance();
		c.setTime(date);
		int weekday = c.get(Calendar.DAY_OF_WEEK);
		int rs=1;
		switch (weekday) {
		case 1:
			rs=7;
			break;
		case 2:
			rs=1;
			break;
		case 3:
			rs=2;
			break;
		case 4:
			rs=3;
			break;
		case 5:
			rs=6;
			break;
		case 6:
			rs=7;
			break;
		default:
			rs=-1;
			break;
		}
		return rs;
	}
}
