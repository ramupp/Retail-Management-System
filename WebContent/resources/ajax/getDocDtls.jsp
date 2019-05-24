 
 <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>

 

        <%
        String val=request.getParameter("val");
        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st= null;
                    st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT doc_id,doc_nm,type FROM mst_document_header where active='Y'");
                int i=0;
         
        %>

                <% while(rs.next()){
                	String docid=rs.getString(1);
                	String doc_nm=rs.getString(2);
                	String type=rs.getString(3);
                	%>
                        <tr>
                           <td colspan="2">
                           <input type="text" name="type[<%=val%>][]" id="type" value="<%=type %>" style=" width:10px; display: none" /> 
                           <input type="text" name="doc_id[<%=val%>][]" id="doc_id" value="<%=docid %>" style=" width:10px; display: none" /> 
                            <input type="text" name="flags[<%=val%>][]" id="flags" value="0" style=" width:10px; display: none">
                            <input type="checkbox" name="doc_nm[<%=val%>][]" id="doc_nm<%=val%><%=i%>" class="form-check-input" onclick="afterCheck(this,this.id)">
    <label class="form-check-label" for="doc_nm<%=val%><%=i%>"><%=doc_nm %></label>  
                             <input type="text" name="doc_nm1[<%=val%>][]" id="doc_nm1"  value="<%=doc_nm %>" style=" width:10px; display: none">
                            </td>
                         <td>
                         <input type="text" name="prefix[<%=val%>][]" id="prefix" style=" width:100px;" placeholder="Prefix" />
                         </td>
                          <td>
                         <input type="text" name="sufix[<%=val%>][]" id="sufix"  style=" width:100px;" placeholder="Suffix" />
                         </td>
                         <td>
                         <input type="text" name="digits[<%=val%>][]" id="digits"  style=" width:100px;" placeholder="No Of Digits"/>
                         </td>
                         <td>
                         <select name="sln_pattern[<%=val%>][]" id="sln_pattern" class="browser-default">
                        <option value='0'>---Select Option---</option>
                         <option value='Y'>Yearly</option>
                          <option value='M'>Monthly</option>
                           <option value='D'>Daily</option>
                        </select>
                         </td>
                        </tr>
                        <% i++;} %>
                         
                      
              

                    