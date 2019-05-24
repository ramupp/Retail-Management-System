<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>

        <%
            String itm_nm = "", itm_type_nm = "";
        	int itm_id=0, itm_type_id=0;  

String des_no=request.getParameter("des_no");
System.out.println("des_no is:-"+des_no);
        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st= null;
                    String cid = "", cnm = "";
                    st = conn.createStatement();
                    String sql="select i.itm_id,i.itm_nm,t.itm_typ_id,t.itm_typ_nm from mst_design d join mst_fp_itm i on(i.itm_id=d.item_id) join mst_itm_typ t on(t.itm_typ_id=i.itm_typ_id) where d.desg_no='"+des_no+"'";
                	System.out.println(sql);
    				ResultSet rs = st.executeQuery(sql);				
    						while (rs.next()) {
    							itm_id=rs.getInt("itm_id");    							
    							itm_nm = rs.getString("itm_nm");
    							itm_type_id=rs.getInt("itm_typ_id");    		
    							itm_type_nm = rs.getString("itm_typ_nm");
    						}
        %>
        
       
				  <th>
                                Item Type:
                            </th>

                            <td>
                             <select name="item_type_id" id="itm_typ_id" class="browser-default ">
                             <option value="<%=itm_type_id%>"><%=itm_type_nm%></option>
                        </select>
                            </td>
					 
                            <th>
                                Item :
                            </th>

                            <td>
                             <select name="item_id" id="itm_id" class="browser-default ">
                             <option value="<%=itm_id%>"><%=itm_nm%></option>
                        </select>
                            </td>

                       
                          

                       
			
				

			