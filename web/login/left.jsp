<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	<link rel="StyleSheet" href="${pageContext.request.contextPath}/css/dtree.css" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
	<script type="text/javascript">
		<!--
		d = new dTree('d');
		d.add(0,-1,'系统菜单树');
        d.add(1,0,'查询信息','${pageContext.request.contextPath}/school_find.action?page=1','','mainFrame');

        d.add(2,0,'校园信息管理','${pageContext.request.contextPath}/login/hello.jsp','','mainFrame');
		//子目录添加
		d.add(3,2,'学校管理','${pageContext.request.contextPath}/school_findAll.action?page=1','','mainFrame');
        d.add(4,2,'班级管理','${pageContext.request.contextPath}/clas_findAll.action?page=1','','mainFrame');
        d.add(5,2,'学生管理','${pageContext.request.contextPath}/student_findAll.action?page=1','','mainFrame');

		
		document.write(d);
		//-->
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
