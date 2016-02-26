<%@ include file="./include.jsp"%>
<%@ page session="false" %>
<c:set var="context" scope="request" value="<%= request.getContextPath()%>" />
<html>
<head>
	<title>Events List</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/nav.css" />
</head>
<body>
<%@ include file="./homeNavbar.jsp"%>
	<h2>User Details:</h2>

	<table width="100%">
		<tr>
			<th>User Name</th>
			<th>Password</th>
			<th>Fisrt Name</th>
			<th>Last Name</th>
			<th>Gender</th>
			<th>DOB</th>
		</tr>
		<c:forEach items="${userlist.userList}" var="curUser"
			varStatus="status">
			<tr>
			    <td>${curUser.username}</td>
				<td>${curUser.password}</td>
				<td>${curUser.first_name}</td>
				<td>${curUser.last_name}</td>
				<td>${curUser.gender}</td>
				<td>${curUser.birthdate}</td>
				
				<form method="post" action="./notavail" >
           
            <td><input type="submit" value="Check Availability"/></td>
            </form>


			</tr>

		</c:forEach>
	</table>
	<br />

<a href="${context}">Home</a>

</body>
</html>
