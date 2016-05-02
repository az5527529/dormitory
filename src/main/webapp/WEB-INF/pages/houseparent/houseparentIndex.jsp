<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<html>

<link rel="stylesheet" href="${ctx}/css/houseparent/houseparentIndex.css" type="text/css" />
<script src="${ctx}/js/houseparent/houseparentIndex.js" type="text/javascript"></script>

<body>
	<div id="mainbody" class="easyui-layout">
		
		//搜索框
		<div data-options="region:'north',border:false" id="search">
			<form id="searchForm">
				<ul>
					<li><label for="houseparentNo">工号:</label> 
					<input id="houseparentNo" class="easyui-validatebox" /></li>
					<li><label for="houseparentName">名字:</label>
					<input id="houseparentName" class="easyui-validatebox" /></li>
					<!-- <li><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchHouseparent()" plain="true"></a></li> -->
				</ul>
			</form>
		</div>
		
		//增删改查4个按钮
		<div id="btn">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchHouseparent()" plain="true"></a> 
 		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="edit" onclick="addTab('宿管编辑','${ctx}/pages/houseparent/houseparentEdit.action')"></a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="edit()"></a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteHouseparent()"></a>   
		</div>      
	
		//结果输出
		<div data-options="region:'center',split:true" id="list">
			<table id="houseparent"></table>
		</div>
	</div>
</body>
</html>