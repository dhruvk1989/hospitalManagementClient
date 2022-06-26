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
        <a href="/idhit/home">Home</a>
        <a class="active" href="/idhit/appointments/register">Appointments</a>
        <a href="/idhit/doctors/register">Doctors</a>
        <a href="/idhit/medicines">Medicines</a>
        <a href="/idhit/about">About</a>
    </div>

    <c:forEach items="${appointments}" var="appointments">
        <tr>
            <th>Doctor</th>
            <th>ID</th>
            <th>Patient</th>
            <th>Gender</th>
            <th>Age</th>
            <th>Date-Time</th>
            <th>Status</th>
        </tr>
        <tr>
            <td><c:out value="${appointments.doctorName}" /></td>
            <td><c:out value="${appointments.id}" /></td>
            <td><c:out value="${appointments.patientName}" /></td>
            <td><c:out value="${appointments.gender}" /></td>
            <td><c:out value="${appointments.age}" /></td>
            <td><c:out value="${appointments.appointmentDateTime}" /></td>
            <td><c:out value="${appointments.status}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>