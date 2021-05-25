<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Детальніше про квартиру</title>
</head>
<body>
<%@include file="header.jspf"%>
<section>
    <div class="flat">
        <h1>${flat.getFlatD().getTitle()}
            <c:if test="${flat.isAvailable()}">
                <span class="allow">Доступна!</span>
            </c:if>
            <c:if test="${!flat.isAvailable()}">
            <span class="notallow">Не доступна...</span></c:if>
        </h1>
        <hr>
        <p>Власник: <b>${flat.getFlatD().getOwnername()}</b>, зв'яжіться за ${flat.getFlatD().getContact()}</p>
        <p>Кількість кімнат: ${flat.getFlatP().getRooms()}</p>
        <p>Наявність дозволу на утримання домашніх улюбленців:
            <c:if test="${flat.getFlatP().isAnimal()}">
                <span class="allow">Дозволено</span>
            </c:if>
            <c:if test="${!flat.getFlatP().isAnimal()}">
                <span class="notallow">Не дозволено</span>
            </c:if>;  Близько метро:
            <c:if test="${flat.getFlatP().isMetro()}">
                <span class="allow">Близько</span>
            </c:if>
            <c:if test="${!flat.getFlatP().isMetro()}">
                <span class="notallow">Неблизько</span>
            </c:if>;
        </p>
        <p>${flat.getFlatD().getText()}</p>
        <hr>
        <h3>Ціна: ${flat.getFlatP().getPrice()} UAH</h3>
    </div>
</section>
<%@include file="footer.jspf"%>
</body>
</html>
