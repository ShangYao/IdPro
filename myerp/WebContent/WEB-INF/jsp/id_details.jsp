<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="page" uri="http://sdga.musicvv.com/tags/page"%>
<%@ taglib prefix="getstr" uri="http://sdga.musicvv.com/tags/getstr"%>
<%@ taglib prefix="getsubstr"
	uri="http://sdga.musicvv.com/tags/getsubstr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@ include file="inc.jsp"%>
<title>身份证信息详情</title>
<script type="text/javascript">


$(function(){
	//load 事件 
      if($("#ywstate").val()!=""&&$("#ywstate").val()!=null){
      	  $.messager.alert("信息提示", $("#ywstate").val(),"info");
			$("#ywstate").val("");
      }	
});

function bc(){
   if($("#zffs").val()==""||$("#zffs").val()==null){
		$.messager.alert("信息提示","支付方式不能为空！","info");
		return;
	} 
	
  
	myform.action = "id.do?ywtype=id_insert";
	myform.submit();  

}



function qk(){
	$("#xtlb").attr("value","");   
    $("#jkxlh").attr("value","");   
    $("#jkid").attr("value","");	
    $("#fwcs").attr("value","");
    $("#bz1").attr("value","");
    $("#jkff").attr("value","");
    $("#jkdz").attr("value","");
    $("#namespace").attr("value","");
}

function gb(){
	top.Dialog.close();
}

</script>
</head>
<body onload="load()">
	<%
	  String ip = (request.getRemoteAddr()).equals("0:0:0:0:0:0:0:1")? "127.0.0.1" :  (request.getRemoteAddr()); 
%>
	<form:form commandName="idForm" action="idmanage.do" method="post"
		id="myform">
		<div id="mainFrame">
			<div class="pageHeader">
				<div class="searchBar">
					<table width="98%" class="tableStyle6" style="margin:5px;">

						
						<tr>
							<td class="tabtit1">姓名：</td>
							<td align="left" colspan="3"><form:input
									path="id.name" id="name" maxlength="100"
									cssStyle="width:92%" cssClass="required" />
							</td>
						</tr>
						<tr>
							<td class="tabtit1">身份证号码：</td>
							<td align="left"><form:input path="id.id_number" id="id_number"
									maxlength="100" cssStyle="width:80%" />
							</td>
							<td class="tabtit1">性别：</td>
							<td align="left"><form:input path="id.sex"
									id="sex" maxlength="100" cssStyle="width:80%" />
							</td>

						</tr>
						<tr>
							<td class="tabtit1">民族：</td>
							<td align="left"><form:input path="id.nation"
									id="nation" maxlength="100" cssStyle="width:80%" />
							</td>
							<td class="tabtit1">住址：</td>
							<td align="left"><form:input path="id.address"
									id="address" maxlength="300" cssStyle="width:80%" />
							</td>

						</tr>


						<tr>
							<td class="tabtit1">省份：</td>
							<td align="left" colspan="3"><form:textarea
									path="id.address_province" id="address_province"
									cssStyle="width:95%" />
							</td>
						</tr>
						<tr>
							<td class="tabtit1">城市：</td>
							<td align="left" colspan="3"><form:textarea
									path="id.address_city" id="address_city"
									cssStyle="width:95%" />
							</td>
						</tr>
						<tr>
							<td class="tabtit1">区：</td>
							<td align="left" colspan="3"><form:input
									path="id.address_area" id="address_area" maxlength="100"
									cssStyle="width:95%" />
							</td>
						</tr>
						
					</table>
					<div style="text-align:center;padding:10px;">

						<input name="button" type="button" class="button2" onclick="gb()"
							value="返回" />
					</div>
				</div>
			</div>
		</div>

		
	</form:form>
</body>
</html>
