<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
    
        <meta charset="utf-8">
        <title>Design Creation Page....</title>
        <%@include file="../common/include.jsp" %>

<style type="text/css">
table th{
    width: auto !important;
    height: auto !important;
     padding: 0px 0px 0px 50px;
}
table td{
    width: auto !important;
    height: auto !important;
     padding: 0px 0px 0px 50px;
}

}
</style>

<script src="../../../resources/js/validation.js"></script> 

 

 <script>
 
            function validation1()
            {
               // alert("hiii");
                var design = document.getElementById("desgNo");
                var by = document.getElementById("design_bys");
                var type = document.getElementById("item_typ");
                var item = document.getElementById("item_id");
                var vendor = document.getElementById("v_desg_no");
                var cost = document.getElementById("cost");
                var outlet = document.getElementById("co_id");
                var rate_typ = document.getElementById("rt_type");
                var rate = document.getElementById("rate");
               

                errors=[];
                checkBlank(design,"Design No");
                Dropdown3(by,"Please Select");
                Dropdown4(type,"Please Select");
                Dropdown5(item,"Please Select");
                checkBlank(vendor,"Vendor Desg");
                checkBlank(cost,"Cost");
                Dropdown6(outlet,"Please Select");
                Dropdown7(rate_typ,"Please Select");
                checkBlank(rate,"Rate");
                return finalCheck();
               
                
            }

        </script>
<script type="text/javascript">

$(document).ready(function() {
   
   
   $('.datepicker').pickadate({
  	
  	  format: 'yyyy-mm-dd'
  	});

 
 var bean="ItemTypeBean";
 var valcol=["active"];
 var valv=["Y"];
 var getDatas={beanName:bean,valColumn:valcol,valValue:valv};
 var params1=JSON.stringify(getDatas);
 var p="item_typ";
 var selectedCol1="itm_typ_id,itm_typ_nm";
 CallDropDownService(params1,p,selectedCol1);
 
 var bean1="PartyViewBean";
 var valcol1=["active","party_typ"];
 var valv1=["Y","SC"];
 var getDatas1={beanName:bean1,valColumn:valcol1,valValue:valv1};
 var params11=JSON.stringify(getDatas1);
 var p1="design_bys";
 var selectedCol11="party_id,party_nm";
 CallDropDownService(params11,p1,selectedCol11);
 
 var bean12="RetailCompanyMasterBean";
 var valcol12=["active"];
 var valv12=["Y"];
 var getDatas12={beanName:bean12,valColumn:valcol12,valValue:valv12};
 var params12=JSON.stringify(getDatas12);
 var p2="co_id";
 var selectedCol12="co_id,co_nm"; 
 CallDropDownService(params12,p2,selectedCol12);
 
 var bean3="ItemRateTypeBean";
 var valcol3=["active"];
 var valv3=["Y"];
 var getDatas3={beanName:bean3,valColumn:valcol3,valValue:valv3};
 var params13=JSON.stringify(getDatas3);
 var p3="rt_type";
 var selectedCol13="rt_typ_id,rt_typ_nm";
 CallDropDownService(params13,p3,selectedCol13);

});

