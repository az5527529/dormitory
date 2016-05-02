<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<html>

<link rel="stylesheet" href="${ctx}/css/event/disciplineIndex.css" type="text/css" />
<script src="${ctx}/js/event/disciplineIndex.js" type="text/javascript"></script>

<body>
	<div id="mainbody" class="easyui-layout">

		//搜索框
		<div data-options="region:'north',border:false" id="search">
			<form id="searchForm">
				<ul>
					<li><label for="studentName">学生:</label> 
						<input id="studentName" class="easyui-validatebox" /></li>
					<li><label for="studentNo">学号:</label> 
						<input id="studentNo" class="easyui-validatebox" /></li>
					<li><label for="time">违纪时间:</label> 
						<input id="time" class="easyui-datetimebox" 
							data-options="required:true,showSeconds:false,editable:false" 
							value="${notices.release_time}"/></li>
				</ul>
			</form>
		</div>
		
		//增改查按钮
		<div id="btn">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchInterview()" plain="true"></a> 
 		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="edit" onclick="addTab('来访信息登记','${ctx}/pages/event/disciplineEdit.action')"></a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="edit()"></a>
		</div>
		
		//结果输出
		<div data-options="region:'center',split:true" id="list">
			<table id="discipline"></table>
		</div>
		
	</div>
</body>
</html>