<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<html>
<script src="${ctx}/js/student/checkOutIndex.js?V=2"
	type="text/javascript"></script>
<body>
	<div id="cc" class="easyui-layout" style="width: 100%; height: 460px">

		<div data-options="region:'north',border:false" id="search"
			style="padding: 5px; height: 70px">
			<form id="searchForm" style="margin-top: 10px">
				<ul>
					<li><label for="timeStart">处理时间从:</label><input
						class="easyui-datebox" name="timeStart"
						data-options="editable:false" id="timeStart" /></li>
					<li><label for="timeEnd">到:</label><input
						class="easyui-datebox" name="timeEnd"
						data-options="editable:false" id="timeEnd" /></li>
					<li><label for="registType">类型</label> <select id="cc"
						class="easyui-combobox" name="dept" style="width: 200px;">
							<option value=""></option>
							<option value="1">入住登记</option>
							<option value="2">换宿登记</option>
							<option value="3">退宿登记</option>
					</select></li>
				</ul>
			</form>
		</div>
		<div data-options="region:'center',split:true" style="height: 390px"
			id="list">
			<table id="regist"></table>
		</div>
	</div>
	<div id="btn">
		<a href="#" class="easyui-linkbutton"
			data-options="iconCls:'icon-search'" onclick="searchReg()"
			plain="true"></a>
	</div>
</body>
</html>