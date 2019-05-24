 
 <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
        <%
            String rid = "", rnm = "";
String user=request.getParameter("user");
System.out.println("damn i is:-"+ user);
        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st = null;
                    String cid = "", cnm = "";
                    st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT distinct a.co_id,concat(b.co_nm,', ',b.outlet) FROM user_role a left join mst_company b on(a.co_id=b.co_id) where a.user_id='"+user+"'");
        %>

             <select id="co_ids" name="co_id" class="mdb-select  colorful-select dropdown-primary">
             <% while(rs.next()){ %>
             <option value="<%=rs.getString(1) %>"><%=rs.getString(2) %></option>
             <%} %>
             </select>