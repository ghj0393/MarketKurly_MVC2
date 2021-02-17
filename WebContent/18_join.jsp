<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="js/jquery-1.11.0.min.js"></script>
	<script src="18_join.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<hr width="700" color="black" size="3" />
	<br>
	<table>
		<tr height = "50">
			<th width="150">아이디</th>
			<td width = "300" align="center">
				<input type="text" id="id" name="id" placeholder="6자 이상의 영문 혹은 영문과 숫자를 조합" style="width:300px; height:40px">
			</td>
			<td width="75">
				<button id="checkDoubleId">중복확인</button>
			</td>
		</tr>
		<tr height = "50">
			<th width="150">패스워드</th>
			<td width = "300" align="left" colspan="2">
				<input type="password" id="pw" name="pw" placeholder="비밀번호를 입력해주세요" style="width:300px; height:40px">
			</td>
		</tr>
		<tr height = "50">
			<th width="150">이름</th>
			<td width = "300" align="left" colspan="2">
				<input type="text" id="name" name="name" placeholder="이름을 입력해주세요" style="width:300px; height:40px">
			</td>
		</tr>
		<tr height = "50">
			<th width="150">휴대폰</th>
			<td width = "300" align="left" colspan="2">
				<input type="text" id="tel" name="tel" placeholder="(-)없이 입력" style="width:300px; height:40px">
			</td>
		</tr>
		<tr height = "50">
			<th width="150">주소</th>
			<td width = "300" align="left" colspan="2">
				<input type="text" id="address" name="address" placeholder="주소를 입력해주세요" style="width:300px; height:40px">
			</td>
		</tr>
		<tr height = "50">
			<th width="150">이메일</th>
			<td width = "300" align="center">
				<input type="email" id="email" name="email" placeholder="예:marketkurly@kurly.com" style="width:300px; height:40px">
			</td>
			<td width="75">
			<button id="checkDoubleEmail">중복확인</button>
		</td>
		</tr>
		<tr height="50">
			<td colspan="3" align="center">
				<br>
				<button id="join">가입하기</button>
			</td>
		</tr>
	</table>
</body>
</html>