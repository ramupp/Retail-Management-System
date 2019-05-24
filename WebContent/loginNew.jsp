<%-- 
    Document   : login222
    Created on : Mar 20, 2018, 11:22:02 AM
    Author     : RAMU
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" class="full-height">
    <head>
    
     <link rel="stylesheet"  href="resources/css/compiled.min.css">
     <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.css" />
<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid-theme.min.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/cupertino/jquery-ui.css">
 <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Monoton" rel="stylesheet">
        <title>Retail Management System</title>
  <style type="text/css">
  
  .view {
    background: url("resources/images/bg.jpg")no-repeat center center;
    background-size: cover;
}
@media (min-width: 768px) {
    .view {
        overflow: visible;
        margin-top: -56px;
    }
}

  
  </style>   

<script src="resources/js/jquery.serializejson.js"></script> 
        <link href="https://fonts.googleapis.com/css?family=Audiowide" rel="stylesheet" type="text/css">
      	<script type="text/javascript">
      	$(function() {
    		$('#myForm').submit(function(event) {
    			event.preventDefault();
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
					//$('#msg').html("Please Provide Valid Login Credentials");
					 toastr["info"]("Please Provide Valid Login Credentials");
					
					}
			},
			error : function(xhr, textStatus, errorThrown) {
				window.location
						.replace("<%=request.getContextPath()%>");

			}
		});

          
           
        });

      	});	
      	
      	
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
            $("#co_ids").material_select();	
//             x=parseInt(x)+1;
//             document.getElementById("flag_incr").value=x;
        });

      	} 
      	</script>
      	<script type="text/javascript">
      	$(document).ready(function(e)
      			{
      		
      	  $("#co_ids").material_select();	
      			});
      	
      	</script>
    </head>
    <body class="fixed-sn mdb-skin-custom">
      
   
      <header>
       
        <div class="view intro-2">
        <div class="full-bg-img">
            <div class="mask rgba-black-strong flex-center">
                <div class="container">
                    <div class="white-text text-center wow fadeInUp">
<!--                       <h2 class="h1-responsive font-weight-bold text-center my-5">Contact us</h2> -->
                       <div class="h1-responsive font-weight-bold " style="font-family: 'Chicle', cursive;font-family: 'Monoton', cursive;" ><h1>Retail Management System</h1></div>	
              <br> <br> <br>
                       
			 <section class="form-simple">
 				<div class="container" style=" width: 40%">
 		
<!--         <div class="col-md-6 mb-5"> -->
            
                <div class="card card-cascade" >
               <div class="view gradient-card-header  blue-gradient" style=" width: 100%">

    <!-- Title -->
    <h2 class="card-header-title mb-3">Log In</h2>
    <!-- Text -->
    

  </div>
        			<div class="card-body text-center">
        			 <form id="myForm" name="login" method="post" >	
<!--         			 <div class="form-header deep-blue-gradient rounded"> -->
<!--                             <h3><i class="fa fa-lock"></i> Login:</h3> -->
<!--                         </div> -->
                       
                            <div class="md-form">
                          
                            <input type="text" name="user_id" id="user_id" class="form-control" onchange="getCompany(this.value)">
                              <label for="user_id">Enter User Id</label>
                        </div>
                           
                             <div class="md-form">
                          
                                    <input type="password" name="user_pw" id="user_pw" class="form-control">
                                <label for="user_pw">Enter Password</label>
                                 
                        </div> 
                        <div class="md-form" id="company_div">
                          
                            <select name="co_id" id="co_ids" class="mdb-select  colorful-select dropdown-primary" >
                        <option value='0'>---Select Company---</option>
                        </select>
                               <p class="font-small grey-text d-flex justify-content-end">Forgot <a href="resources/pages/common/forgot_password.jsp" class="dark-grey-text font-weight-bold ml-1"> Password?</a></p>
                        </div>
<!--                                                   <div class="text-center mt-4"> -->
<!--                                                       <input type="submit"  value="Register" class="btn btn-light-blue" onclick="openRegister()"> -->
<!--                                     				</div> -->
                                    				<div class="text-center mb-4">
                                    <input type="submit"  value="Submit" class="btn btn-danger btn-block z-depth-2">         
                          </div>
                           <p class="font-small grey-text d-flex justify-content-center">To Register Please <a href="#" class="dark-grey-text font-weight-bold ml-1" onclick="openRegister()"> Click Here</a></p>
                                    
                         </form>
                        </div>
                        </div>
                         
<!--                         </div> -->
                      
                        </div>
                     </section> 
                    </div>
                </div>
            </div>
        </div>
    </div> 
    </header> 
   
    </body>
    
<%--   <%@include file="/resources/pages/common/footer.jsp" %>  --%>
  <script type="text/javascript" src="resources/js/compiled.min.js" ></script>  
   <script type="text/javascript" src="resources/js/jquery.serializejson.js" ></script>      
	<footer class="page-footer center-on-small-only pt-0 mt-5 fixed-bottom">
<!--Copyright-->
<div class="footer-copyright py-3 " align="right" style="margin-right: 10px">
<!-- <div class="footer-copyright py-3 "> -->
© 2018 Copyright: <a href="https://www.MDBootstrap.com"> www.vareli.co.in </a>
<!-- </div> -->
</div>
<!--/.Copyright-->
</footer>
</html>
