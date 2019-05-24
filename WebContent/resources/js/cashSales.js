

function afterDesgChange(x,co_id)
{
	 var value=$(x).closest('tr').find('#desg_id').val();
	 //alert(value);
	 var div_data=null;
	 var arr=null;
	 var beanName="RetailDesignViewBeanDtl";
	  var valColumn=["active","barcode","co_id"];
	  var valValue=["Y",value,co_id];
	  var getData={beanName:beanName,valColumn:valColumn,valValue:valValue};
	  var params=JSON.stringify(getData);
	
	  //var text = $(this).closest('tr').find('.browser-default').get(3).attr('id');
	
	  var selectedCol="rate,rt_type";
	
	  
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
				 $.each(data,function(i,data){
					 val= data[cols[0]];
					 show= data[cols[1]];
					// alert(val + 'the data is '+show);
				            div_data="<option value='"+val+"'>"+show+"</option>"+","+div_data;
				          // alert(div_data);
				           // $(div_data).appendTo(p); 
				            });
				 //   $(p).material_select();
				  arr=div_data.split(",");
				  //alert("arr:-"+arr.length);
				  $(x).closest('tr').find('#rate').find('option').remove();
				  $('<option value="0">---select Option---</option>').appendTo($(x).closest('tr').find('#rate'));
				  
	  for( k=0;k<arr.length-1;k++)
		  {//alert("ARR IS:-"+arr[k]+"x is:-"+x.value);
		  $(arr[k]).appendTo($(x).closest('tr').find('#rate'));
		// $(x).closest('tr').find('#rate').appendChild(arr[k]);
		  }
	 	
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
	var m=$('#addRowCount').val();
	//alert(m);
	if(parseInt(m)<=10)
		{
	 var x=$("#addRowValue").html();
	// $('.x').material_select('destroy');
	//$("#TableId").find("tr").last().after(x);
	$(x).insertBefore("#insertBefore");
	$('#addRowCount').val(parseInt(m)+1);
		}
	// $('.x').material_select();
	 
}
function fetchItemTypeAndItemFromDesign(x,co_id,type)
{
//
	var des_no=$(x).closest('tr').find('#barcode').val();
	  $.get('../../ajax/getItemAndItemTypeFromDesign_sales.jsp',{des_no:des_no,co_id:co_id,type:type}, function (response) {
     	//alert(response.trim());
		  var m=JSON.parse(response.trim());
		 // alert(x);
		  var item_type_id=m.itm_typ_id;
		  var item=m.itm_typ_nm;
		  var item_nm=m.itm_nm;
		  var item_id=m.itm_id;
		  var gst=m.gst_per;
		  var desg_no=m.desg_no;
		  var rate=m.rate;
		  var hsn_cd=m.hsn_cd;
		  var stk=m.cl_bal;
		 // alert("itm_typ_id-"+item_type_id);
		  if(desg_no=="" || desg_no ==null)
				 
			 {
			 alert("This Item Does Not Have Sale Rate Value for this Company");
			 }
			 else{ 
		  var pp='<option value='+item_type_id+'>'+item+'</option>';
		  var mm='<option value='+item_id+'>'+item_nm+'</option>';
		 
		 // alert(pp);item_id
		  $(x).closest('tr').find('#hsn_cd').val(hsn_cd); 
		 $(x).closest('tr').find('#item_typ_id').find('option').remove();
		 $(pp).appendTo($(x).closest('tr').find('#item_typ_id'));
		 $(x).closest('tr').find('#item_id').find('option').remove();
		 $(mm).appendTo($(x).closest('tr').find('#item_id'));
		
		 $(x).closest('tr').find('#gst_per').val(parseFloat(gst));
		 $(x).closest('tr').find('#desg_id').val(desg_no);
		 $(x).closest('tr').find('#stk').val(stk);
		 $(x).closest('tr').find('#rate').val(rate);
		 $(x).closest('tr').find('#qty').focus(); 
		 afterRateChange(x);
			 }
//           x=parseInt(x)+1;
//           document.getElementById("flag_incr").value=x;
		  $('.cleanData').focus();
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
		
	  $.get('../../ajax/getItemAndItemTypeForDesign_sales.jsp',{des_no:des_no,co_id:co_id,type:type}, function (response) {
     	//alert(response.trim());
		  var m=JSON.parse(response.trim());
		 // alert(x);
		  var item_type_id=m.itm_typ_id;
		  var item=m.itm_typ_nm;
		  var item_nm=m.itm_nm;
		  var item_id=m.itm_id;
		  var gst=m.gst_per;
		  var desg_no=m.desg_no;
		  var rate=m.rate;
		  var hsn_cd=m.hsn_cd;
		  var stk=m.cl_bal;
		  var barcode=m.bar_code;
		 // alert("itm_typ_id-"+item_type_id);
		  if(desg_no=="" || desg_no ==null)
				 
			 {
			 alert("This Item Does Not Have Sale Rate Value for this Company");
			 }
			 else{ 
		  var pp='<option value='+item_type_id+'>'+item+'</option>';
		  var mm='<option value='+item_id+'>'+item_nm+'</option>';
		 
		 // alert(pp);item_id
		  $(x).closest('tr').find('#hsn_cd').val(hsn_cd); 
		 $(x).closest('tr').find('#item_typ_id').find('option').remove();
		 $(pp).appendTo($(x).closest('tr').find('#item_typ_id'));
		 $(x).closest('tr').find('#item_id').find('option').remove();
		 $(mm).appendTo($(x).closest('tr').find('#item_id'));
		 $(x).closest('tr').find('#barcode').val(barcode);
		 $(x).closest('tr').find('#gst_per').val(parseFloat(gst));
		 $(x).closest('tr').find('#desg_id').val(desg_no);
		 $(x).closest('tr').find('#stk').val(stk);
		 $(x).closest('tr').find('#rate').val(rate);
		 $(x).closest('tr').find('#qty').focus(); 
		 afterRateChange(x);
			 }
//           x=parseInt(x)+1;
//           document.getElementById("flag_incr").value=x;
		  $('.cleanData').focus();
		  addNewRow();
		
      });
	
		}
	 
}

function fetchItemTypeAndItemForKarigarh(x,co_id,type)
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
		
	  $.get('../../ajax/getItemAndItemTypeForDesign_sales.jsp',{des_no:des_no,co_id:co_id,type:type}, function (response) {
     	//alert(response.trim());
		  var m=JSON.parse(response.trim());
		 // alert(x);
		  var item_type_id=m.itm_typ_id;
		  var item=m.itm_typ_nm;
		  var item_nm=m.itm_nm;
		  var item_id=m.itm_id;
		 // var gst=m.gst_per;
		  var desg_no=m.desg_no;
		  var rate=m.rate;
		 // var hsn_cd=m.hsn_cd;
		  var stk=m.cl_bal;
		  var barcode=m.bar_code;
		 // alert("itm_typ_id-"+item_type_id);
		  if(desg_no=="" || desg_no ==null)
				 
			 {
			 alert("This Item Does Not Have Sale Rate Value for this Company");
			 }
			 else{ 
		  var pp='<option value='+item_type_id+'>'+item+'</option>';
		  var mm='<option value='+item_id+'>'+item_nm+'</option>';
		 
		 // alert(pp);item_id
		 // $(x).closest('tr').find('#hsn_cd').val(hsn_cd); 
		 $(x).closest('tr').find('#item_typ_id').find('option').remove();
		 $(pp).appendTo($(x).closest('tr').find('#item_typ_id'));
		 $(x).closest('tr').find('#item_id').find('option').remove();
		 $(mm).appendTo($(x).closest('tr').find('#item_id'));
		 $(x).closest('tr').find('#barcode').val(barcode);
		// $(x).closest('tr').find('#gst_per').val(parseFloat(gst));
		 $(x).closest('tr').find('#desg_id').val(desg_no);
		 $(x).closest('tr').find('#stk').val(stk);
		 $(x).closest('tr').find('#rate').val(rate);
		 $(x).closest('tr').find('#qty').focus(); 
		// afterRateChange(x);
			 }
//           x=parseInt(x)+1;
//           document.getElementById("flag_incr").value=x;
		  $('.cleanData').focus();
		  addNewRow();
		
      });
	
		}
	 
}
function afterRateChange(x)
{//afterRateChangeKarigarh
	var qty=$(x).closest('tr').find('#qty').val();
	var rate=$(x).closest('tr').find('#rate').val(); 
	var stk=$(x).closest('tr').find('#stk').val(); 
	var desg=$(x).closest('tr').find('#desg_id').val(); 
	var item_types=$(x).closest('tr').find('#item_typ_id').val();
	var items=$(x).closest('tr').find('#item_id').val();
	if(desg=='MISC'){
		 $.get('../../ajax/getGSTFromRMitem.jsp',{type:item_types,item:items,rate:rate}, function (response) {
			 
			 var m=JSON.parse(response.trim());
			 // alert(x);
			  var gst=m.gst_per; 
			  $(x).closest('tr').find('#gst_per').val(gst);
			  $(x).closest('tr').find('#barcode').val(m.bar_code);
			  
			  
			 if(parseInt(qty)<=parseInt(stk)){
					
					var basic=parseFloat(qty)*parseFloat(rate);
					var dis_per=$(x).closest('tr').find('#dis_per').val();
					var eff_dis=$(x).closest('tr').find('#dis_amt').val();
					
					$(x).closest('tr').find('#basic').val(Math.round(basic,2));
					var dis_amt=0.00;
					if(parseFloat(dis_per)==parseFloat(0.00) && parseFloat(eff_dis)!=parseFloat(0.00))
						{  //alert("in if"+dis_per+"--"+eff_dis);
						dis_amt=eff_dis;
						var per=parseFloat(eff_dis/rate)*100;
						//$(x).closest('tr').find('#dis_per').val(per);
						$(x).closest('tr').find('#dis_amt').val(Math.round(dis_amt,2));
						}
					else
						{   //alert("in else"+dis_per+"--"+eff_dis);
						dis_amt=parseInt(qty)*parseFloat(rate)*(parseFloat(dis_per)*0.01);
						$(x).closest('tr').find('#dis_amt').val(Math.round(dis_amt,2));
						
						}
					
//					if($("#inlineFormCheckMD"). prop("checked")==true)
//						{//alert("hi");D/0001
					
//						var gst_per=$(x).closest('tr').find('#gst_per').val();
//						//var	gst_amt=$(x).closest('tr').find('#gst_amt').val();
//						var	gst_amt=parseInt(qty)*parseFloat(rate)*(parseFloat(gst_per)*0.01);
//						$(x).closest('tr').find('#cgst_amt').val(Math.round(0.00,2));
//						$(x).closest('tr').find('#sgst_amt').val(Math.round(0.00,2));
//						//$(x).closest('tr').find('#igst_amt').val(Math.round(gst_amt,2));
//						}else{ //alert("hello");
					var cal_amt=parseInt(qty)*parseFloat(rate)-parseFloat(dis_amt);

							var gst_per=$(x).closest('tr').find('#gst_per').val();
									
							//var	gst_amt=cal_amt*(parseFloat(gst_per/2)*0.01);
							var gst_amt=parseFloat((parseFloat(cal_amt)/(parseFloat(gst_per)+100))*parseFloat(gst_per)/2);
							$(x).closest('tr').find('#cgst_amt').val(Math.round(gst_amt,2));
							$(x).closest('tr').find('#sgst_amt').val(Math.round(gst_amt,2));
							//$(x).closest('tr').find('#igst_amt').val(Math.round(0.00,2));
							$(x).closest('tr').find('#basic').val(Math.round((parseFloat(cal_amt)-parseFloat(gst_amt*2)),2));
					//	}
					var cgst=$(x).closest('tr').find('#cgst_amt').val();
					var sgst=$(x).closest('tr').find('#sgst_amt').val();
					//var igst=$(x).closest('tr').find('#igst_amt').val();
//					var amt=parseInt(qty)*parseFloat(rate)-parseFloat(dis_amt)+parseFloat(cgst)+parseFloat(sgst);//+parseFloat(igst); before
					// $(x).closest('tr').find('#amt').val(parseFloat(Math.round(amt,2))); before
					$(x).closest('tr').find('#amt').val(parseFloat(Math.round(cal_amt,2)));

					afterDisAmtChange();
					//netAmount();
					getFinalValues();
					
					}else
						{$(x).closest('tr').find('.cleanData').val('0');
						$(x).closest('tr').find('#qty').val('0');
						alert("Quantity Must Be less than Stock ");
						
						}	  
		  });
			
		
		
		
		
	}else{
	//alert(qty+stk);
	if(parseInt(qty)<=parseInt(stk)){
		
	var basic=parseFloat(qty)*parseFloat(rate);
	var dis_per=$(x).closest('tr').find('#dis_per').val();
	var eff_dis=$(x).closest('tr').find('#dis_amt').val();
	
	$(x).closest('tr').find('#basic').val(Math.round(basic,2));
	var dis_amt=0.00;
	if(parseFloat(dis_per)==parseFloat(0.00) && parseFloat(eff_dis)!=parseFloat(0.00))
		{  //alert("in if"+dis_per+"--"+eff_dis);
		dis_amt=eff_dis;
		var per=parseFloat(eff_dis/rate)*100;
		//$(x).closest('tr').find('#dis_per').val(per);
		$(x).closest('tr').find('#dis_amt').val(Math.round(dis_amt,2));
		}
	else
		{   //alert("in else"+dis_per+"--"+eff_dis);
		dis_amt=parseInt(qty)*parseFloat(rate)*(parseFloat(dis_per)*0.01);
		$(x).closest('tr').find('#dis_amt').val(Math.round(dis_amt,2));
		
		}
	
//	if($("#inlineFormCheckMD"). prop("checked")==true)
//		{//alert("hi");D/0001
	
//		var gst_per=$(x).closest('tr').find('#gst_per').val();
//		//var	gst_amt=$(x).closest('tr').find('#gst_amt').val();
//		var	gst_amt=parseInt(qty)*parseFloat(rate)*(parseFloat(gst_per)*0.01);
//		$(x).closest('tr').find('#cgst_amt').val(Math.round(0.00,2));
//		$(x).closest('tr').find('#sgst_amt').val(Math.round(0.00,2));
//		//$(x).closest('tr').find('#igst_amt').val(Math.round(gst_amt,2));
//		}else{ //alert("hello");
	var cal_amt=parseInt(qty)*parseFloat(rate)-parseFloat(dis_amt);

			var gst_per=$(x).closest('tr').find('#gst_per').val();
					
			//var	gst_amt=cal_amt*(parseFloat(gst_per/2)*0.01);
			var gst_amt=parseFloat((parseFloat(cal_amt)/(parseFloat(gst_per)+100))*parseFloat(gst_per)/2);
			$(x).closest('tr').find('#cgst_amt').val(Math.round(gst_amt,2));
			$(x).closest('tr').find('#sgst_amt').val(Math.round(gst_amt,2));
			//$(x).closest('tr').find('#igst_amt').val(Math.round(0.00,2));
			$(x).closest('tr').find('#basic').val(Math.round((parseFloat(cal_amt)-parseFloat(gst_amt*2)),2));
	//	}
	var cgst=$(x).closest('tr').find('#cgst_amt').val();
	var sgst=$(x).closest('tr').find('#sgst_amt').val();
	//var igst=$(x).closest('tr').find('#igst_amt').val();
//	var amt=parseInt(qty)*parseFloat(rate)-parseFloat(dis_amt)+parseFloat(cgst)+parseFloat(sgst);//+parseFloat(igst); before
	// $(x).closest('tr').find('#amt').val(parseFloat(Math.round(amt,2))); before
	$(x).closest('tr').find('#amt').val(parseFloat(Math.round(cal_amt,2)));

	afterDisAmtChange();
	//netAmount();
	getFinalValues();
	
	}else
		{$(x).closest('tr').find('.cleanData').val('0');
		$(x).closest('tr').find('#qty').val('0');
		alert("Quantity Must Be less than Stock ");
		
		}
	
	}
}

