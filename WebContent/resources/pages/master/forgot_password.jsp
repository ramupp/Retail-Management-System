<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
 <head>
        <meta charset="utf-8">
       <title>Forgot Password</title>
       <%@include file="../common/include.jsp" %>
<!--        <script src="../../js/jquery.serializejson.js"></script> -->

<script>
$(document).ready(function(){
	
	
    $("#user_nm").change(function(){
    	//alert("hi");
    	var x = document.getElementById("user_nm").value;
    	//var x = $("#user_nm").val;
    	//alert(x);
        $.ajax({url: "../../../getPwdbyMail",data:{user_nm: x},type : "POST",success: function(result){
        	alert(result);
            $("#div1").html(result);
        }});
    });
});
</script>
  
<!-- <script type="text/javascript">
	$(function() {
		$('#myForm').submit(function(event) {
			event.preventDefault();
				//alert("hahahah");
							var x = jQuery('#myForm').serializeJSON();//$('#myForm').serializeJSON();
						
							var val = JSON.stringify(x);
							//alert("my val is :-"+val);
								var p=validation1();
								//alert("the val is:-"+p);
										if(p){ alert(val);



							$.ajax({

										beforeSend : function(xhrObj) {
											xhrObj.setRequestHeader(
													"Content-Type",
													"application/json");
											xhrObj.setRequestHeader("Accept",
													"application/json");
										},
										type : "POST",
										url : "../../../getPwdbyMail",

										data : val,
										dataType : 'json',

										success : function(data, textStatus) {
											//	alert(data);
												
												
												if (data=="success") {
													alert("== Data has been submited successfully ==");
													 location.reload();
												} else {
													alert("==Data Submition failed==");
													 location.reload();
													// alert("====Unauthorised Login====");	
													
												}
											},
										error : function(xhr, textStatus,
												errorThrown) {
											alert("error");
											window.location
													.replace("http://localhost:8081/SpringTest/login.jsp");

										}
							});
}

				});


});
  	</script> -->


</head>
<body class="fixed-sn light-blue-skin">
<main>
 
    
    
    <center>
            <div class="card card-cascade wider" style="width: 100%;">
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2">Forgot Password</div>
       <div class="card-body">
         <div id="jsGrid" >
         <form id="myForm" name="myForm" >
         
         	<table class="table table-hover">
							
<div class="col-xs-4">
							  <tr>
							<td >User Name:</td>
							<td><input type="text" name="user_nm" id="user_nm" placeholder="User Name"/> </td>
							</tr>
							
						
							
                          </div> 
    </table>
    <table>
    <tr>
		<td> 
			<input type="submit"  value="Send Me Mail" class="btn btn-primary" > 
			</tr>
    </table>
	</form>        
         </div>
         <div id="providePass">
          <form id="myForm" name="myForm" action="/gfgjfgfghfghfghfhgfghfghfhgfghfghfhg" style="display:none">
         
         	<table class="table table-hover" >
							
<div class="col-xs-4">
							  <tr>
							<td >PassKey:</td>
							<td><input type="text" name="user_nm" id="user_nm" placeholder="User Name"/> </td>
							</tr>
							<tr>
							<td>New Password:</td>
							<td><input type="text" name="new_pwd" id="new_pwd" readonly >
							
							</tr>
							<tr>
							<td>Confirm Password:</td>
							<td><input type="text" name="cnf_pwd" id="cnf_pwd"  readonly>
							
							</tr>
							
						
							
                          </div> 
    </table>
    <table>
    <tr>
		<td> 
			<input type="submit"  value="Send Me Mail" class="btn btn-primary" > 
			</tr>
    </table>
	</form>
         </div>
       </div>
       </div>
     
        <tr>
							
							<td><input type="hidden" name="dis_none" id="dis_none">
							<td><input type="hidden" name="user_nm" id="user_nm">
							
							
							</tr>    
              
             
           
       </center>     
 	
 </main>
 	</body>
  <%@include file="../common/footer.jsp" %>
</html>