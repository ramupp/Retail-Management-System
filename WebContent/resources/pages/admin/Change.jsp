<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
 <head>
        <meta charset="utf-8">
       <title>Change Password</title>
       <%@include file="../common/include.jsp" %>
<!--        <script src="../../js/jquery.serializejson.js"></script> -->
  
	<script type="text/javascript">
	function submitData() { 
		//jQuery.noConflict();
		$('#myForm').submit(function(event) {
			//alert("hahahah");
							var x = jQuery('#myForm').serializeJSON();//$('#myForm').serializeJSON();
						
							var val = JSON.stringify(x);
							alert("my val is :-"+val);

							$.ajax({

										beforeSend : function(xhrObj) {
											xhrObj.setRequestHeader(
													"Content-Type",
													"application/json");
											xhrObj.setRequestHeader("Accept",
													"application/json");
										},
										type : "POST",
										url : "../../../Additm_master",

										data : val,
										dataType : 'json',

										success : function(data, textStatus) {
											alert("success");
											
											if (data.length > 0) {
												//alert("====u have succesfully logged in====");
												window.location
														.replace("http://localhost:8081/SpringTest/home.jsp");
											} else {
												alert("failure");
												// alert("====Unauthorised Login====");	
												$('#msg').html("Please Provide Valid Login Credentials");
											}
										},
										error : function(xhr, textStatus,
												errorThrown) {
											alert("error");
											window.location
													.replace("http://localhost:8081/SpringTest/login.jsp");

										}
									});

						});

	}
  	</script>
  	
  	 <script >
            function check()
            {
                var oldpassword = document.getElementById("pass").value;
                var newpassword = document.getElementById("pass1").value;
                var confirmpassword = document.getElementById("pass2").value;
                var oldpasssession = document.getElementById("pwd1").value;
                //var w=document.oq.pro.value;
                // var a=document.oq.oqty.value;

                //alert(oldpasssession + oldpassword);
                if (oldpassword != oldpasssession)
                {
                    $.notify('Please provide valid old Password', {blur: 0.6, delay: 0});
                    return false;
                }
                if (newpassword == "")
                {
                    $.notify('Please provide New Password', {blur: 0.6, delay: 0});
                    return false;
                }
                if (confirmpassword == "" || (newpassword != confirmpassword))
                {
                    $.notify('Please provide Confirm Password', {blur: 0.6, delay: 0});
                    return false;
                }
                else {
                    return true;
                }

            }
            function test1()
            {
                // alert("helooo1");
                var oldpassword = document.getElementById("pass").value;
                //    var newpassword=document.getElementById("pass1").value;
                //    var confirmpassword=document.getElementById("pass2").value;
                var oldpasssession = document.getElementById("pwd1").value;
                //var w=document.oq.pro.value;
                // var a=document.oq.oqty.value;

                //alert(oldpasssession + oldpassword);
                if (oldpassword == oldpasssession)
                {
                    //alert("helloo2");
                    var start = 8;
                    var mid = 15;
                    var end = 820;
                    var width = 2;
                    var leftX = start;
                    var leftY = start;
                    var rightX = mid - (width / 2.7);
                    var rightY = mid + (width / 2.7);
                    var animationSpeed = 20;

                    var ctx = document.getElementsByTagName('canvas')[0].getContext('2d');
                    ctx.lineWidth = width;
                    ctx.strokeStyle = 'rgb(213, 255, 128)';

                    for (i = start; i < mid; i++) {
                        var drawLeft = window.setTimeout(function () {
                            ctx.beginPath();
                            ctx.moveTo(start, start);
                            ctx.lineTo(leftX, leftY);
                            ctx.stroke();
                            leftX++;
                            leftY++;
                        }, 1 + (i * animationSpeed) / 3);
                    }

                    for (i = mid; i < end; i++) {
                        var drawRight = window.setTimeout(function () {
                            ctx.beginPath();
                            ctx.moveTo(leftX, leftY);
                            ctx.lineTo(rightX, rightY);
                            ctx.stroke();
                            rightX++;
                            rightY--;
                        }, 1 + (i * animationSpeed) / 3);
                    }

                    document.getElementById("pass1").removeAttribute("readonly");
                    document.getElementById("pass2").removeAttribute("readonly");
                }
                else
                {
                    // alert("hiii guys");
                    $("#pass").removeClass("text1");
                    $("#pass").addClass("error");
                }

            }

            function matchPassword()
            {
                //alert("hiiiii");
                var p = document.getElementById("pass1").value;
                var q = document.getElementById("pass2").value;
                // alert(p);
                if (p == q)
                {
                    //  alert("password matched");

                    document.getElementById("xp").innerText = "\u2714Password matched";

                }
                else
                {
                    //  alert("password didnt matched");
                    document.getElementById("xp").innerText = "\u274cPassword didnt matched";
                    document.oq.newpassword.focus();
                    document.oq.confirmpassword.focus();
                }
            }


        </script>
 

</head>
<body class="fixed-sn light-blue-skin">

 
<%@include file="../common/menu.jsp" %>
             
 <main>
 
    <form id="myForm" name="myForm" method="post">
    
    <center>
            <div class="card card-cascade wider" style="width: 100%;">
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2">Change Password</div>
       <div class="card-body">
        <table size="100%">
                            <form name="oq" method="post" onsubmit="return check()"> 
                                <tr>
                                    <td><text>User I.D :</text> </td>                
                                       <td><input type="text"  class="text1" value="" name="opid" id="opid" placeholder="User ID"></td>
                                </tr> 
                                <tr>
                                    <td> <text>Old Password :</text> </td>
                                    <td><input type="password"  class="text1" value="" name="pass" id="pass" onchange="test1();" placeholder="Old Password"><td> 
                                    <canvas height="50" width="80"></canvas></td>
                                    <td><input style="display : none;" type="password" class="text1" value="" name="pwd1" id="pwd1" > </td> 
                                </tr>

                                <tr>
                                    <td ><text>New Password :</text> </td>
                                       <td> <input type="password"  class="text1" value="" name="pass1" id="pass1" placeholder="New Password"></td>          

                                </tr>

                                <tr>
                                    <td ><text>Confirm Password :</text> </td>
                                        <td><input type="password"  class="text1" value="" name="pass2" id="pass2" placeholder="Confirm Password" onkeyup="matchPassword();" > </td>  
                                                                            <td colspan="2">  <p id="xp" style=" color: #00FF00; font-size: larger; padding: 5px;"></p>
                                            

                                </tr>
                               


                                <%
                      //    ResultSet rs3 = stmt2.executeQuery("SELECT * FROM tbl_master_activity where flag='Y'");
                                %>

  
                                <table>
                               <tr>
							<td> 
							<input type="submit"  value="Submit" class="btn btn-primary" onclick="submitData();"> 
							</tr>
                                </table>
       </div>
       </div>
       <br>
                
               <div class="modal fade" id="centralModalLGInfoDemo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg modal-notify modal-info" role="document">
                <!--Content-->
                <div class="modal-content">
                    <!--Header-->
                    <div class="modal-header">
                        <p class="heading lead">Change Password</p>

                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true" class="white-text">&times;</span>
                        </button>
                    </div>
                     <div class="modal-body">
                       
					  
	<div class="modal-footer">
                       
                          </div>
                </div>
                <!--/.Content-->
            </div>
        </div>
      </div>
      
       </center>     
 	</form>
 </main>
 	</body>
  <%@include file="../common/footer.jsp" %>
</html>