/**
 * 
 */
 function addTab(title,url){  
              
	 		var jq = top.jQuery;  
            if(jq("#tt").tabs("exists",title)){
            	jq("#tt").tabs("select",title);
    		}else{
    			jq("#tt").tabs("add",{
    				title:title,
    				content:'<iframe src="'+url+'" frameborder="0" width="100%" height="100%" />',
    				//href:默认是通过url加载body内容，不加载head
    				//href:href,
    				closable:true
    			});
    		}
              
        }
 
 function closeTab(title){
	 var jq = top.jQuery;  
	 jq("#tt").tabs("close",title);
 }