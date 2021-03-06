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
    <title>Appointments</title>
</head>
<body>
<table>

    <div class="topnav">
        <a href="${home}">Home</a>
        <a href="/logout">Logout</a>
    </div>

    <tr>
        <th>ID</th>
        <th>Doctor</th>
        <th>Patient</th>
        <th>Gender</th>
        <th>Age</th>
        <th>Date</th>
        <th>Time</th>
        <th>Status</th>
    </tr>

    <c:forEach items="${appointments}" var="appointments" varStatus="loop">
        <td><a href="${links[loop.index]}"> <c:out value="${appointments.id}" /></a></td>
        <td><c:out value="${appointments.doctorName}" /></td>
        <td><c:out value="${appointments.patientName}" /></td>
        <td><c:out value="${appointments.gender}" /></td>
        <td><c:out value="${appointments.age}" /></td>
        <td><c:out value="${dates[loop.index]}" /></td>
        <td><c:out value="${appointments.time}" /></td>
        <td><c:out value="${appointments.status}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>