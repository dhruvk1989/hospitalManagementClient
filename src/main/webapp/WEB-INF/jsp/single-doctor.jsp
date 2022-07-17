<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Single doctor</title>
    <style>
        .center {
            display: block;
            margin-left: auto;
            margin-right: auto;
            width: 50%;
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
<p><b>Doctor Name</b>        : ${doctor.name}</p>
<p><b>Department</b>       : ${doctor.dept.deptName}</p>
<p><b>Doctor Age</b>        : ${doctor.age}</p>
<!--<p><a href="${link}"><b>Appointments/Schedule</b></a></p>-->

<table>
    <tr>
        <th>Appointment Id</th>
        <th>Patient Name</th>
        <th>Timing</th>
        <th>Date</th>
    </tr>
    <c:if test="${not empty schedule}">
    <c:forEach items="${schedule}" var="schedule" varStatus="loop">
        <tr>
            <td><a href="${links[loop.index]}"><c:out value="${schedule.apptId}" /></a></td>
            <td><c:out value="${schedule.patientName}" /></td>
            <td cssClass="form-control"><c:out value="${schedule.docTime}" /></td>
            <td cssClass="form-control"><c:out value="${schedule.apptDate}" /></td>
        </tr>
    </c:forEach>
    </c:if>
</table>

</body>
</html>