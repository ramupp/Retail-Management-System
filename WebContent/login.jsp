<%-- 
    Document   : login222
    Created on : Mar 20, 2018, 11:22:02 AM
    Author     : RAMU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <style>
            /*  @import url(https://fonts.googleapis.com/css?family=Open+Sans+Condensed:700);*/

            body {
                background: #999;
                padding: 40px;
                font-family: "Open Sans Condensed", sans-serif;
            }

            /*#bg {
              position: fixed;
              left: 0%;
              top: 0;
              width: 100%;
              height: 100%;
            background:url("images1/bg.jpg");
              background-size: 100px 80px;
                background-repeat: no-repeat;
                padding:15px;
            background-repeat: no-repeat;
              background-size: cover;
             -webkit-filter: blur(5px);    
               
            }*/


            form {

                position: relative;
                width: 400px;
                margin: 0 auto;
                margin-right: 40px;
                margin-to: 60px;
                background: rgba(130,130,130,.3);
                padding: 50px 33px;
                border: 1px solid;
                border-top-color: rgba(255,255,255,.4);
                border-left-color: rgba(255,255,255,.4);
                border-bottom-color: rgba(60,60,60,.4);
                border-right-color: rgba(60,60,60,.4);
            }

            form input, form button {

                width: 212px;
                border: 1px solid;
                border-bottom-color: rgba(255,255,255,.5);
                border-right-color: rgba(60,60,60,.35);
                border-top-color: rgba(60,60,60,.35);
                border-left-color: rgba(80,80,80,.45);
                background-color: rgba(0,0,0,.2);
                background-repeat: no-repeat;
                padding: 8px 24px 8px 10px;
                font: bold .875em/1.25em "Open Sans Condensed", sans-serif;
                letter-spacing: .075em;
                color: #fff;
                text-shadow: 0 1px 0 rgba(0,0,0,.1);
                margin-bottom: 19px;
            }

            form input:focus { background-color: rgba(0,0,0,.4); }



            form button[type=submit] {

                margin-bottom: 0;
                color: #3f898b;
                letter-spacing: .05em;
                text-shadow: 0 1px 0 #133d3e;
                text-transform: uppercase;
                background: #225558;
                border-top-color: #9fb5b5;
                border-left-color: #608586;
                border-bottom-color: #1b4849;
                border-right-color: #1e4d4e;
                cursor: pointer;
            }
        </style>
	
        <title>Retail Management System</title>
        <!-- Meta tag Keywords -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Classic Login Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- Meta tag Keywords -->

      
        <link rel="stylesheet" href="resources/css/style_n1.css" type="text/css" />
        <link rel="stylesheet" href="resources/css/font-awesome.css" type="text/css">
    

   <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/3.51/jquery.form.min.js"></script>
          <script type="text/javascript" src="resources/js/jquery-1.11.0.js" type="text/javascript"></script>
<!-- <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script> -->
           <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" type="text/css" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>

        <script src="resources/js/jquery.vide.min.js" type="text/javascript"></script>
 <link href="https://fonts.googleapis.com/css?family=Chicle|Fredoka+One|Monoton" rel="stylesheet">  
<link href="https://fonts.googleapis.com/css?family=Chicle|Monoton" rel="stylesheet">
        <!-- online-fonts -->
        <link href="//fonts.googleapis.com/css?family=Oleo+Script:400,700&amp;subset=latin-ext" rel="stylesheet">
        <!-- //online-fonts -->
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script src="resources/js/jquery.serializejson.js"></script>
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
    <body>
      
   
        <div data-vide-bg="resources/images/bg">
            <div class="center-container">
                <div class="header-w3l" style=" margin-left: 530px;font-family: 'Chicle', cursive;font-family: 'Monoton', cursive;" ><h1>Retail Management System</h1></div>	
                <div class="main-content-agile">
<%--                 <center> --%>
                    <div class="sub-main-w3" style=" margin-right: 100px; top: 150px;" >	
                        <!--                        <div class="wthree-pro"><h2>Login Here</h2></div>-->

                        <form id="myForm" name="login" method="post" >
                        <br>
                            <center><h2 style=" color: #fff; font-family: 'Chicle', cursive;font-family: 'Monoton', cursive;font-family: 'Fredoka One', cursive;">Sign In</h2></center><br>
                            <div class="form-group" style=" margin-left: 40px;">
                            <br>
                            <center>
                            <label id="msg"   style="color: #fff;"></label>
                            </center>
                            <br>
                                <label  class="col-xs-3 control-label" style="color: #fff;">Username:</label>
                                <div class="col-xs-8">
                                    <input type="text" name="user_id" id="user_id" class="form-control" title = 'select your user name' onchange="getCompany(this.value)">
                                </div>
                            </div><br><br>
                            <div class="form-group" style=" margin-left: 40px;">
                                <label class="col-xs-3 control-label" style="color: #fff;">Password:</label>
                                <div class="col-xs-8">
                                    <input type="password" name="user_pw" id="user_pw" class="form-control" title = 'select your password'>
                                </div>
                            </div><br><br>
                            <div class="form-group" style=" margin-left: 40px;">
                                <label class="col-xs-3 control-label" style="color: #fff;">Select Company:</label>
                                <div class="col-xs-8" id="company_div">
<!--                                     <input type="password" name="user_pw" id="user_pw" class="form-control" title = 'select your password'> -->
                                </div>
                            </div>

							
                            <div class='col-md-offset-3'>
                                <div class='col-md-offset-3'>
                                  <input type="submit"  value="Register" style=" margin-right: 20px;" onclick="openRegister()">
                                    <input type="submit"  value="Submit" style=" margin-right: 20px;" onclick="submitData()">
                                </div>
                            </div>
                        </form>

                    </div>
<%--                     </center> --%>
                </div>
                <div class="footer">
                    <text style="font-size: 12px; font-family: sans-serif; color: #fff">Copyright &copy; 2018 <a style=" color: #fff; text-decoration: underline;"href="http://www.vareli.co.in">Vareli Tecnac Pvt. Ltd.</a></text>
                </div>	
            </div>
        </div>
    </body>
</html>
