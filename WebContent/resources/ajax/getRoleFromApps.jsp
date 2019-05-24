<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<script>
	$(function() {
		$("input").checkboxradio();
	});
</script>

        <%
            String mid = "", mnm = "";

String app_id=request.getParameter("app");
System.out.println("damn i is:-"+app_id);
        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st= null;
                    String cid = "", cnm = "";
                    st = conn.createStatement();
               
               // ResultSet rs1 = st1.executeQuery("SELECT app_id,app_nm FROM adm_app");
        %>
        
       <%
				String value=request.getParameter("hid");
					int i = 0;
					String sql="SELECT menu_id,menu_nm FROM adm_menu where app_id='"+app_id+"' and parent_menu <> 0 order by menu_order";
					System.out.println(sql);
				ResultSet rs = st.executeQuery(sql);				
						while (rs.next()) {
							i++;
							mid = rs.getString("menu_id");
							mnm = rs.getString("menu_nm");
				%>
				<table>
					<tr>
						<td><label for="checkbox-<%=mid%>" id="<%=mid%>"><%=mnm%></label>
							<input type="checkbox" name="menuId[]" id="checkbox-<%=mid%>" value="<%=mid%>" onclick=""></td>
						<td>
						<label style="" for="checkbox-add<%=mid%>">Add</label> 
						<input type="checkbox" class="" name="" id="checkbox-add<%=mid%>" value="add<%=mid%>" onclick="check(this.id);"> 
						<textarea style="display: none;" id="add<%=mid%>" name="addId[]">no</textarea>
						</td>
						
						<td>
						<label for="checkbox-edit<%=mid%>">Edit</label> 
						<input type="checkbox" class="" name="" id="checkbox-edit<%=mid%>" value="edit<%=mid%>" onclick="check(this.id);">
						<textarea style="display: none;" id="edit<%=mid%>" name="editId[]">no</textarea>
						</td>
						<td>
						<label for="checkbox-del<%=mid%>">Delete</label> 
						<input type="checkbox" class="" name="" id="checkbox-del<%=mid%>" value="del<%=mid%>" onclick="check(this.id);">
						<textarea style="display: none;" id="del<%=mid%>" name="deleteId[]">no</textarea>
						</td>
						<td>
						<label for="checkbox-view<%=mid%>">View</label>
						 <input type="checkbox" class="" name="" id="checkbox-view<%=mid%>" value="view<%=mid%>" onclick="check(this.id);">
						 <textarea style="display: none;" id="view<%=mid%>" name="viewId[]">no</textarea>
						 </td>
					</tr>
				</table>

				<%
					}
				%>