</script>

  <script type="text/javascript">
  function getItems(str)
  {
	  var beanName="ItemMasterBean";
	  var valColumn=["active","itm_typ_id"];
	  var valValue=["Y",str];
	  var getData={beanName:beanName,valColumn:valColumn,valValue:valValue};
	  var params=JSON.stringify(getData);
	 // alert(params);
	  var x="item_id";
	  var selectedCol="itm_id,itm_nm";
	  CallDropDownService(params,x,selectedCol);  
	  
  }
  
 function addNewRow()
 {
	// alert("hello");
	
	 var x=$("#cloneRow").clone();
	// $('.x').material_select('destroy');
	$("#TableId").find("tr").last().after(x);
	
	// $('.x').material_select();
	 
 }
 
  function generateBarcode()
  { 	//alert("i am here");
	  $.get('../../../fetchBarcode',{}, function (response) {
      	//alert(response);
       $("#bar_code").val(response);
          

      });
  }
  
  </script>
  <script type="text/javascript">
  function readURL(input) {

	  if (input.files && input.files[0]) {
	    var reader = new FileReader();

	    reader.onload = function(e) {
	      $('#disImg').attr('src', e.target.result);
	    }

	    reader.readAsDataURL(input.files[0]);
	  }
	}
  $(function() {
	$("#design_pic").change(function(e) {
		//alert("hii");
	  readURL(this);
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

    deleteConfirm: "Do you really want to delete the client?",


    controller: {
        loadData: function(filter) {
            var d = $.Deferred();

            $.ajax({
            	   type: 'GET',
            	    url: "../../../fetchDesignDetails1",
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
        { name: "tr_id", type:"text",width:50,title: "Item Id",css: "hide"},
        { name: "desg_no", type: "text", width: 50 ,title : "Design No"  },
        { name: "v_desg_no", type: "text", width: 50 ,title : "Vendor Design No"  },
        { name: "desg_on", type: "text", width: 50 ,title : "Designed On"  },
        { name: "item_typ_nm", type: "text", width: 50 ,title : "Item Type"  },
        { name: "item_id_nm", type: "text", width: 50 ,title : "Item"  },
        { name: "design_by_nm", type: "text", width: 50 ,title : "Designed By"  },
        { name: "bar_code", type: "text", width: 50 ,title : "Barcode"  },
        { name: "cost", type: "text", width: 50 ,title : "Cost"  },
        { name: "desg_desc", type: "text", width: 50 ,title : "Description"  },
        { name: "created_by", type: "text", width: 50, title: "Created By" },
//         { name: "modified_by", type: "text", width: 50 , title: "Modified By"},
        { name: "created_on", type: "text", width: 50, title: "Created On" },
//         { name: "modified_on", type: "text", width: 50, title: "Modified On" },
        { type: "control",itemTemplate: function(value, item) {
       	 var $result = jsGrid.fields.control.prototype.itemTemplate.apply(this, arguments);

         var $customEditButton = $("<p>").attr({class: "customGridEditbutton fa fa-caret-square-o-right"})
           .click(function(e) {
        	   e.preventDefault();
            // alert("ID: " + item.tr_id);
             $.get('../../../resources/ajax/forDesignMasterView.jsp', {tr_id: item.tr_id}, function (response)
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
</script>
  <script>
  $(function() {
		$('#form1').submit(function(event) {
			event.preventDefault();
	
							var x = $('#form1').serializeJSON();
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
										url : "../../../addDesign",
										enctype: 'multipart/form-data',
										 processData: false,  
									        contentType: false,
										data : val,
										dataType : 'json',

										success : function(data, textStatus) {
											
											// 				for (var i = 0; i < data.length; i++) {
											// 					fin_data= data[i].user_id + data[i].user_pw;
											// 				}
											if (data=="success") {
												alert("====ur Data Has Been Saved Suceessfully====");
												 location.reload();
											} else {
												 alert("====Your Data Was Not Saved====");
												
												
											}
										},
										error : function(xhr, textStatus,
												errorThrown) {
											alert("Please Check Your Data");

										}
									});
										}
						});

	});
</script>    
 

    </head>
    <body class="fixed-sn mdb-skin-custom">
<%@include file="../common/menu.jsp" %>


        <main>
        
<center>
          <div class="card card-cascade wider" style="width: 100%;">
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2"> Design Master</div>
       
       <ul class="nav nav-tabs nav-justified indigo" role="tablist">
    <li class="nav-item">
        <a class="nav-link active" data-toggle="tab" href="#panel5" role="tab"><i class="fa fa-plus"></i> Add Design</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#panel6" role="tab"><i class="fa fa-edit"></i> View/Update Design</a>
    </li>
   
</ul>
        
   
       </div>
       <br>
       
       <div class="tab-content">
                  
                <div class="tab-pane fade in show active" id="panel5" role="tabpanel">
                <form id="form1" name="form_1" method="post" >
                <div>
                 <table  border="0" style=" width: 100%; ">
                   <tr>
                    <th>
				Design No:
				</th>
				<td>
				 <input type="text" name="desg_no" id="desgNo" class="form-control"  style=" width: 75%;"/>
				
				</td>
                <th>
                      Vendor Desg No:
                        </th>
                        <td>
                        	 <input type="text" name="v_desg_no" id="v_desg_no" class="form-control"/>
                        
                        </td>

                            <th>
                                Designed On :
                            </th>

                            <td>
                               <input placeholder="Selected date" type="text" name="desg_on" id="desg_on" class="form-control datepicker">
                        
                            </td>
                        </tr>
                      
						<tr>
						<th>
                               Design By:
                            </th>

                            <td>
                                 
                        <select name="design_by" id="design_bys" class="mdb-select  colorful-select dropdown-primary " >
                        <option value='0'>---select Option---</option>
                        </select>
                            </td>
                            <th>
                                Item Type:
                            </th>

                            <td>
                                 
                        <select name="item_typ" id="item_typ" class="mdb-select  colorful-select dropdown-primary " onchange="getItems(this.value)">
                        <option value='0'>---select Option---</option>
                        </select>
                            </td>

                     
                        <th>
                        Item:
                        </th>
                        <td>
                        <select name="item_id" id="item_id" class="mdb-select  colorful-select dropdown-primary " >
                        <option value='0'>---select Option---</option>           
                        </select>
                        </td>
                        </tr>
                        
                        <tr>
                        <th>
                       Barcode:
                        </th>
                        <td>
                         <input type="text" name="bar_code" id="bar_code" class="form-control" style=" width: 60%; float: left" readonly/> <button type="button" class="btn btn-mdb-color btn-sm" style=" float: right;" onclick="generateBarcode()"><i class="fa fa-plus"></i></button>
                        </td>
                        <th>
                        Image:
                        </th>
                        <td colspan="2">
                        
                        <div class="file-field">
            <div class="btn btn-primary btn-sm float-left">
                <span>Choose file</span>
                <input type="file" id="design_pic" name="file">
            </div>
            <div class="file-path-wrapper">
                <input class="file-path validate" type="text" placeholder="Upload your file" name="file_name" >
            </div>
        </div>
                        </td>
                        
                        </tr>
                          <tr>
                       
                            <th>
                                Description:
                            </th>

                            <td>
                                <textarea type="text" id="desg_desc"  name="desg_desc" class="md-textarea form-control"></textarea>
                            </td>

                      
<!--                         <th> -->
<!--                        Comment: -->
<!--                         </th> -->
<!--                         <td > -->
<!--                          <textarea type="text" id="notes"  name="notes" class="md-textarea form-control"></textarea> -->
<!--                         </td> -->
 						<th>
                      Cost:
                        </th>
                        <td>
                        	 <input type="text" name="cost" id="cost" class="form-control"/>
                        
                        </td>
                         <td> <img id="disImg" src="#" alt="your image"  class="img-fluid z-depth-1" alt="1"/>
                         
                         
                         </td>
                        </tr>
                    </table>
                  </div>
                <br>
                  <div class="card border-warning">
                    <table  id="TableId">
<!--                     <tr> -->
<!--                     <td colspan="7"><center>  <button type="button" class="btn btn-mdb-color btn-sm" onclick="addNewRow()"><i>ADD Details</i></button></center> -->
<!--                     </tr> -->
                    <tr>
                    <th>Outlet
                    <th>Rate Type
                    <th>Rate
                    <th>Remarks
                    <th>Default
                    <th><button type="button" class="btn btn-mdb-color btn-sm" onclick="addNewRow()"><i>ADD Details</i></button>
                    </tr>
                    <tr id="cloneRow">
                    <td><select name="co_id[]" id="co_id" class="browser-default">
                        <option value='0'>---select Option---</option>           
                        </select>
                    <td><select name="rt_type[]" id="rt_type" class="browser-default">
                        <option value='0'>---select Option---</option>           
                        </select>
                    <td><input type="text" name="rate[]" id="rate"  />
                    <td><input type="text" name="remarks[]" id="remarks"  />
                   
                   <td>
                   <select name="default_rate[]" id="default_rate" class="browser-default">
                        <option value='N'>No</option>    
                        <option value='Y'>Yes</option>           
                        </select>
                   </td>
                    </tr>
                    
                    </table>
                    
                 
            <input type="submit" class="btn btn-primary btn-sm"  value="submit" />
     	</div>
<!--             <input type="button"  value="Stock Entry" onclick="doAjaxPost()" style="color:white;background-color: blue;"><br /><br />      -->
    </form>
            </div>
            <div class="tab-pane fade" id="panel6" role="tabpanel">
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
            <div class="modal-body" id="viewGrid">
            
            </div>
            <div class="modal-footer">
              
                <button type="button" class="btn btn-primary btn-sm">Save changes</button>
            </div>
        </div>
    </div>
</div>
          </div>
      </div>
      <br>
              </center>
    
       <input type="text" id="cnt" value="0" style="display:none">
         </main>
         <script type="text/javascript">

$('#design_pic').change(function(evt) {
	var files=evt.target.files;

    console.log("filename="+files[0]);
    //alert("Inside file upload..");
    var formData = new FormData();
    formData.append('file',files[0]);
    var barcode=document.getElementById("bar_code").value;
    formData.append('barcode',barcode);
    console.log("form data " + formData);
    $.ajax({
        url : '../../../uploadDesignPic',
        data : formData,
        processData : false,
        contentType : false,
        type : 'POST',
        success : function(data) {
        	 console.log(data);
        },
        error : function(err) {
        	 console.log(err);
        }
    });
});

</script>
    </body>
    <%@include file="../common/footer.jsp" %>
</html>
