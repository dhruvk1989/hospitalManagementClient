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
    <a href="/idhita/home">Home</a>
    <a class="active" href="/idhita/appointments/register">Appointments</a>
    <a href="/idhita/doctors/register">Doctors</a>
    <a href="/idhita/medicines">Medicines</a>
    <a href="/idhita/about">About</a>
</div>
<p><b>Patient Name</b>        : ${patientName}</p>
<p><b>Medicines</b>     : ${medicines}</p>
<p><b>Doctor Name</b>       : ${doctor}</p>
<p><b>Doctor Remarks</b>       : ${remarks}</p>
</body>
</html>