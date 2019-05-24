<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
        <%
   //         String rid = "", rnm = "";
int cust_code=Integer.parseInt(request.getParameter("cust_code"));
int co_id=Integer.parseInt(request.getParameter("co_id"));
//String app_id=request.getParameter("app_id");
//System.out.println("damn i is:-"+ii);
        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st= null;
                    String cid = "", cnm = "";
                    st = conn.createStatement();
                    String sql="SELECT memo_no,tr_dt,net_amt,co_id,tr_hid FROM cash_sale_hd where uid='"+cust_code+"' and co_id='"+co_id+"' and vr_type='CASA'";
                    System.out.println("sql is------>"+sql);
                ResultSet rs = st.executeQuery(sql);
                
                %>
                <table class="table">
                <tr>
                <th>Existing Sales Detail:-</th>
                </tr>
                <% 
               // ResultSet rs1 = st1.executeQuery("SELECT app_id,app_nm FROM adm_app");
               while(rs.next()){
        %>
       
       <tr> 
       <th>
				Bill no:
				</th><td>&nbsp;
				<td> <%=rs.getString(1) %>        </td>
				
		 <th>
				Bill Date:
				</th><td>&nbsp;
				<td> <%=rs.getString(2) %>        </td>		
				 <th>
				Net Amount:
				</th><td>&nbsp;
				<td> <%=rs.getString(3) %>        </td>
				<td><div class="form-check">
  <input type="radio" class="form-check-input" id="CASA<%=rs.getString("tr_hid") %>" name="groupOfMaterialRadios" onclick="getSalesData('<%=rs.getString(1)%>',<%=co_id%>)">
  <label class="form-check-label" for="CASA<%=rs.getString("tr_hid") %>"></label>
</div></td>
				</tr>
				<%}%>
				</table>
				