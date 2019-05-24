<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>

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
 
 
 
<!--  <script> 
 
//  $(document).ready(function() {
//     $('.mdb-select').material_select();
   
//    $('.datepicker').pickadate({
  	
//   	  format: 'yyyy-mm-dd'
//   	}); 
  
</script> -->

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
          
		String slip_no=request.getParameter("slip_no");
 String co_id=request.getParameter("co_id");
 String coid=co_id;
 String flag=request.getParameter("flag");
		System.out.println("pur_no is:-"+slip_no);
        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st= null;
                     Statement st1,st2=null;
                    String cid = "", cnm = "";
                    st = conn.createStatement();
                    st1=conn.createStatement();
                    st2=conn.createStatement();
                    String sql="SELECT a.tr_hid, a.pck_sl_dt, a.consg_id,(select party_nm from mst_party where party_id=a.consg_id and party_typ='SD' ) consg, a.transp_id,(select party_nm from mst_party where party_id=a.transp_id and party_typ='TR' ) transp, a.no_of_pck, a.notes, a.tot_amt,a.fin_dis_amt, a.fin_igst_amt, a.net_amt, a.party_id,"
                    		+"(select party_nm from mst_party where party_id=a.party_id and party_typ='SC' ) party_nm, a.fin_cgst_amt, a.fin_sgst_amt, a.finBasic,m.gst_no,a.lr_no, a.lr_dt,a.bill_dt, a.pck_sl_no,a.pkwt, a.salesman,(select m.sm_nm FROM mst_sales_man m where m.sm_id= a.salesman and m.sl_type='S') as salesman_nm, a.helper,(select m.sm_nm FROM mst_sales_man m where m.sm_id= a.helper and m.sl_type='H') as helper_nm  "
                       	 +" FROM cr_sale_hd a left join mst_party m on(a.party_id=m.party_id and m.party_typ='SD') "
                       		 +" where bill_no='"+slip_no+"' and vr_type='"+flag+"' and a.co_id='"+co_id+"'";
                   System.out.println(sql);
                	ResultSet rs = st.executeQuery(sql);	
                	rs.next();
                	int tr_id=rs.getInt(1);
                	double net_amt=rs.getDouble("net_amt");
                	double tot_disc=rs.getDouble("fin_dis_amt");
                	double tot_sgst=rs.getDouble("fin_sgst_amt");
                	double tot_cgst=rs.getDouble("fin_cgst_amt");
                	double tot_igst=rs.getDouble("fin_igst_amt");
                	double tot_basic=rs.getDouble("finBasic");
                	Date bill_dt=rs.getDate("bill_dt");
                	String pck_sl_no=rs.getString("pck_sl_no");
                	
               String sql1="SELECT tr_did, tr_hid, sl_no, item_typ_id,c.itm_typ_nm, a.item_id,d.itm_nm, desg_id,b.desg_no, qty, rate, a.dis_per, dis_amt, amt, a.gst_per, a.cgst_amt, a.co_id, a.sgst_amt, a.igst_amt, a.basic,a.barcode,a.hsn_cd"+
            		   " FROM cr_sale_dtl a left join mst_design b on(a.desg_id=b.tr_id) left join mst_itm_typ c on(a.item_typ_id=c.itm_typ_id) left join mst_fp_itm d on(a.item_typ_id=d.itm_typ_id and a.item_id=d.itm_id)"+
            		   " where tr_hid='"+tr_id+"'";
               System.out.println(sql1);
               String sql2="SELECT a.tr_id, a.tr_hid, a.oh_hid,b.description, a.gst_per, cgst_amt, sgst_amt, igst_amt, amt,"+
               " basic FROM cr_sale_other_dtl a left join mst_other_head b on(a.oh_hid=b.oh_id) where tr_hid='"+tr_id+"' and a.active='Y'";
                	
    %>
                					<table class="table">
               
                	                <tr>
                	                  <th>
                      Packing Slip No:
                        </th>
                        <td colspan="1">
                          <input type="text" name="pck_sl_no" id="pck_sl_no" class="form-control" value="<%=pck_sl_no%>">
                        	
                        
                        </td>
                	                 <th>
                      Bill No:
                        </th>
                        <td colspan="1">
                          <input type="text" name="bill_no" id="bill_no" class="form-control" value="<%=slip_no%>">
                        	
                        
                        </td>
                <th>
                      Bill Date:
                        </th>
                        <td colspan="1">
                          <input placeholder="Selected date" type="text" name="bill_dt" id="bill_dt" class="form-control datepicker" value="<%=bill_dt%>">
                        	
                        
                        </td>
                        
						 <th>
                       No. Of Packets:
                        </th>
                        <td>
                         <input type="text" name="no_of_pck" id="no_of_pck" class="form-control" value="<%=rs.getInt("no_of_pck")%>" style=" width: 60%" /> 
                        </td> 
                       
                <th>
                      Slip Date:
                        </th>
                        <td colspan="1">
                          <input type="text" name="pck_sl_dt" id="pck_sl_dt" class="form-control" value="<%=rs.getString("pck_sl_dt") %>">
                        	
                        
                        </td>
                         </tr>
						<tr>
                        <th>
                      Gst No.:
                        </th>
                        <td colspan="1">
                          <input type="text" name="gst_no" id="gst_no" class="form-control" value="<%=rs.getString("gst_no") %>">
                        	
                        
                        </td>
                       
						<th>
                              Customer Name:
                            </th>

                            <td>
                                 
                         <select name="party_id" id="party_id" class="mdb-select  colorful-select dropdown-primary x" >
                        <option value="<%=rs.getInt("party_id")%>"><%=rs.getString("party_nm")%></option>
                        </select>
                            </td>
                            <th>
                              Consignee:
                            </th>

                            <td >
                           <select name="consg_id" id="consg_id" class="mdb-select  colorful-select dropdown-primary x" >
                           <option value="<%=rs.getInt(3)%>"><%=rs.getString(4)%></option>
                        </select>
                                                
                            </td>
                            <th>
                              Transporter:
                            </th>
                            <td>
                      <select name="transp_id" id="transp_id" class="mdb-select  colorful-select dropdown-primary x" >
                       <option value="<%=rs.getInt(5)%>"><%=rs.getString(6)%></option>
                        </select>
                        
                            </td>
                           </tr>
                           <tr>
                             <th>
                              LR No:
                            </th>
                            <td>
                             <input type="text" name="lr_no" id="lr_no" class="form-control" value="<%=rs.getString("lr_no")%>">
            
                        
                            </td>
                            
                             <th>
                              LR Date:
                            </th>
                            <td colspan="1">
                          <input placeholder="Selected date" type="text" name="lr_dt" id="lr_dt" class="form-control datepicker" value="<%=rs.getString("lr_dt")%>" >
                        	
                        
                        </td>
                            
                             <th>
                              Packing Weight:
                            </th>
                            <td>
                     <input  type="text" name="pkwt" id="pkwt" class="form-control" value="<%=rs.getInt("pkwt")%>">
                      
                        
                            </td>
                            </tr>
                            <tr>
                             <th>
                              Salesman:
                            </th>
                            <td>
                      <select name="salesman" id="salesman" class="mdb-select  colorful-select dropdown-primary" >
                       <option value="<%=rs.getString("salesman")%>"><%=rs.getString("salesman_nm")%></option>
                        </select>
                        
                            </td>
                            
                              <th>
                              Helper:
                            </th>
                            <td>
                      <select name="helper" id="helper" class="mdb-select  colorful-select dropdown-primary " >
                       <option value="<%=rs.getString("helper")%>"><%=rs.getString("helper_nm")%></option>
                        </select>
                        
                            </td>

                        
                        
                        <th>
                       Notes:
                        </th>
                        <td colspan="2">
                        
                         <textarea type="text" id="notes"  name="notes" class="md-textarea form-control" ><%=rs.getString("notes")%></textarea>
                        </td>
                       
                        </tr>
                	                    </table>
                	                    <br>
                  <div class="row justify-content-start border-warning" >
                    <table class="table-bordered border-warning table-responsive">
                    <tr>
                    <td colspan="16" align="center" class="card-header juicy-peach-gradient lighten-1 text-dark text-center z-depth-2 "><p class="h5">Details</p>
                   
                    </tr>
                    <tr>
                     <td colspan="16" >&nbsp;</td>
                    </tr>
                    <tr>
                    <th>BarCode 
                    <th>Design 
                    <th>Item Type
                    <th>Item
                    <th>HsnCode
                    <th>Quantity
                    <th>Return Quantity
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
                  <%
                  ResultSet rsp = st1.executeQuery(sql1);	
                  while(rsp.next()){
                  
                  %>  
                    <tr id="cloneRow">
                  <td><input type="text" name="barcode[]" id="barcode" style=" width: 80px" value='<%=rsp.getString("barcode")%>' /></td>
                    <td><select name="desg_id[]" id="desg_id" class="browser-default" onchange="afterDesgChange(this,<%=coid %>);fetchItemTypeAndItemFromDesign(this);">
                        <option value="<%=rsp.getString("desg_id")%>"><%=rsp.getString("desg_id")%></option>           
                        </select></td>
                    <td><select name="item_typ_id[]" id="item_typ_id" class="browser-default" >
                       <option value='<%=rsp.getInt("item_typ_id")%>'><%=rsp.getString("itm_typ_nm")%></option>            
                        </select></td>
                    <td><select name="item_id[]" id="item_id" class="browser-default" >
                           <option value='<%=rsp.getInt("item_id")%>'><%=rsp.getString("itm_nm")%></option> 
                        </select></td>
                    
                    <td><input type="text" name="hsn_cd[]" id="hsn_cd" style=" width: 50px" value='<%=rsp.getString("hsn_cd")%>' /></td>
<!--                     <td><input type="text" name="qty[]" id="qty" style=" width: 50px"  /></td> -->
                                        <td><input type="text" name="qty1[]" id="qty1" style=" width: 50px" onfocus="calqtydiff(this.value,this);" value='<%=rsp.getString("qty")%>' class="qtyClass" />
                    <td><input type="text" name="qty[]" id="qty" style=" width: 50px" onkeyup="qtyValidate(this.value,this);" onchange="afterRateChange(this)" class="rqtyClass" />
                    <td><input type="text" name="rate[]" id="rate" style=" width: 50px" value='<%=rsp.getString("rate")%>' /></td>
                    <td><input type="text" name="basic[]" id="basic" style=" width: 100px; text-align:right" value='<%=rsp.getString("basic")%>'  class="basClass" readonly/></td>
                    <td><input type="text" name="dis_per[]" id="dis_per" style=" width: 50px; text-align:right" value='<%=rsp.getString("dis_per")%>' onchange="afterRateChange(this)"/></td>
                    <td><input type="text" name="dis_amt[]" id="dis_amt" style=" width: 70px; text-align:right" value='<%=rsp.getString("dis_amt")%>' class="disClass" readonly/></td>
                    <td><input type="text" name="gst_per[]" id="gst_per" style=" width: 50px; text-align:right" value='<%=rsp.getString("gst_per")%>' onchange="afterRateChange(this)" readonly/></td>
                    <td><input type="text" name="cgst_amt[]" id="cgst_amt" style=" width: 70px; text-align:right" value='<%=rsp.getString("cgst_amt")%>' class="cgstClass" readonly/></td>
                     <td><input type="text" name="sgst_amt[]" id="sgst_amt" style=" width: 70px; text-align:right" value='<%=rsp.getString("sgst_amt")%>' class="sgstClass" readonly/></td>
                      <td><input type="text" name="igst_amt[]" id="igst_amt" style=" width: 70px; text-align:right" value='<%=rsp.getString("igst_amt")%>' class="igstClass" readonly/></td>
                     <td><input type="text" name="amt[]" id="amt" style=" width: 100px; text-align:right" value='<%=rsp.getString("amt")%>' class="amtClass" readonly/></td>
                      </tr>
                      <% } %>
                     <tr id="insertBefore" class="table-info" style=" display: none">
                    <th>
                    <th>
                    <th>
                    <th>
                     
                     
                    <th>Total:
                     <td><input type="text" name="tot_bas_amt" id="tot_bas_amt" class=" border border-success" style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                    <th>
                    
                    <td><input type="text" name="tot_dis_amt" id="tot_dis_amt" class=" border border-success" style=" width: 70px; text-align:right" value='0.00' readonly/></td>
                    <th>
                    
                    <td><input type="text" name="tot_cgst_amt" id="tot_cgst_amt" class=" border border-success"  style=" width: 70px; text-align:right" value='0.00' readonly/></td>
                    <td><input type="text" name="tot_sgst_amt" id="tot_sgst_amt" class=" border border-success"  style=" width: 70px; text-align:right" value='0.00' readonly/></td>
