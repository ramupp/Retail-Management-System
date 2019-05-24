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
              int count=0;
                    st = conn.createStatement();
                    String sql="SELECT count(*) FROM mst_design where desg_no='"+des_no+"' and active='Y'";
                	System.out.println(sql);
    				ResultSet rs = st.executeQuery(sql);				
    						while (rs.next()) {
    						count=rs.getInt(1);	
    						}
    						out.println(count);
        %>
        
       			