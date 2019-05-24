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
        <title>Carigarh Return page....</title>
        
            <script src="../../../resources/js/jquery-1.11.0.js"></script> 
        <%@include file="../common/include.jsp" %>
   <script src="../../../resources/js/cashSales.js"></script> 
<!--      <script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->
<!--   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
<!--   <script src="../../../resources/js/validation.js"></script>   -->
  
  
      

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
        function calqtydiff(param,x)
        {
       	 //alert('inside');
       	 //alert(param);		
       	 var sum1=0.00,sum2=0.00,sum3=0.00,sum4=0.00,sum5=0.00,sumqty=0.00,sum7=0.00,sum8=0.00,paramval=0.00,sumrqty=0.00,sumhqty=0.00;
       	 var qty1=$(x).closest('tr').find('#qty1').val();
       	 var qty=$(x).closest('tr').find('#qty').val();
       	 var value =  $('#val').val();
       	 if(parseInt(qty) < parseInt(qty1)){
       // alert(qty+"="+qty1);
       //	 alert("qty1==> "+qty1);
       	var amt=parseInt(qty1)-parseInt(param);
       	$('#diffqty').val(amt);
       	 var pqty=parseInt(qty1);
       	 var miscH=$('#miscH').val();
       	 var rs=((parseFloat(miscH) * parseFloat(param)) / parseFloat(qty1));
       	// alert(rs);
       	//paramval = parseFloat(paramval) + parseFloat(param);
       	
       	//alert(paramval);
       	
       	 $(".rqtyClass").each(function() {
       	 //var x=$(this).val();
       	 var z= $(this).val() == '' ? 0.00 : $(this).val();
       	 sumrqty=parseFloat(sumrqty)+parseFloat(z);
       	 
       	});
       	// alert("sumrqty "+sumrqty);
       	 
       	 $(".qtyClass").each(function() {
       		 //var x=$(this).val();
       		 var y= $(this).val() == '' ? 0.00 : $(this).val();
       		 sumqty=parseFloat(sumqty)+parseFloat(y);
       		 
       		});
       	// alert("sumqty "+sumqty);
       	
       	 $(".hqtyClass").each(function() {
       		 //var x=$(this).val();
       		 var z= $(this).val() == '' ? 0.00 : $(this).val();
       		 sumhqty=parseFloat(sumhqty)+parseFloat(z);
       		 
       		});
       	 
       	 
       	 $("input[name='miscHamt1[]']").each(function() {
       		 //var x=$(this).val();//miscHamt
       		 var x= $(this).val() == '' ? 0.00 : $(this).val();
       		 var q1=0.00;
       		// alert("sumqty "+sumqty);
       		 if(sumrqty > 0){
       			 q1=(parseFloat(x) * parseFloat(sumrqty))/parseFloat(sumqty);
       				//alert("the x:-"+x+" the param is:-"+sumrqty);
       		 }
       		 else
       			 {
       			 q1=(parseFloat(x) * parseFloat(sumqty))/parseFloat(sumhqty);
       				//alert("the x:-"+x+" the param is:-"+sumrqty);
       			 }
       		//alert(x);
       		//alert("q1 "+q1);
       		//$(this).val(q1);
       		$(this).closest('tr').find('#miscHamt').val(Math.round(q1)); 
       		
       		var o_gst_per=$(this).closest('tr').find('#o_gst_per').val();
       		var res= (parseFloat(q1) * parseFloat(o_gst_per))/100;
       		if(value=="true"){	
       		$(this).closest('tr').find('#o_cgst_amt').val(res/2);
       		$(this).closest('tr').find('#o_sgst_amt').val(res/2);
       		//alert("res " +res);
       		var tot_amt=parseFloat(q1) + parseFloat(res);
       		//alert("tot_amt"+tot_amt);
       		$(this).closest('tr').find('#o_amt').val(tot_amt);
       		}else
       			{
       			$(this).closest('tr').find('#o_igst_amt').val(parseFloat(res));
       			var tot_amt=parseFloat(q1) + parseFloat(res);
       			//alert("tot_amt"+tot_amt);
       			$(this).closest('tr').find('#o_amt').val(tot_amt);
       			}
       		});
       	 }
        
        } 
        </script>
        

<%-- <script type="text/javascript">


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
</script>--%>
<script type="text/javascript">

