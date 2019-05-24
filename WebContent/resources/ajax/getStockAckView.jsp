<%@page import="org.json.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>

<script>
 $('.datepicker').pickadate({
  	
	  format: 'yyyy-mm-dd',
	  max: new Date()
 	}); 
 $(function() {
 	$('img').on('click', function() {
 		$('.enlargeImageModalSource').attr('src', $(this).attr('src'));
 		$('#enlargeImageModal').modal('show');
 	});
 });
</script>


        <%
    	 
            String itm_nm = "", itm_type_nm = "";
        	int itm_id=0, itm_type_id=0;  

String id=request.getParameter("tr_hid");
UtilityHelper util=new UtilityHelper();

        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st= null;
                     Statement st1= null;
                     Statement st2= null;
                    String cid = "", cnm = "";
                    st = conn.createStatement();
                    st1=conn.createStatement();
                    st2=conn.createStatement();
                    String sql1 = "SELECT a.tr_hid as tr_hid,a.pck_sl_no as pck_sl_no,date_format(a.pck_sl_dt,'%Y-%m-%d') as pck_sl_dt, a.co_id as co_id,concat(b.co_nm,'-',b.outlet) as co_nm, " +
                        	" a.no_of_pck as no_of_pck, a.tot_qty as tot_qty, a.finBasic as finBasic, a.bill_no as bill_no,date_format(a.bill_dt,'%Y-%m-%d') as bill_dt,a.amt_in_word as amt_in_word, a.fin_dis_amt as fin_dis_amt, a.fin_cgst_amt as fin_cgst_amt,"+
                        	" a.fin_sgst_amt as fin_sgst_amt, a.fin_igst_amt as fin_igst_amt, a.net_amt as net_amt,a.party_id as party_id,p.party_nm,ifnull(p.sd_tag,'N') sd_tag ,"+
                        	"  a.active as active, "+
                        	 " (SELECT sm_nm FROM mst_sales_man where sm_id=a.salesman) as salesman,"+
                        	 " (SELECT sm_nm FROM mst_sales_man where sm_id=a.helper) as helper FROM cr_sale_hd a join mst_party p on(a.party_id=p.party_id)" +
                        	 " join mst_company b on(a.co_id=b.co_id) where a.active='Y' and tr_hid='"+id+"'";
                    
                    String sql3 = "SELECT c.tr_did,im.itm_nm, c.tr_hid, it.itm_typ_nm,it.itm_typ_id, c.sl_no, c.item_typ_id, c.item_id, c.desg_id, c.qty,c.rate, c.dis_per, c.dis_amt, c.amt,c.gst_per, c.cgst_amt, c.co_id, c.created_by, c.created_on, c.modified_by, c.modified_on, c.active, c.sgst_amt, c.igst_amt,"+
                    		"c.basic, c.hsn_cd, c.barcode FROM cr_sale_dtl c join mst_fp_itm im on (im.itm_id=c.item_id) join mst_itm_typ it on(it.itm_typ_id=c.item_typ_id) where tr_hid='"+id+"'";
                	System.out.println("SQL==> "+sql1);
                	
                	
                	String sql4 = "select h.description,o.oh_hid, o.amt,h.cal_typ,o.igst_amt, o.sgst_amt,o.cgst_amt,o.gst_per,  o.created_by, o.created_on, o.modified_by, o.tr_id, o.tr_hid, o.oh_hid,o.modified_on, o.active, o.basic from cr_sale_other_dtl o join mst_other_head h on(h.oh_id=o.oh_hid) where tr_hid='"+id+"'" ;
                	
