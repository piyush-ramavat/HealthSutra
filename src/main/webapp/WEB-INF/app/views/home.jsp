<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Account Home</title>
</head>
<body>


<c:url value="/j_spring_security_logout" var="logoutUrl"/>

<!-- csrf for log out-->
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

<center>
    <h1>Title : ${title}</h1>

    <h1>Message : ${message}</h1>

    <h2>Account Home</h2>

    <h2>
        <a href="<c:url value="/admin" />">Admin</a> |
        <a href="<c:url value="/subjects/listAll" />">Subjects</a> |
        <a href="javascript:formSubmit()"> Logout</a>
    </h2>
</center>
</body>
</html>