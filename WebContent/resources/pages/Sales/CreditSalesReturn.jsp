<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>Credit Sales Return Page....</title>

<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->


<script src="../../../resources/js/jquery-1.11.0.js"></script>
      <script src="../../../resources/js/packingSlip.js"></script> 
      <script src="../../../resources/js/validation.js"></script>   
<%@include file="../common/include.jsp"%>

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


<script>
// var bean1="PartyViewBean";
// var valcol1=["active","party_typ"];
// var valv1=["Y","SC"];
// var getDatas1={beanName:bean1,valColumn:valcol1,valValue:valv1};
// var params11=JSON.stringify(getDatas1);
// var p1="party_cd";
// var selectedCol11="party_id,party_nm";
// CallDropDownService(params11,p1,selectedCol11);
function validation1()
{
     //alert("hiii");
  var trn_dt=document.getElementById("bill_dt");
  //var name=document.getElementById("party_id");

    errors=[];
   // Dropdown1(associate_typ,"Please Select");
   // Dropdown1(name,"Please Select an ");
    checkBlank(trn_dt,"Bill Date");

    params=["pivotElement","#qty"];
    validationForDetailCashSaleReturn(params);

    return finalCheck();            
    
    }
function validationForDetailCashSaleReturn(params)
{
	
	//alert(params[0]);
	var x="."+params[0];
	var count=0;
	var temp_count=0;
	var cnt1=0;
	var cnt2=0;
	$(x).each(function() {cnt1++;
		 //var x=$(this).val();
		 var m= $(this).val() == '' ? 0 : $(this).val();
		 //alert(m);
		 if(m!='0'){
			 		for(var k=1;k<params.length;k++)
			 				{
			 				var temp=$(this).closest("tr").find(params[k]).val() == '' ? 0 : $(this).closest("tr").find(params[k]).val();
			 //alert(temp);
			 						if(m!='0' && temp=='0')
			 							{//alert("hii");
			 							$(this).closest("tr").find(params[k]).css("background-color", "yellow"); 
			 							temp_count=parseInt(temp_count)+1;
			 							}
			 
			 				}
		 			}
		 else
			 {
			 cnt2++;
			 }
		 if(parseInt(temp_count)>1)
			 {
			 count++;
			 }
		// alert(sum1);
		});
	if(parseInt(count)>0)
		{
		errors[errors.length] ="Please provide all the required fields";
		
		}
	if(cnt1==cnt2)
		{
		errors[errors.length] ="Please select atleast one item";
		}
	
	}
</script>

