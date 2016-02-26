<%@ include file="./include.jsp"%>
<html>
<head>
<title>List of Flights</title>

<style>
.error {
	font-size: 0.8em;
	color: #ff0000;
}
</style>
</head>

<body>

	<h2>Flight Details:</h2>

	<table width="50%">
		<tr>
		    <th>Airline</th>
			<th>Start_Airport</th>
			<th>End_Airport</th>
			<th>Start_Time</th>
			<th>End_Time</th>
			<th>Price</th>
			<th>Stops</th>
		</tr>
		<c:forEach items="${flightList.flightList1}" var="curflight"
			varStatus="status">
			<tr>
			    <td>${curflight.airline}</td>
				<td>${curflight.start_airport}</td>
				<td>${curflight.end_airport}</td>
				<td>${curflight.startTime}</td>
				<td>${curflight.endTime}</td>
				<td>${curflight.price}</td>
				<td>${curflight.stops}</td>
				<form method="post" action="./bookFlight" >
           
            <td><input type="submit" value="BOOK"/></td>
            </form>


			</tr>

		</c:forEach>
	</table>
	<br />

<a href="${context}">Home</a>

</body>
</html>
