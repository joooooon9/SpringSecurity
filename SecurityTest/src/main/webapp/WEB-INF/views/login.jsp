<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<form action="<c:url value="/loginProcess" />" method="post">
		<!-- 시큐리티에서 제공하는 로그인 처리 url을 사용할 경우
			아이디에 해당하는 name은 username으로,
			비밀번호에 해당하는 name은 password로 요청해야한다. -->
		아이디 : <input type="text" name="username"><br>
		비밀번호 : <input type="text" name="password"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>