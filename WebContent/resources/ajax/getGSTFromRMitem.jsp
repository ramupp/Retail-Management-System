<%@page import="org.json.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>


        <%
           
        	int itm_id=0, itm_type_id=0;  

 itm_id=Integer.parseInt(request.getParameter("item"));
String co_id=request.getParameter("co_id");
itm_type_id=Integer.parseInt(request.getParameter("type"));
double rate=Double.parseDouble(request.getParameter("rate"));
//System.out.println("des_no is:-"+des_no);
        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st,st1= null;
                    String cid = "", cnm = "";
                    st = conn.createStatement();
                    st1 = conn.createStatement();
                    String sql1="select i.log_cond from mst_fp_itm i where itm_typ_id='"+itm_type_id+"' and itm_id='"+itm_id+"' and active='Y'";
                    ResultSet rsp = st.executeQuery(sql1);	
                    rsp.next();
                    String cond=rsp.getString(1);
                    String sql="select if("+rate+" "+cond+" i.amount,i.gst_per,i.gst_per1) gst_per,hsn_cd,(SELECT bar_code FROM mst_design where desg_no='MISC' ) bar_code from  mst_fp_itm i where itm_id="+itm_id+" and itm_typ_id="+itm_type_id+" and active='Y'";
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
        
        
       
				
					 
                          
				

			