<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/pages/common/head.jsp" %>
<html>
<script type="text/javascript">
function login() {
	$.ajax({
		type : "post",
		url : "${ctx}/pages/common/b.action?ids=" + Math.random(),
		success : function(data) {
			
		},
		async : true
	});
}
</script>
<body>
	<a href="${ctx}/pages/common/b.action">登陆</a>
	<input type="button" value="aa" onclick="login()"/>
	<a href="${ctx}/index.jsp">登陆</a>
</body>	
</html>