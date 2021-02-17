<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>주문서</h2>
	<hr size="2" color="purple" width="300">
	
	<form method="post" action="${contextPath}/insertOrderList.do">
		<table>
			<tr height="50">
				<td colspan = "4">
					<h3 align="left">구매상품확인</h3>
				</td>
			</tr>
			<tr height="5">
				<td colspan ="4">
					<hr size="1" color="gray" width="800">
				</td>
			</tr>
			<c:set var="number" value="0"/>
			<c:forEach var="order" items="${orderList}">
				<tr height="50">
					<td width="200" align="center">
						<c:set var="number" value="${number+1}" />${number}
					</td>
					<td width = "100" align="center">
						<img src="img/${order.item_image}" height="50">
					</td>
					<td width = "400" align="center">
						<font size="3">${order.item_name}</font>
					</td>
					<td width = "100" align="center">
						<font size="3">${order.buy_count}</font>
					</td>
				</tr>
			</c:forEach>
			</table>

		<table>
			<tr height="50">
				<td colspan="2">
					<h3 align="left">구매자 정보</h3>
				</td>
			</tr>
			<tr height="5">
				<td colspan ="2">
					<hr size="1" color="gray" width="800">
				</td>
			</tr>
			<tr height="50">
				<td width="200" align="center">
					<font size="2"><b>이름</b></font>
				</td>
				<td width="600">
					<input type="text" name="name" value="${customer.name}" style="width:200px; height:30px">
				</td>
			</tr>
			<tr height="50">
				<td width="200" align="center">
					<font size="2"><b>전화번호</b></font>
				</td>
				<td width="600">
					<input type="text" name="tel" value="${customer.tel}" style="width:200px; height:30px">
				</td>
			</tr>
			<tr height="50">
				<td width="200" align="center">
					<font size="2"><b>주소</b></font>
				</td>
				<td width="600">
					<input type="text" name="address" value="${customer.address}" style="width:300px; height:30px">
				</td>
			</tr>
		</table>
		<br>

		<table>
			<tr height="50">
				<td colspan="2">
					<h3 align="left">결제방법</h3>
				</td>
			</tr>
			<tr height="5">
				<td colspan="2">
					<hr size="1" color="gray" width="800">
				</td>
			</tr>
			<tr height="50">
				<td width="200" align="center">
					<font size="2"><b>결제수단</b></font>
				</td>
				<td width="600">
					<select name="howpay">
						<option value="1">계좌이체</option>
						<option value="2">신용카드</option>
					</select>
				</td>
			</tr>
		</table>
		
		<table>
			<tr height="50">
				<td width="800">
					<h3 align="left">결제금액</h3>
				</td>
			</tr>
			<tr height="5">
				<td width="800">
					<hr size="1" color="gray" width="800">
				</td>
			</tr>
			<tr height="50">
				<td align="right" width="800">
					<h3><fmt:formatNumber value="${total}" pattern="#,###" />원</h3>
				</td>
			</tr>
			<tr height="50">
				<td align="center" width="800">
					<input type="image" src = "img/pay.PNG" name="submit" value="submit" style="height:50px">
					 <input type="hidden" name="buy_count" value="${order.buy_count}">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>