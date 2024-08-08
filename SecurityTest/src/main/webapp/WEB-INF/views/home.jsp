<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<sec:authorize access="isAuthenticated()">
	<div>welcome<p><sec:authentication property="principal.nickname"/>  </p></div>
	<a href="<c:url value="/logout" />">logout</a>
</sec:authorize>

<sec:authorize access="hasRole('ADMIN')">
	hello admin
</sec:authorize>

<sec:authorize access="!hasRole('ADMIN')">
	hello user
</sec:authorize>

</body>
</html>
