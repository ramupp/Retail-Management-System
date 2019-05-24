<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
        <%
            String rid = "", rnm = "";
int ii=Integer.parseInt(request.getParameter("comp"));
int iis=Integer.parseInt(request.getParameter("ii"));
String app_id=request.getParameter("app_id");
System.out.println("damn i is:-"+ii);
        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st= null;
                    String cid = "", cnm = "";
                    st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT app_id,app_nm FROM adm_app");
               // ResultSet rs1 = st1.executeQuery("SELECT app_id,app_nm FROM adm_app");
        %>
       <th>
				Select Application:
				</th>
				<td> 
        <select id="app_id" onchange="getRoleDetails(this.value,'newRole<%=--iis%>');">
				<option>Select an Application.</option>
				<%
				while (rs.next()) {
				%>
				<option value="<%=rs.getString("app_id")%>"><%=rs.getString("app_nm")%></option>
				
				<% 
				//str=rs1.getString("app_id");
				}
				
				%>
				</select>
        
        </td>