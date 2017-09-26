package com.cg.frs.DbUtil;



import java.io.FileReader;
import java.io.IOException;

import java.sql.*;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
	public static Connection getConnection() throws IOException, SQLException
	{
		Connection conn=null;
		Properties prop=readdbInfo();
		String url=prop.getProperty("url");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		conn=DriverManager.getConnection(url,username,password);
		return conn;
	}

	private static Properties readdbInfo() throws IOException {
		
		Properties p=new Properties();
		FileReader fr=new FileReader("room.properties");
		p.load(fr);
		return p;
	}
}

