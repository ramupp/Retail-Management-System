 
 <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>

 

        <%
        int ii=Integer.parseInt(request.getParameter("incr"));
            String rid = "", rnm = "";
//String app_id=request.getParameter("app_id");
System.out.println("damn i is:-"+ii);
        MyConnection mc=new MyConnection();
        int p=ii-1;
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st,st1= null;
                    String cid = "", cnm = "",appid="",appnm="";
                    st = conn.createStatement();
                    st1 = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT co_id,concat(co_nm,' ',outlet) co_nm FROM mst_company");
                ResultSet rsp = st1.executeQuery("SELECT role_nm,role_id FROM adm_role_hd");
        %>
<script>

$(document).ready(function() {
	var p='#cid'+<%=ii%>;
	
    $(p).material_select();
  });
</script>
                <table id="mlast">
                        
                        <tr>
                            <td>
                                Select a company:
                            </td>
                           <td colspan="1">
                            
<%--                                 <select name="cId[<%=ii %>]" onchange=""> --%>
                                <select id="cid<%=ii%>" name="cId[<%=ii %>]" onchange="" class="mdb-select colorful-select dropdown-danger">
                                <option value='0'>--select a value--</option>
                                    <%
                                        while (rs.next()) { 
                                            cid = rs.getString("co_id");
                                            cnm = rs.getString("co_nm");
                                    %>
                                    <option value="<%=cid%>"><%=cnm%></option>

                                    <%
                                        }
                                    %>
                                </select>
                            </td>
                        </tr>
                        
                        <%
                        while (rsp.next()) {
							//i++;
							rid = rsp.getString("role_id");
							rnm = rsp.getString("role_nm");
                        System.out.println("hellooo arnab");
                        
                        %>
                        <tr id="newApp<%=ii%>">
                       <td> 
                            
 							<input type="checkbox" class="filled-in form-check-input" name="roleId[<%=ii %>][]" id="checkbox-<%=ii%><%=rid%>" value="<%=rid%>">
 							<label class="form-check-label" for="checkbox-<%=ii%><%=rid%>" id="<%=rid%>"><%=rnm%></label> 
 							
 							</td> 
						 </tr>
                       <%
                        }
                       %>
                      
                  </table>     

                    