<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>Role Creation Page....</title>


<%@include file="../common/include.jsp" %>

<script src="../../../resources/js/validation.js"></script> 

<!-- 		 <script>
//             function validation1()
//             {
           
//                 var role = document.getElementById("r_nm");
//             	errors=[];
//                 checkBlank(role,"Role Name");
//                 var p=isCheckBoxGroupHasValue("X");
//            		var q=isCheckBoxGroupHasValue("A");
//            		var r=isCheckBoxGroupHasValue("B");
//            		var s=isCheckBoxGroupHasValue("C");
//            		var t=isCheckBoxGroupHasValue("D");


// 					if(p==0){
// 						errors[errors.length] = "Please Select a role";
// 					}else if(parseInt(p)>0 &&(parseInt(q)==0 && parseInt(r)==0 && parseInt(s)==0 && parseInt(t)==0))
// 						{
// 						errors[errors.length] = "Please Provide atleast one grant";
// 						}
           			
                
               
//                 return finalCheck();
       
                
//             }

        </script>  -->
     


<style type="text/css">
.table-wrapper {
    display: block;
    max-height: 300px;
    overflow-y: auto;
    -ms-overflow-style: -ms-autohiding-scrollbar;
}
}
</style>

<!--  <script> 
//  	function check(param) {
//  		//alert(param);
//  		var chbox = '#' + param;
//  		var txarea = document.getElementById(param).value;
//  		if ($(chbox).prop("checked") == true) {
//  			//alert(chbox);			
//  			document.getElementById(txarea).value = 'true';     

//  		} else if ($(chbox).prop("checked") == false) {
//  			document.getElementById(txarea).value = 'false';

//  		}
//  	}
 	
//  	function isCheckBoxGroupHasValue(x)
//  	{
//  		var sum3=0.0;
//  		var p="."+x+":checkbox:checked";
//  		var m=$(p).length;
//  		//alert(m);
//  		if(parseInt(m)==parseInt("0"))
//  			{
 	
//  			return 0;
//  			}else{return m;}
 		
//  	}
  </script> -->

 <script type="text/javascript">
 $(function() {
 	$('#form1').submit(function(event) {
 		event.preventDefault();
 			//alert("hahahah");
 						var x = jQuery('#form1').serializeJSON();//$('#myForm').serializeJSON();
					
 						var val = JSON.stringify(x);
 						//alert("my val is :-"+val);
 							//var p=validation1();
 							//alert("the val is:-"+p);
									//if(p){ //alert(val);
 							$.ajax({

 										beforeSend : function(xhrObj) {
 											xhrObj.setRequestHeader(
 													"Content-Type",
 													"application/json");
 											xhrObj.setRequestHeader("Accept",
 													"application/json");
 										},
 										type : "POST",
 										url : "../../../roleupdation",

 										data : val,
 										dataType : 'json',

										success : function(data, textStatus) {
											var fin_data = "";
											// 				for (var i = 0; i < data.length; i++) {
											// 					fin_data= data[i].user_id + data[i].user_pw;
											// 				}
											if (data=="success") {
												alert("====Role updated successfully====");
												 location.reload();
												//window.location
												//		.replace("http://localhost:8081/SpringTest/home.jsp");
											} else {
												 alert("====Your Data is Not Saved====");	
												
											}
										},
										error : function(xhr, textStatus,
												errorThrown) {
											alert(xhr+textStatus+errorThrown);
// 											window.location
// 													.replace("http://localhost:8081/SpringTest/login.jsp");


 										}
 									});
// }

 						});
		

 	});
 </script>

<script>
	function getRoleView(param) {
		if(param=='0')
			{
			$('#insertDiv').hide();
			$('#newDiv').show();
			}else{
		$.get("../../ajax/getRoleData.jsp", {role_id : param}, function(data, status) {
			$('#insertDiv').html(data);
			getAutoFocus();
			//$('#party_cd').material_select();
			//$('#newDiv').hide();
			$('#insertDiv').show();
		});
			}

	}
</script>





 <script>
 
 $(document).ready(function() {
	 
 var bean1="RoleDataHdr";
 var valcol1=["active"];
 var valv1=["Y"];
 var getDatas1={beanName:bean1,valColumn:valcol1,valValue:valv1};
 var params11=JSON.stringify(getDatas1);
 var p1="roleId";
 var selectedCol11="roleId,roleNm";
 CallDropDownService(params11,p1,selectedCol11);
 });
 
 </script>





</head>
<body class="fixed-sn mdb-skin-custom">
<%@include file="../common/menu.jsp" %>

   
	<main>
	<form id="form1" name="role" method="post" >
<center>
		<div class="card card-cascade wider" style="width: 70%;">
<div class="card-header deep-orange lighten-1 white-text text-center z-depth-2">
				Role Updation.... 
				</div>
				 <div class="card-body text-center">
			
				<table class="table table-bordered" >
				 <tbody>
				 <th>Select Role: <select name="roleId" id="roleId" class="mdb-select  colorful-select dropdown-primary " onchange="getRoleView(this.value);">
									<option value='0'>---select Option---</option>
							</select>
							</th>
					</tbody>
				</table>
				<div id="insertDiv" class="table-responsive" align="left"></div>
					</div>
			</div>
			
		<input type="submit" class="btn btn-primary" value="submit" />
</center>

	</form>
		<%@include file="../common/footer.jsp" %>
	</main>

</body>

</html>