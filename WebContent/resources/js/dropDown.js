

function CallDropDownService(obj,id,selectedCol,allTag)
{
	var p='#'+id;
	//alert("p is:- "+p);
	
	 $.ajax({

			beforeSend : function(xhrObj) {
				xhrObj.setRequestHeader("Content-Type", "application/json");
				xhrObj.setRequestHeader("Accept", "application/json");
			},
			type : "POST",
			url : "../../../getSelectData",

			data : obj,
			dataType : 'json',

			success : function(data, textStatus) {
				//alert('request successful');
				var cols=selectedCol.split(',');
				//alert(cols[0]);
				//var m="<option value='0'>---select Option---</option>";
				$(p).find('option').remove().end().append('<option value="0">-select-</option>');
				if(allTag=='Y')
					{
					//alert("helloo");
					$('<option value="">---ALL---</option>').appendTo(p);
					
					}
				//$(m).appendTo(p);
				 $.each(data,function(i,data){
				           //  alert(data.itm_id+":"+data.itm_nm);
					 //JSONObject json = (JSONObject) JSONSerializer.toJSON(data); 
				      //  alert(JSON.stringify(data));     
					// JSONObject jsonObj = new JSONObject(JSON.stringify(data));      
					 var val= data[cols[0]];
					 var show= data[cols[1]];
					// alert(val + 'the data is '+show);
				             var div_data="<option value='"+val+"'>"+show+"</option>";
				           // alert(div_data);
				            $(div_data).appendTo(p); 
				            });
				    $(p).material_select();
			},
			error : function(xhr, textStatus, errorThrown) {
//	 			window.location
//	 					.replace("http://localhost:8080/SpringTest/login.jsp");
				alert("error");

			}
		});

}

function CallDropDownService1(obj,id,selectedCol,allTag)
{
	var p='#'+id;
	//alert("p is:- "+p);
	
	 $.ajax({

			beforeSend : function(xhrObj) {
				xhrObj.setRequestHeader("Content-Type", "application/json");
				xhrObj.setRequestHeader("Accept", "application/json");
			},
			type : "POST",
			url : "../../../getSelectData",

			data : obj,
			dataType : 'json',

			success : function(data, textStatus) {
				//alert('request successful');
				var cols=selectedCol.split(',');
				//alert(cols[0]);
				//var m="<option value='0'>---select Option---</option>";
				$(p).find('option').remove();//.end().append('<option value="0">-select-</option>');
				if(allTag=='Y')
					{
					//alert("helloo");
					$('<option value="">---ALL---</option>').appendTo(p);
					
					}
				//$(m).appendTo(p);
				 $.each(data,function(i,data){
				           //  alert(data.itm_id+":"+data.itm_nm);
					 //JSONObject json = (JSONObject) JSONSerializer.toJSON(data); 
				       // alert(JSON.stringify(data));     
					// JSONObject jsonObj = new JSONObject(JSON.stringify(data));      
					 var val= data[cols[0]];
					 var show= data[cols[1]];
					// alert(val + 'the data is '+show);
				             var div_data="<option value='"+val+"'>"+show+"</option>";
				           // alert(div_data);
				            $(div_data).appendTo(p); 
				            });
				    $(p).material_select();
			},
			error : function(xhr, textStatus, errorThrown) {
//	 			window.location
//	 					.replace("http://localhost:8080/SpringTest/login.jsp");
				alert("error");

			}
		});

}

function CallDropDownServiceForConcat(obj,id,selectedCol,allTag)
{
	var p='#'+id;
	//alert("p is:- "+p);
	
	 $.ajax({

			beforeSend : function(xhrObj) {
				xhrObj.setRequestHeader("Content-Type", "application/json");
				xhrObj.setRequestHeader("Accept", "application/json");
			},
			type : "POST",
			url : "../../../getSelectData",

			data : obj,
			dataType : 'json',

			success : function(data, textStatus) {
				//alert('request successful');
				var cols=selectedCol.split(',');
				//alert(cols[0]);
				//var m="<option value='0'>---select Option---</option>";
				$(p).find('option').remove().end().append('<option value="0">-select-</option>');
				if(allTag=='Y')
					{
					//alert("helloo");
					$('<option value="">---ALL---</option>').appendTo(p);
					
					}
				//$(m).appendTo(p);
				 $.each(data,function(i,data){
				           //  alert(data.itm_id+":"+data.itm_nm);
					 //JSONObject json = (JSONObject) JSONSerializer.toJSON(data); 
				      //  alert(JSON.stringify(data));     
					// JSONObject jsonObj = new JSONObject(JSON.stringify(data));      
					 var val= data[cols[0]];
					 var temp=data[cols[1]];
					 var temp1=data[cols[2]];
					 var show=temp+' '+temp1 ;
					// alert(val + 'the data is '+show);
				             var div_data="<option value='"+val+"'>"+show+"</option>";
				           // alert(div_data);
				            $(div_data).appendTo(p); 
				            });
				    $(p).material_select();
			},
			error : function(xhr, textStatus, errorThrown) {
//	 			window.location
//	 					.replace("http://localhost:8080/SpringTest/login.jsp");
				alert("error");

			}
		});

}

function CallDropDownServiceForDetail(obj,id,selectedCol,allTag,thisPointer,idName)
{
	var px='#'+idName;
	var pxx=$(thisPointer).closest('tr').find(px);
	//alert("p is:- "+px);
	
	 $.ajax({

			beforeSend : function(xhrObj) {
				xhrObj.setRequestHeader("Content-Type", "application/json");
				xhrObj.setRequestHeader("Accept", "application/json");
			},
			type : "POST",
			url : "../../../getSelectData",

			data : obj,
			dataType : 'json',

			success : function(data, textStatus) {
				//alert('request successful');
				var cols=selectedCol.split(',');
				//alert(cols[0]);
				//var m="<option value='0'>---select Option---</option>";
				$(pxx).find('option').remove().end().append('<option value="0">-select-</option>');
				if(allTag=='Y')
					{
					//alert("helloo");
					$('<option value="">---ALL---</option>').appendTo(pxx);
					
					}
				//$(m).appendTo(p);
				 $.each(data,function(i,data){
				           //  alert(data.itm_id+":"+data.itm_nm);
					 //JSONObject json = (JSONObject) JSONSerializer.toJSON(data); 
				      //  alert(JSON.stringify(data));     
					// JSONObject jsonObj = new JSONObject(JSON.stringify(data));      
					 var val= data[cols[0]];
					 var temp=data[cols[1]];
					 var temp1=data[cols[2]];
					 var show=temp ;
					// alert(val + 'the data is '+show);
				             var div_data="<option value='"+val+"'>"+show+"</option>";
				           // alert(div_data);
				            $(div_data).appendTo(pxx); 
				            });
				    $(pxx).material_select();
			},
			error : function(xhr, textStatus, errorThrown) {
//	 			window.location
//	 					.replace("http://localhost:8080/SpringTest/login.jsp");
				alert("error");

			}
		});

}


