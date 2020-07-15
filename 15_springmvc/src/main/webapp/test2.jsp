<html>
<body>
<h2>Hello World!</h2>
<fmt:formatDate value="${sessionScope.user.birth}" pattern ="yyyy-MM=dd"/>
</br>
${sessionScope.user.birth}
</br>
${requestScope.age}
</body>
</html>
