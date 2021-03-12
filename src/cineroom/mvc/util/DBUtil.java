package cineroom.mvc.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private static Properties proFile = new Properties();
	/**
	 * �ε�
	 */
	static {
		try {
			//�ܺ� properteis���� �ε��ϱ�
			proFile.load(new FileInputStream("resources/dbInfo.properties"));
			
			Class.forName(proFile.getProperty("driverName"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static Properties getProFile() {
		return proFile;
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				proFile.getProperty("url"),
				proFile.getProperty("userName"),
				proFile.getProperty("userPass"));
	}
	

	
	public static void dbClose(Connection con, Statement st) {
	  try {
		if(st!=null) st.close();
		if(con!=null) con.close();
	  }catch (SQLException e){
		  e.printStackTrace();
	  }
	 }
	
	
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			
			dbClose(con,st);
		  }catch (SQLException e){
			  e.printStackTrace();
		  }
	}
}
