<html>
<head><title>IDHIT HMS Home Page</title></head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
    .center {
        display: block;
        margin-left: auto;
        margin-right: auto;
        width: 50%;
    }
</style>
</head>
<body>
<div class="topnav">
    <a href="${home}">Home</a>
    <a href="/logout">Logout</a>
</div>
<h1 align="center">IDHITA HMS</h1>
<img class = "center" width="5%" height="80%" src="https://i.ibb.co/bs7DW9D/IDHIT.png" align="centre">
<h1>Pharmacist Portal</h1>
<h3><a href="/idhita/medicines">Check out all medicines here</a></h3>
<h3><a href="/idhita/medicines/register">Create a medicine record here</a> </h3>
</body>
</html>