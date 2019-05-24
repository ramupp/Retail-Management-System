<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

 <head>
        <meta charset="utf-8">
       <title>Item Master</title>
       <%@include file="../common/include.jsp" %>
<!--        <script src="../../js/jquery.serializejson.js"></script> -->
<script src="../../../resources/js/validation.js"></script> 
 <script>
            function validation1()
            {
               // alert("hiii");
                var name = document.getElementById("itenm");
                //var hsn = document.getElementById("hsn_cd");
               // var gst = document.getElementById("gst_per");
               // var gst1 = document.getElementById("gst_per1");
               // var amount = document.getElementById("amount");
              //  var log_cond = document.getElementById("log_cond");
                var e = document.getElementById("itm_typ_id");

                errors=[];
                checkBlank(name,"Item Name");
              //  checkBlank(hsn,"HSN Code");
               // checkBlank(gst,"GST");
               // checkBlank(gst1,"GST1");
                //(amount,"Amount");
               // checkBlank(log_cond,"Condition");
                Dropdown(e,"Please Select");
                return finalCheck();
               
                
            }

        </script>
        <script>
	function checkDuplicate(param) {
		alert(hiii);
		var tnm="name";
		//var fnm="role_nm";
		
		$.get("../../ajax/getForUniqueValue.jsp", {val : param,tbl_nm:tnm,fld_nm:fnm}, function(response) {
			var x=response.trim();	
			 // alert(x);
		       
		         if(parseInt(x)>0)
		        	 {
		        	 alert("This Role Name already Exists");
		        	 $('#r_nm').val("");
		        	 $('#r_nm').focus();
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
										url : "../../../Additm_master",

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
											//alert("error");
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
            	    url: "../../../fetchAllItemMaster",
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
          	 var d = $.Deferred();
          	 //alert(JSON.stringify(item));
          var p=JSON.parse(JSON.stringify(item));      
              return $.ajax({
                  type: "POST",
                  async: false,
                  url: "../../../itmUpdate",
                  contentType: "application/json",
                  dataType: 'json',
                  //var x = $('#form1').serializeJSON();
      			//var val = JSON.stringify(item.itm_nm),
      			
                  data: JSON.stringify(item),
                  success: function (data) {
               	  // d.resolve(JSON.parse(JSON.stringify(data)));
                	  location.reload();
                  }
              });
          },
          DeleteItem: function(item_master) {
           	 var d = $.Deferred();
           	 //alert(JSON.stringify(item));
           var p=JSON.parse(JSON.stringify(item_master));      
               return $.ajax({
                   type: "POST",
                   async: false,
                   url: "../../../itmDelete",
                   contentType: "application/json",
                   dataType: 'json',
                   //var x = $('#form1').serializeJSON();
       			//var val = JSON.stringify(item.itm_nm),
       			
                   data: JSON.stringify(item_master),
                   success: function (data) {
                	  // d.resolve(JSON.parse(JSON.stringify(data)));
                 	  location.reload();
                   }
               });
           }
        
    },

    fields: [
        { name: "itm_id",  width: 50, css: "hide"},
        { name: "itm_nm", type: "text", width: 50 ,title : "Item"  },
        { name: "itm_typ_nm", type: "text", width: 50 ,title : "Item Type"  },
        { name: "hsn_cd", type: "text", width: 50 ,title : "HSN"  },
        { name: "amount", type: "text", width: 50 ,title : "Amount"  },
        { name: "log_cond", type: "text", width: 50 ,title : "Condition"  },
        { name: "gst_per", type: "text", width: 50 ,title : "GST"  },
        { name: "gst_per1", type: "text", width: 50 ,title : "GST1"  },
        { name: "created_by", type: "text", width: 50, title: "Created By" ,type: "disabled"},
        { name: "modified_by", type: "text", width: 50 , title: "Modified By" ,type: "disabled"},
        { name: "created_on", type: "text", width: 50, title: "Created On" ,type: "disabled"},
        { name: "modified_on", type: "text", width: 50, title: "Modified On" ,type: "disabled"},
        { type: "control" }
    ]
});
});
</script>
<script type="text/javascript">

jQuery(document).ready(function() {
    
 var bean="ItemTypeBean";
 var valcol=["active"];
 var valv=["Y"];
 var getDatas={beanName:bean,valColumn:valcol,valValue:valv};
 var params1=JSON.stringify(getDatas);
 var select_id="itm_typ_id";
 var selectedCol1="itm_typ_id,itm_typ_nm";
 CallDropDownService(params1,select_id,selectedCol1);

});

</script>

</head>
<body class="fixed-sn light-blue-skin">

<%@include file="../common/menu.jsp" %>
             
 <main>
 
    <form id="myForm" name="myForm" method="post" >
    
    <center>
            <div class="card card-cascade wider" style="width: 100%;">
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2">Item Master</div>
       <div class="card-body">
         <div id="jsGrid"></div>
       </div>
       </div>
       <br>
       <% System.out.println("AP==> "+ap);
							if(ap.equalsIgnoreCase("true")){ %>
        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#centralModalLGInfoDemo">ADD</button>
        <% } %>
              <br>
              <br>    
               <div class="modal fade" id="centralModalLGInfoDemo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg modal-notify modal-info" role="document">
                <!--Content-->
                <div class="modal-content"  style="width: 110%;">
                    <!--Header-->
                    <div class="modal-header">
                        <p class="heading lead">Item Master</p>

                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true" class="white-text">&times;</span>
                        </button>
                    </div>
                     <div class="modal-body">
                                     
							<table class="table table-hover">
							
							<tr>
							<td> Select Type:</td>
							<td> <select name="itm_typ_id" id="itm_typ_id" class="mdb-select  colorful-select dropdown-primary " >
                        <option value='0'>---Select Option---</option>
                        </select>
                        </td>
							</tr>
							
							<tr>
							<td>Item:</td>
							<td><input type="text" name="itm_nm" style="text-align: left" id="itenm"  placeholder="Item" onchange="checkDuplicate(this.value)"></td>
							</tr>
							<tr>
							<td>HSN Code:</td>
							<td><input type="text" name="hsn_cd" id="hsn_cd" placeholder="HSN" style="text-align: left"></td>
							</tr>
<!-- 							<tr> -->
<!-- 							<td>GST Per:</td> -->
<!-- 							<td><input type="text" name="gst_per" id="gst_per" placeholder="GST"></td> -->
<!-- 							</tr> -->
							
							<tr>
							<td>GST Criteria:</td>
							<td><input type="text" name="amount" id="amount" style="text-align: right" placeholder="Amount" onkeyup="checkMinus(this.value,this);"></td>
							<td><input type="text" style="text-align: right"   name="log_cond" id="log_cond" style="max-width:80px" placeholder="Condition"></td>
							<td><input type="text" name="gst_per" style="text-align: right" id="gst_per" placeholder="GST" style="max-width:60px"></td>
							<td><input type="text" name="gst_per1" style="text-align: right" id="gst_per1"  style="max-width:60px" placeholder="GST"></td>
						
							</tr>
							
						
	</table>
	<table>
	<tr>
							<td> 
							
							<input type="submit"  value="Submit" class="btn btn-success"> 
							
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