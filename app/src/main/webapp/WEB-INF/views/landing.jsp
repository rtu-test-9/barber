<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link href="<c:url value="/resources/static/css/landing.css" />" rel="stylesheet">
    <link rel="icon" href="<c:url value="/resources/static/images/scissorss.svg" />">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@1,200&display=swap" rel="stylesheet">
  <title>BAYERN</title>
</head>
<body>
  <div class="container-fluid mb-5">
    <nav class="navbar navbar-expand-lg navbar-dark">
      <div class="container-fluid justify-content-end" id="header">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
          <ul class="navbar-nav mb-3">
            <li class="nav-item ms-4">
              <a class="nav-link active" aria-current="page" href="#header">Главная</a>
            </li>
            <li class="nav-item ms-4">
              <a class="nav-link" href="#aboutus">О нас</a>
            </li>
            <li class="nav-item ms-4">
              <a class="nav-link" href="#masters">Сотрудники</a>
            </li>
            <li class="nav-item ms-4">
              <a class="nav-link" href="#reviews">Отзывы</a>
            </li>
            <li class="nav-item ms-4">
              <a class="nav-link" href="#services">Услуги</a>
            </li>
            <li class="nav-item ms-4">
              <a class="nav-link" href="#note">Запись</a>
            </li>
            <li class="nav-item ms-4 me-4">
              <a class="nav-link" href="#address">Контакты</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="container-header">
      <a class="row brand-name" href="#header">BAYERN</a>
      <button class="btn-info mt-5" onclick="location.href='#aboutus'">УЗНАТЬ БОЛЬШЕ</button>
    </div>
  </div>
  <div class="container-aboutus" id="aboutus">
    <div class="row">
      <div class="col mt-4 p-5 whowe">
        <img src="<c:url value="/resources/static/images/help-circle.svg" />" class="mb-4">
        <h1 class="mb-4">КТО МЫ</h1>
        <p>BAYERN — намного больше, чем просто мужская парикмахерская, это даже больше, чем мужской клуб по интересам, это именно то место, где ты найдёшь себя и свой стиль.</p>
      </div>
      <div class="col aboutusimg"></div>
      <div class="col mt-4 p-5 whowe">
        <img src="<c:url value="/resources/static/images/check-circle.svg" />" class="mb-4">
        <h1 class="mb-4">ПОЧЕМУ МЫ</h1>
        <p>"Премиум сервис по демократичным ценам" - наш девиз, так как, по нашему мнению, люди должны понимать,что каждый товар должен иметь свою оправданную цену.Не будем томить, приходите и убедитесь во всем сами. С уважением к вам, "BAYERN"</p>
      </div>
    </div>
  </div>
  <div class="container-master" id="masters">
    <h1 style="color: white;" class="mt-5">НАШИ СОТРУДНИКИ</h1>
    <img src="resources/static/images/scissors.svg" class="mb-5">
    <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel" data-bs-interval="3000">
      <div class="carousel-inner">
        <c:set var = "is_active" value="${true}"/>
        <c:forEach var = "barber" items="${barbers}">
          <c:if test="${is_active == true}">
            <div class="carousel-item active">
          </c:if>
          <c:if test="${is_active == false}">
            <div class="carousel-item">
          </c:if>
              <a href="#note"><img src="<c:url value="/resources/static/images/slide_${barber.avatar}" />" class="d-block w-100" alt="..."></a>
            </div>
            <c:set var = "is_active" value="${false}"/>
        </c:forEach>
      </div>
    </div>
  </div>
  <div class="container-reviews pt-3" id="reviews">
    <h1 class="mt-5">ОТЗЫВЫ</h1>
    <img src="<c:url value="/resources/static/images/heart.svg" />">
    <div class="row">
      <c:forEach var="comment" items="${comments}">
        <div class="col p-5">
          <img src="<c:url value="/resources/static/images/${comment.authorAvatarName}" />" class="client mb-1">
          <h2>${comment.authorName}</h2>
          <p class="review ps-5 pe-5">${comment.commentBody}</p>
        </div>
      </c:forEach>
    </div>
  </div>
  <div class="container-services mb-5" style="color: white; text-align: center;" id="services">
    <h1 class="mt-5">УСЛУГИ</h1>
    <img src="<c:url value="/resources/static/images/dollar-sign.svg" />">
    <table class="table mt-5" style="color: white;">
      <tbody>
      <c:set var="i" value = "${0}"/>
        <c:forEach var="service" items="${services}">
          <c:if test="${i % 2 == 0}">
            <tr>
          </c:if>
              <td>${service.name.toUpperCase()}</td>
              <td>${service.price}₽</td>
          <c:if test="${i % 2 != 0}">
              </tr>
          </c:if>
          <c:set var="i" value="${i + 1}"/>
        </c:forEach>
      </tbody>
    </table>
    <h1 class="pt-5">АКЦИЯ</h1>
    <p>Выбирайте несколько услуг и получайте скидку!</p>
    <h2>1+1 = 10%</h2>
    <h2>2+1 = 15%</h2>
  </div>
  <div class="d-flex align-items-center flex-column container-note pt-5 pb-5" id="note">
    <h1>ЗАПИСЬ</h1>
    <div class="d-flex flex-column" style="width: 200px; height: 150px">
      <img src="<c:url value="/resources/static/images/edit.svg" />">
      <button class="btn btn-light" type="submit" onclick="location.href='/order'">Записаться</button>
    </div>
  </div>
  <div class="container-address pt-5 pb-5" id="address">
    <div class="row">
      <div class="col ms-4 mt-3">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d36104.30272594578!2d37.49426129524223!3d55.558163252081705!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x414aada3139fd541%3A0xb12c40ac65de4ef7!2s27%20Barbershop!5e0!3m2!1sru!2sru!4v1621332651517!5m2!1sru!2sru" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
      </div>
      <div class="col pt-5 mt-3" style="font-family: serif; font-size: 24px;">
        <h1 class="mb-3">КОНТАКТЫ</h1>
        <img src="<c:url value="/resources/static/images/map-pin.svg" />"><br>
        <p class="mt-4"><b>Адрес: </b>Куликовская ул., 6, Москва, 117628</p>
        <p><b>Время работы: </b>каждый день 10:00–22:00</p>
        <p><b>Контактный номер: </b>+7 (914) 587-62-01</p>
      </div>
    </div>
  </div>
  <footer>
    <p class="pt-5">
      <img src="<c:url value="/resources/static/images/map-pin.svg" />">
      BAYERN
    </p>
  </footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>