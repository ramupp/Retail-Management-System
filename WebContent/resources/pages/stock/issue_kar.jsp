<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="com.crunchify.util.*"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
    
        <meta charset="utf-8">
        <title>Issue Karigar....</title>
        
            <script src="../../../resources/js/jquery-1.11.0.js"></script> 
        <%@include file="../common/include.jsp" %>
         <script src="../../../resources/js/packingSlip.js"></script> 
<!--     <script src="../../../resources/js/cashSales.js"></script> -->
  <script src="../../../resources/js/validation.js"></script>   
        

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

$(document).ready(function() {
   
   
   $('.datepicker').pickadate({
  	
  	  format: 'yyyy-mm-dd',
  	  max:new Date()
  	});

 

 
//  var bean1="RetailTempBean";
//  var valcol1=["active"];
//  var valv1=["Y"];
//  var getDatas1={beanName:bean1,valColumn:valcol1,valValue:valv1};
//  var params11=JSON.stringify(getDatas1);
//  var p1="desg_id";
//  var selectedCol11="tr_id,desg_no";
//  CallDropDownService(params11,p1,selectedCol11);
//    var bean2="PartyViewBean";
//  var valcol2=["active","party_typ","co_id"];
//  var valv2=["Y","SD","0"];
//  var getDatas2={beanName:bean2,valColumn:valcol2,valValue:valv2};
//  var params12=JSON.stringify(getDatas2);
//  var p2="party_id";
//  var selectedCol12="party_id,party_nm";
//  CallDropDownService(params12,p2,selectedCol12); 
 
 var bean3="ItemRateTypeBean";
 var valcol3=["active"];
 var valv3=["Y"];
 var getDatas3={beanName:bean3,valColumn:valcol3,valValue:valv3};
 var params13=JSON.stringify(getDatas3);
 var p3="rt_type";
 var selectedCol13="rt_typ_id,rt_typ_nm";
 CallDropDownService(params13,p3,selectedCol13);
 
 var beans="PaymentTypeBean";
 var valcols=["active"];
 var valvs=["Y"];
 var getDatass={beanName:beans,valColumn:valcols,valValue:valvs};
 var params1s=JSON.stringify(getDatass);
 var ps="pay_type";
 var selectedCol1s="id,type";
 CallDropDownService(params1s,ps,selectedCol1s); 
 

 
 var bean7="PartyViewBean";
 var valcol7=["active","party_typ"];
 var valv7=["Y","SC"];
 var getDatas7={beanName:bean7,valColumn:valcol7,valValue:valv7};
 var params17=JSON.stringify(getDatas7);
 var p7="kar_cd";
 var selectedCol17="party_id,party_nm";
 CallDropDownService(params17,p7,selectedCol17);
 
 var beans="ItemTypeBean";
 var valcols=["active"];
 var valvs=["Y"];
 var getDatass={beanName:beans,valColumn:valcols,valValue:valvs};
 var params1s=JSON.stringify(getDatass);
 var ps="item_typ_id";
 var selectedCol1s="itm_typ_id,itm_typ_nm";
 CallDropDownService(params1s,ps,selectedCol1s);
 
//  var beans="SalesManBean";
//  var valcols=["active","co_id","sl_type"];
//  var valvs=["Y",($('#company_id').val()),"S"];
//  var getDatass={beanName:beans,valColumn:valcols,valValue:valvs};
//  var params1s=JSON.stringify(getDatass);
//  var ps="salesman";
//  var selectedCol1s="sm_id,sm_nm";
//  CallDropDownService(params1s,ps,selectedCol1s);
 
//  var beans="SalesManBean";
//  var valcols=["active","co_id","sl_type"];
//  var valvs=["Y",($('#company_id').val()),"H"];
//  var getDatass={beanName:beans,valColumn:valcols,valValue:valvs};
//  var params1s=JSON.stringify(getDatass);
//  var ps="helper";
//  var selectedCol1s="sm_id,sm_nm";
//  CallDropDownService(params1s,ps,selectedCol1s);

// $('#party_ids').material_select();
});

