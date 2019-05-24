<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Role Creation Page....</title>
<!--         <link rel="stylesheet"	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> -->
<!-- <link rel="stylesheet" href="/resources/css/style.css"> -->
<!--       <script src="resources/js/jquery-2.1.3.js"></script> -->
<!-- <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
<!-- <script src="resources/js/jquery.serializejson.js"></script> -->
      
 <%@include file="../common/include.jsp" %>
 <script src="../../../resources/js/validation.js"></script> 
		 <script>
            function validation1()
            {
               // alert("hiii");
                var Name = document.getElementById("userNm");
                var user_id = document.getElementById("userId");
                var pwd = document.getElementById("userPwd");
//                 var company = document.getElementById("userPwd");
//                 var Question = document.getElementById("seqQues");
//                 var ans = document.getElementById("seqAns");
           
           

                
              
                errors=[];
                checkBlank(Name,"Name");
                checkBlank(user_id,"User ID");
                checkBlank(pwd,"Password");
//                 checkBlank(company,"Please Select");
//                 checkBlank(Question,"Security Question");
//                 checkBlank(ans,"Security Answer");

          
                
               
                return finalCheck();
               
                
            }

        </script> 
<script>

$(document).ready(function() {
    $('.mdb-select').material_select();
  });
</script>
 <style>
 
 .w-auto {
    width: 500px;
}
 </style>     
 <script>      
            
          function addNewRow()
            {
            	   document.getElementById("fs").style.display="block";

var x=document.getElementById("flag_incr").value;
                $.get('../../ajax/ajaxForRole.jsp',{"incr":x}, function (response) {
                	console.log(response);
                 
                    $("#addR").append(response);
                    x=parseInt(x)+1;
                    document.getElementById("flag_incr").value=x;
                });
            }
        </script>
        
        
        <script type="text/javascript">
       // jQuery.noConflict();
	function submitData() {	
		$('#form1').submit(function(event) {
							var favorite = [];
// 							$.each($("input[name='cId']:checked"),
// 									function() {
// 										favorite.push($(this).val());
// 									});
							$.each($("input[name='roleId']:checked"),
									function() {
										favorite.push($(this).val());
									});
							
							//alert("My favourite sports are: "
							//		+ favorite.join(", "));
							var x = $('#form1').serializeJSON();
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
										url : "../../../usercreationrole",

										data : val,
										dataType : 'json',

										success : function(data, textStatus) {
											var fin_data = "";
											// 				for (var i = 0; i < data.length; i++) {
											// 					fin_data= data[i].user_id + data[i].user_pw;
											// 				}
											if (data.length > 0) {
												//alert("====u have succesfully logged in====");
												window.location
														.replace("http://localhost:8081/SpringTest/home.jsp");
											} else {
												// alert("====Unauthorised Login====");	
												$('#msg')
														.html(
																"Please Provide Valid Login Credentials");
											}
										},
										error : function(xhr, textStatus,
												errorThrown) {
											window.location
													.replace("http://localhost:8081/SpringTest/login.jsp");

										}
									});
										}

						});

	}
</script>

<script type="text/javascript">
 jQuery.noConflict();
 jQuery(document).ready(function($){
$("#jsGrid").jsGrid({
    width: "100%",
    inserting: false,
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
            	    url: "../../../getAllUser",
            	    async: false,
            	    contentType: "application/json",
            	    dataType: 'json',
            	    success: function(response) {
            	    	//alert(reponse);
            	    	//alert(JSON.stringify(response));
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
        { name: "user_id", width: 50, css: "hide"},
        { name: "user_nm", type: "text", width: 50 ,title : "User Name"  },
        { name: "user_type", type: "text", width: 30 ,title : "User Type"  },
        { name: "user_pw",  type: "text", width: 50 ,title : "Password"  },
        { name: "emp_id",  type: "text", width: 30 ,title : "Emp ID"   },
        { name: "created_by", type: "text", width: 50 ,title : "Created By"  },
        { name: "modified_by",  type: "text", width: 50 ,title : "Created On"  },
        { name: "created_on",  type: "text", width: 50 ,title : "Modified By"  },
        { name: "modified_on",  type: "text", width: 50 ,title : "Modified On"   },
        { type: "control" }
    ]
});
});
</script>

    </head>
   <body class="fixed-sn mdb-skin-custom">
