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
		<!-- ��ť��Ƽ���� �����ϴ� �α��� ó�� url�� ����� ���
			���̵� �ش��ϴ� name�� username����,
			��й�ȣ�� �ش��ϴ� name�� password�� ��û�ؾ��Ѵ�. -->
		���̵� : <input type="text" name="username"><br>
		��й�ȣ : <input type="text" name="password"><br>
		<input type="submit" value="�α���">
	</form>
</body>
</html>