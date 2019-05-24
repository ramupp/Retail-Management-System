<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>

        <%
            String itm_nm = "", itm_type_nm = "";
        	int itm_id=0, itm_type_id=0;  

String itm_typ_id=request.getParameter("itm_typ_id");
//System.out.println("itm_typ_id is:- "+itm_typ_id);
        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st= null;
                    String cid = "", cnm = "";
                    st = conn.createStatement();
                    String sql="SELECT itm_id,itm_nm FROM mst_fp_itm where itm_typ_id='"+itm_typ_id+"'";
                	//System.out.println(sql);
    				ResultSet rs = st.executeQuery(sql);				
    						//while (rs.next()) {
    						//	itm_id=rs.getInt("itm_id");    							
    						//	itm_nm = rs.getString("itm_nm");
    							
    						//}
        %>
         <option value="0">-Select-</option>
				<%
				while (rs.next()) {
					//System.out.println("123");
				%>
				<option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
				
				<% 
				
				}
				
				%>

                       
                          

                       
			
				

			