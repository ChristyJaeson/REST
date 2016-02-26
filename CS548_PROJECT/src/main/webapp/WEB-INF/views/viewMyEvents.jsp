<%@ include file="./include.jsp"%>
<%@ page session="false" %>
<c:set var="context" scope="request" value="<%= request.getContextPath()%>" />
<html>
<head>
	<title>Events List</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/nav.css" />
</head>
<body>
<%@ include file="./userNavbar.jsp"%>
	<h2>Available Event Details:</h2>

	<table width="100%">
		<tr>
			<th>Event Name</th>
			<th>Event Type</th>
			<th>Event Date</th>
			<th>Duration</th>
		</tr>
		<c:forEach items="${eventList.eventList}" var="curEvent"
			varStatus="status">
			<tr>
			    <td>${curEvent.eventName}</td>
				<td align="center">${curEvent.eventType}</td>
				<td align="center">${curEvent.eventDate}</td>
				<td align="center">${curEvent.duration} hrs.</td>				
			</tr>

		</c:forEach>
	</table>
	<br />
</body>
</html>
