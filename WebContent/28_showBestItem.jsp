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
	<table>
		<c:set var="i" value="0" />
		<c:forEach var="item" items="${itemList}">
		<c:if test="${i % 3 == 0}">
			<tr height="250" >
		</c:if>
			<td width = "300" align="center">
			<c:if test = "${item.item_stock == 0}">
				<img src="img/${item.item_image}" width="280" style="opacity:40%">
			</c:if>
			<c:if test = "${item.item_stock > 0 }">
				<a href="${contextPath}/showOneItem.do?item_num=${item.item_number}">
					<img src="img/${item.item_image}" width="280">
				</a>
			</c:if>
			<p>
			<font size = "5"><b>${item.item_name}</b></font></p>
			<c:if test="${item.item_stock > 0}">
				<c:set var="price" value="${item.item_price}" />
				<c:set var="realPrice" value="${item.item_price - item.item_price*item.discount_rate/100}" />
				<c:if test="${price > realPrice}">
					<p><font size="3"><del><fmt:formatNumber value="${item.item_price}" pattern="#,###" />원</del></font>
						→				
					<font size="4" color="purple"><b><fmt:formatNumber value="${realPrice}" pattern="#,###" />원</b></font></p>
				</c:if>
				<c:if test="${price == realPrice}">
					<p><font size="4"><fmt:formatNumber value="${item.item_price}" pattern="#,###" />원</font></p>
				</c:if>
			</c:if>
			
			<c:if test="${item.item_stock == 0}">
				<p><font size="3" color="red"><b>품절</b></font></p>
			</c:if>
			</td>
		<c:if test="${i % 3 == 2}">
			</tr>
		</c:if>
		<c:set var="i" value="${i+1}" />
		</c:forEach>
	</table>
</body>
</html>