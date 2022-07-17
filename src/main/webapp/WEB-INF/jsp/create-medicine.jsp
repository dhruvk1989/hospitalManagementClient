<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        div {
            border-radius: 5px;
            background-color: #f2f2f2;
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
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<div class="topnav">
    <a href="${home}">Home</a>
    <a href="/logout">Logout</a>
</div>

<h1>Create a medicine record</h1>
<form:form method="POST" modelAttribute="medicine" commandName="medicine" action="/idhita/medicines/save">
    <div>
        <div>
            <label for="medicineName">Medicine's Name</label>
            <div>
                <form:input path="medicineName" id="medicineName" type="text"/>
            </div>
        </div>
    </div>

    <div>
        <div>
            <label for="companyName">Company Name</label>
            <div>
                <form:input path="companyName" id="companyName" type="text"/>
            </div>
        </div>
    </div>

    <div>
        <div>
            <label for="disease">Disease</label>
            <div>
                <form:input path="disease" id="disease" type="text"/>
            </div>
        </div>
    </div>

    <div>
        <div>
            <label for="price">Price</label>
            <div>
                <form:input path="price" id="price" type="text"/>
            </div>
        </div>
    </div>

    <div>
        <div>
            <label for="expiryDate">Expiry date</label>
            <div>
                <form:input path="expiryDate" id="expiryDate" type="text"/>
            </div>
        </div>
    </div>

    <div>
        <div>
            <input type="submit" value="Register">
        </div>
    </div>

</form:form>
</body>
</html>