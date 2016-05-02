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
	        {field:'grade',title:'年级',width:80},
	        {field:'studentClass',title:'班别',width:80},
	        {field:'teacher',title:'辅导员',width:80},
	        {field:'isGraduated',title:'是否为研究生',width:80},
	    ]]    
	});  
	
	$('#editDiv').dialog({   
		onClose:function(){
			$("#editForm").form("clear");
		},
		buttons:[{
			text:'保存',
			handler:saveChangeRoom
		},{
			text:'取消',
			handler:cancel
		}]
	});
	$('#buildingNo').combobox({
		onSelect: loadRoomNo
	});

})
var roomNoArray = new Array();
function loadRoomNo(record){
	$("#roomNo").combobox("clear");
	$("#roomNo").combobox("loadData",{});
	var buildingNo = $("#buildingNo").combobox("getValue");
	if(buildingNo !=null && buildingNo!=""){
		var roomNos="";
		for(i=0;i<roomNoArray.length;i++){
			if(buildingNo==roomNoArray[i].buildingNo){
				roomNos=roomNoArray[i].roomNo;
				break;
			}
		}
		if(roomNos==""){
			$.ajax({
				type : "post",
				dataType : 'json',
				url : ctx+"/sbRoom/combobox.action",
				data : {
					fields:JSON.stringify({"buildingNo":buildingNo,"isFull":"0"}),
				},
				success : function(data) {
					
					var obj = new Object();
					obj.buildingNo = buildingNo;
					obj.roomNo = data;
					roomNoArray.push(obj);
					roomNos=data;
				},
				async : false
			});
		}
		$("#roomNo").combobox("loadData",roomNos);
	}
	
}
function sexFormatter(value,row,index){
	if(value=0){
		return "女";
	}else{
		return "男";
	}
}
function searchStudent(){
	$('#student').datagrid("options").queryParams={
		fields:JSON.stringify({"studentNo": $("#studentNo").val(),"studentName": $("#studentName").val(),"isCheckIn":"1"}),
		
		};
	$('#student').datagrid("options").url=ctx+"/student/searchStudent.action?ids=" + Math.random();
	$('#student').datagrid("load");
}

function changeRoom(){
	var row = $('#student').datagrid("getSelected");
	if(row==null){
		newAlert("请选择要进行换宿登记的学生");
		return false;
	}
	$("#editDiv").dialog("open");
	$("#studentIdEdit").val(row.studentId);
	$("#startBuildingNo").val(row.buildingNo);
	$("#startRoomNo").val(row.roomNo);
}
function saveChangeRoom(){
	if($("#startBuildingNo").val()==$("#buildingNo").combobox("getValue")&&$("#startRoomNo").val()==$("#roomNo").combobox("getValue")){
		newAlert("不能选学生的当前宿舍为换宿舍对象！");
		return;
	}
	$('#editForm').form('submit', {    
	    url:ctx+"/changeRoom/doChangeRoom.action",    
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
	        	newShow(obj.msg);
	        	cancel();
	        	$('#student').datagrid("reload");
	        }
	    }    
	}); 
}
function cancel(){
	$("#editDiv").dialog("close");
	$("#editForm").form("clear");
}

