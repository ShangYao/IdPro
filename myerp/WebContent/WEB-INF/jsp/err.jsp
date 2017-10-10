<%@ page language="java" contentType="text/html; charset=GBK"       pageEncoding="GBK"%>   <%@ page import="java.lang.Exception"%>  
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
 <html>   
 <head>  
  <meta name="viewport" content="width=320px, user-scalable=yes, initial-scale=1, maximum-scale=1"> 
 <meta http-equiv="Content-Type" content="text/html; charset=GBK">   
<title>错误页面</title>
<%@ include  file="inc.jsp" %>
<style>
.errTit{height:70px;background:#fff url(images/err.jpg) no-repeat;font-size:20px;font-weight:bold;line-height:70px;text-align:left;padding-left:100px;}
.errinf{color:#336699;font-size:16px;font-weight:bold;line-height:60px;text-align:center;}
.errtableStyle{padding:0px;font-size:14px;margin:auto;}
</style>
</head>  
 <body>
 <div id="mainBox">
<div id="errbox" style="width:700px;margin: auto;padding-top:80px;">
								<div id="mbox_topcenter">
								<div id="mbox_topleft">
								<div id="mbox_topright">
									<div id="mbox_topleft">
										
									</div>
								</div>
								</div>
								</div>
								<div id="mbox_middlecenter">
								<div id="mbox_middleleft">
								<div id="mbox_middleright">
									<div id="bs_right">
									       <!--*********************************************************-->
                                           <div id="contentBox">
	
	<div id="resultBox">
    			<table width="90%" class="errtableStyle">
						<tr>
							<th class="errTit">出错了</th>
						</tr>
						<tr>
							<td class="errinf">不好意思，出错了，请检查程序重新操作。</td>
						</tr>
						<tr>
							<td align="left">（出错原因：<%   Exception e = (Exception)request.getAttribute("exception");  
 out.print(e.getMessage());    %> ） </td>
						</tr>
							
				
				</table>

<p align="center">
		<input name="button3" type="button" class="button2"      onclick="window.history.go(-1)" value="返 回"     style="cursor: hand;"/>
	</p>
</div>
								</div>
								</div>
								</div>
								<div id="mbox_bottomcenter" >
								<div id="mbox_bottomleft">
								<div id="mbox_bottomright">

								</div>
								</div>
								</div>
		</div>
</div>
</div>
</div>

 </body>  
 </html> 
