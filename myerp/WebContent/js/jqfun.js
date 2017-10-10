// jqfun.js
$(function(){
	autoReset();
	 $('table.tableStyle tr').click(function(){
		  $(this).addClass('selected').siblings('tr').removeClass('selected');
		 });
  $("table.tableStyle").find("tr:even").addClass("odd");

  $('table.option tr').live('click', function() {
	  //$(this).toggleClass('selected');
	  if($(this).find(':checkbox').size()>0){
	  var checkbox = $(this).find(':checkbox')[0];
	  checkbox.checked = !checkbox.checked;
	  }
	  });
  $('table.option tr :checkbox').click(function(event){
      event.stopPropagation();
})
  //如果是必填的，则加红星标识.
		$("form :input.required").each(function(){
			var $required = $("<strong class='high'> *</strong>"); //创建元素
			$(this).parent().append($required); //然后将它追加到文档中
		});
	$("form :input.readonlyBlur").click(function(){
		$(this).blur();
		});

//按钮样式切换 
$(".button2").hover( 
	function () { 
	$(this).removeClass("button2").addClass("button1"); 
	}, 
	function () { 
	$(this).removeClass("button1").addClass("button2"); 
	} 
);
});
$(function(){var a;$("input:text[class=''],input:password[class=''],input:text[class*=validate],input:password[class*=validate]").each(function(){$(this).addClass("textinput");$(this).hover(function(){if(a!=$(this)[0]){$(this).removeClass("textinput");$(this).addClass("textinput_hover")}},function(){if(a!=$(this)[0]){$(this).removeClass("textinput_hover");$(this).addClass("textinput")}});$(this).focus(function(){a=$(this)[0];$(this).removeClass("textinput");$(this).removeClass("textinput_hover");$(this).addClass("textinput_click")});$(this).blur(function(){a=null;$(this).removeClass("textinput_click");$(this).addClass("textinput")});if($(this).attr("clearable")=="true"){$(this).clearableTextField()}if($(this).attr("maxNum")!=null){$(this).maxlength()}if($(this).attr("checkStrength")=="true"){$(this).password_strength()}if($(this).attr("watermark")!=null){$(this).watermark("watermark",$(this).attr("watermark"))}})});

(function($){$.fn.bgIframe=$.fn.bgiframe=function(s){if($.browser.msie&&/6.0/.test(navigator.userAgent)){s=$.extend({top:'auto',left:'auto',width:'auto',height:'auto',opacity:true,src:'javascript:false;'},s||{});var prop=function(n){return n&&n.constructor==Number?n+'px':n;},html='<iframe class="bgiframe"frameborder="0"tabindex="-1"src="'+s.src+'"'+'style="display:block;position:absolute;z-index:-1;'+(s.opacity!==false?'filter:Alpha(Opacity=\'0\');':'')+'top:'+(s.top=='auto'?'expression(((parseInt(this.parentNode.currentStyle.borderTopWidth)||0)*-1)+\'px\')':prop(s.top))+';'+'left:'+(s.left=='auto'?'expression(((parseInt(this.parentNode.currentStyle.borderLeftWidth)||0)*-1)+\'px\')':prop(s.left))+';'+'width:'+(s.width=='auto'?'expression(this.parentNode.offsetWidth+\'px\')':prop(s.width))+';'+'height:'+(s.height=='auto'?'expression(this.parentNode.offsetHeight+\'px\')':prop(s.height))+';'+'"/>';return this.each(function(){if($('> iframe.bgiframe',this).length==0)this.insertBefore(document.createElement(html),this.firstChild);});}return this;};})(jQuery);
$(function(){var a;$("input:text[class=''],input:password[class=''],input:text[class*=validate],input:password[class*=validate]").each(function(){$(this).addClass("textinput");$(this).hover(function(){if(a!=$(this)[0]){$(this).removeClass("textinput");$(this).addClass("textinput_hover")}},function(){if(a!=$(this)[0]){$(this).removeClass("textinput_hover");$(this).addClass("textinput")}});$(this).focus(function(){a=$(this)[0];$(this).removeClass("textinput");$(this).removeClass("textinput_hover");$(this).addClass("textinput_click")});$(this).blur(function(){a=null;$(this).removeClass("textinput_click");$(this).addClass("textinput")});if($(this).attr("clearable")=="true"){$(this).clearableTextField()}if($(this).attr("maxNum")!=null){$(this).maxlength()}if($(this).attr("checkStrength")=="true"){$(this).password_strength()}if($(this).attr("watermark")!=null){$(this).watermark("watermark",$(this).attr("watermark"))}})});

