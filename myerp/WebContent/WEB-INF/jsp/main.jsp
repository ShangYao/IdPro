<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="left" uri="http://sdga.musicvv.com/tags/left"%>
<%@ taglib prefix="main" uri="http://sdga.musicvv.com/tags/main"%>
<%@ taglib prefix="getstr" uri="http://sdga.musicvv.com/tags/getstr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>erp </title>
    <link href="css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="js/themes/icon.css" />
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/frame/dialog.js"></script>
	<link href="css/mainframe.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="js/index.js"></script>
<!--[if IE 6]>	
<script type="text/javascript" src="js/frame/png.js"></script>
<![endif]-->
    <script type="text/javascript">
    
 var _menus = ${sessionScope.loginForm.qxjson};
        //关闭登录窗口
        function closePwd() {
            $('#w').window('close');
        }
		function xgmm(){
			/* alert(1111111111); */
			Dialog.open({URL:"user.do?ywtype=loadxgmm",Title:"修改密码",Width:500,Height:250});
		
		}
		
    </script>
     <script type="text/javascript">
		function showHome(){
			addHome("主页", "dispatch.do?ywtype=nav", "icon-home");
			}
</script>
    
</head>
<body class="easyui-layout" style="overflow-y: hidden"  fit="true"   scroll="no">
<noscript>
<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
    <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
</div></noscript>

<div id="loading-mask" style="position:absolute;top:0px; left:0px; width:100%; height:100%; background:#D2E0F2; z-index:20000">
<div id="pageloading" style="position:absolute; top:50%; left:50%; margin:-120px 0px 0px -120px; text-align:center;  border:2px solid #8DB2E3; width:200px; height:40px;  font-size:14px;padding:10px; font-weight:bold; background:#fff; color:#15428B;"> 
    <img src="images/loading.gif" align="absmiddle" /> 正在加载中,请稍候...</div>
</div>

    <div region="north" split="true" border="false" style="height:66px; padding: 0px;width:100%">
         <div  class="bs_bannercenter">
            <div class="bs_banner_title"></div>
                <div style="font-weight: bold; width: auto; position: absolute; top: 15px; right: 10px">
                    <ul class="nav">
                            <li><%-- <img src="images/yhjb${sessionScope.loginForm.user.yhjb}.png" align="absmiddle" / --%>${sessionScope.loginForm.user.name}</li>
                            <li><a href="javascript:showHome();" id="editpass"><img src="images/home.png" align="absmiddle" />主页</a></li>
                            <li><a href="javascript:xgmm();" id="editpass"><img src="images/key.png" align="absmiddle" />修改密码</a></li>
                            <!--<li><a href="" id="help" target="_blank"><img src="images/help.png" align="absmiddle" />操作手册</a></li>-->
                            <li><a href="index.html" id="loginOut"><img src="images/exit.png" align="absmiddle" />重新登录</a></li>
                        </ul>
                </div>
        </div>

    </div>
    <div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
        <div class="footer">版权所有：我要无敌&nbsp;&nbsp; 技术支持：sy&nbsp;&nbsp; 版本:V1.0</div>
    </div>
    <div region="west" split="true"  title="导航菜单" style="width:180px;" id="west">
			<div id="nav">
		<!--  导航内容 -->
				
			</div>

    </div>
    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<div title="主页" style="padding:5px;overflow:hidden;" id="home">
				
			<iframe id="myfrmright" name="frmright" width="100%" height="100%" class="share_self"  frameborder="0" scrolling="no" src="dispatch.do?ywtype=nav"></iframe>

			</div>
		</div>
    </div>
    
    


	<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="close">关闭</div>
		<div id="closeall">全部关闭</div>
		<div id="closeother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="closeright">当前页右侧全部关闭</div>
		<div id="closeleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="exit">退出</div>
	</div>












	<input type="hidden" id="yhdh" value="${sessionScope.loginForm.user.user_code }" />
    <input type="hidden" id="qxjson" value='${sessionScope.loginForm.qxjson }'/>
</body>
</html>