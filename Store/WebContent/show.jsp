<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="javax.servlet.*"%>
<%@page import="java.util.List"%>
<%@page import="st.dao.StoreBean"%>
<%@page import="st.dao.StoreDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/styles.css'
	type="text/css" />
<meta http-equiv="content-Type" content="text/html" charset="UTF-8">
<title>Show Store Table</title>
</head>
<body>
	<div align="center">
		<table border='1' cellspacing='2' cellpadding='2'>
			<tr bgcolor="#C8EFD4">
				<td colspan='6' align='center'>新北市商圈特色商家</td>
			</tr>
			<tr bgcolor="#C8EFD4">
				<th>商圈</th>
				<th>店名</th>
				<th>電話</th>
				<th>地址</th>
				<th>商品</th>
				<th></th>
			</tr>
			<c:forEach var="stores" items="${AllStores}" varStatus="vs">
				<c:choose>
					<c:when test="${vs.count%2 == 0}">
						<c:set var="colorVar" value="#D9D9D9" />
					</c:when>
					<c:otherwise>
						<c:set var="colorVar" value="#F2F2F2" />
					</c:otherwise>
				</c:choose>
				<tr bgcolor="${colorVar}">
					<td>${stores.town}</td>
					<td>${stores.store}</td>
					<td>${stores.telephone}</td>
					<td>${stores.addr}</td>
					<td>${stores.product}</td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>