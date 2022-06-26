<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Medicines</title>
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
<h1>Medicines</h1>
<table>
    <c:forEach items="${medicines}" var="medicines">
        <tr>
            <th>Name</th>
            <th>Company Name</th>
            <th>Disease</th>
            <th>Price</th>
            <th>Expiry Date</th>
        </tr>
        <tr>
            <td><c:out value="${medicines.medicineName}" /></td>
            <td><c:out value="${medicines.companyName}" /></td>
            <td><c:out value="${medicines.disease}" /></td>
            <td><c:out value="${medicines.price}" /></td>
            <td><c:out value="${medicines.expiryDate}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>