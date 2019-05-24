<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="com.crunchify.util.*"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
    
        <meta charset="utf-8">
        <title>Receive From Karigarh....</title>
        
            <script src="../../../resources/js/jquery-1.11.0.js"></script> 
        <%@include file="../common/include.jsp" %>
<!--          <script src="../../../resources/js/packingSlip.js"></script>  -->
<!--     <script src="../../../resources/js/cashSales.js"></script> -->
<!--   <script src="../../../resources/js/validation.js"></script>    -->

<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.js" type="text/javascript"></script>

<style type="text/css">
.table-wrapper {
    display: block;
    max-height: 300px;
    overflow-y: auto;
    -ms-overflow-style: -ms-autohiding-scrollbar;
}

}
</style>




<script type="text/javascript">

$(document).ready(function() {
   
   
   $('.datepicker').pickadate({
  	
  	  format: 'yyyy-mm-dd',
  	  max:new Date()
  	});

 

 

 
 var bean3="ItemRateTypeBean";
 var valcol3=["active"];
 var valv3=["Y"];
 var getDatas3={beanName:bean3,valColumn:valcol3,valValue:valv3};
 var params13=JSON.stringify(getDatas3);
 var p3="rt_type";
 var selectedCol13="rt_typ_id,rt_typ_nm";
 CallDropDownService(params13,p3,selectedCol13);
 
 var beans="PaymentTypeBean";
 var valcols=["active"];
 var valvs=["Y"];
 var getDatass={beanName:beans,valColumn:valcols,valValue:valvs};
 var params1s=JSON.stringify(getDatass);
 var ps="pay_type";
 var selectedCol1s="id,type";
 CallDropDownService(params1s,ps,selectedCol1s); 
 

 
 var bean7="PartyViewBean";
 var valcol7=["active","party_typ"];
 var valv7=["Y","SC"];
 var getDatas7={beanName:bean7,valColumn:valcol7,valValue:valv7};
 var params17=JSON.stringify(getDatas7);
 var p7="kar_cd";
 var selectedCol17="party_id,party_nm";
 CallDropDownService(params17,p7,selectedCol17);
 
 var beans="OtherHeadsHdr";
 var valcols=["active","hd_typ"];
 var valvs=["Y","SA"];
 var getDatass={beanName:beans,valColumn:valcols,valValue:valvs};
 var params1s=JSON.stringify(getDatass);
 var ps="miscH";
 var selectedCol1s="oh_id,description";
 CallDropDownService(params1s,ps,selectedCol1s);
 


// $('#party_ids').material_select();
});

</script>

<script type="text/javascript">
function validation1()
{
     //alert("hiii");
  var trn_dt=document.getElementById("doc_dt");
  var name=document.getElementById("kar_cd");
  var zero=document.getElementById("item_typ_id");

    errors=[];
   // Dropdown1(associate_typ,"Please Select");
    Dropdown16(name,"Please Select an ");
    checkBlank(trn_dt,"Bill Date");
   // Dropdown4(item_name,"Please Select an ");

    params=["desgClass","#item_typ_id","#item_id","#qty1"];
    params1=["sexy","#item_id","#qty"];
    validationForDetail(params);
    validationForDetail(params1);

    return finalCheck();            
    
    }

</script>
<script type="text/javascript">

// $(window).load(function() {
// 	var pxx=$('#cloneRow').clone();
// 	$('#addRowValue').html(pxx);
	
// 	});
 </script>
 <script type="text/javascript">
 $(document).on("keypress",function(event){
 //$(":input").keypress(function(event){
	   if (event.which == '10' || event.which == '13') {
	        event.preventDefault();
	        $('#uom_id').focus();
	       // addNewRow();
	       // fetchItemTypeAndItemFromDesign(this);
	    }
	});
 // });
 </script> 
 <script type="text/javascript">
 function EditThis(str)
 {
	// alert(str);
	 
 }
