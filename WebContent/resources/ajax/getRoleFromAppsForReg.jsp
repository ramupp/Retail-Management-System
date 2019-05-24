<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<script>
	$(function() {
		$("input").checkboxradio();
	});
</script>
        <%
            String rid = "", rnm = "";

//String app_id=request.getParameter("app");
int ii=Integer.parseInt(request.getParameter("incr"));
        MyConnection mc=new MyConnection();
     int p=ii-1;   
    	Connection conn=mc.getConnection("adm_retail");
                     Statement stp= null;
                    String cid = "", cnm = "";
                    stp = conn.createStatement();
               
               // ResultSet rs1 = st1.executeQuery("SELECT app_id,app_nm FROM adm_app");
        %>
        
       <%
				String value=request.getParameter("hid");
					int i = 0;
					String sql="SELECT role_nm,role_id FROM adm_role_hd";
					System.out.println(sql);
				ResultSet rsp = stp.executeQuery(sql);				
						while (rsp.next()) {
							i++;
							rid = rsp.getString("role_id");
							rnm = rsp.getString("role_nm");
				%>
				
                              <td><label for="checkbox-<%=rid%>" id="<%=rid%>"><%=rnm%></label> 
- 							<input type="checkbox" name="roleId[<%=p %>][]" id="checkbox-<%=rid%>" value="<%=rid%>" onclick=""></td> 
						
                       

				<%
					}
				%>