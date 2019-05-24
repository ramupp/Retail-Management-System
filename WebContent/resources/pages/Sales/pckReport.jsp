<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
    
        <meta charset="utf-8">
        <title>CashMemo....</title>
        
            <script src="../../../resources/js/jquery-1.11.0.js"></script> 
        <%@include file="../common/include.jsp" %>
<!--          <script src="../../../resources/js/packingSlip.js"></script>  -->
    
        

<style type="text/css">
.table-wrapper {
    display: block;
    max-height: 300px;
    overflow-y: auto;
    -ms-overflow-style: -ms-autohiding-scrollbar;
}

}
</style>
<script type="text/javascript">

$(document).ready(function() {
   
   
   $('.datepicker').pickadate({
  	
  	  format: 'yyyy-mm-dd'
  	});

 

 
 

});

</script>
<script type="text/javascript">

//function submitData() {
//	alert("hello");



//}
</script>
    


    </head>
    <body class="fixed-sn mdb-skin-custom ">
<%@include file="../common/menu.jsp" %>

        
        <main>
        <form id="form1" name="form_1" method="post" >
 <div class="main-wrapper">
          <div class="container-fluid">
     <%
     String input=request.getParameter("input");
     String input1=request.getParameter("input1");
     
     String text=util.getGSTamtInWord(input,"pck_sl_no",input1,"pck_slp_hdr");
     %>
    <div class="card-header deep-orange lighten-1 white-text text-center z-depth-2"> Packing Slip</div>
       <div class=" card-body">
                 
                  <table cellpadding="0" cellspacing="0" >
                    <tr>
                        <td align="left">
                            <iframe id="i1" style=" height: 100%; width: 85%; position: absolute; margin-bottom: 35px; overflow-x: scroll;" src="../../../../birt-viewer/frameset?__report=/Retail/pckSlip.rptdesign&__showtitle=false& __title=false&pck_sl_no=<%=input%>&co_id=<%=input1%>&gstword=<%=text%>"></iframe>
                            <div style="display: none;">
                                <div id="toNewWindow">
                                    <%  String reportUrl = "pckSlip.rptdesign&pck_sl_no=" + input + "&co_id=" + input1+"&gstword="+text ;
                                        session.setAttribute("reportUrl", reportUrl);
                                    %>
                                </div>
                            </div>
                        </td>
                    </tr>
                </table>
                    </div>
                    
                    
                    </div>
                   
                 </div>
                
      
<!--        </div> -->
       <br>
                 
                     
    </div>        
       </form>
      
         </main>
         
    </body>
    <%@include file="../common/footer.jsp" %>
</html>
