<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${check == 1}">
		<c:set var="id" value="${id}" scope="session" />
		<script>
			location.href='${contextPath}/index.do';
		</script>
	</c:if>
	
	<c:if test="${check!=1}">
		<script>
			alert("아이디와 패스워드를 확인해주세요.");
			history.go(-1);
		</script>
	</c:if>
</body>
</html>