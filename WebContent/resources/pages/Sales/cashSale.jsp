<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
    
        <meta charset="utf-8">
          <meta http-equiv="Pragma" content="no-cache">
        <title>Cash Sales Page....</title>
        
            <script src="../../../resources/js/jquery-1.11.0.js"></script> 
        <%@include file="../common/include.jsp" %>
         
<!--      <script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script src="../../../resources/js/validation.js"></script>       

<style type="text/css">
.table-wrapper {
    display: block;
    max-height: 300px;
    overflow-y: auto;
    -ms-overflow-style: -ms-autohiding-scrollbar;
}
.juicy-peach-gradient {
    background-image: linear-gradient(to right, #ffecd2 0%, #fcb69f 100%);
}

}
</style>
<script src="../../../resources/js/cashSales.js"></script> 
<script type="text/javascript">
function fetchCashParty()
{
	 $.noConflict();
	// var availableTags = [{"id":1,"label":"ActionScript"},{"id":2,"label":"BppleScript"}];
	var coid=$('#company_id').val();
	$.get('../../../fetchCashParty',{}, function (response) {
	    // alert(response);
	    
	     $('#cust_name').autocomplete({
	    	    source:response,
	    	    select: function( event, ui ) { //alert(ui.item.id);
	    	    	// alert(ui.item.label);
	    	    $('#uid').val(ui.item.id);
	    	    getCashSaleParty(ui.item.id);
	    	    }
	    	});
	          

	      });		
}

function checkMinus(val,x)
{
	var str=val;
	//alert('1== '+str);
	var i;
	for(i=0;i<str.length;i++)
		{
		var res = str.charAt(i);
		    if(res=='-')
		    {
		    	alert("Minus not allowed here....");
		    	var ids='#'+x.id;
		    	//$(x).closest('tr').find('#nuom_id').val('');
		    	$(x).closest('tr').find(ids).val('');
		    	//$(x).closest('tr').find('#rate').val('');
		    }	
		}
	
}
</script>
<script type="text/javascript">

$(document).ready(function() {
   
   
   $('.datepicker').pickadate({
  	
  	  format: 'yyyy-mm-dd',
  	max: new Date()
  	});
  
  
	  
	
   
   var beanp="CashSaleHdrBean";
   var valcolp=["active","vr_type"];
   var valvp=["Y","CASR"];
   var getDatasp={beanName:beanp,valColumn:valcolp,valValue:valvp};
   var params1p=JSON.stringify(getDatasp);
   var pp="r_memo_no";
   var selectedCol1p="memo_no,memo_no";
   CallDropDownService(params1p,pp,selectedCol1p);  

  
 var bean3="ItemRateTypeBean";
 var valcol3=["active"];
 var valv3=["Y"];
 var getDatas3={beanName:bean3,valColumn:valcol3,valValue:valv3};
 var params13=JSON.stringify(getDatas3);
 var p3="rt_type";
 var selectedCol13="rt_typ_id,rt_typ_nm";
 CallDropDownService(params13,p3,selectedCol13);
 
 var beans="PriceTypeMasterBean";
 var valcols=["active"];
 var valvs=["Y"];
 var getDatass={beanName:beans,valColumn:valcols,valValue:valvs};
 var params1s=JSON.stringify(getDatass);
 var ps="pay_type";
 var selectedCol1s="price_typ,typ_nm";
 CallDropDownService(params1s,ps,selectedCol1s);
 CallDropDownService(params1s,'pay_type1',selectedCol1s);

 var beans="OtherHeadsHdr";
 var valcols=["active","hd_typ"];
 var valvs=["Y","SA"];
 var getDatass={beanName:beans,valColumn:valcols,valValue:valvs};
 var params1s=JSON.stringify(getDatass);
 var ps="miscH";
 var selectedCol1s="oh_id,description";
 CallDropDownService(params1s,ps,selectedCol1s);

 var beans="SalesManBean";
 var valcols=["active","co_id","sl_type"];
 var valvs=["Y",($('#company_id').val()),"S"];
 var getDatass={beanName:beans,valColumn:valcols,valValue:valvs};
 var params1s=JSON.stringify(getDatass);
 var ps="salesman";
 var selectedCol1s="sm_id,sm_nm";
 CallDropDownService(params1s,ps,selectedCol1s);
 
 var beans="SalesManBean";
 var valcols=["active","co_id","sl_type"];
 var valvs=["Y",($('#company_id').val()),"H"];
 var getDatass={beanName:beans,valColumn:valcols,valValue:valvs};
 var params1s=JSON.stringify(getDatass);
 var ps="helper";
 var selectedCol1s="sm_id,sm_nm";
 CallDropDownService(params1s,ps,selectedCol1s);
 

  
});


