function showCheck(a){
	var c = document.getElementById("myCanvas");
  var ctx = c.getContext("2d");
	ctx.clearRect(0,0,1000,1000);
	ctx.font = "80px 'Microsoft Yahei'";
	ctx.fillText(a,0,100);
	ctx.fillStyle = "black";
}
var code ;    
function createCode(){       
    code = "";      
    var codeLength = 4;
    var selectChar = new Array(1,2,3,4,5,6,7,8,9,'a','b','c','d','e','f','g','h','j','k','l','m','n','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');      
    for(var i=0;i<codeLength;i++) {
       var charIndex = Math.floor(Math.random()*60);      
      code +=selectChar[charIndex];
    }      
    if(code.length != codeLength){      
      createCode();      
    }
    showCheck(code);
}
          
function validate () {
    var inputCode = document.getElementById("J_codetext").value.toUpperCase();
    var codeToUp=code.toUpperCase();
    if(inputCode.length <=0) {
      document.getElementById("J_codetext").setAttribute("placeholder","输入验证码");
      createCode();
      //alert("输入验证码");
      layer.msg("输入验证码", {icon: 2,time: 1000});
      return "/back/login";
    }
    else if(inputCode != codeToUp ){
      document.getElementById("J_codetext").value="";
      document.getElementById("J_codetext").setAttribute("placeholder","验证码错误");
      createCode();
      //alert("验证码错误");
      layer.msg("验证码错误", {icon: 2,time: 1000});
      return false;
    }
    else {
//      window.open(document.getElementById("J_down").getAttribute("data-link"));
      document.getElementById("J_codetext").value="";
      createCode();
      document.getElementById("subform").submit();
      return true;
    }

    
}