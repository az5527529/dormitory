<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<html>
<script src="${ctx}/js/student/checkInIndex.js?V=2" type="text/javascript"></script>
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
			plain="true"></a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-edit" id="checkIn" plain="true" onclick="checkIn()"
			text="入住登记"></a>
	</div>
	<div id="editDiv" class="easyui-dialog" title="入住登记"
		style="width: 600px; height: 200px"
		data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
		<form id="editForm" style="margin-top: 10px" method="post">
			<input name="checkInId" id="checkInId" type="hidden" />
			<input name="studentId" id="studentIdEdit" type="hidden" />
			<table cellpadding="5px" style="text-align: right;">
				<tr>
					<td><label for="buildingNo">楼号:</label> <input id="buildingNo"
						class="easyui-combobox" name="buildingNo"
						data-options="required:true,valueField:'buildingNo',textField:'buildingNo',
    								url:'${ctx}/sbBuilding/combobox.action', editable:false
    								" />
					</td>
					<td><label for="roomNo">房号:</label> <input id="roomNo"
						class="easyui-combobox" name="roomNo"
						data-options="required:true,valueField:'roomNo',textField:'roomNo',
    					editable:false"/>
					</td>
					
				</tr>
				<tr>
					<td> 
						<label for="checkInTime">入住时间:</label> 
						<input class="easyui-datebox" name="checkInTime"     
        				data-options="required:true,editable:false" id="checkInTime"/> 
					</td>
					<td>
						<label for="reason">原因:</label> 
						<textarea name="reason" style="height:40px;width:200px" maxLength="256"></textarea>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>