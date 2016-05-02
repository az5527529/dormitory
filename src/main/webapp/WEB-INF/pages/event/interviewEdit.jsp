<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<html>
<link rel="stylesheet" href="${ctx}/css/event/interviewEdit.css" type="text/css" />
<script src="${ctx}/js/event/interviewEdit.js" type="text/javascript"></script>
<body>
	<div id="mainbody" class="easyui-layout">
		<div data-options="region:'north',title:'编辑区',split:false" id="edit">
			<div id="edit_edit">
				<form id="searchForm" method="post">
					<input name="interviewId" id="interviewId" type="hidden" value='<%=request.getParameter("id")%>'}'/>
					<ul>
						<li><label for="client">来访者:</label>
						<input id="client" name="client" class="easyui-validatebox" /></li>
						<li><label for="interviewNo">被访者学号:</label>
						<input id="interviewNo" name="interviewNo" class="easyui-validatebox" /></li>
						<li><label for="interview">被访者:</label>
						<input name="interview" id="interview" class="easyui-validatebox" /></li>
						<li><label for="time">来访时间:</label>
						<input name="time" id="time" class="easyui-datetimebox" 
							data-options="required:true,showSeconds:false,editable:false" 
							value="${notices.release_time}"/></li>
						<li><label for="buildingNo">被访者楼号:</label>
						<input name="buildingNo" id="buildingNo" class="easyui-validatebox" /></li>
						<li><label for="roomNo">被访者宿舍号:</label>
						<input name="roomNo" id="roomNo" class="easyui-validatebox" /></li>
						<li><label for="reason">来访原因:</label>
						<input name="reason" id="reason" class="easyui-validatebox" /></li>
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