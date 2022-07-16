<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
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
    <a href="${home}">Home</a>
    <a href="/logout">Logout</a>
</div>
<table>
    <h1>${doctor}</h1>
    <tr>
        <th>Patient</th>
        <th>Symptoms</th>
        <th>Medicines</th>
    </tr>
    <c:forEach items="${appointments}" var="appointments" varStatus="loop">
        <tr>
            <td><a href = ${links[loop.index]}><c:out value="${appointments.patientName}" /></a></td>
            <td><c:out value="${appointments.symptoms}" /></td>
            <td><c:out value="${prescriptions[loop.index].medicines}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>