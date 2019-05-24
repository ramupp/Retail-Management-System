<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
 <head>
        <meta charset="utf-8">
       <title>Item Type</title>
       <%@include file="../common/include.jsp" %>
<!--        <script src="../../js/jquery.serializejson.js"></script> -->
		<script src="../../../resources/js/validation.js"></script> 
		 <script>
            function validation1()
            {
               // alert("hiii");
                var agent_cd = document.getElementById("agent_cd");
                var name = document.getElementById("name");
                var address = document.getElementById("address");
                var phone = document.getElementById("phone");
                var mobile = document.getElementById("mobile");
                var email = document.getElementById("email");
           

                
              
                errors=[];
                checkBlank(agent_cd,"Agent Code");
                checkBlank(name,"Name");
                checkBlank(address,"Address");
                checkBlank(phone,"Phone");
                checkBlank(mobile,"Mobile");
                checkBlank(email,"Email");
                
               
                return finalCheck();
               
                
            }
           

        </script> 
        
         <script>
	function checkDuplicate(param) {
		
		var tnm="mst_itm_typ";
		var fnm="itm_typ_nm";
		
		$.get("../../ajax/getForUniqueValue.jsp", {val : param,tbl_nm:tnm,fld_nm:fnm}, function(response) {
			var x=response.trim();	
			 // alert(x);
		       
		         if(parseInt(x)>0)
		        	 {
		        	 alert("Name already Exists");
		        	 $('#itm_typ_nm').val("");
		        	 $('#itm_typ_nm').focus();
		        	 }
		});
			
	}
</script>
        
	<script type="text/javascript">
	$(function() {
		$('#myForm').submit(function(event) {
			event.preventDefault();
				//alert("hahahah");
							var x = jQuery('#myForm').serializeJSON();//$('#myForm').serializeJSON();
						
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
										url : "../../../AgentMaster",

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
}

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
    pageSize: 5,

    deleteConfirm: "Do you really want to delete the client?",


    controller: {
        loadData: function(filter) {
            var d = $.Deferred();

            $.ajax({
            	   type: 'GET',
            	    url: "../../../fetchAllAgent",
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
        updateItem: function(item) {
            return $.ajax({
                type: "POST",
                url: "../../../AgentMasterUpdate",
                contentType: "application/json",
                dataType: 'json',
                //var x = $('#form1').serializeJSON();
    			//var val = JSON.stringify(item.itm_nm),
    			
                data: JSON.stringify(item),
                success: function (data) {
                	 //d.resolve(JSON.parse(JSON.stringify(data)));
                	  location.reload();
                }
            });
        },
        deleteItem: function(item) {
            return $.ajax({
                type: "POST",
                url: "../../../agentDelete",
                contentType: "application/json",
                dataType: 'json',
                //var x = $('#form1').serializeJSON();
    			//var val = JSON.stringify(item.itm_nm),
    			
                data: JSON.stringify(item),
                success: function (data) {
                	 //d.resolve(JSON.parse(JSON.stringify(data)));
                	  location.reload();
                }
            });
        }
    },

    fields: [
        { name: "agent_cd", css: "hide"},
        { name: "name", type: "text", width: 50 , title: "Name"},
        { name: "address", type: "text", width: 50 , title: "Address"},
        { name: "phone", type: "text", width: 50 , title: "Phone"},
        { name: "mobile", type: "text", width: 50 , title: "Mobile"},
        { name: "email", type: "text", width: 50 , title: "Email"},
        { name: "created_by", type: "text", width: 50, title: "Created By",type: "disabled"},
        { name: "modified_by", type: "text", width: 50, title: "Modified By",type: "disabled" },
        { name: "created_on", type: "text", width: 50, title: "Created On",type: "disabled" },
        { name: "modified_on", type: "text", width: 50 , title: "Modified On" ,type: "disabled"},
        { type: "control" }
    ]
});
});
</script>
  	
 
</head>
<body class="fixed-sn light-blue-skin">

<%@include file="../common/menu.jsp" %>
             
 <main>
 
    <form id="myForm" name="myForm" method="post" >
    
    <center>
            <div class="card card-cascade wider" style="width: 100%;">
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2">Agent Master</div>
       <div class="card-body">
         <div id="jsGrid"></div>
       </div>
       </div>
       <br>
        <button type="button"  class="btn btn-default" data-toggle="modal" data-target="#centralModalLGInfoDemo">ADD</button>
<br><br>

                  
               <div class="modal fade" id="centralModalLGInfoDemo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg modal-notify modal-info" role="document">
                <!--Content-->
                <div class="modal-content">
                    <!--Header-->
                    <div class="modal-header">
                        <p class="heading lead">Agent Master</p>

                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true" class="white-text">&times;</span>
                        </button>
                    </div>
                     <div class="modal-body">
                                     
							<table class="table table-hover">
							
							<tr>
							<td>Agent Code:</td>
							<td><input type="text" name="agent_cd" id="agent_cd" placeholder="Agent Code"></td>
							</tr>
							<tr>
							<td>Name:</td>
							<td><input type="text" name="name" id="name" placeholder="Name"></td>
							</tr>
							<tr>
							<td>Address:</td>
							<td><input type="text" name="address" id="address" placeholder="Address"></td>
							</tr>
							<tr>
							<td>Phone:</td>
							<td><input type="text" name="phone" id="phone" placeholder="Phone"></td>
							</tr>
								<tr>
							<td>Mobile:</td>
							<td><input type="text" name="mobile" id="mobile" placeholder="Mobile"></td>
							</tr>
								<tr>
							<td>Email:</td>
							<td><input type="text" name="email" id="email" placeholder="Email"></td>
							</tr>
							
							
	</table>
	<tr>
							<td> 
							<input type="submit"  value="Submit" class="btn btn-success" > 
							
							</tr>
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