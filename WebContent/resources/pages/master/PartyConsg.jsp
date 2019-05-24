<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
 <head>
       <meta charset="utf-8">
       <title>Associate Consignee</title>
       <%@include file="../common/include.jsp" %>
<!--<script src="../../js/jquery.serializejson.js"></script> -->
<script src="../../../resources/js/validation.js"></script>
    <!-- <script>
            function validation1()
            {
                 alert("hiii");
                  var buss_ass = document.getElementById("party_id");
                var name = document.getElementById("consg_nm");
                var address1 = document.getElementById("consg_add1");
//                 var address2 = document.getElementById("consg_add2");
//                 var address3 = document.getElementById("consg_add3");
//                 var state = document.getElementById("state_id");
//                 var city = document.getElementById("city");
//                 var pin = document.getElementById("pin");
                 var gst = document.getElementById("gst_no");
//                 var phone = document.getElementById("phone");
//                 var coEmail = document.getElementById("email");
//                 var webst = document.getElementById("web_site");
//                 var fax = document.getElementById("fax");
//                 var s_no = document.getElementById("slno");
//                 var conname = document.getElementById("cont");
//                 var mobile = document.getElementById("cont_mob");
//                 var email = document.getElementById("email1");
//               	var date1 = document.getElementById("valid_fr");
//                 var date2 = document.getElementById("valid_to");


                errors=[];
                Dropdown16(buss_ass,"Please Select")
                checkBlank(name,"Name");
                checkBlank(address1,"Address1");
//                 checkBlank(address2,"Address2");
//                 checkBlank(address3,"Address3");
//                 checkBlank(state,"State");
//                 checkBlank(city,"City");
//                 checkBlank(pin,"Pin");
                 checkBlank(gst,"GST");
//                 checkBlank(phone,"Phone");
//                 checkBlank(coEmail,"Email");
//                 checkBlank(webst,"Webst");
//                 checkBlank(fax,"FAX");
//                 checkBlank(s_no,"Serial No");
//                	checkBlank(conname,"Contact");
//                 checkBlank(mobile,"Mobile");
//                 checkBlank(email,"Email");
//                 checkBlank(date1,"Date1");
//                 checkBlank(date2,"Date2");
              
               
               
                return finalCheck();            }

        </script>   -->


  
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
										url : "../../../Addparty_consg",

										data : val,
										dataType : 'json',

										success : function(data, textStatus) {
											//	alert(data);
												
												
												if (data=="success") {
													alert("== Data has been submited successfully ==");
													 location.reload();
												} else {
													alert("==Data Submition failed==");
													 location.reload();
													// alert("====Unauthorised Login====");	
													
												}
											},
										error : function(xhr, textStatus,
												errorThrown) {
											alert("error");
											window.location
													.replace("http://localhost:8081/SpringTest/login.jsp");

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
    inserting: true,
    filtering: true,
    editing: true,
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
            	    url: "../../../fetchAllConsgMaster",
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
        },
        updateItem: function(item) {
            return $.ajax({
                type: "POST",
                url: "../../../consgUpdate",
                contentType: "application/json",
                dataType: 'json',
                //var x = $('#form1').serializeJSON();
    			//var val = JSON.stringify(item.itm_nm),
    			
                data: JSON.stringify(item),
                success: function (data) {
                	 //d.resolve(JSON.parse(JSON.stringify(data)));
                	  location.reload();
                }
            });
        },
        
        deleteItem: function(item) {
            return $.ajax({
                type: "POST",
                url: "../../../partyConsgDelete",
                contentType: "application/json",
                dataType: 'json',
                //var x = $('#form1').serializeJSON();
    			//var val = JSON.stringify(item.itm_nm),
    			
                data: JSON.stringify(item),
                success: function (data) {
                	 //d.resolve(JSON.parse(JSON.stringify(data)));
                	  location.reload();
                }
            });
        }
    },

    fields: [
         { name: "consg_id", css: "hide"},
//         { name: "party_typ", type: "text", width: 70 , title: "Party"},
        { name: "consg_nm", type: "text", width: 100 , title: "Name"},
//         { name: "party_add1", type: "text", width: 50 , title: "Address1"},
//         { name: "party_add2", type: "text", width: 50 , title: "Address2"},
        { name: "consg_add3", type: "text", width: 100 , title: "Address"},
        { name: "city_nm", type: "text", width: 100 , title: "City"},
        { name: "state_nm", type: "text", width: 100 , title: "State"},
        { name: "pin", type: "text", width: 50 , title: "Pin"},
        { name: "gst_no", type: "text", width: 50 , title: "GST"},
        { name: "phone", type: "text", width: 50 , title: "Phone"},
        { name: "email", type: "text", width: 50 , title: "Email"},
        { name: "web_site", type: "text", width: 50 , title: "Web Site"},
        { name: "fax", type: "text", width: 50 , title: "FAX"},
//         { name: "created_by", type: "text", width: 50, title: "Created By"},
//         { name: "modified_by", type: "text", width: 50, title: "Modified By" },
//         { name: "created_on", type: "text", width: 50, title: "Created On" },
//         { name: "modified_on", type: "text", width: 50 , title: "Modified On"},
        { type: "control" }
    ]
});
});
</script>
  	
  	<script type="text/javascript">

