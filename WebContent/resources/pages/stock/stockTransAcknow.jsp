<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Role Creation Page....</title>
<%@include file="../common/include.jsp" %>

<style type="text/css">
.table-wrapper {
    display: block;
    max-height: 300px;
    overflow-y: auto;
    -ms-overflow-style: -ms-autohiding-scrollbar;
}
}
</style>

<!--  <style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style> -->

<script type="text/javascript">

// jQuery(document).ready(function() {
 //function beginDropDownService() { 
	
//  var bean="RetailCompanyMasterBean";
//  var valcol=["active"];
//  var valv=["Y"];
//  var getDatas={beanName:bean,valColumn:valcol,valValue:valv};
//  var params1=JSON.stringify(getDatas);
//  var select_id="comp_id";
//  var selectedCol1="co_id,co_nm";
//  CallDropDownService(params1,select_id,selectedCol1);
 
//  var bean1="YearCodeBean";
//  var valcol1=["active"];
//  var valv1=["Y"];
//  var getDatas1={beanName:bean1,valColumn:valcol1,valValue:valv1};
//  var params11=JSON.stringify(getDatas1);
//  var select_id1="yrcode";
//  var selectedCol11="yr_cd_id,yr_cd";
//  CallDropDownService(params11,select_id1,selectedCol11);
 
//  var bean2="UomMasterBean";
//  var valcol2=["active"];
//  var valv2=["Y"];
//  var getDatas2={beanName:bean2,valColumn:valcol2,valValue:valv2};
//  var params12=JSON.stringify(getDatas2);
//  var select_id2="u_id";
//  var selectedCol12="uom_id,uom_nm";
//  CallDropDownService(params12,select_id2,selectedCol12);
 
//  var bean3="RetailTempBean";
//  var valcol3=["active"];
//  var valv3=["Y"];
//  var getDatas3={beanName:bean3,valColumn:valcol3,valValue:valv3};
//  var params13=JSON.stringify(getDatas3);
//  var select_id3="des_id";
//  var selectedCol13="desg_no,desg_no";
//  CallDropDownService(params13,select_id3,selectedCol13);

//  var bean5="RetailTempBean";
//  var valcol5=["active"];
//  var valv5=["Y"];
//  var getDatas5={beanName:bean5,valColumn:valcol5,valValue:valv5};
//  var params15=JSON.stringify(getDatas5);
//  var select_id5="desg_no_p";
//  var selectedCol15="desg_no,desg_no";
//  var allTag='Y';
//  CallDropDownService(params15,select_id5,selectedCol15,allTag);





//  var bean6="RetailCompanyMasterBean";
//  var valcol6=["active"];
//  var valv6=["Y"];
//  var getDatas6={beanName:bean6,valColumn:valcol6,valValue:valv6};
//  var params16=JSON.stringify(getDatas6);
//  var select_id6="co_nm_p";
//  var selectedCol16="co_id,co_nm";
//   var allTag='Y';
//  CallDropDownService(params16,select_id6,selectedCol16,allTag);
 
// });
//}


</script>
<script type="text/javascript">

$(document).ready(function() {
   
   
   $('.datepicker').pickadate({
  	
  	  format: 'yyyy-mm-dd'
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
            	    url: "../../../fetchStockTransAcknow",
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
                url: "../../../itmtypUpdate",
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
     { name: "tr_hid", css: "hide"},
//      { name: "pck_sl_no", type: "text", width: 70,title : "Packing Slip No"  },
//      { name: "pck_sl_dt", type: "text", width: 70,title : "Packing Slip Data"  },
     { name: "co_nm", type: "text", width: 70 ,title : "Outlet" },
//      { name: "no_of_pck", type: "text", width: 70,title : "No. of Packing"  },
//      { name: "tot_qty", type: "text", width: 70,title : "Total Quantity"  },
     { name: "bill_no", type: "text", width: 70,title : "Bill No"  },
		{ name: "bill_dt", type: "text", width: 70,title : "Bill Date"  },
     { name: "finBasic", type: "text", width: 70,title : "Basic"  },

//      { name: "amt_in_word", type: "text", width: 50,title : "Amount In Word"  },
     { name: "fin_dis_amt", type: "text", width: 50,title : "Discount Amount"  },
     { name: "fin_igst_amt", type: "text", width: 50,title : "Discount IGST"  },
     { name: "fin_cgst_amt", type: "text", width: 50,title : "Discount CGST"  },
     { name: "fin_sgst_amt", type: "text", width: 50,title : "Discount SGST"  },
//      { name: "salesman", type: "text", width: 50,title : "Salesman"  },
//      { name: "helper", type: "text", width: 50,title : "Helper"  },
     { type: "control",itemTemplate: function(value, item) {
       	 var $result = jsGrid.fields.control.prototype.itemTemplate.apply(this, arguments);

         var $customEditButton = $("<p>").attr({class: "customGridEditbutton fa fa-caret-square-o-right"})
           .click(function(e) {
        	   e.preventDefault();
             //alert("ID: " + item.tr_hid);
             $.get('../../../resources/ajax/getStockAckView.jsp', {tr_hid: item.tr_hid}, function (response)
                     {
                       // alert(response);
                     $('#viewGrid').html(response);
                     jQuery('.x').material_select();
                     //jQuery("#mdb-lightbox-ui").load("mdb-addons/mdb-lightbox-ui.html");
                    jQuery('#myModal').modal('show');
                     });
                     
             e.stopPropagation();
           });
        
         return $("<div>").append($customEditButton);
    } }
    ]
});
	 });

</script>

<script type="text/javascript">
	$(function() { 
		$('#form1').submit(function(event) {
			event.preventDefault();
							var x = $('#form1').serializeJSON();
							var val = JSON.stringify(x);
							console.log(val);
							//alert(val);
								//	var p=validation1();
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
										url : "../../../purchaseEntry",

										data : val,
										dataType : 'json',

										success : function(data, textStatus) {
																					
											
											if (data=="" || data==null) {
												alert("====Sorry!! Your Data has not been saved====");
												location.reload();
												
												//window.location
												//		.replace("http://localhost:8081/SpringTest/home.jsp");
											} else {
												// alert("====Unauthorised Login====");	
													alert("Ur Data Has Been Saved Suceessfully with Memo No:-"+data);
												location.reload();
											}
										},
										error : function(xhr, textStatus,
												errorThrown) {
											alert("====Sorry!! error in page===="+errorThrown+","+textStatus);
											 location.reload();
										}
									});
									//	}
						});

	});
</script>




   
     
    </head>
    <body class="fixed-sn light-blue-skin" > 
    <%@include file="../common/menu.jsp" %>
<main>
        <form id="form1" name="form_1" method="post">
<center>
          <div class="card card-cascade wider" style="width: 100%;">
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2"> Stock Transfer (Stock-In)</div>
       <div class="card-body">

         <div id="jsGrid"></div>
        
       </div>
       </div>
       <br>
        
       <br>
         <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document" style=" max-width: 90%">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Stock Transfer Ackowledgement (Stock-In)..</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" id="viewGrid">
            
            </div>
            <div class="modal-footer">
              
                <input type="submit" class="btn btn-primary btn-sm" value="Ackowledged"/>
            </div>
        </div>
    </div>
</div>    
      
              </center>
        </form>
        </main>
    </body>
    <%@include file="../common/footer.jsp" %>    
</html>    