</script>
<script type="text/javascript">
function getCashSaleParty(str)
{
	//alert(str);
	var coid=$('#company_id').val();
	$.get('../../ajax/getCashSalePartyDetails.jsp',{id:str,co_id:coid}, function (response) {
	     //alert(response);
	     var m=JSON.parse(response.trim());
	     var name=m.name;
	     var add1=m.add1;
	     var add2=m.add2;
	     var mobile=m.mobile;
	     var email=m.email;
	     $('#cust_name').val(name);
	     $('#cust_add1').val(add1);
	     $('#cust_add2').val(add2);
	     $('#cust_mob').val(mobile); 
	     $('#cust_email').val(email);
	          

	      });	
	
	}
// function getCode()
// {
// 	var x=$('#cust_name').val();
// 	//alert(x);
// 	}
function putUomData(id,x,paramval,sid)
{
	 $(x).closest('tr').find('#qty').val(paramval);
	 $(x).closest('tr').find('#uom_id').val(id);
	 var res = sid.split("-");
	 afterRateChange(x);
	    for(var i=0;i<res.length;i++)
	    {//alert(id+res[i]);
	    	if(id!=res[i]){
	    	//alert(res[i]);
	    	var y="#"+res[i];
	    	$(x).closest('tr').find(y).val("");
	    	}
	    }
	   
	   // checkMinus(paramval,x);
	  
}
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
        loadData: function() {
            var d = $.Deferred();

            $.ajax({
            	   type: 'GET',
            	    url: "../../../fetchCashSaleDetails",
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
        { name: "tr_hid", type:"text",width:50,title: "Item Id",css: "hide"},
        { name: "memo_no", type: "text", width: 50 ,title : "Memo No"  },
        { name: "tr_dt", type: "text", width: 50 ,title : "Date"  },
        { name: "cust_name", type: "text", width: 50 ,title : "Customer Name"  },
        { name: "cust_add1", type: "text", width: 50 ,title : "Address 1"  },
        { name: "cust_add2", type: "text", width: 50 ,title : "Address 2"  },
        { name: "finBasic", type: "text", width: 50 ,title : "Basic"  },
        { name: "fin_dis_amt", type: "text", width: 50 ,title : "Discount"  },
        { name: "fin_cgst_amt", type: "text", width: 50 ,title : "CGST"  },
        { name: "fin_sgst_amt", type: "text", width: 50 ,title : "SGST"  },
        { name: "net_amt", type: "text", width: 50 ,title : "Net Amount"  },
        { name: "salesman", type: "text", width: 50 ,title : "Salesman"  },
        { name: "helper", type: "text", width: 50 ,title : "Helper"  },
        { name: "created_by", type: "text", width: 50, title: "Created By" },
//         { name: "modified_by", type: "text", width: 50 , title: "Modified By"},
        { name: "created_on", type: "text", width: 50, title: "Created On" },
//         { name: "modified_on", type: "text", width: 50, title: "Modified On" },
        { type: "control",itemTemplate: function(value, item) {
        	 var $result = jsGrid.fields.control.prototype.itemTemplate.apply(this, arguments);

             var $customEditButton = $("<button>").attr({class: "customGridEditbutton jsgrid-button jsgrid-edit-button"})
               .click(function(e) {
                 alert("ID: " + item.tr_hid);
                 e.stopPropagation();
               });
            
             return $("<div>").append($customEditButton);
        }
}
    ]
});
});
</script>

<script type="text/javascript">

