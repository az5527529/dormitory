$(function(){
	$('#daliyInfor').datagrid({    
		pageList: [10,20,50,100],//分页大小
	    pagination:true,
	    rownumbers:true,
	    pagePosition:"bottom",
	    idField: 'daliyInforId', 
	    width: ($("#list").width()),
	    height:$("#list").height(),
	    fitColumns:true,
	    toolbar:"#btn",
	    singleSelect:true,
	    sortName:"time",
	    sortOrder:"asc",
	    columns:[[    
	        {field:'daliyInforId',title:'',hidden:true},
	        {field:'time',title:'登记时间',width:80},        
	        {field:'studentName',title:'登记者',width:60},    
	        {field:'studentNo',title:'登记者学号',width:80},
	        {field:'buildingNo',title:'登记者楼号',width:60},
	        {field:'roomNo',title:'登记者宿舍号',width:60},
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
	$('#daliyInfor').datagrid("options").queryParams={
			fields:JSON.stringify({
				daliyInforNo: $("#daliyInforNo").val(),
				daliyInfor: $("#daliyInfor").val()
			})
		};
	$('#daliyInfor').datagrid("options").url = 
		ctx + "/daliyInfor/searchInterview.action?ids=" + 
		Math.random();
	$('#daliyInfor').datagrid("load");
}

//改
function edit(){
	var row = $('#daliyInfor').datagrid("getSelected");
	
	if(row==null){
		alert("请选择要编辑的行");
		return false;
	}
	
	addTab('日常信息编辑',ctx +
			'/pages/event/daliyInforEdit.action?id=' +
			row.daliyInforId);
}

//删
function deleteInterview(){
	var row = $('#daliyInfor').datagrid("getSelected");
	
	if(row==null){
		alert("请选择要删除的行");
		return false;
	}
	
	if(window.confirm("你确定要删除吗?")){
		$.ajax({
			type : "post",
			dataType : 'json',
			url : ctx + "/daliyInfor/deleteById.action?ids=" + 
					Math.random(),
			data : {
				id : row.daliyInforId,
			},
			success : function(data) {
				alert(data.msg);
				$('#daliyInfor').datagrid("reload");
			},
			async : true
		});
	}
}
