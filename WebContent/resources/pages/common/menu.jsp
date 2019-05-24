
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.crunchify.util.UtilityHelper"%>
<%@page import="com.crunchify.model.RetailRegistrationBean"%>
<%@page import="java.sql.*"%>
<%@page import="com.crunchify.util.MyConnection"%>
<script type="text/javascript">
function logout()
{
	alert("heyyyy");
	 $.get('../../../logoutFromAll',{}, function (response) {
     	alert(response);
      
        // $("#company_div").html(response);
//          x=parseInt(x)+1;
//          document.getElementById("flag_incr").value=x;
     });
	}


</script>
<%
Connection con=null;
MyConnection c=new MyConnection();
con=c.getConnection("adm_retail");
RetailRegistrationBean rbs=(RetailRegistrationBean)session.getAttribute("user1");
String user=rbs.getUser_id();
String coid=rbs.getCo_id();
UtilityHelper util=new UtilityHelper();
String p_co_nm=util.findCoNameFromId(Integer.parseInt(coid));
String m_org_nm=util.findOrgNameByCoId(Integer.parseInt(coid));
Statement stmt=con.createStatement();
Statement stmts=con.createStatement();
String sql="select menu_nm,menu_order,parent_menu,module_nm,file_nm,menu_id from adm_menu where menu_id in("+
"select distinct e.parent_menu from adm_reg a left join user_role b on(a.user_id=b.user_id) left join "+
" adm_role_hd c on(b.role_id=c.role_id ) left join adm_role_dt d on(c.role_id=d.role_id)"+
" left join adm_menu e on(d.menu_id=e.menu_id) where a.user_id='"+user+"' and b.co_id='"+coid+"' ) order by menu_order";


ResultSet rs=stmt.executeQuery(sql);
ResultSet rsp=null;

System.out.println(sql);
String path=request.getContextPath();
String p=path+"/resources/images/Picture1.png";
%>
<header>
        <!-- Sidebar navigation -->
        <div id="slide-out" class="side-nav sn-bg-4 fixed mdb-sidenav">
            <ul class="custom-scrollbar">
                <!-- Logo -->
                <li>
                    <div class="logo-wrapper waves-light" style="margin-bottom: 2px">
<!--                         <a href="#"><img src="" class="img-fluid flex-center"></a> -->
                        <img src="<%=p%>" class="img-fluid z-depth-5" alt="1">
                        
                    </div>
                </li>
               <li class="waves-effect" align="center"><%= m_org_nm%></li>
                <!--/. Logo -->
                <!--Social-->
                
                <!--/Social-->
                <!--Search Form-->
                <li>
                    <form class="search-form" role="search">
                        <div class="form-group md-form mt-0 pt-1 waves-light">
