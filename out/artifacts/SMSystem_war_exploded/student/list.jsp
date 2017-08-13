<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-1.4.2.js"></script>
		<script type="text/javascript">
            function addUser(){
                window.location.href = "${pageContext.request.contextPath}/student_addPage.action";
            }
		</script>
	</HEAD>
	<body>
		<br>
		<s:form action="student_list" namespace="/" method="post" theme="simple" id="Form1" name="Form1">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>学 生 列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="添加" class="button_add" onclick="addUser()">
								&#28155;&#21152;
							</button>

						</td>
					</tr>
					<s:if test="pageBean.totalPage != 0">
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="5%">
										学号
									</td>
									<td align="center" width="17%">
										姓名
									</td>
									<td align="center" width="5%">
										性别
									</td>
									<td align="center" width="17%">
										年龄
									</td>
									<td width="7%" align="center">
										编辑
									</td>
									<td width="7%" align="center">
										删除
									</td>
								</tr>
								<s:iterator value="pageBean.list" var="st" status="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												<s:property value="#status.count"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:property value="#st.name"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												<s:property value="#st.sex"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:property value="#st.age"/>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/student_edit.action?stuid=<s:property value="#st.stuid"/>">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>

											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/student_delete.action?stuid=<s:property value="#st.stuid"/>">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
								</s:iterator>		
							</table>
						</td>
					</tr>
					<tr align="center" style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
						<td colspan="4">
							第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页
							<s:if test="pageBean.page != 1">
								<a href="${pageContext.request.contextPath }/student_findAll.action?page=1">首页</a> |
								<a href="${pageContext.request.contextPath }/student_findAll.action?page=<s:property value="pageBean.page-1"/>">上一页</a> |
							</s:if>
							<s:if test="pageBean.page != pageBean.totalPage">
								<a href="${pageContext.request.contextPath }/student_findAll.action?page=<s:property value="pageBean.page+1"/>">下一页</a> |
								<a href="${pageContext.request.contextPath }/student_findAll.action?page=<s:property value="pageBean.totalPage"/>">尾页</a>
							</s:if>
						</td>
					</tr>
					</s:if>
					<s:else>
						<tr>
							<td align="center">
								<h1>列表为空</h1>
							</TD>
						</tr>
					</s:else>
				</TBODY>
			</table>
		</s:form>
	</body>
</HTML>

