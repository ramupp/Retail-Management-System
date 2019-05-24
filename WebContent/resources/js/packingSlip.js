

function afterDesgChange(x,co_id,tr_id)
{
	 var value=tr_id;//$(x).closest('tr').find('#desg_id').val();
	// alert("coid--"+co_id+"tr_id--"+tr_id);
	 var div_data=null;
	 var arr=null;
	 var beanName="RetailDesignViewBeanDtl";
	  var valColumn=["active","desg_id","co_id"];
	  var valValue=["Y",value,co_id];
	  var getData={beanName:beanName,valColumn:valColumn,valValue:valValue};
	  var params=JSON.stringify(getData);
	
	  //var text = $(this).closest('tr').find('.browser-default').get(3).attr('id');
	
	  var selectedCol="rate,rt_type,default_rate";
	
	  
	  $.ajax({

			beforeSend : function(xhrObj) {
				xhrObj.setRequestHeader("Content-Type", "application/json");
				xhrObj.setRequestHeader("Accept", "application/json");
			},
			type : "POST",
			url : "../../../getSelectData",

			data : params,
			dataType : 'json',

			success : function(data, textStatus) {
				//alert('request successful');
				var cols=selectedCol.split(',');
				//alert("cols:-"+cols);
				var k=0;
				 var val=null;
				 var show=null;
				 var def=null;
				 $.each(data,function(i,data){
					 val= data[cols[0]];
					 show= data[cols[1]];
					 def=data[cols[2]];
					// alert(val + 'the data is '+show+"def=="+def);
					 if(def=='Y'){  div_data="<option value='"+val+"' selected>"+show+"</option>"+","+div_data;}else{
				            div_data="<option value='"+val+"'>"+show+"</option>"+","+div_data;
					 }
				          // alert(div_data);
				           // $(div_data).appendTo(p); 
				            });
				 //   $(p).material_select();
				  arr=div_data.split(",");
				  //alert("arr:-"+arr.length);
				  $(x).closest('tr').find('#rate').find('option').remove();
				 // $('<option value="0">---select Option---</option>').appendTo($(x).closest('tr').find('#rate'));
				  
	  for( k=0;k<arr.length-1;k++)
		  {//alert("ARR IS:-"+arr[k]+"x is:-"+x.value);
		  $(arr[k]).appendTo($(x).closest('tr').find('#rate'));
		// $(x).closest('tr').find('#rate').appendChild(arr[k]);
		  }
	  getGstValues(x);
	  afterRateChange(x);
	 //$(x).closest('tr').find('#rate').material_select();
	
			},
			error : function(xhr, textStatus, errorThrown) {

				alert("error");
				
			}
		});
	}

function addNewRow()
{
	// alert("hello");
	
	 var x=$("#addRowValue").html();
	// $('.x').material_select('destroy');
	//$("#TableId").find("tr").last().after(x);
	$(x).insertBefore("#insertBefore");
	
	// $('.x').material_select();
	 
}
function fetchItemTypeAndItemFromDesign(x,co_id,type)
{
//
	var des_no=$(x).closest('tr').find('#barcode').val();
	  $.get('../../ajax/getItemAndItemTypeFromDesign_sales.jsp',{des_no:des_no,co_id:co_id,type:type}, function (response) {
     	//alert(response.trim());
		  var m=JSON.parse(response.trim());
		 // alert(m);
		  var item_type_id=m.itm_typ_id;
		  var item=m.itm_typ_nm;
		  var item_nm=m.itm_nm;
		  var item_id=m.itm_id;
		  var gst=m.gst_per;
		  var desg_no=m.desg_no;
		  var rate=m.rate;
		  var tr_id=m.tr_id;
		  var hsn_cd=m.hsn_cd;
		  var stk=m.cl_bal;
		 if(desg_no=="" || desg_no ==null)
			 
			 {
			 alert("This Item Does Not Have Credit Sale Rate Value");
			 }
			 else{ 
		 // alert("itm_typ_id-"+item_type_id);
		  var pp='<option value='+item_type_id+'>'+item+'</option>';
		  var mm='<option value='+item_id+'>'+item_nm+'</option>';
		 // alert(pp);item_id
		 $(x).closest('tr').find('#item_typ_id').find('option').remove();
		 $(pp).appendTo($(x).closest('tr').find('#item_typ_id'));
		 $(x).closest('tr').find('#item_id').find('option').remove();
		 $(mm).appendTo($(x).closest('tr').find('#item_id'));
		
		 $(x).closest('tr').find('#gst_per').val(parseFloat(gst).toFixed(2));
		 $(x).closest('tr').find('#desg_id').val(desg_no);
		 $(x).closest('tr').find('#hsn_cd').val(hsn_cd);
		 $(x).closest('tr').find('#stk').val(stk);
		 afterDesgChange(x,co_id,tr_id);
		
		 $(x).closest('tr').find('#rate').val(parseFloat(rate).toFixed(2));
		 $(x).closest('tr').find('#qty').focus(); 
		 }
		// alert($(x).closest('tr').find('#rate').val());
		
//           x=parseInt(x)+1;
//           document.getElementById("flag_incr").value=x;
		 addNewRow();
      });
	

}

