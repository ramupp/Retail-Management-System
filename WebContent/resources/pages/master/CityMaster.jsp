<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
 <head>
        <meta charset="utf-8">
       <title>City</title>
       <%@include file="../common/include.jsp" %>
<!--        <script src="../../js/jquery.serializejson.js"></script> -->
<script src="../../../resources/js/validation.js"></script> 
<script>
            function validation1()
            {
               // alert("hiii");
                var state = document.getElementById("state_id");
                var name = document.getElementById("city");
           

                
              
                errors=[];
                Dropdown2(state,"Please Select");
                checkBlank(name,"City");
                
               
                return finalCheck();
               
                
            }

        </script>  
         <script>
	function checkDuplicate(param) {
		
		var tnm="mst_city";
		var fnm="city_nm";
		
		$.get("../../ajax/getForUniqueValue.jsp", {val : param,tbl_nm:tnm,fld_nm:fnm}, function(response) {
			var x=response.trim();	
			 // alert(x);
		       
		         if(parseInt(x)>0)
		        	 {
		        	 alert("Name already Exists");
		        	 $('#city').val("");
		        	 $('#city').focus();
		        	 }
		});
			
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
<script>

$(document).ready(function() {
    $('.mdb-select').material_select();
   
   $('.datepicker').pickadate({
  	
  	  format: 'yyyy-mm-dd'
  	});
 
  // alert(generateJson());
  });
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
										url : "../../../Addcity_master",

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
            	    url: "../../../fetchAllCity",
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
                url: "../../../cityUpdate",
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
                url: "../../../CityDelete",
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
        { name: "state_id",width: 50,  css: "hide"},
        { name: "city_nm", type: "text", width: 50, title: "Name" },
        { name: "created_by", type: "text", width: 50, title: "Created By" ,type: "disabled"},
        { name: "modified_by", type: "text", width: 50, title: "Modified By" ,type: "disabled"},
        { name: "created_on", type: "text", width: 50, title: "Created On" ,type: "disabled"},
        { name: "modified_on", type: "text", width: 50 , title: "Modified On" ,type: "disabled"},
        { type: "control" }
    ]
});
});
</script>

	<script type="text/javascript">

jQuery(document).ready(function() {
    
 var bean="StateMasterBean";
 var valcol=["active"];
 var valv=["Y"];
 var getDatas={beanName:bean,valColumn:valcol,valValue:valv};
 var params1=JSON.stringify(getDatas);
 var select_id="state_id";
 var selectedCol1="state_id,state_nm";
 CallDropDownService(params1,select_id,selectedCol1);

});

</script>
  	

</head>
<body class="fixed-sn light-blue-skin">

<%@include file="../common/menu.jsp" %>
             
 <main>
 
    <form id="myForm" name="myForm" method="post">
    
    <center>
            <div class="card card-cascade wider" style="width: 100%;">
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2">City</div>
       <div class="card-body">
         <div id="jsGrid"></div>
       </div>
       </div>
       <br>
        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#centralModalLGInfoDemo">ADD</button>
            <br>   <br>   
               <div class="modal fade" id="centralModalLGInfoDemo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg modal-notify modal-info" role="document">
                <!--Content-->
                <div class="modal-content">
                    <!--Header-->
                    <div class="modal-header">
                        <p class="heading lead">City</p>

                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true" class="white-text">&times;</span>
                        </button>
                    </div>
                     <div class="modal-body">
                                     
							<table class="table table-hover">
							
							<tr>
							<td> Select State:</td>
							<td> <select name="state_id" id="state_id" class="mdb-select  colorful-select dropdown-primary " onchange="getItems(this.value)">
                        <option value='0'>---select Option---</option>
                        </select>
                        </td>
							</tr>
							<tr>
							<td>Name:</td>
							<td><input type="text" name="city_nm" id="city" placeholder="Name" onchange="checkDuplicate(this.value)"></td>
							</tr>
							
                          

	</table>
	<tr>
							<td> 
							<input type="submit"  value="Submit" class="btn btn-success"> 
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