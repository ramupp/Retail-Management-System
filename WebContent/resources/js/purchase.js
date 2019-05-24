

function afterDesgChange(x,co_id)
{
	 var value=$(x).closest('tr').find('#desg_id').val();
	 //alert(value);
	 var div_data=null;
	 var arr=null;
	 var beanName="RetailDesignViewBeanDtl";
	  var valColumn=["active","desg_id","co_id"];
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
	  getGstValues(x);
	  afterRateChange(x);
	 //$(x).closest('tr').find('#rate').material_select();
	
			},
			error : function(xhr, textStatus, errorThrown) {

				alert("error");
				
			}
		});
	}

function addNewRow(x,param)
{
	//alert(param);
	//var a= $(x).closest('tr').find('#item_id').val();
	//var b= $(x).closest('tr').find('#item_typ_id').val();
	////var c= $(x).closest('tr').find('#desg_id').val();
	var d= $(x).closest('tr').find('#qty').val();
	//var e= $(x).closest('tr').find('#rate').val();
	var r= $(x).closest('tr').find('#rate1').val();
	//var f= $(x).closest('tr').find('#gst_per').val();
	//alert(r);
	if(d!='' && param!='' && r==''){
	var x1=$("#addRowValue").html();
	//alert(x1);
	// $('.x').material_select('destroy');
	//$("#TableId").find("tr").last().after(x);
	$(x1).insertBefore("#insertBefore");	
	$(x).closest('tr').find('#rate1').val(param);
	//alert("rate1==> "+$(x).closest('tr').find('#rate1').val());
	fetchDesignData();
	}
	 
}

function fetchItemTypeAndItemFromDesign(x,co_id)
{
	//alert('inside');
	var des_no=$(x).closest('tr').find('#desg_id').val();
	
	$.get('../../ajax/getDesignIdFromDesign.jsp',{des_no:des_no}, function (response) {		
		//int desg_id=response.trim();
		 $(x).closest('tr').find('#desg_id1').val(response.trim());
		// $(x).closest('tr').find('#desg_id').append(response); 
		 
	 });
	
	if(des_no=='MISC')
		{
		//alert("hi- "+des_no);
		 $.get('../../ajax/getItemTypeFromDesign.jsp',{des_no:des_no,co_id:co_id,type:'C'}, function (response) {		
			 $(x).closest('tr').find('#item_typ_id').find('option').remove();
			 $(x).closest('tr').find('#item_typ_id').append(response); 
			 
		 });
		}
	else
		{
	  $.get('../../ajax/getItemAndItemTypeFromDesign.jsp',{des_no:des_no,co_id:co_id}, function (response) {
      //	alert(response.trim());
		  var m=JSON.parse(response.trim());
		 // alert(x);
		  var item_type_id=m.itm_typ_id;
		  var item=m.itm_typ_nm;
		  var item_nm=m.itm_nm;
		  var item_id=m.itm_id;
		  var gst=m.gst_per;
		  var barcode=m.bar_code;
		  
		  //alert("barcode->"+barcode);
		  var pp='<option value='+item_type_id+'>'+item+'</option>';
		  var mm='<option value='+item_id+'>'+item_nm+'</option>';
		 // alert(pp);item_id
		 $(x).closest('tr').find('#item_typ_id').find('option').remove();
		 $(pp).appendTo($(x).closest('tr').find('#item_typ_id'));
		 $(x).closest('tr').find('#item_id').find('option').remove();
		 $(mm).appendTo($(x).closest('tr').find('#item_id'));
		 $(x).closest('tr').find('#bar_code').val(barcode);
		
		// $(x).closest('tr').find('#gst_per').val(parseFloat(gst));
//           x=parseInt(x)+1;
//           document.getElementById("flag_incr").value=x;
      });
	}


}
function fetchItemType(x,itm_typ_id)
{
	 $.get('../../ajax/getItemFromTypeRM.jsp',{itm_typ_id:itm_typ_id}, function (response) {
		 $(x).closest('tr').find('#item_id').find('option').remove();
		 $(x).closest('tr').find('#item_id').append(response); 
	      });
	
}


