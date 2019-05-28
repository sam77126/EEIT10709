<%@ page contentType="text/html; charset=UTF-8" session="false"%>
<script>
	function gAllStores() {
		alert("success");
		<a href="<c:out value='${pageContext.request.contextPath}' />/index.jsp" >
	}
</script>
<center>
	<table border='1' BGColor='#FFFFFF' width="100%" height="50">
		<tr>
			<td align="CENTER">
				<!-- 			<input type="button" value="查詢全部" onClick="gAllStores()"> -->
				<form action="<c:url value='${pageContext.request.contextPath}/showTable01.jsp' />" method="POST">
					<input type="submit" value="查詢全部"></form>
			</td>
			<td align="CENTER"><input type="text" id="name1" name="na"
				autofocus autocomplete="off" placeholder="請輸入店名查詢" size="10">
				<button class="button" onclick="clickF4()">依店名查詢</button> <span
				id="nspan"></span></td>
			<td align="CENTER">
				<button class="button" onclick="clickF1()">新增</button>
			</td>
			<td align="CENTER">
				<button class="button" onclick="clickF2()">修改</button>
			</td>
			<td align="CENTER">
				<button class="button" onclick="clickF3()">刪除</button>
			</td>
			<td align="CENTER"><FONT face="Verdana" SIZE="+2">空白</FONT></td>
		</tr>
	</table>
</center>