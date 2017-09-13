<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
		<script>
            function checkForm(){
                // 校验用户名:
                // 获得用户名文本框的值:
                var shname = document.getElementById("shname").value;
                if(shname == null || shname == ''){
                    alert("学校名称不能为空!");
                    return false;
                }
                var shaddress = document.getElementById("shaddress").value;
                if(shaddress == null || shaddress == ''){
                    alert("学校地址不能为空!");
                    return false;
                }
            }
		</script>
	</HEAD>
	
	<body>
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/school_update.action" method="post" enctype="multipart/form-data" onsubmit="return checkForm();">
			&nbsp;
			<input type="hidden" name="shid" value="<s:property value="model.shid"/>"/>
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>学校已存在，学校不可重复，请重新编辑！</STRONG>
						</strong>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						学校名称：<input type="text" name="shname" value="<s:property value="model.shname"/>" id="shname" class="bg" maxlength="15"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						学校地址：<input type="text" name="shaddress" value="<s:property value="model.shaddress"/>" id="shaddress" class="bg" maxlength="30"/>
					</td>
				</tr>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" value="确定" class="button_ok">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>