//                 	puroth.setMiscH(purHdr.getMiscH()[j]);
//                		puroth.setMiscHamt(purHdr.getMiscHamt()[j]);
//                		puroth.setO_amt(purHdr.getO_amt()[j]);
//                		puroth.setO_cal_typ(purHdr.getO_cal_typ()[j]);
//                		puroth.setActive("Y");
//                		puroth.setO_igst_amt(purHdr.getO_igst_amt()[j]);
//                		puroth.setO_sgst_amt(purh.description,Hdr.getO_sgst_amt()[j]);
//                		puroth.setO_cgst_amt(purHdr.getO_cgst_amt()[j]);
//                		puroth.setO_gst_per(purHdr.getO_gst_per()[j]);   				
    						
    						
        %>
        <%    
        			String finBasic="",fin_dis_amt="",fin_cgst_amt="",fin_sgst_amt="",fin_igst_amt="",net_amt="";       
                       String sd_tag="";          	
    				ResultSet rss1 = st.executeQuery(sql1);	
    				ResultSetMetaData rsmds1 = rss1.getMetaData();
    			
    				JSONArray jsonarr1=new JSONArray();
    				while(rss1.next()) {
    					
    				  int numColumns1 = rsmds1.getColumnCount();
    				  JSONObject objs1 = new JSONObject();
    				  for (int i=1; i<=numColumns1; i++) {
    				    String column_name1 = rsmds1.getColumnName(i);
    				    objs1.put(column_name1, rss1.getObject(column_name1));
    				  }
    				  jsonarr1.put(objs1);
    					System.out.println("the array is:-"+jsonarr1);
   				}
    			
                    for(int x1=0;x1<jsonarr1.length();x1++){
                 	   JSONObject objects1 = jsonarr1.getJSONObject(x1);
                 	  		  finBasic=objects1.get("finBasic").toString();
                 			  fin_dis_amt=objects1.get("fin_dis_amt").toString();
                 			  fin_cgst_amt=objects1.get("fin_cgst_amt").toString();
                 			  fin_sgst_amt=objects1.get("fin_sgst_amt").toString();
                 			  fin_igst_amt=objects1.get("fin_igst_amt").toString();
                 			  sd_tag=objects1.get("sd_tag").toString();
                 			 net_amt=objects1.get("net_amt").toString();
                 			java.util.Date dt=new java.util.Date();
            				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            				String trdate=sdf.format(dt);
                    %>
        
        <table class="table table-hover" style="width:100%;">
        <tr>
         			<th>Company</th>
                    <td><input type="text" name="party_nm" id="party_nm" style="width:80%;" class="form-control" readonly="readonly" value="<%=objects1.get("party_nm") %>" />
                    <input type="hidden" name="party_cd" id="party_cd" style="width:80%;" readonly="readonly" value="<%=objects1.get("co_id") %>" /></td>
                   
                                       
                    <th>Bill No</th>
                    <td><input type="text" name="inv_no" id="inv_no" style="width:80%;" class="form-control" readonly="readonly" value="<%=objects1.get("bill_no") %>" /></td>
                    
                    <th>Bill Date</th>
                    <td><input type="text" name="inv_dt" id="inv_dt" style="width:80%;" class="form-control" readonly="readonly" value="<%=objects1.get("bill_dt") %>" />
                  <th>In Date
                  <td> <input type="text" name="pur_dt" id="pur_dt" style="width:80%;" value="<%= trdate %>" class="form-control datepicker" required/></td>
                   </tr>
                   
                   <tr>
                    <th>Vendor</th>
                    <td><input type="text" name="co_nm" id="co_nm" style="width:100%;" readonly="readonly" class="form-control" value="<%=objects1.get("co_nm") %>" /> 
                     <input type="hidden" name="co_id" id="co_id" style="width:60%;" readonly="readonly" value="<%=objects1.get("co_id") %>" /> </td>
                   
                   </tr>
<!--                    <tr>  -->
<!--                       <th>Basic</th> -->
<%--                       <td><input type="text" name="finBasic" id="finBasic" class="form-control" style="width:60%;text-align:right;" readonly="readonly" value="<%=objects1.get("finBasic") %>" /></td> --%>
              
<!--               			<th>Discount</th> -->
<%--               			<td><input type="text" name="fin_dis_amt" id="fin_dis_amt" class="form-control" style="width:60%;text-align:right;" readonly="readonly" value="<%=objects1.get("fin_dis_amt") %>" /></td> --%>
                   
<!--                    <th>CGST</th> -->
<%--                    <td><input type="text" name="fin_cgst_amt" id="fin_cgst_amt" class="form-control" style="width:60%;text-align:right;" readonly="readonly" value="<%=objects1.get("fin_cgst_amt") %>" /></td> --%>
<!--                    </tr> -->
<!--                    <tr> -->
<!--                     <th>SGST</th> -->
<%--                    <td><input type="text" name="fin_sgst_amt" id="fin_sgst_amt" class="form-control" style="width:60%;text-align:right;" readonly="readonly" value="<%=objects1.get("fin_sgst_amt") %>" /></td> --%>
                   
<!--                    <th>IGST</th> -->
<%--                    <td><input type="text" name="fin_igst_amt" id="fin_igst_amt" class="form-control" style="width:60%;text-align:right;" readonly="readonly" value="<%=objects1.get("fin_igst_amt") %>" /></td> --%>
                   
<!--                    <th>Net Amount</th> -->
<%--                    <td><input type="text" name="net_amt" id="net_amt" class="form-control" style="width:60%;text-align:right;" readonly="readonly" value="<%=objects1.get("net_amt") %>" /></td> --%>
              
<!--            </tr> -->
                	                    </table>
                	                 <% } %>
