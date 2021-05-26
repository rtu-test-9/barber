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
    <div class="container-fluid d-flex flex-column align-items-center">
        <div style="width: 80%">
            <div style="text-align: center">
                Выберите мастера:
            </div>
            <c:forEach var="master" items="${masters}">
                <a href="/timeChoice?masterName=${master.name}" style="text-decoration: none; color: white">
                    <div class="row" style="border-color:grey; margin-bottom: 20px">
                        <div class="col-4">
                            <img src="<c:url value="/resources/static/images/${master.avatar}" />" style="width:250px; height:250px; border-radius: 45%"/>
                        </div>
                        <div class="col-8 d-flex justify-content-center align-items-center" style="font-size: 30px;">${master.name}</div>
                    </div>
                </a>
            </c:forEach>
        </div>
        <footer>
            <p class="pt-5">
                <img src="<c:url value="/resources/static/images/map-pin.svg" />">
                BAYERN
            </p>
        </footer>
    </div>
</body>
</html>
