<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>У Вас трапилась помилка</title>
</head>
<body>
<%@include file="header.jspf"%>
<section>
    <h1>${message}</h1>
    <a href=".">Перейдіть до головної сторінки</a>
</section>
<br>
<%@include file="footer.jspf"%>
</body>
</html>
