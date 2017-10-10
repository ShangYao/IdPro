<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="page" uri="http://sdga.musicvv.com/tags/page"%>
<%@ taglib prefix="jlselect" uri="http://sdga.musicvv.com/tags/jlselect"%>
<%@ taglib prefix="getstr" uri="http://sdga.musicvv.com/tags/getstr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jqfun.js"></script>
<script type="text/javascript" src="js/glbmjl.js"></script>
<link href="css/contentStyle.css" type=text/css rel=stylesheet />
<%@ include  file="inc.jsp" %>
<title>身份证信息管理</title>
<%
String ss=request.getParameter("zl");
%>
<script type="text/javascript">
$(function(){
	//load 事件 
	$("#zl").val("<%=ss %>");
	       if($("#ywstate").val()!=""&&$("#ywstate").val()!=null){
	      	  $.messager.alert("信息提示", $("#ywstate").val(),"info");
			$("#ywstate").val("");
	      }	 
	      $(document).keyup(function(event){
        var event=event||window.event;
        var keycode = event.which||event.keyCode;
        if(keycode == 13){
        	cx();
        }
	}); 
});


function cx(){
	
	myform.action="idmanage.do?ywtype=id_cx";
	myform.submit();
}
	
	function fy(num){
		myform.action = "id.do?ywtype=id_cx&pageNumber="+num;  
		myform.submit();  
	}

	function tj(){
		top.Dialog.open({URL:"id.do?ywtype=id_tj",Title:"参数信息添加",Width:700,Height:400});
		}

	function xg(id){
		top.Dialog.open({URL:"idmanage.do?id_temp="+id+"&ywtype=id_xg",Title:"参数信息修改",Width:700,Height:400});

		}
	function xq(id){
		top.Dialog.open({URL:"idmanage.do?id_temp="+id+"&ywtype=id_xq",Title:"参数信息详情",Width:700,Height:400});
		}

	
	function sc(id){
		if(!confirm("确实要删除该信息？"))
			return;
		
		myform.action = "idmanage.do?ywtype=id_sc&id_temp="+id; 
		myform.submit();
	}

	

	function qk(){
		$("#id_number").attr("value","");   
	    $("#name").attr("value","");   
	     
	}

</script>
  </head>
  <%
	  String ip = (request.getRemoteAddr()).equals("0:0:0:0:0:0:0:1")? "127.0.0.1" :  (request.getRemoteAddr()); 
%>
  <body>
  <div align="right"></div>
	<form:form commandName="idForm" action="idmanage.do" method="post" id="myform">
		<div id="mainFrame">
			<div class="pageHeader">
				<div class="searchBar">
					<table class="searchContent">
						<nobr>
								<span>身份证号码：</span>
								<form:input path="id.id_number" cssStyle="width:150px" maxlength="50" id="id_number"/></nobr>
						<nobr>
								<span>姓名：</span>
								<form:input path="id.name" cssStyle="width:70px" maxlength="50" id="name"/></nobr>
					</table>
					<div class="subBar">
						<ul>
							<li><div class="buttonActive">
									<div class="buttonContent">
										<button type="button" onclick="cx()">查 询</button>
									</div>
								</div>
							</li>
							<li><div class="buttonActive">
									<div class="buttonContent">
										<button type="button" onclick="tj()">添 加</button>
									</div>
								</div>
							</li>
							<li><div class="buttonActive">
									<div class="buttonContent">
										<button type="button" onclick="qk()">清 空</button>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="pageContent">
				<table width="100%" class="tableStyle">
					<thead>
						<tr>
							<th width="13%">姓名</th>
							<th width="7%">身份证号码</th>
							<th width="7%">性别</th>
							<th width="4%">民族</th>
							<th width="7%">地址</th>
							<th width="7%">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${empty idForm.cxlist}">
								<%for(int i=0;i<10;i++){%>
								<tr>
									<% for(int k=0;k<6;k++){
                 				%>
									<td>&nbsp;</td>
									<%}%>
								</tr>
								<%}%>
							</c:when>
							<c:otherwise>
								<c:forEach items="${idForm.cxlist}" var="id"
									varStatus="status">
									<tr class="bs" title="">
										<%-- <td width="13%"><getstr:getstr code="${id.name}"
												mbcode="ZFFS" />
										</td> --%>

										<td width="7%"><c:out value="${id.name}" />
										</td>
										<td width="7%"><c:out value="${id.id_number}" />
										</td>
										<td width="7%"><c:out value="${id.sex}" />
										</td>
										<td width="3%"><c:out value="${id.nation}" />
										</td>
										<td width="7%"><c:out value="${id.address}"  />
										</td>
										<td width="8%"><input type="button" name="button1"
											value="详情" class="bt_g" onclick="xq('${id.id_number}')" />
											<input type="button" name="button1" value="修改" class="bt_g"
											onclick="xg('${id.id_number}')" /> <input type="button"
											name="button2" value="删除" class="bt_g"
											onclick="sc('${id.id_number}')" /></td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
			<div class="panelBar">
				<page:page pageNumber="${idForm.id.pageNumber}"
					lastPageNumber="${idForm.id.lastPageNumber}"
					totalRecordCount="${idForm.id.totalRecordCount}"
					itemCountPerPage="${idForm.id.itemCountPerPage}" />
			</div>
		</div>
		<input type="hidden" name="id.pageNumber" id="pageNumber"
			value="${idForm.id.pageNumber}" />
		<input type="hidden" name="id.ywtype" id="ywtype"
			value="${idForm.ywtype}" />
		<input type="hidden" name="id.ywstate" id="ywstate"
			value="${idForm.ywstate}" />
		

			<input type="hidden" name="yhxm_l" id="yhxm_l"	value="${sessionScope.loginForm.user.name}" />
      	<input type="hidden" name="glbm_l" id="glbm_l"	value="${sessionScope.loginForm.user.department}" />

		<input type="hidden" name="jkip" value="<%=ip%>" maxlength="18" />&nbsp;
</form:form>
</body>
</html>