<!--                 	                    <br> -->
                	                    
             <div class="table-responsive" align="left">
                    <table class="table-bordered" align="left">
               
                    
                    <tr style="width:auto;background-color: cyan;">
                    <th>Design
                    <th>Item
                    <th>Item Type
                    <th>Rate
                     <th>Basic
                    <th>Received
                    <th>Accepted
                   
                    <th>Discount
                    <th>GSTPER
                    <th>CGST
                    <th>SGST
                    <th>IGST
                    <th>Amount
                    </tr>
                    
                    
                    <% 
                                 	
    				ResultSet rss = st.executeQuery(sql3);	
    				ResultSetMetaData rsmds = rss.getMetaData();
    			
    				JSONArray jsonarr=new JSONArray();
    				while(rss.next()) {
    					
    				  int numColumns = rsmds.getColumnCount();
    				  JSONObject objs = new JSONObject();
    				  for (int i=1; i<=numColumns; i++) {
    				    String column_name = rsmds.getColumnName(i);
    				    objs.put(column_name, rss.getObject(column_name));
    				  }
    				  jsonarr.put(objs);
    					System.out.println("the array is:-"+jsonarr);
    				}
    			
                   for(int x=0;x<jsonarr.length();x++){
                	   JSONObject objects = jsonarr.getJSONObject(x);
                    %>
                    <tr id="cloneRow">
                    
                     <td><input type="text" name="desg_no[]" id="desg_no" style="width:100%;" readonly="readonly" value="<%=objects.get("desg_id") %>" />
                     <input type="hidden" name="desg_id[]" id="desg_id" readonly="readonly" value="1" />
                     
                    <td><input type="hidden" name="item_id[]" id="item_id" style="width:100%;" readonly="readonly" value="<%=objects.get("item_id") %>" readonly/>
                    <input type="text" name="item_nm[]" id="item_nm" style="width:100%;" value="<%=objects.get("itm_nm") %>" readonly/>
                    
                    <td><input type="hidden" name="item_typ_id[]" id="item_typ_id[]" style="width:100%;" readonly="readonly" value="<%=objects.get("itm_typ_id") %>" readonly/>
                    <input type="text" name="item_typ_nm[]" id="item_typ_nm" style="width:100%;" value="<%=objects.get("itm_typ_nm") %>" readonly/>
                   
                        
                    <td><input type="text" name="rate[]" id="rate" style="width:100%;text-align:right;" readonly="readonly" value="<%=objects.get("rate") %>" />
                    
                      <td><input type="text" name="basic[]" id="basic" readonly="readonly" style="width:100%;text-align:right;" value="<%=objects.get("basic") %>" />
                    
                    <input type="hidden" name="uom_id[]" id="uom_id" style="width:100%;" value="Meter" />
                    
                    <td><input type="text" name="qty1[]" id="qty1" style="width:100%;text-align:right;" readonly="readonly" value="<%=objects.get("qty") %>" />
                    <%if(sd_tag.equalsIgnoreCase("Y")){%>
                     <input type="hidden" name="vr_type" id="vr_type" value="SDTAG"/>
                    <%}else{ %>
                    <input type="hidden" name="vr_type" id="vr_type" value="STKI"/>
                    <%} %>
                     <td><input type="text" name="qty[]" id="qty" style="width:100%;text-align:right;background-color: #FFD4A7;" readonly="readonly" value="<%=objects.get("qty") %>" readonly/>
                    
                  
                   
                    <input type="hidden" name="bar_code[]" id="bar_code" style="width:100%;" value="<%=objects.get("barcode") %>" />
                   
                   <td><input type="text" name="dis_amt[]" id="dis_amt" readonly="readonly" style="width:100%;text-align:right;" value="<%=objects.get("dis_amt") %>" />
                   <input type="hidden" name="dis_per[]" id="dis_per" readonly="readonly" style="width:100%;" value="<%=objects.get("dis_per") %>" />
                                      <td><input type="text" name="gst_per[]" id="gst_per" readonly="readonly" style="width:100%;text-align:right;" value="<%=objects.get("gst_per") %>" />
                   <td><input type="text" name="cgst_amt[]" id="cgst_amt" style="width:100%;text-align:right;" readonly="readonly" value="<%=objects.get("cgst_amt") %>" />

                   <td><input type="text" name="sgst_amt[]" id="sgst_amt" style="width:100%;text-align:right;" readonly="readonly" value="<%=objects.get("sgst_amt") %>" />
                   <td><input type="text" name="igst_amt[]" id="igst_amt" style="width:100%;text-align:right;" readonly="readonly" value="<%=objects.get("igst_amt") %>" />
                   <td><input type="text" name="amt[]" id="dis_amt" style="width:100%;text-align:right;" readonly="readonly" value="<%=objects.get("amt") %>" />
                
                    </tr>
                    <%
                    } 
                    %>
                    
                    <% 
                                 	
    				ResultSet rss10 = st2.executeQuery(sql4);	
    				ResultSetMetaData rsmds4 = rss10.getMetaData();
    			
    				JSONArray jsonarr10=new JSONArray();
    				while(rss10.next()) {
    					
    				  int numColumns4 = rsmds4.getColumnCount();
    				  JSONObject objs4 = new JSONObject();
    				  for (int i=1; i<=numColumns4; i++) {
    				    String column_name = rsmds4.getColumnName(i);
    				    objs4.put(column_name, rss10.getObject(column_name));
    				  }
    				  jsonarr10.put(objs4);
    					System.out.println("the array is:-"+jsonarr10);
    				}
    			
                   for(int x=0;x<jsonarr10.length();x++){
                	   JSONObject objects10 = jsonarr10.getJSONObject(x);
                    %>
<!--                      <tr id="afterMisc"> -->
                    
<!--                     </tr> -->
<!--                      <tr class="table-danger"> -->
                
                   <tr id="cloneRow1">
                   
                    <th colspan="2" style="text-align: right;font-weight: bold;">Misc Head:-</th>
                    <td colspan="2" style="text-align: right;"><input type="text" name="description[]" id="description" style="width:100%;" readonly="readonly" value="<%=objects10.get("description") %>" />
                     <input type="hidden" name="miscH[]" id="miscH" style="width:100%;" value="<%=objects10.get("oh_hid") %>" /></td>
                                        
<!--                      <th>Basic</th> -->
                     <td><input type="text" name="miscHamt[]" id="miscHamt" style="width:100%;text-align:right;" value="<%=objects10.get("basic") %>" readonly/></td>
                     
<!--                     <th>Misc Amount</th> -->
                   
                    
<!--                     <th>Cal Type</th> -->
<%--                     <td><input type="text" name="o_cal_typ[]" id="o_cal_typ" style="width:70%;" value="<%=objects10.get("cal_typ") %>" readonly/></td> --%>
                    
                    <th colspan="3">
<!--                     <th>GST PERCENTAGE</th> -->
                     <td><input type="text" name="o_gst_per[]" id="o_gst_per" readonly="readonly" style="width:100%;" value="<%=objects10.get("gst_per") %>" /></td>
                    
                    
<!--                     <th>IGST</th> -->
                    
                     <td><input type="text" name="o_cgst_amt[]" id="o_cgst_amt" style="width:100%;text-align: right;" readonly="readonly" value="<%=objects10.get("cgst_amt") %>" />    </td>
                     
                     
<!--                    <th>SGST</th>              -->
                   <td><input type="text" name="o_sgst_amt[]" id="o_sgst_amt" style="width:100%;text-align: right;" readonly="readonly" value="<%=objects10.get("sgst_amt") %>" /></td>
                   
<!--                    <th>CGST</th> -->
                   <td><input type="text" name="o_igst_amt[]" id="o_igst_amt" style="width:100%;text-align: right;" readonly="readonly" value="<%=objects10.get("igst_amt") %>" />
                    
                    
                    <td><input type="text" name="o_amt[]" id="o_amt" style="width:100%;text-align:right;" readonly="readonly" value="<%=objects10.get("amt") %>" /></td>
                    
                    </tr>
                     <tr id="afterMisc">
                    
                    </tr>
                    
                    <%
                    } 
                    %>
                    
                     <tr class="table-danger">
                <th colspan="2">
                    <th colspan="2" style="text-align: right;font-weight: bold;">Net Amount: 
                      <td><input type="text" name="finBasic" id="finBasic"  style="width:100%;text-align:right;" readonly="readonly" value="<%=finBasic%>" /></td>
              <td colspan="2">&nbsp;</td>
            

              			<td><input type="text" name="fin_dis_amt" id="fin_dis_amt"  style="width:100%;text-align:right;" readonly="readonly" value="<%=fin_dis_amt%>" /></td>
                   
					<td></td>
                   <td colspan="1"><input type="text" name="fin_cgst_amt" id="fin_cgst_amt"  style="width:100%;text-align:right;" readonly="readonly" value="<%=fin_cgst_amt%>" /></td>
                  
                   <td><input type="text" name="fin_sgst_amt" id="fin_sgst_amt"  style="width:100%;text-align:right;" readonly="readonly" value="<%=fin_sgst_amt%>" /></td>
                   

                   <td><input type="text" name="fin_igst_amt" id="fin_igst_amt" style="width:100%;text-align:right;" readonly="readonly" value="<%=fin_igst_amt%>" /></td>

                   <td><input type="text" name="net_amt" id="net_amt"  style="width:100%;text-align:right;" readonly="readonly" value="<%=net_amt%>" /></td>
              

                    </tr>
                    
                    
                    </table> 
       </div>
				
					 
                          
				

			