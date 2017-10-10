<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:useBean id="user" scope="request"
	class="com.sy.domain.Users" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<title>身份证管理系统 </title>
<link href="css/login.css" rel="stylesheet" type="text/css" id="skin"/>
		<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){
$("#yhdh").focus();
var yhdh=getCookie('yhdh');
	if(yhdh !=""){
		$("#yhdh").attr("value",yhdh);
	}
})


function getCookie(objName){//获取指定名称的cookie的值  
    var arrStr = document.cookie.split("; ");  
    for(var i = 0;i < arrStr.length;i ++){  
      var temp = arrStr[i].split("=");  
      if(temp[0] == objName) return unescape(temp[1]);  
  
  }   
} 


function dl(){    
          if($("#yhdh").val()==""){
      		alert("用户代号不能为空!");
      		$("#yhdh").focus();
      		return;
      }
                 if($("#mm").val()==""){
      		alert("密码不能为空!");
      		$("#mm").focus();
      		return;
      }

 myform.action = "login.do?ywtype=dl";  
  myform.submit();    
}    


</script>
</head>

<body>
<%
	  String ip = (request.getRemoteAddr()).equals("0:0:0:0:0:0:0:1")? "127.0.0.1" :  (request.getRemoteAddr()); 
%>
	<div class="login_main">
		<div class="login_top">
			<div class="login_title"></div>
		</div>
		<div class="login_middle">
			<div class="login_middleleft"></div>
			<div class="login_middlecenter">
				<form:form commandName="loginForm" action="login.do" method="post" cssClass="login_form" id="myform">
					<div class="login_user"><form:input path="user.user_code" id="yhdh"   /></div>
					<div class="login_pass"><form:password path="user.pwd" id="mm"   onkeydown="if(event.keyCode==13){dl()}"  /></div>
					<div class="clear"></div>
					<div class="login_button">
						<div class="login_button_left"><input type="button"  onclick="dl()"/>
						<p>${loginForm.ywstate}</p>
						</div>
						<div class="clear"></div>
					</div>
					
					<input type="hidden" name="ywstate" id="ywstate"	value="${loginForm.ywstate}" />
					<input type="hidden" name="ip" id="ip"	value="<%=ip %>" />
					</form:form>
			</div>
			<div class="login_middleright"></div>
			<div class="clear"></div>
		</div>
		<div class="login_bottom">
			<div class="login_copyright">版权所有：sy<span>技术支持：sy</span></div>
		</div>
	</div>

</body>
</html>
