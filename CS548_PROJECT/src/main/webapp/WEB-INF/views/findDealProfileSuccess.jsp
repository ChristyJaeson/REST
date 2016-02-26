<%@ include file="./include.jsp"%>
<html>
<head>
	<title>Deals List</title>
	<link rel="stylesheet" type="text/css" href="../resources/css/nav.css" />

<style>
.error {
	font-size: 0.8em;
	color: #ff0000;
}
</style>
</head>

<body>
<%@ include file="./homeNavbar.jsp"%>
	<h2>Deals Details:</h2>

	<table width="50%">
		<tr>
			<th>Offer Name</th>
			<th>Price</th>
			<th>Dicount</th>
			<th>Expiry Date</th>
		</tr>
		<c:forEach items="${dealList.dealList1}" var="curdeal"
			varStatus="status">
			<tr>
				<td>${curdeal.event}</td>
				<td>&#36;${curdeal.price}</td>
				<td>${curdeal.discount}%</td>
				<td>${curdeal.dates}</td>
				
            


			</tr>

		</c:forEach>
	</table>
	<br />

<a href="${context}">Home</a>


</body>
</html>
