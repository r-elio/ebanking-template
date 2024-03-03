<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Personal</title>
    <link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />" rel="stylesheet" />
    <link href="<c:url value='/resources/css/styles.css' />" rel="stylesheet" />
</head>
<body>
    <div class="small"><jsp:include page="/WEB-INF/jsp/include/header.jsp" /></div>
    <p class="text-decoration-underline">Click <a href="<c:url value='/dashboard/' />">here</a> to go back</p>
    <script src="<c:url value='/resources/bootstrap/js/bootstrap.bundle.min.js' />"></script>
    <script src="<c:url value='/resources/js/scripts.js' />"'js/scripts.js'></script>
</body>
</html>