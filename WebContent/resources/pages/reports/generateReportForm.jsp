<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="com.crunchify.util.*"%>
<%@ page import="java.sql.*"%>

   <script src="../../../resources/js/jquery-1.11.0.js"></script> 
        <%@include file="../common/include.jsp" %>
   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
   <script src="../../../resources/js/packingSlip.js"></script> 
   
  <script>
  $( function() {
// 	    $( "#FromDate" ).datepicker({ dateFormat: 'yy-mm-dd' }).val();
// 	    $( "#ToDate" ).datepicker({ dateFormat: 'yy-mm-dd' }).val();
	    
	  } );
</script>
	<script type="text/javascript">
$(document).ready(function() {
	 $(".x").material_select();	
	 $('#FromDate').pickadate({
		  	
	  	  format: 'yyyy-mm-dd'
	  	});
	 $('#ToDate').pickadate({
		  	
	  	  format: 'yyyy-mm-dd'
	  	});
});

</script>



  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <style>
* {
    box-sizing: border-box;
}

body {
    font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
    background-color: #FF8C00;
    padding: 20px;
    text-align: center;
    font-size: 20px;
    color: white;
}

/* Create two columns/boxes that floats next to each other */
nav {
    float: left;
    width: 30%;
    height: 100px; /* only for demonstration, should be removed */
    background: #ccc;
    padding: 20px;
}

/* Style the list inside the menu */
nav ul {
    list-style-type: none;
    padding: 0;
}

article {
    float: left;
    padding: 20px;
    width: 70%;
    background-color: #f1f1f1;
    height: 300px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section:after {
    content: "";
    display: table;
    clear: both;
}

/* Style the footer */
footer {
    background-color: #777;
    padding: 10px;
    text-align: center;
    color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 100px) {
    nav, article {
        width: 100%;
        height: auto;
    }
}
</style> -->

</head>
<!-- <h1 style="color:blue;">Cash Memo</h1> -->
<body class="fixed-sn mdb-skin-custom">
<%@include file="../common/menu.jsp" %>
<main>
  <div class="container-fluid text-center" >
  
      
 <% 
 

	//String al=request.getParameter("al");
String n=request.getParameter("n");
 System.out.println("n==>" +n);
 
 
 %>
 <center>
<div class="card-header deep-orange lighten-1 white-text text-center z-depth-2" style=" max-width: 650px"> <%=n%></div>  

 <div class="card card-body" style=" max-width: 600px">
<form action="generateReport.jsp" method="post">
<%
		String al=request.getParameter("al");
//String n=request.getParameter("n");
        System.out.println("al==>" +al);
		//	String al= "cash_memo"; 
		
		String report_nm="",alias_nm="",qry="",ptype="",param="",heading="";
		String[] paramList=null;
		int count=0;
		int rid=0;
		int j=0;
	    MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");                    
		String sqla="SELECT id, alias, report_nm, is_delete from tbl_report_hdr where active='Y' and alias='"+al+"'";   
		     
		ResultSet rsa=mc.getResultSet(sqla,"adm_retail");
		System.out.println("sql1==> "+sqla);
		while(rsa.next())
		{
			rid=rsa.getInt("id");
			report_nm=rsa.getString("report_nm");
			alias_nm=rsa.getString("alias");
			
			
		String sqldtl="select id, param, qry, ptype,heading from tbl_report_dtl where hid="+rid;
		ResultSet rsdtl=mc.getResultSet(sqldtl,"adm_retail");
		System.out.println("sql2==> "+sqldtl);
		while(rsdtl.next())
		{
			param=rsdtl.getString("param");		
			qry=rsdtl.getString("qry");
			ptype=rsdtl.getString("ptype");
			heading=rsdtl.getString("heading");
	%>	
	
	<%
		ResultSet rssel=mc.getResultSet(qry,"adm_retail");
	
	
	%>
	<input type="hidden" name="hid" id="h_id" value="<%=rid%>" />
	   <input type="hidden" name=rnm id="r_nm" value="<%=report_nm%>" />
       <table class="table" >
	   <tr>
	    <th>
	     <%=heading%>
	   </th>
<%      if(ptype.equalsIgnoreCase("select"))    {
	System.out.println("sql3==> ");
	
	%>	   
	   <td>
	   <select name="<%=param%>" class="browser-default">
	   <% while(rssel.next()){ %>
	   <option value="<%=rssel.getString(1)%>"><%=rssel.getString(2)%></option>
	   <% } %>
	   </select>
	   </td>

			
<%	} 
	   else if(ptype.equals("text")){ %>

		<td>
	   <input type="text" name="<%=param%>" id="<%=param%>" class="form-control" />
                                                       
	   </td>
	   
	   <% }else if(ptype.equals("datepicker")){ %>
	   <td>

	   <input type="text" name="<%=param%>" id="<%=param%>" class="form-control" readonly>

	   </td>
	   <% }else if(ptype.equals("radio")){ 
	   j++;
	   
	   %>
	   <td>
	   <input class="form-check-input" name="<%=param%>" type="radio" id="radio<%=j%>>" value="<%=qry%>" onclick="" checked>
    <label class="form-check-label" for="radio<%=j%>>"><%=heading%></label>
	      
	   </td>
<%}

}

%>

</tr>
<tr>
  <td colspan="7" align="center"> <input type="submit" class="btn btn-primary btn-sm" value="submit" />
</tr>
</table>

</form>

</div>
</center>
</div>
</main>	
</body>

<%    

		}  %>
		
<!-- 		<footer> -->
<!--   <p>Footer</p> -->
 <%@include file="../common/footer.jsp" %>
<!-- </footer> -->
</html>
