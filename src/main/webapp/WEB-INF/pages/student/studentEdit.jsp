<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<html>
<script src="${ctx}/js/student/studentIndex.js" type="text/javascript"></script>
<body>
	<div id="cc" class="easyui-layout" style="width: 100%; height: 460px">

		<div data-options="region:'north',border:false" id="search"
			style="padding: 5px; height: 70px">
			<form id="searchForm" style="margin-top: 10px">
				<ul>
					<li><label for="studentNo">学号:</label> <input id="studentNo"
						class="easyui-validatebox" /></li>
					<li><label for="studentName">名字:</label> <input
						id="studentName" class="easyui-validatebox" /></li>
				</ul>
			</form>
		</div>
		<div data-options="region:'center',split:true" style="height: 390px"
			id="list">
			<table id="student"></table>
		</div>
	</div>
	<div id="btn">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'" onclick="searchStudent()"
			plain="true"></a> 
		<a href="#" class="easyui-linkbutton"
			iconCls="icon-add" plain="true"></a> 
		<a href="#"
			class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
		 <a
			href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
	</div>



</body>
</html>