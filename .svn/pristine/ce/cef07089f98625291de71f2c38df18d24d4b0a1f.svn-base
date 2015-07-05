/**
 * <p>Title: DBConnectionManager.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: </p>
 * @author 马金健
 * @date 2015年2月15日
 * @version 
 */
package com.huc.dbcp.util;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/**
 * @author 马金健
 *
 */
public class DBConnectionManager {
	private static DBConnectionManager instance;
//	private static int clients;
	private List<DSConfigBean> drivers = new ArrayList<DSConfigBean>();
	private DBConnectionPool pool;
	private ParseConfig config;
	private Hashtable<String,DBConnectionPool> pools = new Hashtable<String,DBConnectionPool>();
	private Connection connection;
	
	/**
	 * <p>Project: DBCP</p>
	 * <p>Package: com.huc.dbcp.util</p>
	 * <p>Title: </p>
	 * <p>Description: </p>
	 * <p>@Param </p>
	 * <p>@return </p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date 2015年2月15日 下午6:24:08
	 * @version 
	 */
	private DBConnectionManager(){
		this.init();
	}
	
	/**
	 * <p>Project: DBCP</p>
	 * <p>Package: com.huc.dbcp.util</p>
	 * <p>Title: getInstance</p>
	 * <p>Description: </p>
	 * <p>@param </p>
	 * <p>@return DBConnectionManager</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date 2015年2月15日 下午6:25:46
	 * @version 
	 */
	public static synchronized DBConnectionManager getInstance(){
		if(instance == null){
			instance = new DBConnectionManager();
		}
		DBLog.out("DBConnectionManager", "创建数据库连接池实例成功");
		return instance;
	}
	
	/**
	 * <p>Project: DBCP</p>
	 * <p>Package: com.huc.dbcp.util</p>
	 * <p>Title: loadDrivers</p>
	 * <p>Description: 装载数据库连接池配置</p>
	 * <p>@param </p>
	 * <p>@return void</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date 2015年2月15日 下午6:55:54
	 * @version 
	 */
	private void loadDrivers(){
		config = new ParseConfig();
		drivers = config.readConfigInfo("ds.config.xml");
		DBLog.out(this.getClass().getSimpleName(), "装载数据库连接池配置文件");
	}
	
	/**
	 * <p>Project: DBCP</p>
	 * <p>Package: com.huc.dbcp.util</p>
	 * <p>Title: init</p>
	 * <p>Description: </p>
	 * <p>@param </p>
	 * <p>@return void</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date 2015年2月15日 下午6:26:11
	 * @version 
	 */
	public synchronized void init(){
		this.loadDrivers();
		for(DSConfigBean bean : drivers){
			this.createPool(bean);
		}
		DBLog.out(this.getClass().getSimpleName(), "初始化数据库连接池");
	}
	
	/**
	 * <p>Project: DBCP</p>
	 * <p>Package: com.huc.dbcp.util</p>
	 * <p>Title: createPool</p>
	 * <p>Description: 创建数据库连接池</p>
	 * <p>@param </p>
	 * <p>@return void</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date 2015年2月15日 下午6:53:14
	 * @version 
	 */
	public void createPool(DSConfigBean bean){
		this.pool = new DBConnectionPool();
		
		this.pool.setName(bean.getName());
		this.pool.setType(bean.getType());
		this.pool.setDriver(bean.getDriver());
		this.pool.setUrl(bean.getUrl());
		this.pool.setUsername(bean.getUsername());
		this.pool.setPassword(bean.getPassword());
		this.pool.setMaxConn(bean.getMaxConn());
		
		this.pools.put(bean.getName(), this.pool);
		DBLog.out(this.getClass().getSimpleName(), "创建数据库连接池");
	}
	
	/**
	 * <p>Project: DBCP</p>
	 * <p>Package: com.huc.dbcp.util</p>
	 * <p>Title: freeConnection</p>
	 * <p>Description: 释放指定数据库连接</p>
	 * <p>@param </p>
	 * <p>@return void</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date 2015年2月15日 下午7:03:13
	 * @version 
	 */
	public void freeConnection(String name,Connection connection){
		this.pool = (DBConnectionPool) this.pools.get(name);
		if(this.pool != null){
			this.pool.freeConnection(connection);
		}
		DBLog.out(this.getClass().getSimpleName(), "释放数据库连接");
	}
	
	/**
	 * <p>Project: DBCP</p>
	 * <p>Package: com.huc.dbcp.util</p>
	 * <p>Title: getConnection</p>
	 * <p>Description: 取得指定连接池的连接</p>
	 * <p>@param </p>
	 * <p>@return Connection</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date 2015年2月15日 下午7:04:55
	 * @version 
	 */
	public Connection getConnection(String name){
		this.pool = (DBConnectionPool) this.pools.get(name);
		this.connection = this.pool.getConnection();
		DBLog.out(this.getClass().getSimpleName(), "取得数据库连接");
		return this.connection;
	}
	
	/**
	 * <p>Project: DBCP</p>
	 * <p>Package: com.huc.dbcp.util</p>
	 * <p>Title: getConnection</p>
	 * <p>Description: </p>
	 * <p>@param </p>
	 * <p>@return Connection</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date 2015年2月15日 下午7:07:52
	 * @version 
	 */
	public Connection getConnection(String name,long timeout){
		this.pool = (DBConnectionPool) this.pools.get(name);
		this.connection = this.pool.getConnection(timeout);
		DBLog.out(this.getClass().getSimpleName(), "取得数据库连接");
		return this.connection;
	}
	
	/**
	 * <p>Project: DBCP</p>
	 * <p>Package: com.huc.dbcp.util</p>
	 * <p>Title: release</p>
	 * <p>Description: </p>
	 * <p>@param </p>
	 * <p>@return void</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date 2015年2月15日 下午7:08:27
	 * @version 
	 */
	public synchronized void release(){
		Enumeration<DBConnectionPool> connectionPools = this.pools.elements();
		while(connectionPools.hasMoreElements()){
			this.pool = connectionPools.nextElement();
			if(this.pool != null){
				this.pool.release();
			}
		}
		DBLog.out(this.getClass().getSimpleName(), "清空数据库连接池");
		this.pools.clear();
	}
}
