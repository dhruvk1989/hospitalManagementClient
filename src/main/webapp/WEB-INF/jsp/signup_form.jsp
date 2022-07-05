<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="ISO-8859-1">
    <title>Sign Up - CodeJava</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container text-center">
    <div>
        <h1>User Registration - Sign Up</h1>
    </div>
    <form:form method="POST" modelAttribute="user" commandName="user" action="/process_register"
          style="max-width: 600px; margin: 0 auto;">
        <div class="m-3">
            <div class="form-group row">
                <label class="col-4 col-form-label" for="email">E-mail: </label>
                <div class="col-8">
                    <form:input path="email" id="email" type="email" class="form-control"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-4 col-form-label" for="password">Password: </label>
                <div class="col-8">
                    <form:input type="password" id="password" path="password" class="form-control"
                           minlength="6" maxlength="10"/>
                </div>
            </div>

            <div class="form-group row">
                <label for="firstName" class="col-4 col-form-label">First Name: </label>
                <div class="col-8">
                    <form:input path="firstName" type="text" id="firstName" class="form-control"
                           minlength="2" maxlength="20"/>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-4 col-form-label">Last Name: </label>
                <div class="col-8">
                    <form:input type="text" path="lastName" id="lastName" class="form-control"
                           minlength="2" maxlength="20" />
                </div>
            </div>

            <div>
                <button type="submit" class="btn btn-primary">Sign Up</button>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>