</script>
<script type="text/javascript">

$(window).load(function() {
	var pxx=$('#cloneRow').clone();
	$('#addRowValue').html(pxx);
	var pxx1=$('#cloneRow1').clone();
	$('#addRowValue1').html(pxx1);
	
	});
</script>
 <script type="text/javascript">
 $(document).on("keypress",function(event){
 //$(":input").keypress(function(event){
	   if (event.which == '10' || event.which == '13') {
	        event.preventDefault();
	        $('#uom_id').focus();
	       // addNewRow();
	       // fetchItemTypeAndItemFromDesign(this);
	    }
	});
 // });
 </script> 
 <script type="text/javascript">
function validation1()
{
     //alert("hiii");
  var trn_dt=document.getElementById("doc_dt");
  var name=document.getElementById("kar_cd");
  var zero=document.getElementById("item_typ_id");
  var design=document.getElementById("desg_no");

    errors=[];
   // Dropdown1(associate_typ,"Please Select");
    Dropdown16(name,"Please Select an ");
    checkBlank(trn_dt,"Bill Date");
    checkBlank(design,"Design");
   // Dropdown4(item_name,"Please Select an ");

    params=["desgClass","#item_typ_id","#item_id","#qty1"];
    params1=["sexy","#item_id","#qty"];
    validationForDetail(params);
    validationForDetail(params1);

    return finalCheck();            
    
    }

</script>

<script type="text/javascript">
function addNewRow()
{
	// alert("hello");
	
	 var x=$("#addRowValue").html();
	// $('.x').material_select('destroy');
	//$("#TableId").find("tr").last().after(x);
	$(x).insertBefore("#insertBefore");
	
	// $('.x').material_select();
	 
}

function addNewRow1()
{
	// alert("hello");
	
	 var x=$("#addRowValue1").html();
	// $('.x').material_select('destroy');
	//$("#TableId").find("tr").last().after(x);
	$(x).insertBefore("#insertBefore1");
	
	// $('.x').material_select();
	 
}
</script>

<script type="text/javascript">

//function submitData() {
//	alert("hello");


$(function() {
	$('#form1').submit(function(event) {
		event.preventDefault();
						var x = $('#form1').serializeJSON();
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
									url : "../../../addIssuekar",
									//enctype: 'multipart/form-data',
									// processData: false,  // Important!
								    contentType: 'application/json',
									data : val,
									dataType : 'json',
									

									success : function(data, textStatus) {
										//alert(data);
										
										// 				for (var i = 0; i < data.length; i++) {
										// 					fin_data= data[i].user_id + data[i].user_pw;
										// 				}
										if (data=="" || data==null) {
											 alert("====Data was not Saved====");
											 location.reload();
											
											
										} else {
										
											alert("Data Has Been Saved Suceessfully:-"+data);
											//$('#centralModalSuccess').modal();
												location.reload();
// 											window.location.replace(x);
										}
									},
									error : function(xhr, textStatus,
											errorThrown) {
										 alert("====Data was not Saved====");
										 location.reload();

									}
								});
}

					});
});
</script>

<script type="text/javascript">

//function submitData() {
//	alert("hello");


