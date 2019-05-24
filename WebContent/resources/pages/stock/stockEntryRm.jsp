<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Role Creation Page....</title>
<%@include file="../common/include.jsp" %>
<script src="../../../resources/js/validation.js"></script> 
 <script>
            function validation1()
            {
               // alert("hiii");
               var yr_cd = document.getElementById("yrcode");
                var item_type = document.getElementById("item_type_id");
                var uom = document.getElementById("u_id");
                var quantity = document.getElementById("op_bal");

                errors=[];
              	Dropdown13(yr_cd,"Please Select");
             	Dropdown14(item_type,"Please Select");
             	Dropdown15(uom,"Please Select");
                checkBlank(quantity,"Quantity");
                return finalCheck();
               
                
            }

        </script>

<style type="text/css">
.table-wrapper {
    display: block;
    max-height: 300px;
    overflow-y: auto;
    -ms-overflow-style: -ms-autohiding-scrollbar;
}
}
</style>

<!--  <style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style> -->

<script type="text/javascript">

jQuery(document).ready(function() {
 //function beginDropDownService() { 
	
 var bean="RetailCompanyMasterBean";
 var valcol=["active"];
 var valv=["Y"];
 var getDatas={beanName:bean,valColumn:valcol,valValue:valv};
 var params1=JSON.stringify(getDatas);
 var select_id="comp_id";
 var selectedCol1="co_id,co_nm";
 CallDropDownService(params1,select_id,selectedCol1);
 
 var bean1="YearCodeBean";
 var valcol1=["active"];
 var valv1=["Y"];
 var getDatas1={beanName:bean1,valColumn:valcol1,valValue:valv1};
 var params11=JSON.stringify(getDatas1);
 var select_id1="yrcode";
 var selectedCol11="yr_cd_id,yr_cd";
 CallDropDownService(params11,select_id1,selectedCol11);
 
 var bean2="UomMasterBean";
 var valcol2=["active"];
 var valv2=["Y"];
 var getDatas2={beanName:bean2,valColumn:valcol2,valValue:valv2};
 var params12=JSON.stringify(getDatas2);
 var select_id2="u_id";
 var selectedCol12="uom_id,uom_nm";
 CallDropDownService(params12,select_id2,selectedCol12);
 
 var bean3="RetailTempBean";
 var valcol3=["active"];
 var valv3=["Y"];
 var getDatas3={beanName:bean3,valColumn:valcol3,valValue:valv3};
 var params13=JSON.stringify(getDatas3);
 var select_id3="des_id";
 var selectedCol13="desg_no,desg_no";
 CallDropDownService(params13,select_id3,selectedCol13);

 var bean5="RetailTempBean";
 var valcol5=["active"];
 var valv5=["Y"];
 var getDatas5={beanName:bean5,valColumn:valcol5,valValue:valv5};
 var params15=JSON.stringify(getDatas5);
 var select_id5="desg_no_p";
 var selectedCol15="desg_no,desg_no";
 CallDropDownService(params15,select_id5,selectedCol15);





 var bean6="RetailCompanyMasterBean";
 var valcol6=["active"];
 var valv6=["Y"];
 var getDatas6={beanName:bean6,valColumn:valcol6,valValue:valv6};
 var params16=JSON.stringify(getDatas6);
 var select_id6="co_nm_p";
 var selectedCol16="co_id,co_nm";
 CallDropDownService(params16,select_id6,selectedCol16);
 
});
//}


</script>

<!-- <script type="text/javascript"> 
// //function fetch_grid(str){
// 	$(function() {
// 	$("#desg_no_p").change(function (e) {
//                 e.preventDefault();
// 	 desg_no=$('#desg_no_p').val();
// 	 co_id=$('#co_nm_p').val();
// 	jQuery.noConflict();
// 		$("#jsGrid").jsGrid({
//  width: "100%",
//  inserting: true,
//  filtering: true,
//  editing: true,
//  sorting: true,
//  paging: true,
//  autoload: true,
//  searching:true,

//  deleteConfirm: "Do you really want to delete the client?",

//  controller: {
//      loadData: function(filter) {
//          var d = $.Deferred();

//          $.ajax({
//          	   type: 'GET',
//          	    url: "../../../fetchAllStock?desg_no="+desg_no+"&co_id="+co_id, 
//          	   	data:null,
//          	    async: false,
//          	    contentType: "application/json",
//          	    dataType: 'json',
         	    
//          	    success: function(response) {
//          	    	//alert(reponse);
//          	    	//alert(JSON.stringify(response));
//          	    	d.resolve(JSON.parse(JSON.stringify(response)));
         	     
//          	    },
//          	    error: function(e) {
//          	       console.log(e.message);
//          	    }
//          	});

//          return d.promise();
//      }
//  },

