<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
 <head>
        <meta charset="utf-8">
       <title>Miscellaneous Head</title>
       <%@include file="../common/include.jsp" %>
<!--        <script src="../../js/jquery.serializejson.js"></script> -->
		<script src="../../../resources/js/validation.js"></script> 
		
		
		 <script>
            function validation1()
            {
               // alert("hiii");
                var item = document.getElementById("itm_typ_nm");
              //  var sm_nm = document.getElementById("sm_nm");
           

                
              
                errors=[];
                checkBlank(item,"Item Type");
             //   checkBlank(sm_nm,"Name");
                
               
                return finalCheck();
               
                
            }

        </script> 
        
        <script>

$(document).ready(function() {
    $('.mdb-select').material_select();
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
								//var p=validation1();
								//alert("the val is:-"+p);
									//	if(p){ alert(val);



							$.ajax({

										beforeSend : function(xhrObj) {
											xhrObj.setRequestHeader(
													"Content-Type",
													"application/json");
											xhrObj.setRequestHeader("Accept",
													"application/json");
										},
										type : "POST",
										url : "../../../miscHead",

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
    pageSize: 5,

    deleteConfirm: "Do you really want to delete the client?",


    controller: {
        loadData: function(filter) {
            var d = $.Deferred();

            $.ajax({
            	   type: 'GET',
            	    url: "../../../fetchAllMiscHead",
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
      
    },

    fields: [
       { name: "oh_id", css: "hide"},
        { name: "hd_typ", type: "text", width: 50 , title: "Type"},
        { name: "description", type: "text", width: 50 , title: "Description"},
        { name: "cal_typ", type: "text", width: 50 , title: "Cal Type"},
        { name: "gst_per", type: "text", width: 50 , title: "GST"},
        { name: "created_by", type: "text", width: 50, title: "Created By"},
        { name: "modified_by", type: "text", width: 50, title: "Modified By" },
        { name: "created_on", type: "text", width: 50, title: "Created On" },
        { name: "modified_on", type: "text", width: 50 , title: "Modified On"},
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
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2">Miscellaneous Head</div>
       <div class="card-body">
         <div id="jsGrid"></div>
       </div>
       </div>
       <br>
        <button type="button"  class="btn btn-default" data-toggle="modal" data-target="#centralModalLGInfoDemo">ADD</button>
		<br><br><br>

                  
               <div class="modal fade" id="centralModalLGInfoDemo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg modal-notify modal-info" role="document">
                <!--Content-->
                <div class="modal-content">
                    <!--Header-->
                    <div class="modal-header">
                        <p class="heading lead">Miscellaneous Head</p>

                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true" class="white-text">&times;</span>
                        </button>
                    </div>
                     <div class="modal-body">
                                     
							<table class="table table-hover">
							

			<!--   <input list="hosting-plan" type="text">
 
		<datalist id="hosting-plan">
    <option value="PA">Purchase</option>
    <option value="CS">Cash Sales</option>
    <option value="CS">Credit Sales</option>
		</datalist> -->
							
							<tr>
							<td>Header Type:</td>
							<td><select name="hd_typ" id="hd_typ" class="mdb-select colorful-select dropdown-primary">                            
                             <option value="PU">Purchase</option>
                             <option value="SA">Sales</option>   
                             </select>
							</td>
							</tr>
								<tr>
							<td>Description:</td>
							<td><input type="text" name=description id="description" placeholder="Description"></td>
							</tr>
								<tr>
							<td>Cal Type:</td>
							<td><select name="cal_typ" id="cal_typ" class="mdb-select colorful-select dropdown-primary">                            
                             <option value="A">Add</option>
                             <option value="L">Less</option>   
                             </select>
							</td>
							</tr>
								<tr>
							<td>GST:</td>
							<td><input type="text" name="gst_per" id="gst_per" placeholder="GST"></td>
							</tr>
							
						</table>
	<tr>
							<td> 
							<input type="submit"  value="Submit" class="btn btn-success" onclick="getUniqueVal();"> 
							
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