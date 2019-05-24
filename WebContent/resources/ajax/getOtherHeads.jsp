<%@page import="org.json.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>


        <%
            String itm_nm = "", itm_type_nm = "";
        	int itm_id=0, itm_type_id=0;  

String type=request.getParameter("type");
System.out.println("des_no is:-"+type);
        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st= null;
                    String cid = "", cnm = "";
                    st = conn.createStatement();
                    String sql="SELECT oh_id,description,cal_typ,ifnull(gst_per,0.00) gst_per FROM mst_other_head where oh_id='"+type+"' and active='Y'";
                	System.out.println(sql);
                	
    				ResultSet rs = st.executeQuery(sql);	
    				ResultSetMetaData rsmd = rs.getMetaData();
    				JSONObject obj = null;
    				JSONArray json=new JSONArray();
    				while(rs.next()) {
    				  int numColumns = rsmd.getColumnCount();
    				  obj=new JSONObject();
    				  for (int i=1; i<=numColumns; i++) {
    				    String column_name = rsmd.getColumnName(i);
    				    obj.put(column_name, rs.getObject(column_name));
    				  }
    				  json.put(obj);
    				
    				}
    				out.println(json);
    						
    						
        %>
        
        
       
				
					 
                          
				

			