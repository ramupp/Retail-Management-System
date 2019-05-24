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
	$(function() {
		$('#myForm').submit(function(event) {
			event.preventDefault();
				//alert("hahahah");
							var x = jQuery('#myForm').serializeJSON();//$('#myForm').serializeJSON();
						
							var val = JSON.stringify(x);
							//alert("my val is :-"+val);
								//var p=validation1();
								//alert("the val is:-"+p);
										//if(p){ alert(val);



							$.ajax({

										beforeSend : function(xhrObj) {
											xhrObj.setRequestHeader(
													"Content-Type",
													"application/json");
											xhrObj.setRequestHeader("Accept",
													"application/json");
										},
										type : "POST",
										url : "../../../Change_Pwd",

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
//}

				});


});
  	</script>

  <script type="text/javascript">
 jQuery.noConflict();
 jQuery(document).ready(function($){
$("#jsGrid").jsGrid({
    width: "100%",
    inserting: true,
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
            	    url: "../../../fetchAllItmType",
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
        },
        updateCangePwd: function(pwd) {
            return $.ajax({
                type: "POST",
                url: "../../../Change_Pwd",
                contentType: "application/json",
                dataType: 'json',
                //var x = $('#form1').serializeJSON();
    			//var val = JSON.stringify(item.itm_nm),
    			
                data: JSON.stringify(pwd),
                success: function (data) {
                	 //d.resolve(JSON.parse(JSON.stringify(data)));
                	  location.reload();
                }
            });
        }
    },

    fields: [
        { name: "itm_typ_id", css: "hide"},
        { name: "itm_typ_nm", type: "text", width: 50 , title: "Type"},
        { name: "created_by", type: "text", width: 50, title: "Created By"},
        { name: "modified_by", type: "text", width: 50, title: "Modified By" },
        { name: "created_on", type: "text", width: 50, title: "Created On" },
        { name: "modified_on", type: "text", width: 50 , title: "Modified On"},
        { type: "control" }
    ]
});
});
</script>
  
	  <script>          
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
 
   <form id="myForm" name="myForm" method="post" >
    
    <center>
            <div class="card card-cascade wider" style="width: 100%;">
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2">Change Password</div>
       <div class="card-body">
         <div ><table class="table table-hover">
							
							<tr>
							<td>User ID:</td>
							<td><input type="text" name="user_id" id="user_id" placeholder="User ID"></td>
							</tr>
							<tr>
							<td>Old Password:</td>
							<td><input type="password" name="user_pw" id="user_pw" placeholder="Old Password"></td>
							</tr>
							<tr>
							<td>New Password:</td>
							<td><input type="password" name="user_pw" id="user_pw" placeholder="New Password"></td>
							</tr>
					 		<tr>
							<td>Confirm Password:</td>
							<td><input type="password" name="user_pw" id="arka" placeholder="Confirm Password"></td>
							</tr> 
							
	
	<tr>
							<td> 
							<input type="submit"  value="Submit" class="btn btn-success" > 
							
							</tr>
							</table>
							
							</div>
       </div>
       </div>
       <br>
       


           
                
      
       </center>     
 	</form>
 </main>
 	</body>
  <%@include file="../common/footer.jsp" %>
</html>