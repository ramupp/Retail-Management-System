
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.crunchify.model.RetailRegistrationBean"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME PAGE............</title>
<!--bootgrid  -->


<!-- bootgrid end -->
 <script src="resources/js/jquery-1.11.0.js"></script>
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.css" />
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid-theme.min.css" />
 
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.js"></script>
<script type="text/javascript">
$(function() {
$("#jsGrid").jsGrid({
    width: "100%",
    height: "400px",
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
            	    url: "getAllUser",
            	    async: false,
            	    contentType: "application/json",
            	    dataType: 'json',
            	    success: function(response) {
            	    //	alert(reponse);
            	    	alert(JSON.stringify(response));
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
</script>


</head>
<body>
	<div id="contentDiv">
		<div style="background-color: #9ECAD0; height: 35em; weidth: 40em">
			<br />
			<div align="center"
				style="background-color: #999999; height: 4em; width: 100%">
				<h1>
					<font color="#FFFFFF">Home Page</font>
				</h1>
			</div>
<!-- 			<div> -->
<!-- 			<table id="grid-data" class="table table-condensed table-hover table-striped"> -->
<!--     <thead> -->
<!--         <tr> -->
<!--             <th data-column-id="user_id" data-identifier="true">User ID</th> -->
<!--             <th data-column-id="user_nm">Name</th> -->
<!--             <th data-column-id="user_pw" data-order="desc">Password</th> -->
<!--             <th data-column-id="user_type" data-order="desc">Type</th> -->
<!--             <th data-column-id="link" data-formatter="link" data-sortable="false">Link</th> -->
<!--         </tr> -->
<!--     </thead> -->
<!-- </table> -->
<!-- 			</div> -->
			<div id="jsGrid"></div>
			
			<%
			RetailRegistrationBean rb=(RetailRegistrationBean)session.getAttribute("user1");
			%>
			<span>
			<%=rb.getUser_nm() %>
			</span>
		</div>
	</div>
</body>
</html>