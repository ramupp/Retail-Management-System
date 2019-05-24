<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<script src="../../../resources/js/purchase.js"></script>


<script src="../../../resources/js/validation.js"></script> 


<script type="text/javascript">

function check(param) {
		//alert(param);
		var chbox = '#' + param;
		var txarea = document.getElementById(param).value;
		//alert(txarea);
		if ($(chbox).prop("checked") == true) { 	
			//alert(chbox);
			document.getElementById(txarea).value = 'true';     

		} else if ($(chbox).prop("checked") == false) { 	
			//alert(chbox);
			document.getElementById(txarea).value = 'false';

		}
	}
	
	
// 	function isCheckBoxGroupHasValue(x)
// 	{
// 		var sum3=0.0;
// 		var p="."+x+":checkbox:checked";
// 		var m=$(p).length;
// 		//alert(m);
// 		if(parseInt(m)==parseInt("0"))
// 			{
	
// 			return 0;
// 			}else{return m;}
		
// 	}
</script>



<script>
	function qtyValidate(value, x) {
		// alert("1 value-" + value);
		var qty1 = $(x).closest('tr').find('#qty1').val();
		//alert("qty1->"+qty1);

		if (parseInt(value) > parseInt(qty1)) {
			alert("Return quantity cannot be more than purchase quantity......");
			$(this).closest('tr').find('#qty').val("0");
		}
	}
</script>

<script>
	function getFinalValues() {
		//alert(param);
		var sum1 = 0.00, sum2 = 0.00, sum3 = 0.00, sum4 = 0.00, sum5 = 0.00, sum6 = 0.00, sum7 = 0.00, sum8 = 0.00;

		$(".basClass").each(function() {
			//var x=$(this).val();//miscHamt
			var x = $(this).val() == '' ? 0.00 : $(this).val();

			sum1 = parseFloat(sum1) + parseFloat(x);

		});
		//alert(sum1);

		$(".ocgstClass").each(function() {
			//var x=$(this).val();
			var x = $(this).val() == '' ? 0.00 : $(this).val();

			sum2 = parseFloat(sum2) + parseFloat(x);
			// alert(sum1);
		});
		$(".disClass").each(function() {
			//var x=$(this).val();
			var x = $(this).val() == '' ? 0.00 : $(this).val();

			sum6 = parseFloat(sum6) + parseFloat(x);
			// alert(sum1);
		});

		$(".osgstClass").each(function() {
			//var x=$(this).val();
			var x = $(this).val() == '' ? 0.00 : $(this).val();

			sum3 = parseFloat(sum3) + parseFloat(x);
			// alert(sum1);
		});

		$(".oigstClass").each(function() {
			//var x=$(this).val();
			var x = $(this).val() == '' ? 0.00 : $(this).val();

			sum4 = parseFloat(sum4) + parseFloat(x);
			// alert(sum1);
		});

		$(".oamtClass").each(function() {
			//var x=$(this).val();
			var x = $(this).val() == '' ? 0.00 : $(this).val();

			sum5 = parseFloat(sum5) + parseFloat(x);
			// alert(sum1);
		});
		//alert(sum1+"-"+tot_dis_amt+"-"+sum2+"-"+sum3+"-"+sum4+"-"+sum5);
		$('#finBasic').val(parseFloat(sum1));
		$('#fin_dis_amt').val(parseFloat(sum6));
		$('#fin_cgst_amt').val(parseFloat(sum2));
		$('#fin_sgst_amt').val(parseFloat(sum3));
		$('#fin_igst_amt').val(parseFloat(sum4));
		$('#net_amt').val(parseFloat(sum5));
	}
</script>


<!--  <script> 
 
//  $(document).ready(function() {
//     $('.mdb-select').material_select();
   
//    $('.datepicker').pickadate({
  	
//   	  format: 'yyyy-mm-dd'
//   	}); 
  
</script> -->

<script>
	function calculateAmount(value, y) {
		//alert(value+'-'+y);
		var amt = $(y).closest('tr').find('#o_amt').val();
		//alert(amt);
		var result = parseFloat(amt) + parseFloat(value);
		//alert(result);
		$(y).closest('tr').find('#o_amt').val(result);
	}
