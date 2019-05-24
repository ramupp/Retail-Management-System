<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>

        <%
            String itm_nm = "", itm_type_nm = "";
        	int itm_id=0, itm_type_id=0;  

String code=request.getParameter("code");
String coid=request.getParameter("coid");
String type=request.getParameter("type");
UtilityHelper util=new UtilityHelper();
String x[]=util.findFinalUpdatedId(code, coid,type);
String memo_no=x[0];
String idp=x[1];
System.out.println("idp is:-"+idp);
session.setAttribute("idp",idp);

out.println(memo_no);

        %>
        