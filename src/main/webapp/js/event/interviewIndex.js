$(function(){
	$('#interview').datagrid({    
		pageList: [10,20,50,100],//分页大小
	    pagination:true,
	    rownumbers:true,
	    pagePosition:"bottom",
	    idField: 'interviewId', 
	    width: ($("#list").width()),
	    height:$("#list").height(),
	    fitColumns:true,
	    toolbar:"#btn",
	    singleSelect:true,
	    sortName:"time",
	    sortOrder:"asc",
	    columns:[[    
	        {field:'interviewId',title:'',hidden:true},
	        {field:'time',title:'来访时间',width:80},  
	        {field:'client',title:'来访者',width:60},        
	        {field:'interviewee',title:'被访者',width:60},    
	        {field:'intervieweeNo',title:'被访者学号',width:80},
	        {field:'buildingNo',title:'被访者楼号',width:60},
	        {field:'roomNo',title:'被访者宿舍号',width:60},
	        {field:'reason',title:'来访原因',width:255},
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
	$('#interview').datagrid("options").queryParams={
			fields:JSON.stringify({
				interviewNo: $("#interviewNo").val(),
				interview: $("#interview").val()
			})
		};
	$('#interview').datagrid("options").url = 
		ctx + "/interview/searchInterview.action?ids=" + 
		Math.random();
	$('#interview').datagrid("load");
}

//改
function edit(){
	var row = $('#interview').datagrid("getSelected");
	
	if(row==null){
		alert("请选择要编辑的行");
		return false;
	}
	
	addTab('来访信息编辑',ctx +
			'/pages/event/interviewEdit.action?id=' +
			row.interviewId);
}

//删
function deleteInterview(){
	var row = $('#interview').datagrid("getSelected");
	
	if(row==null){
		alert("请选择要删除的行");
		return false;
	}
	
	if(window.confirm("你确定要删除吗?")){
		$.ajax({
			type : "post",
			dataType : 'json',
			url : ctx + "/interview/deleteById.action?ids=" + 
					Math.random(),
			data : {
				id : row.interviewId,
			},
			success : function(data) {
				alert(data.msg);
				$('#interview').datagrid("reload");
			},
			async : true
		});
	}
}
