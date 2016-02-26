<%@ include file="./include.jsp"%>
<html>
<head>
<title>Location Information</title>
</head>
<body>

<h2>New Location Has Been  Successfully Added!!!</h2>
<br>

<h3>Location Information</h3>
<font color="blue"/>${location.code} ${location.name} ${location.city} ${location.country}  </font>

<h2>
<a href="${context}">Home</a>
</h2>
</body>
</html>
