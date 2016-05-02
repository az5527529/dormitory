/**
 * 
 */
$(function(){
	
	$('#room').datagrid({    
		pageList: [10,20,50,100],
	    pagination:true,
	    rownumbers:true,
	    pagePosition:"bottom",
	    idField: 'sbRoomId', 
	    width: ($("#list").width()),
	    height:$("#list").height(),
	    fitColumns:true,
	    toolbar:"#btn",
	    singleSelect:true,
	    sortName:"roomNo",
		sortOrder:"asc",
	    columns:[[    
	        {field:'sbRoomId',title:'',hidden:true},    
	        {field:'roomNo',title:'房号',width:200},    
	        {field:'buildingNo',title:'所属楼',width:200},
	        {field:'area',title:'面积/m2',width:200},
	        {field:'bedNum',title:'床位数',width:200},
	        {field:'bedLeft',title:'剩余床位',width:200},
	        {field:'isFull',title:'是否已满',formatter:booleanFormater,width:200},
	        {field:'createdByUser',title:'创建人',width:200},
	        {field:'updatedByUser',title:'修改人',width:200},
	    ]]    
	});  
	
	$('#editDiv').dialog({   
		onClose:function(){
			$("#editForm").form("clear");
		},
		buttons:[{
			text:'保存',
			handler:saveRoom
		},{
			text:'取消',
			handler:cancel
		}]
	});  
})
function saveRoom(){
	
	$('#editForm').form('submit', {    
	    url:ctx+"/sbRoom/saveOrUpdate.action",    
	    /*onSubmit: function(){    
	        // do some check    
	        // return false to prevent submit;    
	    	return $("#editForm").form("validate");
	    },   */ 
	    success:function(data){    
	    	var obj = JSON.parse(data);
	        if(obj.errorMessage){
	        	newAlert(data.errorMessage);
	        }else{
	        	newShow("保存成功");
	        	cancel();
	        	$('#room').datagrid("reload");
	        }
	    }    
	}); 
}
function cancel(){
	$("#editDiv").dialog("close");
	$("#editForm").form("clear");
}
function booleanFormater(value,row,index){
	if(value==0){
		return "否";
	}else{
		return "是";
	}
}
function searchRoom(){
	$('#room').datagrid("options").queryParams={
		fields:JSON.stringify({"roomNo":$("#roomNo").val(),"buildingNo":$("#buildingNo").combobox("getValue"),"isFull":$("#isFull").combobox("getValue")}),
		};
	$('#room').datagrid("options").url=ctx+"/sbRoom/searchSbRoom.action?ids=" + Math.random();
	$('#room').datagrid("load");
}

function newRoom(){
	$("#editDiv").dialog("open");
}
function edit(){
	var row = $('#room').datagrid("getSelected");
	if(row==null){
		newAlert("请选择要编辑的行");
		return false;
	}
	$("#editDiv").dialog("open");
	$("#editForm").form("load",row);
}
function deleteRoom(){
	var row = $('#room').datagrid("getSelected");
	if(row==null){
		newAlert("请选择要删除的行");
		return false;
	}
	$.messager.confirm('确认对话框', '你确定要删除吗?', function(r){
		if (r){
			$.ajax({
				type : "post",
				dataType : 'json',
				url : ctx+"/sbRoom/deleteById.action?ids=" + Math.random(),
				data : {
					id : row.sbRoomId,
				},
				success : function(data) {
					newShow(data.msg);
					$('#room').datagrid("reload");
				},
				async : true
			});
		}
	});
}