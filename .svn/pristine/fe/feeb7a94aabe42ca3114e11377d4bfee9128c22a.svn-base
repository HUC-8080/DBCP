/**
 * <p>Title: Test.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: </p>
 * @author 马金健
 * @date 2015年2月15日
 * @version 
 */
package com.huc.dbcp.util;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author 马金健
 *
 */
public class Test {

	public static void main(String[] args) {
		DBConnectionManager manager = DBConnectionManager.getInstance();
		Connection connection = manager.getConnection("oracle");
		if(connection != null){
			DBLog.out("Test", "数据库连接成功");
		}
		String sql = "SELECT * FROM TB_USER";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			while(set.next()){
				int id = set.getInt("id");
				String username = set.getString("name");
				String password = set.getString("password");
				System.out.println("id:"+id+" username:"+username+" password:"+password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
