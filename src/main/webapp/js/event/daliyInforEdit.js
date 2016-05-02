$(function(){
	var id = $("#daliyInforId").val();
	
	if(id > 0){
		$.ajax({
			type : "post",
			dataType : 'json',
			url : ctx + "/daliyInfor/searchById.action?ids=" + 
					Math.random(),
			data : {
				id : id,
			},
			success : function(data) {
				var errorMsg = data['errorMsg'];
				if (errorMsg != undefined && errorMsg != "") {
					alert(errorMsg);
				}else{
					$('#searchForm').form("load",data);
				}
			},
			async : true
		});
	}
})

function submit(){
	$('#searchForm').form('submit', {    
	    url:ctx + "/daliyInfor/createOrUpdate.action",    
	    onSubmit: function(){ 
	    	
	    },
	    
	    success:function(data){    
	    	var obj = JSON.parse(data);
	    	
	        if(obj.errorMessage){
	        	alert(data.errorMessage);
	        }else{
	        	alert("保存成功");
	        	var $input = $("#searchForm : input[name]");
	        	
	        	for(i=0 ; i<$input.size() ; i++){
	        		name = $input[i].name;
	        		$input[i].value=obj[name];
	        	}
	        	
	        	closeTab('登记信息编辑');
	        }
	    }    
	});
}