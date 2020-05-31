<%--
  Created by IntelliJ IDEA.
  User: Админ
  Date: 30.05.2020
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentification</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
<div class="container center-block" style="width: 400px">
    <form method="post">
        <div class="card bg-light mb-3" style="max-width: 18rem; height: 230px">
            <div class="card-header text-center">Authentification</div>
            <div class="card-body">
                <div class="form-group text-center">
                    <input type="text" class="form-control" id="InputEmail" placeholder="Login" name="login">
                    <input type="password" class="form-control" id="InputPassword" placeholder="Password" name="password"> <br>
                    <button type="submit" class="btn btn-outline-success create" align="center">Войти</button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
