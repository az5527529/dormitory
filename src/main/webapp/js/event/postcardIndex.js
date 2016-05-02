$(function(){
	$('#postcard').datagrid({    
		pageList: [10,20,50,100],//分页大小
	    pagination:true,
	    rownumbers:true,
	    pagePosition:"bottom",
	    idField: 'postcardId', 
	    width: ($("#list").width()),
	    height:$("#list").height(),
	    fitColumns:true,
	    toolbar:"#btn",
	    singleSelect:true,
	    sortName:"time",
	    sortOrder:"asc",
	    columns:[[    
	        {field:'postcardId',title:'',hidden:true},
	        {field:'time',title:'送达时间',width:80},  
	        {field:'sender',title:'寄件者',width:60},        
	        {field:'studentName',title:'收件者',width:60},    
	        {field:'studentNo',title:'收件者学号',width:80},
	        {field:'buildingNo',title:'收件者楼号',width:60},
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
	$('#postcard').datagrid("options").queryParams={
			fields:JSON.stringify({
				postcardNo: $("#postcardNo").val(),
				postcard: $("#postcard").val()
			})
		};
	$('#postcard').datagrid("options").url = 
		ctx + "/postcard/searchInterview.action?ids=" + 
		Math.random();
	$('#postcard').datagrid("load");
}

//改
function edit(){
	var row = $('#postcard').datagrid("getSelected");
	
	if(row==null){
		alert("请选择要编辑的行");
		return false;
	}
	
	addTab('信件信息编辑',ctx +
			'/pages/event/postcardEdit.action?id=' +
			row.postcardId);
}

//删
function deleteInterview(){
	var row = $('#postcard').datagrid("getSelected");
	
	if(row==null){
		alert("请选择要删除的行");
		return false;
	}
	
	if(window.confirm("你确定要删除吗?")){
		$.ajax({
			type : "post",
			dataType : 'json',
			url : ctx + "/postcard/deleteById.action?ids=" + 
					Math.random(),
			data : {
				id : row.postcardId,
			},
			success : function(data) {
				alert(data.msg);
				$('#postcard').datagrid("reload");
			},
			async : true
		});
	}
}
