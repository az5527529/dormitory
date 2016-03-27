/**
 * 
 */
$(function(){
	var id = $("#studentId").val();
	if(id>0){
		$.ajax({
			type : "post",
			dataType : 'json',
			url : ctx+"/student/searchById.action?ids=" + Math.random(),
			data : {
				id : id,
			},
			success : function(data) {
				var errorMsg = data['errorMsg'];
				if (undefined!=errorMsg&&""!=errorMsg) {
					alert(errorMsg);
				}else{
					$('#ff').form("load",data);
				}
			},
			async : true
		});
	}
})
function submit(){
	$('#ff').form('submit', {    
	    url:ctx+"/student/saveOrUpdate.action",    
	    onSubmit: function(){    
	        // do some check    
	        // return false to prevent submit;    
	    	
	    },    
	    success:function(data){    
	    	var obj = JSON.parse(data);
	        if(obj.errorMessage){
	        	alert(data.errorMessage);
	        }else{
	        	alert("保存成功");
	        	var $input = $("#ff :input[name]");
	        	for(i=0;i<$input.size();i++){
	        		name = $input[i].name;
	        		$input[i].value=obj[name];
	        	}

	        }
	    }    
	}); 
}