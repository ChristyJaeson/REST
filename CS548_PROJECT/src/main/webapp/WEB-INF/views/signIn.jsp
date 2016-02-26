<%@ include file="./include.jsp"%>
<%@ page session="false" %>
<c:set var="context" scope="request" value="<%= request.getContextPath()%>" />
<html>
<head>
	<title>SignIn Page</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/nav.css" />
</head>
<body>
<%@ include file="./homeNavbar.jsp"%>

<form:form action="./processUserInformation" method="POST" commandName="user">
 <table>
  
  
 <tr>
  	<td><fmt:message key="usernameLabel" /></td>
  	<td><form:input path="username" />
  		<form:errors path="username" cssClass="error"/></td>
  </tr>
  
  <tr>
  	<td><fmt:message key="passwordLabel" /></td>
  	<td><form:password path="password" />
  		<form:errors path="password" cssClass="error"/></td>
  </tr>
  
  <tr>
    <td><input type="submit" value="<fmt:message key="submitBtn" />"> </td>
    </tr>
  
  </table>
  </form:form>
 
</body>
</html>