$(window).load(function() {
	var pxx=$('#cloneRow').clone();
	$('#addRowValue').html(pxx);
	  
	});
</script>
<script type="text/javascript">

$(function() {
	
	$('#form1').submit(function(event) {
		event.preventDefault();
		jQuery.noConflict();
						var x = jQuery('#form1').serializeJSON();
						var val = JSON.stringify(x);
						//alert("my val is :-"+val);
var p=validation1();
if(p){
						$.ajax({

									beforeSend : function(xhrObj) {
										xhrObj.setRequestHeader(
												"Content-Type",
												"application/json");
										xhrObj.setRequestHeader("Accept",
												"application/json");
									},
									type : "POST",
									url : "../../../addCashSale",
									enctype: 'multipart/form-data',
									 processData: false,  // Important!
								        contentType: false,
									data : val,
									dataType : 'json',

									success : function(data, textStatus) {
										
										// 				for (var i = 0; i < data.length; i++) {
										// 					fin_data= data[i].user_id + data[i].user_pw;
										// 				}
										if (data==""|| data==null) {
											 alert("Data was not Saved");
											 location.reload();
												
												// location.reload(); input-> memo_on input1->co_id input2->term condition
												
											} else {
												
												alert("Data Has Been Saved Suceessfully with Memo No:-"+data);
												//$('#centralModalSuccess').modal();
												var x="<%=request.getContextPath()%>"+"/resources/pages/Sales/cashReport.jsp?"+"memo_no="+data+"&co_id="+$('#company_id').val();
												window.location.replace(x);	
											}
									},
									error : function(xhr, textStatus,
											errorThrown) {
										 alert("====Your Data was not Saved====");
										 location.reload();
										

									}
								});
}

					});

});

</script>
 <script type="text/javascript">
 $(document).on("keypress",function(event){
 //$(":input").keypress(function(event){
	   if (event.which == '10' || event.which == '13') {
	        event.preventDefault();
	        $('#gst_per').focus();
	      // $('.cleanData').focus();
	        //addNewRow();
	        //fetchItemTypeAndItemFromDesign(this);
	    }
	});
 // });
 </script> 
<script type="text/javascript">
function validation1()
{
     //alert("hiii");
  var trn_dt=document.getElementById("tr_dt");
  var name=document.getElementById("cust_name");
  var pay_amt=document.getElementById("pay_amt").value;
  var pay_amt1=document.getElementById("pay_amt1").value;
  var pay_type=document.getElementById("pay_type").value;
  var pay_type1=document.getElementById("pay_type1").value;
    errors=[];
   // Dropdown1(associate_typ,"Please Select");
    checkBlank(name,"Customer Name");
    checkBlank(trn_dt,"Bill Date");
    if(pay_type!=0 && pay_amt=="")
    	{
    	errors[errors.length] ="Please provide Pay amount1";
    	}
    if(pay_type1!=0 && pay_amt1=="")
	{
	errors[errors.length] ="Please provide Pay amount2";
	}
    if(pay_type==0 && pay_type1==0)
    	{
    	errors[errors.length] ="Please complete payment";
    	}
    params=["pivotElement","#qty"];
    validationForDetail(params);

    return finalCheck();            
    
    }
    
    function getItems(x,val)
    {
    	 var bean1="ItemMasterBean";
    	 var valcol1=["active","itm_typ_id"];
    	 var valv1=["Y",val];
    	 var getDatas1={beanName:bean1,valColumn:valcol1,valValue:valv1};
    	 var params11=JSON.stringify(getDatas1);
    	 var p1='';
    	 var selectedCol11="itm_id,itm_nm";
    	// CallDropDownServiceForDetail(params11,p1,selectedCol11,);
    	 CallDropDownServiceForDetail(params11,p1,selectedCol11,'N',x,'item_id');
    }
    
    function getGstValueFromItem(x,val){
    	var item_type= $(x).closest('tr').find('#item_typ_id').val();
    	  $.get('../../ajax/getGSTFromRMitem.jsp',{type:item_type,item:val}, function (response) {
    		  
    	  });
    }
    
    function getStockDetails(x,val,coid)
    {
    	var item_type= $(x).closest('tr').find('#item_typ_id').val();
  $.get('../../ajax/getStockForRM.jsp',{type:item_type,item:val,coid:coid}, function (response) {
	  $(x).closest('tr').find('#stk').val(response.trim()); 
    	  });
 
    }

