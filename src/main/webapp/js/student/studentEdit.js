/**
 * 
 */

function submit(){
	$('#ff').form('submit', {    
	    url:ctx+"/student/saveOrUpdate.action",    
	    onSubmit: function(param){    
	        // do some check    
	        // return false to prevent submit;    
	    	param.isUpdate = 0;
	    },    
	    success:function(data){    
	        console.log(data);    
	    }    
	}); 
}