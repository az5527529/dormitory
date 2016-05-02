/**
 * 
 */
$(function(){
	$('#regist').datagrid({    
		pageList: [10,20,50,100],
	    pagination:true,
	    rownumbers:true,
	    pagePosition:"bottom",
	    width: ($("#list").width()),
	    height:$("#list").height(),
	    fitColumns:true,
	    toolbar:"#btn",
	    singleSelect:true,
	    sortName:"time",
	    sortOrder:"desc",
	    columns:[[     
	        {field:'studentName',title:'名字',width:75},    
	        {field:'studentNo',title:'学号',width:80},
	        {field:'registType',title:'类别',width:80},
	        {field:'reason',title:'办理理由',width:80},
	        {field:'time',title:'办理时间',width:80},
	        {field:'createdByUser',title:'处理人',width:80},
	        {field:'startRoom',title:'变更前宿舍',width:80},
	        {field:'endRoom',title:'变更后宿舍',width:80},
	        {field:'sex',title:'性别',width:80,formatter:sexFormatter},
	        {field:'idCard',title:'身份证',width:80},
	        {field:'telephone',title:'电话',width:80},
	        {field:'major',title:'专业',width:80},
	        {field:'grade',title:'年级',width:80},
	        {field:'studentClass',title:'班别',width:80}, 
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
function searchReg(){
	$('#regist').datagrid("options").queryParams={
		fields:JSON.stringify({"timeStart": $("#timeStart").val(),"timeEnd": $("#timeEnd").val(),"registType":$("#registType").combobox("getValue"),"buildingNo":defaultBuildingNo}),
		
		};
	$('#student').datagrid("options").url=ctx+"/regOfDor/searchRegOfDor.action?ids=" + Math.random();
	$('#student').datagrid("load");
}

