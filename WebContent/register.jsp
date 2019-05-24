<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <script src="resources/js/jquery-1.11.0.js"></script>
 <script src="resources/js/jquery.serializejson.js"></script>
 <script>
 
 function getVal()
 {
	var key=document.getElementById("keyVal").value;
	//alert(key);1011004364; 815524157; 593051762 ;237855850
	  $.get('http://122.15.67.93:8080/Retail_Mngt/Ajax/getCompanyDataFromKey.jsp', {key: key}, function (response) {
        // alert(response.trim());  
var r=response.trim();
 var JSONObject=JSON.parse(r);
 console.log(JSONObject);
 $('#org_id').val(JSONObject[0]['org_id']);
 $('#org_nm').val(JSONObject[0]['org_nm']);
 $('#web_site').val(JSONObject[0]['web_site']);
 $('#o_active').val(JSONObject[0]['active']);
 $('#o_created_by').val(JSONObject[0]['created_by']);     
 $('#o_created_on').val(JSONObject[0]['created_on']); 
 
 
 $('#org_idd').val(JSONObject[1]['org_id']);
 $('#co_id').val(JSONObject[1]['co_id']);
 $('#co_nm').val(JSONObject[1]['co_nm']);
 $('#add1').val(JSONObject[1]['add1']);
 $('#add2').val(JSONObject[1]['add2']);
 $('#add3').val(JSONObject[1]['add3']);
 $('#loc_id').val(JSONObject[1]['loc_id']);
 $('#pin').val(JSONObject[1]['pin']);
 $('#phone').val(JSONObject[1]['phone']);
 $('#fax').val(JSONObject[1]['fax']);
 $('#web_sites').val(JSONObject[1]['web_site']);
 $('#co_email').val(JSONObject[1]['co_email']);
 $('#parent_id').val(JSONObject[1]['parent_id']);
 $('#valid_fr').val(JSONObject[1]['valid_fr']);
 $('#valid_to').val(JSONObject[1]['valid_to']);
 $('#gst_no').val(JSONObject[1]['gst_no']);
 $('#bank_nm').val(JSONObject[1]['bank_nm']);
 $('#bank_br').val(JSONObject[1]['bank_br']);
 $('#parent_co').val(JSONObject[1]['parent_co']);
 $('#actives').val(JSONObject[1]['active']);
 
 $('#bank_acc').val(JSONObject[1]['bank_acc']);
 $('#ifsc_cd').val(JSONObject[1]['ifsc_cd']);
 $('#co_key').val(JSONObject[1]['co_key']);
 $('#co_type').val(JSONObject[1]['co_type']);
 $('#war_ams_flag').val(JSONObject[1]['war_ams_flag']);
 $('#co_created_by').val(JSONObject[1]['created_by']);
 $('#co_created_on').val(JSONObject[1]['created_on']);
 $('#city_nm').val(JSONObject[1]['city_nm']);
 $('#state_nm').val(JSONObject[1]['state_nm']);
 $('#country_nm').val(JSONObject[1]['country_nm']);
 
 
      });
 }
 
 function submitData()
 {
	 //var formData=$("#orgDataSubmit").serializeObject();
		//alert( ConvertFormToJSON(document.getElementById("orgDataSubmit")));
		var key=$('#co_key').val();
		var flag=0;
		var flag1=0;
		var x= $('#orgDataSubmit').serializeJSON();      		
  		var val=JSON.stringify(x);
  		console.log(val);
     $.ajax({

			beforeSend : function(xhrObj) {
				xhrObj.setRequestHeader("Content-Type", "application/json");
				xhrObj.setRequestHeader("Accept", "application/json");
			},
			contentType: "application/json; charset=utf-8",
			type : "POST",
			url : "addOrgMaster",

			data : val,
			dataType : 'json',

			success : function(data) {
			
//				for (var i = 0; i < data.length; i++) {
//					fin_data= data[i].user_id + data[i].user_pw;
//				}
//alert("org------------"+data);
				if(data=='success')
				{
// 				alert("====u have succesfully registered====");
// 				window.location.replace("http://localhost:8081/SpringTest/login.jsp");
						flag=1;

						var y=$('#orgCompanySubmit').serializeJSON();  
						var valForCompany=JSON.stringify(y);
						console.log("val is----"+valForCompany);
 					$.ajax({

							beforeSend : function(xhrObjs) {
							xhrObjs.setRequestHeader("Content-Type", "application/json");
							xhrObjs.setRequestHeader("Accept", "application/json");
						},
							contentType: "application/json; charset=utf-8",
							type : "POST",
							url : "addCompanyMaster",
					
							data : valForCompany,
							dataType : 'json',
					
							success : function(data) {
							

								//alert("in  company--------"+data);
								if(data=='success' && flag==1)
								{
									
									  $.get('http://122.15.67.93:8080/Retail_Mngt/Ajax/updateCompanyStatusInRemote.jsp',{key:key}, function (response) {
								        	//alert("response is:------"+response);
								         if(response.trim()=='success')
								        	 {
								        	 alert("====u have succesfully registered====");
						 						window.location.replace("http://localhost:8081/SpringTest/login.jsp");	
								        	 
								        	 }
								         else
								        	 {
								        	 alert("====Your Registration Failed====");	
//						 						//$('#msg').html("Please Provide Valid Login Credentials");
						 						 window.location.replace("http://localhost:8081/SpringTest/login.jsp"); 
								        	 
								        	 }
								         
								        });
			 						
								}
								else
								{
				 					 alert("====Your Registration Failed1===="+flag+flag1);	
//			 						//$('#msg').html("Please Provide Valid Login Credentials");
			 						 window.location.replace("http://localhost:8081/SpringTest/login.jsp");
								}
							},
									error : function(xhr, textStatus, errorThrown) {
					 					 alert("====Your Registration Failed1====");	
//				 						//$('#msg').html("Please Provide Valid Login Credentials");
				 						 window.location.replace("http://localhost:8081/SpringTest/login.jsp");

									}
						});

					}
						else
							{
		
								flag=-1;
							}
						},
						error : function(xhr, textStatus, errorThrown) {
								flag=-1;
								alert("error"+textStatus+"-thrown-"+errorThrown+"-xhr-org-"+xhr);
							}
				});
     
     // ajax for company submission 
    
    
     
    // Ajax End 
     
// 			    if(flag==1 && flag1==1)
// 			    	{
// 						alert("====u have succesfully registered1====");
// 						window.location.replace("http://localhost:8081/SpringTest/login.jsp");	
// 			    	}
// 			    else
// 			    	{
// 					 alert("====Your Registration Failed1===="+flag+flag1);	
// 						//$('#msg').html("Please Provide Valid Login Credentials");
// 						 window.location.replace("http://localhost:8081/SpringTest/login.jsp");
			    	
// 			    	}
    
 	}
 
 </script>
 
 
