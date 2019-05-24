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

</head>
<body>
<form>
 <%
 	//String pur_no=request.getParameter("pur_no");
  String kar_cd=request.getParameter("kar_cd");
  System.out.println("Karigarh code  is-----="+kar_cd);
 		//System.out.println("pur_no is:-"+pur_no);
 		//String co_id=request.getParameter("co_id");
 		String hid=request.getParameter("hid");
 		String doc_no=request.getParameter("doc_no");
 		UtilityHelper util=new UtilityHelper();
 		System.out.println("hid is------="+hid);
 		String id = request.getParameter("id");
         MyConnection mc=new MyConnection();
     	Connection conn=mc.getConnection("adm_retail");
                      Statement st= null;
                      Statement st1=null;
                      Statement st2,st3=null;
                     String cid = "", cnm = "";
                     st = conn.createStatement();
                     st1=conn.createStatement();
                     st2=conn.createStatement();
                     st3=conn.createStatement();
                     //st4=conn.createStatement();
                     String sql3="select hid,doc_no, doc_dt, kar_cd from trn_kar_issue_hd where hid="+hid+"";
                     //String sql7="select hid,doc_no, doc_dt, kar_cd from trn_kar_issue_hd where type='I' hid="+hid+"";
                     String sql4="select hid,doc_no, doc_dt, party_nm, ref_no, ref_dt, isu_id from trn_kar_issue_hd a join mst_party b on (a.kar_cd=b.party_id) where type='R' and party_typ='SC' and hid="+hid+"";
                     //String sql5="select id,itm_typ_id, itm_id, desg_no, qty, uom_id, co_id from trn_kar_isu_prod where hid="+hid+"";
                     //String sql6="select id,itm_typ_id, itm_id, desg_no, qty, uom_id, co_id from trn_kar_isu_dt where hid="+hid+"";
                    String sql5="select a.id,a.desg_no,a.qty,a.uom_id,a.itm_typ_id,a.itm_id,i.itm_nm,it.itm_typ_nm,b.doc_no from trn_kar_isu_prod a join mst_fp_itm i on(i.itm_id=a.itm_id) join mst_itm_typ it on (a.itm_typ_id=it.itm_typ_id)join trn_kar_issue_hd b on (b.hid=a.hid) where b.hid="+hid+"";

                     String sql6="select a.id,a.desg_no,a.qty,a.uom_id,a.itm_typ_id,a.itm_id,i.itm_nm,it.itm_typ_nm,b.doc_no from trn_kar_isu_dt a join mst_fp_itm i on(i.itm_id=a.itm_id) join mst_itm_typ it on (a.itm_typ_id=it.itm_typ_id)join trn_kar_issue_hd b on(b.hid=a.hid) where b.hid="+hid+"";

                     
                     System.out.println("sql5 is......="+sql5);
                     //String sql5="select id,itm_typ_nm, itm_nm, desg_no, qty, uom_nm, co_nm, desg_no, qty from trn_kar_isu_dt a join mst_fp_itm b on(a.itm_id=b.itm_id) join mst_itm_typ c on(a.itm_typ_id=c.itm_typ_id) join mst_uom d on (a.uom_id=d.uom_id) join mst_company e on (a.co_id= e.co_id)";

                     System.out.println(sql3);
                     System.out.println(sql4);
                     
                 ResultSet rs1 = st.executeQuery(sql3);
                 ResultSet rs2 = st1.executeQuery(sql4);
                 ResultSet rs3 = st3.executeQuery(sql6);	
                 ResultSet rs4 = st2.executeQuery(sql5);	
                // ResultSet rs5 = st4.executeQuery(sql7);	
                 	//rs1.next();
 %>
    <div align="center" class="row">
                   
      <table class="table-bordered border-warning table-responsive">
      
<%   	
                   //  String doc_no = rs1.getString("doc_no");
                 	//String doc_dt = rs1.getString("doc_dt");
                 	//String kar_cd = rs1.getString("kar_cd");
                 	
                 	
                 	
    						while (rs1.next()) {
    							
    						
 %>
 
                    <tr>
                 
<!--                     <td> -->
<%-- 					<input type="text" name="doc_no" id="doc_no" value="<%=rs1.getString("doc_no")%>" style=" width: 100px"  /> --%>
<!--                     </td> -->
<!--                      <td> -->
<%-- 					<input type="text" name="doc_dt" id="doc_dt" value="<%=rs1.getString("doc_dt")%>" style=" width: 100px"  /> --%>
<!--                     </td> -->
<!--                      <td> -->
<%-- 					<input type="text" name="kar_cd" id="kar_cd" value="<%=rs1.getString("kar_cd")%>" style=" width: 100px"  /> --%>
<!--                     </td> -->
                 
                    </tr>
                    
                    
                    
                    
                <% 
   						} %>
 <tr >
                   
