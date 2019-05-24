<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<script src="../../../resources/js/purchase.js"></script>
<script>
	function getAutoFocus() {
		$(".qtyClass").each(function() {
			//alert(1);
			//var x=$(this).val();//miscHamt
			$(this).focus();
			//document.getElementById("qty").focus();

		});
	}

	$(function() {
		$('img').on('click', function() {
			$('.enlargeImageModalSource').attr('src', $(this).attr('src'));
			$('#enlargeImageModal').modal('show');
		});
	});

	function calqtydiff(param, x) {
		var sum1 = 0.00, sum2 = 0.00, sum3 = 0.00, sum4 = 0.00, sum5 = 0.00, sumqty = 0.00, sum7 = 0.00, sum8 = 0.00, paramval = 0.00, sumrqty = 0.00, sumhqty = 0.00;
		var qty1 = $(x).closest('tr').find('#qty1').val();
		var qty = $(x).closest('tr').find('#qty').val();
		//if(qty < qty1){
		//alert(param);
		//alert("qty1==> "+qty1);
		// var amt=parseFloat(qty1)-parseFloat(param);
		// $('#diffqty').val(amt);
		var pqty = parseFloat(qty1);
		var miscH = $('#miscH').val();
		var rs = ((parseFloat(miscH) * parseFloat(param)) / parseFloat(qty1));
		// alert(rs);
		//paramval = parseFloat(paramval) + parseFloat(param);

		//alert(paramval);

		$(".rqtyClass").each(function() {
			//var x=$(this).val();
			var z = $(this).val() == '' ? 0.00 : $(this).val();
			sumrqty = parseFloat(sumrqty) + parseFloat(z);

		});
		// alert("sumrqty "+sumrqty);

		$(".qtyClass").each(function() {
			//var x=$(this).val();
			var y = $(this).val() == '' ? 0.00 : $(this).val();
			sumqty = parseFloat(sumqty) + parseFloat(y);

		});
		// alert("sumqty "+sumqty);

		$(".hqtyClass").each(function() {
			//var x=$(this).val();
			var z = $(this).val() == '' ? 0.00 : $(this).val();
			sumhqty = parseFloat(sumhqty) + parseFloat(z);

		});

		$("input[name='miscHamt1[]']")
				.each(
						function() {
							//var x=$(this).val();//miscHamt
							var x = $(this).val() == '' ? 0.00 : $(this).val();
							var q1 = 0.00;
							// alert("sumqty "+sumqty);
							if (sumrqty > 0) {
								q1 = (parseFloat(x) * parseFloat(sumrqty))
										/ parseFloat(sumqty);
								//alert("the x:-"+x+" the param is:-"+sumrqty);
							} else {
								q1 = (parseFloat(x) * parseFloat(sumqty))
										/ parseFloat(sumhqty);
								//alert("the x:-"+x+" the param is:-"+sumrqty);
							}
							//alert(x);
							//alert("q1 "+q1);
							//$(this).val(q1);
							$(this).closest('tr').find('#miscHamt').val(
									Math.round(q1));

							var o_gst_per = $(this).closest('tr').find(
									'#o_gst_per').val();
							var res = (parseFloat(q1) * parseFloat(o_gst_per)) / 100;
							$(this).closest('tr').find('#o_cgst_amt').val(
									res / 2);
							$(this).closest('tr').find('#o_sgst_amt').val(
									res / 2);
							//alert("res " +res);
							var tot_amt = parseFloat(q1) + parseFloat(res);
							//alert("tot_amt"+tot_amt);
							$(this).closest('tr').find('#o_amt').val(tot_amt);
						});
	}
</script>

<script>
	function qtyValidate(value, x) {
		// alert("1 value-" + value);
		var qty1 = $(x).closest('tr').find('#qty1').val();
		//alert("qty1->"+qty1);

		if (parseInt(value) > parseInt(qty1)) {
			alert("Return quantity cannot be more than purchase quantity......");
			$(this).closest('tr').find('#qty').val("");
		}
	}