</script>

    </head>
    <body class="fixed-sn mdb-skin-custom" onload="fetchCashParty();">
<%@include file="../common/menu.jsp" %>

        
        <main>
       
<!--  <div class="main-wrapper"> -->
          <div class="container-fluid text-center" >
<!--          -->
<!-- <div class="card table-responsive wider "> -->
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2"> Cash Sale</div>
     <ul class="nav nav-tabs nav-justified indigo" role="tablist">
    <li class="nav-item">
        <a class="nav-link active" data-toggle="tab" href="#panel5" role="tab"><i class="fa fa-plus"></i> Add Cash Sale</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#panel6" role="tab"><i class="fa fa-edit"></i> View/Update Sales Details</a>
    </li>
   
</ul>
 <div class="tab-content">
                
                <div class="tab-pane fade in show active" id="panel5" role="tabpanel">
                 <form id="form1" name="form_1" method="post">  
<!--        <div class="card-body table-responsive"> -->
       
                 <table class="table-hover table-bordered">
                   <tr>
<!--                     <th> -->
<!-- 				Memo Number: -->
<!-- 				</th> -->
<!-- 				<td> -->
				<%
				
// 				System.out.println("idp is:-"+idp);
// 				session.setAttribute("idp",idp);
				java.util.Date dt=new java.util.Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				String trdate=sdf.format(dt);
				
				%>
<%-- 				 <input type="text" name="memo_no" id="memo_no" class="form-control" value="<%=memo_no%>" readonly/> --%>
				<input type="hidden" id="vr_type" name="vr_type" value="CASA">
<!-- 				</td> -->
                <th>
                      Date:
                        </th>
                        <td>
                          <input placeholder="Selected date" type="text" name="tr_dt" id="tr_dt" value="<%= trdate %>" class="form-control datepicker">
                        	
                        
                        </td>
						
                       <td >
                         <input type="text" name="uid" id="uid" class="form-control" placeholder="User Id" onchange="getCashSaleParty(this.value)"/>
                            </td>
						<th>
                              Name:
                            </th>

                            <td>
<!--                         <div class="md-form">          -->
<!--                         <input type="text" name="cust_name" id="cust_name" class="form-control mdb-autocomplete" onfocus="getCode()"/> -->
<!--                          </div> -->
 							<input type="text" name="cust_name" id="cust_name" class="form-control" />
                            </td>
                            <th>
                                Address:
                            </th>

                            <td >
                          <input type="text" name="cust_add1" id="cust_add1" class="form-control"/>
                         
                        
                            </td>
                            <td colspan="2">
                          <input type="text" name="cust_add2" id="cust_add2" class="form-control"/>
                        
                            </td>
						

                            
                        </tr>
                        
                        <tr>
                        <th>
                       Mobile:
                        </th>
                        <td>
                         <input type="text" name="cust_mob" id="cust_mob" class="form-control" /> 
                        </td>
                        <th>
                       Email:
                        </th>
                        <td >
                        
                        <input type="text" name="cust_email" id="cust_email" class="form-control" /> 
                        </td>
                        <th>
                        SalesMan:
                        </th>
                        <td>
<!--                          <input type="text" name="cust_email" id="cust_email" class="form-control" />  -->
 <select name="salesman" id="salesman" class="mdb-select  colorful-select dropdown-primary " >
                        </select>
                        </td>
                        <th>
                        Helper:
                        </th>
                        <td>
<!--                          <input type="text" name="cust_email" id="cust_email" class="form-control" />  -->
 <select name="helper" id="helper" class="mdb-select  colorful-select dropdown-primary " >
                        </select>
                        </td>
                        </tr>
                          
                    </table>
<!--                     </div> -->
                    
<!--                   <div class="row justify-content-start border-warning" > -->
                    <table class="table-bordered">
                    <tr>
                    <td colspan="14">
                    <center>  