function fetchItemTypeAndItemForDesign(x,co_id,type)
{
//
var des_no=$(x).closest('tr').find('#desg_id').val();
	
	if(des_no=='MISC')
		{
		//alert("hi");
		 $.get('../../ajax/getItemTypeFromDesign.jsp',{des_no:des_no,co_id:co_id,type:type}, function (response) {
		//item_typ_id	
			 $(x).closest('tr').find('#item_typ_id').find('option').remove();
			 $(x).closest('tr').find('#item_typ_id').append(response); 
			  //$('.cleanData').focus();
			  addNewRow();
		 });
		 
		
		}
	else
		
	{
	//var des_no=$(x).closest('tr').find('#barcode').val();
	  $.get('../../ajax/getItemAndItemTypeForDesign_sales.jsp',{des_no:des_no,co_id:co_id,type:type}, function (response) {
     	//alert(response.trim());
		  var m=JSON.parse(response.trim());
		 // alert(m);
		  var item_type_id=m.itm_typ_id;
		  var item=m.itm_typ_nm;
		  var item_nm=m.itm_nm;
		  var item_id=m.itm_id;
		  var gst=m.gst_per;
		  var desg_no=m.desg_no;
		  var rate=m.rate;
		  var tr_id=m.tr_id;
		  var hsn_cd=m.hsn_cd;
		  var stk=m.cl_bal;
		  var barcode=m.bar_code;
		 if(desg_no=="" || desg_no ==null)
			 
			 {
			 alert("This Item Does Not Have Credit Sale Rate Value");
			 }
			 else{ 
		 // alert("itm_typ_id-"+item_type_id);
		  var pp='<option value='+item_type_id+'>'+item+'</option>';
		  var mm='<option value='+item_id+'>'+item_nm+'</option>';
		 // alert(pp);item_id
		 $(x).closest('tr').find('#item_typ_id').find('option').remove();
		 $(pp).appendTo($(x).closest('tr').find('#item_typ_id'));
		 $(x).closest('tr').find('#item_id').find('option').remove();
		 $(mm).appendTo($(x).closest('tr').find('#item_id'));
		 $(x).closest('tr').find('#barcode').val(barcode);
		 $(x).closest('tr').find('#gst_per').val(parseFloat(gst).toFixed(2));
		 $(x).closest('tr').find('#desg_id').val(desg_no);
		 $(x).closest('tr').find('#hsn_cd').val(hsn_cd);
		 $(x).closest('tr').find('#stk').val(stk);
		 afterDesgChange(x,co_id,tr_id);
		
		 $(x).closest('tr').find('#rate').val(parseFloat(rate).toFixed(2));
		 $(x).closest('tr').find('#qty').focus(); 
		 }
		// alert($(x).closest('tr').find('#rate').val());
		
//           x=parseInt(x)+1;
//           document.getElementById("flag_incr").value=x;
		 addNewRow();
      });
	
	}
}

