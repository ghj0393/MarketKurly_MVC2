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
	<form method="post" action="${contextPath}/insertCart.do">
		<table>
			<tr height="80">
				<td rowspan="7" width="350" align="center" >
					<img src="img/${item.getItem_image()}" height="350">
				</td>
				<td width="400" colspan="2">
					<font size="5"><b>${item.item_name}</b></font><br>
					<font size="2">${item.item_info}</font>
					
				</td>
			</tr>
			<tr height="70">
				<td width="400" colspan="2">
					<c:if test="${item.discount_rate == 0}">
						<font size="4"><b><fmt:formatNumber value="${item.item_price}" pattern="#,###" />원</b></font><br>
					</c:if>
					<c:if test="${item.discount_rate != 0}">
						<font size="3"><b><del><fmt:formatNumber value="${item.item_price}" pattern="#,###" />원</del></b></font> →
						<font size="4" color="purple"><b><fmt:formatNumber value="${item.item_price - item.item_price*item.discount_rate/100}" pattern="#,###" />원</b></font><br>
					</c:if>
					<font size="2" color="purple">로그인 후 적립혜택이 적용됩니다.</font>
				</td>
			</tr>
			<tr height="50">
				<td width="100">
					<font size="2"><b>판매단위</b></font>
				</td>
				<td width="300">
					<font size="2">1개</font>
				</td>
			</tr>
			<tr height="50">
				<td width="100">
					<font size="2"><b>배송방법</b></font>
				</td>
				<td width="300">
					<font size="2">샛별배송/택배배송</font>
				</td>
			</tr>
			<tr height="50">
				<td width="100">
					<font size="2"><b>포장타입</b></font>
				</td>
				<td width="300">
					<font size="2">상온/종이포장</font><br>
					<font size="1">택배배송은 에코포장이 스티로폼으로 대체됩니다.</font>
				</td>
			</tr>
			<tr height="50">
				<td width="100">
					<font size="2"><b>구매수량</b></font>
				</td>
				<td width="300">
					<input type="number" name="buy_count" min="0" max="100" size="100" value="1">
				</td>
			</tr>
			<tr height="35">
				<td colspan="2">
					<input type="image" src="img/sendcart.PNG" name="submit" value="submit" style="height:50px">
					<input type="hidden" name="item_number" value="${item.item_number}">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>