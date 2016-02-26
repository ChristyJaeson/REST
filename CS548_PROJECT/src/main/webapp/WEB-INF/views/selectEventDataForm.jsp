<%@ include file="./include.jsp"%>
<%@ page session="false" %>
<c:set var="context" scope="request" value="<%= request.getContextPath()%>" />
<html>
<head>
	<title>Events Page</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/nav.css" />
</head>
<body>
<%@ include file="./homeNavbar.jsp"%>

<h1>Checkout the Events of your convineience...</h1>
 <form:form action="./processEventInformation" method="POST" commandName="event">
 <table>
  
  
 <tr>
  	<td><fmt:message key="eventAreaLabel" /></td>
  	<td><form:input path="eventArea" />
  		<form:errors path="eventArea" cssClass="error"/></td>
  </tr>
  
  <tr>
  	<td><fmt:message key="locationLabel" /></td>
  	<td><form:input path="location" />
  		<form:errors path="location" cssClass="error"/></td>
  </tr>
  
  
  <tr>
    <td><input type="submit" value="<fmt:message key="submitBtn" />"> </td>
    </tr>
  
  </table>
  </form:form>
 
</body>
</html>