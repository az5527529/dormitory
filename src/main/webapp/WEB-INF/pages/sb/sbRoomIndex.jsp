<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<html>
<style type="text/css">
	#editDiv input{
		width:120px;
	}
</style>
<script src="${ctx}/js/sb/sbRoomIndex.js" type="text/javascript"></script>
<body>
	<div id="cc" class="easyui-layout" style="width: 100%; height: 460px">

		<div data-options="region:'north',border:false" id="search"
			style="padding: 5px; height: 70px">
			<form id="searchForm" style="margin-top: 10px">
				<ul>
					<li><label for="roomNo">房号:</label> <input id="roomNo"
						class="easyui-validatebox" /></li>
					<li><label for="buildingNo">楼号:</label> 
					<input id="buildingNo" class="easyui-combobox" name="buildingNo"   
    					data-options="valueField:'buildingNo',textField:'buildingNo',
    								url:'${ctx}/sbBuilding/combobox.action', 
    								"
		/>  
    				</li>
				</ul>
			</form>
		</div>
		<div data-options="region:'center',split:true" style="height: 390px"
			id="list">
			<table id="room"></table>
		</div>
	</div>
	<div id="btn">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'" onclick="searchRoom()"
			plain="true"></a> 
		<a href="#" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" id="new" onclick="newRoom()"></a> 
		<a href="#"
			class="easyui-linkbutton" iconCls="icon-edit" id="edit" plain="true" onclick="edit()"></a>
		 <a
			href="#" class="easyui-linkbutton" iconCls="icon-remove" id="remove" plain="true" onclick="deleteRoom()"></a>
	</div>
	
	<div id="editDiv" class="easyui-dialog" title="编辑楼层" style="width:400px;height:200px"   
        data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">   
    	<form id="editForm" style="margin-top: 10px" method="post">
    		<input name="sbBuildingId"
						id="sbBuildingIdEdit" type="hidden" />
    		<table cellpadding="5px" style="text-align:right;">
    			<tr>
    				<td><label for="buildingNoEdit">楼号:</label> <input id="buildingNoEdit"
						class="easyui-numberbox" data-options="required:true,min:0,precision:0" name="buildingNo"/></td>
    				<td><label for="roomNumEdit">房间数:</label> <input id="roomNumEdit"
						class="easyui-numberbox" data-options="required:true,min:0,precision:0" name="roomNum"/></td>
    			</tr>
    			<tr>
    				<td><label for="roomLeftEdit">所剩空房:</label> <input id="roomLeftEdit"
						class="easyui-numberbox" data-options="required:true,min:0,precision:0" name="roomLeft"/></td>
    				<td><label for="floorNumEdit">楼层数:</label> <input id="floorNumEdit"
						class="easyui-numberbox" data-options="required:true,min:0,precision:0" name="floorNum"/></td>
    			</tr>
    		</table>				
			</form>    
	</div>  
	<script type="text/javascript">
	var roleType = ${userInfo.roleType};
	if(roleType != 1){
		$("#new,#edit,#remove").hide();
	}
</script>
</body>

</html>