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
    <a href="/idhit/home">Home</a>
    <a class="active" href="/idhit/appointments/register">Appointments</a>
    <a href="/idhit/doctors/register">Doctors</a>
    <a href="/idhit/medicines">Medicines</a>
    <a href="/idhit/about">About</a>
</div>
<p><b>Patient Name</b>        : ${patientName}</p>
<p><b>Medicines</b>     : ${medicines}</p>
<p><b>Doctor Name</b>       : ${doctor}</p>
</body>
</html>