<!--                     <button type="button" class="btn btn-mdb-color btn-sm" onclick="addNewRow()"> -->
                   <B><i> Details</i></B> 
<!--                     </button> -->
                    </center>
                       <%
                    MyConnection mycon=new MyConnection();
                   Connection newcon= mycon.getConnection("adm_retail");
                   String qry="SELECT uom_nm FROM mst_uom where active='Y'";
                   String db="adm_retail";
                   ResultSet rsnew = mycon.getResultSet(qry, db); 
                    %>
                   
                    </td>
                    </tr>
                    <tr>
                     <th>Barcode 
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
                    <th>Taxable
                    <th>Disc.(%)
                    <th>Disc. Amt.
                    <th>GST(%)
                    <th>CGST Amt.
                    <th>SGST Amt.
<!--                     <th>IGST Amt. -->
                    <th>Amount
                    </tr>
                    <tr id="cloneRow"> 
                  <td>
                  <input type="text" name="barcode[]" id="barcode" style=" width: 100px" class="pivotElement" onchange="fetchItemTypeAndItemFromDesign(this,<%=coid %>,'C');  " />
                  </td>
                    <td>

<input type="text" name="desg_id[]" id="desg_id" style=" width: 100px" class="desgClass" onchange="fetchItemTypeAndItemForDesign(this,<%=coid %>,'C');  " />
   <input type="hidden" name="hsn_cd[]" id="hsn_cd" style=" width: 100px" readonly/>                     
                    </td>
                    <td><select name="item_typ_id[]" id="item_typ_id" class="browser-default" onchange="getItems(this,this.value)">
                        <option value='0'>-select-</option>           
                        </select></td>
                    <td><select name="item_id[]" id="item_id" class="browser-default" onchange="getStockDetails(this,this.value,<%=coid %>)">
                        <option value='0'>-select-</option>           
                        </select></td>
                    
                    <td style=" width: 50px; display: none"><input type="text" name="qty[]" id="qty"  value='0' />
                    <input type="text" name="stk[]" id="stk"  value='0' />
                    </td>
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
                    <td><input type="text" name="nuom_id[]" id="<%=rsnew.getString("uom_nm")%>" onkeyup="checkMinus(this.value,this);" onchange="putUomData(this.id,this,this.value,'<%=sid%>');" class="cleanData" style="width:70px;text-align:right;"/>
                    
                    <%    
                    	}
                    %>
                    <td style=" width: 50px; display: none">
<!--                     <select name="uom_id[]" id="uom_id" class="browser-default" > -->
<!--                         <option value='0'>-select-</option>            -->
<!--                         </select> -->
                    <input type="text" name="uom_id[]" id="uom_id" style=" width: 50px; text-align:right; display: none">    
                    </td>
                    <td>
                        <input type="text" name="rate[]" id="rate" style=" width: 100px;text-align:right;" onchange="afterRateChange(this);" />
                        </td>
                    <td><input type="text" name="basic[]" id="basic" style=" width: 100px; text-align:right" value='0.00' class="basClass" readonly/></td>
                    <td><input type="text" name="dis_per[]" id="dis_per" style=" width: 50px; text-align:right" value='0.00' onkeyup="checkMinus(this.value,this);" onchange="afterRateChange(this)"/></td>
                    <td><input type="text" name="dis_amt[]" id="dis_amt" style=" width: 70px; text-align:right" value='0.00' class="disClass"  onchange="afterRateChange(this)" /></td>
                    <td><input type="text" name="gst_per[]" id="gst_per" style=" width: 50px; text-align:right" value='0.00' onchange="afterRateChange(this)" readonly/></td>
                    <td><input type="text" name="cgst_amt[]" id="cgst_amt" style=" width: 70px; text-align:right" value='0.00' class="cgstClass" readonly/></td>
                     <td><input type="text" name="sgst_amt[]" id="sgst_amt" style=" width: 70px; text-align:right" value='0.00' class="sgstClass" readonly/></td>
