<%-- 
    Document   : item_master
    Created on : May 29, 2018, 12:44:40 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table class="tbl" cellpadding="0" cellspacing="0" width="500px">


                                

                                    
                                        <iframe id="i1" height="590" width="1040" src="/birt-viewer/frameset?__report=Retail/item_master_new.rptdesign"></iframe>                                  
                                        <div style="display: none;">
                                            <div id="toNewWindow">
                                                <%
                                                    //String reportUrl = "play_report.rptdesign&transaction_date=" + reportPushBean.getTransaction_date() + "&transaction_date1="+ reportPushBean.getTransaction_date1() + "&site_code=" + reportPushBean.getSite_code();
                                                    //session.setAttribute("reportUrl", reportUrl);
                                                    

                                                %>
                                            </div>
                                        </div>

                                    
                                


                            </table>
    </body>
</html>