</script>




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
	String doc_no = request.getParameter("doc_no");
	String pdt = "";
	System.out.println("doc_no is:-" + doc_no);
	MyConnection mc = new MyConnection();
	Connection conn = mc.getConnection("adm_retail");
	Statement st = null;
	Statement st1 = null;
	Statement st2 = null;
	UtilityHelper util = new UtilityHelper();
	String cid = "", cnm = "";
	st = conn.createStatement();
	st1 = conn.createStatement();
	st2 = conn.createStatement();
	String sql = "select date_format(trn_kar_issue_hd.doc_dt,'%Y-%m-%d')doc_dt,trn_kar_issue_hd.kar_cd,trn_kar_issue_hd.doc_no,mst_party.party_nm,trn_kar_issue_hd.hid from trn_kar_issue_hd inner join mst_party on (trn_kar_issue_hd.kar_cd=mst_party.party_id) where   trn_kar_issue_hd.doc_no='"
			+ doc_no + "'";
	String sql1 = "select a.id,a.desg_no,a.qty,a.uom_id,a.itm_typ_id,a.itm_id,i.itm_nm,it.itm_typ_nm,b.doc_no from trn_kar_isu_dt a join mst_fp_itm i on(i.itm_id=a.itm_id) join mst_itm_typ it on (a.itm_typ_id=it.itm_typ_id)join trn_kar_issue_hd b on(b.hid=a.hid) where b.doc_no='"
			+ doc_no + "'";

	// 					 String sql1="select d.*,(d.qty - ret_qty) as av_qty,d.basic_amt,d.gst_per,it.itm_typ_nm,i.itm_nm,d.cgst_amt, d.sgst_amt, d.igst_amt, d.basic_amt,d.qty,d.bar_code from trn_pur_hdr h join trn_pur_dtl d on(h.pur_id=d.pur_id) join mst_party p on(p.party_id=h.party_cd) join mst_design md on(md.tr_id=d.desg_id) join mst_fp_itm i on(d.itm_id=i.itm_id) left join mst_itm_typ it on(d.itm_typ_id=it.itm_typ_id) where h.pur_id='"+pur_id+"'";                    

	String sql2 = "select a.id,a.desg_no,a.qty,a.uom_id,a.itm_typ_id,a.itm_id,i.itm_nm,it.itm_typ_nm,b.doc_no from trn_kar_isu_prod a join mst_fp_itm i on(i.itm_id=a.itm_id) join mst_itm_typ it on (a.itm_typ_id=it.itm_typ_id) join trn_kar_issue_hd b on(b.hid=a.hid) where b.doc_no='"
			+ doc_no + "'";
	//                     System.out.println("SQL1==> "+sql1);
	//                     System.out.println("SQL2==> "+sql2);
	ResultSet rs1 = st.executeQuery(sql);
	ResultSet rs2 = st1.executeQuery(sql1);
	ResultSet rs3 = st2.executeQuery(sql2);
	rs1.next();
	//                 	double tot_amt=rs.getDouble("tot_amt");
	//                 	double tot_bas_amt=rs.getDouble("tot_bas_amt");
	//                 	pdt=rs.getString("doc_dt");
	//                 	double tot_dis_amt=rs.getDouble("tot_dis_amt");
	//                 	double tot_cgst_amt=rs.getDouble("tot_cgst_amt");
	//                 	double tot_sgst_amt=rs.getDouble("tot_sgst_amt");
	//                 	double tot_igst_amt=rs.getDouble("tot_igst_amt");
	//                 	double net_amt=rs.getDouble("net_amt");
	//                 	String purno=rs.getString("pur_no");
