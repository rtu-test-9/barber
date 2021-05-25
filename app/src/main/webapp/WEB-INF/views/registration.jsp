<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/resources/static/css/login.css" />" type="text/css">
    <title>Каталог</title>
</head>
<body>
<div class="container-singup">
    <h2>Вход</h2>
    <form action="/registration" class="loginForm" method="POST">
        <input type="hidden" name="_csrf" value="{{_csrf.token}}">
        <input type="username" name="username" maxlength="50" class="inputData" placeholder="Логин">
        <input type="password" name="password" maxlength="50" class="inputData" placeholder="Пароль"><br>
        <button class="mt-3 btn-singup submit">Зарегистрироваться</button>
    </form>
</div>
</body>
</html>