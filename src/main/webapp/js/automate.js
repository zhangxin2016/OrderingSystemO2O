jQuery(document).ready(function(){
		var location = (window.location+'').split('/');
		var path= location[0]+'//'+location[2]+'/'+location[3];
		var nameword=new Array();
		var url=path+"/automate.html";
		jQuery.post(url,function(data){
			var names=eval(data);  
			 for(var a in names){
				var list=names[a];
				nameword[a]=list;
			 } 
			 jQuery("#key").autocomplete({
			      source: nameword
			   });  
		});
	})