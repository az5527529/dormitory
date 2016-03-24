<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<html>
<script src="${ctx}/js/student/studentEdit.js" type="text/javascript"></script>
<body>

	<div id="cc" class="easyui-layout" style="width: 100%; height: 470px;">
		<div data-options="region:'north',title:'编辑区',split:false"
			style="height:100%">
			<div id="edit" style="height:90%">
			<form id="ff" method="post">
				<ul>
					<li><label for="studentNo">学号:</label> <input id="studentNo" name="studentNo"
						class="easyui-validatebox" /></li>
					<li><label for="studentName">名字:</label> <input name="studentName"
						id="studentName" class="easyui-validatebox" /></li>
				</ul>
			</form>
			</div>
			<div style="clear:both"></div>
			<div id="btn" style="height:10%">
				<input type="button" value="保存" onclick="submit()"/>
				<input type="button" value="取消" />
			</div>
		</div>

		
	</div>
</body>
</html>