<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Главная страница</h1>
<security:authorize access="hasRole('HR')">
<p>HR <input type="button" value="Зарплата" onclick="window.location.href ='hr_info'"/></p>
</security:authorize>
<security:authorize access="hasRole('MANAGER')">
<p>Manager <input type="button" value="Производительность" onclick="window.location.href ='manager_info'"/></p>
</security:authorize>
</body>
</html>