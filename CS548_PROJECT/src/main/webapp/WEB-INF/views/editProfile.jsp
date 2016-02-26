<%@ include file="./include.jsp"%>
<%@ page session="false" %>
<c:set var="context" scope="request" value="<%= request.getContextPath()%>" />
<html>
<head>
	<title>Edit Profile</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/nav.css" />
</head>
<body>
<%@ include file="./userNavbar.jsp"%>

<form:form action="./saveUserInformation" method="POST" commandName="user">
Greetings :--------
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