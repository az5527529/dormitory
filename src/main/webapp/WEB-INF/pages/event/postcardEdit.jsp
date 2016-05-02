<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<html>
<link rel="stylesheet" href="${ctx}/css/event/postcardEdit.css" type="text/css" />
<script src="${ctx}/js/event/postcardEdit.js" type="text/javascript"></script>
<body>
	<div id="mainbody" class="easyui-layout">
		<div data-options="region:'north',title:'编辑区',split:false" id="edit">
			<div id="edit_edit">
				<form id="searchForm" method="post">
					<input name="postcardId" id="postcardId" type="hidden" value='<%=request.getParameter("id")%>'}'/>
					<ul>
						<li><label for="sender">寄件者:</label>
						<input id="sender" name="sender" class="easyui-validatebox" /></li>
						<li><label for="studentNo">收件者学号:</label>
						<input id="studentNo" name="studentNo" class="easyui-validatebox" /></li>
						<li><label for="studentName">收件者:</label>
						<input name="studentName" id="studentName" class="easyui-validatebox" /></li>
						<li><label for="time">来访时间:</label>
						<input name="time" id="time" class="easyui-datetimebox" 
							data-options="required:true,showSeconds:false,editable:false" 
							value="${notices.release_time}"/></li>
						<li><label for="buildingNo">收件者楼号:</label>
						<input name="buildingNo" id="buildingNo" class="easyui-validatebox" /></li>
						<li><label for="roomNo">收件者宿舍号:</label>
						<input name="roomNo" id="roomNo" class="easyui-validatebox" /></li>
						<li><label for="isRead">消息是否已读:</label>
						<input id="isRead" class="easyui-combobox" name="isRead"  
							style="width:50px;" 
    						data-options="
	    						valueField: 'id',
								textField: 'value',
								editable:false,
	    						data: [{
										id: '0',
										value: '否',
										selected:true   
									},{
										id: '1',
										value: '是'
									}]" /></li>
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
				<input type="button" value="取消" onclick="closeTab('')"/>
			</div>
			
		</div>
	</div>
</body>
</html>