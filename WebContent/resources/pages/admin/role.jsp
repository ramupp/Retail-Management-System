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
		 <script>
            function validation1()
            {
           
                var role = document.getElementById("r_nm");
            	errors=[];
                checkBlank(role,"Role Name");
                var p=isCheckBoxGroupHasValue("X");
           		var q=isCheckBoxGroupHasValue("A");
           		var r=isCheckBoxGroupHasValue("B");
           		var s=isCheckBoxGroupHasValue("C");
           		var t=isCheckBoxGroupHasValue("D");


					if(p==0){
						errors[errors.length] = "Please Select a role";
					}else if(parseInt(p)>0 &&(parseInt(q)==0 && parseInt(r)==0 && parseInt(s)==0 && parseInt(t)==0))
						{
						errors[errors.length] = "Please Provide atleast one grant";
						}
           			
                
               
                return finalCheck();
       
                
            }

        </script> 
     


<style type="text/css">
.table-wrapper {
    display: block;
    max-height: 300px;
    overflow-y: auto;
    -ms-overflow-style: -ms-autohiding-scrollbar;
}
}
</style>

<script type="text/javascript">
$(function() {
	$('#form1').submit(function(event) {
		event.preventDefault();
			//alert("hahahah");
						var x = jQuery('#form1').serializeJSON();//$('#myForm').serializeJSON();
					
						var val = JSON.stringify(x);
						//alert("my val is :-"+val);
							var p=validation1();
							//alert("the val is:-"+p);
									if(p){ //alert(val);
							$.ajax({

										beforeSend : function(xhrObj) {
											xhrObj.setRequestHeader(
													"Content-Type",
													"application/json");
											xhrObj.setRequestHeader("Accept",
													"application/json");
										},
										type : "POST",
										url : "../../../rolecreation",

										data : val,
										dataType : 'json',

										success : function(data, textStatus) {
											var fin_data = "";
											// 				for (var i = 0; i < data.length; i++) {
											// 					fin_data= data[i].user_id + data[i].user_pw;
											// 				}
											if (data=="success") {
												alert("====Your Data is Saved====");
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
}

						});
		

	});
</script>





 <script>
 	function check(param) {
 		//alert(param);
 		var chbox = '#' + param;
 		var txarea = document.getElementById(param).value;
 		if ($(chbox).prop("checked") == true) {
 			//alert(chbox);			
 			document.getElementById(txarea).value = 'true';     

 		} else if ($(chbox).prop("checked") == false) {
 			document.getElementById(txarea).value = 'false';

 		}
 	}
 	function isCheckBoxGroupHasValue(x)
 	{
 		

 		var sum3=0.0;
 		var p="."+x+":checkbox:checked";
 		var m=$(p).length;
 		//alert(m);
 		if(parseInt(m)==parseInt("0"))
 			{
 	
 			return 0;
 			}else{return m;}
 		
 	}
 </script>





</head>
<body class="fixed-sn mdb-skin-custom">
<%@include file="../common/menu.jsp" %>
	<%
		String mid = "", mnm = "",str="";
		try {
			 MyConnection mc=new MyConnection();
		  // Connection con=mc.getConnection("adm_retail");
			Statement st = null;
			st = con.createStatement();
			ResultSet rsx = st.executeQuery("SELECT menu_id,menu_nm FROM adm_menu where parent_menu <> 0 order by menu_order");
	%> 
	<main>
	<form id="form1" name="role" method="post" >
<center>
		<div class="card card-cascade wider" style="width: 70%;">
<div class="card-header deep-orange lighten-1 white-text text-center z-depth-2">
				Role Creation.... 
				</div>
				 <div class="card-body text-center table-wrapper">
				<% 
				while (rsx.next()) {
					mid = rsx.getString("menu_id");
					mnm = rsx.getString("menu_nm");
				
				%>
				<table class="table table-bordered" >
				 <tbody>
					<tr>
						<td width="250px" align="left">
						
							<input class="filled-in form-check-input X"  type="checkbox" name="menuId[]" id="checkbox-<%=mid%>" value="<%=mid%>" >
							<label for="checkbox-<%=mid%>" class="form-check-label" id="<%=mid%>"><%=mnm%></label>
							
							</td>
						
						<td>
						
						<input type="checkbox" class="filled-in form-check-input A" name="" id="checkbox-add<%=mid%>" value="add<%=mid%>" onclick="check(this.id);checkBox(this.id);"> 
						<label for="checkbox-add<%=mid%>" class="form-check-label">Add</label> 
						<textarea style="display: none;" id="add<%=mid%>" name="addId[]">no</textarea>
						</td>
						
						<td>
						
						<input type="checkbox" class="filled-in form-check-input B" name="" id="checkbox-edit<%=mid%>" value="edit<%=mid%>" onclick="check(this.id);checkBox(this.id);">
						<label for="checkbox-edit<%=mid%>" class="form-check-label">Edit</label> 
						<textarea style="display: none;" id="edit<%=mid%>" name="editId[]">no</textarea>
						</td>
						<td >
						<input type="checkbox" class="filled-in form-check-input C" name="" id="checkbox-del<%=mid%>" value="del<%=mid%>" onclick="check(this.id);checkBox(this.id);">
						<label for="checkbox-del<%=mid%>" class="form-check-label">Delete</label> 
						<textarea style="display: none;" id="del<%=mid%>" name="deleteId[]">no</textarea>
						</td>
						<td >
						 <input type="checkbox" class="filled-in form-check-input D" name="" id="checkbox-view<%=mid%>" value="view<%=mid%>" onclick="check(this.id);checkBox(this.id);">
						 <label for="checkbox-view<%=mid%>" class="form-check-label">View</label>
						 <textarea style="display: none;" id="view<%=mid%>" name="viewId[]">no</textarea>
						 </td>
					</tr>
					</tbody>
				</table>
				<% } %>
				
			
				
<!-- 			</fieldset> -->

		</div>
		<br />
		 <div class="card mx-xl-5" style="width: 500px;">
				<div class="card-body">
			
					<label for="r_nm" class="grey-text font-weight-light">Enter Role Name</label>
					<input type="text" name="roleNm" id="r_nm" class="form-control"></td>
			 		<input type="submit"  class="btn btn-cyan"  value="submit" /></td>
				</div>	
		</div>

</div>
		<%
			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
</center>
	</form>
		<%@include file="../common/footer.jsp" %>
	</main>

</body>

</html>