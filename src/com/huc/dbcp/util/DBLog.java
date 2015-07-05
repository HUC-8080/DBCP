/**
 * <p>Title: DBLog.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: </p>
 * @author 马金健
 * @date 2015年2月15日
 * @version 
 */
package com.huc.dbcp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 马金健
 *
 */
public class DBLog {
	
	/**
	 * <p>Project: DBCP</p>
	 * <p>Package: com.huc.dbcp.util</p>
	 * <p>Title: out</p>
	 * <p>Description: </p>
	 * <p>@param </p>
	 * <p>@return String</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date 2015年2月15日 下午7:16:31
	 * @version 
	 */
	public static void out(String className,String message){
		System.out.println("[ "+ className + " " + genericTime() +" ]" + message);
	}
	
//	/**
//	 * <p>Project: DBCP</p>
//	 * <p>Package: com.huc.dbcp.util</p>
//	 * <p>Title: out</p>
//	 * <p>Description: </p>
//	 * <p>@param </p>
//	 * <p>@return String</p>
//	 * @author 马金健
//	 * @since JDK 1.7.55 
//	 * @date 2015年2月15日 下午7:16:36
//	 * @version 
//	 */
//	public static String out(String className,String...strings){
//		return null;
//	}
	
	/**
	 * <p>Project: DBCP</p>
	 * <p>Package: com.huc.dbcp.util</p>
	 * <p>Title: genericTime</p>
	 * <p>Description: </p>
	 * <p>@param </p>
	 * <p>@return String</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date 2015年2月15日 下午7:16:39
	 * @version 
	 */
	private static String genericTime(){
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD dd:hh:ss");
		return format.format(new Date());
	}
}
