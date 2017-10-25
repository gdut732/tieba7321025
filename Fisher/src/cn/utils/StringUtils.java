package cn.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringUtils {
	/**
	 * �ж��ַ����Ƿ�Ϊ��
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
	 * ���ַ���ת��ΪInteger
	 * @param str      Ҫת�����ַ���
	 * @param defValue ���ת��ʧ�ܷ��ص�Ĭ��ֵ
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
	 * ���ַ���ת��ΪDouble
	 * @param str      Ҫת�����ַ���
	 * @param defValue ���ת��ʧ�ܷ��ص�Ĭ��ֵ
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
	 * ���ַ���ת��Ϊjava.sql.Date
	 * @param str      Ҫת�����ַ���
	 * @param defValue ���ת��ʧ�ܷ��ص�Ĭ��ֵ
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
