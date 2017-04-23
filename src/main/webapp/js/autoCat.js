jQuery(document).ready(function(){
		var location = (window.location+'').split('/');
		var path= location[0]+'//'+location[2]+'/'+location[3];
		var url=path+"/category/getAll.html";
		jQuery.post(url,function(data){
			var res="";
			for(var i in data){
				var c=data[i];
				 if(c.pId==0){
					 res+="<li>"
						+"<div class=\"fj\">"
						+"<span class=\"n_img\"><span></span><img src=\"images/nav"+(parseInt(i)+1)+".png\" />"
						+"</span> <span class=\"fl\">"+c.name+"</span>"	
						+"</div>"
						+"<div class=\"zj\" style=\"top: -"+i*40+"px;\">"
						+"<div class=\"zj_l\">";
						for(var k in data){
							c1=data[k];
							if(c1.pId!=0){
								if(c1.pId==c.id){
									res+="<div class=\"zj_l_c\">"		
									   +"<h2>"+c1.name+"</h2>";
									for(var j in data){
										c2=data[j];
										if(c2.pId!=0){
											if(c2.pId==c1.id){
												res+="<a href=\"www\" onclick=\"searchBycat('"+c2.name+"');return false\">"+c2.name+"</a>|";
										
											}
											
										}									
									}
									res+="</div>"; 
								}
							}
						}									
					 res+="</div>"	
						+"<div class=\"zj_r\">"	
						+"<a href=\"#\"><img src=\"images/n_img1.jpg\" width=\"236\""		
						+"height=\"200\" /></a> <a href=\"#\"><img src=\"images/n_img2.jpg\""			
						+"width=\"236\" height=\"200\" /></a>"			
						+"</div>"	
						+"</div>"
						+"</li>";
				}
			}
			jQuery(res).appendTo(jQuery("#allcat"));  
			jQuery(".leftNav ul li").hover(
					function(){
						jq(this).find(".fj").addClass("nuw");
						jq(this).find(".zj").show();
					}
					,
					function(){
						jq(this).find(".fj").removeClass("nuw");
						jq(this).find(".zj").hide();
					}
			) 
		},"json")
	});
function searchBycat(CatName){
	var catUrl="http://localhost:8080/AmbowTwo/search.html?q="+encodeURI(encodeURI(CatName));
	return window.open(catUrl);
}