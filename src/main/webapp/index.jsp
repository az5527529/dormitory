<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
		style="height: 100px;"></div>
	<div data-options="region:'west',title:'系统菜单',split:true"
		style="width: 200px;">
		<div id="menu" class="easyui-accordion" data-options="fit:true">
			<div title="Title1">
				<ul>
					<li><a href="#" title="${ctx}/pages/student/student.action">学生信息</a></li>
					<li><a href="#">宿舍信息</a></li>
				</ul>
			</div>
			<div title="Title2">
				<ul>
					<li><a href="#">学生信息</a></li>
					<li><a href="#">宿舍信息</a></li>
				</ul>
			</div>
			<div title="Title3">content3</div>
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