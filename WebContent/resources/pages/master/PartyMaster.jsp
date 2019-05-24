<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
 <head>
       <meta charset="utf-8">
       <title>Business Associate</title>
       
        
       <%@include file="../common/include.jsp" %>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!--<script src="../../js/jquery.serializejson.js"></script> -->
<script src="../../../resources/js/validation.js"></script> 

  <script>
            function validation1()
            {
                 //alert("hiii");
                var associate_typ = document.getElementById("party_typ_id");
                var name = document.getElementById("party_nm");
                var address1 = document.getElementById("party_add1");
				var gst = document.getElementById("gst_no");

                errors=[];
                Dropdown1(associate_typ,"Please Select")
                checkBlank(name,"Name");
                checkBlank(address1,"Address1");
				checkBlank(gst,"GST");
				return finalCheck();            
				}

        </script>
        <script>

$(document).ready(function() {
    $('.mdb-select').material_select();
  });
</script>
        
        <script>
	function checkDuplicate(param) {
		
		var tnm="mst_party";
		var fnm="party_nm";
		
		$.get("../../ajax/getForUniqueValue.jsp", {val : param,tbl_nm:tnm,fld_nm:fnm}, function(response) {
			var x=response.trim();	
			 // alert(x);
		       
		         if(parseInt(x)>0)
		        	 {
		        	 alert("Name already Exists");
		        	 $('#party_nm').val("");
		        	 $('#party_nm').focus();
		        	 }
		});
			
	}
</script>
<!--  <script>
	function checkDuplicate1(param) {
		
		var tnm="mst_party";
		var fnm="party_add1";
		
		$.get("../../ajax/getForUniqueValue.jsp", {val : param,tbl_nm:tnm,fld_nm:fnm}, function(response) {
			var x=response.trim();	
			 // alert(x);
		       
		         if(parseInt(x)>0)
		        	 {
		        	 alert("Address already Exists");
		        	 $('#party_add1').val("");
		        	 $('#party_add1').focus();
		        	 }
		});
			
	}
</script> -->


  
	<script type="text/javascript">
	$(function() {
		$('#myForm').submit(function(event) {
			event.preventDefault();
				//alert("hahahah");
							var x = jQuery('#myForm').serializeJSON();//$('#myForm').serializeJSON();
						
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
										url : "../../../Addparty_master",

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
}

				});


});
  	</script>
