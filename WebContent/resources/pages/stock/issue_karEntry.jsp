<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>Puchase Page....</title>

<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->


  <script src="../../../resources/js/jquery-1.11.0.js"></script> 
  <%@include file="../common/include.jsp" %>        
<!--      <script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
   <script src="../../../resources/js/validation.js"></script> 
 <script> 
             function validation1()
             {
              // alert("hiii");
                 // var item_type = document.getElementById("item_typ_id");
                var bill_no = document.getElementById("inv_no");
                  var item_id = document.getElementById("item_id");
                  var vendor = document.getElementById("party_cd");
//                  var payment = document.getElementById("pay_terms");
                 var design = document.getElementById("desg_id");
//                  var quantity = document.getElementById("qty");
                var item_type = document.getElementById("item_typ_id");
//                  var rate = document.getElementById("rate");
//                 var mis = document.getElementById("miscH");
//                  var amount = document.getElementById("miscHamt");
              
              
               

               errors=[];
                 //checkBlank(item_type,"Item Type");
                checkBlank(bill_no,"Invoice No");
               //checkBlank(item_id,"Item");
                 Dropdown9(vendor,"Please Select");
                 params=["pivotElement","#qty","#rate","#dis_per","#gst_per"];
                 validationForDetail(params);
//                 checkBlank(payment,"Payment Terms");
 //                 Dropdown10(design,"Please Select");
//                 checkBlank(quantity,"Quantity");
//                 Dropdown11(item_type,"Please Select");
//               checkBlank(rate,"Rate");
//                 Dropdown12(item_id,"Please Select");
//                checkBlank(amount,"Amount");

             
             return finalCheck();
               
                
          }

    </script> 
    
    <script type="text/javascript">
    function fetchDesignData()
    {
    	jQuery.noConflict();
    	// var availableTags = [{"id":1,"label":"ActionScript"},{"id":2,"label":"BppleScript"}];
    	//var coid=$('#company_id').val();
    	jQuery.get('../../../fetchDesign',{}, function (response) {
    	    // alert(response);desg_id//
    	    
    	    $('.testD').autocomplete({
    	    	    source:response,
    	    	    select: function( event, ui ) { //alert(ui.item.id);
    	    	    	// alert(ui.item.label);
    	    	   // $('#uid').val(ui.item.id);
    	    	    //getCashSaleParty(ui.item.id);
//     	    	    var x=$('#company_id').val();
//     	    	    afterDesgChange(event.,x);
//     	    	    fetchItemTypeAndItemFromDesign(this,x);
    	    	    	
    	    	    }
    	    	});
    	          

    	      });		
    }
    
    </script>
  
         
       

     

    <script src="../../../resources/js/purchase.js"></script> 
<style type="text/css">
.table-wrapper {
    display: block;
    max-height: 300px;
    overflow-y: auto;
    -ms-overflow-style: -ms-autohiding-scrollbar;
}
}
</style>

