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
	<table border = "1" style="border-collapse:collapse;">
		<tr height="40">
			<td align="center" width="120"> 글번호 </td>
			<td align="center" width="180">${board.num}</td>
			<td align="center" width="120"> 조회수 </td>
			<td align="center" width="180">${board.readcount}</td>
		</tr>
		<tr height="40">
			<td align="center" width="120"> 작성자 </td>
			<td align="center" width="180"> ${board.writer}</td>
			<td align="center" width="120"> 작성일 </td>
			<td align="center" width="180"> ${board.reg_date}</td>
		</tr>
		<tr height="40">
			<td align="center" width="120"> 제목 </td>
			<td align="center" colspan="3"> ${board.title}</td>
		</tr>
		<tr height="80">
			<td align="center" width="120"> 글 내용 </td>
			<td align="center" colspan="3"> ${board.content}</td>
		</tr>
		<tr height="40">
			<td align="center" colspan="4">
				<c:set var="viewer" value = "${sessionScope.id}"/>
				<c:if test="${viewer == board.writer}">
					<input type="button" value="수정하기" onclick="location.href='${contextPath}/boardUpdateForCustomer.do?num=${board.num}'" >
					<input type="button" value="삭제하기" onclick="location.href='${contextPath}/boardDeleteForCustomer.do?num=${board.num}'" >
				</c:if>
				<input type="button" value="목록보기" onclick="location.href='${contextPath}/showBoardListForCustomer.do'">
			</td>
		</tr>
	</table>
</body>
</html>