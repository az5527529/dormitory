<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.entity.UserInfo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
%>
<c:set value="${pageContext.request.contextPath}" var="ctx" />
<c:set value="${userInfo.buildingNo}" var="defaultBuildingNo" />
<title>宿舍管理系统</title>

<!-- easyui环境 -->
<link rel="stylesheet" href="${ctx}/jquery-easyui-1.4.4/themes/icon.css" type="text/css"></link>
<link rel="stylesheet" href="${ctx}/jquery-easyui-1.4.4/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="${ctx}/css/common/common.css" type="text/css"></link>
<script type="text/javascript">
<!--
//-->
	var ctx="${ctx}";//定义项目路径
	var defaultBuildingNo = "${defaultBuildingNo}";//定义登陆人员所属楼
</script>
<script type="text/javascript" src="${ctx}/jquery-easyui-1.4.4/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${ctx}/js/common/common.js"></script>
