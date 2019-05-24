<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Role Creation Page....</title>
         <script src="../../../resources/js/jquery-1.11.0.js"></script> 
<%@include file="../common/include.jsp" %>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
	   //fetchDesignData();
 //function beginDropDownService() { 
	
//  var bean="RetailCompanyMasterBean";
//  var valcol=["active"];
//  var valv=["Y"];
//  var getDatas={beanName:bean,valColumn:valcol,valValue:valv};
//  var params1=JSON.stringify(getDatas);
//  var select_id="comp_id";
//  var selectedCol1="co_id,co_nm";
//  CallDropDownService(params1,select_id,selectedCol1);
 
//  var bean1="YearCodeBean";
//  var valcol1=["active"];
//  var valv1=["Y"];
//  var getDatas1={beanName:bean1,valColumn:valcol1,valValue:valv1};
//  var params11=JSON.stringify(getDatas1);
//  var select_id1="yrcode";
//  var selectedCol11="yr_cd_id,yr_cd";
//  CallDropDownService(params11,select_id1,selectedCol11);
 
//  var bean2="UomMasterBean";
//  var valcol2=["active"];
//  var valv2=["Y"];
//  var getDatas2={beanName:bean2,valColumn:valcol2,valValue:valv2};
//  var params12=JSON.stringify(getDatas2);
//  var select_id2="u_id";
//  var selectedCol12="uom_id,uom_nm";
//  CallDropDownService(params12,select_id2,selectedCol12);
 
//  var bean3="RetailTempBean";
//  var valcol3=["active"];
//  var valv3=["Y"];
//  var getDatas3={beanName:bean3,valColumn:valcol3,valValue:valv3};
//  var params13=JSON.stringify(getDatas3);
//  var select_id3="des_id";
//  var selectedCol13="desg_no,desg_no";
//  CallDropDownService(params13,select_id3,selectedCol13);

//  var bean5="RetailTempBean";
//  var valcol5=["active"];
//  var valv5=["Y"];
//  var getDatas5={beanName:bean5,valColumn:valcol5,valValue:valv5};
//  var params15=JSON.stringify(getDatas5);
//  var select_id5="desg_no_p";
//  var selectedCol15="desg_no,desg_no";
//  var allTag='Y';
//  CallDropDownService(params15,select_id5,selectedCol15,allTag);





 var bean6="RetailCompanyMasterBean";
 var valcol6=["active"];
 var valv6=["Y"];
 var getDatas6={beanName:bean6,valColumn:valcol6,valValue:valv6};
 var params16=JSON.stringify(getDatas6);
 var select_id6="co_nm_p";
 var selectedCol16="co_id,co_nm,outlet";
 var allTag='Y';
 CallDropDownServiceForConcat(params16,select_id6,selectedCol16,allTag);
 
});
//}


</script>
   <script type="text/javascript">
    function fetchDesignData(str)
    { 
    	jQuery.noConflict();
    	// var availableTags = [{"id":1,"label":"ActionScript"},{"id":2,"label":"BppleScript"}];
    	//var coid=$('#company_id').val();
    	jQuery.get('../../../fetchDesign',{val:str}, function (response) {
    	   // alert(response);//desg_id//
    	    
    	    $('#desg_no_p').autocomplete({
    	    	    source:response,
    	    	    select: function( event, ui ) { //alert(ui.item.id);
    	    	    	// alert(ui.item.label);
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
<script type="text/javascript">
//function fetch_grid(str){
	$(function() {
	$("#desg_no_p").change(function (e) {
                e.preventDefault();
	 desg_no=$('#desg_no_p').val();
	 co_id=$('#co_nm_p').val();
	 //alert(desg_no+'-----'+co_id);
	if(co_id=="")
		{
		co_id="-999";
		}
	if(desg_no=="")
	{
		desg_no="-999";
	}
	jQuery.noConflict();
$("#jsGrid").jsGrid({
 width: "100%",
 inserting: false,
 filtering: true,
 editing: false,
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
         	    url: "../../../fetchAllStock?desg_no="+desg_no+"&co_id="+co_id, 
         	   	data:null,
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
     { name: "comp_nm", type: "text", width: 50, validate: "required",title : "Company" },
     { name: "desg_no", type: "text", width: 50,title : "Design"  },
     { name: "itm_typ_nm", type: "text", width: 50,title : "Item Type"  },
     { name: "itm_nm", type: "text", width: 50 ,title : "Item" },
     { name: "cl_bal", type: "text", width: 50,title : "Closing Balance"  }
 ]
});
	 });
	////////////
	
	$("#co_nm_p").change(function (e) {
        e.preventDefault();
desg_no=$('#desg_no_p').val();
co_id=$('#co_nm_p').val();
// alert(desg_no+co_id);
if(co_id=="")
{
co_id="-999";
}
if(desg_no=="")
{
desg_no="-999";
}
jQuery.noConflict();
$("#jsGrid").jsGrid({
width: "100%",
inserting: false,
filtering: true,
editing: false,
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
 	    url: "../../../fetchAllStock?desg_no="+desg_no+"&co_id="+co_id, 
 	   	data:null,
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
{ name: "comp_nm", type: "text", width: 50, validate: "required",title : "Company" },
{ name: "desg_no", type: "text", width: 50,title : "Design"  },
{ name: "itm_typ_nm", type: "text", width: 50,title : "Item Type"  },
{ name: "itm_nm", type: "text", width: 50 ,title : "Item" },
{ name: "cl_bal", type: "text", width: 50,title : "Closing Balance"  },

{ type: "control" }
]
});
});
	
	
	 });
//}

</script>
   
     
    </head>
    <body class="fixed-sn light-blue-skin" > 
    <%@include file="../common/menu.jsp" %>
<main>
        <form id="form1" name="form_1" method="post">
<center>
          <div class="card card-cascade wider" style="width: 100%;">
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2"> Stock View </div>
       <div class="card-body">
       <table class="table table-hover">
                   <tr>
                    <th>
				Company:
				</th>
				<td>
				 <select name="co_nm" id="co_nm_p" class="browser-default" >
				
                        </select>
				
				</td>
                <th>
                      Design:
                        </th>
                   
				  <td>
<!--                         <select name="desg_no" id="desg_no_p" class="mdb-select  colorful-select dropdown-primary" > -->
                         
<!--                         </select> -->
                         <input placeholder="Enter Design" type="text" name="desg_no" id="desg_no_p"  value="" onkeyup="fetchDesignData(this.value)">
                        
                        </td>
						  
                        </tr>
                        </table>
         <div id="jsGrid"></div>
       </div>
       </div>
       <div class="modal-body" id="viewGrid">
            
            </div>
            <div class="modal-footer">
              
                <input type="hidden" class="btn btn-primary btn-sm" value="Ackowledged"/>
            </div>
       <br>
        
       <br>
            
      
              </center>
        </form>
        </main>
    </body>
    <%@include file="../common/footer.jsp" %>    
</html>    