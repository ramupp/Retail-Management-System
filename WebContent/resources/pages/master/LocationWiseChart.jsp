<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
 <head>
        <meta charset="utf-8">
       <title>Location Rate Wise Chart</title>
       <%@include file="../common/include.jsp" %>
<!--<script src="../../js/jquery.serializejson.js"></script>-->
<script src="../../../resources/js/validation.js"></script> 

 <script>
            function validation1()
            {
                //alert("hiii");
                var id = document.getElementById("rt_typ_id");
                var name = document.getElementById("rt_typ_nm");
              
                errors=[];
                checkBlank(id,"ID");
                checkBlank(name,"Name");
               
                return finalCheck();
               
                
            }

        </script>

  
	  	


</head>
<body class="fixed-sn light-blue-skin">

<%@include file="../common/menu.jsp" %>
             
 <main>
 
    <form action="LocationWiseChartQry.jsp" id="myForm" name="myForm" method="post" onsubmit="return validation()">
    
    <center>
            <div class="card card-cascade wider" style="width: 100%;">
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2">Location Wise Rate Chart</div>
       <div class="card-body">
         <div id="jsGrid"></div>
       </div>
       </div>
      
                  
          <%

                       
          		Connection cons=null;
       			//con = DriverManager.getConnection("jdbc:mysql://192.168.1.232:3306/"+db, "root", "root")
                     String db = "adm_retail";
                     MyConnection mc=new MyConnection();
                     cons = mc.getConnection(db);
                     Statement stmt1 = cons.createStatement();
                     Statement stmt2 = cons.createStatement();
                     Statement stmt3 = cons.createStatement();

                 
                    String desg_no = request.getParameter("desg_no");
                    String cost = request.getParameter("cost");


                    ResultSet rs1 = stmt1.executeQuery("select b.tr_id,a.desg_no,a.cost,rt_type, group_concat(concat(b.co_id,b.rate)) from mst_design a left join mst_design_rt b on (b.desg_id=a.tr_id) group by a.desg_no,rt_type");
                    ResultSet rs2 = stmt2.executeQuery("select co_id,co_nm from mst_company");
                    ResultSet rs3 = stmt3.executeQuery("select rate from mst_design_rt where co_id='2'");


                   
                %>
                 
               
              
                  
 <div class="modal-body">
                                     
							<!--Table-->
  <table id="grid-selection" class="table table-condensed table-hover table-striped">
   
    <thead class="blue-grey lighten-4">
        <tr>
         	
               	<th data-column-id="state_name" data-order="desc" style="display: none;" data-visible="false" >Sl No</th>
               	<th data-column-id="state_name" data-order="desc">Design</th>
               	<th data-column-id="state_name" data-order="desc">Cost</th>
               	<th data-column-id="state_name" data-order="desc">Rate Type</th>
               	<%while(rs2.next()){ %>
               	<th data-column-id="state_name" data-order="desc"><%=rs2.getString(2)%></th>
               	
               	 
                	<% }%>
               	
           </tr>
           
    </thead>
  

   
     <tbody>
     


                        <%while (rs1.next()) { 
                        %>
                        <tr>

                            <td style="display:none;"><%=rs1.getString(1)%>
							<td><%=rs1.getString(2)%>
                             <td><%=rs1.getString(3)%>
                              <td><%=rs1.getString(4)%>
                              <%
                              String x=rs1.getString(5);
                              String m[]=x.split(",");
                              rs2.beforeFirst();
                              while(rs2.next()){//System.out.println(" i am in rs2");
                            	  double fin_rate=0.00;
                            	  int px=rs2.getInt(1);
                            	  //System.out.println("px is:="+px);
                            	  for(int k=0;k<m.length;k++){
                            		  int n=Integer.parseInt(m[k].substring(0,1));
                            		 // System.out.println("n is:-"+n);
                            		  if(px==n)
                            		  {
                            			  fin_rate=Double.valueOf(m[k].substring(1));
                            		  }
                            		  
                            	  }
                            	  %>
                              <td><%=fin_rate%>
                              
                               <%} %>
                        
                              
                      </tr> 
                        
                               
                        <%}%>
                      
                    </tbody>
  

</table>

	<div class="modal-footer">
                       
                          </div>
                </div>
                <!--/.Content-->
            </div>
        </div>
      </div>
      
       </center>     
 	</form>
 </main>
 	</body>
  <%@include file="../common/footer.jsp" %>
</html>