$(document).ready(function() {
   
   
   $('.datepicker').pickadate({
  	
  	  format: 'yyyy-mm-dd',
  	max: new Date()
  	});
  
  
	  
	
    
});


</script>
<script type="text/javascript">

function putUomData(id,x,paramval,sid)
{
	 $(x).closest('tr').find('#qty').val(paramval);
	 $(x).closest('tr').find('#uom_id').val(id);
	 var res = sid.split("-");
	 afterRateChangeKarigarh(x);
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

$(window).load(function() {
	var pxx=$('#cloneRow').clone();
	$('#addRowValue').html(pxx);
	  
	});
	
	
	
function EditThis(str)
{
	 //alert(str);
	 
	 $.get("../../ajax/getRcvdataforReturn.jsp" , {hid : str}, function(data , status){
		 alert(data);
		 $(".sexy").material_select();
		 $('#copyDiv').html(data);
			
			//getAutoFocus();
			$('#hid').focus();
		 
	 });
	 
	 
}
	
</script>

<script type="text/javascript">
	$(function() {
		$('#myForm').submit(function(event) {
			event.preventDefault();
				//alert("hahahah");
							var x = jQuery('#myForm').serializeJSON();//$('#myForm').serializeJSON();
						
							var val = JSON.stringify(x);
							//alert("my val is :-"+val);
								//var p=validation1();
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
										url : "../../../addReturnKarigarh",

										data : val,
										dataType : 'json',

										success : function(data, textStatus) {
										//	alert(data);
											
											
											if (data=="" || data==null) {
												alert("==Sorry!!Your Data has not been submited ==");
												 location.reload();
											} else {
												alert("Data Has Been Saved Suceessfully:-"+data);
												 location.reload();
												// alert("====Unauthorised Login====");	
												
											}
											
											
											
											//if (data=="" || data==null) {
												// alert("====Data was not Saved====");
												// location.reload();
												
												
											//} else {
											
											//	alert("Data Has Been Saved Suceessfully:-"+data);
												
											//}
										},
										error : function(xhr, textStatus,
												errorThrown) {
											//alert("error");
										
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
    pageSize: 5,

    deleteConfirm: "Do you really want to delete the client?",


    controller: {
        loadData: function(filter) {
            var d = $.Deferred();

            $.ajax({
            	   type: 'GET',
            	    url: "../../../fetchKarigarhReturn",
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
             {name:"hid" , css:"hide"},
        { name: "doc_no", type:"text",width:60,title: "Return No"},
        { name: "doc_dt", type: "text", width: 70 ,title : "Return Date"  },
        { name: "ref_no", type:"text",width:60,title: "Recvd. No"},
        { name: "ref_dt", type: "text", width: 70 ,title : "Recvd Date"  },
//         { name: "narration", type: "text", width: 50 ,title : "Narration"  },
        { name: "party_nm", type: "text", width: 70 ,title : "Karigarh Code"  },
//         { name: "desg_no", type: "text", width: 70 ,title : "Design No"  },
//         { name: "qty", type: "text", width: 70 ,title : "Quantity"  },
      
        { type: "control",itemTemplate: function(value, item) {
          	 var $result = jsGrid.fields.control.prototype.itemTemplate.apply(this, arguments);

            var $customEditButton = $("<p>").attr({class: "customGridEditbutton fa fa-caret-square-o-right"})
              .click(function(e) {
           	   e.preventDefault();
                //alert("ID: " + item.tr_hid);
                $.get('../../../resources/ajax/getReturnKarigarView.jsp', {hid: item.hid , id: item.id}, function (response)
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
  	

 <%-- <script type="text/javascript">
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
 </script> --%>
<script type="text/javascript">
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
    
    
    var bean7="PartyViewBean";
    var valcol7=["active","party_typ"];
    var valv7=["Y","SC"];
    var getDatas7={beanName:bean7,valColumn:valcol7,valValue:valv7};
    var params17=JSON.stringify(getDatas7);
    var p7="kar_cd";
    var selectedCol17="party_id,party_nm";
    CallDropDownService(params17,p7,selectedCol17);

</script>






    </head>
	
	
	
	
	
	
<!--     <body class="fixed-sn mdb-skin-custom" onload="fetchCashParty();"> -->
<body class="fixed-sn mdb-skin-custom">
<%@include file="../common/menu.jsp" %>

        
        <main>
         <center>


       <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2" style="width:100%;">Return To Karigarh</div>
         
          <ul class="nav nav-tabs nav-justified indigo" role="tablist">
    <li class="nav-item">
        <a class="nav-link active" data-toggle="tab" href="#panel5" role="tab"><i class="fa fa-plus"></i> Add Return Karigarh</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#panel6" role="tab"><i class="fa fa-edit"></i> View/Update Return Karigarh</a>
    </li>
   
</ul>
 <div class="tab-content">
                
                <div class="tab-pane fade in show active" id="panel5" role="tabpanel">
                 <form id="myForm" name="myForm" method="post">  
<!--        <div class="card-body table-responsive"> -->
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
                              Karigar:
                            </th>

                            <td>
                                 
                         <select name="kar_cd" id="kar_cd" class="browser-default" >
                         
                        </select>
                            </td>
				 <th>
                      Recvd. No:
                        </th>
                    <td><input type="text" name="doc_no" id="doc_no"   class="cleanData" onchange="EditThis" style="width:70px;text-align:right;"/>

                <th>
                     Recvd. Date:
                        </th>
                        <td colspan="1">
                          <input placeholder="Selected date" type="text" name="doc_dt" id="doc_dt" style=" width: 120px" value="" class="form-control datepicker">
                        	
                        
                        </td>
                       
                            <th>
                              Narration:
                            </th>

                            <td >
                           <input type="text" name="narration" id="narration" class="form-control"/>
                      
                                                
                            </td>
                            
                                                   
                        </tr>
                    </table>
                    
                   <br>
                    <div class="row justify-content-start border-warning" id="copyDiv">
                     
                     </div>
                    </div>
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

                    <th>Amount
                    </tr>
                    <tr id="cloneRow"> 
                  <td>
                  <input type="text" name="barcode1[]" id="barcode" style=" width: 100px" class="pivotElement" onchange="fetchItemTypeAndItemFromDesign(this,<%=coid %>,'C');  " />
                  </td>
                    <td>

<input type="text" name="desg_id1[]" id="desg_id" style=" width: 100px" class="desgClass" onchange="fetchItemTypeAndItemForKarigarh(this,<%=coid %>,'CR');  "  />
                    </td>
                    <td><select name="item_typ_id1[]" id="item_typ_id" class="browser-default" onchange="getItems(this,this.value)">
                        <option value='0'>-select-</option>           
                        </select></td>
                    <td><select name="item_id1[]" id="item_id" class="browser-default" onchange="getStockDetails(this,this.value,<%=coid %>)">
                        <option value='0'>-select-</option>           
                        </select></td>
                    
                    <td style=" width: 50px; display: none"><input type="text" name="qty1[]" id="qty"  value='0' />
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
                    <td><input type="text" name="nuom_id1[]" id="<%=rsnew.getString("uom_nm")%>" onkeyup="checkMinus(this.value,this);" onchange="putUomData(this.id,this,this.value,'<%=sid%>');" class="cleanData" style="width:70px;text-align:right;"/>
                    
                    <%    
                    	}
                    %>
                    <td style=" width: 50px; display: none">

                    <input type="text" name="uom_id1[]" id="uom_id" onkeyup="checkMinus(this.value,this);" style=" width: 50px; text-align:right; display: none">    
                    </td>
                    <td>
                        <input type="text" name="rate1[]" id="rate" style=" width: 100px;text-align:right;" onchange="afterRateChange(this);" />
                        </td>


                     <td><input type="text" name="amt1[]" id="amt" style=" width: 100px; text-align:right" value='0.00' class="amtClass" readonly/></td>

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

                   
                    <td><input type="text" name="tot_amt1[]" id="tot_amt" class=" border border-success"  style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                   
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
                    <th colspan="3">
                     
                    <th colspan="2">Net Amount: 

                    <td><input type="text" name="net_amt1[]" id="net_amt" class=" border-danger"  style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                    </tr>
                    
                      <tr>
                    <td colspan="7" align="center"> <input type="submit" class="btn btn-primary btn-sm" value="submit" />
                    </tr>
                    </table>
                  

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
                <h5 class="modal-title" id="exampleModalLabel">Update Return To Karigar..</h5>
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
       
    <div id="addRowValue" style=" display: none"></div>
         </main>
     <input type="hidden" id="addRowCount" value='2'/>   
    </body>
    <%@include file="../common/footer.jsp" %>
</html>