jQuery(document).ready(function() {
    
	 var bean="PartyViewBean";
	 var valcol=["active"];
	 var valv=["Y"];
	 var getDatas={beanName:bean,valColumn:valcol,valValue:valv};
	 var params1=JSON.stringify(getDatas);
	 var select_id="party_id";
	 var selectedCol1="party_id,party_nm";
	 CallDropDownService(params1,select_id,selectedCol1);
	 
	 var bean2="StateMasterBean";
	 var valcol2=["active"];
	 var valv2=["Y"];
	 var getDatas2={beanName:bean2,valColumn:valcol2,valValue:valv2};
	 var params2=JSON.stringify(getDatas2);
	 var select_id2="state_id";
	 var selectedCol2="state_id,state_nm";
	 CallDropDownService(params2,select_id2,selectedCol2);

});

</script>
<script type="text/javascript">

function getCity()
{
	var strs=$('#state_id').val();
	//alert(strs);
	var bean2="CityMasterBean";
	 var valcol2=["active","state_id"];
	 var valv2=["Y",strs];
	 var getDatas2={beanName:bean2,valColumn:valcol2,valValue:valv2};
	 var params2=JSON.stringify(getDatas2);
	 var select_id2="city";
	 var selectedCol2="city_id,city_nm";
	 CallDropDownService(params2,select_id2,selectedCol2);
	
	}
</script>

</head>
<body class="fixed-sn mdb-skin-custom">

<%@include file="../common/menu.jsp" %>
             
 <main>
 
    <form id="myForm" name="myForm" method="post">
    
    <center>
    <div class="card card-cascade wider" style="width: 100%;">
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2">Associate Consignee</div>
       <div class="card-body">
         <div id="jsGrid"></div>
       </div>
       </div>
       <br>
        <button type="button"  class="btn btn-default" data-toggle="modal" data-target="#centralModalLGInfoDemo">ADD</button>
                  
               <div class="modal fade" id="centralModalLGInfoDemo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg modal-notify modal-info" role="document">
                <!--Content-->
                <div class="modal-content">
                    <!--Header-->
                    <div class="modal-header">
                        <p class="heading lead">Associate Consignee</p>

                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true" class="white-text">&times;</span>
                        </button>
                    </div>
                     <div class="modal-body">
                                     
							<table  class="table table-hover">
							
					<tr>
							<td> Select Business Associate Name:</td>
							<td> <select name="party_id" id="party_id" class="mdb-select  colorful-select dropdown-primary " >
                        <option value='0'>---select Option---</option>
                        </select>
                        </td>
							</tr>  
							
<tr>
<td>Name:</td>
<td><input  type="text" name="consg_nm" id="consg_id" placeholder="Name"></td>
</tr>
<tr>
<td>Address1:</td>
<td><input  type="text" name="consg_add1" id="consg_add1" placeholder="Address1"></td>
</tr>
<tr>
<td>Address2:</td>
<td><input  type="text" name="consg_add2" id="consg_add2" placeholder="Address2"></td>
</tr>
<tr>
<td>Address3:</td>
<td><input  type="text" name="consg_add3" id="consg_add3" placeholder="Address3"></td>
</tr>



<tr>
							<td>State:</td>
							<td> <select name="state" id="state_id" class="mdb-select  colorful-select dropdown-primary " onchange="getCity()">
                        <option value='0'>---select Option---</option>
                        </select>
                        </td>
							</tr>
							<tr>
<td>City:</td>
<td> <select name="city" id="city" class="mdb-select  colorful-select dropdown-primary " >
                        <option value='0'>---select Option---</option>
                        </select></td>
</tr>
<tr>
<td>Pin:</td>
<td><input  type="text" name="pin" id="pin" placeholder="pin"></td>
</tr>
<tr>
<td>GST:</td>
<td><input  type="text" name="gst_no" id="gst_no" placeholder="GST"></td>
</tr>
<tr>
<td>Phone:</td>
<td><input  type="text" name="phone" id="phone" placeholder="Phone"></td>
</tr>
<tr>
<td>Email:</td>
<td><input  type="text" name="email" id="email" placeholder="Email"></td>
</tr>
<tr>
<td>Web Site:</td>
<td><input  type="text" name="web_site" id="web_site" placeholder="Web Site"></td>
</tr>
<tr>
<td>FAX:</td>
<td><input  type="text" name="fax" id="fax" placeholder="FAX"></td>
</tr>

<tr>
<th>
Contact Details
</th>
</tr>
  <!-- <tr>
                        <th>
                        Consignee:
                        </th>
                        <td>
                         <input type="text" name="consg_id" id="cons" placeholder="Consignee"/>
                        </td>
                        </tr> -->
                        
                         <tr>
                        <th>
                        Serial No:
                        </th>
                        <td>
                         <input type="text" name="sl_no" id="slno" placeholder="Serial No"/>
                        </td>
                        </tr>
                        
                         <tr>
                        <th>
                        Contact Person:
                        </th>
                        <td>
                         <input type="text" name="cont_per" id="cont" placeholder="Contact Person"/>
                        </td>
                        </tr>
                        
                         <tr>
                        <th>
                        Mobile:
                        </th>
                        <td>
                         <input type="text" name="cont_mob" id="cont_mob" placeholder="Mobile"/>
                        </td>
                        </tr>
                         <tr>
                        <th>
                        Email:
                        </th>
                        <td>
                         <input type="text" name="cont_email" id="email" placeholder="Email"/>
                        </td>
                        </tr>
                        
							
	</table>
	<tr>
							<td> 
							<input type="submit"  value="Submit" class="btn btn-success"> 
							</tr>
							<div class="modal-footer">
                       
                          </div>
                </div>
                <!--/.Content-->
            </div>
        </div>
      </div>
      
       </center>     
 	</form>
 </main>
 	</body>
  <%@include file="../common/footer.jsp" %>
</html>