<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
 <script src="../../../resources/js/purchase.js"></script> 
 <script>
function getAutoFocus()
{
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

 function calqtydiff(param,x)
 {
	 var sum1=0.00,sum2=0.00,sum3=0.00,sum4=0.00,sum5=0.00,sumqty=0.00,sum7=0.00,sum8=0.00,paramval=0.00,sumrqty=0.00,sumhqty=0.00;
	 var qty1=$(x).closest('tr').find('#qty1').val();
	 var qty=$(x).closest('tr').find('#qty').val();
	 //if(qty < qty1){
	 //alert(param);
	 //alert("qty1==> "+qty1);
	// var amt=parseFloat(qty1)-parseFloat(param);
	// $('#diffqty').val(amt);
	 var pqty=parseFloat(qty1);
	 var miscH=$('#miscH').val();
	 var rs=((parseFloat(miscH) * parseFloat(param)) / parseFloat(qty1));
	// alert(rs);
	//paramval = parseFloat(paramval) + parseFloat(param);
	
	//alert(paramval);
	
	 $(".rqtyClass").each(function() {
	 //var x=$(this).val();
	 var z= $(this).val() == '' ? 0.00 : $(this).val();
	 sumrqty=parseFloat(sumrqty)+parseFloat(z);
	 
	});
	// alert("sumrqty "+sumrqty);
	 
	 $(".qtyClass").each(function() {
		 //var x=$(this).val();
		 var y= $(this).val() == '' ? 0.00 : $(this).val();
		 sumqty=parseFloat(sumqty)+parseFloat(y);
		 
		});
	// alert("sumqty "+sumqty);
	
	 $(".hqtyClass").each(function() {
		 //var x=$(this).val();
		 var z= $(this).val() == '' ? 0.00 : $(this).val();
		 sumhqty=parseFloat(sumhqty)+parseFloat(z);
		 
		});
	 
	 
	 $("input[name='miscHamt1[]']").each(function() {
		 //var x=$(this).val();//miscHamt
		 var x= $(this).val() == '' ? 0.00 : $(this).val();
		 var q1=0.00;
		// alert("sumqty "+sumqty);
		 if(sumrqty > 0){
			 q1=(parseFloat(x) * parseFloat(sumrqty))/parseFloat(sumqty);
				//alert("the x:-"+x+" the param is:-"+sumrqty);
		 }
		 else
			 {
			 q1=(parseFloat(x) * parseFloat(sumqty))/parseFloat(sumhqty);
				//alert("the x:-"+x+" the param is:-"+sumrqty);
			 }
		//alert(x);
		//alert("q1 "+q1);
		//$(this).val(q1);
		$(this).closest('tr').find('#miscHamt').val(Math.round(q1)); 
		
		var o_gst_per=$(this).closest('tr').find('#o_gst_per').val();
		var res= (parseFloat(q1) * parseFloat(o_gst_per))/100;
		$(this).closest('tr').find('#o_cgst_amt').val(res/2);
		$(this).closest('tr').find('#o_sgst_amt').val(res/2);
		//alert("res " +res);
		var tot_amt=parseFloat(q1) + parseFloat(res);
		//alert("tot_amt"+tot_amt);
		$(this).closest('tr').find('#o_amt').val(tot_amt);
		});
	 }
	 
	 
	 
 </script>
 
 <script>
 
 function qtyValidate(value,x)
 {
	// alert("1 value-" + value);
	 var qty1=$(x).closest('tr').find('#qty1').val();
	 //alert("qty1->"+qty1);
	 
	 if(parseInt(value)>parseInt(qty1))
		 {
		 alert("Return quantity cannot be more than purchase quantity......");
		 $(this).closest('tr').find('#qty').val("");
		 }
 }
 
 
 
 </script>
 
 <script>
 function getFinalValues()
 {
 	//alert(param);
 	var sum1=0.00,sum2=0.00,sum3=0.00,sum4=0.00,sum5=0.00,sum6=0.00,sum7=0.00,sum8=0.00;
 	
 	$(".basClass").each(function() {
 		 //var x=$(this).val();//miscHamt
 		 var x= $(this).val() == '' ? 0.00 : $(this).val();
 		 
 		 sum1=parseFloat(sum1)+parseFloat(x);
 		 
 		});
 	//alert(sum1);
 	
 	$(".ocgstClass").each(function() {
 		 //var x=$(this).val();
 		 var x= $(this).val() == '' ? 0.00 : $(this).val();
 		 
 		 sum2=parseFloat(sum2)+parseFloat(x);
 		// alert(sum1);
 		});
 	$(".disClass").each(function() {
		 //var x=$(this).val();
		 var x= $(this).val() == '' ? 0.00 : $(this).val();
		 
		 sum6=parseFloat(sum6)+parseFloat(x);
		// alert(sum1);
		});
 	
 	$(".osgstClass").each(function() {
 		 //var x=$(this).val();
 		 var x= $(this).val() == '' ? 0.00 : $(this).val();
 		 
 		 sum3=parseFloat(sum3)+parseFloat(x);
 		// alert(sum1);
 		});
 	
 	$(".oigstClass").each(function() {
 		 //var x=$(this).val();
 		 var x= $(this).val() == '' ? 0.00 : $(this).val();
 		 
 		 sum4=parseFloat(sum4)+parseFloat(x);
 		// alert(sum1);
 		});
 	
 	$(".oamtClass").each(function() {
 		 //var x=$(this).val();
 		 var x= $(this).val() == '' ? 0.00 : $(this).val();
 		 
 		 sum5=parseFloat(sum5)+parseFloat(x);
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
 
 

<script>
function calculateAmount(value,y)
{
	//alert(value+'-'+y);
	var amt=$(y).closest('tr').find('#o_amt').val();
 //alert(amt);
  var result = parseFloat(amt) + parseFloat(value);
 //alert(result);
 $(y).closest('tr').find('#o_amt').val(result);
}
	</script>
 <%
          
		String pur_id=request.getParameter("pur_id");
        String pdt="";
		System.out.println("pur_id is:-"+pur_id);
        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st= null;
                     Statement st1=null;
                     Statement st2=null;
                     UtilityHelper util=new UtilityHelper();
                    String cid = "", cnm = "";
                    st = conn.createStatement();
                    st1=conn.createStatement();
                    st2=conn.createStatement();
                    String sql="SELECT h.pur_id, h.pur_no, date_format(h.pur_dt,'%Y-%m-%d') pur_dt, h.inv_no, h.inv_dt,h.tot_bas_amt, h.tot_dis_amt, h.tot_cgst_amt, h.tot_sgst_amt,h.pay_terms, h.tot_igst_amt, h.party_cd,p.party_nm,h.tot_amt,h.tot_disc,h.tot_gst,h.net_amt FROM trn_pur_hdr h left join mst_party p on(p.party_id=h.party_cd) where h.active='Y' and h.pur_id='"+pur_id+"'";
                  //  String sql1="select d.*,(d.qty - ret_qty) as av_qty,md.desg_no,it.itm_typ_nm,i.itm_nm,d.basic_amt,d.gst_per,d.cgst_amt, d.sgst_amt, d.igst_amt, d.basic_amt,d.qty from trn_pur_hdr h join trn_pur_dtl d on(h.pur_id=d.pur_id) join mst_party p on(p.party_id=h.party_cd) join mst_design md on(md.tr_id=d.desg_id) join mst_fp_itm i on(d.itm_id=i.itm_id) join mst_itm_typ it on(d.itm_typ_id=it.itm_typ_id) where h.pur_id='"+pur_id+"' and h.vr_type='PURC'";
                	
					 String sql1="select d.*,(d.qty - ret_qty) as av_qty,d.basic_amt,d.gst_per,it.itm_typ_nm,i.itm_nm,d.cgst_amt, d.sgst_amt, d.igst_amt, d.basic_amt,d.qty,d.bar_code from trn_pur_hdr h join trn_pur_dtl d on(h.pur_id=d.pur_id) join mst_party p on(p.party_id=h.party_cd) join mst_design md on(md.tr_id=d.desg_id) join mst_fp_itm i on(d.itm_id=i.itm_id) left join mst_itm_typ it on(d.itm_typ_id=it.itm_typ_id) where h.pur_id='"+pur_id+"'";                    
                    
                    String sql2="SELECT o.*,oh.* FROM trn_pur_hdr h join pur_other_dtl o on(h.pur_id=o.pur_id) inner join mst_other_head oh on(oh.oh_id=o.oh_hid) where h.pur_id='"+pur_id+"'";
                    System.out.println("SQL1==> "+sql1);
                    System.out.println("SQL2==> "+sql2);
                	ResultSet rs = st.executeQuery(sql);	
                	rs.next();
                	double tot_amt=rs.getDouble("tot_amt");
                	double tot_bas_amt=rs.getDouble("tot_bas_amt");
                	pdt=rs.getString("pur_dt");
                	double tot_dis_amt=rs.getDouble("tot_dis_amt");
                	double tot_cgst_amt=rs.getDouble("tot_cgst_amt");
                	double tot_sgst_amt=rs.getDouble("tot_sgst_amt");
                	double tot_igst_amt=rs.getDouble("tot_igst_amt");
                	double net_amt=rs.getDouble("net_amt");
                	String purno=rs.getString("pur_no");
                	
                	
    %>
                					<table>
                					<tr>
                					<th>
                	                      Purchase No:
                	                        </th>
                	                        <td>
                	                         <input type="text" name="pur_no" id="pur_no" class="form-control" value="<%=rs.getString("pur_no") %>"/>
                	                        </td>
                	                <th>
                	                      Purchase Date:
                	                        </th>
                	                        <td>
                	                          <input placeholder="Selected date" type="text" name="pur_dt" id="pur_dt" class="form-control datepicker" value="<%=rs.getString(3) %>">
                	                        	
                	                        </td>
                	                      
                							   <th>
                	                       Vendor:
                	                        </th>
                	                        <td>
                	                          <select name="party_cd" id="party_cd" class="mdb-select  colorful-select dropdown-primary x">
                	                        <% 
                        String yy=util.getDropdownString("mst_party","party_id","party_nm",rs.getString("party_cd") );
                        out.print(yy);
                        %>
                	                        </select>
                	                        </td>
                	                        </tr>
                	                      
                							<tr>
                							<th>
                	                              Invoice No :
                	                            </th>

                	                            <td>
                	                                 
                	                        <input type="text" name="inv_no" id="inv_no" class="form-control" value="<%=rs.getString(4) %>"/>
                	                            </td>
                	                           
                	                            <th>
                	                                Invoice Date:
                	                            </th>

                	                            <td>
                	                          <input placeholder="Selected date" type="text" name="inv_dt" id="inv_dt" class="form-control datepicker" value="<%=rs.getDate(5) %>">
                	                        	</td>
                	                        	
                	                        	<th>
                	                              Payment Terms:
                	                            </th>

                	                            <td>
                	                                 
                	                        <input type="text" name="pay_terms" id="pay_terms" class="form-control" value="<%=rs.getString("pay_terms") %>"/>
                	                            </td>

                	                        </tr>
                	                 
                	                    </table>
<!--                 	                    </div> -->
<!--                 	                    <br> -->
<!--                 	                  <div class="row justify-content-start border-warning"> -->
                	                    <table class="" id="TableId">
                	                    <tr>
                	                   <td colspan="15" align="center"> <div class="row">
                    <div class="col">
                   <div class="" style="margin-top:10px">
                    <div style="background-color:orange;" class="card-header juicy-peach-gradient lighten-1 text-dark text-center z-depth-2"><p class="h5">Detail</p></div>
                   </div> 
                   </div>
                   </div></td>
                	                    </tr>
                	                    <tr style="width: 40%;">
                	                    
                	                    <th>Design 
                	                    <th>Item Type
                	                    <th>Item
                	                    <th>Quantity                	                   
                	                    <th>Rate
                	                    <th>Basic
                	                    <th>Discount(%)
                	                    <th>Discount Amt.
                	                    <th>GST(%)
                	                    <th>CGST Amt.
                	                    <th>SGST Amt.
                	                    <th>IGST Amt.
                	                    <th>Amount
                	                    </tr>
                	                    <%   ResultSet rs1 = st1.executeQuery(sql1);				
    						while (rs1.next()) {
    							
    							System.out.println("desg_id==> "+rs1.getString(5)+","+rs1.getString(24)+"--"+rs1.getString("desg_no"));
    							System.out.println("item_typ_id==> "+rs1.getString(6)+","+rs1.getString(25));
    							System.out.println("item_id==> "+rs1.getString(7)+","+rs1.getString(26));
    					
 %>
 
 
 					
                   <tr id="cloneRow">
                  <td style="display:none"><input type="text" value="<%=rs1.getString("d.qty")%>" name="hqty" id="hqty" class="hqtyClass"/></td>
                        
                          <td>
                	                          <select name="desg_id[]" id="desg_id" class="browser-default">
                	                        <% 
                        String yy1=util.getDropdownString("mst_design","desg_no","desg_no",rs1.getString("desg_no") );
                        out.print(yy1);
                        %>
                	                        </select>
                	                        </td>
                        
                        				 <td>
                	                          <select name="item_typ_id[]" id="item_typ_id" class="browser-default">
                	                        <% 
                        String yy2=util.getDropdownString("mst_itm_typ","itm_typ_id","itm_typ_nm",rs1.getString("itm_typ_id") );
                        out.print(yy2);
                        %>
                	                        </select>
                	                        </td>
                       
                        
                        
                         <td>
                	                          <select name="item_id[]" id="item_id" class="browser-default">
                	                        <% 
                        String yy3=util.getDropdownString("mst_fp_itm","itm_id","itm_nm",rs1.getString("itm_id"));
                        out.print(yy3);
                        %>
                	                        </select>
                	                        </td>
                        
                        
                        
                        
                        
                        
                    <td><input type="text" name="qty1[]" id="qty1" style=" width: 50px;text-align:right;" value="<%=rs1.getInt("av_qty") %>" class="qtyClass" />

<!--                     <td><input type="text" name="qty[]" id="qty" style=" width: 100px" onkeyup="qtyValidate(this.value,this);calqtydiff(this.value,this);afterRateChange(this);" class="rqtyClass" /> -->

                         <td><input type="text" name="rate[]" id="rate" style=" width: 100px;text-align:right;" value="<%=rs1.getString(10) %>" onkeyup="afterRateChange(this)"/>
                        <td><input type="text" name="basic[]" id="basic" style=" width: 100px;text-align:right;" class="basClass" value="<%=rs1.getString("basic_amt")%>"/>
                    <td><input type="text" name="dis_per[]" id="dis_per" style=" width: 80px;text-align:right;" value='<%=rs1.getString(12) %>' onkeyup="afterRateChange(this)"/>
                    <td><input type="text" name="dis_amt[]" id="dis_amt" style=" width: 100px;text-align:right;" value='<%=rs1.getString(13) %>' class="disClass" />
                    <td><input type="text" name="gst_per[]" id="gst_per" style=" width: 50px;text-align:right;" value='<%=rs1.getString("gst_per") %>' onkeyup="afterRateChange(this)"/>
                     <td><input type="text" name="cgst_amt[]" id="cgst_amt" style=" width: 100px;text-align:right;" value='<%=rs1.getString("cgst_amt") %>' class="ocgstClass" onkeyup="afterRateChange(this)"/>
                      <td><input type="text" name="sgst_amt[]" id="sgst_amt" style=" width: 100px;text-align:right;" value='<%=rs1.getString("sgst_amt") %>' class="osgstClass" onkeyup="afterRateChange(this)"/>
                    <td><input type="text" name="igst_amt[]" id="igst_amt" style=" width: 100px;text-align:right;" value='<%=rs1.getString("igst_amt") %>' class="oigstClass" onkeyup="afterRateChange(this)"/>
                     <td><input type="text" name="amt[]" id="amt" style=" width: 100px;text-align:right;" value='<%=rs1.getString("amt") %>' class="oamtClass"/>
                      <td><input type="hidden" name="uom_id[]" id="uom_id" style=" width: 100px;text-align:right;" value='<%=rs1.getString("uom_id") %>'/>
                      <td> <button onclick="printCode(<%=rs1.getString("bar_code") %>,'<%=purno%>','<%=pdt%>')">Print</button>
                    </tr>
                    <input type="hidden" name="diffqty[]" id="diffqty" />

<%
    						}
ResultSet rs2 = st2.executeQuery(sql2);	
while(rs2.next())
{

%>



                     <tr id="cloneRow1">
                    <th >
                    <th colspan="2" style="text-align:right;font-weight: bold;">Misc Head
                    <td colspan="2"> <select name="miscH[]" id="miscH" class="browser-default" onchange="fetchOtherHead(this.value,this.id,this)">
             <option value="<%=rs2.getString("oh_hid")%>"><%=rs2.getString("description") %></option>
             </select>
             
             <td><input type="text" placeholder="Amount" name="miscHamt1[]" id="miscHamt1" value="<%=rs2.getString("basic")%>" style="width: 100px; text-align:right" class="hbasClass" onchange="" /></td>
             <td>
              <td><input type="text" placeholder="Amount" name="miscHamt[]" id="miscHamt" value="<%=rs2.getString("basic")%>" style="width: 100px; text-align:right" class="basClass" onchange="" /></td>
                  
                    <td colspan="1"><input type="text" name="o_gst_per[]" id="o_gst_per" value="<%=rs2.getString("gst_per")%>" style=" width: 50px; text-align:right" value='0.00'/></td>
                    <td><input type="text" name="o_cgst_amt[]" id="o_cgst_amt" value="<%=rs2.getString("cgst_amt")%>" style=" width: 100px; text-align:right" value='0.00' onchange="afterRateChange(this);" class="ocgstClass" /></td>
                     <td><input type="text" name="o_sgst_amt[]" id="o_sgst_amt" value="<%=rs2.getString("sgst_amt")%>" style=" width: 100px; text-align:right" value='0.00' onchange="afterRateChange(this);" class="osgstClass" /></td>
                      <td><input type="text" name="o_igst_amt[]" id="o_igst_amt" value="<%=rs2.getString("igst_amt")%>" style=" width: 100px; text-align:right" value='0.00' onchange="afterRateChange(this);" class="oigstClass" /></td>
                     <td><input type="text" name="o_amt[]" id="o_amt" value="<%=rs2.getString("amt")%>" style=" width: 100px; text-align:right" value='0.00' class="oamtClass" /></td>
                    <td style=" display: none;"><input type="text" name="o_cal_typ[]" id="o_cal_typ" style=" width: 100px; text-align:right" class="ocalType" />
                    </tr>
                    
                     <% } %>
                    <tr id="afterMisc">
                    
                    </tr>
                     <tr class="table-danger">
                    <th colspan="3">
                    <th>
                    <th colspan="1">Net Amount: 
                     <td><input type="text" placeholder="Amount" name="finBasic" class=" border-danger" id="finBasic" style="width: 100px; text-align:right" value="<%=tot_bas_amt%>"/></td>
                    <th colspan="">
                   <td><input type="text" name="fin_dis_amt" id="fin_dis_amt" class=" border-danger" style=" width: 100px; text-align:right" value="<%=tot_dis_amt%>" /></td>
                     <th colspan="">
                    <td><input type="text" name="fin_cgst_amt" id="fin_cgst_amt" style=" width: 100px; text-align:right" value="<%=tot_cgst_amt%>" class=" border-danger" /></td>
                     <td><input type="text" name="fin_sgst_amt" id="fin_sgst_amt" style=" width: 100px; text-align:right" value="<%=tot_sgst_amt%>" class=" border-danger" /></td>
                      <td><input type="text" name="fin_igst_amt" id="fin_igst_amt" style=" width: 100px; text-align:right" value="<%=tot_igst_amt%>" class=" border-danger" /></td>
                     
                    <td><input type="text" name="net_amt" id="net_amt" class=" border-danger"  style=" width: 100px; text-align:right" value="<%=net_amt%>" /></td>
                    </tr>
                    
<!--                     <tr> -->
<!--                     <td colspan="10" align="center"> <input type="submit" class="btn btn-primary" value="submit" /> -->
<!--                     </tr> -->
 
 </table>