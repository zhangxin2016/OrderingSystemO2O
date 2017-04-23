	$(function () {
		//用户名验证（非空、长度、重名）
		$("#name").blur(function(){
			if($("#name").val()==null || $("#name").val()==""){
				$("#nameCheck").html("<font color='red'>用户名不能为空！</font>");
			}else if($("#name").val().length<1 || $("#name").val().length>16){
				$("#nameCheck").html("<font color='red'>用户名介于1~16位！</font>");
			}else{
			$.ajax({
				url:"CheckRegister.html",
				type:"post",
				dataType:"json",
				data:{
					name:$("#name").val()
				},
				success:function(data){
					if(data.result == 1){
						$("#nameCheck").html("");
					}else if(data.result == 0){
						$("#nameCheck").html("<font color='red'>抱歉！用户</font>"+$("#name").val()+"<font color='red'>已存在！</font>");
					}
				},
				error:function(){
					layer.msg('系统错误', {icon: 2,time: 1000});
				}
			});
			$("#nameCheck").html("");
			}
		});
		//密码验证（非空、长度）
		$("#pass").blur(function(){
			if($("#pass").val()==null || $("#pass").val()==""){
				$("#passCheck").html("<font color='red'>密码不能为空！</font>");
			}else if($("#pass").val().length<8 || $("#pass").val().length>16){
				$("#passCheck").html("<font color='red'>密码介于8~16位！</font>");
			}else{
				$("#passCheck").html("");
			}
		});
		//确认密码验证（非空、长度、是否与密码一致）
		$("#repass").blur(function(){
			if($("#repass").val()==null || $("#repass").val()==""){
				$("#repassCheck").html("<font color='red'>确认密码不能为空！</font>");
			}else if($("#repass").val().length<1 || $("#repass").val().length>16){
				$("#repassCheck").html("<font color='red'>确认密码介于1~16位！</font>");
			}else if($("#pass").val()!=$("#repass").val()){
				$("#repassCheck").html("<font color='red'>确认密码与密码不一致！</font>");
			}else{
				$("#repassCheck").html("");
			}
		});
		//手机号码验证
		$("#phone").blur(function(){
			if($("#phone").val()==null || $("#phone").val()==""){
				$("#phoneCheck").html("<font color='red'>手机号码不能为空！</font>");
			}else if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test($("#phone").val()))){
				$("#phoneCheck").html("<font color='red'>请输入规范的手机号码！</font>");
			}else{
				$("#phoneCheck").html("");
			}
		});
		//邮箱验证
		$("#email").blur(function(){
			if($("#email").val()==null || $("#email").val()==""){
				$("#emailCheck").html("");
			}else if(!(/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test($("#email").val()))){
				$("#emailCheck").html("<font color='red'>请输入正确的邮箱！</font>");
			}else{
				$("#emailCheck").html("");
			}
		});
		
		var code2 = null;
		//手机验证码
		$("#btn").mousedown(function(){
			$.ajax({
				url:"SendMessage.html",
				type:"post",
				dataType:"json",
				data:{
					phone:$("#phone").val()
				},
				success:function(data){
				
					if(data.code==2){
						layer.msg('短信已发送，请注意查收', {icon: 1,time: 1000});
						code2 = data.phoneCode;
						$("#codeCheck").html("");
					}else{
						layer.msg('短信发送失败，请60秒后重试', {icon: 2,time: 1000});
					}
				},
				/*error:function(){
					layer.msg('系统错误', {icon: 2,time: 1000});
				}*/
			});
		});
		
		//验证码验证
		$("#code").blur(function(){
		if($("#code").val()==null || $("#code").val()==""){
			$("#codeCheck").html("<font color='red'>请输入验证码！</font>");
		}else if(code2 != $("#code").val()){
				$("#codeCheck").html("<font color='red'>验证码不正确，请60秒后重试！</font>");
		}else if(code2 == $("#code").val()){
			$("#codeCheck").html("");
		}
			
		
		});
		
    	//提交表单进行注册
    	$("#sub").click(function(){
    		if($("#nameChack").html()!=null || $("#name").val()==""){
    			layer.msg('用户名不规范', {icon: 2,time: 1000});
    			return;
    		}else if($("#passChack").html()!=null || $("#pass").val()==""){
    			layer.msg('密码不规范', {icon: 2,time: 1000});
    			return;
    		}else if($("#repassChack").html()!=null || $("#repass").val()==""){
    			layer.msg('确认密码不规范', {icon: 2,time: 1000});
    			return;
    		}else if($("#emailChack").html()!=null){
    			layer.msg('邮箱不规范', {icon: 2,time: 1000});
    			return;
    		}else if($("#phone").val()==""){
    			layer.msg('手机号码不规范', {icon: 2,time: 1000});
    			return;
    		}else if($("#code").val()=="" || $("#code").val()==null){
    			layer.msg('请输入验证码', {icon: 2,time: 1000});
    			return;
    		}else if(code2 != $("#code").val()){
    			layer.msg('验证码不正确，请60秒后重试', {icon: 2,time: 1000});
    			return;
    		}else{
    			document.getElementById("registerForm").submit();
    		}
    		
    	});
    	
    	
    	//手机号码中间隐藏
    	$("#phone1").focusout(function () {            
            $("#phone1").val($("#phone1").val().substring(0, 3) + "****" + $("#phone1").val().substring(7, 11));
        }); 
    	
    });
    
    //验证码倒计时
	var countdown=60; 
	function settime(obj) { 
	    if (countdown == 0) { 
	        obj.removeAttribute("disabled");    
	        obj.value="免费获取验证码"; 
	        countdown = 60; 
	        return;
	    } else { 
	        obj.setAttribute("disabled", true); 
	        obj.value="重新发送(" + countdown + ")"; 
	        countdown--; 
	    } 
	setTimeout(function() { 
	    settime(obj);
	    },1000);
	}    
    
