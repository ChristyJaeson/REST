<%@page import="com.npu.myproject.domain.User"%>
<link rel="stylesheet" type="text/css" href="${context}/resources/css/nav.css" />
<div id="titlebar">
   <h1>CJ Event Management Services</h1>
</div>
<div id="wrap">
  <ul id="nav">
  <li><a href="${context}/selecteventform">Select Events</a> 
  <li><a href="${context}/findDealform">Find Deals</a>
  <li><a href="${context}/viewCart">My Events</a>
  <li><a href="${context}/editProfile">Edit Profile</a>
  <%
	User obj = (User)request.getSession().getAttribute("user");
  %>
  <li><a href="${context}/logout">Logout(<%=obj.getUsername()  %>) </a>
  <li><a href="${context}/savings">Purchase Summary</a>
  
  
  </ul>
  