<%@ include file="./include.jsp"%>

<html>
<head>
	<title>Add Location Details</title>
	<style>
		.error {
		    font-size: 0.8em;
			color: #ff0000;
		}
	</style>
</head>
<body>

<h1><fmt:message key="addlocationDataForm.title" /></h1>
 <form:form action="./processNewLocationProfile" method="POST" commandName="location">
 <table>
  
  
 <tr>
  	<td><fmt:message key="codeLabel" /></td>
  	<td><form:input path="code" />
  		<form:errors path="code" cssClass="error"/></td>
  </tr>
  
  <tr>
  	<td><fmt:message key="nameLabel" /></td>
  	<td><form:input path="name" />
  		<form:errors path="name" cssClass="error"/></td>
  </tr>
   <tr>
  	<td><fmt:message key="cityLabel" /></td>
  	<td><form:input path="city" />
  		<form:errors path="city" cssClass="error"/></td>
  </tr>
  <tr>
  	<td><fmt:message key="countryLabel" /></td>
  	<td><form:input path="country" />
  		<form:errors path="country" cssClass="error"/></td>
  </tr>
  
  
  
  <tr>
    <td><input type="submit" value="<fmt:message key="enterBtn" />"> </td>
    </tr>
  
  </table>
  </form:form>
 
</body>
</html>