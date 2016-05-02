/**
 * 
 */
$(function(){
	$('#student').datagrid({    
		pageList: [10,20,50,100],
	    pagination:true,
	    rownumbers:true,
	    pagePosition:"bottom",
	    idField: 'studentId', 
	    width: ($("#list").width()),
	    height:$("#list").height(),
	    fitColumns:true,
	    toolbar:"#btn",
	    singleSelect:true,
	    sortName:"studentNo",
	    sortOrder:"asc",
	    columns:[[    
	        {field:'studentId',title:'',hidden:true},    
	        {field:'studentName',title:'名字',width:75},    
	        {field:'studentNo',title:'学号',width:80},
	        {field:'sex',title:'性别',width:80,formatter:sexFormatter},
	        {field:'idCard',title:'身份证',width:80},
	        {field:'telephone',title:'电话',width:80},
	        {field:'major',title:'专业',width:80},
	        {field:'grade',title:'年级',width:80,formatter:gradeFormatter},
	        {field:'studentClass',title:'班别',width:80},
	        {field:'teacher',title:'辅导员',width:80},
	        {field:'isGraduated',title:'是否为研究生',width:80,formatter:booleanFormatter},
	        {field:'buildingNo',title:'楼号',width:40,formatter:noFormatter},
	        {field:'roomNo',title:'房号',width:40,formatter:noFormatter},
	        {field:'createdByUser',title:'创建人',width:80},
	        {field:'updatedByUser',title:'修改人'},
	        {field:'isCheckIn',title:'是否入住',formatter:booleanFormatter},
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
function gradeFormatter(value,row,index){
	if(value=="1"){
		return "大一";
	}
	if(value=="2"){
		return "大二";
	}
	if(value=="3"){
		return "大三";
	}
	if(value=="4"){
		return "大四";
	}
	if(value=="5"){
		return "研究生";
	}
	
}
function booleanFormatter(value,row,index){
	if(value==0){
		return  "否";
	}else{
		return "是";
	}
}
function noFormatter(value,row,index){
	if(row.isCheckIn==0){
		return "";
	}else {
		return value;
	}
}
function searchStudent(){
	$('#student').datagrid("options").queryParams={
		fields:JSON.stringify({"studentNo": $("#studentNo").val(),"studentName": $("#studentName").val()}),
		
		};
	$('#student').datagrid("options").url=ctx+"/student/searchStudent.action?ids=" + Math.random();
	$('#student').datagrid("load");
}

function edit(){
	var row = $('#student').datagrid("getSelected");
	if(row==null){
		newAlert("请选择要编辑的行");
		return false;
	}
	addTab('学生编辑',ctx+'/pages/student/studentEdit.action?id='+row.studentId);
}
function deleteStudent(){
	var row = $('#student').datagrid("getSelected");
	if(row==null){
		newAlert("请选择要删除的行");
		return false;
	}
	$.messager.confirm('确认对话框', '你确定要删除吗?', function(r){
		if (r){
			$.ajax({
				type : "post",
				dataType : 'json',
				url : ctx+"/student/deleteById.action?ids=" + Math.random(),
				data : {
					id : row.studentId,
				},
				success : function(data) {
					newShow(data.msg);
					$('#student').datagrid("reload");
				},
				async : true
			});
		}
	});
	
}