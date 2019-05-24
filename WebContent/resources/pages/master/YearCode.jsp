<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
 <head>
        <meta charset="utf-8">
       <title>Year Code</title>
       <%@include file="../common/include.jsp" %>
<!--        <script src="../../js/jquery.serializejson.js"></script> -->
<script src="../../../resources/js/validation.js"></script> 
   <script>
            function validation1()
            {
               // alert("hiii");
                var Code = document.getElementById("yr_cd");
                var S_Date = document.getElementById("st_date");
                var E_Date = document.getElementById("end_date");

                
              
                errors=[];
                checkBlank(Code,"Year Code");
                checkBlank(S_Date,"Start Date");
                checkBlank(E_Date,"End Date");
               
                return finalCheck();
               
                
            }

        </script>
         <script>
	function checkDuplicate(param) {
	
		var tnm="mst_yr_code";
		var fnm="yr_cd";
		
		$.get("../../ajax/getForUniqueValue.jsp", {val : param,tbl_nm:tnm,fld_nm:fnm}, function(response) {
			var x=response.trim();	
			 //alert(x);
		       
		         if(parseInt(x)>0)
		        	 {
		        	 alert("Year Code already Exists");
		        	 $('#yr_cd').val("");
		        	 $('#yr_cd').focus();
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
										url : "../../../Add_yr_cd_master",

										data : val,
										dataType : 'json',

										success : function(data, textStatus) {
												//alert(data);
												
												
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
            	    url: "../../../fetchAllYearCode",
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
                url: "../../../yearcodeUpdate",
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
                url: "../../../year_cdDelete",
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
        { name: "yr_cd_id", type: "text", css: "hide"},
        { name: "yr_cd", type: "text", width: 50, title: "Year Code" ,type: "disabled"},
        { name: "st_date", type: "text", width: 50 , title: "Start Date" ,type: "disabled"},
        { name: "end_date", type: "text", width: 50 , title: "End Date" ,type: "disabled"},
        { name: "created_by", type: "text", width: 50, title: "Created By" ,type: "disabled"},
       // { name: "modified_by", type: "text", width: 50 , title: "Modified By" ,type: "disabled"},
        { name: "created_on", type: "text", width: 50 , title: "Created On" ,type: "disabled"},
       // { name: "modified_on", type: "text", width: 50, title: "Modified On" ,type: "disabled"}
       // { type: "control" }
    ]
});
});
</script>
  	

</head>
<body class="fixed-sn light-blue-skin">

<%@include file="../common/menu.jsp" %>
             
 <main>
 
    <form id="myForm" name="myForm" method="post">
    
    <center>
            <div class="card card-cascade wider" style="width: 100%;">
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2">Year Code</div>
       <div class="card-body">
         <div id="jsGrid"></div>
       </div>
       </div>
       <br>
        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#centralModalLGInfoDemo">ADD</button>
            <br><br>      
               <div class="modal fade" id="centralModalLGInfoDemo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg modal-notify modal-info" role="document">
                <!--Content-->
                <div class="modal-content">
                    <!--Header-->
                    <div class="modal-header">
                        <p class="heading lead">Year Code</p>

                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true" class="white-text">&times;</span>
                        </button>
                    </div>
                     <div class="modal-body">
                                     
							<table class="table table-hover">
							
							<tr>
							<td>Year Code:</td>
							<td><input type="text" name="yr_cd" id="yr_cd" placeholder="Year Code" style="text-align: right" onchange="checkDuplicate(this.value)"></td>
							</tr>
							 <tr>
                            <th>
                                Start Date :
                            </th>

                            <td>
                               <input placeholder="Selected date" type="text" name="st_date" id="st_date" class="form-control datepicker">
                        
                            </td>
                            </tr>
                             <tr>
                            <th>
                                End Date :
                            </th>

                            <td>
                               <input placeholder="Selected date" type="text" name="end_date" id="end_date" class="form-control datepicker">
                        
                            </td>
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