<%@page import="org.json.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<head>
<script>
$('#desg_on1').pickadate({
  	
	  format: 'yyyy-mm-dd'
	});
$(function() {
	$('img').on('click', function() {
		$('.enlargeImageModalSource').attr('src', $(this).attr('src'));
		$('#enlargeImageModal').modal('show');
	});
});
</script>
  <%-- 	<script type="text/javascript">

jQuery(document).ready(function() {
    
 var bean="PartyTypeBean";
 var valcol=["active"];
 var valv=["Y"];
 var getDatas={beanName:bean,valColumn:valcol,valValue:valv};
 var params1=JSON.stringify(getDatas);
 var select_id="party_typ_id";
 var selectedCol1="party_typ_id,party_typ_nm";
 CallDropDownService(params1,select_id,selectedCol1);
 
 var bean1="RetailCompanyMasterBean";
 var valcol1=["active"];
 var valv1=["Y"];
 var getDatas1={beanName:bean1,valColumn:valcol1,valValue:valv1};
 var params1=JSON.stringify(getDatas1);
 var select_id1="co_id";
 var selectedCol1="co_id,co_nm,outlet";
 CallDropDownServiceForConcat(params1,select_id1,selectedCol1);
 
 var bean2="StateMasterBean";
 var valcol2=["active"];
 var valv2=["Y"];
 var getDatas2={beanName:bean2,valColumn:valcol2,valValue:valv2};
 var params2=JSON.stringify(getDatas2);
 var select_id2="state_id";
 var selectedCol2="state_id,state_nm";
 CallDropDownService(params2,select_id2,selectedCol2);

});

</script>
<script type="text/javascript">

function getCity()
{
	var strs=$('#state_id').val();
	//alert(strs);
	var bean2="CityMasterBean";
	 var valcol2=["active","state_id"];
	 var valv2=["Y",strs];
	 var getDatas2={beanName:bean2,valColumn:valcol2,valValue:valv2};
	 var params2=JSON.stringify(getDatas2);
	 var select_id2="city";
	 var selectedCol2="city_id,city_nm";
	 CallDropDownService(params2,select_id2,selectedCol2);
	
	}
</script>--%>

</head>

      <%
 	
  String party_id=request.getParameter("party_id");
      String sl_no=request.getParameter("sl_no");
 UtilityHelper util=new UtilityHelper();
 
         MyConnection mc=new MyConnection();
     	Connection conn=mc.getConnection("adm_retail");
                      Statement st= null;
                      Statement st1=null;
                      Statement st2,st3=null;
                     String cid = "", cnm = "";
                     st = conn.createStatement();
                 
                     String sql3="select a.party_id, party_typ, party_nm, party_add1, party_add2, party_add3, city, state, pin,gst_no, phone, email,web_site, fax ,b.party_typ_nm from mst_party a" +
                    		 " join mst_party_typ b on (a.party_id=b.party_typ_id) where party_id="+party_id+"";
                    		
                 
                     System.out.println(sql3);
               
                     
                 ResultSet rs1 = st.executeQuery(sql3);
               
 %>
       <div class="row no-gutters">
        <div class=" col-10 " >
       
          	<table class="table table-hover" style" width: 90%">
							
<%	while (rs1.next()) {
    							
    						
 %>
							<tr>
							
							 <th>
                        Associate Type:
                        </th>
                        <td>
                        <select name="party_typ_nm" id="party_typ_id" class="mdb-select  colorful-select dropdown-primary x" >
                        <% 
                        String yyx=util.getDropdownString("mst_party_typ","party_typ_id","party_typ_nm",String.valueOf(rs1.getString("party_typ_nm")));
                        out.print(yyx);
                        %>           
                        </select>
                        </td>
							
							<%--<th>
                        Select Outlet (For Stock Transfer Only):
                        </th>
                        <td>
                        <select name="co_id" id="co_id" class="mdb-select  colorful-select dropdown-primary x" >
                        <% 
                        String yyx1=util.getDropdownString("mst_company","co_id","co_nm",String.valueOf(rs1.getString("co_nm")));
                        out.print(yyx1);
                        %>           
                        </select>
                        </td> --%> 
							
						<%--  <td> Select Associate Type:</td>
							<td> <select name="party_typ" id="party_typ_id" class="mdb-select  colorful-select dropdown-primary " >
                        <option value='0'>---select Option---</option>
                        </select>
                        </td>
						
							<td>Select Outlet (For Stock Transfer Only):</td>
							<td> <select name="co_id" id="co_id" class="mdb-select  colorful-select dropdown-primary " >
                        <option value='0'>---Select Option---</option>
                        </select>
                        </td> --%>
						
							
						
<td>Name:</td>
<td><input type="text" name="party_nm" id="party_nm" placeholder="Name" onchange="checkDuplicate(this.value)" value="<%=rs1.getString("party_nm")%>"></td>

	</tr>
	<tr>
		<td>Address:</td>
<td><input type="text" name="party_add3" id="party_add3" value="<%=rs1.getString("party_add3") %>" placeholder="Address"></td>
	
	

<td>Address1:</td>
<td><input type="text" name="party_add1" id="party_add1" value="<%=rs1.getString("party_add1") %>" placeholder="Address1" onchange="checkDuplicate1(this.value)"></td>

<td>Address2:</td>
<td><input type="text" name="party_add2" id="party_add2" value="<%=rs1.getString("party_add2") %>" placeholder="Address2"></td>
</tr>
<tr>

		<td>State:</td>
							<td> <select name="state" id="state_id"  class="mdb-select  colorful-select dropdown-primary " onchange="getCity()">
                        <option value='0'>---select Option---</option>
                        </select>
                        </td>
						
<td>City:</td>
<td> <select name="city" id="city" class="mdb-select  colorful-select dropdown-primary " >
                        <option value='0'>---select Option---</option>
                        </select></td>
                          <td>Pin:</td>
<td><input type="text" name="pin" id="pin" value="<%=rs1.getString("pin") %>"  placeholder="pin" style="text-align: right"></td>
</tr>
<tr>
					
                        
                      

       
          <td><label for="sgTag"> SG Tag : </label>
                            <td> <select name="sd_tag" id="sd_tag" class="mdb-select colorful-select dropdown-danger">  
                             <option value='0'>---select Option---</option>                          
                             <option value="Y">Yes</option>
                             <option value="N">No</option>   
                             </select>
                             </td>
                             <td>GST Number:</td>
<td><input type="text" name="gst_no" id="gst_no" value="<%=rs1.getString("gst_no") %>" placeholder="GST" style="text-align: right"></td>

<td>Phone:</td>
<td><input type="text" name="phone" value="<%=rs1.getString("phone") %>" id="phone" placeholder="Phone" style="text-align: right"></td>
                             
                             
       
       
        </tr>  
                 

<tr>

<td>Email:</td>
<td><input type="text" name="email" value="<%=rs1.getString("email") %>" id="email" placeholder="Email"></td>



<td>Web Site:</td>
<td><input type="text" name="web_site" value="<%=rs1.getString("web_site") %>" id="web_site" placeholder="Web Site"></td>

<td>FAX:</td>
<td><input type="text" name="fax" id="fax" value="<%=rs1.getString("fax") %>" placeholder="FAX" style="text-align: right"></td>
  </tr> 
  
  </div>
  
   
          
                   
                      
		 <% } %>
							
	</table>
                
                  </div>
                  
                </div>
                 