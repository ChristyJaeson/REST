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
	<h2>Available Event Details:</h2>

	<table width="100%">
		<tr>
			<th>Event Name</th>
			<th>Event Type</th>
			<th>Event Date</th>
			
		</tr>
		<c:forEach items="${eventList.eventList}" var="curEvent"
			varStatus="status">
			<tr>
			    <td>${curEvent.eventName}</td>
				<td>${curEvent.eventType}</td>
				<td>${curEvent.eventDate}</td>
				
				
				<form method="post" action="./checkAvailability/${curEvent.id}" >
           
            <td><input type="submit" value="Check Availability"/></td>
            </form>


			</tr>

		</c:forEach>
	</table>
	<br />

<a href="${context}">Home</a>

</body>
</html>
