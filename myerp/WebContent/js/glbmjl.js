
function changeGlbm(id){
	$("#glbm").html("");
	$("#glbm").html("<option value=''>全部</option>");
	var xjglbm="";
	var mbms="";
	if(id=="bmjb"){
		xjglbm="glbm";
		mbms="GLBM";
	} else{
		return false;
	}

	var xzqh=$("#"+id+" option:selected").val();
	$.ajax({
		type:"post",
		url:"department.do",
		dataType:"json",
        data:"bmjb="+xzqh+"&glbmType="+mbms+"&ywtype=getGlbmAjax",

        success:function(data){
             $("#"+xjglbm).html("");
              $("#"+xjglbm).append("<option value=''>全部</option>");
             $.each(data,function(i,item){
                 $("#"+xjglbm).append("<option value="+item.code+">"+item.description+"</option>");
             });
          }
      });


}

function changexzqh(id){
	$("#glbm").html("");
	$("#glbm").html("<option value=''>全部</option>");
	var xjglbm="";
	var mbms="";
	if(id=="xzqh"){
		xjglbm="glbm";
		mbms="GLBM";
	} else{
		return false;
	}

	var xzqh=$("#"+id+" option:selected").val();
	$.ajax({
		type:"post",
		url:"department.do",
		dataType:"json",
        data:"xzqh="+xzqh+"&glbmType="+mbms+"&ywtype=getXzqhglbmAjax",

        success:function(data){
             $("#"+xjglbm).html("");
              $("#"+xjglbm).append("<option value=''>全部</option>");
             $.each(data,function(i,item){
                 $("#"+xjglbm).append("<option value="+item.code+">"+item.description+"</option>");
             });
          }
      });


}





	
	