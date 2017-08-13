<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
	<script>
        function checkForm(){
            // 校验用户名:
            // 获得用户名文本框的值:
            var name = document.getElementById("name").value;
            if(name == null || name == ''){
                alert("学生名字不能为空!");
                return false;
            }
            var cname = document.getElementById("cname").value;
            if(cname == null || cname == ''){
                alert("班级不能为空!");
                return false;
            }

            var sex = document.getElementById("sex").value;
            if(sex == null || sex == ''){
                alert("请选择学生性别");
                return false;
            }

            var age = document.getElementById("age").value;
            if(age == null || age == ''){
                alert("学生年龄不能为空");
                return false;
            }
        }
	</script>
</HEAD>

<body>
<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/student_update.action" method="post" enctype="multipart/form-data" onsubmit="return checkForm();">
	&nbsp;
	<input type="hidden" name="stuid" value="<s:property value="model.stuid"/>"/>
	<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
		<tr>
			<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
				height="26">
				<strong><STRONG>修改学生信息</STRONG>
				</strong>
			</td>
		</tr>

		<tr>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				学生姓名：<input type="text" name="name" value="<s:property value="model.name"/>" id="studentAction_add_name" class="bg"/>
			</td>
		</tr>
		<tr>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				学生性别：<select name="sex" id="sex">
				<option value="">-请选择-</option>
				<option value="男" <c:if test="${model.sex eq '男' }">selected</c:if>>男</option>
				<option value="女" <c:if test="${model.sex eq '女' }">selected</c:if>>女</option>
				</select>
			</td>
		</tr>
		<tr>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				学生年龄：<input type="text" name="age" value="<s:property value="model.age"/>" id="age" class="bg"/>
			</td>
		</tr>
		<tr>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				所属的班级：
				<select name="clas.cid" id="cname">
					<option value="">-请选择-</option>
					<s:iterator var="c" value="cList">
						<option value="<s:property value="#c.cid"/>" <s:if test="#c.cid==model.clas.cid">selected</s:if>><s:property value="#c.cname"/></option>
					</s:iterator>
				</select>
			</td>
		</tr>
		<tr>
			<td class="ta_01" style="WIDTH: 100%" align="center"
				bgColor="#f5fafe" colSpan="4">
				<button type="submit" id="clasAction_save_do_submit" value="确定" class="button_ok">
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