<script type="text/javascript">
$(function() {
	$("#party_nm1").change(function (e) {
   e.preventDefault();
   party_nm1=$('#party_nm1').val();
   party_nm1=$('#party_nm1').val();
	// alert(party_nm1);
	if(party_nm1=="")
		{
		party_nm1=" ";
		}
	
	jQuery.noConflict();
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
            	    url: "../../../fetchAllPartyMaster",
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
                url: "../../../party_mtypUpdate",
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
                url: "../../../partyDelete",
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
        { name: "party_id", css: "hide"},
		{ name: "party_nm", type: "text", width: 100 , title: "Name"},
		{ name: "party_add3", type: "text", width: 100 , title: "Address"},
        { name: "city_nm", type: "text", width: 100 , title: "City"},
        { name: "state_nm", type: "text", width: 100 , title: "State"},
        { name: "pin", type: "text", width: 50 , title: "Pin" },
		{ name: "gst_no", type: "text", width: 50 , title: "GST"},
        { name: "phone", type: "text", width: 50 , title: "Phone"},
        { name: "email", type: "text", width: 50 , title: "Email"},
        { name: "web_site", type: "text", width: 50 , title: "Web Site"},
        { name: "fax", type: "text", width: 50 , title: "FAX"},

       { type: "control",itemTemplate: function(value, item) {
       	 var $result = jsGrid.fields.control.prototype.itemTemplate.apply(this, arguments);

         var $customEditButton = $("<p>").attr({class: " customGridEditbutton fa fa-caret-square-o-right"})
        
           .click(function(e) {
        	   e.preventDefault();
            // alert("ID: " + item.tr_id+"---"+Date.now());
            var x=Date.now();
             $.get('../../../resources/ajax/forPartyMasterView.jsp', {tr_id: item.tr_id,ttimestamps:x}, function (response)
                     {
                       // alert(response);
                     $('#viewGrid').html(response);
                     jQuery('.x').material_select();
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
});
	
</script>
  	
  	<script type="text/javascript">

jQuery(document).ready(function() {
    
 var bean="PartyTypeBean";
 var valcol=["active"];
 var valv=["Y"];
 var getDatas={beanName:bean,valColumn:valcol,valValue:valv};
 var params1=JSON.stringify(getDatas);
 var select_id="party_typ_id";
 var selectedCol1="party_typ_id,party_typ_nm";
 CallDropDownService(params1,select_id,selectedCol1);
 
 var bean1="RetailCompanyMasterBean";
 var valcol1=["active"];
 var valv1=["Y"];
 var getDatas1={beanName:bean1,valColumn:valcol1,valValue:valv1};
 var params1=JSON.stringify(getDatas1);
 var select_id1="co_id";
 var selectedCol1="co_id,co_nm,outlet";
 CallDropDownServiceForConcat(params1,select_id1,selectedCol1);
 
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

 <script type="text/javascript">
    function fetchDesignData(str)
    {
    
    	jQuery.noConflict();
    	// var availableTags = [{"id":1,"label":"ActionScript"},{"id":2,"label":"BppleScript"}];
    	//var coid=$('#company_id').val();
    	jQuery.get('../../../fetchCustomerForPartyMaster',{val:str}, function (response) {
    	 //  alert(response);//desg_id//
    	// var myJSON = JSON.stringify(response); 
    	    $('#party_nm1').autocomplete({
    	    	    source: response,
    	    	    select: function( event, ui ) { alert(ui.item.id);
    	    	    	 //alert(ui.item.label);
    	    	   // $('#uid').val(ui.item.id);
    	    	    //getCashSaleParty(ui.item.id);
//     	    	    var x=$('#company_id').val();
//     	    	    afterDesgChange(event.,x);
//     	    	    fetchItemTypeAndItemFromDesign(this,x);
    	    	    	
    	    	    }
    	    	});
    	          

    	      });		
    }
    
    </script>

</head>
<body class="fixed-sn mdb-skin-custom">

<%@include file="../common/menu.jsp" %>
             
 <main>
 
    
    <center>
          <div class="card card-cascade wider" style="width: 100%;">
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2"> Business Associate</div>
       
       <ul class="nav nav-tabs nav-justified indigo" role="tablist">
    <li class="nav-item">
        <a class="nav-link active" data-toggle="tab" href="#panel5" role="tab"><i class="fa fa-plus"></i> Add Business Associate </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#panel6" role="tab"><i class="fa fa-edit"></i> View/Update Business Associate</a>
    </li>
   
</ul>
        
   
       </div>
       <br>
 
       <div class="tab-content">
                  
                <div class="tab-pane fade in show active" id="panel5" role="tabpanel">
    <form id="myForm" name="myForm" method="post" onsubmit="return validation()">
              <div>
							<table class="table table-hover">
								<tr><td>
	<div class="form-check"> Select Type:
    <input class="form-check-input" name="reg_typ" type="radio" id="radio100" value="R"  checked>
    <label class="form-check-label" for="radio100">Registered</label>

    <input class="form-check-input" name="reg_typ" type="radio" id="radio101" value="U"  >
    <label class="form-check-label" for="radio101">Unregistered</label>
</div>

</td></tr>
<br>
							<tr>
							<td> Select Associate Type:</td>
							<td> <select name="party_typ" id="party_typ_id" class="mdb-select  colorful-select dropdown-primary " >
                        <option value='0'>---select Option---</option>
                        </select>
                        </td>
						
							<td>Select Outlet (For Stock Transfer Only):</td>
							<td> <select name="co_id" id="co_id" class="mdb-select  colorful-select dropdown-primary " >
                        <option value='0'>---Select Option---</option>
                        </select>
                        </td>
						
							
						
<td>Name:</td>
<td><input type="text" name="party_nm" id="party_nm" placeholder="Name" onchange="checkDuplicate(this.value)"></td>

	</tr>
	<tr>
		<td>Address:</td>
<td><input type="text" name="party_add3" id="party_add3" placeholder="Address"></td>
	
	

<td>Address1:</td>
<td><input type="text" name="party_add1" id="party_add1" placeholder="Address1" onchange="checkDuplicate1(this.value)"></td>

<td>Address2:</td>
<td><input type="text" name="party_add2" id="party_add2" placeholder="Address2"></td>
</tr>
<tr>

		<td>State:</td>
							<td> <select name="state" id="state_id" class="mdb-select  colorful-select dropdown-primary " onchange="getCity()">
                        <option value='0'>---select Option---</option>
                        </select>
                        </td>
						
<td>City:</td>
<td> <select name="city" id="city" class="mdb-select  colorful-select dropdown-primary ">
                        <option value='0'>---select Option---</option>
                        </select></td>
                          <td>Pin:</td>
<td><input type="text" name="pin" id="pin" placeholder="pin" style="text-align: right"></td>
</tr>
<tr>
					
                        
                      

       
          <td><label for="sgTag"> SG Tag : </label>
                            <td> <select name="sd_tag" id="sd_tag" class="mdb-select colorful-select dropdown-danger">  
                             <option value='0'>---select Option---</option>                          
                             <option value="Y">Yes</option>
                             <option value="N">No</option>   
                             </select>
                             </td>
                             <td>GST Number:</td>
<td><input type="text" name="gst_no" id="gst_no" placeholder="GST" style="text-align: right"></td>

<td>Phone:</td>
<td><input type="text" name="phone" id="phone" placeholder="Phone" style="text-align: right"></td>
                             
                             
       
       
        </tr>  
                 

<tr>

<td>Email:</td>
<td><input type="text" name="email" id="email" placeholder="Email"></td>



<td>Web Site:</td>
<td><input type="text" name="web_site" id="web_site" placeholder="Web Site"></td>

<td>FAX:</td>
<td><input type="text" name="fax" id="fax" placeholder="FAX" style="text-align: right"></td>
  </tr> 
  
  </div>
  <th>
<h style="color: #E73408;  font-weight: bold;">Contact Details</h>

</th>
<br>
  <tr>


                        <th>
                        Serial No:
                        </th>
                        <td>
                         <input type="text" name="sl_no" id="slno" placeholder="Serial No" style="text-align: right"/>
                        </td>
                  
                        <th>
                        Contact Person:
                        </th>
                        <td>
                         <input type="text" name="cont_per" id="cont" placeholder="Contact Person"/>
                        </td>
                      
                        <th>
                        Mobile:
                        </th>
                        <td>
                         <input type="text" name="cont_mob" id="cont_mob" placeholder="Mobile" style="text-align: right"/>
                        </td>
                      
                     	</tr>
                     	<tr>
                     	       <th>
                        Email:
                        </th>
                        <td>
                         <input type="text" name="cont_email" id="email1" placeholder="Email"/>
                        </td>
                     	</tr>
                    
                   
                      
		
							
	</table>
	<input type="submit"  value="Submit" class="btn btn-success" onclick="submitData();"> 
	
	</div>
	</form>
	</div>
	<div class="tab-pane fade" id="panel6" role="tabpanel">
	
	<table>
	  <th>
                      Customer Name
                        </th>
                   
				 <tr> <td>
<!--                         <select name="desg_no" id="desg_no_p" class="mdb-select  colorful-select dropdown-primary" > -->
                         
<!--                         </select> -->
                         <input placeholder="Enter Customer"  type="text" name="party_nm1" id="party_nm1" onkeyup="fetchDesignData(this.value)" >
                        
                        </td></tr>
                      </table>  
                        
        <br>
        <div id="jsGrid"></div> 
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document" style=" max-width: 90%">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">View Data</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
             <form id="form2" name="form_2" method="post" >
            <div class="modal-body" id="viewGrid">
            
            </div>
            <div class="modal-footer">
              
                 <input type="submit" class="btn btn-primary btn-sm"  value="Save Changes" />
            </div>
            </form>
        </div>
    </div>
</div>
          </div>
            </div>
      <br>
       </center>     
 
 	</body>
  <%@include file="../common/footer.jsp" %>
</html>