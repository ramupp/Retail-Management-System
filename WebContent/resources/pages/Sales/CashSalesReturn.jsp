<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>Cash Sales Return Page....</title>

<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->


<!-- <script src="../../../resources/js/jquery-1.11.0.js"></script> -->


<%@include file="../common/include.jsp"%>

 <script src="../../../resources/js/cashSales.js"></script> 
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

<script type="text/javascript">
function fetchCashParty()
{
	 $.noConflict();
	// var availableTags = [{"id":1,"label":"ActionScript"},{"id":2,"label":"BppleScript"}];
	$.get('../../../fetchCashParty',{}, function (response) {
	    // alert(response);
	    
	     $('#cust_name').autocomplete({
	    	    source:response,
	    	    select: function( event, ui ) { //alert(ui.item.id);
	    	    	// alert(ui.item.label);
	    	    $('#cust_code').val(ui.item.id);
	    	  //  getCashSaleParty(ui.item.id);
	    	    }
	    	});
	          

	      });		
}

function getSalesList(co_id)
{
	var cust_code=$('#cust_code').val();
	//alert(cust_code +"..."+ co_id);
	$.get("../../ajax/getCashsaleList.jsp", {cust_code : cust_code,co_id:co_id}, function(data, status) {
		console.log(data);
		//alert(data);
		$('#insertDiv').html("");
		$('#insertDiv').html(data);
		
	});
	
}


function getFinalValues()
{
	var tot_bas_amt=  $('#tot_bas_amt').val();
	var tot_dis_amt=  $('#tot_dis_amt').val();
	var tot_cgst_amt= $('#tot_cgst_amt').val();
	var tot_sgst_amt= $('#tot_sgst_amt').val();
	//var tot_igst_amt= $('#tot_igst_amt').val();
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
	
//	$(".oigstClass").each(function() {
//		 //var x=$(this).val();
//		 var x= $(this).val() == '' ? 0.00 : $(this).val();
//		 
//		 sum4=parseFloat(sum4)+parseFloat(x);
//		// alert(sum1);
//		});
	
	$(".oamtClass").each(function() {
		 //var x=$(this).val();
		 var x= $(this).val() == '' ? 0.00 : $(this).val();
		 
		 sum5=parseFloat(sum5)+parseFloat(x);
		// alert(sum1);
		});
	
	$('#finBasic').val(parseFloat(tot_bas_amt)+parseFloat(sum1));
	$('#fin_dis_amt').val(parseFloat(tot_dis_amt));
	$('#fin_cgst_amt').val(parseFloat(tot_cgst_amt)+parseFloat(sum2));
	$('#fin_sgst_amt').val(parseFloat(tot_sgst_amt)+parseFloat(sum3));
	//$('#fin_igst_amt').val(parseFloat(tot_igst_amt)+parseFloat(sum4));
	$('#net_amt').val(parseFloat(tot_amt)+parseFloat(sum5));//,,,,,
	
	}
  
   
</script>
<script type="text/javascript">
function validation1()
{
     //alert("hiii");
//   var trn_dt=document.getElementById("pck_sl_dt");
//   var name=document.getElementById("party_id");

    errors=[];
   // Dropdown1(associate_typ,"Please Select");
//     Dropdown1(name,"Please Select an ");
//     checkBlank(trn_dt,"Bill Date");

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
											 alert("====Data was not Saved====");
											 location.reload();
												
												// location.reload(); input-> memo_on input1->co_id input2->term condition
												
											} else {
												
												alert("Data Has Been Saved Suceessfully with Memo No:-"+data);
												 var x="<%=request.getContextPath()%>"+"/resources/pages/Sales/cashSalesReturnReport.jsp?"+"memo_no="+data+"&co_id="+$('#company_id').val();
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

</script>


<script type="text/javascript">
$(window).load(function(){
	
	var pxx=$('#cloneRow').clone();
	$('#addRowValue').html(pxx);
});




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

<script>
	function getSalesData(param,coid) {
		if(param=='0')
			{
			$('#insertDiv').hide();
			$('#newDiv').show();
			}else{
				var x=$('#vr_type1').val();
		$.get("../../ajax/getCashSalesDetails.jsp", {slip_no : param,co_id:coid,flag:x}, function(data, status) {
			console.log(data);
			$('#insertDiv').html("");
			$('#insertDiv').html(data);
			//getAutoFocus();
			jQuery('#salesman').material_select();
			jQuery('#helper').material_select();
		    jQuery('#tr_dt').pickadate({
		  	
	    	  format: 'yyyy-mm-dd'
	   	}); 
			$('#newDiv').hide();
			$('#insertDiv').show();
		});
			}

	}
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
});
  </script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body class="fixed-sn mdb-skin-custom" onload="fetchCashParty();">
	<%@include file="../common/menu.jsp"%>

	<main>
	
		<div class="main-wrapper">
			<div class="container-fluid" >
				
				<div class="card-header deep-orange lighten-1 white-text text-center z-depth-2">Cash Sales Return</div>
				<div class="card card-body">
					<table class="table table-hover">
					
						<tr><input type="hidden" id="vr_type1" name="vr_type1" value="CASA"/>
					<input type="hidden" id="vr_type" name="vr_type" value="CRSR"/>
							<th>Bill Number:
							 <input type="text"  name="memo_no" id="memo_no" class="form-control" onchange="getSalesData(this.value,<%=coid%>);"/>
							</th>
							<th>Customer Code:
							<input type="text"  name="cust_code" id="cust_code" class="form-control" onchange="getSalesList(<%=coid%>)"/>
							</th>
							<th>Customer Name:
							<input type="text"  name="cust_name" id="cust_name" class="form-control" onchange="getSalesList(<%=coid%>)"/>
							</th>
						</tr>
					</table>
					
					</div>
					<form id="form1" name="form_1" method="post">
					
					<div id="insertDiv" class="img-fluid" align="center"></div>
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
	</main>
</body>
<%@include file="../common/footer.jsp"%>
</html>
