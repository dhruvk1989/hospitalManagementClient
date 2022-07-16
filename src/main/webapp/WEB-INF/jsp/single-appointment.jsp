<html>
<head>
    <title>Single appointment</title>
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
</head>
<body>
<div class="topnav">
    <a href="${home}">Home</a>
    <a href="/logout">Logout</a>
</div>
<p><b>Appointment ID</b>     : ${appointment.id}</p>
<p><b>Doctor Name</b>        : ${appointment.doctorName}</p>
<p><b>Patient Name</b>       : ${appointment.patientName}</p>
<p><b>Patient Age</b>        : ${appointment.age}</p>
<p><b>Patient Gender</b>     : ${appointment.gender}</p>
<p><b>Appointment Date</b>   : ${date}</p>
<p><b>Appointment Time</b>   : ${appointment.time}</p>
<p><b>Appointment Status</b> : ${appointment.status}</p>
<p><b>Patient Symptoms</b>   : ${appointment.symptoms}</p>

<a href="${link}">${buttonName}</a>
</body>
</html>