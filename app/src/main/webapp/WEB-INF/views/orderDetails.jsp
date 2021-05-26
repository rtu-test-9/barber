<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="icon" href="<c:url value="/resources/static/images/scissorss.svg" />">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@1,200&display=swap" rel="stylesheet">
    <title>BAYERN</title>
</head>
<body style="background-color: #000; color:white; font-size: 25px">
    <form action = "orderComplete" method="post">
        <input name="email" type="email" placeholder="Ваш email">
        <input type="hidden" name="master_id" value="${master.id.toString()}">
        Услуга:
        <select name="service_id">
            <c:forEach items="${services}" var="service">
                <option value="${service.id.toString()}">${service.name}</option>
            </c:forEach>
        </select>
        Время:
        <select name="time">
            <c:forEach items="${times}" var="time">
                <option value="${time}">${time.toString()}</option>
            </c:forEach>
        </select>
        <button type="submit">Оформить заказ</button>
    </form>
</body>
</html>