<!--                     <p class="h">Material Details & Design Receive</p></div> -->
                  <h style="color: #E73408;  font-weight: bold;">Header</h>
                    <th>Recd. No 
                    <th>Recd. Date  
                   
                      <th>Issue No 
                    <th> Isuue Date 
                     <th> Karigarh Name
                    
                    
<!--                      <th>Stock Date -->
<!--                     <th>Ref Date -->
                   
                    
                   
                   
                  
                    </tr>
    	                	
	
 <% while(rs2.next())
 {

 %> 
                    <tr>
<%--                   <td><input type="text" name="ref_no" id="ref_no" value="<%=rs2.getString("ref_no")%>"  class="cleanData" style="width:70px;text-align:right;"/>  --%>
                    
<!--                   <td> -->
<%--                   <input type="text" name="doc_no" id="doc_no" value="<%=rs2.getString("doc_no")%>" style=" width: 100px" class="pivotElement"  /> --%>
<!--                   </td> -->
<!--                     <td> -->

<%-- 					<input type="text" name="doc_dt" id="doc_dt" value="<%=rs2.getString("doc_dt")%>" style=" width: 100px" class="desgClass"  /> --%>
                        
<!--                     </td> -->

                   
                    <td><input type="text" name="doc_no" id="doc_no" value="<%=rs2.getString("doc_no")%>"   class="cleanData" style="width:70px;text-align:right;" readonly/>
                    <td><input type="text" name="doc_dt" id="doc_dt" value="<%=rs2.getString("doc_dt")%>"   class="cleanData" style="width:70px;text-align:right;" readonly/>
                 
                   <td><input type="text" name="ref_no" id="ref_no" value="<%=rs2.getString("ref_no")%>"  class="cleanData" style="width:70px;text-align:right;" readonly/>
                    
                    <td><input type="text" name="ref_dt" id="ref_dt" value="<%=rs2.getString("ref_dt")%>"   class="cleanData" style="width:70px;text-align:right;" readonly/>
                  <td><input type="text" name="kar_cd" id="kar_cd" value="<%=rs2.getString("party_nm")%>" style=" width: 100px; text-align:left" readonly/></td>
                    
                    

<%--                       <td><input type="text" name="stk_dt" id="stk_dt" value="<%=rs2.getString("stk_dt")%>"    class="cleanData" style="width:70px;text-align:right;"/>  --%>
                     
                   </tr>
                   
                   
                   
                    <%
    						} %>
    						</table>
    						</div>
    						
    					<div class="row">
    					<div class="col-sm-6">    											
 <table class="table-bordered border-warning table-responsive">
  <tr>
                   <h style="color: #E73408;  font-weight: bold;">Receive Design</h>
                    <th>Item Type
                    <th>Item
                        <th>Design No.
                        <th> Quantity
                           <th>Recd Qty
                              <th>UOM
                               
                   
                   </tr>