%>
<table>
	<tr>
		<th>Document No:</th>
		<td><input type="text" name="doc_no" id="doc_no"
			class="form-control" readonly value="<%=rs1.getString("doc_no")%>" />
			<input type="hidden" name="hid" value="<%=rs1.getString("hid")%>" />
		</td>
		<th>Document Date:</th>
		<td><input placeholder="Selected date" type="text" name="doc_dt"
			id="doc_dt" class="form-control datepicker" readonly
			value="<%=rs1.getString("doc_dt")%>"></td>

		<th>Karigar:</th>
<!-- 		<td><input type="text" name="doc_no" id="doc_no" -->
<%-- 			class="form-control" readonly value="<%=rs1.getString("party_nm")%>" /> --%>
			<td><select name="kar_cd" id="kar_cd"
						class="browser-default sexy">
							<option value="<%=rs1.getString("kar_cd")%>"><%=rs1.getString("party_nm")%></option>
					</select>
		</td>
	</tr>

</table>

<div class="row justify-content-start border-warning">
	<div class="row">
	
		<div align="center" class="col-sm-6">
		<h>Raw Material</h>
			<table class="table-bordered border-warning table-responsive">
				<%
					MyConnection mycon = new MyConnection();
					Connection newcon = mycon.getConnection("adm_retail");
					String qry = "SELECT uom_nm FROM mst_uom where active='Y'";
					String db = "adm_retail";
					ResultSet rsnew = mycon.getResultSet(qry, db);
				%>
				<tr>
					<th>Design
					<th>Item Type
					<th>Item <%
						while (rsnew.next()) {
					%>
					<th><%=rsnew.getString("uom_nm")%> <%
 	}
 	rsnew.beforeFirst();
 %>
				</tr>


				<%
					while (rs2.next()) {
						System.out.println("A=> " + rs2.getString("qty"));

						int x = rs2.getInt("qty");
						String y = rs2.getString("uom_id");
				%>

				<tr>


					<td><input type="text" name="did[]" id="did"
						style="width: 100px;  display: none"
						value="<%=rs2.getString("id")%>" /> <input type="text"
						name="desg_no[]" id="desg_no"
						value="<%=rs2.getString("desg_no")%>" style="width: 100px"
						readonly class="desgClass" /></td>
					<td><select name="itm_typ_id[]" id="item_typ_id"
						class="browser-default sexy">
							<option value="<%=rs2.getString("itm_typ_id")%>"><%=rs2.getString("itm_typ_nm")%></option>
					</select></td>
					
					<td><select name="itm_id[]" id="item_id"
						value="<%=rs2.getString("itm_nm")%>" class="browser-default">
							<option value="<%=rs2.getString("itm_id")%>"><%=rs2.getString("itm_nm")%></option>
					</select></td>
					<td style="width: 50px; display: none"><input type="text" display: none"
						name="qty[]" id="qty" value="<%=rs2.getString("qty")%>">

					</td>
					<%
						String sid = "";
							while (rsnew.next()) {
								sid = sid + rsnew.getString("uom_nm") + "-";
							}
							rsnew.beforeFirst();
							System.out.println("SID==> " + sid);
					%>
					<%
						while (rsnew.next()) {
								String temp = rsnew.getString("uom_nm");
								System.out.println("1==> " + temp.equalsIgnoreCase(y));
								if (temp.equalsIgnoreCase(y)) {
					%>
					<td><input type="text" name="nuom_id[]"
						id="<%=rs2.getString("uom_id")%>" value="<%=x%>" class="cleanData"
						onkeyup="checkMinus(this.value,this);"
						onchange="putUomData(this.id,this,this.value,'<%=sid%>');"
						style="width: 70px; text-align: right;" /></td>
					<%
						} else {
					%>

					<td><input type="text" name="nuom_id[]"
						id="<%=rs2.getString("uom_id")%>" class="cleanData"
						onkeyup="checkMinus(this.value,this);"
						onchange="putUomData(this.id,this,this.value,'<%=sid%>');"
						style="width: 70px; text-align: right;" /></td>
					<%
						}
							}
					%>
					<td style="width: 50px; display: none"><input type="text"
						name="uom_id[]" id="uom_id" value="<%=rs2.getString("uom_id")%>"
						style="width: 50px; text-align: right; display: none"></td>
				</tr>
				<%
					}
				%>
				<tr id="insertBefore" class="table-info">
					<td colspan="9">
				</tr>
			</table>
		</div>




		<div style="float: right" class="col-sm-6">
		<h style="margin-left: 100px;">Finish Goods</h>
			<table class="table-bordered border-warning table-responsive">
				<tr>
					<th>Design
					<th>Item Type
					<th>Item <%
						rsnew.beforeFirst();
						while (rsnew.next()) {
					%>
					<th><%=rsnew.getString("uom_nm")%> <%
 	}
 	rsnew.beforeFirst();
 %>
				</tr>
				<%
					while (rs3.next()) {
						int x1 = rs3.getInt("qty");
						String y1 = rs3.getString("uom_id");
				%>

				<tr>
					<td><input type="text" name="pid[]" id="pid"
						style="width: 100px; display: none"
						value="<%=rs3.getString("id")%>" /> <input type="text"
						name="desg_no1[]" id="desg_no"
						value="<%=rs3.getString("desg_no")%>" style="width: 100px"
						readonly class="desgClass" /></td>
					<td><select name="itm_typ_id1[]" id="item_typ_id"
						class="browser-default" onchange="getItems(this,this.value)">
							<option value="<%=rs3.getString("itm_typ_id")%>"><%=rs3.getString("itm_typ_nm")%></option>
					</select></td>
					<td><select name="itm_id1[]" id="item_id"
						class="browser-default">
							<option value="<%=rs3.getString("itm_id")%>"><%=rs3.getString("itm_nm")%></option>
					</select></td>
					<td style="width: 50px; display: none"><input type="text"
						name="qty1[]" id="qty1" value='<%=rs3.getString("qty")%>' /> <%
 	String bid = "";
 		rsnew.beforeFirst();
 		while (rsnew.next()) {
 			bid = bid + rsnew.getString("uom_nm") + "-";
 		}

 		System.out.println("SID==> " + bid);
 %> <%
 	rsnew.beforeFirst();
 		while (rsnew.next()) {
 			String temp = rsnew.getString("uom_nm");
 			System.out.println("1==> " + temp.equalsIgnoreCase(y1));
 			if (temp.equalsIgnoreCase(y1)) {
 %>
					<td><input type="text" name="nuom_id1[]"
						id="<%=rsnew.getString("uom_nm")%>" value="<%=x1%>"
						onkeyup="checkMinus(this.value,this);"
						onchange="putUomData1(this.id,this,this.value,'<%=bid%>');"
						class="cleanData" style="width: 70px; text-align: right;" /> <%
 	} else {
 %>
					<td><input type="text" name="nuom_id1[]"
						id="<%=rsnew.getString("uom_nm")%>" value=""
						onkeyup="checkMinus(this.value,this);"
						onchange="putUomData1(this.id,this,this.value,'<%=bid%>');"
						class="cleanData" style="width: 70px; text-align: right;" /> <%
 	}

 		}
 %>
					<td style="width: 50px; display: none"><input type="text"
						name="uom_id1[]" id="uom_id" value="<%=rs3.getString("uom_id")%>"
						style="width: 50px; text-align: right; display: none"></td>
				</tr>

				<%
					}
				%>

				<tr id="insertBefore1" class="table-info">
					<td colspan="9">
				</tr>

			</table>
		</div>

	</div>
	<div style="position: relative;" align="center">
		<table>
			<tr>
				<td colspan="14" align="center"><input type="submit"
					class="btn btn-primary btn-sm" value="submit" />
			</tr>
		</table>
	</div>

</div>
