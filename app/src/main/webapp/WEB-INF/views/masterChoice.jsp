<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: anmark
  Date: 25.05.2021
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-color: #000; color:white; font-size: 25px">
    <div class="container-fluid d-flex flex-column align-items-center">
        <div style="text-align: center">
            Выберите мастера:
        </div>
        <c:forEach var="master" items="${masters}">
            <a href="/timeChoice?masterName=${master.name}">
                <div class="d-flex flex-row">
                    <img src="<c:url value="/resources/static/images/${master.avatar}" />" style="width:330px; height:380px"/>
                    <div style="font-size: 30px">${master.name}</div>
                </div>
            </a>
        </c:forEach>
    </div>
</body>
</html>