</head>
<body>
<div>
<center>
<table>
<tr>
<td><span><h1>Enter Key:</h1></span>
<td><input type="text" id="keyVal" />
</tr>
<tr>
<td><input type="button" value="GetData" onclick="getVal()"> 
</tr>
</table>
</center>
</div>
<br>
<div>
<center>
<form id="orgDataSubmit" class="orgDataSubmit">
<table>
<tr>
<td><span><h2>Organization Details</h2></span>
</tr>
<tr>
<td><input type="hidden" id="org_id" name="org_id" value=""/>
</tr>
<tr>
<td><text style="color: #3E4E95; float: left;  font-family:  Verdana; font-size: 14px; font-weight: bold; padding: 5px;">Organization Name: </text>
<td><input type="text" id="org_nm" name="org_nm" style=" background-color: #E0F4E1;" value="" readonly/>
</tr>
<tr>
<td><text style="color: #3E4E95; float: left;  font-family:  Verdana; font-size: 14px; font-weight: bold; padding: 5px;">WebSite: </text>
<td><input type="text" id="web_site" name="web_site" style=" background-color: #E0F4E1;" value=""/>
</tr>
<tr>
<td><input type="hidden" id="o_active" name="active" value=""/>
</tr>
<tr>
<td><input type="hidden" id="o_created_by" name="created_by" value=""/>
</tr>
<tr>
<td><input type="hidden" id="o_created_on" name="created_on" value=""/>
</tr>
<tr>
<!-- <td> <input type="button"  value="Submit" style=" margin-right: 20px;" onclick="submitData()"> -->
</tr>
</table>

</form>
</center>

</div>
<br>
<div>

