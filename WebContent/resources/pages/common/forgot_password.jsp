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
        $.ajax({url: "../../ajax/getForgotPwd.jsp",data:{usernm: x},success: function(result){
        	//alert(result);
            $("#div1").html(result);
        }});
    });
});
</script>

</head>
<body class="fixed-sn light-blue-skin">
<main>
 
    <form id="myForm" name="myForm" method="post">
    
    <center>
            <div class="card card-cascade wider" style="width: 100%;">
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2">Forgot Password</div>
       <div class="card-body">
         <div id="jsGrid">
         
         
         	<table class="table table-hover">
							
<div class="col-xs-4">
							<tr>
							<td >User Name:</td>
							<td><input type="text" name="user_nm" id="user_nm" placeholder="User Name"/> </td>
							</tr>
							
							<tr>
							<td >Security Question:</td>
							<td ><div id="div1"><input type="text" name="ques"  class="form-control" id="seqQues" placeholder="Security Question"></div></td>
							</tr>
							
							<tr> 
                            <td>    
                           <label for="seqAns" >Write Your Security answer :</label>
                           <td><input type="text" name="quesAns" id="seqAns"  placeholder="Security Answer"/>
                           </tr>
                          </div> 
    </table>
    <table>
    <tr>
		<td> 
			<input type="submit"  value="Send Me Mail" class="btn btn-primary" > 
			</tr>
    </table>
	
         
         </div>
       </div>
       </div>
     
                  
              
             
           
       </center>     
 	</form>
 </main>
 	</body>
<%--   <%@include file="../common/footer.jsp" %> --%>
</html>