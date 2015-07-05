/**
 * <p>Title: DSConfigBean.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: </p>
 * @author 马金健
 * @date 2015年2月15日
 * @version 
 */
package com.huc.dbcp.util;

/**
 * @author 马金健
 *
 */
public class DSConfigBean {
	
	private String type;
	private String name;
	private String driver;
	private String url;
	private String username;
	private String password;
	private int maxConn;
	/**
	 * <p>Project: DBCP</p>
	 * <p>Package: com.huc.dbcp.util</p>
	 * <p>Title: </p>
	 * <p>Description: </p>
	 * <p>@Param </p>
	 * <p>@return </p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date 2015年2月15日 下午5:15:06
	 * @version 
	 */
	public DSConfigBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * <p>Project: DBCP</p>
	 * <p>Package: com.huc.dbcp.util</p>
	 * <p>Title: </p>
	 * <p>Description: </p>
	 * <p>@Param </p>
	 * <p>@return </p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date 2015年2月15日 下午5:15:09
	 * @version 
	 */
	public DSConfigBean(String type, String name, String driver, String url,
			String username, String password, int maxConn) {
		super();
		this.type = type;
		this.name = name;
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
		this.maxConn = maxConn;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DSConfigBean [type=" + type + ", name=" + name + ", driver="
				+ driver + ", url=" + url + ", username=" + username
				+ ", password=" + password + ", maxConn=" + maxConn + "]";
	}
	
	
}
