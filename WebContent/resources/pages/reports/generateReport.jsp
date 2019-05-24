<%@ page import="com.crunchify.util.*"%>
<%@ page import="java.sql.*"%>
<%
    String hid = request.getParameter("hid");
String rnm=request.getParameter("rnm");


MyConnection mc1=new MyConnection();
int i=1;
String val="&";
String par="";
String pur="";
String pnm="",pval="";
String parVal="/birt-viewer/frameset?__report="+rnm;
Connection conn1=mc1.getConnection("adm_retail");                    
String sql1="select param from tbl_report_dtl where hid="+hid;        
ResultSet rs1=mc1.getResultSet(sql1,"adm_retail");
while(rs1.next())
{
	pur="&";
	pnm = rs1.getString("param");
	pval=request.getParameter(pnm);
// 	if(pnm.equalsIgnoreCase("FromDate") || pnm.equalsIgnoreCase("ToDate"))
// 	{
// 		pval=pval + " 05:30:00";
// 	}
	
	 
	par = pnm  +  "=" + pval;  
	
	System.out.println("par==> "+par);
	pur = pur + par;
	System.out.println("pur1==> "+pur);
	parVal = parVal + pur ;
	 
}


//System.out.println("pur2==> "+pur);
System.out.println("parVal==> "+parVal);
%>

<!DOCTYPE html>
<html>  
    <head>
        
    </head>
    <body>
       
                            <table class="tbl" cellpadding="0" cellspacing="0" width="1000px">


                                <tr>
                                    <td align="left">
                                        <iframe id="i1" height="590" width="1040" src="<%=parVal%>"></iframe>                                  
                                        

                                    </td>
                                </tr>                               
                            </table> 
                        
                <div style="text-align: right;">
                    <img src="resources/images/fullscreen.png" width="200px" height="200px" title="Full Screen" onclick="OpenWindow()" id="fullScreen"/>                    
                    <script>                                        
                     function OpenWindow(){
                             window.open("ReportInNewWindowAction",'popUpWindow','height=700,width=800,left=10,top=10,resizable=yes,scrollbars=yes,toolbar=no,menubar=no,location=no,directories=no,status=yes');
                         }  
                    </script>
                    
                </div>                    

                     
       
    </body>
</html>