<center>
<form id="orgCompanySubmit">
 <table> 
  <tr>
   
   <td><input type="hidden" id="org_idd" name="org_id" value="" />
   <input type="hidden" id="co_id" name="co_id" value=""/></td>
   </td>
                                
                            </tr>
                            <tr>
                                <td><text style="color: #3E4E95; float: left;  font-family:  Verdana; font-size: 14px; font-weight: bold; padding: 5px;">Name:</text></td>
                                <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold; padding: 5px;">Address1:</text></td> 
                                <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold; padding: 5px;">Address2:</text></td> 
                                <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold;; padding: 5px;">Address3:</text></td> 




                            </tr>
                            <tr>
                                <td><input type="text" name="co_nm" id="co_nm" placeholder="Name" style=" background-color: #E0F4E1;" readonly></td>
                                <td><input type="text" name="add1" id="add1"  placeholder="Address1" style=" background-color: #E0F4E1;"></td>
                                <td><input type="text" name="add2" id="add2" placeholder="Address2" style=" background-color: #E0F4E1;"></td>
                                <td><input type="text" name="add3" id="add3" placeholder="Address3" style=" background-color: #E0F4E1;"></td>



                            </tr>
                            <tr>
                                <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold; padding: 5px;">City:</text></td> 
                                <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold; padding: 5px;">State:</text></td> 
                                <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold; padding: 5px;">Country:</text></td> 
                                <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold; padding: 5px;">Pin Code:</text></td> 





                            </tr>
                            <tr>
                                <td><input type="text" class="text1"  name="city_nm" id="city_nm" placeholder="City" style=" background-color: #E0F4E1;"></td>
                                <td><input type="text" name="state_nm" id="state_nm" placeholder="State" style=" background-color: #E0F4E1;"></td>
                                <td><input type="text" name="country_nm" id="country_nm" placeholder="Country" style=" background-color: #E0F4E1;"></td>
                                <td><input type="text" name="pin" id="pin" placeholder="Pin Code" style=" background-color: #E0F4E1;"></td>


                            </tr>
                            <tr>
                                <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold; padding: 5px;">Phone:</text></td> 
                                <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold; padding: 5px;">Fax:</text></td> 
                                <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold; padding: 5px;">Email:</text></td> 
                                <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold; padding: 5px;">Web Site:</text></td> 





                            </tr>
                            <tr>
                                <td><input type="text" class="text1"  name="phone" id="phone" placeholder="Phone" style=" background-color: #E0F4E1;"></td>
                                <td><input type="text" name="fax" id="fax" placeholder="Fax" style=" background-color: #E0F4E1;"></td>
                                <td><input type="text" name="co_email" id="co_email" placeholder="Email" style=" background-color: #E0F4E1;"></td>
                                <td><input type="text" name="web_site" id="web_sites" placeholder="Web Site" style=" background-color: #E0F4E1;"></td>


                            </tr>






                        </table><br>
                        <h style=" margin-right: 700px; color: #2baf2b;">Bank Details:</h>
                        <div  style="border: 2px solid #269abc; width: 800px; padding: 10px;">
                            <table style=" margin: 5px;"> 
                                <tr> <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold; padding: 5px;">Bank:</text></td>
                                    <td><input type="text" name="bank_nm" id="bank_nm" placeholder="Bank" style=" background-color: #E0F4E1;"></td>
                                    <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold; padding: 5px;">Branch:</text></td>
                                    <td><input type="text" name="bank_br" id="bank_br" placeholder="Branch" style=" background-color: #E0F4E1;"></td>
                                    <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold; padding: 5px;">A/c No.:</text></td>
                                    <td><input type="text" name="bank_acc" id="bank_acc" placeholder="A/c No." style=" background-color: #E0F4E1;"></td></tr>
                                <tr><td>&nbsp;</tr>
                                <tr> <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold; padding: 5px;">IFSC Code:</text></td>
                                    <td><input type="text" name="ifsc_cd" id="ifsc_cd" placeholder="IFSC Code" style=" background-color: #E0F4E1;"></td></tr>
                            </table>
                        </div><br>
                        <table>
                            <tr>
                                <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold; padding: 5px;">Parent Co.:</text></td>
                                <td><input type="text" name="parent_co" id="parent_co" placeholder="Parent Co" style=" background-color: #E0F4E1;"></td>
                                <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold; padding: 5px;">Valid From:</text></td>
                                <td><input type="text" name="valid_fr" readonly id="valid_fr" placeholder="Valid From" style=" background-color: #E0F4E1;"></td>
                                <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold; padding: 5px;">Valid To:</text></td>
                                <td><input type="text" name="valid_to" readonly id="valid_to" placeholder="Valid To" style=" background-color: #E0F4E1;"></td>
                            </tr>


                            <tr>
                                <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold; padding: 5px;">GST No.:</text></td>
                                <td><input type="text" name="gst_no" id="gst_no" placeholder="GST NO." style=" background-color: #E0F4E1;"></td>
                                <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold; padding: 5px;">Active:</text>
                                </td><td><input type="text" name="active" readonly id="actives" placeholder="Active" style=" background-color: #E0F4E1;">
                                <td><text style="color: #3E4E95; float: left;  font-family: Verdana; font-size: 14px; font-weight: bold; padding: 5px;">Company Key:</text></td>
                                <td><input type="text" name="co_key" readonly id="co_key" placeholder="Company Key" style=" background-color: #E0F4E1;"></td>
                                <td><input type="hidden" name="created_by" readonly id="co_created_by" placeholder="Company Key" style=" background-color: #E0F4E1;"></td>
                                <td><input type="hidden" name="created_on" readonly id="co_created_on" placeholder="Company Key" style=" background-color: #E0F4E1;"></td>
                            </tr>
                        </table>
</form>
</center>
<br>
<center>
<table>
<tr>
<input type="button"  value="Submit" style=" margin-right: 20px;" onclick="submitData()">
</tr>
</table>
</center>
</div>





</body>
</html>