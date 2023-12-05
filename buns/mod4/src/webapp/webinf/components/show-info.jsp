<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<p>Имя: ${employee.name}</p>
<p>Фамилия: ${employee.surname}</p>
<p>Зарплата: ${employee.salary}</p>
<p>Отдел: ${employee.department}</p>
<p>Бренд машины: ${employee.carBrand}</p>
<p>Языки:</p>
<ul>
    <c:forEach var="lang" items="${employee.languages}">
        <li>${lang}</li>
    </c:forEach>
</ul>
<p>Номер телефона: ${employee.phoneNumber}</p>
<p>Почта: ${employee.email}</p>
</body>
</html>