var countdown=60; 
var yzm="1";
var timer;
var timer2;
function check(val){
	var sfzmhm = $("#username").val();
	if(!yzsfzmhm(sfzmhm)){
//		alert("请输入正确的身份证明号码！");
		return;
	}
	$.ajax({
        url:"login.do?ywtype=bacheck",
        type:"GET",
//        async:false,
        data:{"sfzmhm":sfzmhm},
        dataType:"text",
        success: function(data) {
        		//setTimeout(function() { yzm="";},50000) ;
        	if(data=="01"){
        		alert("系统故障！");
        	}else if(data=="00"){
        		alert("查无此人，请备案！");
        	}else if(data=="11"){
        		alert("验证码已发送，请注意查收！");
        	}else if(data=="12"){
        		alert("验证码发送失败！");
        	}else if(data=="051"){
        		alert("验证码仍然有效，请不要重复发送验证码！");
        	}
        }
    });
	timer = setInterval(function() { 
		settime(val);
	},1000) ;
}
function settime(val) { 
	if (countdown == 0) { 
		val.removeAttribute("disabled");    
		val.value="获取验证码"; 
		countdown = 60;
		clearInterval(timer);
	} else { 
		val.setAttribute("disabled", true); 
		val.value="重新发送(" + countdown + ")"; 
		countdown--; 
	} 
};
function dl(){
		if(!yzsfzmhm($("#username").val())){
//			alert("请输入正确的身份证明号码！");
			$("#username").focus();
			return;
	    }
	    if($("#ident-code").val()==""||$("#ident-code").val()==null){
			alert("验证码不能为空!");
			$("#ident-code").focus();
			return;
	    }

	myform.action = "login.do?ywtype=dl";  
	myform.submit();
};

//兼容ie8 placeholder属性
$(function(){  
	  //判断浏览器是否支持placeholder属性
	  supportPlaceholder='placeholder'in document.createElement('input'),
	 
	  placeholder=function(input){
	 
	    var text = input.attr('placeholder'),
	    defaultValue = input.defaultValue;
	 
	    if(!defaultValue){
	 
	      input.val(text).addClass("phcolor");
	    }
	 
	    input.keydown(function(){
	 
	      if(input.val() == text){
	   
	        $(this).val("");
	      }
	    });
	 
	  
	    input.blur(function(){
	 
	      if(input.val() == ""){
	       
	        $(this).val(text).addClass("phcolor");
	      }
	    });
	 
	    //输入的字符不为灰色
	    input.keydown(function(){
	  
	      $(this).removeClass("phcolor");
	    });
	  };
	 
	  //当浏览器不支持placeholder属性时，调用placeholder函数
	  if(!supportPlaceholder){
	    $('input').each(function(){
	 
	      text = $(this).attr("placeholder");
	 
	      if($(this).attr("type") == "text"){
	 
	        placeholder($(this));
	      }
	    });
	  }
	 
	});




//判断ie版本 
$(function() {
var userAgent = window.navigator.userAgent.toLowerCase();

$.browser.msie10 = $.browser.msie && /msie 10\.0/i.test(userAgent);
$.browser.msie9 = $.browser.msie && /msie 9\.0/i.test(userAgent); 
$.browser.msie8 = $.browser.msie && /msie 8\.0/i.test(userAgent);
$.browser.msie7 = $.browser.msie && /msie 7\.0/i.test(userAgent);
$.browser.msie6 = !$.browser.msie8 && !$.browser.msie7 && $.browser.msie && /msie 6\.0/i.test(userAgent);
	if($.browser.msie7){
		$("form").addClass("form-ie7")
	}
	if($.browser.msie6){
		$("form").addClass("form-ie7")
	}
});







