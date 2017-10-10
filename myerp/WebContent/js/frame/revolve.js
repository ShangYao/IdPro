jQuery.fn.rotate = function(angle,whence) { 
    var p = this.get(0); 
 
    // we store the angle inside the image tag for persistence  
    if (!whence) { 
        p.angle = ((p.angle==undefined?0:p.angle) + angle) % 360; 
    } else { 
        p.angle = angle; 
    } 
 
    if (p.angle >= 0) { 
        var rotation = Math.PI * p.angle / 180; 
    } else { 
        var rotation = Math.PI * (360+p.angle) / 180; 
    } 
    var costheta = Math.round(Math.cos(rotation) * 1000) / 1000; 
    var sintheta = Math.round(Math.sin(rotation) * 1000) / 1000; 
    //alert(costheta+","+sintheta);  
  
    if (document.all && !window.opera) { 
        var canvas = document.createElement('img'); 
 
        canvas.src = p.src; 
        canvas.height = p.height; 
        canvas.width = p.width; 
 
        canvas.style.filter = "progid:DXImageTransform.Microsoft.Matrix(M11="+costheta+",M12="+(-sintheta)+",M21="+sintheta+",M22="+costheta+",SizingMethod='auto expand')"; 
    } else { 
        var canvas = document.createElement('canvas'); 
        if (!p.oImage) { 
            canvas.oImage = new Image(); 
            canvas.oImage.src = p.src; 
        } else { 
            canvas.oImage = p.oImage; 
        } 
 
        canvas.style.width = canvas.width = Math.abs(costheta*canvas.oImage.width) + Math.abs(sintheta*canvas.oImage.height); 
        canvas.style.height = canvas.height = Math.abs(costheta*canvas.oImage.height) + Math.abs(sintheta*canvas.oImage.width); 
 
        var context = canvas.getContext('2d'); 
        context.save(); 
        if (rotation <= Math.PI/2) { 
            context.translate(sintheta*canvas.oImage.height,0); 
        } else if (rotation <= Math.PI) { 
            context.translate(canvas.width,-costheta*canvas.oImage.height); 
        } else if (rotation <= 1.5*Math.PI) { 
            context.translate(-costheta*canvas.oImage.width,canvas.height); 
        } else { 
            context.translate(0,-sintheta*canvas.oImage.width); 
        } 
        context.rotate(rotation); 
        context.drawImage(canvas.oImage, 0, 0, canvas.oImage.width, canvas.oImage.height); 
        context.restore(); 
    } 
    canvas.id = p.id; 
    canvas.angle = p.angle; 
    p.parentNode.replaceChild(canvas, p); 
} 
 
jQuery.fn.rotateRight = function(angle) { 
    this.rotate(angle==undefined?90:angle); 
} 
 
jQuery.fn.rotateLeft = function(angle) { 
    this.rotate(angle==undefined?-90:-angle); 
}


function imagePreview(id,lx) {
    xOffset = 10;
    yOffset = 30;
    currentliindex=id;   
    curUrl=$("#big"+lx+currentliindex).val();
    var tit=$("#tp"+id).val();
    maxliindex=$("#box_"+lx+" .tp").length;
	var h=document.body.offsetHeight-40;
        $("body").append("<div id='imgpreview' class='dragDiv2'><div class='handler2'><span id='tit'>"+tit+"</span>&nbsp;&nbsp;&nbsp;<input type='button' class='btnRelRight' title='顺时针旋转'  onclick='revolveRight()'/>&nbsp;<input type='button' class='btnRelLeft'  onclick='revolveLeft()' title='逆时针旋转' />&nbsp;&nbsp;&nbsp;<input type='button' class='btnFull'  onclick='full()' title='查看原图' />&nbsp;<input type='button' class='btnSmall'  onclick='Small()' title='还原' />&nbsp;<input type='button' class='btnPre'  onclick='proPic(\""+lx+"\")' title='上一页' />&nbsp;<input type='button' class='btnNext'  onclick='nextPic(\""+lx+"\")' title='下一页' />&nbsp;<input type='button' class='btnClose'  id='btn_close' title='关闭'  onclick='revolveClose()'/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div id='picBox' style='overflow:auto'><img id='rotate-image' src='" + curUrl + "'   onerror='this.src=\"images/picbig.jpg\"'/></div></div>");
        $("#imgpreview").css("top","0px").css("left","0px").fadeIn("fast");
        $("#picBox").css("height",h);      
        Small();
};
$(document).ready(function(){
	$('.boxgrid1.captionfull').each(function(){
		$(".cover", this).css({
			top:"160px"
		});
	});


	$('.boxgrid1.captionfull').hover(function(){
		$(".cover", this).stop().animate({top:'115px'},{queue:false,duration:160});
	}, function() {
		$(".cover", this).stop().animate({top:'160px'},{queue:false,duration:160});
	});

});
function revolveRight(){
	$("#rotate-image").rotateRight();
}
function full(){
	var theImage = new Image(); 
	theImage.src = $( '#rotate-image').attr( "src"); 
	$("#rotate-image").width(theImage.width);
	$("#rotate-image").height(theImage.height);
}
function Small(){
	var theImage = new Image(); 
	theImage.src = $( '#rotate-image').attr( "src"); 
	$("#rotate-image").width("800");
	var sh=theImage.height/theImage.width*800;

	$("#rotate-image").height(sh);
}

function revolveLeft(){
	$("#rotate-image").rotateLeft();
}
function revolveClose(){
	$("#imgpreview").remove();
}

function nextPic(lx){
	if(currentliindex<maxliindex-1){
		currentliindex++;
		curUrl=$("#big"+lx+currentliindex).val();
		$("#tit").html($("#tp"+currentliindex).val());
		$("#rotate-image").attr("src", curUrl);
	}
	else{
		alert("已经达到最后一张");
	}
};

function proPic(lx){
	if(currentliindex>0){
		currentliindex--;
		curUrl=$("#big"+lx+currentliindex).val();
		$("#tit").html($("#tp"+currentliindex).val());
		$("#rotate-image").attr("src", curUrl);
	}else{
		alert("已经达到第一张");
	}
};
 