function afterRateChangeKarigarh(x)
{
	var qty=$(x).closest('tr').find('#qty').val();
	var rate=$(x).closest('tr').find('#rate').val(); 
	//var stk=$(x).closest('tr').find('#stk').val(); 
	var desg=$(x).closest('tr').find('#desg_id').val(); 
	var item_types=$(x).closest('tr').find('#item_typ_id').val();
	var items=$(x).closest('tr').find('#item_id').val();
	if(desg=='MISC'){
		 $.get('../../ajax/getGSTFromRMitem.jsp',{type:item_types,item:items,rate:rate}, function (response) {
			 
			 var m=JSON.parse(response.trim());
			 // alert(x);
			  var gst=m.gst_per; 
			  $(x).closest('tr').find('#gst_per').val(gst);
			  $(x).closest('tr').find('#barcode').val(m.bar_code);
			  
			  
			
					
					var basic=parseFloat(qty)*parseFloat(rate);
					var dis_per=$(x).closest('tr').find('#dis_per').val();
					var eff_dis=$(x).closest('tr').find('#dis_amt').val();
					
					$(x).closest('tr').find('#basic').val(Math.round(basic,2));
					var dis_amt=0.00;
					if(parseFloat(dis_per)==parseFloat(0.00) && parseFloat(eff_dis)!=parseFloat(0.00))
						{  //alert("in if"+dis_per+"--"+eff_dis);
						dis_amt=eff_dis;
						var per=parseFloat(eff_dis/rate)*100;
						//$(x).closest('tr').find('#dis_per').val(per);
						$(x).closest('tr').find('#dis_amt').val(Math.round(dis_amt,2));
						}
					else
						{   //alert("in else"+dis_per+"--"+eff_dis);
						dis_amt=parseInt(qty)*parseFloat(rate)*(parseFloat(dis_per)*0.01);
						$(x).closest('tr').find('#dis_amt').val(Math.round(dis_amt,2));
						
						}
					
//					if($("#inlineFormCheckMD"). prop("checked")==true)
//						{//alert("hi");D/0001
					
//						var gst_per=$(x).closest('tr').find('#gst_per').val();
//						//var	gst_amt=$(x).closest('tr').find('#gst_amt').val();
//						var	gst_amt=parseInt(qty)*parseFloat(rate)*(parseFloat(gst_per)*0.01);
//						$(x).closest('tr').find('#cgst_amt').val(Math.round(0.00,2));
//						$(x).closest('tr').find('#sgst_amt').val(Math.round(0.00,2));
//						//$(x).closest('tr').find('#igst_amt').val(Math.round(gst_amt,2));
//						}else{ //alert("hello");
					var cal_amt=parseInt(qty)*parseFloat(rate)-parseFloat(dis_amt);

							var gst_per=$(x).closest('tr').find('#gst_per').val();
									
							//var	gst_amt=cal_amt*(parseFloat(gst_per/2)*0.01);
							var gst_amt=parseFloat((parseFloat(cal_amt)/(parseFloat(gst_per)+100))*parseFloat(gst_per)/2);
							$(x).closest('tr').find('#cgst_amt').val(Math.round(gst_amt,2));
							$(x).closest('tr').find('#sgst_amt').val(Math.round(gst_amt,2));
							//$(x).closest('tr').find('#igst_amt').val(Math.round(0.00,2));
							$(x).closest('tr').find('#basic').val(Math.round((parseFloat(cal_amt)-parseFloat(gst_amt*2)),2));
					//	}
					var cgst=$(x).closest('tr').find('#cgst_amt').val();
					var sgst=$(x).closest('tr').find('#sgst_amt').val();
					//var igst=$(x).closest('tr').find('#igst_amt').val();
//					var amt=parseInt(qty)*parseFloat(rate)-parseFloat(dis_amt)+parseFloat(cgst)+parseFloat(sgst);//+parseFloat(igst); before
					// $(x).closest('tr').find('#amt').val(parseFloat(Math.round(amt,2))); before
					$(x).closest('tr').find('#amt').val(parseFloat(Math.round(cal_amt,2)));

					afterDisAmtChange();
					//netAmount();
					getFinalValues();
					
						  
		  });
			
		
		
		
		
	}else{
	//alert(qty);
	
		
	var basic=parseFloat(qty)*parseFloat(rate);
	
	
//	if($("#inlineFormCheckMD"). prop("checked")==true)
//		{//alert("hi");D/0001
	
//		var gst_per=$(x).closest('tr').find('#gst_per').val();
//		//var	gst_amt=$(x).closest('tr').find('#gst_amt').val();
//		var	gst_amt=parseInt(qty)*parseFloat(rate)*(parseFloat(gst_per)*0.01);
//		$(x).closest('tr').find('#cgst_amt').val(Math.round(0.00,2));
//		$(x).closest('tr').find('#sgst_amt').val(Math.round(0.00,2));
//		//$(x).closest('tr').find('#igst_amt').val(Math.round(gst_amt,2));
//		}else{ //alert("hello");
	
	//var igst=$(x).closest('tr').find('#igst_amt').val();
//	var amt=parseInt(qty)*parseFloat(rate)-parseFloat(dis_amt)+parseFloat(cgst)+parseFloat(sgst);//+parseFloat(igst); before
	// $(x).closest('tr').find('#amt').val(parseFloat(Math.round(amt,2))); before
	$(x).closest('tr').find('#amt').val(parseFloat(Math.round(basic,2)));

	afterDisAmtChange();
	//netAmount();
	getFinalValues();
	
	
	
	}
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
  
   


function afterDisAmtChange()
{
//alert("hi");
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
//	$(".igstClass").each(function() {
//		 var x=$(this).val();
//		 sum5=parseFloat(sum5)+parseFloat(x);
//		});
	$('#tot_bas_amt').val(sum3);
	$('#tot_dis_amt').val(sum);
	$('#tot_cgst_amt').val(sum1);
	$('#tot_amt').val(sum2);
	$('#tot_sgst_amt').val(sum4);
	//$('#tot_igst_amt').val(sum5);
	
	}
function afterDisAmtChangeForDel()
{
//alert("hi");
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
//	$(".igstClass").each(function() {
//		 var x=$(this).val();
//		 sum5=parseFloat(sum5)+parseFloat(x);
//		});
	$('#tot_bas_amt').val(sum3);
	$('#tot_dis_amt').val(sum);
	$('#tot_cgst_amt').val(sum1);
	$('#tot_amt').val(sum2);
	$('#tot_sgst_amt').val(sum4);
	//$('#tot_igst_amt').val(sum5);
	
	}
function netAmount()
{
	
var x=parseFloat($('#tot_amt').val());
$('#net_amt').val(x);
}
function afterPaidChange(x)
{
	var net_amt=$('#net_amt').val();
	var temp1=$('#pay_amt1').val() == '' ? 0.00 : $('#pay_amt1').val();
	var temp2=$('#pay_amt').val() == '' ? 0.00 : $('#pay_amt').val();
	var temp3=$('#adj_amt').val() == '' ? 0.00 : $('#adj_amt').val();
	var temp=parseFloat(net_amt)-(parseFloat(temp1)+parseFloat(temp2)+parseFloat(temp3));
	$('#bal_amt').val(temp);
}

function calculateMgst(val,x)
{//alert(val);
	  if($("#inlineFormCheckMD"). prop("checked")==true)
		  {
		  
		  var gst_per=$(x).closest('tr').find('#o_gst_per').val();
			//var	gst_amt=$(x).closest('tr').find('#gst_amt').val();
			var	gst_amt=parseInt(val)*(parseFloat(gst_per)*0.01);
			$(x).closest('tr').find('#o_cgst_amt').val(0.00);
			$(x).closest('tr').find('#o_sgst_amt').val(0.00);
			$(x).closest('tr').find('#o_igst_amt').val(gst_amt);
		  
		  }
	  else
		  {
		  
		  var gst_per=$(x).closest('tr').find('#o_gst_per').val();
		  var	gst_amt=parseInt(val)*(parseFloat(gst_per/2.0)*0.01);
			$(x).closest('tr').find('#o_cgst_amt').val((gst_amt));
			$(x).closest('tr').find('#o_sgst_amt').val(gst_amt);
			$(x).closest('tr').find('#o_igst_amt').val(0.00);
		  
		  
		  }
	 
	  var cgst=$(x).closest('tr').find('#o_cgst_amt').val();
		var sgst=$(x).closest('tr').find('#o_sgst_amt').val();
		var igst=$(x).closest('tr').find('#o_igst_amt').val();
	  var amt=parseFloat(val)+parseFloat(cgst)+parseFloat(sgst)+parseFloat(igst);
	  var m=$(x).closest('tr').find('#o_cal_typ').val();
	  if(m=='A'){
		  $(x).closest('tr').find('#o_amt').val(parseFloat(amt)); 
	  }else
		  {
		  $(x).closest('tr').find('#o_amt').val((parseFloat(amt))*(-1)); 
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
		$(x).insertBefore("#afterMisc");
}

function deleteRow(x)
{		var m=$('#addRowCount').val();
if(parseInt(m)>2){
	 $(x).parents('tr').detach();	
	 $('#addRowCount').val(parseInt(m)-1);
	 afterDisAmtChangeForDel();
		//netAmount();
		getFinalValues();
}else
	{
	alert("Further Rows cannot be deleted");
	}
}
