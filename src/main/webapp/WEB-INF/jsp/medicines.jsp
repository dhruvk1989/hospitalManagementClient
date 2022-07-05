<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Medicines</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }

        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
        }

        .topnav {
            overflow: hidden;
            background-color: #333;
        }

        .topnav a {
            float: left;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        .topnav a.active {
            background-color: #04AA6D;
            color: white;
        }
    </style>
</head>
<body>
<div class="topnav">
    <a href="/idhita/home">Home</a>
    <a href="/idhita/appointments/register">Appointments</a>
    <a href="/idhita/doctors/register">Doctors</a>
    <a class = "active" href="/idhita/medicines">Medicines</a>
    <a href="/idhita/about">About</a>
</div>
<h1>Medicines</h1>
<table>
    <tr>
        <th>Name</th>
        <th>Company Name</th>
        <th>Disease</th>
        <th>Price</th>
        <th>Expiry Date</th>
    </tr>
    <c:forEach items="${medicines}" var="medicines">
        <tr>
            <td><c:out value="${medicines.medicineName}" /></td>
            <td><c:out value="${medicines.companyName}" /></td>
            <td><c:out value="${medicines.disease}" /></td>
            <td><c:out value="${medicines.price}" /></td>
            <td><c:out value="${medicines.expiryDate}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>