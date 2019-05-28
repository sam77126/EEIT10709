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
<%-- <jsp:include page="/commons/header.jsp" />	 --%>
<%-- <jsp:include page="/commons/article.jsp" />	 --%>
<table border='1' BGColor='#FFFFFF' width="65%" height="50">
		<tr>
			<td align="CENTER">
				<form action="showAllServlet" method="POST">
					<input type="submit" value="查詢全部"></form>
			</td>
			<td align="CENTER">
			<input type="text" id="name1" name="na"
				autofocus autocomplete="off" placeholder="請輸入店名查詢" size="12">
				<button class="button" onclick="clickF4()">依店名查詢</button>
				 <span id="nspan"></span>
			</td>
			<td align="CENTER">
				<button class="button" onclick="clickF1()">新增</button>
			</td>
			<td align="CENTER">
				<button class="button" onclick="javascript:updateMethod();">修改</button>
			</td>
			<td align="CENTER">
				<button class="button" onclick="clickF3()">刪除</button>
			</td>
			<td align="CENTER"></td>
		</tr>
	</table>
<!-- 	<a href="showTable01">A</a> -->
	<div>
			<form>
		<table align="left" border='1' width="68%">
			<tr bgcolor="#C8EFD4">
				<td colspan='6' align='center'><b>新北市商圈特色商家</b></td>
			</tr>
			<tr bgcolor="#C8EFD4">
				<th></th>
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
					<td><input name="checkbox" type="checkbox"></td>
					<td>${stores.town}</td>
					<td>${stores.store}</td>
					<td>${stores.telephone}</td>
					<td>${stores.addr}</td>
					<td>${stores.product}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
			<form action="updateServlet" method="POST" onsubmit="return check(this);">
		<table align="right" border='1' width="30%">
			<tr bgcolor="#C8EFD4">
				<td></td>
			</tr>
			
				<tr><td>
				<label class="t1" for="name1">商圈：</label>
                    <input type="text" id="name1" name="town" value="" autocomplete="off" size="20">
                    <span id="nspan"></span>
				</td></tr>
				<tr><td>
				<label class="t1" for="name1">店名：</label>
                    <input type="text" id="name1" name="store" value="" autocomplete="off" size="20">
                    <span id="nspan"></span>
				</td></tr>
				<tr><td>
				<label class="t1" for="name1">電話：</label>
                    <input type="text" id="name1" name="telephone" value="" autocomplete="off" size="20">
                    <span id="nspan"></span>
				</td></tr>
				<tr><td>
				<label class="t1" for="name1">地址：</label>
                    <input type="text" id="name1" name="addr" value="" autocomplete="off" size="28">
                    <span id="nspan"></span>
				</td></tr>
				<tr><td>
				<label class="t1" for="name1">商品：</label>
                    <textarea cols="35" rows="5" id="name1" name="product" ></textarea>
                    <span id="nspan"></span>
				</td></tr>
				<tr><td align="CENTER">
				<input type="submit" value="確定">
				</td></tr>
				<tr><td>
				</td></tr>
				<tr><td></td></tr>
		</table>
				</form>
	</div>
	<script>
	function updateMethod(){
		document.getElementById("method").setAttribute("value", ); 
		document.getElementById("ud").submit(); 
	}
	</script>
</body>
</html>