<script type="text/javascript">
 jQuery.noConflict();
 jQuery(document).ready(function($){
$("#jsGrid").jsGrid({
    width: "100%",
    inserting: false,
    filtering: true,
    editing: false,
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
            	    url: "../../../fetchPurchaseDetails",
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
             {name:"pur_id", css:"hide"},
        { name: "pur_no", type:"text",width:60,title: "Pur No"},
        { name: "pur_dt", type: "text", width: 70 ,title : "Pur Date"  },
        { name: "inv_no", type: "text", width: 50 ,title : "Invoice No"  },
        { name: "inv_dt", type: "text", width: 70 ,title : "Invoice Date"  },
       // { name: "party_cd", type: "text", width: 50 ,title : "Party Code"  },
       // { name: "pur_typ", type: "text", width: 50 ,title : "Party Type"  },
        { name: "tot_amt", type: "text", width: 50 ,title : "Total Amount"  },
        //{ name: "tot_disc", type: "text", width: 50 ,title : "Total Discount"  },
        { name: "net_amt", type: "text", width: 50 ,title : "Net Amount"  },
        { name: "tot_bas_amt", type: "text", width: 50 ,title : "Final Basic"  },
        { name: "tot_dis_amt", type: "text", width: 50 ,title : "Total Discount"  },
        { name: "tot_cgst_amt", type: "text", width: 50 ,title : "Final CGST"  },
        { name: "tot_sgst_amt", type: "text", width: 50 ,title : "Final SGST"  },
        { name: "tot_igst_amt", type: "text", width: 50 ,title : "Final IGST"  },
        { name: "pay_terms", type: "text", width: 50, title: "Payment Terms" },
//         { name: "modified_by", type: "text", width: 50 , title: "Modified By"},
//        { name: "created_on", type: "text", width: 50, title: "Created On" },
//         { name: "modified_on", type: "text", width: 50, title: "Modified On" },
      { type: "control",itemTemplate: function(value, item) {
       	 var $result = jsGrid.fields.control.prototype.itemTemplate.apply(this, arguments);

         var $customEditButton = $("<p>").attr({class: "customGridEditbutton fa fa-caret-square-o-right"})
           .click(function(e) {
        	   e.preventDefault();
             //alert("ID: " + item.tr_hid);
             $.get('../../../resources/ajax/getPurchaseDtlView.jsp', {pur_id: item.pur_id}, function (response)
                     {
                       // alert(response);
                     $('#viewGrid').html(response);
                     jQuery('.x').material_select();
                     jQuery('.datepicker').pickadate({
                    	  	
                      	  format: 'yyyy-mm-dd'
                     	}); 
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
<script type="text/javascript" src="https://printjs-4de6.kxcdn.com/print.min.js"></script>
<link type="text/css" rel="stylesheet" href="https://printjs-4de6.kxcdn.com/print.min.css" />
<script>
function printCode(code,purno,pdt)
{ //alert(code+purno);
	$.get('../../../resources/ajax/generateBarcode.jsp',{code:code,purno:purno,pdt:pdt}, function (response) {
      //	alert(response.trim());
      	var m="../../../../birt-viewer/Retail/BARCODE/"+response.trim();
      	//alert(m);
    	printJS(m);
      
      });

}



</script>

<script type="text/javascript">

$(window).load(function(){
	
	var pxx=$('#cloneRow').clone();
	$('#addRowValue').html(pxx);
});


$(document).ready(function() {
	//$.noConflict();
	jQuery('.mdb-select').material_select();
   
   $('.datepicker').pickadate({
  	
  	  format: 'yyyy-mm-dd',
  	  max:new Date()
  	}); 
   
   
   
   $(document).ready(function() {
	   
	   fetchDesignData();
	   
   });
  
   

 
  
// var bean1="RetailTempBean";
// var valcol1=["active"];
// var valv1=["Y"];
// var getDatas1={beanName:bean1,valColumn:valcol1,valValue:valv1};
// var params11=JSON.stringify(getDatas1);
// var p1="desg_id";
// var selectedCol11="tr_id,desg_no";
// CallDropDownService(params11,p1,selectedCol11);
 
var bean3="ItemRateTypeBean";
var valcol3=["active"];
var valv3=["Y"];
var getDatas3={beanName:bean3,valColumn:valcol3,valValue:valv3};
var params13=JSON.stringify(getDatas3);
var p3="rt_type";
var selectedCol13="rt_typ_id,rt_typ_nm";
CallDropDownService(params13,p3,selectedCol13);


var beans="OtherHeadsHdr";
var valcols=["active","hd_typ"];
var valvs=["Y","PU"];
var getDatass={beanName:beans,valColumn:valcols,valValue:valvs};
var params1s=JSON.stringify(getDatass);
var ps="miscH";
var selectedCol1s="oh_id,description";
CallDropDownService(params1s,ps,selectedCol1s);

var bean1="PartyViewBean";
var valcol1=["active","party_typ"];
var valv1=["Y","SC"];
var getDatas1={beanName:bean1,valColumn:valcol1,valValue:valv1};
var params11=JSON.stringify(getDatas1);
var p1="party_cd";
var selectedCol11="party_id,party_nm";
CallDropDownService(params11,p1,selectedCol11);

});  

function getItemFromType(param)
{
	var beanl="PartyViewBean";
	var valcol1=["active","party_typ"];
	var valv1=["Y","SC"];
	var getDatas1={beanName:bean1,valColumn:valcol1,valValue:valv1};
	var params11=JSON.stringify(getDatas1);
	var p1="party_cd";
	var selectedCol11="party_id,party_nm";
	CallDropDownService(params11,p1,selectedCol11);
	
	
}



</script>
<script>
// $(document).ready(function() {
// var bean1="UomMasterBean";
// var valcol1=["active"];
// var valv1=["Y"];
// var getDatas1={beanName:bean1,valColumn:valcol1,valValue:valv1};
// var params11=JSON.stringify(getDatas1);
// var p1="uom_id";
// var selectedCol11="uom_id,uom_nm";
// CallDropDownService(params11,p1,selectedCol11);

//});

</script>

<script>

</script>

<script type="text/javascript">
	$(function() { 
		 jQuery.noConflict();
		$('#form1').submit(function(event) {
			event.preventDefault();
			//alert("hii");
							var x = jQuery('#form1').serializeJSON();
							var val = JSON.stringify(x);
							//alert(val);
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
										url : "../../../purchaseEntry",

										data : val,
										dataType : 'json',

										success : function(data, textStatus) {
											//alert("1");
											//alert(data);
											
											
											if (data=="" || data==null) {
												alert("====Data has not been saved====");
												location.reload();
												
												//window.location
												//		.replace("http://localhost:8081/SpringTest/home.jsp");
											} else {
												// alert("====Unauthorised Login====");	
													alert("Data Has Been Saved Suceessfully with Memo No:-"+data);
												location.reload();
											}
										},
										error : function(xhr, textStatus,
												errorThrown) {
											alert("====Data have some error====");
										}
									});
										}
						});

	});
</script>

<script>
// function getFinalValues()
// {
// 	var tot_bas_amt=  $('#tot_bas_amt').val();
// 	var tot_dis_amt=  $('#tot_dis_amt').val();
// 	var tot_cgst_amt= $('#tot_cgst_amt').val();
// 	var tot_sgst_amt= $('#tot_sgst_amt').val();
// 	var tot_igst_amt= $('#tot_igst_amt').val();
// 	var tot_amt=      $('#tot_amt').val();
	
// 	var sum1=0.00,sum2=0.00,sum3=0.00,sum4=0.00,sum5=0.00,sum6=0.00;
	
// 	$(".omiscHamt").each(function() {
// 		 //var x=$(this).val();
// 		 var x= $(this).val() == '' ? 0.00 : $(this).val();
		 
// 		 sum1=parseFloat(sum1)+parseFloat(x);
// 		// alert(sum1);
// 		});
	
// 	$(".ocgstClass").each(function() {
// 		 //var x=$(this).val();
// 		 var x= $(this).val() == '' ? 0.00 : $(this).val();
		 
// 		 sum2=parseFloat(sum2)+parseFloat(x);
// 		// alert(sum1);
// 		});
	
// 	$(".osgstClass").each(function() {
// 		 //var x=$(this).val();
// 		 var x= $(this).val() == '' ? 0.00 : $(this).val();
		 
// 		 sum3=parseFloat(sum3)+parseFloat(x);
// 		// alert(sum1);
// 		});
	
// 	$(".oigstClass").each(function() {
// 		 //var x=$(this).val();
// 		 var x= $(this).val() == '' ? 0.00 : $(this).val();
		 
// 		 sum4=parseFloat(sum4)+parseFloat(x);
// 		// alert(sum1);
// 		});
	
// 	$(".oamtClass").each(function() {
// 		 //var x=$(this).val();
// 		 var x= $(this).val() == '' ? 0.00 : $(this).val();
		 
// 		 sum5=parseFloat(sum5)+parseFloat(x);
// 		// alert(sum1);
// 		});
	
// 	$('#finBasic').val(parseFloat(tot_bas_amt)+parseFloat(sum1));
// 	$('#fin_dis_amt').val(parseFloat(tot_dis_amt));
// 	$('#fin_cgst_amt').val(parseFloat(tot_cgst_amt)+parseFloat(sum2));
// 	$('#fin_sgst_amt').val(parseFloat(tot_sgst_amt)+parseFloat(sum3));
// 	$('#fin_igst_amt').val(parseFloat(tot_igst_amt)+parseFloat(sum4));
// 	$('#net_amt').val(parseFloat(tot_amt)+parseFloat(sum5));
	
// 	}
 

</script>



 <!--  <script>
            function validation1()
            {
                //alert("hiii");
                var p_date = document.getElementById("pur_dt");
                var bill_no = document.getElementById("inv_no");
                var bill_date = document.getElementById("inv_dt");
                var vendor = document.getElementById("party_cd");
                var payment = document.getElementById("pay_terms");
                var design = document.getElementById("desg_id");
                var quantity = document.getElementById("qty");
                var uom = document.getElementById("uom_id");
                var rate = document.getElementById("rate");
                var mis = document.getElementById("miscH");
                var amount = document.getElementById("miscHamt");
              
              
               

                errors=[];
                checkBlank(p_date,"Date");
                checkBlank(bill_no,"Bill No");
                checkBlank(bill_date,"Bill Date");
                Dropdown9(vendor,"Please Select");
                checkBlank(payment,"Payment Terms");
                Dropdown10(design,"Please Select");
                checkBlank(quantity,"Quantity");
                Dropdown11(uom,"Please Select");
                checkBlank(rate,"Rate");
                Dropdown12(mis,"Please Select");
                checkBlank(amount,"Amount");

             
                return finalCheck();
               
                
            }

        </script> -->
        
        <script>
        function checkDOB(param) {
            var dateString = param;
            var myDate = new Date(dateString);
            var today = new Date();
            if ( myDate > today ) { 
                alert('You cannot enter future date!!!...');
                $('#pur_dt').val("");
                return false;
            }
            return true;
        }
        
        </script>
        
         <script>
        function checkDateGreater(param) {
            var dateString = param;
            //2018-01-01
            var pdt = $("#pur_dt").val();
            var idt = $("#inv_dt").val();
            
            var p_dt = pdt.substring(8,10);
          //  alert(p_dt);
           
            var i_dt = idt.substring(8,10);
          //  alert(i_dt);
            if(parseInt(i_dt) > parseInt(p_dt))
            	{
            	alert('Invoice cannot be greater than Purchase date!!!...'); 
            	$("#pur_dt").val('');
            	$("#inv_dt").val('');
            	return false;
            	}
        }
        
        </script>
        





</head>
  <body class="fixed-sn mdb-skin-custom">
<%@include file="../common/menu.jsp"%>

      <main>
<!--       <div class="ui-widget"> -->
<!--   <label for="tags">Tags: </label> -->
<!--   <input id="tags"> -->
<!-- </div> -->
        
         <div class="main-wrapper">
          <div class="container-fluid">
          <input type="hidden" name="val" id="val" />
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2" style="width:100%;"> Purchase Entry</div>
     <ul class="nav nav-tabs nav-justified indigo" role="tablist">
    <li class="nav-item">
        <a class="nav-link active" data-toggle="tab" href="#panel5" role="tab"><i class="fa fa-plus"></i> Add Purchase Entry</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#panel6" role="tab"><i class="fa fa-edit"></i> View/Update Purchase Details</a>
    </li>
   
</ul>
        <div class="tab-content">
                
                <div class="tab-pane fade in show active" id="panel5" role="tabpanel">
       <form id="form1" name="form_1" method="post" >
                 <table class="table table-hover" style="width:100%;">
                   <tr>
<!--                     <th> -->
<!-- 				PNo: -->
<!-- 				</th> -->
<!-- 				<td> -->
				<%
				//String memo_no=util.findFinalUpdatedId("PURC");
				
				
				%>
<%-- 				 <input type="text" placeholder="Enter purno" name="pur_no" id="pur_no" value="<%=memo_no%>" class="form-control" /> --%>
				
<!-- 				</td> -->
                <th>
                Date:
                        </th>
                        <td colspan="1">
                          <input placeholder="Enter date" type="text" name="pur_dt" id="pur_dt" onchange="checkDateGreater(this.value);" class="form-control datepicker">
                        	
                        
                        </td>
						  
                       
						<th>
                              InvoiceNo:
                            </th>

                            <td>
                                 
                        <input type="text" placeholder="Enter billno" name="inv_no" id="inv_no" class="form-control"/>
                         <input type="hidden" name="vr_type" id="vr_type" value="PURC"/>
                            </td>
                            
                          
                            <th>
                                InvoiceDate:
                            </th>

                            <td colspan="2">
                          <input placeholder="Enter Bill date" type="text" name="inv_dt" id="inv_dt" onchange="checkDateGreater(this.value);" class="form-control datepicker">
                           </td>
						</tr>
                        <tr>
                        <th>
                       Vendor:
                        </th>
                        
                        <td colspan="">
                          <select name="party_cd" id="party_cd" class="browser-default" onchange="">
                          <option value='0'>---select Option---</option>
                          <%
                          UtilityHelper u=new UtilityHelper();
                          String value=u.getDropdownStringForParty("mst_party", "party_id", "party_nm", "0","SC");
                          out.println(value);
                          %>
                        
                        </select>
                        </td>
                        
                        <th>
                       Payment Terms:
                        </th>
                        <td>
                         <input type="text" placeholder="Enter payment terms" name="pay_terms" id="pay_terms" onkeypress="checkMinus(this.value,this);" class="form-control"/> (no of days.)                       
                        </td>
<!--                         <td style="text-align:left;width:5px;"> -->
                        
<!--                         </td> -->
                        </tr>
                    </table>
                    
                    <%
                    MyConnection mycon=new MyConnection();
                   Connection newcon= mycon.getConnection("adm_retail");
                   String qry="SELECT uom_nm FROM mst_uom";
                   String db="adm_retail";
                   ResultSet rsnew = mycon.getResultSet(qry, db); 
                    %>
                    
<!--                     <br> -->
                  <div class="table-responsive" align="left">
                    <table class="table-bordered" align="left" style="width:80%;">
<!--                     <tr> -->
<!--                     <td colspan="6"  align="right"><button type="button" class="btn btn-mdb-color btn-sm" onclick="addNewRow()"><i>ADD Details</i></button> -->
                    
<!--                     <td colspan="7" align="left"> -->
<!--                     <button type="button" class="btn btn-primary btn-sm" onclick="addNewMiscRow()"><i class="fa fa-plus-square mr-1"></i> Add/Less Misc.</button> -->
<!--                     </td> -->
<!--                     </tr> -->
                    <tr style=" background-color: cyan; text-align: center;">
                    
                    <th>Design 
                    <th>Item Type
                    <th>Item
<!--                     <th>Quantity -->
                    <%
                    while(rsnew.next())
                    {
                    %>
                    <th><%=rsnew.getString("uom_nm")%>
                    <% 
                    } 
                    rsnew.beforeFirst();
                    %>
<!--                     <th>UOM -->
                    <th>Rate
                    <th>Basic
                    <th>Discount(%)
                    <th>Discount Amt.
                    <th>GST(%)
                    <th>CGST Amt.                     
                    <th>SGST Amt.                    
                    <th>IGST Amt.                    
                    <th>Amount
                   
                    </tr>
                   <tr id="cloneRow">
                  <td><input type="text" name="desg_id1[]" id="desg_id" style=" width: 100px;text-align:right;" class="testD pivotElement" onchange="fetchItemTypeAndItemFromDesign(this,<%=coid%>);"/>
				  <input type="hidden" name="desg_id[]" id="desg_id1"/>
                    <td><select name="item_typ_id[]" id="item_typ_id" class="browser-default" onchange="fetchItemType(this,this.value);" style="width: 100px;">
                        <option value='0'>---select Option---</option>           
                        </select>
                    <td><select name="item_id[]" id="item_id" class="browser-default" style=" width: 100px;">
                        <option value='0'>---select Option---</option>           
                        </select>
                    
                    <td style=" display: none"><input type="text" name="qty[]" id="qty" style=" width: 100px;text-align:right;" onchange="getGstValues(this);checkMinus(this.value,this);"/>
							<%
							String sid="";
	                           while(rsnew.next()){ 
	                        	   sid=sid + rsnew.getString("uom_nm") + "-";
	                           }
	                           rsnew.beforeFirst();
	                           System.out.println("SID==> "+sid);
							%>
                           <%                            
                           while(rsnew.next()){ 
                        	  
                           %>
                    <td><input type="text" name="nuom_id[]" id="<%=rsnew.getString("uom_nm")%>" onkeypress="checkMinus(this.value,this);" onchange="afterRateChange(this);putUomData(this.id,this,this.value,'<%=sid%>');" style="width:70px;text-align:right;"/>
                    
                    <%    
                    	}
                    %>
                    <td style=" display: none"><input type="text" name="uom_id[]" id="uom_id" style=" width: 100px;text-align:right;"/>
                    <input type="hidden" name="bar_code[]" id="bar_code" style=" width: 100px;text-align:right;"/>
<!-- 					<td><select name="uom_id[]" id="uom_id" class="browser-default"> -->
<!--                         <option value='0'>---select Option---</option>            -->
<!--                         </select> -->
                    <td><input type="text" name="rate[]" id="rate" style=" width: 100px;text-align:right;" onblur="addNewRow(this,this.value);" onkeyup="getGstValues(this);afterRateChange(this);checkMinus(this.value,this);"/>
                    <input type="hidden" name="rate1[]" id="rate1" />
                    <td><input type="text" name="basic[]" id="basic" readonly style=" width: 100px;text-align:right;" class="basClass" value='0.00'/>
                    <td><input type="text" name="dis_per[]" id="dis_per" style=" width:100px;text-align:right;" value='0.00' onkeyup="afterRateChange(this);getGstValues(this);checkMinus(this.value,this);"/>
                    <td><input type="text" name="dis_amt[]" id="dis_amt" readonly style=" width: 100px;text-align:right;" value='0.00' class="disClass" />
                    <td><input type="text" name="gst_per[]" id="gst_per" style=" width: 100px;text-align:right;" value='0.00' onkeyup="getGstValues(this);checkMinus(this.value,this);"/>
                    <td><input type="text" name="cgst_amt[]" id="cgst_amt" readonly style=" width: 100px;text-align:right;" value='0.00' class="cgstClass" onkeyup="afterRateChange(this)"/>
                    <td><input type="text" name="sgst_amt[]" id="sgst_amt" readonly style=" width: 100px;text-align:right;" value='0.00' class="sgstClass" onkeyup="afterRateChange(this)"/>
                    <td><input type="text" name="igst_amt[]" id="igst_amt" readonly style=" width: 100px;text-align:right;" value='0.00' class="igstClass" onkeyup="afterRateChange(this)"/>
                    <td><input type="text" name="amt[]" id="amt" style=" width: 100px;text-align:right;" value='0.00' class="amtClass"/>
                    </tr>
                    <tr id="insertBefore" class="table-info">
                     <th>
                    <th>
                    <th>
                                  
                     <% rsnew.beforeFirst();
                    while(rsnew.next())
                    {
                    %>
                    <th>
                    <% 
                    } 
                    rsnew.beforeFirst();
                    %>                 
                    <th style="text-align:right;font-weight: bold;">Total:-
                    <td><input type="text" name="tot_bas_amt" readonly id="tot_bas_amt" class=" border-danger" style=" width: 100px;text-align:right;" value='0.00'/>
                    <th>
                   
                     
                    <td><input type="text" name="tot_dis_amt" readonly id="tot_dis_amt" class=" border-danger" style=" width: 100px;text-align:right;" value='0.00'/>
                   <th>
                    <td><input type="text" name="tot_cgst_amt" readonly id="tot_cgst_amt" class=" border-danger"  style=" width: 100px;text-align:right;" value='0.00'/>
                     <td><input type="text" name="tot_sgst_amt" readonly id="tot_sgst_amt" class=" border-danger"  style=" width: 100px;text-align:right;" value='0.00'/>
                      <td><input type="text" name="tot_igst_amt" readonly id="tot_igst_amt" class=" border-danger"  style=" width: 100px;text-align:right;" value='0.00'/>
                   
                    <td><input type="text" name="tot_amt" id="tot_amt" readonly class=" border-danger"  style=" width: 100px;text-align:right;" value='0.00'/>
                    </tr>
                     <tr id="cloneRow1">
                    <th>
                     <% rsnew.beforeFirst();
                    while(rsnew.next())
                    {
                    %>
                    <th>
                    <% 
                    } 
                    rsnew.beforeFirst();
                    %>
                    <th colspan="2" style="text-align: right;font-weight: bold;">Misc Head:-
                    <td colspan="1" style="text-align: right;"> <select name="miscH[]" id="miscH" class="browser-default" onchange="fetchOtherHead(this.value,this.id,this)">
             <option value='0'>---select Option---</option>
             </select>
             
              <td><input type="text" placeholder="Amount"  onkeypress="checkMinus(this.value,this);" name="miscHamt[]" id="miscHamt" style="width: 100px; text-align:right" onblur="addNewMiscRow(this.value,this)" class="omiscHamt" onkeyup="calculateMgst(this.value,this)" />
              <input type="hidden" name="miscHamt1[]"  id="miscHamt1" /> 
              </td>
                  
                    <th colspan="2">
                    <td><input type="text" name="o_gst_per[]" id="o_gst_per" style=" width: 100px; text-align:right" value='0.00' onkeyup="getOtherGstValues(this);"/></td>
                    <td><input type="text" name="o_cgst_amt[]" readonly id="o_cgst_amt" style=" width: 100px; text-align:right" value='0.00' onkeyup="afterRateChange(this);" class="ocgstClass" /></td>
                     <td><input type="text" name="o_sgst_amt[]" readonly id="o_sgst_amt" style=" width: 100px; text-align:right" value='0.00' onkeyup="afterRateChange(this);" class="osgstClass" /></td>
                      <td><input type="text" name="o_igst_amt[]" readonly id="o_igst_amt" style=" width: 100px; text-align:right" value='0.00' onkeyup="afterRateChange(this);" class="oigstClass" /></td>
                     <td><input type="text" name="o_amt[]" id="o_amt" readonly style=" width: 100px; text-align:right" value='0.00' class="oamtClass" />
                    <td style=" display: none;"><input type="text" name="o_cal_typ[]" id="o_cal_typ" style=" width: 100px; text-align:right" class="ocalType" />
                    </tr>
                    <tr id="afterMisc">
                    
                    </tr>
                     <tr class="table-danger">
                      <% rsnew.beforeFirst();
                    while(rsnew.next())
                    {
                    %>
                    <th>
                    <% 
                    } 
                    rsnew.beforeFirst();
                    %>
                    <th colspan="2">
                    <th colspan="2" style="text-align: right;font-weight: bold;">Net Amount: 
                     <td><input type="text" placeholder="Amount" readonly name="finBasic"  class=" border-danger" id="finBasic" style="width: 100px; text-align:right" value='0.00'/></td>
                    <th colspan="">
                   <td><input type="text" name="fin_dis_amt" id="fin_dis_amt" readonly class=" border-danger" style=" width: 100px; text-align:right" value='0.00' /></td>
                     <th colspan="">
                    <td><input type="text" name="fin_cgst_amt" id="fin_cgst_amt" readonly style=" width: 100px; text-align:right" value='0.00' class=" border-danger" /></td>
                     <td><input type="text" name="fin_sgst_amt" id="fin_sgst_amt" readonly style=" width: 100px; text-align:right" value='0.00' class=" border-danger" /></td>
                      <td><input type="text" name="fin_igst_amt" id="fin_igst_amt" readonly style=" width: 100px; text-align:right" value='0.00' class=" border-danger" /></td>
                     
                    <td><input type="text" name="net_amt" id="net_amt" readonly class=" border-danger"  style=" width: 100px; text-align:right" value='0.00' /></td>
                    </tr>
                    
                    <tr>
                    <td colspan="10" align="center"> <input type="submit" class="btn btn-primary" value="submit" />
                    </tr>
                    </table>
       </div>
       <br />

               </form>             
       </div>  
        <div class="tab-pane fade" id="panel6" role="tabpanel">
        <br>
        <div id="jsGrid"></div>  
          </div>
      </div>
      </div>    
        <br>
         <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document" style=" max-width: 90%">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Purchase View..</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" id="viewGrid">
            
            </div>
            <div class="modal-footer">
              
<!--                 <input type="submit" class="btn btn-primary btn-sm" value="Ackowledged"/> -->
            </div>
        </div>
    </div>
</div>    
       
       <div id="addRowValue" style="display:none;"></div>
         </main>
    </body>
    <%@include file="../common/footer.jsp" %>
</html>
