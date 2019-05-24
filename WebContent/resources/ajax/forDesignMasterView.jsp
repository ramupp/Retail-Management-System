<%@page import="org.json.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
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

<!--  <script type="text/javascript">
var modal = document.getElementById("myModal");

// Get the image and insert it inside the modal - use its "alt" text as a caption
var img = document.getElementById("myImg");
var modalImg = document.getElementById("img01");
var captionText = document.getElementById("caption1");
img.onclick = function(){
    modal.style.display = "block";
    modalImg.src = this.src;
    captionText.innerHTML = this.alt;
}

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function() { 
  modal.style.display = "none";
}
 
</script>-->

        <%
            String itm_nm = "", itm_type_nm = "";
        	int itm_id=0, itm_type_id=0;  

String id=request.getParameter("tr_id");
UtilityHelper util=new UtilityHelper();

        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st= null;
                     Statement st1= null;
                    String cid = "", cnm = "";
                    st = conn.createStatement();
                    String sql="SELECT tr_id, desg_no, v_desg_no, date_format(desg_on,'%Y-%m-%d') desg_on, desg_desc, item_typ, item_id, bar_code, notes, design_by, file_name, cost FROM mst_design where tr_id='"+id+"'";
                	System.out.println(sql);
                	
    				ResultSet rs = st.executeQuery(sql);	
    				ResultSetMetaData rsmd = rs.getMetaData();
    				JSONObject obj = new JSONObject();
    				while(rs.next()) {
    				  int numColumns = rsmd.getColumnCount();
    				  
    				  for (int i=1; i<=numColumns; i++) {
    				    String column_name = rsmd.getColumnName(i);
    				    obj.put(column_name, rs.getObject(column_name));
    				  }
    				  //json.put(obj);
    				}
    				//out.println(obj);
    						
    						
        %>
       <div class="row no-gutters">
        <div class=" col-10 " >
                 <table  border="0" style=" width: 90%; ">
                   <tr>
                    <th>
				Design No:
				</th>
				<td><input type="hidden" name="tr_id" id="tr_id" class="form-control"  style=" width: 75%;" value="<%=obj.get("tr_id") %>"/>
				 <input type="text" name="desg_no" id="desgNo" class="form-control"  style=" width: 75%;" value="<%=obj.get("desg_no") %>"/>
				
				</td>
                <th>
                      Vendor Desg No:
                        </th>
                        <td>
                        	 <input type="text" name="v_desg_no" id="v_desg_no" class="form-control" value="<%=obj.get("v_desg_no") %>"/>
                        
                        </td>

                            <th>
                                Designed On :
                            </th>

                            <td>
                               <input placeholder="Selected date" type="text" name="desg_on" id="desg_on1" class="form-control datepicker" value="<%=obj.get("desg_on") %>">
                        
                            </td>
                        </tr>
                      
						<tr>
						<th>
                               Design By:
                            </th>

                            <td>
                                 
                        <select name="design_by" id="design_bys" class="mdb-select  colorful-select dropdown-primary x" >
                        <% 
                        String yy=util.getDropdownString("mst_party","party_id","party_nm",String.valueOf(obj.get("design_by")));
                        out.print(yy);
                        %> 
                        </select>
                            </td>
                            <th>
                                Item Type:
                            </th>

                            <td>
                                 
                        <select name="item_typ" id="item_typ" class="mdb-select  colorful-select dropdown-primary x" onchange="getItems(this.value)">
                        <% 
                        String yyy=util.getDropdownString("mst_itm_typ","itm_typ_id","itm_typ_nm",String.valueOf(obj.get("item_typ")));
                        out.print(yyy);
                        %>
                        </select>
                            </td>

                     
                        <th>
                        Item:
                        </th>
                        <td>
                        <select name="item_id" id="item_id" class="mdb-select  colorful-select dropdown-primary x" >
                        <% 
                        String yyx=util.getDropdownString("mst_fp_itm","itm_id","itm_nm",String.valueOf(obj.get("item_id")));
                        out.print(yyx);
                        %>           
                        </select>
                        </td>
                        </tr>
                        
                        <tr>
                        <th>
                       Barcode:
                        </th>
                        <td>
                         <input type="text" name="bar_code" id="bar_code1" class="form-control" style=" width: 100%; float: left" value="<%=obj.get("bar_code") %>" readonly/>
                        </td>
                        <td>
<%--                         <button onclick="printCode(<%=obj.get("bar_code") %>)">Print</button> --%>
                        </td>
                        <th>
                        Image:
                        </th>
                        <td colspan="2">
                        
                        <div class="file-field">
            <div class="btn btn-primary btn-sm float-left">
                <span>Choose file</span>
                <input type="file" id="design_pic1" name="file">
            </div>
            <div class="file-path-wrapper">
                <input class="file-path validate" type="text" placeholder="Upload your file" name="file_name" value="<%=obj.get("file_name") %>">
            </div>
        </div>
                        </td>
                        
                        </tr>
                          <tr>
                       
                            <th>
                                Description:
                            </th>

                            <td>
                                <textarea type="text" id="desg_desc"  name="desg_desc" class="md-textarea form-control"><%=obj.get("desg_desc") %></textarea>
                            </td>

                      
<!--                         <th> -->
<!--                        Comment: -->
<!--                         </th> -->
<!--                         <td > -->
<!--                          <textarea type="text" id="notes"  name="notes" class="md-textarea form-control"></textarea> -->
<!--                         </td> -->
 						<th>
                      Cost:
                        </th>
                        <td>
                        	 <input type="text" name="cost" id="cost" class="form-control" value="<%=Double.valueOf(String.valueOf(obj.get("cost")))%>"/>
                        
                        </td>
                        </tr>
                        <tr>
                         <td> 
