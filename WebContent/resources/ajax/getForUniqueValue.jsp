<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
//public String getForUniqueValue(String tbl_nm,String val,String fld_nm,String match){

String itm_type_nm = "";
int itm_type_id=0;  

String value =request.getParameter("val");
String tbl =request.getParameter("tbl_nm");
String fld =request.getParameter("fld_nm");

System.out.println("value "+value);
System.out.println("tbl "+tbl);
System.out.println("fld "+fld);

    	  MyConnection mc=new MyConnection();
      	Connection conn=mc.getConnection("adm_retail");
                       Statement st= null;
                      String cid = "", cnm = "";
                      int cnt=0;
                      st = conn.createStatement();
                      String sql="select count(*) as str from " + tbl + " WHERE " + fld + "='"+value+"'";
                  	System.out.println("sql==>"+sql);
      				ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                cnt=rs.getInt("str");
            }
           
            System.out.println("COUNT==========>"+cnt);
            		out.println(cnt);
           
        }catch (Exception e){
            System.out.println(e);  
      
       
%>



	