<script type="text/javascript">
	$(function() {
		$('#form1').submit(function(event) {
			event.preventDefault();
			//	alert("hahahah");
							var x = jQuery('#form1').serializeJSON();//$('#myForm').serializeJSON();
						
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
										url : "../../../addCrSale",

										data : val,
										dataType : 'json',

										success : function(data, textStatus) {
										//	alert(data);
											
											
											if (data=="" || data==null) {
												alert("==Data Submition failed==");
												 location.reload();
												
											} else {
												alert("Data has been submited successfully with Return No:-"+data);
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
function putUomData(id,x,paramval,sid)
{
	 $(x).closest('tr').find('#qty').val(paramval);
	 $(x).closest('tr').find('#uom_id').val(id);
	 var res = sid.split("-");
	    for(var i=0;i<res.length;i++)
	    {//alert(id+res[i]);
	    	if(id!=res[i]){
	    	//alert(res[i]);
	    	var y="#"+res[i];
	    	$(x).closest('tr').find(y).val("");
	    	}
	    }
	  //  afterRateChange(x);
	   // checkMinus(paramval,x);
	  
}


</script>


<script type="text/javascript">
	$(document).ready(function() {

// 		var bean = "PurchaseViewBean";
// 		var valcol = [ "active","vr_typ"];
// 		var valv = [ "Y","PURC"];
// 		var getDatas = {
// 			beanName : bean,
// 			valColumn : valcol,
// 			valValue : valv
// 		};
// 		var params = JSON.stringify(getDatas);
// 		var p = "pur_no";
// 		var selectedCol = "pur_no,pur_no";
// 		CallDropDownService(params, p, selectedCol);

	});
</script>

<script type="text/javascript">
$(window).load(function(){
	
	var pxx=$('#cloneRow').clone();
	$('#addRowValue').html(pxx);
});


$(document).ready(function() {
    $('.mdb-select').material_select();
   
   $('.datepicker').pickadate({
  	
  	  format: 'yyyy-mm-dd',
  	  max:new Date()
  	}); 
  
   

//    var bean="CreditSalesReturnBean";
//    var valcol=["active","vr_type","co_id"];
//    var valv=["Y","CRSA",$('#company_id').val()];
//    var getDatas={beanName:bean,valColumn:valcol,valValue:valv};
//    var params1=JSON.stringify(getDatas);
//    var select_id="bill_no";
//    var selectedCol1="bill_no,bill_no";
//    CallDropDownService(params1,select_id,selectedCol1);
  
// var bean1="RetailTempBean";
// var valcol1=["active"];
// var valv1=["Y"];
// var getDatas1={beanName:bean1,valColumn:valcol1,valValue:valv1};
// var params11=JSON.stringify(getDatas1);
// var p1="desg_id";
// var selectedCol11="tr_id,desg_no";
// CallDropDownService(params11,p1,selectedCol11);
 
// var bean3="ItemRateTypeBean";
// var valcol3=["active"];
// var valv3=["Y"];
// var getDatas3={beanName:bean3,valColumn:valcol3,valValue:valv3};
// var params13=JSON.stringify(getDatas3);
// var p3="rt_type";
// var selectedCol13="rt_typ_id,rt_typ_nm";
// CallDropDownService(params13,p3,selectedCol13);


// var beans="OtherHeadsHdr";
// var valcols=["active","hd_typ"];
// var valvs=["Y","PU"];
// var getDatass={beanName:beans,valColumn:valcols,valValue:valvs};
// var params1s=JSON.stringify(getDatass);
// var ps="miscH";
// var selectedCol1s="oh_id,description";
// CallDropDownService(params1s,ps,selectedCol1s);
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
   
// var bean1="RetailTempBean";
// var valcol1=["active"];
// var valv1=["Y"];
// var getDatas1={beanName:bean1,valColumn:valcol1,valValue:valv1};
// var params11=JSON.stringify(getDatas1);
// var p1="desg_id";
// var selectedCol11="tr_id,desg_no";
// CallDropDownService(params11,p1,selectedCol11);
  var bean2="PartyViewBean";
var valcol2=["active","party_typ","co_id"];
var valv2=["Y","SD","0"];
var getDatas2={beanName:bean2,valColumn:valcol2,valValue:valv2};
var params12=JSON.stringify(getDatas2);
var p2="party_id";
var selectedCol12="party_id,party_nm";
CallDropDownService(params12,p2,selectedCol12); 


});  

</script>


<script>
	function getSalesData(param,coid) {
		if(param=='0')
			{
			$('#insertDiv').hide();
			$('#newDiv').show();
			}else{
				var x=$('#vr_type1').val();
		$.get("../../ajax/getSalesDetailsForCrRet.jsp", {slip_no : param,co_id:coid,flag:x}, function(data, status) {
			$('#insertDiv').html(data);
			//getAutoFocus();
			$('.x').material_select();
			$('#newDiv').hide();
			$('#insertDiv').show();
		});
			}

	}
</script>
<script>
function getFinalValues()
{
	var tot_bas_amt=  $('#tot_bas_amt').val();
	var tot_dis_amt=  $('#tot_dis_amt').val();
	var tot_cgst_amt= $('#tot_cgst_amt').val();
	var tot_sgst_amt= $('#tot_sgst_amt').val();
	var tot_igst_amt= $('#tot_igst_amt').val();
	var tot_amt=      $('#tot_amt').val();
	//var ,,,,,
	var sum1=0.00,sum2=0.00,sum3=0.00,sum4=0.00,sum5=0.00,sum6=0.00;
	
	$(".omiscHamt").each(function() {
		 //var x=$(this).val();
		 var x= $(this).val() == '' ? 0.00 : $(this).val();
		 
		 sum1=parseFloat(sum1)+parseFloat(x);
		// alert(sum1);
		});
	
	$(".ocgstClass").each(function() {
		 //var x=$(this).val();
		 var x= $(this).val() == '' ? 0.00 : $(this).val();
		 
		 sum2=parseFloat(sum2)+parseFloat(x);
		// alert(sum1);
		});
	
	$(".osgstClass").each(function() {
		 //var x=$(this).val();
		 var x= $(this).val() == '' ? 0.00 : $(this).val();
		 
		 sum3=parseFloat(sum3)+parseFloat(x);
		// alert(sum1);
		});
	
	$(".oigstClass").each(function() {
		 //var x=$(this).val();
		 var x= $(this).val() == '' ? 0.00 : $(this).val();
		 
		 sum4=parseFloat(sum4)+parseFloat(x);
		// alert(sum1);
		});
	
	$(".oamtClass").each(function() {
		 //var x=$(this).val();
		 var x= $(this).val() == '' ? 0.00 : $(this).val();
		 
		 sum5=parseFloat(sum5)+parseFloat(x);
		// alert(sum1);
		});
	
	$('#finBasic').val(parseFloat(parseFloat(tot_bas_amt)+parseFloat(sum1)).toFixed(2));
	$('#fin_dis_amt').val(parseFloat(tot_dis_amt).toFixed(2));
	$('#fin_cgst_amt').val(parseFloat(parseFloat(tot_cgst_amt)+parseFloat(sum2)).toFixed(2));
	$('#fin_sgst_amt').val(parseFloat(parseFloat(tot_sgst_amt)+parseFloat(sum3)).toFixed(2));
	$('#fin_igst_amt').val(parseFloat(tot_igst_amt)+parseFloat(sum4));
	$('#net_amt').val(parseFloat(parseFloat(tot_amt)+parseFloat(sum5)).toFixed(2));//,,,,,
	
	}
  
   
</script>

 <script type="text/javascript">
 $(document).on("keypress",function(event){
 //$(":input").keypress(function(event){
	   if (event.which == '10' || event.which == '13') {
	        event.preventDefault();
	        $('#hsn_cd').focus();
	       // addNewRow();
	       // fetchItemTypeAndItemFromDesign(this);
	    }
	});
 // });
 </script> 
<script type="text/javascript">
$(window).load(function(){
	
	var pxx=$('#cloneRow').clone();
	$('#addRowValue').html(pxx);
});


$(document).ready(function() {
    $('.mdb-select').material_select();
   
   $('.datepicker').pickadate({
  	
  	  format: 'yyyy-mm-dd'
  	}); 
  </script>


</head>
<body class="fixed-sn mdb-skin-custom">
	<%@include file="../common/menu.jsp"%>

	<main>
	
		<div class="main-wrapper">
			<div class="container-fluid">
				<form id="form1" name="form_1" method="post">
				<div class="card-header deep-orange lighten-1 white-text text-center z-depth-2">Credit Sales Return</div>
				<div class="card card-body">
					<table class="table table-hover">
					<tr>
					<td><input type="hidden" id="vr_type1" name="vr_type1" value="CRSA">
					<input type="hidden" id="vr_type" name="vr_type" value="CRSR">
					</tr>
<!-- 						<tr> -->
<!-- 							<th>Bill Number: <select name="bill_no" id="bill_no" -->
<!-- 								class="mdb-select  colorful-select dropdown-primary " -->
<%-- 								onchange="getSalesData(this.value,<%=coid%>);"> --%>
<!-- 									<option value='0'>---select Option---</option> -->
<!-- 							</select> -->
<!-- 							</th> -->
<!-- 						</tr> -->
					</table>
					
					<div id="insertDiv" class="img-fluid" align="left">
					
					<%@include file="../../ajax/getSalesDetailsForCrRetNew.jsp"%>
					</div>
					</div>
					</form>
					

<!-- 					<div id="newDiv" class="" align="left"> -->
<!-- 						<form id="form2" name="form_2" method="post"> -->
					
<!-- 							<div class="table-responsive" align="left"> -->
                    
<!--        </div> -->
<!-- 						</form> -->
<!-- 					</div> -->
					
					
				</div>
			</div>
	
<div id="addRowValue" style="display:none;"></div>
<input type="text" id="gst_status"/>
	</main>
</body>
<%@include file="../common/footer.jsp"%>
</html>
