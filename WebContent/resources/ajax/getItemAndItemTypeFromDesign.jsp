<%@page import="org.json.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>


        <%
            String itm_nm = "", itm_type_nm = "";
        	int itm_id=0, itm_type_id=0;  

String des_no=request.getParameter("des_no");
String co_id=request.getParameter("co_id");
System.out.println("des_no is:-"+des_no);
        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st= null;
                    String cid = "", cnm = "";
                    st = conn.createStatement();
                    String sql="select i.itm_id,i.itm_nm,t.itm_typ_id,t.itm_typ_nm,i.gst_per,d.desg_no,a.rate,d.bar_code from mst_design d join mst_fp_itm i on(i.itm_id=d.item_id) join mst_itm_typ t on(t.itm_typ_id=i.itm_typ_id) join mst_design_rt a on(d.tr_id=a.desg_id and co_id='"+co_id+"') where d.desg_no='"+des_no+"' and  a.default_rate='Y'";
                	System.out.println(sql);
                	
    				ResultSet rs = st.executeQuery(sql);	
    				ResultSetMetaData rsmd = rs.getMetaData();
    				JSONObject obj = new JSONObject();
    				while(rs.next()) {
    				  int numColumns = rsmd.getColumnCount();
    				  
    				  for (int i=1; i<=numColumns; i++) {
    				    String column_name = rsmd.getColumnName(i);
    				    obj.put(column_name, rs.getObject(column_name));
    				  }
    				  //json.put(obj);
    				}
    				out.println(obj);
    						
    						
        %>
        
        
       
				
					 
                          
				

			