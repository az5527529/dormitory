<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<html>
<link rel="stylesheet" href="${ctx}/css/houseparent/houseparentEdit.css" type="text/css" />
<script src="${ctx}/js/houseparent/houseparentEdit.js" type="text/javascript"></script>
<body>
	<div id="mainbody" class="easyui-layout">
		<div data-options="region:'north',title:'编辑区',split:false" id="edit">
			<div id="edit_edit">
				<form id="searchForm" method="post">
					<input name="houseparentId" id="houseparentId" type="hidden" value='<%=request.getParameter("id")%>'}'/>
					<ul>
						<li><label for="houseparentNo">工号:</label>
						<input id="houseparentNo" name="houseparentNo" class="easyui-validatebox" /></li>
						<li><label for="houseparentName">名字:</label>
						<input name="houseparentName" id="houseparentName" class="easyui-validatebox" /></li>
						<li><label for="sex">性别:</label>
						<input id="sex" name="sex" class="easyui-validatebox" /></li>
						<li><label for="buildingNo">管理楼号:</label>
						<input id="buildingNo" name="buildingNo" class="easyui-validatebox" /></li>
						<li><label for="idCard">身份证:</label>
						<input id="idCard" name="idCard" class="easyui-validatebox" /></li>
						<li><label for="telephone">联系电话:</label>
						<input id="telephone" name="telephone" class="easyui-validatebox" /></li>
						<li><label for="createdByUser">创建者:</label>
						<input id="createdByUser" name="createdByUser" class="easyui-validatebox" value="超管" /></li>
						<li><label for="updatedByUser">更新者:</label>
						<input id="updatedByUser" name="updatedByUser" class="easyui-validatebox" value="超管"/></li>
						
						
					</ul>
				</form>
			</div>
			
			<div style="clear:both"></div>
			
			<div id="btn">
				<input type="button" value="保存" onclick="submit()"/>
				<input type="button" value="取消" onclick="closeTab('宿管编辑')"/>
			</div>
			
		</div>
	</div>
</body>
</html>