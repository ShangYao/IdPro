$(function(){
$("#sfzmhm").focus();
var sfzmhm=getCookie('sfzmhm');
	if(sfzmhm !=""){
		$("#sfzmhm").attr("value",sfzmhm);
	}
});


function getCookie(objName){//获取指定名称的cookie的值  
    var arrStr = document.cookie.split("; ");  
    for(var i = 0;i < arrStr.length;i ++){  
      var temp = arrStr[i].split("=");  
      if(temp[0] == objName) return unescape(temp[1]);  
  
  }   
} 


function dl(){    
          if($("#sfzmhm").val()==""){
      		alert("身份证明号码不能为空!");
      		$("#sfzmhm").focus();
      		return;
          }
          if($("#yzm").val()==""){
      		alert("验证码不能为空!");
      		$("#yzm").focus();
      		return;
          }

  myform.action = "pa.do?ywtype=login";  
  myform.submit();
}    