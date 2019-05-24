 
 <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*"%>
<%@ page import="com.crunchify.util.*"%>
        <%
            //String user_id = "";
        	//String user_nm = "";
String user_nm=request.getParameter("usernm");
//String ques=request.getParameter("ques");
System.out.println("damn i is:-"+ user_nm);
        MyConnection mc=new MyConnection();
    	Connection conn=mc.getConnection("adm_retail");
                     Statement st = null;
                    String cid = "", cnm = "";
                  
                   st = conn.createStatement();
                ResultSet rs = st.executeQuery("select user_nm, ques,ques_ans  from adm_reg where user_id='"+user_nm+"'");
        rs.next();
        %>

            <input type="text" name="quesAns" id="seqAns" class="form-control"  placeholder="Security Answer" value='<%=rs.getString(2)%>'/>