<!--                       <td><input type="text" name="igst_amt[]" id="igst_amt" style=" width: 100px; text-align:right" value='0.00' class="igstClass" readonly/></td> -->
                     <td><input type="text" name="amt[]" id="amt" style=" width: 100px; text-align:right" value='0.00' class="amtClass" readonly/></td>
                    <td>
                        <span class="table-remove" style=" width: 5px;"><button type="button"  class="btn btn-danger btn-rounded btn-sm my-0" onclick="deleteRow(this)">R</button></span>
                    </td>
                    </tr>
                    <tr id="insertBefore" class="table-info">
                    <th>
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
                     
                    <th>Total:
                     <td><input type="text" name="tot_bas_amt" id="tot_bas_amt" class=" border border-success" style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                    <th>
                    
                    <td><input type="text" name="tot_dis_amt" id="tot_dis_amt" class=" border border-success" style=" width: 70px; text-align:right" value='0.00' readonly/></td>
                    <th>
                    
                    <td><input type="text" name="tot_cgst_amt" id="tot_cgst_amt" class=" border border-success"  style=" width: 70px; text-align:right" value='0.00' readonly/></td>
                    <td><input type="text" name="tot_sgst_amt" id="tot_sgst_amt" class=" border border-success"  style=" width: 70px; text-align:right" value='0.00' readonly/></td>
<!--                     <td><input type="text" name="tot_igst_amt" id="tot_igst_amt" class=" border border-success"  style=" width: 100px; text-align:right" value='0.00' readonly/></td> -->
                    
                   
                    <td><input type="text" name="tot_amt" id="tot_amt" class=" border border-success"  style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                   
                    </tr>
<!--                     <tr id="cloneRow1"> -->
<!--                     <th > -->
<!--                     <th colspan="2">Misc Head -->
<!--                     <td colspan="2"> <select name="miscH[]" id="miscH" class="browser-default" onchange="fetchOtherHead(this.value,this.id,this)"> -->
<!--              <option value='0'>---select Option---</option> -->
<!--              </select> -->
<!--               <td><input type="text" placeholder="Amount" name="miscHamt[]" id="miscHamt" style="width: 100px; text-align:right" class="omiscHamt" onchange="calculateMgst(this.value,this)" /></td> -->
<!--                     <th colspan="2"> -->
<!--                     <td><input type="text" name="o_gst_per[]" id="o_gst_per" style=" width: 50px; text-align:right" value='0.00' readonly/></td> -->
<!--                     <td><input type="text" name="o_cgst_amt[]" id="o_cgst_amt" style=" width: 100px; text-align:right" value='0.00' class="ocgstClass" readonly/></td> -->
<!--                      <td><input type="text" name="o_sgst_amt[]" id="o_sgst_amt" style=" width: 100px; text-align:right" value='0.00' class="osgstClass" readonly/></td> -->
<!--                       <td><input type="text" name="o_igst_amt[]" id="o_igst_amt" style=" width: 100px; text-align:right" value='0.00' class="oigstClass" readonly/></td> -->
<!--                      <td><input type="text" name="o_amt[]" id="o_amt" style=" width: 100px; text-align:right" value='0.00' class="oamtClass" readonly/></td> -->
<!--                     <td style=" display: none;"><input type="text" name="o_cal_typ[]" id="o_cal_typ" style=" width: 100px; text-align:right" class="ocalType" readonly/> -->
<!--                     </tr> -->
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
                    <th colspan="3">
                     
                    <th colspan="2">Net Amount: 
                     <td><input type="text" placeholder="Amount" name="finBasic" class=" border-danger" id="finBasic" style="width: 100px; text-align:right" value='0.00'/></td>
                    <th colspan="">
                   <td><input type="text" name="fin_dis_amt" id="fin_dis_amt" class=" border-danger" style=" width: 70px; text-align:right" value='0.00' readonly/></td>
                     <th colspan="">
                    <td><input type="text" name="fin_cgst_amt" id="fin_cgst_amt" style=" width: 70px; text-align:right" value='0.00' class=" border-danger" readonly/></td>
                     <td><input type="text" name="fin_sgst_amt" id="fin_sgst_amt" style=" width: 70px; text-align:right" value='0.00' class=" border-danger" readonly/></td>
