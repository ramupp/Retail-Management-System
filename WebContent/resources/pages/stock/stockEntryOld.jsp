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

<style type="text/css">
.table-wrapper {
    display: block;
    max-height: 300px;
    overflow-y: auto;
    -ms-overflow-style: -ms-autohiding-scrollbar;
}
}
</style>

<style>
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
</style>

 <script type="text/javascript">


function beginDropDownService() {
	
	 var bean1="RetailCompanyMasterBean";
	 var valcol1=["active"];
	 var valv1=["Y"];
	 var getDatas1={beanName:bean1,valColumn:valcol1,valValue:valv1};
	 var params11=JSON.stringify(getDatas1);
	 var select_id1="comp_id";
	 var selectedCol11="co_id,co_nm";
	 CallDropDownService(params11,select_id1,selectedCol11);
    
	 var bean2="YearCodeBean";
	 var valcol2=["active"];
	 var valv2=["Y"];
	 var getDatas2={beanName:bean2,valColumn:valcol2,valValue:valv2};
	 var params12=JSON.stringify(getDatas2);
	 var select_id2="yrcode";
	 var selectedCol12="yr_cd_id,yr_cd";
	 CallDropDownService(params12,select_id2,selectedCol12);
    
	 var bean3="UomMasterBean";
	 var valcol3=["active"];
	 var valv3=["Y"];
	 var getDatas3={beanName:bean3,valColumn:valcol3,valValue:valv3};
	 var params13=JSON.stringify(getDatas3);
	 alert(params13);
	 var select_id3="u_id";
	 var selectedCol13="uom_id,uom_nm";
	 CallDropDownService(params13,select_id3,selectedCol13);
    
	 var bean4="RetailTempBean";
	 var valcol4=["active"];
	 var valv4=["Y"];
	 var getDatas4={beanName:bean4,valColumn:valcol4,valValue:valv4};
	 var params14=JSON.stringify(getDatas4);
	 var select_id4="des_id";
	 var selectedCol14="desg_no,desg_no";
	 CallDropDownService(params14,select_id4,selectedCol14);
	}

</script>
<script type="text/javascript">
 jQuery.noConflict();
 jQuery(document).ready(function($){
$("#jsGrid").jsGrid({
    width: "100%",
    inserting: true,
    filtering: true,
    editing: true,
    sorting: true,
    paging: true,
    autoload: true,
    searching:true,

    deleteConfirm: "Do you really want to delete the client?",


    controller: {
        loadData: function(filter) {
            var d = $.Deferred();

            $.ajax({
            	   type: 'GET',
            	    url: "../../../fetchAllStock",
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
        { name: "co_id", type: "text", width: 50, validate: "required" },
        { name: "desg_no", type: "text", width: 50 },
        { name: "itm_typ_id", type: "text", width: 50 },
        { name: "item_id", type: "text", width: 50 },
        { name: "cl_bal", type: "text", width: 50 },
        { name: "created_by", type: "text", width: 50 },
        { name: "modified_by", type: "text", width: 50 },
        { name: "created_on", type: "text", width: 50 },
        { name: "modified_on", type: "text", width: 50 },
        { type: "control" }
    ]
});
});
</script>
  <script type="text/javascript">
	function submitData() {
		$('#form1').submit(function(event) {
							var x = $('#form1').serializeJSON();
							var val = JSON.stringify(x);
						//	alert("my val is :-"+val);

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
											//alert("My");
											var fin_data = "";
											if (data.length > 0) {
											alert("====u have succesfully logged in====");
// 												window.location
// 														.replace("http://localhost:8081/SpringTest/home.jsp");
											} else {
												// alert("====Unauthorised Login====");	
												$('#msg')
														.html(
																"Please Provide Valid Login Credentials");
											}
										},
										error : function(xhr, textStatus,
												errorThrown) {
											window.location
													.replace("http://localhost:8081/SpringTest/login.jsp");

										}
									});

						});

	}
</script> 

<script>
 	function getData(param) { 		
  		 $.get("../../ajax/getItemFromDesign.jsp",{des_no:param}, function(data, status){  
  			 
  	        $('#itm').html(data);
  	      $('#itm_id').material_select();
  	    $('#itm_typ_id').material_select();
  	    });
 		

 	}
 </script>

   
     
    </head>
    <body class="fixed-sn light-blue-skin"> 
    <%@include file="../common/menu.jsp" %>

        <form id="form1" name="form_1" method="post">
<center>
          <div class="card card-cascade wider" style="width: 100%;">
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2"> Design Master</div>
       <div class="card-body">
         <div id="jsGrid"></div>
       </div>
       </div>
       <br>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#centralModalLGInfoDemo" onclick="beginDropDownService()"> Add Opening Stock </button>
                  
               <div class="modal fade" id="centralModalLGInfoDemo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg modal-notify modal-info" role="document">
                <!--Content-->
                <div class="modal-content">
                    <!--Header-->
                    <div class="modal-header">
                        <p class="heading lead">Opening Stock Entry.. </p>

                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true" class="white-text">&times;</span>
                        </button>
                    </div>
                     <div class="modal-body" style="color: #000"> 
           
              
                 <table>
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
                        Year Code:
                        </th>
                        <td>
                        <select name="yr_cd" id="yrcode" class="mdb-select  colorful-select dropdown-primary ">
                        </select>
                        
                        </td>
                       
                            <th>
                                Design No :
                            </th>

                            <td>
                            <select name="desg_no" id="des_id" class="mdb-select  colorful-select dropdown-primary " onchange="getData(this.value)">
                        </select>
                              
                            </td>

                        </tr>

                        <tr id="itm">     
                      
                        </tr>
                      
						<table>
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
                         <input type="text" name="op_bal" id="op_bal" />
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
               
              <input type="submit" class="btn btn-primary" onclick="submitData();" value="submit" />
<!--             <input type="button"  value="Stock Entry" onclick="doAjaxPost()" style="color:white;background-color: blue;"><br /><br />      -->
 </div>
 <div class="modal-footer">
                       
                          </div>
                </div>
                <!--/.Content-->
            </div>
        </div>       
        
        

      
              </center>
        </form>
    </body>
    <%@include file="../common/footer.jsp" %>    
</html>    