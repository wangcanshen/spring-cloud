package com.dream.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

public class Test {
	static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://rm-uf6667k66f2ea8k83do.mysql.rds.aliyuncs.com/shoubei?useUnicode=true&characterEncoding=UTF-8";
    static String user = "sb_admin";
    static String password = "shoubei_123";
    static Connection conn = null;
    public static void main(String[] args) {
    	//注册数据库驱动
    	try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			Statement statement = conn.createStatement();
			for(int i = 742;i<=846;i++) {
				statement.execute("INSERT INTO sb_company_share (area_id,company_id,category_id,create_date,update_date,del_flag) VALUE ("+i+",'2','9','2018-08-01 16:34:13','2018-08-01 16:34:13','0')");
				statement.execute("INSERT INTO sb_company_share (area_id,company_id,category_id,create_date,update_date,del_flag) VALUE ("+i+",'2','12','2018-08-01 16:34:13','2018-08-01 16:34:13','0')");
				statement.execute("INSERT INTO sb_company_share (area_id,company_id,category_id,create_date,update_date,del_flag) VALUE ("+i+",'2','15','2018-08-01 16:34:13','2018-08-01 16:34:13','0')");
				statement.execute("INSERT INTO sb_company_share (area_id,company_id,category_id,create_date,update_date,del_flag) VALUE ("+i+",'2','19','2018-08-01 16:34:13','2018-08-01 16:34:13','0')");
				statement.execute("INSERT INTO sb_company_share (area_id,company_id,category_id,create_date,update_date,del_flag) VALUE ("+i+",'2','22','2018-08-01 16:34:13','2018-08-01 16:34:13','0')");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	//取得数据库连接
		
	}
       
}
