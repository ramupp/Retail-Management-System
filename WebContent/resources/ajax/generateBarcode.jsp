<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<%@ page import="com.crunchify.model.*"%>


 <%
          
 String code=request.getParameter("code");
	String purno=request.getParameter("purno");
	String pdt=request.getParameter("pdt");
	UtilityHelper util=new UtilityHelper();
	RetailRegistrationBean rb=(RetailRegistrationBean)request.getSession().getAttribute("user1");
	String coid=rb.getCo_id();
	String respnse=util.barcode_generate(code, purno, coid, pdt);//.barcode_generate(code,purno,coid,pdt);
	out.println(respnse);
                	
    %>
     

        

				

			