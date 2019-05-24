<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
    
        <meta charset="utf-8">
        <title>Credit Sale Page....</title>
        
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
.juicy-peach-gradient {
    background-image: linear-gradient(to right, #ffecd2 0%, #fcb69f 100%);
}
}
</style>
<script type="text/javascript">

$(document).ready(function() {
	 var beans="OtherHeadsHdr";
	 var valcols=["active","hd_typ"];
	 var valvs=["Y","SA"];
	 var getDatass={beanName:beans,valColumn:valcols,valValue:valvs};
	 var params1s=JSON.stringify(getDatass);
	 var ps="miscH";
	 var selectedCol1s="oh_id,description";
	 CallDropDownService(params1s,ps,selectedCol1s);
});

</script>
<script>
	function getPackingSlipDetails(param,co_id) { 	
		var x=$('#flags').val();
		//alert(x);
		 $.get("../../ajax/getPackingSlipDetails.jsp",{slip_no:param,co_id:co_id,flag:x}, function(data, status){//alert(data);
			 if(data.trim()=="exist"){
				 alert("A bill already generated against this Packing Slip Number");
			 }else{
	       $('#insertDiv').html(data);
	       afterDisAmtChange();
	       $('#transp_id').material_select();
	       $('#consg_id').material_select();
	       $('#party_id').material_select();
	       $('#salesman').material_select();
	       $('#helper').material_select();
	       $('.datepicker').pickadate({
	    	   
	    	  	  format: 'yyyy-mm-dd',
	    	  	 max:new Date()
	    	  	});

			 } 
	    });
		

	}
	function getTheData(value){
	//alert(value);	
	$('#flags').val(value);
	}
</script>
 <script type="text/javascript">
function validation1()
{
     //alert("hiii");
  var trn_dt=document.getElementById("bill_dt");
 // var name=document.getElementById("party_id");

    errors=[];
   // Dropdown1(associate_typ,"Please Select");
   // Dropdown1(name,"Please Select an ");
    checkBlank(trn_dt,"Bill Date");

//     params=["pivotElement","#miscHamt","#rate"];
//     validationForDetail(params);

    return finalCheck();            
    
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
									url : "../../../addCrSale",
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
										if (data=="success") {
											alert("====Data Has Been Saved Suceessfully====");
											//$('#centralModalSuccess').modal();
											var x="<%=request.getContextPath()%>"+"/resources/pages/Sales/crReport.jsp?"+"input="+$('#bill_no').val()+"&input1="+$('#company_id').val();
											window.location.replace(x);
											
										} else {
											 alert("====Data was not Saved====");
											 location.reload();
											
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
    


    </head>
    <body class="fixed-sn mdb-skin-custom ">
<%@include file="../common/menu.jsp" %>

        
        <main>
        <form id="form1" name="form_1" method="post" >
 <div class="main-wrapper">
          <div class="container-fluid ">
     
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2"> Credit Sale</div>
       <div class="card card-body w-100 p-3">
                 <table class="table-hover" >
                 <tr><td colspan="7">
	<div class="form-check"> Select Type:
    <input class="form-check-input" name="vr_type" type="radio" id="radio100" value="CRSA" onclick="getTheData(this.value)" checked>
    <label class="form-check-label" for="radio100">Credit Sales</label>

    <input class="form-check-input" name="vr_type" type="radio" id="radio101" value="STKO"  onclick="getTheData(this.value)" >
    <label class="form-check-label" for="radio101">Stock Transfer</label>
</div>
<input type="hidden" id="flags" value="CRSA">
</td></tr>
                   <tr>
                    <th>
				Packing Slip No:
				</th>
				<%
				
			
				
				%>
				<td>
				 <input type="text" name="pck_sl_no" id="pck_sl_no" class="form-control" onkeyup="getPackingSlipDetails(this.value,<%=coid %>)"/>
				
				</td>
				
				</tr>
				                       
                    </table>
                    <div id="insertDiv">
				
				</div>
                    </div>
                    
                   
                 </div>
                
      
<!--        </div> -->
       <br>
                 
                     
    </div>        
       </form>
      
         </main>
         
    </body>
    <%@include file="../common/footer.jsp" %>
</html>