<% while(rs4.next())
{

%>
                   
                   <tr>
                     <td><select name="itm_typ_id[]" id="item_typ_id"
						class="browser-default sexy">
							<option value="<%=rs4.getString("itm_typ_id")%>"><%=rs4.getString("itm_typ_nm")%></option>
					</select></td>
                   <td><select name="itm_id[]" id="item_id"
						value="<%=rs4.getString("itm_nm")%>" class="browser-default">
							<option value="<%=rs4.getString("itm_id")%>"><%=rs4.getString("itm_nm")%></option>
					</select></td>
                   
                   <%-- <td><select name="item_typ_id[]" id="item_typ_id" class="browser-default drp" readonly>
                      <%=util.getDropdownString("mst_itm_typ", "itm_typ_id", "itm_typ_nm",rs4.getString("itm_typ_id") )%>            
                        </select></td>
                    <td><select name="item_id[]" id="item_id" class="browser-default drp" readonly>
                        <%=util.getDropdownString("mst_fp_itm", "itm_id", "itm_nm",rs4.getString("itm_id") )%>            
                        </select></td>--%>
<%--                    <td><input type="text" name="itm_typ_id" id="itm_typ_id" value="<%=rs3.getString("itm_typ_id")%>" style=" width: 100px;text-align:right"  /> --%>
<!--                        </td> -->
<%--                         <td><input type="text" name="itm_id" id="itm_id" value="<%=rs3.getString("itm_id")%>" style=" width: 100px;text-align:right"  /> --%>
<!--                        </td> -->
                        <td><input type="text" name="desg_no[]" id="desg_no" value="<%=rs4.getString("desg_no")%>" style=" width: 100px;text-align:right"  readonly/>
                       </td>
                       <td><%=rs4.getString("qty")%> 
                       </td>
                        
                        <td><input type="text" name="qty[]" id="qty"  value="" style=" width: 100px;text-align:right"  />
                       </td>
                        
                        <td><input type="text" name="uom_id[]" id="uom_id" value="<%=rs4.getString("uom_id")%>" onkeyup="checkMinus(this.value,this);" style=" width: 100px;text-align:right"  />
                       </td>
                         
                       
                        <% } %>
                      </tr> 
                      
                    
                    
             
                  </table>
                  </div><br>
    	
    		<div class="col-sm-6">      	 						
 <table class="table-bordered border-warning table-responsive" style=" float: right">
  <tr>
                   <h style="color: #E73408;  font-weight: bold;">Material Details</h>
                    <th>Item Type
                    <th>Item
                        <th>Design No.
                        <th> Quantity
                           <th>Recd Qty
                              <th>UOM
                               
                   
                   </tr>

<% while(rs3.next()){

%>
                   
                   <tr>
                   
                   <td><select name="itm_typ_id1[]" id="item_typ_id"
						class="browser-default sexy">
							<option value="<%=rs3.getString("itm_typ_id")%>"><%=rs3.getString("itm_typ_nm")%></option>
					</select></td>
                   <td><select name="itm_id1[]" id="item_id"
						value="<%=rs3.getString("itm_nm")%>" class="browser-default">
							<option value="<%=rs3.getString("itm_id")%>"><%=rs3.getString("itm_nm")%></option>
					</select></td>
					
					
                   
                   
                   <%-- <td><select name="item_typ_id1[]" id="item_typ_id" class="browser-default drp" readonly>
                      <%=util.getDropdownString("mst_itm_typ", "itm_typ_id", "itm_typ_nm",rs3.getString("itm_typ_id") )%>            
                        </select></td>
                    <td><select name="item_id1[]" id="item_id" class="browser-default drp" readonly>
                        <%=util.getDropdownString("mst_fp_itm", "itm_id", "itm_nm",rs3.getString("itm_id") )%>            
                        </select></td>--%>
<%--                    <td><input type="text" name="itm_typ_id" id="itm_typ_id" value="<%=rs3.getString("itm_typ_id")%>" style=" width: 100px;text-align:right"  /> --%>
<!--                        </td> -->
<%--                         <td><input type="text" name="itm_id" id="itm_id" value="<%=rs3.getString("itm_id")%>" style=" width: 100px;text-align:right"  /> --%>
<!--                        </td> -->
                        <td><input type="text" name="desg_no1[]" id="desg_no" value="<%=rs3.getString("desg_no")%>" style=" width: 100px;text-align:right"  readonly/>
                       </td>
                       <td><%=rs3.getString("qty")%> 
                       </td>
                        
                        <td><input type="text" name="qty1[]" id="qty"  value="" style=" width: 100px;text-align:right"  />
                       </td>
                        
                        <td><input type="text" name="uom_id1[]" id="uom_id" value="<%=rs3.getString("uom_id")%>" onkeyup="checkMinus(this.value,this);" style=" width: 100px;text-align:right"  />
                       </td>
                         
                       
                        <% } %>
                      </tr> 
                     
                    
                    
             
                  </table>
                	 </div>
                	 </div>
                	
                	 <div class="row" style=" margin-float: right 15px;">
                	 <table>
                	  <tr>
                    <td colspan="14" align="center"> <input type="submit" class="btn btn-primary btn-sm" value="submit" />
                    </tr>
                	 </table>
                	 </div>
                	 
                	 
                	 </form>
                	 </body>
                	 </html>
                	  