//  fields: [
//      { name: "co_id", type: "text", width: 50, validate: "required",title : "Company" },
//      { name: "desg_no", type: "text", width: 50,title : "Design"  },
//      { name: "itm_typ_id", type: "text", width: 50,title : "Item Type"  },
//      { name: "item_id", type: "text", width: 50 ,title : "Item" },
//      { name: "cl_bal", type: "text", width: 50,title : "Closing Balance"  },
//      { name: "created_by", type: "text", width: 50,title : "Created By"  },
//      { name: "modified_by", type: "text", width: 50,title : "Company"  },
//      { name: "created_on", type: "text", width: 50,title : "Created On"  },
//      { name: "modified_on", type: "text", width: 50,title : "Modified On"  },
//      { type: "control" }
//  ]
// });
// 	 });
// 	 });
// //}

</script> -->


  <script type="text/javascript">
 
  $(function() {
		$('#form').submit(function(event) {
			event.preventDefault();
							var x = $('#form').serializeJSON();
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
										url : "../../../stockEntry",

										data : val,
										dataType : 'json',

										success : function(data, textStatus) {
											//alert(data);
											var fin_data = "";
											if (data=="success") {
											alert("====Your Data has been saved successfully====");
											 location.reload();
// 												window.location
// 														.replace("http://localhost:8081/SpringTest/home.jsp");
											} else {
												// alert("====Unauthorised Login====");	
												 alert("====Your Data Was Not Saved====");
											}
										},
										error : function(xhr, textStatus,
												errorThrown) {
											 alert("====Your Data Was Not Saved===="+textStatus);

										}
									});
										}

						});

  });
</script> 

<script>
 	function getData(param) { 		
  		 $.get("../../ajax/getItemFromType.jsp",{itm_typ_id:param}, function(data, status){  			
  	        $('#itm').html(data);
  	      $('#item_id').material_select();
  	   // $('#itm_typ_id').material_select();
  	    });
 		

 	}
 	function updateOpstock(str)
 	{
 	$('#op_stk').val(str);	
 	}
 </script>

   
     
    </head>
    <body class="fixed-sn mdb-skin-custom" > 
    <%@include file="../common/menu.jsp" %>
<main>
        <form id="form" name="form" method="post">

          <div class="card card-cascade wider" style="width: 100%;">
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2">Opening Stock For Rm</div>
       <div class="card-body">
      <table class="table">
<!--                    <tr> -->
<!--                     <th> -->
<!-- 				Select Outlets: -->
<!-- 				</th> -->
<!-- 				<td> -->
<!-- 				<select id="comp_id" name="co_id" class="mdb-select  colorful-select dropdown-primary ">		 -->
<!-- 				</select> -->
				
<!-- 				</td> -->
<!--                         </tr> -->
                        <tr>
                        <th>
                        Financial Year:
                        </th>
                        <td>
                        <select name="yr_cd" id="yrcode" class="mdb-select  colorful-select dropdown-primary ">
                        </select>
                        
                        </td>
                        
 						 <th>
                       Item Type:
                        </th>
                       
                        <td colspan="">
                          <select name="item_type_id" id="item_type_id" class=" browser-default" onchange="getData(this.value)">
                          <option value='0'>---select Option---</option>
                          <%
                          UtilityHelper u=new UtilityHelper();
                          String value=u.getDropdownStringForRMItemType("mst_itm_typ","itm_typ_id", "itm_typ_nm", "0");
                          out.println(value);
                          %>
                        
                        </select>
                        </td>

                        </tr>

                        <tr id="itm">    
                       </tr>
                       
                       <tr>
                        <th>
                        UOM:
                        </th>
                        <td>
                        <select name="uom_id" id="u_id" class="mdb-select  colorful-select dropdown-primary ">
                        </select>
                        
                        </td>
                       
                        <th>
                        Quantity:
                        </th>
                       <td>
                         <input type="text" name="op_bal" id="op_bal" style=" text-align: right" onkeyup="checkMinus(this.value);updateOpstock(this.value)"/>
                          <input type="hidden" name="op_stk" id="op_stk" style=" text-align: right" />
                          <input type="hidden" name="desg_no" id="desg_no" style=" text-align: right" value='MISC' />
                        </td>
                        </tr>
                        
                        
                         <tr>
                        <th>
                        Remarks:
                        </th>
                        <td>
                         <input type="text" name="rem" id="rem_id" />
                        </td>
                        </tr>
                    </table>
                 
           <table>
                     <tr>
                    <td> <input type="submit" class="btn btn-primary" value="submit" />
                    </tr>
                    </table>
        
                 </div>
       </div>
   <br />
        </form>
        </main>
    </body>
    <%@include file="../common/footer.jsp" %>    
</html>    