<!--                          <img id="disImg" src="#" alt="your image"  class="img-fluid z-depth-1" alt="1"/> -->
                         <div class="modal fade" id="enlargeImageModal" tabindex="-1" role="dialog" aria-labelledby="enlargeImageModal" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document" >
      <div class="modal-content">
<!--         <div class="modal-header"> -->
<!--           <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">Close</span></button> -->
<!--         </div> -->
        <div class="modal-body" class="bg-secondary">
          <img src="" class="enlargeImageModalSource" style="width: 50%;">
        </div>
      </div>
    </div>
</div>

       
                         
                         </td>
                        </tr>
                    </table>
                     
                 
                  </div>
                   <div class=" col-2 align-self-end" style=" float: right" >
                
        <figure >
        <% 
        String img_path="../../../../birt-viewer/Retail/UPLOAD/"+obj.get("file_name");
        System.out.println("img:-"+img_path);
        %>
                
                    <img src="<%=img_path %>" alt="placeholder"  id="myImg">
                
            </figure>
            </div>
                </div>
                  <div class="card border-warning">
                    <table  id="TableId1">
<!--                     <tr> -->
<!--                     <td colspan="7"><center>  <button type="button" class="btn btn-mdb-color btn-sm" onclick="addNewRow()"><i>ADD Details</i></button></center> -->
<!--                     </tr> -->
                    <tr>
                    <th>Outlet
                    <th>Sales Type
                    <th>Rate Type
                    <th>Rate Code
                    <th>Rate
                    <th>Remarks
                    <th>Default
                    <th><button type="button" class="btn btn-mdb-color btn-sm" onclick="addNewRow1()"><i>ADD Details</i></button>
                    </tr>
                    <% 
                    String sqls="select tr_id, co_id, desg_id, rt_type, rate, remarks, org_id, default_rate,rCode,sale_type from mst_design_rt where desg_id='"+id+"'";
                	System.out.println(sql);
                	
    				ResultSet rss = st.executeQuery(sqls);	
    				ResultSetMetaData rsmds = rss.getMetaData();
    			
    				JSONArray jsonarr=new JSONArray();
    				while(rss.next()) {
    					
    				  int numColumns = rsmds.getColumnCount();
    				  JSONObject objs = new JSONObject();
    				  for (int i=1; i<=numColumns; i++) {
    				    String column_name = rsmds.getColumnName(i);
    				    objs.put(column_name, rss.getObject(column_name));
    				  }
    				  jsonarr.put(objs);
    					System.out.println("the array is:-"+jsonarr);
    				}
    			
                   for(int x=0;x<jsonarr.length();x++){
                	   JSONObject objects = jsonarr.getJSONObject(x);
                    %>
                    <tr >
                    <td><select name="co_id[]" id="co_id" class="browser-default">
                        <% 
                        String xx=util.getDropdownString("mst_company","co_id","concat(co_nm,' ',outlet)",String.valueOf(objects.get("co_id")));
                        out.print(xx);
                        %>           
                        </select>
                        <td><select name="sale_type[]" id="sale_type" class="browser-default" >
                         <%
                 String ppx=String.valueOf(objects.get("sale_type"));
                   System.out.println("pp issssssssssssssssssssssss:-"+ppx);
                   if(ppx.equals("C")){ %>
                      <option value='C' selected>Cash Sale</option>      
                      <option value='CR'>Credit Sale</option> 
                      <%}else{ %>
                        <option value='C' >Cash Sale</option>      
                      <option value='CR' selected>Credit Sale</option> 
                      <%} %>     
                        </select>
                    <td><select name="rt_type[]" id="rt_type" class="browser-default">
                        <% 
                        String xxx=util.getDropdownString("mst_rate_typ","rt_typ_id","rt_typ_nm",String.valueOf(objects.get("rt_type")));
                        out.print(xxx);
                        %>         
                        </select>
                           <td><input type="text" name="rCode[]" id="rCode" value="<%=objects.get("rCode") %>"/>
                    <td><input type="text" name="rate[]" id="rate" style="width: 80px;" value="<%=objects.get("rate") %>" />
                    <input type="hidden" name="tr_ids[]" id="tr_ids" value="<%=objects.get("tr_id") %>" />
                    <td><input type="text" name="remarks[]" id="remarks" style="width: 60px;" value="<%=objects.get("remarks") %>" />
                   
                   <td>
                   <select name="default_rate[]" id="default_rate" class="browser-default">
                   <%
                 String pp=String.valueOf(objects.get("default_rate"));
                  // System.out.println("pp issssssssssssssssssssssss:-"+pp);
                   if(pp.equals("Y")){ %>
                        <option value='N' >No</option> 
                         <option value='Y' selected>Yes</option> 
                        <%}else{ %>   
                        <option value='Y'>Yes</option>  
                         <option value='N' selected>No</option> 
                        <%} %>         
                        </select>
                   </td>
                    </tr>
                    <%} %>
                    </table> 
       </div>
				
			<script type="text/javascript">

$('#design_pic1').change(function(evt) {
	var files=evt.target.files;
    console.log("filename="+files[0]);
   // alert("Inside file upload..");
    var formData = new FormData();
    formData.append('file',files[0]);
    var barcode=document.getElementById("bar_code1").value;
    formData.append('barcode',barcode);
    console.log("form data " + formData);
    $.ajax({
        url : '../../../uploadDesignPic',
        data : formData,
        processData : false,
        contentType : false,
        type : 'POST',
        success : function(data) {
        	 console.log(data);
        },
        error : function(err) {
        	 console.log(err);
        }
    });
});

</script>	
 
                          
				

			