//function fetchItemTypeAndItemForDesign(x,co_id,type)
//{
////
//	var des_no=$(x).closest('tr').find('#desg_id').val();
//	
//	if(des_no=='MISC')
//		{
//		//alert("hi");
//		 $.get('../../ajax/getItemTypeFromDesign.jsp',{des_no:des_no,co_id:co_id,type:type}, function (response) {
//		//item_typ_id	
//			 $(x).closest('tr').find('#item_typ_id').find('option').remove();
//			 $(x).closest('tr').find('#item_typ_id').append(response); 
//			 
//		 });
//		 
//		
//		}
//	else
//		{
//		
//		 $.get('../../ajax/getItemAndItemTypeFromDesign.jsp',{des_no:des_no,co_id:co_id}, function (response) {
//		      //	alert(response.trim());
//				  var m=JSON.parse(response.trim());
//				 // alert(x);
//				  var item_type_id=m.itm_typ_id;
//				  var item=m.itm_typ_nm;
//				  var item_nm=m.itm_nm;
//				  var item_id=m.itm_id;
//				  var gst=m.gst_per;
//				  var barcode=m.bar_code;
//				  
//				  //alert("barcode->"+barcode);
//				  var pp='<option value='+item_type_id+'>'+item+'</option>';
//				  var mm='<option value='+item_id+'>'+item_nm+'</option>';
//				 // alert(pp);item_id
//				 $(x).closest('tr').find('#item_typ_id').find('option').remove();
//				 $(pp).appendTo($(x).closest('tr').find('#item_typ_id'));
//				 $(x).closest('tr').find('#item_id').find('option').remove();
//				 $(mm).appendTo($(x).closest('tr').find('#item_id'));
//				 $(x).closest('tr').find('#bar_code').val(barcode);
//				
//				// $(x).closest('tr').find('#gst_per').val(parseFloat(gst));
////		           x=parseInt(x)+1;
////		           document.getElementById("flag_incr").value=x;
//		      });
//		}
//	 
//}
//



function afterRateChangeReturn(x)
{
	var qty=$(x).closest('tr').find('#qty1').val();
	var rate=$(x).closest('tr').find('#rate').val(); 
	var qty1=$(x).closest('tr').find('#qty').val();
	//alert(1);
	var basic=parseFloat(qty1)*parseFloat(rate);
	var dis_per=$(x).closest('tr').find('#dis_per').val();
	$(x).closest('tr').find('#basic').val(Math.round(basic,2));
	var dis_amt=parseInt(qty1)*parseFloat(rate)*(parseFloat(dis_per)*0.01);
	$(x).closest('tr').find('#dis_amt').val(Math.round(dis_amt,2));
	//alert(2);
	var cal_amt=parseInt(qty1)*parseFloat(rate)-parseFloat(dis_amt);
	var gst_per=$(x).closest('tr').find('#gst_per').val();
	var cgst=$(x).closest('tr').find('#cgst_amt').val();
	//alert(" - "+cgst);
 	var sgst=$(x).closest('tr').find('#sgst_amt').val();
 	//alert(" - "+sgst);
	var igst=$(x).closest('tr').find('#igst_amt').val();
	///var	gst_amt=cal_amt*(parseFloat(gst_per/2)*0.01);
	 var gst_amt=cal_amt * (parseFloat(gst_per)*0.01);
		
		 if(igst=="0.00"){
			// alert("inside true");
			 
		 $(x).closest('tr').find('#cgst_amt').val(gst_amt/2); 
		 cgst=(parseFloat(gst_amt)/2);
		 $(x).closest('tr').find('#sgst_amt').val(gst_amt/2); 
		 sgst=(parseFloat(gst_amt)/2);
		 }
		 else
		{
			// alert("inside false");
			 $(x).closest('tr').find('#igst_amt').val(gst_amt); 
			 igst=parseFloat(gst_amt);
	     }
	//alert(3);
	//$(x).closest('tr').find('#cgst_amt').val(Math.round(gst_amt,2));
	//$(x).closest('tr').find('#sgst_amt').val(Math.round(gst_amt,2));
	//alert(4);
	
	var amt=(parseFloat(qty1) *parseFloat(rate))-parseFloat(dis_amt)+parseFloat(cgst)+parseFloat(sgst)+parseFloat(igst);
	//alert(amt);
	$(x).closest('tr').find('#amt').val(Math.round(parseFloat(amt),2));

	afterDisAmtChange();
	//netAmount();
	getFinalValues();
}
//function afterRateChange(x)
//{
//	
//	var qty=$(x).closest('tr').find('#qty').val();
//	var rate=$(x).closest('tr').find('#rate').val(); 
//	//alert(1);
//	var basic=parseFloat(qty)*parseFloat(rate);
//	var dis_per=$(x).closest('tr').find('#dis_per').val();
//	$(x).closest('tr').find('#basic').val(Math.round(basic,2));
//	var dis_amt=parseInt(qty)*parseFloat(rate)*(parseFloat(dis_per)*0.01);
//	$(x).closest('tr').find('#dis_amt').val(Math.round(dis_amt,2));
//	//alert(2);
//	var cal_amt=parseInt(qty)*parseFloat(rate)-parseFloat(dis_amt);
//	var gst_per=$(x).closest('tr').find('#gst_per').val();
//	var	gst_amt=cal_amt*(parseFloat(gst_per/2)*0.01);
//	//alert(3);
//	//$(x).closest('tr').find('#cgst_amt').val(Math.round(gst_amt,2));
//	//$(x).closest('tr').find('#sgst_amt').val(Math.round(gst_amt,2));
//	//alert(4);
//	var cgst=$(x).closest('tr').find('#cgst_amt').val();
//	//alert(" - "+cgst);
// 	var sgst=$(x).closest('tr').find('#sgst_amt').val();
// 	//alert(" - "+sgst);
//	var igst=$(x).closest('tr').find('#igst_amt').val();
//	//alert(" - "+igst);
//	var amt=parseInt(qty) *parseFloat(rate)-parseFloat(dis_amt)+parseFloat(cgst)+parseFloat(sgst)+parseFloat(igst);
//	//alert(amt);
//	$(x).closest('tr').find('#amt').val(parseFloat(Math.round(amt,2)));
//
//	afterDisAmtChange();
//	//netAmount();
//	getFinalValues();
//}

