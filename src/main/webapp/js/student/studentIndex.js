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
	    columns:[[    
	        {field:'studentId',title:'',hidden:true},    
	        {field:'studentName',title:'名字',width:75},    
	        {field:'studentNo',title:'学号',width:80},
	        {field:'sex',title:'性别',width:80,formatter:sexFormatter},
	        {field:'idCard',title:'身份证',width:80},
	        {field:'telephone',title:'电话',width:80},
	        {field:'major',title:'专业',width:80},
	        {field:'grade',title:'年级',width:80},
	        {field:'studentClass',title:'班别',width:80},
	        {field:'teacher',title:'辅导员',width:80},
	        {field:'isGraduated',title:'是否为研究生',width:80},
	        {field:'buildingNo',title:'楼号',width:40},
	        {field:'roomNo',title:'房号',width:40},
	        {field:'createdByUser',title:'创建人',width:80},
	        {field:'updatedByUser',title:'修改人'},
	    ]]    
	});  
	

})
function sexFormatter(value,row,index){
	if(value=0){
		return "女";
	}else{
		return "男";
	}
}
function searchStudent(){
	$('#student').datagrid("options").queryParams={
		studentNo: $("#studentNo").val(),
		studentName: $("#studentName").val()
		};
	$('#student').datagrid("options").url=ctx+"/student/searchStudent.action?ids=" + Math.random();
	$('#student').datagrid("load");
}
