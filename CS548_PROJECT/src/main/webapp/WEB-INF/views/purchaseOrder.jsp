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
			<th>Price</th>
		</tr>
		<c:set var="total" value="${0}"/>
		<c:forEach items="${eventList.eventList}" var="curEvent"
			varStatus="status">
			<tr>
			    <td>${curEvent.eventName}</td>
				<td align="center">${curEvent.eventPrice}</td>				
			</tr>
			<c:set var="total" value="${total + curEvent.eventPrice}" />
		</c:forEach>
		<tr>
			    <td align="right">SubTotal:</td>
				<td align="center"><c:out value="${total}"/></td>				
			</tr>
			<tr>
			    <td align="right">Discount [<c:out value="${deal}"/>%]:</td>
			    <c:set var="discount" value="${total * deal/100}" />
				<td align="center">-<c:out value="${discount}"/></td>				
			</tr>
			<tr>
			    <td align="right">Total : </td>
			    <c:set var="tot" value="${total -discount}" />
				<td align="center"><c:out value="${tot}"/></td>				
			</tr>
	</table>
	<br />
</body>
</html>