<%@include file="../common/menu.jsp" %>

        <%
            String mid = "", mnm = "";
//         ConnectionFactory conf = null;

            try {
// 	MyConnection mc=new MyConnection();
// 	Connection cons=mc.getConnection("adm_retail");
//                  Statement st = null;
//                 String cid = "", cnm = "";
//                 st = cons.createStatement();
//                 ResultSet rsz = st.executeQuery("SELECT co_id,co_nm FROM mst_company");
               
        %>
        <main>
        
        <form id="form1" name="role" method="post">
		<center>
            <div class="card card-cascade wider" style="width: 100%;">
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2">User Registration</div>
       <div class="card-body">
         <div id="jsGrid"></div>
       </div>
       </div>
       <br>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#centralModalLGInfoDemo"> Add New User </button>
                  
               <div class="modal fade" id="centralModalLGInfoDemo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg modal-notify modal-info" role="document">
                <!--Content-->
                <div class="modal-content">
                    <!--Header-->
                    <div class="modal-header">
                        <p class="heading lead">Add New User</p>

                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true" class="white-text">&times;</span>
                        </button>
                    </div>
                     <div class="modal-body">
                  
                   <table class="table">
                          <tr><td>    <label for="userNm" >User Name :</label>  
                           
                            <td>    <input type="text" name="user_nm" id="userNm" />
                         </tr>
                         <tr> 
                            <td>    <label for="userId" >User Id :</label>
                           
                              <td>  <input type="text" name="user_id" id="userId" />
                          </tr>
                           <tr> 
                            <td>       <label for="userPwd"> Password : </label>
                          
                             <td>   <input type="password" name="user_pw" id="userPwd" />
                            
                             </tr>
                              <tr>
                              <td><label for="userPwd"> User Type : </label>
                            <td> <select name="usertype" id="usertype" class="mdb-select colorful-select dropdown-danger">                            
                             <option value="U">User</option>
                             <option value="A">Admin</option>   
                             </select>
                             </td>
                             </tr>
                           <tr>
                            <td>     <label for="seqQues" > Select A Security Question :</label>
                            
                              <td> 
                              
                               <select name="ques" id="seqQues" class="mdb-select colorful-select dropdown-danger">
                                    <option value="What is your teacher's name?">What is your teacher's name?</option>
                                    <option value="What is your mother's maiden name?">What is your mother's maiden name?</option>
                                    <option value="What is your first pet name?">What is your first pet name?</option>
                                    <option value="What is your father's native place?">What is your father's native place?</option>
                                    <option value="Who is your favorite super hero?">Who is your favorite super hero?</option>
                                </select>
                             </tr>
                             <tr> 
                            <td>    
                           
                               <label for="seqAns" >Write Your Security answer :</label>
                           
                            <td>    <input type="text" name="quesAns" id="seqAns" />
                           </tr>
			</table>

             

            <br />
       
        <input type="button"  value="Role Grants" onclick="addNewRow()" class="btn btn-primary">
<!--   <div class="card-body text-center table-wrapper" id="newDIv" > -->
                <fieldset id="fs" style="display: none;">
                    <legend>Roles...</legend>
                   <table id="addR" >
                  
                   </table> 
                    <input type="submit"   value="Submit" class="btn btn-primary" onclick="submitData()">
                    </fieldset>
<!--                     </div> -->
<input type="hidden" id="flag_incr" value="0"/>

            <br/>

            <%
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
       </div>  
 <div class="modal-footer">
                       
                          </div>
                </div>
                <!--/.Content-->
            </div>
        </div>
      
      
       </center>     
        </form>
        </main>
    </body>
    <%@include file="../common/footer.jsp" %>
</html>