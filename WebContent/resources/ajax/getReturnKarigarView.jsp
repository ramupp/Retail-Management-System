


<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>


 <%
          
		//String pur_no=request.getParameter("pur_no");
 String hid=request.getParameter("hid");
 System.out.println("document code  is-----="+hid);
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
                    String sql3="select hid, doc_no, date_format(a.doc_dt,'%y-%m-%d')doc_dt,kar_cd,party_nm, narration from trn_kar_issue_hd a join mst_party b on (a.kar_cd = b.party_id) where type='T' and hid="+hid+"";
                  
                	System.out.println(sql3);
                	ResultSet rs = st.executeQuery(sql3);	
                	
                	
					//int hid=rs.getInt("hid");
                	//String doc_no = rs.getString("doc_no");
                	//String doc_dt = rs.getString("doc_dt");
                	//String narration = rs.getString("narration");
                	
                	
                	
    %>
    
    
    
   <head>
    
   
   



</head>
    
    <div>
  
    <table class="table-hover" >
    <%   	
                  	//String doc_no = rs1.getString("doc_no");
                 	//String doc_dt = rs1.getString("doc_dt");
                 	//String kar_cd = rs1.getString("kar_cd");
                 	
                 	
                 	
    						while (rs.next()) {
    							
    						
 %>
                         
         
      

 							<th>
                              Karigar:
                            </th>

                            <td>
                                 
                         <input name="kar_cd" id="kar_cd" value="<%=rs.getString("party_nm")%>" class="browser-default" >
                         
                       
                            </td>
				 <th>
                      Recvd. No:
                        </th>
                    <td><input type="text" name="doc_no" id="doc_no" value="<%=rs.getString("doc_no")%>"    class="cleanData" style="width:70px;text-align:right;"/>

                <th>
                     Recvd. Date:
                        </th>
                        <td colspan="1">
                          <input placeholder="Selected date" type="text" value="<%=rs.getString("doc_dt")%>"  name="doc_dt" id="doc_dt" style=" width: 120px" value="" class="form-control datepicker">
                        	
                        
                        </td>
                       
                            <th>
                              Narration:
                            </th>

                            <td >
                           <input type="text" name="narration" id="narration" value="<%=rs.getString("narration")%>"  class="form-control"/>
                      
                                                
                            </td>
                            
                                                   
                        </tr>
                        
                          <% 
                          
   						} 
   						
   						%>
                    </table>


 </div>
                	
                	  