function fetchItemTypeAndItemForKarighar(x,co_id,type)
{
//
var des_no=$(x).closest('tr').find('#desg_id').val();
	
	if(des_no=='MISC')
		{
		//alert("hi");
		 $.get('../../ajax/getItemTypeFromDesign.jsp',{des_no:des_no,co_id:co_id,type:type}, function (response) {
		//item_typ_id	
			 $(x).closest('tr').find('#item_typ_id').find('option').remove();
			 $(x).closest('tr').find('#item_typ_id').append(response); 
			  //$('.cleanData').focus();
			  addNewRow();
		 });
		 
		
		}
	else
		
	{
	//var des_no=$(x).closest('tr').find('#barcode').val();
	  $.get('../../ajax/getItemAndItemTypeForDesign_sales.jsp',{des_no:des_no,co_id:co_id,type:type}, function (response) {
     	//alert(response.trim());
		  var m=JSON.parse(response.trim());
		 // alert(m);
		  var item_type_id=m.itm_typ_id;
		  var item=m.itm_typ_nm;
		  var item_nm=m.itm_nm;
		  var item_id=m.itm_id;
		  var gst=m.gst_per;
		  var desg_no=m.desg_no;
		  var rate=m.rate;
		  var tr_id=m.tr_id;
		  var hsn_cd=m.hsn_cd;
		  var stk=m.cl_bal;
		  var barcode=m.bar_code;
		 if(desg_no=="" || desg_no ==null)
			 
			 {
			 alert("This Item Does Not Have Credit Sale Rate Value");
			 }
			 else{ 
		 // alert("itm_typ_id-"+item_type_id);
		  var pp='<option value='+item_type_id+'>'+item+'</option>';
		  var mm='<option value='+item_id+'>'+item_nm+'</option>';
		 // alert(pp);item_id
		 $(x).closest('tr').find('#item_typ_id').find('option').remove();
		 $(pp).appendTo($(x).closest('tr').find('#item_typ_id'));
		 $(x).closest('tr').find('#item_id').find('option').remove();
		 $(mm).appendTo($(x).closest('tr').find('#item_id'));
		 $(x).closest('tr').find('#barcode').val(barcode);
		 $(x).closest('tr').find('#gst_per').val(parseFloat(gst).toFixed(2));
		 $(x).closest('tr').find('#desg_id').val(desg_no);
		 $(x).closest('tr').find('#hsn_cd').val(hsn_cd);
		 $(x).closest('tr').find('#stk').val(stk);
		// afterDesgChange(x,co_id,tr_id);
		
		 $(x).closest('tr').find('#rate').val(parseFloat(rate).toFixed(2));
		 $(x).closest('tr').find('#qty').focus(); 
		 }
		// alert($(x).closest('tr').find('#rate').val());
		
//           x=parseInt(x)+1;
//           document.getElementById("flag_incr").value=x;
		// addNewRow();
      });
	
	}
}
function fetchItemTypeAndItemFromDesignForCrSaleRet(x,co_id,type)
{
//
	var des_no=$(x).closest('tr').find('#barcode').val();
	  $.get('../../ajax/getItemAndItemTypeFromDesign_sales.jsp',{des_no:des_no,co_id:co_id,type:type}, function (response) {
     	//alert(response.trim());
		  var m=JSON.parse(response.trim());
		 // alert(m);
		  var item_type_id=m.itm_typ_id;
		  var item=m.itm_typ_nm;
		  var item_nm=m.itm_nm;
		  var item_id=m.itm_id;
		  var gst=m.gst_per;
		  var desg_no=m.desg_no;
		  var rate=m.rate;
		  var tr_id=m.tr_id;
		  var hsn_cd=m.hsn_cd;
		  var stk=m.cl_bal;
		 if(desg_no=="" || desg_no ==null)
			 
			 {
			 alert("This Item Does Not Have Credit Sale Rate Value");
			 }
			 else{ 
		 // alert("itm_typ_id-"+item_type_id);
		  var pp='<option value='+item_type_id+'>'+item+'</option>';
		  var mm='<option value='+item_id+'>'+item_nm+'</option>';
		 // alert(pp);item_id
		 $(x).closest('tr').find('#item_typ_id').find('option').remove();
		 $(pp).appendTo($(x).closest('tr').find('#item_typ_id'));
		 $(x).closest('tr').find('#item_id').find('option').remove();
		 $(mm).appendTo($(x).closest('tr').find('#item_id'));
		
		 $(x).closest('tr').find('#gst_per').val(parseFloat(gst).toFixed(2));
		 $(x).closest('tr').find('#desg_id').val(desg_no);
		 $(x).closest('tr').find('#hsn_cd').val(hsn_cd);
		// $(x).closest('tr').find('#stk').val(stk);
		 afterDesgChange(x,co_id,tr_id);
		
		 $(x).closest('tr').find('#rate').val(parseFloat(rate).toFixed(2));
		 $(x).closest('tr').find('#qty').focus(); 
		 }
		// alert($(x).closest('tr').find('#rate').val());
		
//           x=parseInt(x)+1;
//           document.getElementById("flag_incr").value=x;
		 addNewRow();
      });
	

}
function afterRateChange(x)
{
	var qty=$(x).closest('tr').find('#qty').val();
	var rate=$(x).closest('tr').find('#rate').val(); 
	//alert("in rate change");
	var stk=$(x).closest('tr').find('#stk').val(); 
	var desg=$(x).closest('tr').find('#desg_id').val(); 
	var item_types=$(x).closest('tr').find('#item_typ_id').val();
	var items=$(x).closest('tr').find('#item_id').val();
	if(desg=='MISC'){ //alert("in misc pck");
		
		 $.get('../../ajax/getGSTFromRMitem.jsp',{type:item_types,item:items,rate:rate}, function (response) {
			 var m=JSON.parse(response.trim());
			 // alert(x);
			  var gst=m.gst_per; 
			  var hsn_cd=m.hsn_cd;
			  $(x).closest('tr').find('#gst_per').val(gst);
			  $(x).closest('tr').find('#hsn_cd').val(hsn_cd);
			  $(x).closest('tr').find('#barcode').val(m.bar_code);
				//alert(qty+'---' +stk);
				if(parseInt(qty)<=parseInt(stk)){
				var basic=parseFloat(qty)*parseFloat(rate);
				var dis_per=$(x).closest('tr').find('#dis_per').val();
				$(x).closest('tr').find('#basic').val(parseFloat(basic).toFixed(2));
				var dis_amt=parseInt(qty)*parseFloat(rate)*(parseFloat(dis_per)*0.01);
				$(x).closest('tr').find('#dis_amt').val(parseFloat(dis_amt).toFixed(2));
				
//				if($("#inlineFormCheckMD"). prop("checked")==true)
//					{//alert("hi");
//					var gst_per=$(x).closest('tr').find('#gst_per').val();
//					//var	gst_amt=$(x).closest('tr').find('#gst_amt').val();
//					var	gst_amt=parseInt(qty)*parseFloat(rate)*(parseFloat(gst_per)*0.01);
//					$(x).closest('tr').find('#cgst_amt').val(Math.round(0.00,2));
//					$(x).closest('tr').find('#sgst_amt').val(Math.round(0.00,2));
//					$(x).closest('tr').find('#igst_amt').val(Math.round(gst_amt,2));
//					}else{ //alert("hello");
//						var gst_per=$(x).closest('tr').find('#gst_per').val();
//						var	gst_amt=parseInt(qty)*parseFloat(rate)*(parseFloat(gst_per/2)*0.01);
//						$(x).closest('tr').find('#cgst_amt').val(Math.round(gst_amt,2));
//						$(x).closest('tr').find('#sgst_amt').val(Math.round(gst_amt,2));
//						$(x).closest('tr').find('#igst_amt').val(Math.round(0.00,2));
//					}
				var cgst=$(x).closest('tr').find('#cgst_amt').val();
				var sgst=$(x).closest('tr').find('#sgst_amt').val();
				var igst=$(x).closest('tr').find('#igst_amt').val();
				//alert(igst);
				var amt=parseFloat((parseInt(qty)*parseFloat(rate)))-parseFloat(dis_amt)+parseFloat(cgst)+parseFloat(sgst)+parseFloat(igst);
				//alert(amt);
				$(x).closest('tr').find('#amt').val(parseFloat(amt).toFixed(2));

				afterDisAmtChange();
				//netAmount();
				getFinalValues();}
				else
				{//$(x).closest('tr').find('.cleanData').val('0');
				$(x).closest('tr').find('#qty').val('0');
				alert("Quantity Must Be less than Stock ");
				
				}
			 
		 });
		
	}else{
		// alert("in else misc pck");
		//alert(qty+'---' +stk);
		if(parseInt(qty)<=parseInt(stk)){
		var basic=parseFloat(qty)*parseFloat(rate);
		var dis_per=$(x).closest('tr').find('#dis_per').val();
		$(x).closest('tr').find('#basic').val(parseFloat(basic).toFixed(2));
		var dis_amt=parseInt(qty)*parseFloat(rate)*(parseFloat(dis_per)*0.01);
		$(x).closest('tr').find('#dis_amt').val(parseFloat(dis_amt).toFixed(2));
		
//		if($("#inlineFormCheckMD"). prop("checked")==true)
//			{//alert("hi");
//			var gst_per=$(x).closest('tr').find('#gst_per').val();
//			//var	gst_amt=$(x).closest('tr').find('#gst_amt').val();
//			var	gst_amt=parseInt(qty)*parseFloat(rate)*(parseFloat(gst_per)*0.01);
//			$(x).closest('tr').find('#cgst_amt').val(Math.round(0.00,2));
//			$(x).closest('tr').find('#sgst_amt').val(Math.round(0.00,2));
//			$(x).closest('tr').find('#igst_amt').val(Math.round(gst_amt,2));
//			}else{ //alert("hello");
//				var gst_per=$(x).closest('tr').find('#gst_per').val();
//				var	gst_amt=parseInt(qty)*parseFloat(rate)*(parseFloat(gst_per/2)*0.01);
//				$(x).closest('tr').find('#cgst_amt').val(Math.round(gst_amt,2));
//				$(x).closest('tr').find('#sgst_amt').val(Math.round(gst_amt,2));
//				$(x).closest('tr').find('#igst_amt').val(Math.round(0.00,2));
//			}
		var cgst=$(x).closest('tr').find('#cgst_amt').val();
		var sgst=$(x).closest('tr').find('#sgst_amt').val();
		var igst=$(x).closest('tr').find('#igst_amt').val();
		//alert(igst);
		var amt=parseFloat((parseInt(qty)*parseFloat(rate)))-parseFloat(dis_amt)+parseFloat(cgst)+parseFloat(sgst)+parseFloat(igst);
		//alert(amt);
		$(x).closest('tr').find('#amt').val(parseFloat(amt).toFixed(2));

		afterDisAmtChange();
		//netAmount();
		getFinalValues();}
		else
		{//$(x).closest('tr').find('.cleanData').val('0');
		$(x).closest('tr').find('#qty').val('0');
		alert("Quantity Must Be less than Stock ");
		
		}
	}
	
	
}


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
	//alert("helloo");
	$(".omiscHamt").each(function() {
		 //var x=$(this).val();
		 var x= $(this).val() == '' ? 0.00 : $(this).val();
		 
		 sum1=parseFloat(sum1)+parseFloat(x);
		 //alert(sum1);
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
	//alert(tot_bas_amt);
	$('#finBasic').val(parseFloat(parseFloat(tot_bas_amt)+parseFloat(sum1)).toFixed(2));
	$('#fin_dis_amt').val(parseFloat(tot_dis_amt).toFixed(2));
	$('#fin_cgst_amt').val(parseFloat(parseFloat(tot_cgst_amt)+parseFloat(sum2)).toFixed(2));
	$('#fin_sgst_amt').val(parseFloat(parseFloat(tot_sgst_amt)+parseFloat(sum3)).toFixed(2));
	$('#fin_igst_amt').val(parseFloat(parseFloat(tot_igst_amt)+parseFloat(sum4)).toFixed(2));
	$('#net_amt').val(parseFloat(parseFloat(tot_amt)+parseFloat(sum5)).toFixed(2));//,,,,,
	
	}
  
   


function afterDisAmtChange()
{

var sum=0.00;
var sum1=0.00;
var sum2=0.00;
var sum3=0.00;
var sum4=0.00;
var sum5=0.00;
$(".disClass").each(function() {
 var x=$(this).val();
 sum=parseFloat(sum)+parseFloat(x);
});

$(".cgstClass").each(function() {
	 var x=$(this).val();
	 sum1=parseFloat(sum1)+parseFloat(x);
	});
$(".amtClass").each(function() {
	 var x=$(this).val();
	 sum2=parseFloat(sum2)+parseFloat(x);
	});
	$(".basClass").each(function() {
		 var x=$(this).val();
		 sum3=parseFloat(sum3)+parseFloat(x);
		});
	$(".sgstClass").each(function() {
		 var x=$(this).val();
		 sum4=parseFloat(sum4)+parseFloat(x);
		});
	$(".igstClass").each(function() {
		 var x=$(this).val();
		 sum5=parseFloat(sum5)+parseFloat(x);
		});
	$('#tot_bas_amt').val(parseFloat(sum3).toFixed(2));
	$('#tot_dis_amt').val(parseFloat(sum).toFixed(2));
	$('#tot_cgst_amt').val(parseFloat(sum1).toFixed(2));
	$('#tot_amt').val(parseFloat(sum2).toFixed(2));
	$('#tot_sgst_amt').val(parseFloat(sum4).toFixed(2));
	$('#tot_igst_amt').val(parseFloat(sum5).toFixed(2));
	
	}
function netAmount()
{
	
var x=parseFloat($('#tot_amt').val()).toFixed(2);
$('#net_amt').val(x);
}
function afterPaidChange(x)
{
	var net_amt=$('#net_amt').val();
	var temp=parseFloat(net_amt)-parseFloat(x);
	$('#bal_amt').val(parseFloat(temp).toFixed(2));
}

function calculateMgst(val,x)
{//alert(val);
//	  if($("#inlineFormCheckMD"). prop("checked")==true)
//		  {
//		  
//		  var gst_per=$(x).closest('tr').find('#o_gst_per').val();
//			//var	gst_amt=$(x).closest('tr').find('#gst_amt').val();
//			var	gst_amt=parseInt(val)*(parseFloat(gst_per)*0.01);
//			$(x).closest('tr').find('#o_cgst_amt').val(0.00);
//			$(x).closest('tr').find('#o_sgst_amt').val(0.00);
//			$(x).closest('tr').find('#o_igst_amt').val(gst_amt);
//		  
//		  }
//	  else
//		  {
//		  
//		  var gst_per=$(x).closest('tr').find('#o_gst_per').val();
//		  var	gst_amt=parseInt(val)*(parseFloat(gst_per/2.0)*0.01);
//			$(x).closest('tr').find('#o_cgst_amt').val((gst_amt));
//			$(x).closest('tr').find('#o_sgst_amt').val(gst_amt);
//			$(x).closest('tr').find('#o_igst_amt').val(0.00);
//		  
//		  
//		  }
	 
	  var cgst=$(x).closest('tr').find('#o_cgst_amt').val();
		var sgst=$(x).closest('tr').find('#o_sgst_amt').val();
		var igst=$(x).closest('tr').find('#o_igst_amt').val();
	  var amt=parseFloat(val)+parseFloat(cgst)+parseFloat(sgst)+parseFloat(igst);
	  var m=$(x).closest('tr').find('#o_cal_typ').val();
	  if(m=='A'){
		  $(x).closest('tr').find('#o_amt').val(parseFloat(amt).toFixed(2)); 
	  }else
		  {
		  $(x).closest('tr').find('#o_amt').val(parseFloat((parseFloat(amt))*(-1)).toFixed(2)); 
		  }
		
		getFinalValues();
	  
}
function fetchOtherHead(oh_id,id,x)
{
//
	
	  $.get('../../ajax/getOtherHeads.jsp',{type:oh_id}, function (response) {
      //	alert(response.trim());
		  var m=JSON.parse(response.trim());
		//  alert(JSON.stringify(response.trim()));
		//  alert(m);
//		  var item_type_id=m.itm_typ_id;
//		  var item=m.itm_typ_nm;
//		  var item_nm=m.itm_nm;
//		  var item_id=m.itm_id;
//		  var gst=m.gst_per;
		  var oh_id ="";
		var description="";
		var cal_typ="";
		var cal_typ="";
		  for(var i=0;i< m.length;i++)
		  {
		        oh_id = m[i].oh_id;
		        description = m[i].description;
		      cal_typ = m[i].cal_typ; 
		      gst_per = m[i].gst_per; 
		   
		  }
		 // alert(cal_typ);
		 $(x).closest('tr').find('#o_gst_per').val(parseFloat(gst_per)); 
		$(x).closest('tr').find('#o_cal_typ').val(cal_typ); 
		calculateMgst($(x).closest('tr').find('#miscHamt').val(),x); 
		 // alert(pp);item_id
		
		// $(x).closest('tr').find('#item_id').find('option').remove();
		 
		
		// $(x).closest('tr').find('#gst_per').val(parseFloat(gst));
//           x=parseInt(x)+1;
//           document.getElementById("flag_incr").value=x;
      });


}

function addNewMiscRow()
{
	  
	  var x=$("#cloneRow1").clone();
		// $('.x').material_select('destroy');
		//$("#TableId").find("tr").last().after(x);
	  x.find("#miscHamt").val("");
	  x.find("#o_gst_per").val("0.00");
	  x.find("#o_cgst_amt").val("0.00");
	  x.find("#o_sgst_amt").val("0.00");
	  x.find("#o_igst_amt").val("0.00");
	  x.find("#o_amt").val("0.00");
	  
		$(x).insertBefore("#afterMisc");
}

//function afterPaidChange(x)
//{
//	var net_amt=$('#net_amt').val();
//	var temp=parseFloat(net_amt)-parseFloat(x);
//	$('#bal_amt').val(temp);
//}
function getConsignee(id)
{
	var bean3="ConsigneeMasterBean";
	 var valcol3=["active","party_id"];
	 var valv3=["Y",id];
	 var getDatas3={beanName:bean3,valColumn:valcol3,valValue:valv3};
	 var params13=JSON.stringify(getDatas3);
	 var p3="consg_id";
	 var selectedCol13="consg_id,consg_nm";
	 CallDropDownService(params13,p3,selectedCol13);	
}
function getGstValues(param)

{
	//alert("in gst");
	var y1=$('#party_id').val();
	//alert("y"+y1);
	if(y1==0){
		alert('Please enter your vendor.....');
		//$('#party_cd').val='';
		$(param).closest('tr').find('#gst_per').val("0.00"); 
		//afterRateChange(param);
	}
	else{
	//	alert(1);
      var x1=$('#company_id').val();
    //  alert("x==> "+x1);
    //  alert("y==> "+y1);
	
	  $.get('../../ajax/getGstValues.jsp',{co_id:x1,party_cd:y1}, function (response) {
     
		  var m=response.trim();
		 // alert(m);
		 // alert(2);
		 var basic = $(param).closest('tr').find('#basic').val(); 
		 var discount = $(param).closest('tr').find('#dis_amt').val(); 
		 var gstper=$(param).closest('tr').find('#gst_per').val(); 
		 var amount = parseFloat(basic) -  parseFloat(discount); 
		 //alert("amount is:-"+amount);
		 var gst_amt=amount * (parseFloat(gstper)*0.01);
		//alert(discount);
		 if(m =="true"){//alert("in gst if-"+gst_amt/2);
		 $(param).closest('tr').find('#cgst_amt').val(parseFloat(gst_amt/2).toFixed(2)); 
		 $(param).closest('tr').find('#sgst_amt').val(parseFloat(gst_amt/2).toFixed(2)); 
		 }
		 else
			 {// alert("in gst else-"+gst_amt);
			 $(param).closest('tr').find('#igst_amt').val(parseFloat(gst_amt).toFixed(2)); 
			 }
		 //
		 $('#gst_status').val(m);
		 afterRateChange(param);
      });
	  
	}
	


}
function getOtherGstValues(param)

{ var value =  $('#gst_status').val();
var tot1=0.00,tot2=0.00;
var mbasic = $(param).closest('tr').find('#miscHamt').val(); 		
var mgstper=$(param).closest('tr').find('#o_gst_per').val(); 	
var mamt=$(param).closest('tr').find('#o_amt').val(); 
var m=$(param).closest('tr').find('#o_cal_typ').val();
var mgst_amt=mbasic * (parseFloat(mgstper)*0.01);
//alert("value "+value);
	if(value=="true"){		
		
		 $(param).closest('tr').find('#o_cgst_amt').val(parseFloat(mgst_amt/2).toFixed(2)); 
		 $(param).closest('tr').find('#o_sgst_amt').val(parseFloat(mgst_amt/2).toFixed(2)); 
		// alert("mgst_amt "+mgst_amt);
		// alert("mamt "+mamt);
		 tot1=parseFloat(mgst_amt) + parseFloat(mbasic);
		// alert("tot1 "+tot1);
		 if(m=='A'){
		 $(param).closest('tr').find('#o_amt').val(parseFloat(tot1).toFixed(2)); 
		 }else
			 {
			 $(param).closest('tr').find('#o_amt').val(parseFloat(tot1*-1).toFixed(2));  
			 }
	
	}
	else
		{
		 $(param).closest('tr').find('#o_igst_amt').val(parseFloat(mgst_amt).toFixed(2)); 
		 $(param).closest('tr').find('#o_amt').val(parseFloat(mgst_amt).toFixed(2)); 
		// alert("mgst_amt "+mgst_amt);
		// alert("mamt "+mamt);
		 tot2=parseFloat(mgst_amt) + parseFloat(mbasic);
		// alert("tot2 "+tot2);
		 if(m=='A'){
		 $(param).closest('tr').find('#o_amt').val(parseFloat(tot2).toFixed(2)); 
		 }
		 else
			 {
			 $(param).closest('tr').find('#o_amt').val(parseFloat(tot2*-1).toFixed(2)); 
			 }
		}
	
	getFinalValues();
}


function afterRateChangeReturn(x)
{
	var qty=$(x).closest('tr').find('#qty').val();
	var rate=$(x).closest('tr').find('#rate').val(); 
	//alert("in rate change");
	var basic=parseFloat(qty)*parseFloat(rate);
	var dis_per=$(x).closest('tr').find('#dis_per').val();
	$(x).closest('tr').find('#basic').val(parseFloat(basic).toFixed(2));
	var dis_amt=parseInt(qty)*parseFloat(rate)*(parseFloat(dis_per)*0.01);
	$(x).closest('tr').find('#dis_amt').val(parseFloat(dis_amt).toFixed(2));
	var cal_amt=(parseFloat(qty)*parseFloat(rate))-parseFloat(dis_amt);
	var gst_per=$(x).closest('tr').find('#gst_per').val();
	var cgst=$(x).closest('tr').find('#cgst_amt').val();
	//alert(" - "+cgst);
 	var sgst=$(x).closest('tr').find('#sgst_amt').val();
 	//alert(" - "+sgst);
	var igst=$(x).closest('tr').find('#igst_amt').val();
	///var	gst_amt=cal_amt*(parseFloat(gst_per/2)*0.01);
	 var gst_amt=parseFloat(parseFloat(cal_amt) * (parseFloat(gst_per)*0.01)).toFixed(2);
		//alert(gst_amt+"---"+cal_amt);
		 if(igst=="0.00"){
			// alert("inside true");
			 
		 $(x).closest('tr').find('#cgst_amt').val(parseFloat(gst_amt/2).toFixed(2)); 
		 cgst=(parseFloat(gst_amt)/2);
		 $(x).closest('tr').find('#sgst_amt').val(parseFloat(gst_amt/2).toFixed(2)); 
		 sgst=(parseFloat(gst_amt)/2);
		 }
		 else
		{
			// alert("inside false");
			 $(x).closest('tr').find('#igst_amt').val(parseFloat(gst_amt).toFixed(2)); 
			 igst=parseFloat(gst_amt);
	     }
	var amt=parseInt(qty)*parseFloat(rate)-parseFloat(dis_amt)+parseFloat(cgst)+parseFloat(sgst)+parseFloat(igst);
	//alert(amt);
	$(x).closest('tr').find('#amt').val(parseFloat(Math.round(amt,2)).toFixed(2));

	afterDisAmtChange();
	//netAmount();
	getFinalValues();
}
