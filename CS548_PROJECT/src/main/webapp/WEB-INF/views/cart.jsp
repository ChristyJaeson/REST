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
			<th>Price</th>
			<th>Avail</th>
		</tr>
		<c:forEach items="${eventList.eventList}" var="curEvent"
			varStatus="status">
			<tr>
			    <td>${curEvent.eventName}</td>
				<td>${curEvent.eventType}</td>
				<td>${curEvent.eventDate}</td>
				<td>${curEvent.duration} hrs.</td>
				<!-- td>${curEvent.location.city}</td-->
				<td>${curEvent.eventPrice}</td>
				<td>${curEvent.eventCapacity}</td>
				
				<form method="post" action="./book/${curEvent.id}" >
           
            <td><input type="submit" value="Book NOW!!."/></td>
            </form>


			</tr>

		</c:forEach>
	</table>
	<br />

<a href="${context}">Home</a>

</body>
</html>
