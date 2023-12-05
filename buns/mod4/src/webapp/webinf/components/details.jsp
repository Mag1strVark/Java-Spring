<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form:form action="info" modelAttribute="employee">
    <p>Имя <form:input path="name"/><form:errors path="name"/></p>
    <p>Фамилия <form:input path="surname"/><form:errors path="surname"/></p>
    <p>Зарплата <form:input path="salary"/><form:errors path="salary"/></p>
    <p>Отдел <form:select path="department">
        <form:options items="${employee.departments}"/>
    </form:select></p>
    <p>какой автомобиль вы хотите?
        <form:radiobuttons path="carBrand" items="${employee.carBrands}"/>
    </p>
    <p>Языки
        <form:checkboxes path="languages" items="${employee.langList}"/>
    </p>
    <p>номер телефона <form:input path="phoneNumber"/><form:errors path="phoneNumber"/></p>
    <p>почта <form:input path="email"/><form:errors path="email"/></p>
    <p><input type="submit"></p>
</form:form>
</body>
</html>