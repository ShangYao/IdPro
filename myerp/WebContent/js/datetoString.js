function toString(dateTime){
//	alert(dateTime);
	if(dateTime.indexOf("CST")>-1){
		var date = new Date(dateTime);
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		var day = date.getDate();
		return year+"-"+getMonth(month)+"-"+getDay(day);
	}else{
		var arr = dateTime.split(" ");
		return arr[0];
	}
}
function getMonth(arg){
	if(arg<10){
		arg = "0"+arg;
	}
	return arg;
}
function getDay(arg){
	if(arg<10){
		arg = "0"+arg;
	}
	return arg;
}
$(function(){
	$(".Wdate").each(function(){
  		if($(this).val()!=null&&$(this).val()!=""){
  			$(this).val(toString($(this).val()));
  		}
  	});
})