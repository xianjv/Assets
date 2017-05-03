package com.lxj.assets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	public static final String DBDRIVER ="com.mysql.jdbc.Driver";
	public static final String DBURL= "jdbc:mysql://localhost:3306/lxj";
	public static final String DBUSER="root";
	public static final String DBPASS="885784";
	
	private Connection conn =null;
	private Statement st=null;
	ResultSet rs=null;
	String sql;
	
	public Database(){}
	//连接数据库
	public void OpenConn(){
		try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//执行sql得到返回结果   查找
	public ResultSet executeQuery(String sql){
		try {
			st=conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs=st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	//执行sql语句   增删改
	public void executeUpdate(String sql){
		try {
			st=conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			st.executeUpdate(sql);
		//	conn.commit(); // 将缓存中的命令执行
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void close(){
		try {
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
}
