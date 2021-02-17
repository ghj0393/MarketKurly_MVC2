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
	<form method="post" action="${contextPath}/boardUpdateForCustomerPro.do">
		<table border="1" style="border-collapse:collapse;">
			<tr height="40">
				<td align="center" width="120"> 글번호 </td>
				<td align="center" width="180"> ${board.num}</td>
				<td align="center" width="120"> 조회수 </td>
				<td align="center" width="180"> ${board.readcount}</td>
			</tr>
			<tr height="40">
				<td align="center" width="120"> 작성자 </td>
				<td align="center" width="180"> ${board.writer}</td>
				<td align="center" width="120"> 작성일 </td>
				<td align="center" width="180"> ${board.reg_date}</td>
			</tr>
			<tr height="40">
				<td align="center" width="120"> 제목 </td>
				<td align="center" colspan="3"> 
				<input type="text" name="title" value="${board.title}" size="30">
				</td>
			</tr>
			<tr height="80">
				<td align="center" width="120"> 글 내용 </td>
				<td align="center" colspan="3"> 
				<textarea name="content" cols="50" rows="10">${board.content}</textarea>
				</td>
			</tr>
		</table>
		<br>
		<input type="hidden" name="num" value="${board.num}">

		<input type="submit" value="수정하기">&nbsp;
		<input type="reset" value="다시작성">
	</form>
</body>
</html>