package com.crunchify.util;

import java.sql.*;

import java.sql.SQLException;

public class MyConnection {
	public Connection con=null;
	
	public Connection getConnection(String db)
	{
		try{
		  Class.forName("com.mysql.jdbc.Driver");
     // con = DriverManager.getConnection("jdbc:mysql://192.168.1.232:3306/"+db, "root", "root");
		 con = DriverManager.getConnection("jdbc:mysql://192.168.1.232:3306/"+db, "root", "root");
       return con;
		}catch(Exception e)
		{
			
			System.out.println("error");
			return null;
		}

		
	}
	
	public void disconnect()
	{
		
		try {
			this.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet getResultSet(String qry,String db)
	{
		ResultSet resultSet=null;
	try {
		Statement st= this.getConnection(db).createStatement();
		resultSet=st.executeQuery(qry);
		//this.disconnect();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	return resultSet;	
	
	}
	
	public String getPath()
	{
		ResultSet resultSet=null;
	try {
		Statement st= this.getConnection("adm_retail").createStatement();
		resultSet=st.executeQuery("select * from tbl_master_setup where property_name='upload' and active='Y'");
		//this.disconnect();
		resultSet.next();
		return resultSet.getString(3);	
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}	

	
	}
	public String getBarcodePath()
	{
		ResultSet resultSet=null;
	try {
		Statement st= this.getConnection("adm_retail").createStatement();
		resultSet=st.executeQuery("select * from tbl_master_setup where property_name='barcode' and active='Y'");
		//this.disconnect();
		resultSet.next();
		return resultSet.getString(3);	
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}	

	
	}

}
