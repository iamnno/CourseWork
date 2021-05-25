<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Нове оголошення</title>
</head>
<body>
<%@include file="header.jspf"%>
<section>
    <div class="flat">
        <form class="edit-form" action="flatsave" method="POST">
            Заголовок: <input class="fi" type="text" name="flattitle" value="" required/>
            Опис: <input class="fi" type="text" name="flattext" value="" required/>
            Кількість кімнат: <input class="fi" type="number" name="flatrooms" value="" required/>
            Ціна: <input class="fi" type="number" name="flatprice" value="" required/>
            Наявність дозволу на утримання домашніх улюбленців: <input type="checkbox" name="flatanimal" value="true"/>
            Близько метро: <input type="checkbox" name="flatmetro" value="true"/>
            Контактні дані: <input class="fi" type="text" name="flatcontact" value="${user.getLogin()}" required/>
            Доступність: <input type="checkbox" name="flatavailable" value="true"/>
            <input id="update" type="submit" value="Зберегти" />
        </form>
    </div>
</section>
<%@include file="footer.jspf"%>
</body>
</html>
