<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.entity.SysMenuGroup"%>
<%@page import="com.entity.SysMenuItem"%>
<%@page import="com.entity.UserInfo"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<html>

<script type="text/javascript">
	function login() {
		$.ajax({
			type : "post",
			url : "a/show.action?ids=" + Math.random(),
			success : function(data) {
				alert(data);
			},
			async : true
		});
	}
	$(function(){
		$("a[title]").click(function(){
			var text = $(this).text();
			var href = $(this).attr("title");
			//1.判断是否已打开相应 的tab,有则选中，无责新建
			if($("#tt").tabs("exists",text)){
				$("#tt").tabs("select",text);
			}else{
				$("#tt").tabs("add",{
					title:text,
					content:'<iframe src="'+href+'" frameborder="0" width="100%" height="100%" />',
					//href:默认是通过url加载body内容，不加载head
					//href:href,
					closable:true
				});
			}
		});
	});
	function logout(){
		$.ajax({
			type : "post",
			url : "${ctx}/loginExt/logout.action?ids=" + Math.random(),
			success : function(data) {
				window.location = 'login.jsp';;
			},
			async : true
		});
	}
</script>
<style type="text/css">
#menu {
	width: 200px;
}

#menu ul {
	list-style: none;
	padding: 0;
	margin: 0;
}

#menu ul li {
	border-bottom: 1px solid red;
}

#menu ul li a {
	display: block;
	background-color: #008792;
	color: #fff;
	padding: 5px;
	text-decoration: none;
}

#menu ul li a:hover {
	background-color: #00a6ac;
	cursor: pointer;
}
</style>
<body class="easyui-layout">
	<div data-options="region:'north',title:'欢迎来到宿舍管理系统',split:true"
		style="height: 100px;">
		<b>欢迎您，${userInfo.userName}</b><br />登录时间:<%=new java.text.SimpleDateFormat("yyyy年MM月dd日 HH:MM").format(new java.util.Date()) %><br />
		<input type="button" id="logout" value="退出" onclick="logout()">
		</div>
	<div data-options="region:'west',title:'系统菜单',split:true"
		style="width: 200px;">
		<div id="menu" class="easyui-accordion" data-options="fit:true">
			
			<c:forEach var="group" items="${groupList}" >
				<div title="${group.groupDesc}">
				<ul>
					<c:forEach var="item" items="${userInfo.items}">
						<c:if test="${item.sysMenuGroupId==group.sysMenuGroupId}">
							<li><a href="#" title="${ctx}/${item.url}">${item.menuTitle}</a></li>
						</c:if>
					</c:forEach>
					
				</ul>
			</div>

			</c:forEach>

		</div>
	</div>
	<div data-options="region:'center',title:'操作页面'"
		style="padding: 1px; background: #fff;">
		<div id="tt" class="easyui-tabs" data-options="fit:true">
			<div title="系统首页" style="padding: 5px;">系统首页</div>
		</div>
	</div>
</body>

</html>