<!--                             <input type="text" class="form-control" placeholder="Search"> -->
                        </div>
                    </form>
                </li>
                <!--/.Search Form-->
                <!-- Side navigation links -->
                <li >
                    <ul class="collapsible collapsible-accordion">
                    
                   <%while(rs.next()){ %> 
                        <li ><a class="collapsible-header waves-effect arrow-r"><i class="fa fa-chevron-right"></i> <%=rs.getString(1) %><i class="fa fa-angle-down rotate-icon"></i></a>
                
               
                            <div class="collapsible-body">
                                <ul>
                              <%
                              String sql1=" select distinct e.menu_id,e.menu_nm,e.menu_order,e.parent_menu,e.module_nm,e.file_nm,d.add_per,d.edit_per,d.delete_per,d.view_per from adm_reg a left join user_role b"+
                            		  " on(a.user_id=b.user_id) left join adm_role_hd c on(b.role_id=c.role_id )"+
                            		  " left join adm_role_dt d on(c.role_id=d.role_id) left join adm_menu e on(d.menu_id=e.menu_id)"+
                            		  " where a.user_id='"+user+"' and b.co_id='"+coid+"' and parent_menu='"+rs.getString(6)+"' order by 3";
                              System.out.println("sql1 is:------"+sql1);
                              java.util.Date dt=new java.util.Date();
//                               SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss.SSS");
//                               String mm="?q="+sdf.format(dt);
                             rsp=stmts.executeQuery(sql1);
                              %>
                              <%while(rsp.next()){ 
                            	 // String path="/"+
                            	  %>
         <li><a href="../<%=rsp.getString(5)%>/<%=rsp.getString(6)%>?ap=<%=rsp.getString("d.add_per")%>&ep=<%=rsp.getString("d.edit_per")%>&dp=<%=rsp.getString("d.delete_per")%>&vp=<%=rsp.getString("d.view_per")%>" class="waves-effect"><%=rsp.getString(2) %></a>
                                    </li>
                                 <%} %>
                                </ul>
                            </div>
                        </li>
                        <%} %>
                     
                       
                    </ul>
                </li>
                <!--/. Side navigation links -->
            </ul>
            <div class="sidenav-bg mask-strong"></div>
        </div>
        <!--/. Sidebar navigation -->
        <!-- Navbar -->
        <nav class="navbar fixed-top navbar-toggleable-md navbar-expand-lg scrolling-navbar double-nav">
            <!-- SideNav slide-out button -->
            <div class="float-left">
                <a href="#" data-activates="slide-out" class="button-collapse"><i class="fa fa-bars"></i></a>
            </div>
            <!-- Breadcrumb-->
<!--             <div class="breadcrumb-dn mr-auto"> -->
<%--                 <p> Welcome :- <%=rbs.getUser_nm() %></p> --%>
<!--             </div> -->
             <div class="breadcrumb-dn mr-auto">
                <p> <%=p_co_nm %></p>
            </div>
            <ul class="nav navbar-nav nav-flex-icons ml-auto">
                <li class="nav-item">
                      <a class="nav-link"><span>Welcome :- <%=rbs.getUser_nm() %></span></a>
<!--                     <a class="nav-link"><i class="fa fa-envelope"></i> <span class="clearfix d-none d-sm-inline-block">Contact</span></a> -->
                </li>
<!--                 <li class="nav-item"> -->
<!--                     <a class="nav-link"><i class="fa fa-comments-o"></i> <span class="clearfix d-none d-sm-inline-block">Support</span></a> -->
<!--                 </li> -->
<!--                 <li class="nav-item"> -->
<!--                     <a class="nav-link"><i class="fa fa-user"></i> <span class="clearfix d-none d-sm-inline-block">Account</span></a> -->
<!--                 </li> -->
                <li class="nav-item">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fa fa-cog"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="#">Reset Password</a>
                        <a class="dropdown-item" href="../common/logout.jsp" >Logout</a>
                        
                    </div>
                </li>
            </ul>
        </nav>
        <!-- /.Navbar -->
    </header>
    <!--/.Double navigation-->

    <!--Main Layout-->
    
    <!--Main Layout-->
     <!-- Central Modal Medium Success -->
  <div class="modal fade" id="centralModalSuccess" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-notify modal-success" role="document">
      <!--Content-->
      <div class="modal-content">
          <!--Header-->
          <div class="modal-header">
              <p class="heading lead">Modal Success</p>
  
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true" class="white-text">&times;</span>
              </button>
          </div>
  
          <!--Body-->
          <div class="modal-body">
              <div class="text-center">
                  <i class="fa fa-check fa-4x mb-3 animated rotateIn"></i>
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Impedit iusto nulla aperiam blanditiis ad consequatur in dolores culpa, dignissimos, eius non possimus fugiat. Esse ratione fuga, enim,
                      ab officiis totam.</p>
              </div>
          </div>
  
          <!--Footer-->
          <div class="modal-footer justify-content-center">
              <a type="button" class="btn btn-success">Get it now <i class="fa fa-diamond ml-1"></i></a>
              <a type="button" class="btn btn-outline-success waves-effect" data-dismiss="modal">No, thanks</a>
          </div>
      </div>
      <!--/.Content-->
  </div>
  </div>
  <!-- Central Modal Medium Success-->
  