function afterRateChange(x)
{
	var qty=$(x).closest('tr').find('#qty').val();
	var rate=$(x).closest('tr').find('#rate').val(); 
	//alert("in rate change");
	var basic=parseFloat(qty)*parseFloat(rate);
	var dis_per=$(x).closest('tr').find('#dis_per').val();
	$(x).closest('tr').find('#basic').val(Math.round(basic,2));
	var dis_amt=parseInt(qty)*parseFloat(rate)*(parseFloat(dis_per)*0.01);
	$(x).closest('tr').find('#dis_amt').val(Math.round(dis_amt,2));
	
//	if($("#inlineFormCheckMD"). prop("checked")==true)
//		{//alert("hi");
//		var gst_per=$(x).closest('tr').find('#gst_per').val();
//		//var	gst_amt=$(x).closest('tr').find('#gst_amt').val();
//		var	gst_amt=parseInt(qty)*parseFloat(rate)*(parseFloat(gst_per)*0.01);
//		$(x).closest('tr').find('#cgst_amt').val(Math.round(0.00,2));
//		$(x).closest('tr').find('#sgst_amt').val(Math.round(0.00,2));
//		$(x).closest('tr').find('#igst_amt').val(Math.round(gst_amt,2));
//		}else{ //alert("hello");
//			var gst_per=$(x).closest('tr').find('#gst_per').val();
//			var	gst_amt=parseInt(qty)*parseFloat(rate)*(parseFloat(gst_per/2)*0.01);
//			$(x).closest('tr').find('#cgst_amt').val(Math.round(gst_amt,2));
//			$(x).closest('tr').find('#sgst_amt').val(Math.round(gst_amt,2));
//			$(x).closest('tr').find('#igst_amt').val(Math.round(0.00,2));
//		}
	var cgst=$(x).closest('tr').find('#cgst_amt').val();
	var sgst=$(x).closest('tr').find('#sgst_amt').val();
	var igst=$(x).closest('tr').find('#igst_amt').val();
	var amt=parseInt(qty)*parseFloat(rate)-parseFloat(dis_amt)+parseFloat(cgst)+parseFloat(sgst)+parseFloat(igst);
	//alert(amt);
	$(x).closest('tr').find('#amt').val(parseFloat(Math.round(amt,2)));

	afterDisAmtChange();
	//netAmount();
	getFinalValues();
}





function afterDisAmtChange()
{
//alert("i am here");
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
		// alert(x);
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
	$('#tot_bas_amt').val(sum3);
	$('#tot_dis_amt').val(sum);
	$('#tot_cgst_amt').val(sum1);
	$('#tot_amt').val(sum2);
	$('#tot_sgst_amt').val(sum4);
	$('#tot_igst_amt').val(sum5);
	
	}
