<%@ include file="./include.jsp"%>
<%@ page session="false" %>
<c:set var="context" scope="request" value="<%= request.getContextPath()%>" />
<html>
<head>
	<title>Event  Management</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/nav.css" />
</head>
<body>
<%@ include file="./userNavbar.jsp"%>
<h2>Welcome <%=obj.getFirst_name()  %>!!!</h2>
<center>
	

<br/>

<img src="${context}/resources/images/eternal.jpg" width="400" height="400">

<br>
<br>
<br>
</center>
</div>
</body>
</html>
