
<%

// response.setHeader("Cache-Control", "no-cache");

// //Forces caches to obtain a new copy of the page from the origin server
// response.setHeader("Cache-Control", "no-store");

// //Directs caches not to store the page under any circumstance
// response.setDateHeader("Expires", 0);

// //Causes the proxy cache to see the page as "stale"
// response.setHeader("Pragma", "no-cache");
// response.setHeader("Cache-control","no-store"); //HTTP 1.1 
// response.setHeader("Pragma","no-cache"); //HTTP1.0 
// response.setDateHeader("Expire",0); //prevents caching at the proxy server 
//HTTP 1.0 backward enter code here
String logout_path=request.getContextPath();
System.out.println("------------------------"+request.getRequestURI());
request.getSession().invalidate();

response.setHeader("pragma", "no-cache");            
response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");           
response.setHeader("Expires", "0");



response.sendRedirect(logout_path);


%>