function netAmount()
{
	
var x=parseFloat($('#tot_amt').val());
$('#net_amt').val(x);
}
function afterPaidChange(x)
{
	var net_amt=$('#net_amt').val();
	var temp=parseFloat(net_amt)-parseFloat(x);
	$('#bal_amt').val(temp);
}

//arnab

//function getFinalValues()
//{
//	//alert(param);
//	var sum1=0.00,sum2=0.00,sum3=0.00,sum4=0.00,sum5=0.00,sum6=0.00,sum7=0.00,sum8=0.00;
//	
//	$(".basClass").each(function() {
//		 //var x=$(this).val();//miscHamt
//		 var x= $(this).val() == '' ? 0.00 : $(this).val();
//		 
//		 sum1=parseFloat(sum1)+parseFloat(x);
//		 
//		});
//	//alert(sum1);
//	
//	$(".ocgstClass").each(function() {
//		 //var x=$(this).val();
//		 var x= $(this).val() == '' ? 0.00 : $(this).val();
//		 
//		 sum2=parseFloat(sum2)+parseFloat(x);
//		// alert(sum1);
//		});
//	$(".disClass").each(function() {
//		 //var x=$(this).val();
//		 var x= $(this).val() == '' ? 0.00 : $(this).val();
//		 
//		 sum6=parseFloat(sum6)+parseFloat(x);
//		// alert(sum1);
//		});
//	
//	$(".osgstClass").each(function() {
//		 //var x=$(this).val();
//		 var x= $(this).val() == '' ? 0.00 : $(this).val();
//		 
//		 sum3=parseFloat(sum3)+parseFloat(x);
//		// alert(sum1);
//		});
//	
//	$(".oigstClass").each(function() {
//		 //var x=$(this).val();
//		 var x= $(this).val() == '' ? 0.00 : $(this).val();
//		 
//		 sum4=parseFloat(sum4)+parseFloat(x);
//		// alert(sum1);
//		});
//	
//	$(".oamtClass").each(function() {
//		 //var x=$(this).val();
//		 var x= $(this).val() == '' ? 0.00 : $(this).val();
//		 
//		 sum5=parseFloat(sum5)+parseFloat(x);
//		// alert(sum1);
//		});
//	//alert(sum1+"-"+tot_dis_amt+"-"+sum2+"-"+sum3+"-"+sum4+"-"+sum5);
//	$('#finBasic').val(parseFloat(sum1));
//	$('#fin_dis_amt').val(parseFloat(sum6));
//	$('#fin_cgst_amt').val(parseFloat(sum2));
//	$('#fin_sgst_amt').val(parseFloat(sum3));
//	$('#fin_igst_amt').val(parseFloat(sum4));
//	$('#net_amt').val(parseFloat(sum5));
//	}
//	
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
	
	$('#finBasic').val(parseFloat(tot_bas_amt)+parseFloat(sum1));
	$('#fin_dis_amt').val(parseFloat(tot_dis_amt));
	$('#fin_cgst_amt').val(parseFloat(tot_cgst_amt)+parseFloat(sum2));
	$('#fin_sgst_amt').val(parseFloat(tot_sgst_amt)+parseFloat(sum3));
	$('#fin_igst_amt').val(parseFloat(tot_igst_amt)+parseFloat(sum4));
	$('#net_amt').val(parseFloat(tot_amt)+parseFloat(sum5));//,,,,,
	
	}
  
	
function calculateMgst(val,x)
{
	//alert(val+" val-x "+x);
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
	 // alert("amt "+amt);
	  var m=$(x).closest('tr').find('#o_cal_typ').val();
	 // alert("m "+m);
	  if(m=='A'){
		  $(x).closest('tr').find('#o_amt').val(parseFloat(amt)); 
	  }else
		  {
		  $(x).closest('tr').find('#o_amt').val((parseFloat(amt))*(-1)); 
		  }
		
		getFinalValues();
	  
}
function calculateAmount(value,y)
{
	//alert(value+'-'+y);
	var amt=$(y).closest('tr').find('#o_amt').val();
//alert(amt);
 var result = parseFloat(amt) + parseFloat(value);
//alert(result);
$(y).closest('tr').find('#o_amt').val(result);
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
			    	$(x).closest('tr').find('#nuom_id').val('');
			    	$(x).closest('tr').find('#qty').val('');
			    	$(x).closest('tr').find('#rate').val('');
			    }	
			}
		
	}
	
	
	
