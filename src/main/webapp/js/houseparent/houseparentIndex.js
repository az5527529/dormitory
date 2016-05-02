$(function(){
	$('#houseparent').datagrid({    
		pageList: [10,20,50,100],//分页大小
	    pagination:true,
	    rownumbers:true,
	    pagePosition:"bottom",
	    idField: 'houseparentId', 
	    width: ($("#list").width()),
	    height:$("#list").height(),
	    fitColumns:true,
	    toolbar:"#btn",
	    singleSelect:true,
	    sortName:"houseparentNo",
	    sortOrder:"asc",
	    columns:[[    
	        {field:'houseparentId',title:'',hidden:true},    
	        {field:'houseparentName',title:'名字',width:75},    
	        {field:'houseparentNo',title:'工号',width:80},
	        {field:'sex',title:'性别',width:80,formatter:sexFormatter},
	        {field:'idCard',title:'身份证',width:80},
	        {field:'telephone',title:'联系方式',width:80},
	        {field:'buildingNo',title:'楼号',width:40},
	        {field:'createdByUser',title:'创建人',width:80},
	        {field:'updatedByUser',title:'修改人'},
	    ]]    
	});  
	

})

function sexFormatter(value,row,index){
	if(value==0){
		return "女";
	}else{
		return "男";
	}
}

//查
function searchHouseparent(){
	$('#houseparent').datagrid("options").queryParams={
			fields:JSON.stringify({
				houseparentNo: $("#houseparentNo").val(),
				houseparentName: $("#houseparentName").val()
			})
		};
	$('#houseparent').datagrid("options").url = 
		ctx + "/houseparent/searchHouseparent.action?ids=" + 
		Math.random();
	$('#houseparent').datagrid("load");
}

//改
function edit(){
	var row = $('#houseparent').datagrid("getSelected");
	
	if(row==null){
		alert("请选择要编辑的行");
		return false;
	}
	
	addTab('宿管编辑',ctx +
			'/pages/houseparent/houseparentEdit.action?id=' +
			row.houseparentId);
}

//删
function deleteHouseparent(){
	var row = $('#houseparent').datagrid("getSelected");
	
	if(row==null){
		alert("请选择要删除的行");
		return false;
	}
	
	if(window.confirm("你确定要删除吗?")){
		$.ajax({
			type : "post",
			dataType : 'json',
			url : ctx + "/houseparent/deleteById.action?ids=" + 
					Math.random(),
			data : {
				id : row.houseparentId,
			},
			success : function(data) {
				alert(data.msg);
				$('#houseparent').datagrid("reload");
			},
			async : true
		});
	}
}