function validation1()
{
     //alert("hiii");
  var trn_dt=document.getElementById("pck_sl_dt");
  var name=document.getElementById("party_id");

    errors=[];
   // Dropdown1(associate_typ,"Please Select");
    Dropdown1(name,"Please Select an ");
    checkBlank(trn_dt,"Bill Date");

    params=["pivotElement","#qty","#rate"];
    validationForDetail(params);

    return finalCheck();            
    
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
		    	var ids='#'+x.id;
		    	//$(x).closest('tr').find('#nuom_id').val('');
		    	$(x).closest('tr').find(ids).val('');
		    	//$(x).closest('tr').find('#rate').val('');
		    }	
		}
	
}

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
            	    url: "../../../fetchKarigarhReceive",
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
        	 var d = $.Deferred();
        	 //alert(JSON.stringify(item));
        var p=JSON.parse(JSON.stringify(item));      
            return $.ajax({
                type: "POST",
                async: false,
                url: "../../../rcv_karUpdate",
                contentType: "application/json",
                dataType: 'json',
                //var x = $('#form1').serializeJSON();
    			//var val = JSON.stringify(item.itm_nm),
    			
                data: JSON.stringify(item),
                success: function (data) {
             	  // d.resolve(JSON.parse(JSON.stringify(data)));
              	  location.reload();
                }
            });
        },
        
        },
     

    fields: [
             {name:"hid" , css:"hide"},
        { name: "doc_no", type:"text",width:60,title: "Reced. No"},
        { name: "doc_dt", type: "text", width: 70 ,title : "Reced. Date"  },
        { name: "ref_no", type:"text",width:60,title: "Issue No"},
        { name: "ref_dt", type: "text", width: 70 ,title : "Isuue Date"  },
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
                $.get('../../../resources/ajax/getIssueNoViewFromButton.jsp', {hid: item.hid , id: item.id}, function (response)
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


<script>
function EditThis(str)
{
	// alert(str);
	 
	 $.get("../../ajax/getIssueNoFromButton.jsp" , {hid : str}, function(data , status){
		 //alert(data);
		 $(".sexy").material_select();
		 $('#copyDiv').html(data);
			
			//getAutoFocus();
			$('#hid').focus();
		 
	 });
	 
	 
}
	function getKarigarhData(param) {
		//alert("hello Karigarh");
		
		$.get("../../ajax/getKarigarhDetails.jsp", {kar_cd : param}, function(data, status) {
			$('#insertDiv').html(data);
			//alert(data);
			//getAutoFocus();

		});
			}

// 	// Basic example
// 	$(document).ready(function () {
// 	  $('#dtBasicExample').DataTable({
// 	    "paging": false // false to disable pagination (or any other option)
// 	  });
// 	  $('.dataTables_length').addClass('bs-select');
// 	});
	
	
	$(document).ready(function(){
	    $("dtBasicExample").click(function(){
	       // alert("hello");
	        //"paging": false 
	    });
	    $('.dataTables_length').addClass('bs-select');
	});
	
	
	
</script>
 

    </head>
    <body class="fixed-sn mdb-skin-custom ">
<%@include file="../common/menu.jsp" %>

        
        <main>
         <center>
             <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2" style="width:100%;">Received from Karigarh</div>
         
          <ul class="nav nav-tabs nav-justified indigo" role="tablist">
    <li class="nav-item">
        <a class="nav-link active" data-toggle="tab" href="#panel5" role="tab"><i class="fa fa-plus"></i> Add Receive Karigarh</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#panel6" role="tab"><i class="fa fa-edit"></i> View/Update Receive Karigarh</a>
    </li>
   
</ul>
        <div class="tab-content">
                
                <div class="tab-pane fade in show active" id="panel5" role="tabpanel">
                
               
<!--  <div class="main-wrapper"> -->
<!--           <div class="container-fluid"> -->
     
<!--     <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2"> Receive to Karighar </div> -->
       <div class="card card-body">
       
       <table class="table table-hover">
						<tr>
							<th>Karigarh: <select name="kar_cd" id="kar_cd"
								class="mdb-select  colorful-select dropdown-primary "
								onchange="getKarigarhData(this.value);">
									<option value='0'>---select Option---</option>
							</select>
							</th>
						</tr>
					</table>
					<div id="insertDiv" style=" text-align: center" align="center"></div>
                                    </div>
                                    
                                    
                    <br>
                                   
                     <div class="row justify-content-start border-warning" id="copyDiv">
                     
                     </div>
                   

                
<!--                     <td colspan="14" align="center"> <input type="submit" class="btn btn-primary btn-sm" value="submit" /> -->

      
                
         
       </div>  
        <div class="tab-pane fade" id="panel6" role="tabpanel">
        <br>
        <div id="jsGrid"></div>  
          </div>
          </div>
                 </div>
                
      

       <br>
                 
                     
    </div>        
<%--        </form> --%>
     
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
                <h5 class="modal-title" id="exampleModalLabel">Update Receive From Karigarh..</h5>
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
       
       <div id="addRowValue" style="display:none;"></div>
         </main>
    </body>
    <%@include file="../common/footer.jsp" %>
</html>
