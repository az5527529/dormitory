<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/pages/common/head.jsp" %>
<html>
<script src="${ctx}/js/student/studentIndex.js" type="text/javascript"></script>
<body>
	<div id="search" >
		<form id="searchForm" style="margin-top:10px">
			<ul >
				<li>
					<label for="studentNo">学号:</label>   
					<input id="studentNo" class="easyui-validatebox"  />
				</li>
				<li>
					<label for="studentName">名字:</label>   
					<input id="studentName" class="easyui-validatebox"  />
				</li>
			</ul>
		</form>
	</div>
	<div style="clear:both"></div>
	<div id="btnDiv">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"   
        onclick="searchStudent()">查询</a>  
	</div>
	
	<div id="list" style="margin-top:10px">
		<table id="student"></table> 
	</div>
	
</body>	
</html>