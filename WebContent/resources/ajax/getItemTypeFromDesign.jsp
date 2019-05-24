<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
        <%
   //         String rid = "", rnm = "";
//int ii=Integer.parseInt(request.getParameter("comp"));
//String app_id=request.getParameter("app_id");
//System.out.println("damn i is:-"+ii);
        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st= null;
                    String cid = "", cnm = "";
                    st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT itm_typ_id,itm_typ_nm FROM mst_itm_typ where prod_typ='RM' ");
               // ResultSet rs1 = st1.executeQuery("SELECT app_id,app_nm FROM adm_app");
               //System.out.println("Hi");
        %>
      <option value="0">-Select-</option>
				<%
				while (rs.next()) {
				%>
				<option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
				
				<% 
				
				}
				
				%>
			
        
       