(function($){$.alerts={verticalOffset:-75,horizontalOffset:0,repositionOnResize:true,overlayOpacity:.5,overlayColor:'#babdc1',draggable:true,okButton:'&nbsp;确定&nbsp;',cancelButton:'&nbsp;取消&nbsp;',dialogClass:null,alert:function(message,title,callback){if(title==null)title='Alert';$.alerts._show(title,message,null,'alert',function(result){if(callback)callback(result);});},confirm:function(message,title,callback){if(title==null)title='Confirm';$.alerts._show(title,message,null,'confirm',function(result){if(callback)callback(result);});},prompt:function(message,value,title,callback){if(title==null)title='Prompt';$.alerts._show(title,message,value,'prompt',function(result){if(callback)callback(result);});},_show:function(title,msg,value,type,callback){$.alerts._hide();$.alerts._overlay('show');$("BODY").append('<div id="popup_container">'+'<h1 id="popup_title"></h1>'+'<div id="popup_content">'+'<div id="popup_message"></div>'+'</div>'+'</div>');$('#popup_container').bgiframe();if($.alerts.dialogClass)$("#popup_container").addClass($.alerts.dialogClass);var pos=($.browser.msie&&parseInt($.browser.version)<=6)?'absolute':'fixed';$("#popup_container").css({position:pos,zIndex:99999,padding:0,margin:0});$("#popup_title").text(title);$("#popup_content").addClass(type);$("#popup_message").text(msg);$("#popup_message").html($("#popup_message").text().replace(/\n/g,'<br />'));$("#popup_container").css({minWidth:$("#popup_container").outerWidth(),maxWidth:$("#popup_container").outerWidth()});$.alerts._reposition();$.alerts._maintainPosition(true);switch(type){case'alert':$("#popup_message").after('<div id="popup_panel"><input type="button" value="'+$.alerts.okButton+'" id="popup_ok" /></div>');$("#popup_panel").width( $("#popup_container").width() );$("#popup_ok").click(function(){$.alerts._hide();callback(true);});$("#popup_ok").focus().keypress(function(e){if(e.keyCode==13||e.keyCode==27)$("#popup_ok").trigger('click');});break;case'confirm':$("#popup_message").after('<div id="popup_panel"><input type="button" value="'+$.alerts.okButton+'" id="popup_ok" /> <input type="button" value="'+$.alerts.cancelButton+'" id="popup_cancel" /></div>');$("#popup_panel").width( $("#popup_container").width() );$("#popup_ok").click(function(){$.alerts._hide();if(callback)callback(true);});$("#popup_cancel").click(function(){$.alerts._hide();if(callback)callback(false);});$("#popup_ok").focus();$("#popup_ok, #popup_cancel").keypress(function(e){if(e.keyCode==13)$("#popup_ok").trigger('click');if(e.keyCode==27)$("#popup_cancel").trigger('click');});break;case'prompt':$("#popup_message").append('<br /><input type="text" size="30" id="popup_prompt" />').after('<div id="popup_panel"><input type="button" value="'+$.alerts.okButton+'" id="popup_ok" /> <input type="button" value="'+$.alerts.cancelButton+'" id="popup_cancel" /></div>');$("#popup_prompt").width($("#popup_message").width());$("#popup_ok").click(function(){var val=$("#popup_prompt").val();$.alerts._hide();if(callback)callback(val);});$("#popup_cancel").click(function(){$.alerts._hide();if(callback)callback(null);});$("#popup_prompt, #popup_ok, #popup_cancel").keypress(function(e){if(e.keyCode==13)$("#popup_ok").trigger('click');if(e.keyCode==27)$("#popup_cancel").trigger('click');});if(value)$("#popup_prompt").val(value);$("#popup_prompt").focus().select();break;}
if($.alerts.draggable){try{$("#popup_container").draggable({handle:$("#popup_title")});$("#popup_title").css({cursor:'move'});}catch(e){}}},_hide:function(){$("#popup_container").remove();$.alerts._overlay('hide');$.alerts._maintainPosition(false);},_overlay:function(status){switch(status){case'show':$.alerts._overlay('hide');$("BODY").append('<div id="popup_overlay"></div>');$("#popup_overlay").css({position:'absolute',zIndex:99998,top:'0px',left:'0px',width:'100%',height:$(document).height(),background:$.alerts.overlayColor,opacity:$.alerts.overlayOpacity});break;case'hide':$("#popup_overlay").remove();break;}},_reposition:function(){var top=(($(window).height()/2)-($("#popup_container").outerHeight()/2))+$.alerts.verticalOffset;var left=(($(window).width()/2)-($("#popup_container").outerWidth()/2))+$.alerts.horizontalOffset;if(top<0)top=0;if(left<0)left=0;if($.browser.msie&&parseInt($.browser.version)<=6)top=top+$(window).scrollTop();$("#popup_container").css({top:top+'px',left:left+'px'});$("#popup_overlay").height($(document).height());},_maintainPosition:function(status){if($.alerts.repositionOnResize){switch(status){case true:$(window).bind('resize',$.alerts._reposition);break;case false:$(window).unbind('resize',$.alerts._reposition);break;}}}}
jAlert=function(message,title,callback){$.alerts.alert(message,title,callback);}
jConfirm=function(message,title,callback){$.alerts.confirm(message,title,callback);};jPrompt=function(message,value,title,callback){$.alerts.prompt(message,value,title,callback);};})(jQuery);
function autoReset() {
	var a = document.body.clientHeight;
	var b,c,d,e;
	if($(".pageHeader").length>0){b=parseInt($(".pageHeader").height());d=parseInt($(".pageHeader").css("margin-top"));}else{b=0;d=0;} 
	if($(".panelBar").length>0){c=parseInt($(".panelBar").outerHeight());}else{c=0;} 
	if($(".pageContent").length>0){e=parseInt($(".pageContent").css("margin-top"));}else{e=0;} 

	var h = a - b - c-d-e-3
        $(".pageContent").height(h);
}







