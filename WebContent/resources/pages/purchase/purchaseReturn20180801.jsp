<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>Puchase Return Page....</title>

<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->


<script src="../../../resources/js/jquery-1.11.0.js"></script>
<script src="../../../resources/js/purchase.js"></script>
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
        function checkDOB(param) {
            var dateString = param;
            var myDate = new Date(dateString);
            var today = new Date();
            if ( myDate > today ) { 
                alert('You cannot enter future date!!!...');
                $('#pur_dt').val("");
                $('#inv_dt').val("");
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

<script>
var bean1="PartyViewBean";
var valcol1=["active","party_typ"];
var valv1=["Y","SC"];
var getDatas1={beanName:bean1,valColumn:valcol1,valValue:valv1};
var params11=JSON.stringify(getDatas1);
var p1="party_cd";
var selectedCol11="party_id,party_nm";
CallDropDownService(params11,p1,selectedCol11);
</script>

<script type="text/javascript">
	$(function() {
		$('#form1').submit(function(event) 
				{event.preventDefault();
							var x = $('#form1').serializeJSON();
							var val = JSON.stringify(x);
							//alert(val);

							$
									.ajax({

										beforeSend : function(xhrObj) {
											xhrObj.setRequestHeader(
													"Content-Type",
													"application/json");
											xhrObj.setRequestHeader("Accept",
													"application/json");
										},
										type : "POST",
										url : "../../../purchaseReturnEntry",

										data : val,
										dataType : 'json',

										success : function(data, textStatus) {
											//alert(data);
											var fin_data = "";
											// 				for (var i = 0; i < data.length; i++) {
											// 					fin_data= data[i].user_id + data[i].user_pw;
											// 				}
											if (data=="" || data==null) {
												alert("====Sorry!! The Data has not been saved====");
												location.reload();
												
												//window.location
												//		.replace("http://localhost:8081/SpringTest/home.jsp");
											} else {
												// alert("====Unauthorised Login====");	
													alert("The Data Has Been Saved Suceessfully with Memo No:-"+data);
												location.reload();
											}
										},
										error : function(xhr, textStatus,
												errorThrown) {
											 alert("====Your Data Was Not Saved====");
											 location.reload();

										}
									});

						});
	});
</script>

<script type="text/javascript">
	$(function() {
		$('#form2').submit(function(event) 
				{event.preventDefault();
							var x = $('#form2').serializeJSON();
							var val = JSON.stringify(x);
							//alert(val);

							$
									.ajax({

										beforeSend : function(xhrObj) {
											xhrObj.setRequestHeader(
													"Content-Type",
													"application/json");
											xhrObj.setRequestHeader("Accept",
													"application/json");
										},
										type : "POST",
										url : "../../../purchaseReturnEntry",

										data : val,
										dataType : 'json',

										success : function(data, textStatus) {
											//alert(data);
											var fin_data = "";
											// 				for (var i = 0; i < data.length; i++) {
											// 					fin_data= data[i].user_id + data[i].user_pw;
											// 				}
											if (data=="" || data==null) {
												alert("====Sorry!! The Data has not been saved====");
												location.reload();
												
												//window.location
												//		.replace("http://localhost:8081/SpringTest/home.jsp");
											} else {
												// alert("====Unauthorised Login====");	
													alert("The Data Has Been Saved Suceessfully with Memo No:-"+data);
												location.reload();
											}
										},
										error : function(xhr, textStatus,
												errorThrown) {
											 alert("====Your Data Was Not Saved====");
											 location.reload();

										}
									});

						});
	});
</script>


<script type="text/javascript">
	$(document).ready(function() {

		var bean = "PurchaseViewBean";
		var valcol = [ "active","vr_type","co_id"];
		var valv = [ "Y","PURC",$('#company_id').val()];
		var getDatas = {
			beanName : bean,
			valColumn : valcol,
			valValue : valv
		};
		var params = JSON.stringify(getDatas);
		var p = "pur_no";
		var selectedCol = "pur_no,pur_no";
		CallDropDownService(params, p, selectedCol);

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
  
   

 
  
var bean1="RetailTempBean";
var valcol1=["active"];
var valv1=["Y"];
var getDatas1={beanName:bean1,valColumn:valcol1,valValue:valv1};
var params11=JSON.stringify(getDatas1);
var p1="desg_id";
var selectedCol11="tr_id,desg_no";
CallDropDownService(params11,p1,selectedCol11);
 
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


});  

</script>


<script>
	function getPurchaseData(param) {
		if(param=='0')
			{
			$('#insertDiv').hide();
			$('#newDiv').show();
			}else{
		$.get("../../ajax/getPurchaseDetails.jsp", {pur_no : param}, function(data, status) {
			$('#insertDiv').html(data);
			getAutoFocus();
			$('#party_cd').material_select();
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
				<div class="card-header deep-orange lighten-1 white-text text-center z-depth-2">Purchase Return</div>
				<div class="card card-body">
					<table class="table table-hover">
						<tr>
							<th>Purchase Number: <select name="pur_no" id="pur_no"
								class="mdb-select  colorful-select dropdown-primary "
								onchange="getPurchaseData(this.value);">
									<option value='0'>---select Option---</option>
							</select>
							</th>
						</tr>
					</table>
					
					<div id="insertDiv" class="table-responsive" align="left"></div>
					</div>
					</form>
					 <%
                    MyConnection mycon=new MyConnection();
                   Connection newcon= mycon.getConnection("adm_retail");
                   String qry="SELECT uom_nm FROM mst_uom";
                   String db="adm_retail";
                   ResultSet rsnew = mycon.getResultSet(qry, db); 
                    %>

					<div id="newDiv" class="" align="left">
						<form id="form2" name="form_2" method="post">
						<div class="card card-body">
							<table class="table table-hover">
							<%
				//String memo_no=util.findFinalUpdatedId("PURC");
				String x[]=util.findFinalUpdatedId("PURR", coid,"PURC");
				String memo_no=x[0];
				String idp=x[1];
				System.out.println("idp is:-"+idp);
				session.setAttribute("idp",idp);
				
				%>
								<th> Date:</th>
								<td><input placeholder="Selected date" type="text"
									name="pur_dt" id="pur_dt" onchange="checkDateGreater(this.value);" class="form-control datepicker"
									value=""></td>
								<td>&nbsp;
								<th>Vendor:</th>
								<td><select name="party_cd" id="party_cd" class="mdb-select  colorful-select dropdown-primary ">
										<option value=''></option>
								</select>
								</td>
								</tr>

								<tr>
									<th>Invoice No :</th>

									<td><input type="text" name="inv_no" id="inv_no" class="form-control" value="" /></td>
									<td>&nbsp;
									<th>Invoice Date:</th>

									<td><input placeholder="Selected date" type="text" onchange="checkDateGreater(this.value);" name="inv_dt" id="inv_dt" class="form-control datepicker" value=""></td>
							<td style="display:none"><input type="text" name="vr_type" id="vr_type" style=" width: 100px" value='PURR' />
								</tr>

							</table>
							</div>
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
                  
                    <td><select name="desg_id[]" id="desg_id" class="browser-default" onchange="afterDesgChange(this,<%=coid%>);fetchItemTypeAndItemFromDesign(this,<%=coid%>);">
                        <option value='0'>---select Option---</option>           
                        </select>
                    <td><select name="item_typ_id[]" id="item_typ_id" class="browser-default" style=" width: 100px;">
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
                    <td><input type="text" name="nuom_id[]" id="<%=rsnew.getString("uom_nm")%>" onchange="putUomData(this.id,this,this.value,'<%=sid%>');" onchange="getGstValues(this);checkMinus(this.value,this);" style="width:70px;text-align:right;"/>
                    
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
                    <td><input type="text" name="gst_per[]" id="gst_per" style=" width: 100px;text-align:right;" value='0.00' onkeyup="getGstValues(this);getGstValues(this);checkMinus(this.value,this);"/>
                    <td><input type="text" name="cgst_amt[]" id="cgst_amt" readonly style=" width: 100px;text-align:right;" value='0.00' class="cgstClass" onkeyup="afterRateChange(this)"/>
                    <td><input type="text" name="sgst_amt[]" id="sgst_amt" readonly style=" width: 100px;text-align:right;" value='0.00' class="sgstClass" onkeyup="afterRateChange(this)"/>
                    <td><input type="text" name="igst_amt[]" id="igst_amt" readonly style=" width: 100px;text-align:right;" value='0.00' class="igstClass" onkeyup="afterRateChange(this)"/>
                    <td><input type="text" name="amt[]" id="amt" style=" width: 100px;text-align:right;" value='0.00' class="amtClass"/>
                     <input type="hidden" name="diffqty[]" id="diffqty" value="1" />
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
                    <td><input type="text" name="o_cgst_amt[]" readonly id="o_cgst_amt" style=" width: 100px; text-align:right" value='0.00' onkeyup="calculateAmount(this.value,this);afterRateChange(this);" class="ocgstClass" /></td>
                     <td><input type="text" name="o_sgst_amt[]" readonly id="o_sgst_amt" style=" width: 100px; text-align:right" value='0.00' onkeyup="calculateAmount(this.value,this);afterRateChange(this);" class="osgstClass" /></td>
                      <td><input type="text" name="o_igst_amt[]" readonly id="o_igst_amt" style=" width: 100px; text-align:right" value='0.00' onkeyup="calculateAmount(this.value,this);afterRateChange(this);" class="oigstClass" /></td>
                     <td><input type="text" name="o_amt[]" id="o_amt" readonly style=" width: 100px; text-align:right" value='0.00' class="oamtClass" /></td>
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
						</form>
					</div>
					
					
				</div>
			</div>
	
<div id="addRowValue" style="display:none;"></div>
	</main>
</body>
<%@include file="../common/footer.jsp"%>
</html>
