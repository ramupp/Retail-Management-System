<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>


<%
	int co_id=Integer.parseInt(request.getParameter("co_id"));	
 		int party_id=Integer.parseInt(request.getParameter("party_cd"));
        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st= null;
                     Statement st1=null;
             
                    String cid = "", cnm = "",result="";
                    st = conn.createStatement();
                    st1=conn.createStatement();
	// Commented by: Sk Samimuddin.
	// Date: 03/oct/2018
	// Desc: GST Calculation will based on State Code.
	
			/* String gst_cm="",gst_party="";
                    
                    String sql="select gst_no from mst_company where co_id="+co_id;
                    String sql1="SELECT gst_no FROM mst_party where party_id="+party_id;
                	
                    System.out.println(sql);
                	ResultSet rs = st.executeQuery(sql);	
                	rs.next();
                	gst_cm=rs.getString("gst_no");
                	gst_cm=gst_cm.substring(0, 2);
                	System.out.println(sql1);
                	ResultSet rs1 = st.executeQuery(sql1);	
                	rs1.next();
                	gst_party=rs1.getString("gst_no");
                	gst_party=gst_party.substring(0, 2);
                	
                	if(gst_cm.equalsIgnoreCase(gst_party)) */
                	
                	String state_code_cm = "",state_code_party = "";
                	 String sql="select substring(gst_no,1,2) state_code_cm from mst_company where co_id="+co_id;
                     String sql1="SELECT ms.state_cd as state_code_party FROM mst_party AS mp left join mst_state as ms on ms.state_id = mp.`state` where mp.party_id="+party_id;
                 	
                     System.out.println(sql);
                 	ResultSet rs = st.executeQuery(sql);	
                 	rs.next();
                 	state_code_cm=rs.getString("state_code_cm");
                 	System.out.println(sql1);
                 	ResultSet rs1 = st.executeQuery(sql1);	
                 	rs1.next();
                 	state_code_party=rs1.getString("state_code_party");
                	if(state_code_cm.equalsIgnoreCase(state_code_party))
                	{
                		result="true";
                		System.out.println("1");
                	}
                	else
                	{
                		result="false";
                		System.out.println("2");
                	}
                	
                	System.out.println(result);
                	out.println(result);
%>






