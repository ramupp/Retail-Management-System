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
        <title>Stock Out</title>
        
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
 var valv7=["Y","TR"];
 var getDatas7={beanName:bean7,valColumn:valcol7,valValue:valv7};
 var params17=JSON.stringify(getDatas7);
 var p7="transp_id";
 var selectedCol17="party_id,party_nm";
 CallDropDownService(params17,p7,selectedCol17);
 
 var beans="OtherHeadsHdr";
 var valcols=["active","hd_typ"];
 var valvs=["Y","SA"];
 var getDatass={beanName:beans,valColumn:valcols,valValue:valvs};
 var params1s=JSON.stringify(getDatass);
 var ps="miscH";
 var selectedCol1s="oh_id,description";
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
	
	});
</script>
 <script type="text/javascript">
 $(document).on("keypress",function(event){
 //$(":input").keypress(function(event){
	   if (event.which == '10' || event.which == '13') {
	        event.preventDefault();
	        $('#qty').focus();
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
  var trn_dt=document.getElementById("bill_dt");
  var name=document.getElementById("party_id");

    errors=[];
   // Dropdown1(associate_typ,"Please Select");
    Dropdown1(name,"Please Select an ");
    checkBlank(trn_dt,"Bill Date");

    params=["pivotElement","#qty","#rate"];
    validationForDetail(params);

    return finalCheck();            
    
    }

</script>
<script type="text/javascript">

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
									url : "../../../addCrSaleForStockOut",
									//enctype: 'multipart/form-data',
									// processData: false,  // Important!
								    contentType: 'application/json',
									data : val,
									dataType : 'json',
									

									success : function(data, textStatus) {
										//alert(data);
										
										// 				for (var i = 0; i < data.length; i++) {
										// 					fin_data= data[i].user_id + data[i].user_pw;
										// 
											if (data==""|| data==null) {
											 alert("Data was not Saved");
											 location.reload();
												
												// location.reload(); input-> memo_on input1->co_id input2->term condition
												
											} else {
										
											alert("====Data Has Been Saved Suceessfully====");
											//$('#centralModalSuccess').modal();
											var x="<%=request.getContextPath()%>"+"/resources/pages/Sales/crReport.jsp?"+"input="+data+"&input1="+$('#company_id').val();
											window.location.replace(x);
											
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
//}
</script>
 <script type="text/javascript">
 function getDetailsForSalesTransfer(id,value,coid)
 {
//alert("id is:-"+id+" val is:-"+value);	
if(value=='STKO')
{
	$.get("../../ajax/getAutoGeneratedSerialNumber.jsp",{code:'STKO',coid:coid,type:'PKSL'}, function(data, status){  			
	   // alert(data);  
	   // $('#pck_sl_no').val(data.trim());	
	    var x=$('#hiddenDiv').html();
	    var y=document.getElementById ("party_td").innerHTML;
	    //$('#party_td').html();
	   
	    $('#party_td').html("");
	  // alert(y);
 	    $('#party_td').html(x);
 	  // $('#party_id').material_select('destroy');
 	  // 
	   $('#party_ids').material_select();
	  
	    $('#hiddenDiv').html("");
 	    $('#hiddenDiv').html(y);
 	  // $('#party_id').material_select();
 	 //  $('#party_id').material_select('destroy');
 	 // $('#party_id').material_select();
	    
	   
	    });
		
 }
else
	

	{
		$.get("../../ajax/getAutoGeneratedSerialNumber.jsp",{code:'CRSA',coid:coid,type:'SALE'}, function(data, status){  			
		   // alert(data);  
		  //  $('#pck_sl_no').val(data.trim());	
		    var x=$('#hiddenDiv').html();
		    var y=$('#party_td').html();
		   // alert("x---"+x);
		   // alert("y---"+y);
		    
		    $('#party_td').html("");
		   
	 	    $('#party_td').html(x);
	 	  // $('#party_id').material_select();
	 	  $('#party_id').material_select('destroy');
	 	    $('#party_id').material_select();
		  
		  
// 		    $('#hiddenDiv').html("");
// 	 	    $('#hiddenDiv').html(y);
// 	 	  $('#party_id').material_select('destroy');
	 	  
		    });
			
	 }
	
}
 
 </script>   
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

</script>

    </head>
    <body class="fixed-sn mdb-skin-custom ">
<%@include file="../common/menu.jsp" %>

        
        <main>
        <form id="form1" name="form_1" method="post" >
 <div class="main-wrapper">
          <div class="container-fluid">
     
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2"> Stock Out </div>
       <div class="card card-body">
                 <table class="table-hover" >
                         
<!--           <tr><td colspan="7"> -->
<!-- 	<div class="form-check"> Select Type: -->
<%--     <input class="form-check-input" name="slp_type" type="radio" id="radio100" value="CRSA" onclick="getDetailsForSalesTransfer(this.id,this.value,<%=coid %>)" checked> --%>
<!--     <label class="form-check-label" for="radio100">Credit Sales</label> -->

<%--     <input class="form-check-input" name="slp_type" type="radio" id="radio101" value="STKO"  onclick="getDetailsForSalesTransfer(this.id,this.value,<%=coid %>)" > --%>
<!--     <label class="form-check-label" for="radio101">Stock Transfer</label> -->
<!-- </div> -->

<!-- </td></tr> -->
            
                   <tr><input type="hidden" name="vr_type" value="STKO"/>
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
                          <input placeholder="Selected date" type="text" name="bill_dt" id="bill_dt" style=" width: 120px" value="<%=trdate %>" class="form-control datepicker">
                        	
                        
                        </td>
                        <th>
                              Customer Name:
                            </th>

                            <td id="party_td">
                                 
                         <select name="party_id" id="party_id" class="browser-default" onchange="getConsignee(this.value)">
                           <%
       String mnp= util.getDropdownStringForPckSlip("mst_party", "party_id","party_nm");
        out.println(mnp);
        %>    
                        </select>
                            </td>
                            <th>
                              Consignee:
                            </th>

                            <td >
                           <select name="consg_id" id="consg_id" class="mdb-select  colorful-select dropdown-primary " >
                        </select>
                                                
                            </td>
                            <th>
                              Transporter:
                            </th>
                            <td>
                      <select name="transp_id" id="transp_id" class="mdb-select  colorful-select dropdown-primary " >
                        </select>
                        
                            </td>
						 
                       
                        </tr>
                      
						<tr>
						<th>
                       No. Of Packets:
                        </th>
                        <td>
                         <input type="text" name="no_of_pck" id="no_of_pck" class="form-control" style=" width: 70px" onkeyup="checkMinus(this.value,this);"/> 
                        </td>  
						<th>
                       LR No:
                        </th>
                        <td>
                         <input type="text" name="lr_no" id="no_of_pck" class="form-control" /> 
                         
                        </td>
                       <th>LR Date:
                       <td>
                        <input placeholder="Selected date" type="text" name="lr_dt" id="lr_dt" class="form-control datepicker">
                       </td>
                       <th>Packing Weight:
                       <td>
                        <input  type="text" name="pkwt" id="pkwt" class="form-control">
                       </td>
                        <th>
                      Note:
                        </th>
                        <td colspan="1">
                        
                         <textarea type="text" id="notes"  name="notes" class="md-textarea form-control"></textarea>
                        </td>
                        </tr>
                         <tr>
                        
                       
<!--                        <th> -->
<!--                         SalesMan: -->
<!--                         </th> -->
<!--                         <td> -->
<!-- <!--                          <input type="text" name="cust_email" id="cust_email" class="form-control" />  -->
<!--  <select name="salesman" id="salesman" class="mdb-select  colorful-select dropdown-primary " > -->
<!--                         </select> -->
<!--                         </td> -->
<!--                         <th> -->
<!--                         Helper: -->
<!--                         </th> -->
<!--                         <td> -->
<!-- <!--                          <input type="text" name="cust_email" id="cust_email" class="form-control" />  --> 
<!--  <select name="helper" id="helper" class="mdb-select  colorful-select dropdown-primary " > -->
<!--                         </select> -->
<!--                         </td> -->
                       
                        </tr>
                       
                          
                    </table>
                    </div>
                    <br>
                  <div class="row justify-content-start border-warning" >
                    <table class="table-bordered border-warning table-responsive">
<!--                     <tr> -->
<!--                     <td colspan="6"><center>  <button type="button" class="btn btn-mdb-color btn-sm" onclick="addNewRow()"><i>ADD Details</i></button></center> -->
<!--                     <td colspan="3" align="left"> -->
                  
<!--                     </td> -->
<!--                     <td colspan="4" align="left"> -->
<!--                     <button type="button" class="btn btn-primary btn-sm" onclick="addNewMiscRow()"><i class="fa fa-plus-square mr-1"></i> Add/Less Misc.</button> -->
<!--                     </td> -->
<!--                     </tr> -->
                    <tr>
                      <th>Barcode 
                    <th>Design 
                   
                    <th>Item Type
                    <th>Item
                    <th>HSN Code
                    <th>Quantity
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
                  <td>
                  <input type="text" name="barcode[]" id="barcode" style=" width: 100px" class="pivotElement" onchange="fetchItemTypeAndItemFromDesign(this,<%=coid %>,'CR');"  />
                  </td>
                    <td>

<input type="text" name="desg_id[]" id="desg_id" style=" width: 100px" onchange="fetchItemTypeAndItemForDesign(this,<%=coid %>,'CR');"/>
                        
                    </td>
                    <td><select name="item_typ_id[]" id="item_typ_id" class="browser-default" >
                        <option value='0'>-select-</option>           
                        </select></td>
                    <td><select name="item_id[]" id="item_id" class="browser-default" >
                        <option value='0'>-select-</option>           
                        </select></td>
                    <td><input type="text" name="hsn_cd[]" id="hsn_cd" style=" width: 100px; text-align:left" readonly/></td>
                    <td><input type="hidden" name="stk[]" id="stk"  value='0' />
                    <input type="text" name="qty[]" id="qty" style=" width: 50px;text-align:right" value='0' onkeyup="checkMinus(this.value,this);" onchange="afterRateChange(this);getGstValues(this);" onchange="" /></td>
                    <td><input type="text" name="rate[]" id="rate" style=" width: 100px;text-align:right" onkeyup="checkMinus(this.value,this);" onchange="afterRateChange(this)" onchange="getGstValues(this)"/>
                       </td>
                    <td><input type="text" name="basic[]" id="basic" style=" width: 100px; text-align:right" value='0.00' class="basClass" readonly/></td>
                    <td><input type="text" name="dis_per[]" id="dis_per" style=" width: 50px; text-align:right" value='0.00' onkeyup="checkMinus(this.value,this);" onchange="afterRateChange(this)" onchange="getGstValues(this)"/></td>
                    <td><input type="text" name="dis_amt[]" id="dis_amt" style=" width: 100px; text-align:right" value='0.00' class="disClass" readonly/></td>
                    <td><input type="text" name="gst_per[]" id="gst_per" style=" width: 50px; text-align:right" value='0.00' onchange="afterRateChange(this)" readonly/></td>
                    <td><input type="text" name="cgst_amt[]" id="cgst_amt" style=" width: 100px; text-align:right" value='0.00' class="cgstClass" readonly/></td>
                     <td><input type="text" name="sgst_amt[]" id="sgst_amt" style=" width: 100px; text-align:right" value='0.00' class="sgstClass" readonly/></td>
                      <td><input type="text" name="igst_amt[]" id="igst_amt" style=" width: 100px; text-align:right" value='0.00' class="igstClass" readonly/></td>
                     <td><input type="text" name="amt[]" id="amt" style=" width: 100px; text-align:right" value='0.00' class="amtClass" readonly/></td>
                      </tr>
                    <tr id="insertBefore" class="table-info">
                    <th>
                    <th>
                    <th>
                    <th>
                     <th>  <th>
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
                    <th >
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
                    <th colspan="5">
                    <th colspan="2">Net Amount: 
                     <td><input type="text" placeholder="Amount" name="finBasic" class=" border-danger" id="finBasic" style="width: 100px; text-align:right" value='0.00'/></td>
                    <th colspan="">
                   <td><input type="text" name="fin_dis_amt" id="fin_dis_amt" class=" border-danger" style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                     <th colspan="">
                    <td><input type="text" name="fin_cgst_amt" id="fin_cgst_amt" style=" width: 100px; text-align:right" value='0.00' class=" border-danger" readonly/></td>
                     <td><input type="text" name="fin_sgst_amt" id="fin_sgst_amt" style=" width: 100px; text-align:right" value='0.00' class=" border-danger" readonly/></td>
                      <td><input type="text" name="fin_igst_amt" id="fin_igst_amt" style=" width: 100px; text-align:right" value='0.00' class=" border-danger" readonly/></td>
                     
                    <td><input type="text" name="net_amt" id="net_amt" class=" border-danger"  style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                     </tr>
                     <tr>
                    <td colspan="14" align="center"> <input type="submit" class="btn btn-primary btn-sm" value="submit" />
                    </tr>
                    </table>
                    
                    </div>
                   
                 </div>
                
      
<!--        </div> -->
       <br>
                 
                     
    </div>        
       </form>
       <div id="hiddenDiv" style=" display: none">
       <select name="party_id" id="party_id" class="browser-default" onchange="getConsignee(this.value)">
                  
        </select>
       </div>
      
       <div id="addRowValue" style=" display: none"></div>
       <input type="hidden" id="gst_status"/>
         </main>
         
    </body>
    <%@include file="../common/footer.jsp" %>
</html>
