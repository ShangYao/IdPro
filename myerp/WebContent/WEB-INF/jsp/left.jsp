<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="left" uri="http://sdga.musicvv.com/tags/left"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--框架必需start-->
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/frame/framework.js"></script>
<link href="css/leftframe.css" rel="stylesheet" type="text/css"/>
<!--
<style>
a {
	behavior:url("js/frame/focus.htc")
}
img {
	behavior:url("js/frame/pngbehavior.htc");
}
</style>
-->
<!--框架必需end-->
<style>

.categoryitems span{
	width:160px;
}
</style>
<script>
	$(function(){
		$(".menu ul").hide();
		$(".certain a").click(function(){
			var id = $(this).prop("id");
			$("."+id).toggle();
		});
	})
</script>
</head>
<body leftFrame="true">
<div id="scrollContent">
	<div style="padding:5px;">
	<!--生成菜单类-->
	<left:left leftqxcode="${sessionScope.loginForm.leftqxcode}" leftqxdes="${sessionScope.loginForm.leftqxdes}" leftMcode="${sessionScope.loginForm.qxcode}" leftMdes="${sessionScope.loginForm.qxdes}" dis="dispatch"/>
	</div>
</div>				
</body>

</html>