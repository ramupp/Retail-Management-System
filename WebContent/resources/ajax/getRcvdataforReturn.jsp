


<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>


 <%
          
		//String pur_no=request.getParameter("pur_no");
 String doc_no=request.getParameter("doc_no");
 System.out.println("document code  is-----="+doc_no);
		//System.out.println("pur_no is:-"+pur_no);
		String co_id=request.getParameter("co_id");
        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st= null;
                     Statement st1=null;
                     Statement st2=null;
                    String cid = "", cnm = "";
                    st = conn.createStatement();
                    st1=conn.createStatement();
                    st2=conn.createStatement();
                    String sql3="select hid, doc_no, doc_dt,kar_cd, narration from trn_kar_issue_hd where type='R'";
                   // String sql4="select hid, doc_no,doc_dt, kar_cd, ref_no, ref_dt from trn_kar_issue_hd";
                   // String sql5="select id, itm_typ_id, itm_id, desg_no, qty, uom_id, co_id from trn_kar_isu_dt";
                   // String sql="SELECT h.pur_id, h.pur_no, date_format(h.pur_dt,'%Y-%m-%d') pur_dt, h.inv_no, h.inv_dt,h.tot_bas_amt, h.tot_dis_amt, h.tot_cgst_amt, h.tot_sgst_amt, h.tot_igst_amt, h.party_cd,p.party_nm,h.tot_amt,h.tot_disc,h.tot_gst,h.net_amt FROM trn_pur_hdr h left join mst_party p on(p.party_id=h.party_cd) where h.pur_no='"+pur_no+"' and h.co_id='"+co_id+"'";
                    //String sql1="select d.*,(d.qty - ret_qty) as av_qty,md.desg_no,it.itm_typ_nm,i.itm_nm,d.basic_amt,d.cgst_amt, d.sgst_amt, d.igst_amt, d.basic_amt,d.qty from trn_pur_hdr h join trn_pur_dtl d on(h.pur_id=d.pur_id) join mst_party p on(p.party_id=h.party_cd) join mst_design md on(md.tr_id=d.desg_id) join mst_fp_itm i on(d.itm_id=i.itm_id) join mst_itm_typ it on(d.itm_typ_id=it.itm_typ_id) where h.co_id='"+co_id+"' and h.pur_no='"+pur_no+"' and h.vr_type='PURC'";
                	//String sql2="SELECT o.*,oh.* FROM trn_pur_hdr h join pur_other_dtl o on(h.pur_id=o.pur_id) inner join mst_other_head oh on(oh.oh_id=o.oh_hid) where pur_no='"+pur_no+"'  and h.vr_type='PURC' and h.co_id='"+co_id+"'";
                    System.out.println(sql3);
                	ResultSet rs = st.executeQuery(sql3);	
                	//ResultSet rs4 = st1.executeQuery(sql4);	
                	//ResultSet rs5 = st2.executeQuery(sql5);	
                	//while(rs.next()){

                	
					//int hid=rs.getInt("hid");
                	//String doc_no = rs.getString("doc_no");
                	//String doc_dt = rs.getString("doc_dt");
                	//String narration = rs.getString("narration");
                	
                	
                	
    %>
    
    
    
   <head>
    
   
   



</head>
    
    <div>
  
    <table class="table-hover" >
                         
         
      

 							<th>
                              Karigar:
                            </th>

                            <td>
                                 
                         <select name="kar_cd" id="kar_cd" class="browser-default" >
                         
                        </select>
                            </td>
				 <th>
                      Recvd. No:
                        </th>
                    <td><input type="text" name="doc_no" id="doc_no"   class="cleanData" style="width:70px;text-align:right;"/>

                <th>
                     Recvd. Date:
                        </th>
                        <td colspan="1">
                          <input placeholder="Selected date" type="text" name="doc_dt" id="doc_dt" style=" width: 120px" value="" class="form-control datepicker">
                        	
                        
                        </td>
                       
                            <th>
                              Narration:
                            </th>

                            <td >
                           <input type="text" name="narration" id="narration" class="form-control"/>
                      
                                                
                            </td>
                            
                                                   
                        </tr>
                    </table>


 </div>
                	
                	  