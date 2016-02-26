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

<form:form action="./newUserInformation" method="POST" commandName="user">
 <table>
  <tr>
  	<td><fmt:message key="fnameLabel" /></td>
  	<td><form:input path="first_name" />
  		<form:errors path="first_name" cssClass="error"/></td>
  </tr>
  
  <tr>
  	<td><fmt:message key="lnameLabel" /></td>
  	<td><form:input path="last_name" />
  		<form:errors path="last_name" cssClass="error"/></td>
  </tr>
  
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
  	<td><fmt:message key="genderLabel" /></td>
  	<td><form:input path="gender" />
  		<form:errors path="gender" cssClass="error"/></td>
  </tr>
  
  <tr>
  	<td><fmt:message key="birthdateLabel" /></td>
  	<td><form:input path="birthdate" />
  		<form:errors path="birthdate" cssClass="error"/></td>
  </tr>
  
  <tr>
    <td><input type="submit" value="<fmt:message key="submitBtn" />"> </td>
    </tr>
  
  </table>
  </form:form>
 
</body>
</html>