<!--                     <td><input type="text" name="tot_igst_amt" id="tot_igst_amt" class=" border border-success"  style=" width: 100px; text-align:right" value='0.00' readonly/></td> -->
                    
                   
                    <td><input type="text" name="tot_amt" id="tot_amt" class=" border border-success"  style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                   
                    </tr>   
                   <%
                   ResultSet rspx = st2.executeQuery(sql2);	
                   while(rspx.next()){ %>
                    <tr id="cloneRow1">
                    <th >
                    <th colspan="4">Misc Head
                    <td colspan="3"> <select name="miscH[]" id="miscH" class="browser-default" onchange="fetchOtherHead(this.value,this.id,this)">
             <option value='<%=rspx.getString(3) %>'><%=rspx.getString(4) %></option>
             </select>
              <td><input type="text" placeholder="Amount" name="miscHamt[]" id="miscHamt" style="width: 100px; text-align:right" class="omiscHamt" value="<%=rspx.getString(10) %>" /></td>
                    <th colspan="2">
                    <td><input type="text" name="o_gst_per[]" id="o_gst_per" style=" width: 50px; text-align:right" value='<%=rspx.getString("gst_per") %>' readonly/></td>
                    <td><input type="text" name="o_cgst_amt[]" id="o_cgst_amt" style=" width: 70px; text-align:right" value='<%=rspx.getString("cgst_amt") %>' class="ocgstClass" readonly/></td>
                     <td><input type="text" name="o_sgst_amt[]" id="o_sgst_amt" style=" width: 70px; text-align:right" value='<%=rspx.getString("sgst_amt") %>' class="osgstClass" readonly/></td>
                      <td><input type="text" name="o_igst_amt[]" id="o_igst_amt" style=" width: 70px; text-align:right" value='<%=rspx.getString("igst_amt") %>' class="oigstClass" readonly/></td>
                     <td><input type="text" name="o_amt[]" id="o_amt" style=" width: 100px; text-align:right" value='<%=rspx.getString("amt") %>' class="oamtClass" readonly/></td>
                    
                    </tr>
                    <%} %>
                    <tr id="afterMisc">
                    
                    </tr>
                    <tr class="table-danger">
                    <th colspan="5">
                    <th colspan="3">Net Amount: 
                     <td><input type="text" placeholder="Amount" name="finBasic" class=" border-danger" id="finBasic" style="width: 100px; text-align:right" value='<%=tot_basic%>'/></td>
                    <th colspan="">
                   <td><input type="text" name="fin_dis_amt" id="fin_dis_amt" class=" border-danger" style=" width: 70px; text-align:right" value='<%=tot_disc%>' readonly/></td>
                     <th colspan="">
                    <td><input type="text" name="fin_cgst_amt" id="fin_cgst_amt" style=" width: 70px; text-align:right" value='<%=tot_cgst%>' class=" border-danger" readonly/></td>
                     <td><input type="text" name="fin_sgst_amt" id="fin_sgst_amt" style=" width: 70px; text-align:right" value='<%=tot_sgst%>' class=" border-danger" readonly/></td>
                      <td><input type="text" name="fin_igst_amt" id="fin_igst_amt" style=" width: 70px; text-align:right" value='<%=tot_igst%>' class=" border-danger" readonly/></td>
                     
                    <td><input type="text" name="net_amt" id="net_amt" class=" border-danger"  style=" width: 100px; text-align:right" value='<%=net_amt%>' readonly/></td>
                     </tr>
                     <tr>
                    <td colspan="14" align="center"> <input type="submit" class="btn btn-primary btn-sm" value="submit" />    
                    </tr>
                    </table>
                    
                    </div>
				

			