<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Оренда квартири</title>
</head>
<body>
<%@include file="header.jspf"%>
<section>
    <c:if test="${!empty user}">
        <div class="list">
            <c:if test="${!empty user.getMyFlat()}">
                <table>
                    <tr>
                        <th colspan="2">Опис</th>
                        <th>Ціна</th>
                        <th colspan="2">Дії</th>
                    </tr>

                    <c:forEach var="entry" items="${user.getMyFlat()}">
                        <tr>
                            <td>${entry.value.getFlatD().getTitle()}</td>
                            <th rowspan="2">
                                <c:if test="${entry.value.isAvailable()}">
                                    <span class="allow">Доступна</span>
                                </c:if>
                                <c:if test="${!entry.value.isAvailable()}">
                                    <span class="notallow">Не доступна</span>
                                </c:if>
                            </th>
                            <th rowspan="2">${entry.value.getFlatP().getPrice()} UAH</th>
                            <th rowspan="2"><a href="flat?flatID=${entry.value.getFlatID()}">Детальніше</a></th>
                            <th rowspan="2"><a href="flatedit?flatID=${entry.value.getFlatID()}">Редагувати</a></th>
                        </tr>
                        <tr>
                            <td>Кількість кімнат: ${entry.value.getFlatP().getRooms()}, наявність дозволу на утримання домашніх улюбленців:
                                <c:if test="${entry.value.getFlatP().isAnimal()}">
                                    <span class="allow">Дозволено</span>
                                </c:if>
                                <c:if test="${!entry.value.getFlatP().isAnimal()}">
                                    <span class="notallow">Не дозволено</span>
                                </c:if>; Близько метро:
                                <c:if test="${entry.value.getFlatP().isMetro()}">
                                    <span class="allow">Близько</span>
                                </c:if>
                                <c:if test="${!entry.value.getFlatP().isMetro()}">
                                    <span class="notallow">Неблизько</span>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <a href="flatnew">Створити нове оголошення</a>
        </div>
    </c:if>

    <div class="list">
        <table>
            <tr>
                <th>Власник</th>
                <th colspan="2">Опис</th>
                <th>Ціна</th>
                <th>Дії</th>
            </tr>
            <c:forEach var="flat" items="${flats}">
                <tr>
                    <th rowspan="2">${flat.getFlatD().getOwnername()}</th>
                    <th class="title">${flat.getFlatD().getTitle()}</th>
                    <th rowspan="2">
                        <c:if test="${flat.isAvailable()}">
                            <span class="allow">Доступна</span>
                        </c:if>
                        <c:if test="${!flat.isAvailable()}">
                            <span class="notallow">Не доступна</span>
                        </c:if>
                    </th>
                    <th rowspan="2">${flat.getFlatP().getPrice()} UAH</th>
                    <th rowspan="2"><a href="flat?flatID=${flat.getFlatID()}">Детальніше</a></th>
                </tr>
                <tr>
                    <td>Кількість квартир:${flat.getFlatP().getRooms()}; Наявність дозволу на утримання домашіх улюбленців:
                        <c:if test="${flat.getFlatP().isAnimal()}">
                            <span class="allow">Дозволено</span>
                        </c:if>
                        <c:if test="${!flat.getFlatP().isAnimal()}">
                            <span class="notallow">Не дозволено</span>
                        </c:if>; Близько метро:
                        <c:if test="${flat.getFlatP().isMetro()}">
                            <span class="allow">Близько</span>
                        </c:if>
                        <c:if test="${!flat.getFlatP().isMetro()}">
                            <span class="notallow">Неблизько</span>
                        </c:if>;
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
<br>
<%@include file="footer.jspf"%>
</body>
</html>
