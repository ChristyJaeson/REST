<%@ include file="./include.jsp"%>

<html>
<head>
	<title>New Flight Information</title>
	<style>
		.error {
		    font-size: 0.8em;
			color: #ff0000;
		}
	</style>
</head>
<body>

<h1><fmt:message key="selectflightDataForm.title" /></h1>
 <form:form action="./processEnteredFlightInformation" method="POST" commandName="flight">
 <table>
  
  
 <tr>
  	<td><fmt:message key="start_airportLabel" /></td>
  	<td><form:input path="start_airport" />
  		<form:errors path="start_airport" cssClass="error"/></td>
  </tr>
  
  <tr>
  	<td><fmt:message key="end_airportLabel" /></td>
  	<td><form:input path="end_airport" />
  		<form:errors path="end_airport" cssClass="error"/></td>
  </tr>
  
  
  <tr>
    <td><input type="submit" value="<fmt:message key="submitBtn" />"> </td>
    </tr>
  
  </table>
  </form:form>
 
</body>
</html>