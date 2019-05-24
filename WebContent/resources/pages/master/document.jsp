<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

 <head>
        <meta charset="utf-8">
       <title>Document</title>
       <%@include file="../common/include.jsp" %>
<!--        <script src="../../js/jquery.serializejson.js"></script> -->

  
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
            	    url: "../../../fetchAllDocument",
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
        { name: "itm_id",  width: 50, css: "hide"},
        { name: "doc_id", type: "text", width: 50 ,title : "ID" ,readonly: "false" },
        { name: "doc_nm", type: "text", width: 50 ,title : "Name"  },
        { name: "prefix", type: "text", width: 50 ,title : "Prefix"  },
        { name: "suffix", type: "text", width: 50 ,title : "Suffix"  },
        { name: "digits", type: "text", width: 50 ,title : "Digits"  },
        { name: "active", type: "text", width: 50 ,title : "Active"  },
        { name: "created_by", type: "text", width: 50, title: "Created By" },
        { name: "modified_by", type: "text", width: 50 , title: "Modified By"},
        { name: "created_on", type: "text", width: 50, title: "Created On" },
        { name: "modified_on", type: "text", width: 50, title: "Modified On" },
        { type: "control" }
    ]
});
});
</script>
<script type="text/javascript">

jQuery(document).ready(function() {
    
 var bean="RetailCompanyMasterBean";
 var valcol=["active"];
 var valv=["Y"];
 var getDatas={beanName:bean,valColumn:valcol,valValue:valv};
 var params1=JSON.stringify(getDatas);
 var select_id="co_id";
 var selectedCol1="co_id,co_nm,outlet";
 CallDropDownServiceForConcat(params1,select_id,selectedCol1);

});



</script>
<script type="text/javascript">
       // jQuery.noConflict();
	$(function() {
		$('#myForm').submit(function(event) {
			event.preventDefault();
							
// 							$.each($("input[name='cId']:checked"),
// 									function() {
// 										favorite.push($(this).val());
// 									});
// 							$.each($("input[name='roleId']:checked"),
// 									function() {
// 										favorite.push($(this).val());
// 									});
							
							//alert("My favourite sports are: "
							//		+ favorite.join(", "));
							var x = $('#myForm').serializeJSON();
							var val = JSON.stringify(x);
							//alert("my val is :-"+val);
								//var p=validation1();
								//alert("the val is:-"+p);
										//if(p){ //alert(val);

							$.ajax({

										beforeSend : function(xhrObj) {
											xhrObj.setRequestHeader(
													"Content-Type",
													"application/json");
											xhrObj.setRequestHeader("Accept",
													"application/json");
										},
										type : "POST",
										url : "../../../addDocumentMaster",

										data : val,
										dataType : 'json',

										success : function(data, textStatus) {
											var fin_data = "";
											// 				for (var i = 0; i < data.length; i++) {
											// 					fin_data= data[i].user_id + data[i].user_pw;
											// 				}
											if (data=="success") {
												alert("====Data has been submitted successfully====");
												 location.reload();
// 												window.location
// 														.replace("http://localhost:8081/SpringTest/home.jsp");
											} else {
												 alert("====Data Submition Failed====");	
												location.reload();
// 												$('#msg')
// 														.html(
// 																"Please Provide Valid Login Credentials");
											}
										},
										error : function(xhr, textStatus,
												errorThrown) {
// 											window.location
// 													.replace("http://localhost:8081/SpringTest/login.jsp");
											//	alert(xhr+"-"+textStatus);
											 alert("====Data Submition Failed====");	
													 location.reload();

										}
									});
										//}

						});

	});
</script>
<script>
function getDocDtls(ids,x)
{
	 $.get('../../ajax/getDocDtls.jsp',{"val":ids}, function (response) {
     	console.log(response);
      
        $(x).closest('tr').after(response.trim());
     });	
}
function addNewRow()
{
	// alert("hello");
	
	 var x=$("#cloneRow").clone();
	// $('.x').material_select('destroy');
	//$("#TableId").find("tr").last().after(x);
	$(x).insertBefore("#pqr");
	
	// $('.x').material_select();
	 
}
function afterCheck(x,id)
{// alert(x+"--"+id);
	if ($("#"+id).is(':checked')) {
		$(x).closest("tr").find('#flags').val("on");
	}else
		{
		$(x).closest("tr").find('#flags').val("0");
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
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2">Document</div>
       <div class="card-body">
         <div id="jsGrid"></div>
       </div>
       </div>
       <br>
        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#centralModalLGInfoDemo">ADD</button>
                  
               <div class="modal fade" id="centralModalLGInfoDemo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg modal-notify modal-info" role="document">
                <!--Content-->
                <div class="modal-content" style=" width: 120%">
                    <!--Header-->
                    <div class="modal-header">
                        <p class="heading lead">Document</p>

                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true" class="white-text">&times;</span>
                        </button>
                    </div>
                     <div class="modal-body">
                             <table style=" float: right">
							<tr>
						<td><button type="button" class="btn btn-mdb-color btn-sm" onclick="addNewRow()"><i> Details</i></button>
						</tr>
							</table>        
							<table class="">
							
							<tr id="cloneRow">
							<td>Select Outlet:</td>
							<td> <select name="co_id[]" id="co_id" class="browser-default" onchange="getDocDtls(this.value,this)">
                        <option value='0'>---Select Option---</option>
                        </select>
                        </td>
                        
							</tr>
							<tr id="pqr"></tr>
						
							</table>
							
							<table>
							<tr>
							<td> 
							<input type="submit"  value="Submit" class="btn btn-success" > 
							</tr>
								</table>
	
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