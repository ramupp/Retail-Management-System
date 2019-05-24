<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>

        <%
            String itm_nm = "", itm_type_nm = "";
        	double stock=0.0;  

String itm_typ_id=request.getParameter("type");
String item=request.getParameter("item");
String coid=request.getParameter("coid");

System.out.println("itm_typ_id is:- "+itm_typ_id);
        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st= null;
                    String cid = "", cnm = "";
                    st = conn.createStatement();
                    String sql="SELECT cl_bal FROM trn_stock_rm where item_id='"+item+"' and item_type_id='"+itm_typ_id+"' and co_id='"+coid+"' and active='Y'";
                	System.out.println(sql);
    				ResultSet rs = st.executeQuery(sql);				
    						while (rs.next()) {
    							
    						stock=rs.getDouble(1);	
    						}
    						
    						out.println(stock);
        %>
        
       
				  

                       
                          

                       
			
				

			