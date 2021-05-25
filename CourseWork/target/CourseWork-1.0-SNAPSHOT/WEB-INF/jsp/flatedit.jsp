<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Оновити</title>
</head>
<body>
<%@include file="header.jspf"%>
<section>
    <div class="flat">
        <form class="edit-form" action="flatupdate?flatID=${flat.getFlatID()}" method="POST">
            Заголовок: <input class="fi" type="text" name="flattitle" value="${flat.getFlatD().getTitle()}" required />
            Опис: <input class="fi" type="text" name="flattext" value="${flat.getFlatD().getText()}" required/>
            Кількість кімнат: <input class="fi" type="number" name="flatrooms" value="${flat.getFlatP().getRooms()}" required/>
            Ціна: <input class="fi" type="number" name="flatprice" value="${flat.getFlatP().getPrice()}" required/>
            Наявність дозволу на утримання домашніх улюбленців: <input type="checkbox" name="flatanimal" value="true"/>
            Близько метро: <input type="checkbox" name="flatmetro" value="true"/>
            Контактні дані: <input class="fi" type="text" name="flatcontact" value="${flat.getFlatD().getContact()}" required/>
            Контактні дані: <input type="checkbox" name="flatavailable" value="true"/>
            <hr>
            <input id="update" type="submit" value="Оновити" />
            <input id="delete" type="submit" value="Видалити" formaction="flatdelete?flatID=${flat.getFlatID()}"/>
        </form>
    </div>
</section>
<%@include file="footer.jspf"%>
</body>
</html>
