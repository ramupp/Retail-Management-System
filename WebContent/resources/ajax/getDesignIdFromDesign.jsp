<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>

        <%
            String itm_nm = "", itm_type_nm = "";
        int tr_id=0;  

String des_no=request.getParameter("des_no");
System.out.println("des_no is:- "+des_no);
        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st= null;
                    String cid = "", cnm = "";
                    st = conn.createStatement();
                    String sql="SELECT tr_id,desg_no FROM mst_design where active='Y' and desg_no='"+des_no+"'";
                	System.out.println(sql);
    				ResultSet rs = st.executeQuery(sql);				
    						while (rs.next()) {
    							tr_id=rs.getInt("tr_id");    							
    							//itm_nm = rs.getString("itm_nm");
    							
    						}
    						
    						out.println(tr_id);
        %>
        
       
				         
                       
                          

                       
			
				

			