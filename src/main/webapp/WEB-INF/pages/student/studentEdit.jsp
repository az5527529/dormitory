<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<html>


<script src="${ctx}/js/student/studentEdit.js" type="text/javascript"></script>
<body>

	<div id="cc" class="easyui-layout" style="width: 1086px; height: 470px;">
		<div data-options="region:'north',title:'编辑区',split:false"
			style="height: 100%">
			<div id="edit" style="height: 90%">
				<form id="ff" method="post">
					<input name="studentId" id="studentId" type="hidden"
						value='${pageContext.request.getParameter("id")}' />
					<ul style="width:1086px">
						<li><label for="studentNo">学号:</label> <input id="studentNo"
							name="studentNo" class="easyui-validatebox"
							data-options="required:true" /></li>
						<li><label for="studentName">名字:</label> <input
							name="studentName" id="studentName" class="easyui-validatebox"
							data-options="required:true" /></li>
						<li><label for="idCard">身份证:</label> <input name="idCard"
							id="idCard" class="easyui-validatebox"
							data-options="required:true" /></li>
					</ul>
					<ul style="width:1086px">
						<li><label for="telephone">电话:</label> <input
							name="telephone" id="telephone" class="easyui-validatebox"
							data-options="required:true" /></li>
						<li><label for="sex">性别:</label> <select id="sex"
							class="easyui-combobox" name="sex" style="width:50px">
								<option value="1">男</option>
								<option value="0">女</option>
						</select></li>
						<li><label for="grade">年级:</label> <select id="grade"
							class="easyui-combobox" name="grade" >
								<option value="1">大一</option>
								<option value="2">大二</option>
								<option value="3">大三</option>
								<option value="4">大四</option>
								<option value="5">研究生</option>
						</select></li>
					</ul>
					<ul style="width:1086px">	
						<li><label for="studentClass">班别:</label> <input name="studentClass"
							id="studentClass" class="easyui-validatebox"
							data-options="required:true" /></li>
						<li><label for="major">专业:</label> <input name="major"
							id="major" class="easyui-validatebox"
							data-options="required:true" /></li>
						<li><label for="teacher">辅导员:</label> <input
							name="teacher" id="teacher" class="easyui-validatebox"
							/></li>
					</ul>
				</form>
			</div>
			<div style="clear: both"></div>
			<div id="btn" style="height: 10%">
				<input type="button" value="保存" onclick="submit()" /> <input
					type="button" value="取消" onclick="closeTab('学生编辑')" />
			</div>
		</div>


	</div>
</body>
</html>