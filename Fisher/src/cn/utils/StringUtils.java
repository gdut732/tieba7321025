package cn.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringUtils {
	/**
	 * 判断字符串是否不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str){
		if(str!=null && !str.isEmpty()){
			return true;
		}
		return false;
	}
	/**
	 * 将字符串转换为Integer
	 * @param str      要转换的字符串
	 * @param defValue 如果转换失败返回的默认值
	 * @return
	 */
	public static Integer str2Integer(String str,Integer defValue){
		if(isNotNull(str)){
			try {
				return new Integer(str);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return defValue;
	}
	
	/**
	 * 将字符串转换为Double
	 * @param str      要转换的字符串
	 * @param defValue 如果转换失败返回的默认值
	 * @return
	 */
	public static Double str2Double(String str,Double defValue){
		if(isNotNull(str)){
			try {
				return new Double(str);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return defValue;
	}
	
	/**
	 * 将字符串转换为java.sql.Date
	 * @param str      要转换的字符串
	 * @param defValue 如果转换失败返回的默认值
	 * @return
	 */
	public static java.sql.Date str2DateBySql(String str
			,String pattern,java.util.Date defValue
			,boolean isThrow){
		if(isNotNull(str)){
			String pat="yyyy-MM-dd";
			if(isNotNull(pattern)) pat=pattern;
			SimpleDateFormat sf=new SimpleDateFormat(pat);
			try {
				java.util.Date date=sf.parse(str);
				return new java.sql.Date(date.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				if(isThrow) throw new RuntimeException(e.getMessage());
			}
		}
		return new java.sql.Date(defValue.getTime());
	}
}
