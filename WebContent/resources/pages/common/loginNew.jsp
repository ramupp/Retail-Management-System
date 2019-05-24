<%-- 
    Document   : login222
    Created on : Mar 20, 2018, 11:22:02 AM
    Author     : RAMU
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
<%--    <%@include file="/resources/pages/common/include.jsp" %> --%>
    <link href="../../../resources/css/compiled.min.css" rel="stylesheet"/>  
     <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.css" />
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid-theme.min.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/cupertino/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script type="text/javascript" src="../../../resources/js/TestJsForGrid.js" ></script> 
<script type="text/javascript" src="../../../resources/js/dropDown.js" ></script>  
	
        <title>Retail Management System</title>
        <!-- Meta tag Keywords -->
        <!-- Meta tag Keywords -->

<!-- <script src="resources/js/jquery.serializejson.js"></script> -->
        <link href="https://fonts.googleapis.com/css?family=Audiowide" rel="stylesheet" type="text/css">
      	<script type="text/javascript">
      	function submitData(){//alert("hi");
      	$('#myForm').submit(function(event) {
      		//alert("hiiiiiiiiiiii");
//       	  var formData = {
//                   'user_id'              : $('#user_id').val(),
//                   'user_pw'             : $('#user_pw').val()
                  
//               };
      	var x= $('#myForm').serializeJSON();      		
  		var formData=JSON.stringify(x); 
  		//alert(formData);
      	 event.preventDefault();
            // process the form
           $.ajax({

			beforeSend : function(xhrObj) {
				xhrObj.setRequestHeader("Content-Type", "application/json");
				xhrObj.setRequestHeader("Accept", "application/json");
			},
			type : "POST",
			url : "retaillogin",

			data : formData,
			dataType : 'json',

			success : function(data, textStatus) {
				//alert(data);
// 				for (var i = 0; i < data.length; i++) {
// 					fin_data= data[i].user_id + data[i].user_pw;
// 				}
//alert(data.length);
				if(data.length>0)
					{
				//alert("====u have succesfully logged in====");
				window.location.replace("<%=request.getContextPath()%>/resources/pages/common/home.jsp");
			//	window.location.replace("http://localhost:8081/SpringTest/home.jsp");
					}
				else
					{
				//	 alert("====Unauthorised Login====");	
					$('#msg').html("Please Provide Valid Login Credentials");
					
					}
			},
			error : function(xhr, textStatus, errorThrown) {
				window.location
						.replace("<%=request.getContextPath()%>");

			}
		});

          
           
        });

      	}	
      	
      	
      	</script>
      	<script>
      	function openRegister()
      	{
      	window.open("register.jsp");	
      		
      	}
      	function getCompany(str){
      		
      	//alert(str);	
      	
        $.get('resources/ajax/getCompanyDropdown.jsp',{"user":str}, function (response) {
        	//alert(response);
         
            $("#company_div").html(response);
//             x=parseInt(x)+1;
//             document.getElementById("flag_incr").value=x;
        });

      	} 
      	
      	</script>
    </head>
    <body class="fixed-sn mdb-skin-custom">
      
   
       <main>  
<section class="my-5">
<h2 class="h1-responsive font-weight-bold text-center my-5">Contact us</h2>
<div class="row">
 <div class="card">
        <div class="card-body">
                        <form id="myForm" name="login" method="post" >
                        <br>
                           
                           
                            <label id="msg"   style="color: #fff;"></label>
                           
                               
                                    <input type="text" name="user_id" id="user_id" class="form-control" title = 'select your user name' onchange="getCompany(this.value)">
                             
                           
                                    <input type="password" name="user_pw" id="user_pw" class="form-control" title = 'select your password'>
                                
                                                      <input type="submit"  value="Register" style=" margin-right: 20px;" onclick="openRegister()">
                                    <input type="submit"  value="Submit" style=" margin-right: 20px;" onclick="submitData()">
                          
                        </form>
                        </div>
                        </div>
                        </div>
</section>
           </main>    
    </body>
<%--     <%@include file="/resources/pages/common/footer.jsp" %> --%>
</html>
