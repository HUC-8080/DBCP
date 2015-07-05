/**
 * <p>Title: ParseDataSource.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: </p>
 * @author 马金健
 * @date 2015年2月15日
 * @version 
 */
package com.huc.dbcp.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 * @author 马金健
 *
 */
public class ParseConfig {
	
	private List<DSConfigBean> configs;
	
	public ParseConfig(){
		
	}
	
	/**
	 * <p>Project: DBCP</p>
	 * <p>Package: com.huc.dbcp.util</p>
	 * <p>Title: readConfigInfo</p>
	 * <p>Description: 读取配置文件</p>
	 * <p>@param </p>
	 * <p>@return List<String></p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date 2015年2月15日 下午4:44:56
	 * @version 
	 */
	@SuppressWarnings("unchecked")
	public List<DSConfigBean> readConfigInfo(String path){
		String rpath = this.getClass().getResource("/").getPath().substring(1)+path;
		DBLog.out(this.getClass().getSimpleName(), "配置文件位置："+rpath);
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(rpath);
			configs = new ArrayList<DSConfigBean>();
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(inputStream);
			Element root = document.getRootElement();
			List<Element> pools = root.getChildren();
			for(Element pool : pools){
				DSConfigBean bean = new DSConfigBean();
				bean.setType(pool.getChild("type").getText());
				bean.setName(pool.getChild("name").getText());
				bean.setDriver(pool.getChild("driver").getText());
				bean.setUrl(pool.getChild("url").getText());
				bean.setUsername(pool.getChild("username").getText());
				bean.setPassword(pool.getChild("password").getText());
				bean.setMaxConn(Integer.parseInt(pool.getChild("maxConn").getText()));
				DBLog.out(this.getClass().getSimpleName(), "配置信息："+bean);
				configs.add(bean);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return configs;
	}
	
	public void modifyConfigInfo(String path,DSConfigBean bean){
//		String rpath = this.getClass().getResource("").getPath().substring(1)+path;
//		FileInputStream inputStream = null;
//		FileOutputStream outputStream = null;
		
	}
	
	/**
	 * <p>Project: DBCP</p>
	 * <p>Package: com.huc.dbcp.util</p>
	 * <p>Title: addConfigInfo</p>
	 * <p>Description: 添加数据库配置</p>
	 * <p>@param </p>
	 * <p>@return void</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date 2015年2月15日 下午6:00:50
	 * @version 
	 */
	@SuppressWarnings("unchecked")
	public void addConfigInfo(String path,DSConfigBean bean){
		String rpath = this.getClass().getResource("").getPath().substring(1)+path;
		DBLog.out(this.getClass().getSimpleName(), "配置文件位置："+rpath);
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(rpath);
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(inputStream);
			Element root = document.getRootElement();
			List<Element> pools = root.getChildren();
			
			Element newPool = new Element("pool");
			
			Element type = new Element("type");
			type.setText(bean.getType());
			newPool.addContent(type);
			
			Element name = new Element("name");
			name.setText(bean.getName());
			newPool.addContent(name);
			
			Element driver = new Element("driver");
			driver.setText(bean.getDriver());
			newPool.addContent(driver);
			
			Element url = new Element("url");
			url.setText(bean.getUrl());
			newPool.addContent(url);
			
			Element username = new Element("username");
			username.setText(bean.getUsername());
			newPool.addContent(username);
			
			Element password = new Element("password");
			password.setText(bean.getPassword());
			newPool.addContent(password);
			
			Element maxConn = new Element("maxConn");
			maxConn.setText(bean.getMaxConn()+"");
			newPool.addContent(maxConn);
			
			pools.add(newPool);
			
			Format format = Format.getPrettyFormat();
			format.setIndent("");
			format.setEncoding("utf-8");
			XMLOutputter outputter = new XMLOutputter(format);
			outputStream = new FileOutputStream(rpath);
			outputter.output(document, outputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * <p>Project: DBCP</p>
	 * <p>Package: com.huc.dbcp.util</p>
	 * <p>Title: removeConfigInfo</p>
	 * <p>Description: 删除数据库配置</p>
	 * <p>@param </p>
	 * <p>@return void</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date 2015年2月15日 下午6:11:55
	 * @version 
	 */
	@SuppressWarnings("unchecked")
	public void removeConfigInfo(String path,String type){
		String rpath = this.getClass().getResource("").getPath().substring(1)+path;
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(rpath);
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(inputStream);
			Element root = document.getRootElement();
			List<Element> pools = root.getChildren();
			
			for(Element pool : pools){
				if(pool.getChild("type").getText().equals(type)){
					pools.remove(pool);
					break;
				}
			}
			Format format = Format.getPrettyFormat();
			format.setIndent("");
			format.setEncoding("utf-8");
			XMLOutputter outputter = new XMLOutputter(format);
			outputStream = new FileOutputStream(rpath);
			outputter.output(document, outputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
