$(function(){
	$('#discipline').datagrid({    
		pageList: [10,20,50,100],//分页大小
	    pagination:true,
	    rownumbers:true,
	    pagePosition:"bottom",
	    idField: 'disciplineId', 
	    width: ($("#list").width()),
	    height:$("#list").height(),
	    fitColumns:true,
	    toolbar:"#btn",
	    singleSelect:true,
	    sortName:"time",
	    sortOrder:"asc",
	    columns:[[    
	        {field:'disciplineId',title:'',hidden:true},
	        {field:'time',title:'违纪时间',width:80},        
	        {field:'studentName',title:'违纪者',width:60},    
	        {field:'studentNo',title:'违纪者学号',width:80},
	        {field:'buildingNo',title:'违纪者楼号',width:60},
	        {field:'roomNo',title:'违纪者宿舍号',width:60},
	        {field:'event',title:'原因',width:255},
	        {field:'isRead',title:'是否已读',formatter:isReadFormatter},
	        {field:'createdByUser',title:'创建者',width:60},
	        {field:'updatedByUser',title:'修改者',width:60},
	    ]]    
	});
})

function isReadFormatter(value,row,index){
	if(value=0){
		return "未读";
	}else{
		return "已读";
	}
}

//查
function searchInterview(){
	$('#discipline').datagrid("options").queryParams={
			fields:JSON.stringify({
				disciplineNo: $("#disciplineNo").val(),
				discipline: $("#discipline").val()
			})
		};
	$('#discipline').datagrid("options").url = 
		ctx + "/discipline/searchInterview.action?ids=" + 
		Math.random();
	$('#discipline').datagrid("load");
}

//改
function edit(){
	var row = $('#discipline').datagrid("getSelected");
	
	if(row==null){
		alert("请选择要编辑的行");
		return false;
	}
	
	addTab('违纪信息编辑',ctx +
			'/pages/event/disciplineEdit.action?id=' +
			row.disciplineId);
}

//删
function deleteInterview(){
	var row = $('#discipline').datagrid("getSelected");
	
	if(row==null){
		alert("请选择要删除的行");
		return false;
	}
	
	if(window.confirm("你确定要删除吗?")){
		$.ajax({
			type : "post",
			dataType : 'json',
			url : ctx + "/discipline/deleteById.action?ids=" + 
					Math.random(),
			data : {
				id : row.disciplineId,
			},
			success : function(data) {
				alert(data.msg);
				$('#discipline').datagrid("reload");
			},
			async : true
		});
	}
}
