/**
 * 
 */
$(function(){
	
	$('#building').datagrid({    
		pageList: [10,20,50,100],
	    pagination:true,
	    rownumbers:true,
	    pagePosition:"bottom",
	    idField: 'sbBuidingId', 
	    width: ($("#list").width()),
	    height:$("#list").height(),
	    fitColumns:true,
	    toolbar:"#btn",
	    singleSelect:true,
	    sortName:"buildingNo",
	    sortOrder:"asc",
	    columns:[[    
	        {field:'sbBuidingId',title:'',hidden:true},    
	        {field:'buildingNo',title:'楼号',width:75},    
	        {field:'roomNum',title:'房间数',width:80},
	        {field:'roomLeft',title:'所剩空房',width:80},
	        {field:'floorNum',title:'楼层数',width:80},
	        {field:'createdByUser',title:'创建人',width:80},
	        {field:'updatedByUser',title:'修改人'},
	    ]]    
	});  
	
	$('#editDiv').dialog({   
		onClose:function(){
			$("#editForm").form("clear");
		},
		buttons:[{
			text:'保存',
			handler:saveBuilding
		},{
			text:'取消',
			handler:cancel
		}]
	});  
})
function saveBuilding(){
	
	$('#editForm').form('submit', {    
	    url:ctx+"/sbBuilding/saveOrUpdate.action",    
	    onSubmit: function(){    
	        // do some check    
	        // return false to prevent submit;    
	    	return $("#editForm").form("validate");
	    },    
	    success:function(data){    
	    	var obj = JSON.parse(data);
	        if(obj.errorMessage){
	        	alert(data.errorMessage);
	        }else{
	        	alert("保存成功");
	        	cancel();
	        	$('#building').datagrid("reload");
	        }
	    }    
	}); 
}
function cancel(){
	$("#editDiv").dialog("close");
	$("#editForm").form("clear");
}
function sexFormatter(value,row,index){
	if(value=0){
		return "女";
	}else{
		return "男";
	}
}
function searchStudent(){
	$('#building').datagrid("options").queryParams={
		fields:JSON.stringify({"buildingNo": $("#buildingNo").val()}),
		};
	$('#building').datagrid("options").url=ctx+"/sbBuilding/searchSbBuilding.action?ids=" + Math.random();
	$('#building').datagrid("load");
}

function newBuilding(){
	$("#editDiv").dialog("open");
}
function edit(){
	var row = $('#building').datagrid("getSelected");
	if(row==null){
		alert("请选择要编辑的行");
		return false;
	}
	$("#editDiv").dialog("open");
	$("#editForm").form("load",row);
}
function deleteStudent(){
	var row = $('#building').datagrid("getSelected");
	if(row==null){
		alert("请选择要删除的行");
		return false;
	}
	if(window.confirm("你确定要删除吗?")){
		$.ajax({
			type : "post",
			dataType : 'json',
			url : ctx+"/sbBuilding/deleteById.action?ids=" + Math.random(),
			data : {
				id : row.sbBuildingId,
			},
			success : function(data) {
				alert(data.msg);
				$('#building').datagrid("reload");
			},
			async : true
		});
	}
	
}