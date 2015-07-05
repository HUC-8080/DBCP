/**
 * <p>Title: DBConnectionPool.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: </p>
 * @author 马金健
 * @date 2015年2月15日
 * @version 
 */
package com.huc.dbcp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author 马金健
 *
 */
public class DBConnectionPool {
	
	private Connection connection = null;
	private List<Connection> freeConnections = new ArrayList<Connection>();
	private int inUsed = 0;
	private int minConn;
	private int maxConn;
	private String name;
	private String type;
	private String password;
	private String url;
	private String driver;
	private String username;
	
	public DBConnectionPool(){
		
	}
	
	/**
	 * @return the minConn
	 */
	public int getMinConn() {
		return minConn;
	}

	/**
	 * @param minConn the minConn to set
	 */
	public void setMinConn(int minConn) {
		this.minConn = minConn;
	}

	/**
	 * @return the maxConn
	 */
	public int getMaxConn() {
		return maxConn;
	}

	/**
	 * @param maxConn the maxConn to set
	 */
	public void setMaxConn(int maxConn) {
		this.maxConn = maxConn;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the driver
	 */
	public String getDriver() {
		return driver;
	}

	/**
	 * @param driver the driver to set
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}

	/**
	 * @return the user
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param user the user to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * <p>Project: DBCP</p>
	 * <p>Package: com.huc.dbcp.util</p>
	 * <p>Title: 创建数据库连接池</p>
	 * <p>Description: </p>
	 * <p>@Param name     连接池名称</p>
	 * <p>@Param driver   连接池驱动</p>
	 * <p>@Param url      连接池url</p>
	 * <p>@Param user     连接池用户名</p>
	 * <p>@Param password 连接池密码</p>
	 * <p>@Param maxConn  连接池最大连接数</p>
	 * <p>@return </p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date 2015年2月15日 下午4:08:43
	 * @version 
	 */
	public DBConnectionPool(String type,String name,String driver,String url,String username,String password,int maxConn){
		this.type = type;
		this.name = name;
		this.driver = driver;
		this.url = url; 
		this.username = username;
		this.password = password;
		this.maxConn = maxConn;
	}
	
	/**
	 * <p>Project: DBCP</p>
	 * <p>Package: com.huc.dbcp.util</p>
	 * <p>Title: freeConnection</p>
	 * <p>Description: 释放数据库连接对象，将数据库连接对象放入数据库连接池中</p>
	 * <p>@param connection 数据库连接对象</p>
	 * <p>@return void</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date 2015年2月15日 下午4:13:45
	 * @version 
	 */
	public synchronized void freeConnection(Connection connection){
		this.freeConnections.add(connection);
		this.inUsed--;
		DBLog.out(this.getClass().getSimpleName(), "释放数据库连接");
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
	 * @date 2015年2月15日 下午4:33:57
	 * @version 
	 */
	public synchronized Connection getConnection(long timeout){
		if(this.freeConnections.size() > 0){
			connection = this.freeConnections.get(0);
			if(connection == null){
				connection = getConnection(timeout);
			}
		}else{
			connection = newConnection();
		}
		if(this.maxConn == 0 || this.maxConn < this.inUsed){
			connection = null;
		}
		if(connection != null){
			this.inUsed++;
		}
		DBLog.out(this.getClass().getSimpleName(), "取得数据库连接");
		return connection;
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
	 * @date 2015年2月15日 下午4:37:38
	 * @version 
	 */
	public synchronized Connection getConnection(){
		if(this.freeConnections.size() > 0){
			connection = this.freeConnections.get(0);
			this.freeConnections.remove(0);
			if(connection == null){
				connection = getConnection();
			}
		}else{
			connection = newConnection();
		}
		if(this.maxConn == 0 || this.maxConn < this.inUsed){
			connection = null;
		}
		if(connection != null){
			this.inUsed++;
		}
		DBLog.out(this.getClass().getSimpleName(), "取得数据库连接");
		return connection;
	}
	
	/**
	 * <p>Project: DBCP</p>
	 * <p>Package: com.huc.dbcp.util</p>
	 * <p>Title: release</p>
	 * <p>Description: 释放全部连接</p>
	 * <p>@param </p>
	 * <p>@return void</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date 2015年2月15日 下午4:39:24
	 * @version 
	 */
	public synchronized void release(){
		for(Connection conn : this.freeConnections){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		DBLog.out(this.getClass().getSimpleName(), "清空数据库连接池");
		this.freeConnections.clear();
	}

	/**
	 * <p>Project: DBCP</p>
	 * <p>Package: com.huc.dbcp.util</p>
	 * <p>Title: newConnection</p>
	 * <p>Description: 创建新连接</p>
	 * <p>@param </p>
	 * <p>@return Connection</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date 2015年2月15日 下午4:18:32
	 * @version 
	 */
	private Connection newConnection() {
		// TODO Auto-generated method stub
		try {
			Class.forName(this.driver);
			this.connection = DriverManager.getConnection(this.url,this.username,this.password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBLog.out(this.getClass().getSimpleName(), "创建数据库连接成功");
		return this.connection;
	}
}
