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
</head>
<body>
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