<html>
<head><title>IDHIT HMS Home Page</title></head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<body>
<div class="topnav">
    <a href="${home}">Home</a>
    <a href="/logout">Logout</a>
</div>
<h1 align="center">IDHITA HMS</h1>
<img class = "center" width="30%" height="80%" src="https://i.ibb.co/bs7DW9D/IDHIT.png" align="centre">
<h1>Welcome ${doctorName}</h1>
<h3><a href="schedule">Find your schedule and appointments here.</a></h3>
</body>
</html>