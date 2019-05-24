<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
  
 <%
         UtilityHelper util=new UtilityHelper(); 
		String slip_no=request.getParameter("slip_no");
 String co_id=request.getParameter("co_id");
 String coid=co_id;
 String flag=request.getParameter("flag");
		System.out.println("pur_no is:-"+slip_no);
        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st= null;
                     Statement st1,st2=null,st3=null;
                    String cid = "", cnm = "";
                    st = conn.createStatement();
                    st1=conn.createStatement();
                    st2=conn.createStatement();
                    st3=conn.createStatement();
                  String sqlForCheck="SELECT count(*) FROM cr_sale_hd where pck_sl_no='"+slip_no+"' and vr_type='"+flag+"' and co_id='"+co_id+"'";
                  ResultSet rsForCheck = st3.executeQuery(sqlForCheck);
                  rsForCheck.next();
                  int cnt=rsForCheck.getInt(1);
                  if(cnt==0){
//                     String sql="SELECT a.tr_hid, a.pck_sl_dt, a.consg_id,(select party_nm from mst_party where party_id=a.consg_id and party_typ='SD' ) consg, a.transp_id,(select party_nm from mst_party where party_id=a.transp_id and party_typ='TR' ) transp, a.no_of_pck, a.notes, a.tot_amt,a.fin_dis_amt, a.fin_igst_amt, a.net_amt, a.party_id,"
//                     		+"(select party_nm from mst_party where party_id=a.party_id and party_typ='SD' ) party_nm, a.fin_cgst_amt, a.fin_sgst_amt, a.finBasic,m.gst_no,a.lr_no, a.lr_dt, a.pkwt, a.salesman,(select m.sm_nm FROM mst_sales_man m where m.sm_id= a.salesman and m.sl_type='S') as salesman_nm, a.helper,(select m.sm_nm FROM mst_sales_man m where m.sm_id= a.helper and m.sl_type='H') as helper_nm  "
//                        	 +" FROM pck_slp_hdr a left join mst_party m on(a.party_id=m.party_id and m.party_typ='SD') "
//                        		 +" where pck_sl_no='"+slip_no+"' and slp_type='"+flag+"' and a.co_id='"+co_id+"'";

String sql="SELECT a.tr_hid, a.pck_sl_dt, a.consg_id,(select party_nm from mst_party where party_id=a.consg_id and party_typ='SD' ) consg, a.transp_id,(select party_nm from mst_party where party_id=a.transp_id and party_typ='TR' ) transp, a.no_of_pck, a.notes, a.tot_amt,a.fin_dis_amt, a.fin_igst_amt, a.net_amt, a.party_id,"
                    		+"(select party_nm from mst_party where party_id=a.party_id and party_typ='SD' ) party_nm, a.fin_cgst_amt, a.fin_sgst_amt, a.finBasic,m.gst_no,a.lr_no, a.lr_dt, a.pkwt, a.salesman,(select m.sm_nm FROM mst_sales_man m where m.sm_id= a.salesman and m.sl_type='S') as salesman_nm, a.helper,(select m.sm_nm FROM mst_sales_man m where m.sm_id= a.helper and m.sl_type='H') as helper_nm  "
                       	 +" FROM pck_slp_hdr a left join mst_party m on(a.party_id=m.party_id and m.party_typ='SD') "
                       		 +" where pck_sl_no='"+slip_no+"' and slp_type='"+flag+"' and a.co_id='"+co_id+"'";
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
               String sql1="SELECT tr_did, tr_hid, sl_no, item_typ_id,c.itm_typ_nm, a.item_id,d.itm_nm, desg_id,b.desg_no, qty, rate, a.dis_per, dis_amt, amt, a.gst_per, a.cgst_amt, a.co_id, a.sgst_amt, a.igst_amt, a.basic,a.barcode,a.hsn_cd"+
            		   " FROM pck_slp_dtl a left join mst_design b on(a.desg_id=b.tr_id) left join mst_itm_typ c on(a.item_typ_id=c.itm_typ_id) left join mst_fp_itm d on(a.item_typ_id=d.itm_typ_id and a.item_id=d.itm_id)"+
            		   " where tr_hid='"+tr_id+"'";
               System.out.println(sql1);
               String sql2="SELECT a.tr_id, a.tr_hid, a.oh_hid,b.description, a.gst_per, cgst_amt, sgst_amt, igst_amt, amt,"+
               " basic FROM pck_slp_other_dtl a left join mst_other_head b on(a.oh_hid=b.oh_id) where tr_hid='"+tr_id+"' and a.active='Y'";
               java.util.Date dt=new java.util.Date();
   			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
   			String trdate=sdf.format(dt);
                	
    %>
    <script src="../../../resources/js/packingSlip.js"></script> 
<script type="text/javascript">

$(document).ready(function() {
	 var beans="OtherHeadsHdr";
	 var valcols=["active","hd_typ"];
	 var valvs=["Y","SA"];
	 var getDatass={beanName:beans,valColumn:valcols,valValue:valvs};
	 var params1s=JSON.stringify(getDatass);
	 var ps="miscH1";
	 var selectedCol1s="oh_id,description";
	 CallDropDownService(params1s,ps,selectedCol1s);
});

</script>
                					<table class="table">
               
                	                <tr>
                	                 <th>
                      Bill No:
                        </th>
                        <td colspan="1">
                          <input type="text" name="bill_no" id="bill_no" class="form-control" value="<%=slip_no%>" readonly>
                        	
                        
                        </td>
                <th>
                      Bill Date:
                        </th>
                        <td colspan="1">
                          <input placeholder="Selected date" type="text" name="bill_dt" id="bill_dt" value="<%=trdate %>" class="form-control datepicker">
                        	
                        
                        </td>
                        
						 <th>
                       No. Of Packets:
                        </th>
                        <td>
                         <input type="text" name="no_of_pck" id="no_of_pck" class="form-control" value="<%=rs.getInt("no_of_pck")%>" style=" width: 60%" readonly/> 
                        </td> 
                       
                <th>
                      Slip Date:
                        </th>
                        <td colspan="1">
                          <input type="text" name="pck_sl_dt" id="pck_sl_dt" class="form-control" value="<%=rs.getString("pck_sl_dt") %>" readonly>
                        	
                        
                        </td>
                         </tr>
						<tr>
                        <th>
                      Gst No.:
                        </th>
                        <td colspan="1">
                          <input type="text" name="gst_no" id="gst_no" class="form-control" value="<%=rs.getString("gst_no") %>" readonly>
                        	
                        
                        </td>
                       
						<th>
                              Customer Name:
                            </th>

                            <td>
                                 
                         <select name="party_id" id="party_id" class="mdb-select  colorful-select dropdown-primary " >
                        <option value="<%=rs.getInt("party_id")%>"><%=rs.getString("party_nm")%></option>
                        </select>
                            </td>
                            <th>
                              Consignee:
                            </th>

                            <td >
                           <select name="consg_id" id="consg_id" class="mdb-select  colorful-select dropdown-primary " >
                           <option value="<%=rs.getInt(3)%>"><%=rs.getString(4)%></option>
                        </select>
                                                
                            </td>
                            <th>
                              Transporter:
                            </th>
                            <td>
                      <select name="transp_id" id="transp_id" class="mdb-select  colorful-select dropdown-primary " >
                       <% 
                        String yy=util.getDropdownString("mst_party","party_id","party_nm",rs.getString(5));
                        out.print(yy);
                        %> 
<%--                        <option value="<%=rs.getInt(5)%>"><%=rs.getString(6)%></option> --%>
                        </select>
                        
                            </td>
                           </tr>
                           <tr>
                             <th>
                              LR No:
                            </th>
                            <td>
                             <input type="text" name="lr_no" id="lr_no" class="form-control" value="<%=rs.getString("lr_no")%>" >
            
                        
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
                     <input  type="text" name="pkwt" id="pkwt" class="form-control" value="<%=rs.getInt("pkwt")%>" >
                      
                        
                            </td>
                            </tr>
                            <tr>
<!--                              <th> -->
<!--                               Salesman: -->
<!--                             </th> -->
<!--                             <td> -->
<!--                       <select name="salesman" id="salesman" class="mdb-select  colorful-select dropdown-primary " > -->
<%--                        <option value="<%=rs.getString("salesman")%>"><%=rs.getString("salesman_nm")%></option> --%>
<!--                         </select> -->
                        
<!--                             </td> -->
                            
<!--                               <th> -->
<!--                               Helper: -->
<!--                             </th> -->
<!--                             <td> -->
<!--                       <select name="helper" id="helper" class="mdb-select  colorful-select dropdown-primary " > -->
<%--                        <option value="<%=rs.getString("helper")%>"><%=rs.getString("helper_nm")%></option> --%>
<!--                         </select> -->
                        
<!--                             </td> -->

                        
                        
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
                  <td><input type="text" name="barcode[]" id="barcode" style=" width: 80px" value='<%=rsp.getString("barcode")%>' readonly/></td>
                    <td><select name="desg_id[]" id="desg_id" class="browser-default" onchange="afterDesgChange(this,<%=coid %>);fetchItemTypeAndItemFromDesign(this);">
                        <option value="<%=rsp.getString("desg_id")%>"><%=rsp.getString("desg_id")%></option>           
                        </select></td>
                    <td><select name="item_typ_id[]" id="item_typ_id" class="browser-default" >
                       <option value='<%=rsp.getInt("item_typ_id")%>'><%=rsp.getString("itm_typ_nm")%></option>            
                        </select></td>
                    <td><select name="item_id[]" id="item_id" class="browser-default" >
                           <option value='<%=rsp.getInt("item_id")%>'><%=rsp.getString("itm_nm")%></option> 
                        </select></td>
                    
                    <td><input type="text" name="hsn_cd[]" id="hsn_cd" style=" width: 50px" value='<%=rsp.getString("hsn_cd")%>' readonly/></td>
                    <td><input type="text" name="qty[]" id="qty" style=" width: 50px;text-align:right" value='<%=rsp.getString("qty")%>' readonly/></td>
                    <td><input type="text" name="rate[]" id="rate" style=" width: 100px;text-align:right" value='<%=rsp.getString("rate")%>' readonly/></td>
                    <td><input type="text" name="basic[]" id="basic" style=" width: 100px; text-align:right" value='<%=rsp.getString("basic")%>'  class="basClass" readonly/></td>
                    <td><input type="text" name="dis_per[]" id="dis_per" style=" width: 50px; text-align:right" value='<%=rsp.getString("dis_per")%>' onchange="afterRateChange(this)" readonly/></td>
                    <td><input type="text" name="dis_amt[]" id="dis_amt" style=" width: 70px; text-align:right" value='<%=rsp.getString("dis_amt")%>' class="disClass" readonly/></td>
                    <td><input type="text" name="gst_per[]" id="gst_per" style=" width: 50px; text-align:right" value='<%=rsp.getString("gst_per")%>' onchange="afterRateChange(this)" readonly/></td>
                    <td><input type="text" name="cgst_amt[]" id="cgst_amt" style=" width: 70px; text-align:right" value='<%=rsp.getString("cgst_amt")%>' class="cgstClass" readonly/></td>
                     <td><input type="text" name="sgst_amt[]" id="sgst_amt" style=" width: 70px; text-align:right" value='<%=rsp.getString("sgst_amt")%>' class="sgstClass" readonly/></td>
                      <td><input type="text" name="igst_amt[]" id="igst_amt" style=" width: 70px; text-align:right" value='<%=rsp.getString("igst_amt")%>' class="igstClass" readonly/></td>
                     <td><input type="text" name="amt[]" id="amt" style=" width: 100px; text-align:right" value='<%=rsp.getString("amt")%>' class="amtClass" readonly/></td>
                      </tr>
                      <% } %>
                        <tr id="insertBefore" class="table-info" style=" display: none;">
                    <th>
                    <th>
                    <th>
                    <th>
                     <th>  <th>
                    <th>Total:
                     <td><input type="text" name="tot_bas_amt" id="tot_bas_amt" class=" border border-success" style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                    <th>
                    
                    <td><input type="text" name="tot_dis_amt" id="tot_dis_amt" class=" border border-success" style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                    <th>
                    
                    <td><input type="text" name="tot_cgst_amt" id="tot_cgst_amt" class=" border border-success"  style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                    <td><input type="text" name="tot_sgst_amt" id="tot_sgst_amt" class=" border border-success"  style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                    <td><input type="text" name="tot_igst_amt" id="tot_igst_amt" class=" border border-success"  style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                    
                   
                    <td><input type="text" name="tot_amt" id="tot_amt" class=" border border-success"  style=" width: 100px; text-align:right" value='0.00' readonly/></td>
                    </tr>
                   <%
                   ResultSet rspx = st2.executeQuery(sql2);	
                   while(rspx.next()){ %>
                  
                    <tr id="cloneRow1">
                    <th >
                    <th colspan="4">Misc Head
                    <td colspan="2"> <select name="miscH[]" id="miscH" class="browser-default" onchange="fetchOtherHead(this.value,this.id,this)">
             <option value='<%=rspx.getString(3) %>'><%=rspx.getString(4) %></option>
             </select>
              <td><input type="text" placeholder="Amount" name="miscHamt[]" id="miscHamt" style="width: 100px; text-align:right" class="omiscHamt" value="<%=rspx.getString(10) %>" readonly/></td>
                    <th colspan="2">
                    <td><input type="text" name="o_gst_per[]" id="o_gst_per" style=" width: 50px; text-align:right" value='<%=rspx.getString("gst_per") %>' readonly/></td>
                    <td><input type="text" name="o_cgst_amt[]" id="o_cgst_amt" style=" width: 70px; text-align:right" value='<%=rspx.getString("cgst_amt") %>' class="ocgstClass" readonly/></td>
                     <td><input type="text" name="o_sgst_amt[]" id="o_sgst_amt" style=" width: 70px; text-align:right" value='<%=rspx.getString("sgst_amt") %>' class="osgstClass" readonly/></td>
                      <td><input type="text" name="o_igst_amt[]" id="o_igst_amt" style=" width: 70px; text-align:right" value='<%=rspx.getString("igst_amt") %>' class="oigstClass" readonly/></td>
                     <td><input type="text" name="o_amt[]" id="o_amt" style=" width: 100px; text-align:right" value='<%=rspx.getString("amt") %>' class="oamtClass" readonly/></td>
                    
                    </tr>
                    <%} %>
                    <tr id="cloneRow1">
                    <th >
                    <th colspan="4">Misc Head
                    <td colspan="2"> <select name="miscH[]" id="miscH1" class="browser-default" onchange="fetchOtherHead(this.value,this.id,this)" class="pivotElement">
             <option value='0'>---select Option---</option>
             </select>
              <td><input type="text" placeholder="Amount" name="miscHamt[]" id="miscHamt" style="width: 100px; text-align:right" class="omiscHamt"  onchange="getOtherGstValues(this);addNewMiscRow()" onkeyup="calculateMgst(this.value,this)" /></td>
                    <th colspan="2">
                    <td><input type="text" name="o_gst_per[]" id="o_gst_per" style=" width: 50px; text-align:right" value='0.00' readonly/></td>
                    <td><input type="text" name="o_cgst_amt[]" id="o_cgst_amt" style=" width: 70px; text-align:right" value='0.00' class="ocgstClass" readonly/></td>
                     <td><input type="text" name="o_sgst_amt[]" id="o_sgst_amt" style=" width: 70px; text-align:right" value='0.00' class="osgstClass" readonly/></td>
                      <td><input type="text" name="o_igst_amt[]" id="o_igst_amt" style=" width: 70px; text-align:right" value='0.00' class="oigstClass" readonly/></td>
                     <td><input type="text" name="o_amt[]" id="o_amt" style=" width: 100px; text-align:right" value='0.00' class="oamtClass" readonly/></td>
                    <td style=" display: none;"><input type="text" name="o_cal_typ[]" id="o_cal_typ" style=" width: 100px; text-align:right" class="ocalType" readonly/>
                    </tr>
                    <tr id="afterMisc">
                    
                    </tr>
                    <tr class="table-danger">
                    <th colspan="5">
                    <th colspan="2">Net Amount: 
                     <td><input type="text" placeholder="Amount" name="finBasic" class=" border-danger" id="finBasic" style="width: 100px; text-align:right" value='<%=tot_basic%>' readonly/></td>
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
				
<%}else{out.println("exist");} %>
			