<!--                       <td><input type="text" name="fin_igst_amt" id="fin_igst_amt" style=" width: 100px; text-align:right" value='0.00' class=" border-danger" readonly/></td> -->
                     
                    <td><input type="text" name="net_amt" id="net_amt" class=" border-danger"  style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                    </tr>
                    </table>
<!--                     </div>card -->
<!--                     </div> -->
                    <div class="row">
                    <div class="col">
                   <div class="" style="margin-top:10px">
                    <div class="card-header juicy-peach-gradient lighten-1 text-dark text-center z-depth-2 "><p class="h5">Payment</p></div>
                   </div> 
                   </div>
                   </div>
                   <div class="card">
                   
                    <table class="table">
                    <tr>
                    <th>Payment Type:
                     <th>Paid Amount:
                     
                       <th>Document No.
                         <th>Document Date:
                          <th>Drawn On:
                          </tr>
                          <tr>
                    <td><select name="pay_type" id="pay_type" class="mdb-select  colorful-select dropdown-primary " >
                        <option value='0'>---select Option---</option>
                        </select>
                       
                    <td> <input type="text" name="pay_amt" id="pay_amt" class="form-control" onchange="afterPaidChange(this.value)" onkeyup="checkMinus(this.value,this)"/>
                   
                                        
                       
                    <td> <input type="text" name="doc_no" id="doc_no" class="form-control" /> 
                   
                  
                    <td><input placeholder="Selected date" type="text" name="doc_dt" id="doc_dt" class="form-control datepicker">
                    <td> <input type="text" name="drawn_on" id="drawn_on" class="form-control" /> 
                    </tr>
                    <tr>
                    <td><select name="pay_type1" id="pay_type1" class="mdb-select  colorful-select dropdown-primary " >
                        <option value='0'>---select Option---</option>
                        </select>
                       
                    <td> <input type="text" name="pay_amt1" id="pay_amt1" class="form-control" onchange="afterPaidChange(this.value)" onkeyup="checkMinus(this.value,this)"/>
                   
                   
                       
                       
                    <td> <input type="text" name="doc_no1" id="doc_no1" class="form-control" /> 
                   
                  
                    <td><input placeholder="Selected date" type="text" name="doc_dt1" id="doc_dt1" class="form-control datepicker">
                       <td> <input type="text" name="drawn_on1" id="drawn_on1" class="form-control" /> 
                    </tr>
                    </table>
                    
                    <table class="table">
                    <tr>
                    <td colspan="7"><span><b>Adjustments</b></span>
                    </tr>
                    <tr style=" background-color:#F0E68C">
                    <th>Select Memo No
                    <td><select name="r_memo_no" id="r_memo_no" class="mdb-select  colorful-select dropdown-primary " >
                        <option value='0'>---select Option---</option>
                        </select>
                    <th colspan="2">Adjusted Amount
                    <td colspan="2" style=" float: left"> <input type="text" name="adj_amt" id="adj_amt" class="form-control" onkeyup="checkMinus(this.value,this)" onchange="afterPaidChange(this.value)"/>
                    
                    </tr>
                    <tr><td>&nbsp;</tr>
                    <tr>
                   
                    <th>Remarks:
                    <td> <input type="text" name="remarks" id="remarks" class="form-control" /> 
                     <th>Balance Amount: <td> <input type="text" name="bal_amt" id="bal_amt" class="form-control" /> 
                    </tr>
                    <tr>
                    <td colspan="7" align="center"> <input type="submit" class="btn btn-primary btn-sm" value="submit" />
                    </tr>
                    
                    </table>
                    
                 </div> 
                  </form> 
                 </div>
              
    <div class="tab-pane fade" id="panel6" role="tabpanel">
        <br>
        <div id="jsGrid"></div>  
          </div>
      </div>
<!--       </div> -->
<!--        </div> -->
      
                 
                     
    </div>        
       
    <div id="addRowValue" style=" display: none"></div>
         </main>
     <input type="hidden" id="addRowCount" value='2'/>   
    </body>
    <%@include file="../common/footer.jsp" %>
</html>
