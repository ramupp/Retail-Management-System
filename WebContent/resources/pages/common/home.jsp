
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.crunchify.model.RetailRegistrationBean"%>
<%

if(request.getSession()!=null){

%>
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>HOME PAGE............</title>
<!--bootgrid  -->
<%@include file="/resources/pages/common/include.jsp" %>

<!-- bootgrid end -->  

 <!--  <script type="text/javascript">
 jQuery.noConflict();
 jQuery(document).ready(function($){
	 $.get('../../../getData',function (response) {
		   	//alert(response);
		    
		     //  $("#company_div").html(response);
//		        x=parseInt(x)+1;
//		        document.getElementById("flag_incr").value=x;
		   });
$("#jsGrid").jsGrid({
    width: "100%",
    inserting: true,
    filtering: true,
    editing: true,
    sorting: true,
    paging: true,
    autoload: true,
    searching:true,

    deleteConfirm: "Do you really want to delete the client?",


    controller: {
        loadData: function(filter) {
            var d = $.Deferred();

            $.ajax({
            	   type: 'GET',
            	    url: "../../../getAllUser",
            	    async: false,
            	    contentType: "application/json",
            	    dataType: 'json',
            	    success: function(response) {
            	    	//alert(reponse);
            	    	//alert(JSON.stringify(response));
            	    	d.resolve(JSON.parse(JSON.stringify(response)));
            	     
            	    },
            	    error: function(e) {
            	       console.log(e.message);
            	    }
            	});

            return d.promise();
        }
    },

    fields: [
        { name: "user_id", type: "text", width: 50, validate: "required" },
        { name: "user_nm", type: "text", width: 50 },
        { name: "user_type", type: "text", width: 30 },
        { name: "user_pw", type: "text", width: 70 },
        { name: "emp_id", type: "text", width: 30 },
        { name: "created_by", type: "text", width: 50 },
        { name: "modified_by", type: "text", width: 50 },
        { name: "created_on", type: "text", width: 50 },
        { name: "modified_on", type: "text", width: 50 },
        { type: "control" }
    ]
});
});
</script> -->
 
</head>
<body class="fixed-sn light-blue-skin">
<%@include file="/resources/pages/common/menu.jsp" %>
    <!--Double navigation-->
<main>
<!--         <div class="container-fluid mt-5"> -->
<!--             <h2>Advanced Double Navigation with fixed SideNav & fixed Navbar:</h2> -->
<!--             <br> -->
<!--             <h5>1. Fixed side menu, hidden on small devices.</h5> -->
<!--             <h5>2. Fixed Navbar. It will always stay visible on the top, even when you scroll down.</h5> -->
<!--               <div id="jsGrid"></div> -->
<!--         </div> -->
<%
path=path+"/"+"resources/images/"+"womens-store-shot-3.jpg";
String orgnm=util.findOrgNameByCoId(Integer.parseInt(coid));//.findOrgNameByCoId(coid);p_co_nm;orgnm

%>

<div class="card card-cascade wider reverse">

  <!-- Card image -->
  <div class="view overlay" style=" height: 400px">
    <img class="card-img-top" src="<%=path%>" alt="Card image cap">
    <a href="#!">
      <div class="mask rgba-white-slight"></div>
    </a>
  </div>

  <!-- Card content -->
  <div class="card-body text-center">

    <!-- Title -->
    <h4 class="card-title"><strong><%=orgnm%></strong></h4>
    <!-- Subtitle -->
    <h6 class="font-weight-bold indigo-text py-2"><%=p_co_nm %></h6>
    <!-- Text -->
    <p class="card-text">
    </p>

  
  </div>

</div>
    </main>
  

</body>
<%@include file="/resources/pages/common/footer.jsp" %>
</html>
<%}else{
	response.sendRedirect("../../../login.jsp");
	
}
%>