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
    </style>
    <title>Hello!</title>
</head>
<body>
<table>
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