</script>
<%
	String mid = "", mnm = "", str = "", ap = "", ep = "", dp = "", vp = "", rnm = "";
	try {
		String role_id = request.getParameter("role_id");
		MyConnection mc = new MyConnection();
		Connection conn = mc.getConnection("adm_retail");
		Statement st = null;
		st = conn.createStatement();
		ResultSet rsx = st
				.executeQuery("SELECT d.role_dtl_id,m.menu_id,m.menu_nm,d.add_per,d.edit_per,d.delete_per,d.view_per,h.role_nm from adm_menu m join adm_role_dt d on(m.menu_id=d.menu_id) join adm_role_hd h on(h.role_id=d.role_id) where parent_menu <> 0 and d.role_id="
						+ role_id
						+ " group by m.menu_id order by m.menu_order");
%>

<%
	while (rsx.next()) {
			mid = rsx.getString("menu_id");
			mnm = rsx.getString("menu_nm");
			ap = rsx.getString("add_per");
			ep = rsx.getString("edit_per");
			dp = rsx.getString("delete_per");
			vp = rsx.getString("view_per");
			rnm = rsx.getString("role_nm");
			System.out.println("MID= "+mid);
			System.out.println("MNM= "+mnm);
%>
 
<table class="custom-control custom-checkbox">
	<tr>
	
		<td width="700px" colspan="7">
		<input type="hidden" value="<%=rsx.getInt("d.role_dtl_id")%>" name="role_dtl_id[]" />
		<input class="filled-in form-check-input X" type="checkbox" checked name="menuId[]" id="checkbox-<%=mid%>" value="<%=mid%>"> 
			<label for="checkbox-<%=mid%>" class="form-check-label" id="<%=mid%>"><%=mnm%></label>

		</td>
		<td>
			<%
				if (ap.equalsIgnoreCase("true")) {
			%> 
			<input type="checkbox"
			 class="filled-in form-check-input A" name="" id="checkbox-add<%=mid%>" value="add<%=mid%>" checked
			onclick="check(this.id);">
			<label for="checkbox-add<%=mid%>" class="form-check-label">Add</label> 
			 <textarea style="display: none;" id="add<%=mid%>" name="addId[]">true</textarea>
			 <%
 } else {
 %> 
 			<input type="checkbox" class="filled-in form-check-input A" name="" id="checkbox-add<%=mid%>" value="add<%=mid%>" onclick="check(this.id);"> 
 			<label for="checkbox-add<%=mid%>" class="form-check-label">Add</label> 
 				<textarea style="display: none;" id="add<%=mid%>" name="addId[]">false</textarea>
			<%
 	}
 %> 
 
			
		</td>

		<td>
			<%
				if (ep.equalsIgnoreCase("true")) {
			%> <input type="checkbox"
			checked="checked" class="filled-in form-check-input B" id="checkbox-edit<%=mid%>" value="edit<%=mid%>" onclick="check(this.id);">
			<label for="checkbox-edit<%=mid%>" class="form-check-label">Edit</label>  
			 <textarea style="display: none;" id="edit<%=mid%>" name="editId[]">true</textarea>
	<%
 	} else {
 %> <input
			type="checkbox" class="filled-in form-check-input B" name="" id="checkbox-edit<%=mid%>" value="edit<%=mid%>" onclick="check(this.id);"> 
			<label for="checkbox-edit<%=mid%>" class="form-check-label">Edit</label> 
			 <textarea style="display: none;" id="edit<%=mid%>" name="editId[]">false</textarea>
	<%
 	}
 %> 

		</td>
		<td>
			<%
				if (dp.equalsIgnoreCase("true")) {
			%> <input type="checkbox"
			checked="checked" class="filled-in form-check-input C" name="" id="checkbox-del<%=mid%>" value="del<%=mid%>" onclick="check(this.id);"> 
			<label for="checkbox-del<%=mid%>" class="form-check-label">Delete</label>
			<textarea style="display: none;" id="del<%=mid%>" name="deleteId[]">true</textarea>
<%
 	} else {
 %> <input
			type="checkbox" class="filled-in form-check-input C" name="" id="checkbox-del<%=mid%>" value="del<%=mid%>" onclick="check(this.id);"> 
			<label for="checkbox-del<%=mid%>" class="form-check-label">Delete</label>
			<textarea style="display: none;" id="del<%=mid%>" name="deleteId[]">false</textarea>
			<%
 	}
 %>  
		</td>
		<td>
			<%
				if (vp.equalsIgnoreCase("true")) {
			%> <input type="checkbox"
			checked="checked" class="filled-in form-check-input D" name="" id="checkbox-view<%=mid%>" value="view<%=mid%>" onclick="check(this.id);"> 
			<label for="checkbox-view<%=mid%>" class="form-check-label">View</label>
			<textarea style="display: none;" id="view<%=mid%>" name="viewId[]">true</textarea>
			<%
 	} else {
 %> <input
			type="checkbox" class="filled-in form-check-input D" name="" id="checkbox-view<%=mid%>" value="view<%=mid%>" onclick="check(this.id);"> 
			<label for="checkbox-view<%=mid%>" class="form-check-label">View</label>
			<textarea style="display: none;" id="view<%=mid%>" name="viewId[]">false</textarea>
			<%
 	}
 %>  
		</td>
	</tr>

</table>

<%
	}
%>
<table>
	<tr>


		<label for="r_nm" class="grey-text font-weight-light">Enter	Role Name</label>
		<input type="text" name="roleNm" id="r_nm" value="<%=rnm%>"	class="form-control">
		</td>


	</tr>
</table>



<%
	} catch (SQLException se) {
		se.printStackTrace();
	}
%>






