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
    <a href="/idhit/home">Home</a>
    <a href="/idhit/appointments/register">Appointments</a>
    <a href="/idhit/doctors/register">Doctors</a>
    <a href="/idhit/medicines">Medicines</a>
    <a href="/idhit/about">About</a>
</div>
<table>
    <h1>${doctor}</h1>
    <c:forEach items="${appointments}" var="appointments">
        <tr>
            <th>Doctor</th>
            <th>Patient</th>
            <th>Symptoms</th>
        </tr>
        <tr>
            <td><c:out value="${appointments.doctorName}" /></td>
            <td><c:out value="${appointments.patientName}" /></td>
            <td><c:out value="${appointments.symptoms}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>