$(function() {
	$('#form2').submit(function(event) {
		event.preventDefault();
						var x = $('#form2').serializeJSON();
						var val = JSON.stringify(x);
						//alert("i am in form 2");
						//alert("my val is :-"+val);
//var p=validation1();
//if(p){
						$.ajax({

									beforeSend : function(xhrObj) {
										xhrObj.setRequestHeader(
												"Content-Type",
												"application/json");
										xhrObj.setRequestHeader("Accept",
												"application/json");
									},
									type : "POST",
									url : "../../../addIssuekar",
									//enctype: 'multipart/form-data',
									// processData: false,  // Important!
								    contentType: 'application/json',
									data : val,
									dataType : 'json',
									

									success : function(data, textStatus) {
										//alert(data);
										
										// 				for (var i = 0; i < data.length; i++) {
										// 					fin_data= data[i].user_id + data[i].user_pw;
										// 				}
										if (data=="" || data==null) {
											 alert("====Data was not Saved====");
											 location.reload();
											
											
										} else {
										
											alert("Data Has Been Saved Suceessfully:-"+data);
											//$('#centralModalSuccess').modal();
                                                 location.reload();
// 											window.location.replace(x);
										}
									},
									error : function(xhr, textStatus,
											errorThrown) {
										 alert("====Data was not Saved====");
										 location.reload();

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
            	    url: "../../../fetchAllIssuekar",
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
//     updateItem: function(item) {
//      	 var d = $.Deferred();
//      	 //alert(JSON.stringify(item));
//      var p=JSON.parse(JSON.stringify(item));      
//          return $.ajax({
//              type: "POST",
//              async: false,
//              url: "../../../IssuekarUpdate",
//              contentType: "application/json",
//              dataType: 'json',
//              //var x = $('#form1').serializeJSON();
//  			//var val = JSON.stringify(item.itm_nm),
 			
//              data: JSON.stringify(item),
//              success: function (data) {
//           	  // d.resolve(JSON.parse(JSON.stringify(data)));
//            	  location.reload();
//              }
//          });
//      },

    fields: [
             {name:"pur_id", css:"hide"},
        { name: "doc_no", type:"text",width:60,title: "Document No"},
        { name: "doc_dt", type: "text", width: 70 ,title : "Document Date"  },
        { name: "party_nm", type: "text", width: 50 ,title : "Karigar"  },
//         { name: "inv_dt", type: "text", width: 70 ,title : "Invoice Date"  },
//        // { name: "party_cd", type: "text", width: 50 ,title : "Party Code"  },
//        // { name: "pur_typ", type: "text", width: 50 ,title : "Party Type"  },
//         { name: "tot_amt", type: "text", width: 50 ,title : "Total Amount"  },
//         //{ name: "tot_disc", type: "text", width: 50 ,title : "Total Discount"  },
//         { name: "net_amt", type: "text", width: 50 ,title : "Net Amount"  },
//         { name: "tot_bas_amt", type: "text", width: 50 ,title : "Final Basic"  },
//         { name: "tot_dis_amt", type: "text", width: 50 ,title : "Total Discount"  },
//         { name: "tot_cgst_amt", type: "text", width: 50 ,title : "Final CGST"  },
//         { name: "tot_sgst_amt", type: "text", width: 50 ,title : "Final SGST"  },
//         { name: "tot_igst_amt", type: "text", width: 50 ,title : "Final IGST"  },
//         { name: "pay_terms", type: "text", width: 50, title: "Payment Terms" },
//         { name: "modified_by", type: "text", width: 50 , title: "Modified By"},
//        { name: "created_on", type: "text", width: 50, title: "Created On" },
//         { name: "modified_on", type: "text", width: 50, title: "Modified On" },
      { type: "control",itemTemplate: function(value, item) {
       	 var $result = jsGrid.fields.control.prototype.itemTemplate.apply(this, arguments);

         var $customEditButton = $("<p>").attr({class: "customGridEditbutton fa fa-caret-square-o-right"})
           .click(function(e) {
        	   e.preventDefault();
             //alert("ID: " + item.tr_hid);
             $.get('../../../resources/ajax/getIssueKarDtls.jsp', {doc_no: item.doc_no}, function (response)
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


<!-- <!--  <script type="text/javascript"> -->
<!-- //  function getDetailsForSalesTransfer(id,value,coid) -->
<!-- //  { -->
<!-- // //alert("id is:-"+id+" val is:-"+value);	 -->
<!-- // if(value=='STKO') -->
<!-- // { -->
<!-- // 	$.get("../../ajax/getAutoGeneratedSerialNumber.jsp",{code:'STKO',coid:coid,type:'PKSL'}, function(data, status){  			 -->
<!-- // 	   // alert(data);   -->
<!-- // 	   // $('#pck_sl_no').val(data.trim());	 -->
<!-- // 	    var x=$('#hiddenDiv').html(); -->
<!-- // 	    var y=document.getElementById ("party_td").innerHTML; -->
<!-- // 	    //$('#party_td').html(); -->
	   
<!-- // 	    $('#party_td').html(""); -->
<!-- // 	  // alert(y); -->
<!-- //  	    $('#party_td').html(x); -->
<!-- //  	  // $('#party_id').material_select('destroy'); -->
<!-- //  	  //  -->
<!-- // 	   $('#party_ids').material_select(); -->
	  
<!-- // 	    $('#hiddenDiv').html(""); -->
<!-- //  	    $('#hiddenDiv').html(y); -->
<!-- //  	  // $('#party_id').material_select(); -->
<!-- //  	 //  $('#party_id').material_select('destroy'); -->
<!-- //  	 // $('#party_id').material_select(); -->
	    
	   
<!-- // 	    }); -->
		
<!-- //  } -->
<!-- // else -->
	

<!-- // 	{ -->
<!-- // 		$.get("../../ajax/getAutoGeneratedSerialNumber.jsp",{code:'CRSA',coid:coid,type:'SALE'}, function(data, status){  			 -->
<!-- // 		   // alert(data);   -->
<!-- // 		  //  $('#pck_sl_no').val(data.trim());	 -->
<!-- // 		    var x=$('#hiddenDiv').html(); -->
<!-- // 		    var y=$('#party_td').html(); -->
<!-- // 		   // alert("x---"+x); -->
<!-- // 		   // alert("y---"+y); -->
		    
<!-- // 		    $('#party_td').html(""); -->
		   
<!-- // 	 	    $('#party_td').html(x); -->
<!-- // 	 	  // $('#party_id').material_select(); -->
<!-- // 	 	  $('#party_id').material_select('destroy'); -->
<!-- // 	 	    $('#party_id').material_select(); -->
		  
		  
<!-- // // 		    $('#hiddenDiv').html(""); -->
<!-- // // 	 	    $('#hiddenDiv').html(y); -->
<!-- // // 	 	  $('#party_id').material_select('destroy'); -->
	 	  
<!-- // 		    }); -->
			
<!-- // 	 } -->
	
<!-- // } -->
 
<!-- <!--  </script>    --> 
<script>
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
function getItems(x,val)
{
	//alert(val);
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
function putUomData(id,x,paramval,sid)
{
	 $(x).closest('tr').find('#qty').val(paramval);
	 $(x).closest('tr').find('#uom_id').val(id);
	 var res = sid.split("-");
	// afterRateChange(x);
	    for(var i=0;i<res.length;i++)
	    {//alert(id+res[i]);
	    	if(id!=res[i]){
	    	//alert(res[i]);
	    	var y="#"+res[i];
	    	$(x).closest('tr').find(y).val("");
	    	}
	    }
	  checkMinus(paramval,x);
	  
}
function putUomData1(id,x,paramval,sid)
{
	 $(x).closest('tr').find('#qty1').val(paramval);
	 $(x).closest('tr').find('#uom_id').val(id);
	 var res = sid.split("-");
	// afterRateChange(x);
	    for(var i=0;i<res.length;i++)
	    {//alert(id+res[i]);
	    	if(id!=res[i]){
	    	//alert(res[i]);
	    	var y="#"+res[i];
	    	$(x).closest('tr').find(y).val("");
	    	}
	    }
	  checkMinus(paramval,x);
	  
}

</script>

    </head>
    <body class="fixed-sn mdb-skin-custom ">
<%@include file="../common/menu.jsp" %>

        
        <main>
        <div class="main-wrapper">
       
 
          <div class="container-fluid">
     
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2"> Issue to Karigar </div>
    <ul class="nav nav-tabs nav-justified indigo" role="tablist">
    <li class="nav-item">
        <a class="nav-link active" data-toggle="tab" href="#panel5" role="tab"><i class="fa fa-plus"></i> Add Issue to Karigar</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#panel6" role="tab"><i class="fa fa-edit"></i> View/Update Karigar</a>
    </li>
   
</ul>
 <form id="form1" name="form_1" method="post" >
   <div class="tab-content">
   
<div class="tab-pane fade in show active" id="panel5" role="tabpanel">
       <div class="card card-body">
      
                 <table class="table-hover" >
                         
         
            
                   <tr>
<!--                     <th> -->
                    <%//String memo_no=util.findFinalUpdatedId("",coid);
    		
			java.util.Date dt=new java.util.Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String trdate=sdf.format(dt);
    		%>
<!-- 				Packing Slip No: -->
<!-- 				</th> -->
<!-- 				<td> -->
<%-- 				 <input type="text" name="pck_sl_no" id="pck_sl_no" class="form-control" value="<%=memo_no%>"/> --%>
				
<!-- 				</td> -->
                <th>
                      Date:
                        </th>
                        <td colspan="1">
                          <input placeholder="Selected date" type="text" name="doc_dt" id="doc_dt" style=" width: 120px" value="<%=trdate %>" class="form-control datepicker">
                        	
                        
                        </td>
                        <th>
                              Karigar:
                            </th>

                            <td>
                                 
                         <select name="kar_cd" id="kar_cd" class="browser-default" >
                         
                        </select>
                            </td>
                            <th>
                              Narration:
                            </th>

                            <td >
                           <input type="text" name="narration" id="narration" class="md-textarea form-control" >
                      
                                                
                            </td>
                                                   
                        </tr>
                    </table>
                    </div>
                    <br>
                   
                  <div class="row justify-content-start border-warning " >
                  <div class="container">
                 <div class="row">
                  <div align="center">
                   <h>Raw Material</h>
                    <table class="table-bordered border-warning table-responsive" >

 <%
                    MyConnection mycon=new MyConnection();
                   Connection newcon= mycon.getConnection("adm_retail");
                   String qry="SELECT uom_nm FROM mst_uom where active='Y'";
                   String db="adm_retail";
                   ResultSet rsnew = mycon.getResultSet(qry, db); 
                    %>
                    <tr>
                   <!--   <th>Barcode -->
                    <th>Design 
                    <th>Item Type
                    <th>Item
                 <!--   <th>HSN Code  -->
                     <%
                    while(rsnew.next())
                    {
                    %>
                    <th><%=rsnew.getString("uom_nm")%>
                    <% 
                    } 
                    rsnew.beforeFirst();
                    %>
              <!--      <th>Rate
                    <th>Basic
                    <th>Discount(%)
                    <th>Discount Amt.
                    <th>GST(%)
                    <th>CGST Amt.
                    <th>SGST Amt.
                    <th>IGST Amt.
                    <th>Amount  -->
                    <th><button type="button" class="btn btn-mdb-color btn-sm" onclick="addNewRow()"><i>ADD</i></button>
                    </tr>
                    <tr id="cloneRow">
                 <!-- <td>
                  <input type="text" name="barcode[]" id="barcode" style=" width: 100px" class="pivotElement" onchange="fetchItemTypeAndItemFromDesign(this,<%=coid %>,'CR');"  />
                  </td>-->
                  
                    <td>
                    <input type="text" name="did[]" id="did"  style=" width: 100px; display: none" value="0" />
                    <input type="text" name="desg_no[]" id="desg_no" style=" width: 100px" class="desgClass" />
                        
                    </td> 
                    <td><select name="itm_typ_id[]" id="item_typ_id" class="browser-default sexy"  onchange="getItems(this,this.value)">
                        <option value='0'>-select-</option>           
                        </select></td>
                    <td><select name="itm_id[]" id="item_id" class="browser-default" onchange="getStockDetails(this,this.value,<%=coid %>)">
                        <option value='0'>-select-</option>           
                        </select></td>
                           <td style=" width: 50px;display: none "><input type="text" name="qty[]" id="qty"  value='0' />
             <!--  <td><input type="text" name="hsn_cd[]" id="hsn_cd" style=" width: 100px; text-align:left" readonly/></td>
               
                    <input type="text" name="stk[]" id="stk"  value='0' />
                    </td>  -->
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

                      </tr>
                        <tr id="insertBefore" class="table-info"><td colspan="9"></tr>
                      </table>
                      </div>
                       
                      <div style="float:right">
                      <h style="margin-left: 100px;">Finish Goods</h>
                      <table class="table-bordered border-warning table-responsive" >
                    
                  
                    
                        <tr>
                   <!--   <th>Barcode -->
                    <th>Design 
                    <th>Item Type
                    <th>Item
                 <!--   <th>HSN Code  -->
                     <% rsnew.beforeFirst();
                    while(rsnew.next())
                    {
                    %>
                    <th><%=rsnew.getString("uom_nm")%>
                    <% 
                    } 
                    rsnew.beforeFirst();
                    %>
                    
              <!--      <th>Rate
                    <th>Basic
                    <th>Discount(%)
                    <th>Discount Amt.
                    <th>GST(%)
                    <th>CGST Amt.
                    <th>SGST Amt.
                    <th>IGST Amt.
                    <th>Amount  -->
                    <th><button type="button" class="btn btn-mdb-color btn-sm" onclick="addNewRow1()"><i>ADD</i></button>
                    </tr>
                        <tr id="cloneRow1">
                 <!-- <td>
                  <input type="text" name="barcode[]" id="barcode" style=" width: 100px" class="pivotElement" onchange="fetchItemTypeAndItemFromDesign(this,<%=coid %>,'CR');"  />
                  </td>-->
                  
                    <td>
                     <input type="text" name="pid[]" id="pid" style=" width: 100px; display: none" value="0" />
                     <input type="text" name="desg_no1[]" id="desg_id" style=" width: 100px" class="desgClass" onchange="fetchItemTypeAndItemForKarighar(this,<%=coid %>,'CR');  " />
                        
                    </td> 
                    <td><select name="itm_typ_id1[]" id="item_typ_id" class="browser-default" onchange="getItems(this,this.value)">
                        <option value='0'>-select-</option>           
                        </select></td>
                    <td><select name="itm_id1[]" id="item_id" class="browser-default" onchange="getStockDetails(this,this.value,<%=coid %>)">
                        <option value='0'>-select-</option>           
                        </select></td>
                           <td style=" width: 50px;display: none"><input type="text" name="qty1[]" id="qty1"  value='0' />
             <!--  <td><input type="text" name="hsn_cd[]" id="hsn_cd" style=" width: 100px; text-align:left" readonly/></td>
               
                    <input type="text" name="stk[]" id="stk"  value='0' />
                    </td>  -->
                     <%
							String bid="";
	                           while(rsnew.next()){ 
	                        	   bid=bid + rsnew.getString("uom_nm") + "-";
	                           }
	                           rsnew.beforeFirst();
	                           System.out.println("SID==> "+bid);
							%>
                           <%                            
                           while(rsnew.next()){ 
                        	  
                           %>
                    <td><input type="text" name="nuom_id1[]" id="<%=rsnew.getString("uom_nm")%>" onkeyup="checkMinus(this.value,this);" onchange="putUomData1(this.id,this,this.value,'<%=sid%>');" class="cleanData" style="width:70px;text-align:right;"/>
                    
                    <%    
                    	}
                    %>
                    <td style=" width: 50px; display: none">
<!--                     <select name="uom_id[]" id="uom_id" class="browser-default" > -->
<!--                         <option value='0'>-select-</option>            -->
<!--                         </select> -->
                    <input type="text" name="uom_id1[]" id="uom_id" style=" width: 50px; text-align:right; display: none">    
                    </td>
<!--                     <td><input type="text" name="qty[]" id="qty" style=" width: 50px;text-align:right" value='0' onkeyup="checkMinus(this.value,this);" onchange="afterRateChange(this);getGstValues(this);" onchange="" /></td> 
                    <td><input type="text" name="rate[]" id="rate" style=" width: 100px;text-align:right" onkeyup="checkMinus(this.value,this);" onchange="afterRateChange(this); getGstValues(this)" />
                       </td>
                    <td><input type="text" name="basic[]" id="basic" style=" width: 100px; text-align:right" value='0.00' class="basClass" readonly/></td>
                    <td><input type="text" name="dis_per[]" id="dis_per" style=" width: 50px; text-align:right" value='0.00' onkeyup="checkMinus(this.value,this);" onchange="afterRateChange(this);getGstValues(this)" onchange=""/></td>
                    <td><input type="text" name="dis_amt[]" id="dis_amt" style=" width: 100px; text-align:right" value='0.00' class="disClass" readonly/></td>
                    <td><input type="text" name="gst_per[]" id="gst_per" style=" width: 50px; text-align:right" value='0.00' onchange="afterRateChange(this)" readonly/></td>
                    <td><input type="text" name="cgst_amt[]" id="cgst_amt" style=" width: 100px; text-align:right" value='0.00' class="cgstClass" readonly/></td>
                     <td><input type="text" name="sgst_amt[]" id="sgst_amt" style=" width: 100px; text-align:right" value='0.00' class="sgstClass" readonly/></td>
                      <td><input type="text" name="igst_amt[]" id="igst_amt" style=" width: 100px; text-align:right" value='0.00' class="igstClass" readonly/></td>
                     <td><input type="text" name="amt[]" id="amt" style=" width: 100px; text-align:right" value='0.00' class="amtClass" readonly/></td> -->
                      </tr>
                       <tr id="insertBefore1" class="table-info"><td colspan="9"></tr>
                  <!--   <tr id="insertBefore" class="table-info">
                    <th>
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
                    
                    <td><input type="text" name="tot_dis_amt" id="tot_dis_amt" class=" border border-success" style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                    <th>
                    
                    <td><input type="text" name="tot_cgst_amt" id="tot_cgst_amt" class=" border border-success"  style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                    <td><input type="text" name="tot_sgst_amt" id="tot_sgst_amt" class=" border border-success"  style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                    <td><input type="text" name="tot_igst_amt" id="tot_igst_amt" class=" border border-success"  style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                    
                   
                    <td><input type="text" name="tot_amt" id="tot_amt" class=" border border-success"  style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                    </tr>
                    <tr id="cloneRow1">
                   <% rsnew.beforeFirst();
                    while(rsnew.next())
                    {
                    %>
                    <th>
                    <% 
                    } 
                    rsnew.beforeFirst();
                    %>
                    <th colspan="4">Misc Head
                    <td colspan="2"> <select name="miscH[]" id="miscH" class="browser-default" onchange="fetchOtherHead(this.value,this.id,this)">
             <option value='0'>---select Option---</option>
             </select>
              <td><input type="text" placeholder="Amount" name="miscHamt[]" id="miscHamt" style="width: 100px; text-align:right" class="omiscHamt" onkeyup="checkMinus(this.value,this);" onchange="getOtherGstValues(this);addNewMiscRow()" onkeyup="calculateMgst(this.value,this)" /></td>
                    <th colspan="2">
                    <td><input type="text" name="o_gst_per[]" id="o_gst_per" style=" width: 50px; text-align:right" value='0.00' readonly/></td>
                    <td><input type="text" name="o_cgst_amt[]" id="o_cgst_amt" style=" width: 100px; text-align:right" value='0.00' class="ocgstClass" readonly/></td>
                     <td><input type="text" name="o_sgst_amt[]" id="o_sgst_amt" style=" width: 100px; text-align:right" value='0.00' class="osgstClass" readonly/></td>
                      <td><input type="text" name="o_igst_amt[]" id="o_igst_amt" style=" width: 100px; text-align:right" value='0.00' class="oigstClass" readonly/></td>
                     <td><input type="text" name="o_amt[]" id="o_amt" style=" width: 100px; text-align:right" value='0.00' class="oamtClass" readonly/></td>
                    <td style=" display: none;"><input type="text" name="o_cal_typ[]" id="o_cal_typ" style=" width: 100px; text-align:right" class="ocalType" readonly/>
                    </tr>
                    <tr id="afterMisc">
                    
                    </tr>
                    <tr class="table-danger">
                    <th colspan="4">
                    <% rsnew.beforeFirst();
                    while(rsnew.next())
                    {
                    %>
                    <th>
                    <% 
                    } 
                    rsnew.beforeFirst();
                    %>
                    <th colspan="2">Net Amount: 
                     <td><input type="text" placeholder="Amount" name="finBasic" class=" border-danger" id="finBasic" style="width: 100px; text-align:right" value='0.00'/></td>
                    <th colspan="">
                   <td><input type="text" name="fin_dis_amt" id="fin_dis_amt" class=" border-danger" style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                     <th colspan="">
                    <td><input type="text" name="fin_cgst_amt" id="fin_cgst_amt" style=" width: 100px; text-align:right" value='0.00' class=" border-danger" readonly/></td>
                     <td><input type="text" name="fin_sgst_amt" id="fin_sgst_amt" style=" width: 100px; text-align:right" value='0.00' class=" border-danger" readonly/></td>
                      <td><input type="text" name="fin_igst_amt" id="fin_igst_amt" style=" width: 100px; text-align:right" value='0.00' class=" border-danger" readonly/></td>
                     
                    <td><input type="text" name="net_amt" id="net_amt" class=" border-danger"  style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                     </tr>   -->
                    
                    </table>
                    </div>
                    
                   </div>
                   <div class="row">
                   
                    <div style="position: relative;" align="center">
                    <center>
                    <table>
                     <tr>
                    <td colspan="14" align="center"> <input type="submit" class="btn btn-primary btn-sm" value="submit" />
                    </tr>
                    </table>
                    </center>
                    </div>
                   
                </div>
               
                    </div>
                    </div>
                   </div>
                                      
                   
                   
       <div class="tab-pane fade" id="panel6" role="tabpanel">
        <div id="jsGrid"></div>  
        
          </div>
          
          </div>
          </form>
             <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document" style=" max-width: 90%">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Karigar View..</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
             <form id="form2" name="form_2" method="post" >
            <div class="modal-body" id="viewGrid">
            
            </div>
            </form>
            <div class="modal-footer">
              
<!--                 <input type="submit" class="btn btn-primary btn-sm" value="Ackowledged"/> -->
            </div>
        </div>
    </div>
</div>    
                 </div>
                
      
<!--        </div> -->
       <br>
                 
                     
    </div>        
      
       <div id="hiddenDiv" style=" display: none">
       <select name="party_id" id="party_id" class="browser-default" onchange="getConsignee(this.value)">
        <%
       String mnp= util.getDropdownStringForPckSlip("mst_party", "party_id","party_nm");
        out.println(mnp);
        %>                
        </select>
       </div>
      
       <div id="addRowValue" style=" display: none"></div>
          <div id="addRowValue1" style=" display: none"></div>
       <input type="hidden" id="gst_status"/>
         </main>
         
    </body>
    <%@include file="../common/footer.jsp" %>
</html>