function yzsfzmhm(sfzmhm){
     if(sfzmhm==""){ 
     $.messager.alert("信息提示", "身份证号码不能为空！","info");
        return	false;
     }
	if(sfzmhm.length!=15 && sfzmhm.length!=18){  
		$.messager.alert("信息提示", "身份证号码位数不正确！","info");
        return	false;
    }
    if(sfzmhm.substring(0,1)=="-"){  
    	$.messager.alert("信息提示", "错误的身份证号!","info");
        return false;
    }
    if(isNaN(sfzmhm.substring(0,17))){  
    	$.messager.alert("信息提示", "错误的身份证号!","info");
       return false;
    }else{ 
    	if(isNaN(sfzmhm.substring(17,18))){ 
    		if(sfzmhm.substring(17,18)!="X"){ 
    			alert("错误的身份证号!");
    			$.messager.alert("信息提示", "错误的身份证号!","info");
             return false;
             }
        }
    }
    if(checksfzh(sfzmhm)==false){  
    		$.messager.alert("信息提示", "错误的身份证号!","info");
        return false;
    }
    return true;
}






function checksfzh(sfzmhm){
    var checkTable=new Array("1","0","X","9","8","7","6","5","4","3","2","1");
    var intPID=new Array(sfzmhm.length);
    for(i=0;i<sfzmhm.length;i++){
		if( sfzmhm.substring(i,i+1)=="X"||sfzmhm.substring(i,i+1)=="x")
			intPID[i]=10;
		else
			intPID[i]=parseInt(sfzmhm.substring(i,i+1),10);
	}
	var intPID2=new Array(sfzmhm.length);
	intPid=intPID.reverse();
	var pow=1;
	var w = new Array(18);
	for (i = 0; i < w.length; i++) {
		w[i] = pow % 11;
		pow *= 2;
    }
    var checkBitIndex = 0;
	for (i = 1; i < w.length; i++) {
		checkBitIndex += w[i] * intPid[i];
	}
	checkBitIndex%= 11;
    var checkBit = checkTable[checkBitIndex];
    return checkBit==sfzmhm.substring(17); 
}
function id15to18(zjhm){                            
      var strjiaoyan=new Array("1","0","X","9","8","7","6","5","4","3","2"); 
      var intquan=new Array(7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2,1);          
      var ssum=0;                                                            
      var i;                                                                 
      var ls_check;                                                          
      zjhm=zjhm.substring(0,6) + "19" + zjhm.substring(6);                                                                           
      for (i=0;i<=16;i++){                                                   
          ssum=ssum + zjhm.substring(i,i+1)*intquan[i];                         
      }                                                                      
      ssum=ssum%11;                                                           
      zjhm=zjhm+strjiaoyan[ssum];                                             
      return zjhm;                                                            
 }
function getTabWindow() {
	  var curTabWin = null;
	  var curTab = parent.$('#tabs').tabs('getSelected');
	  if (curTab && curTab.find('iframe').length > 0) {
	    curTabWin = curTab.find('iframe')[0].contentWindow;
	  }
	  return curTabWin;
	}