function fetchOtherHead(oh_id,id,x)

{

	
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
		 //$(x).closest('tr').find('#o_gst_per').val(parseFloat(gst_per)); 
		$(x).closest('tr').find('#o_cal_typ').val(cal_typ); 
		calculateMgst($(x).closest('tr').find('#miscHamt').val(),x); 
		 // alert(pp);item_id
		
		// $(x).closest('tr').find('#item_id').find('option').remove();
		 
		
		// $(x).closest('tr').find('#gst_per').val(parseFloat(gst));
//          x=parseInt(x)+1;
//          document.getElementById("flag_incr").value=x;
     });


}

function getGstValues(param)

{
	//alert(param);
	var y1=$('#party_cd').val();
	//alert("y"+y1);
	if(y1==0){
		alert('Please enter your vendor.....');
		//$('#party_cd').val='';
		$(param).closest('tr').find('#gst_per').val("0.00"); 
		$(param).closest('tr').find('#rate').val(''); 
		afterRateChange(param);
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
		 var gst_amt=amount * (parseFloat(gstper)*0.01);
		//alert(m);
		 if(m =="true"){
			// alert("inside true");
		 $(param).closest('tr').find('#cgst_amt').val(gst_amt/2); 
		 $(param).closest('tr').find('#sgst_amt').val(gst_amt/2); 
		 }
		 else
		{
			 //alert("inside false");
			 $(param).closest('tr').find('#igst_amt').val(gst_amt); 
	     }
		 $('#val').val(m);
		afterRateChange(param);
		 
     });
	  
	}
	


}


function getOtherGstValues(param)

{ var value =  $('#val').val();
var tot1=0.00,tot2=0.00;
var mbasic = $(param).closest('tr').find('#miscHamt').val(); 		
var mgstper=$(param).closest('tr').find('#o_gst_per').val(); 	
var mamt=$(param).closest('tr').find('#o_amt').val(); 
var mgst_amt=mbasic * (parseFloat(mgstper)*0.01);
//alert("value "+value);
	if(value=="true"){		
		
		 $(param).closest('tr').find('#o_cgst_amt').val(mgst_amt/2); 
		 $(param).closest('tr').find('#o_sgst_amt').val(mgst_amt/2); 
		// alert("mgst_amt "+mgst_amt);
		// alert("mamt "+mamt);
		 tot1=parseFloat( mgst_amt) + parseFloat(mbasic);
		// alert("tot1 "+tot1);
		 $(param).closest('tr').find('#o_amt').val(tot1); 
	
	}
	else
		{
		 $(param).closest('tr').find('#o_igst_amt').val(mgst_amt); 
		 $(param).closest('tr').find('#o_amt').val(mgst_amt); 
		// alert("mgst_amt "+mgst_amt);
		// alert("mamt "+mamt);
		 tot2=parseFloat(mgst_amt) + parseFloat(mbasic);
		// alert("tot2 "+tot2);
		 $(param).closest('tr').find('#o_amt').val(tot2); 
		}
	
	getFinalValues();
}


function putUomData(id,x,paramval,sid)
{
	 $(x).closest('tr').find('#qty').val(paramval);
	 $(x).closest('tr').find('#uom_id').val(id);
	 var res = sid.split("-");
	    for(var i=0;i<res.length;i++)
	    {
	    	if(id!=res[i]){
	    	//alert(res[i]);
	    	var y="#"+res[i];
	    	$(x).closest('tr').find(y).val("");
	    	}
	    }
	    
	    //afterRateChange(x);
	    getGstValues(x);
	   // checkMinus(paramval,x);
}



function addNewMiscRow(val,param)
{
	var x=$(param).closest('tr').find('#miscHamt').val(); 
	var a=$(param).closest('tr').find('#miscHamt1').val(); 
	 if(x!='' && a==''){ 
	  var x1=$("#cloneRow1").clone();
		// $('.x').material_select('destroy');
		//$("#TableId").find("tr").last().after(x);
	  $(x1).find('#miscHamt').val('');
		$(x1).find('#o_amt').val('0.00');
		$(x1).find('#o_gst_per').val('0.00');
		$(x1).find('#o_cgst_amt').val('0.00');
		$(x1).find('#o_sgst_amt').val('0.00');
		$(x1).find('#o_igst_amt').val('0.00');
		$(x1).find('#miscHamt1').val(a);
		$(x1).insertBefore("#afterMisc");
		
	 }
}

 
