<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-1.4.2.js"></script>
	<style type="text/css">
		a:Link {
			color: #fa011e;
			text-decoration: none;
		}
		a:visited {
			text-decoration: none;
			color: #0000ff;
		}
		a:hover {
			color: #0000ff;
			text-decoration: underline;
		}
		a:active {
			text-decoration: none;
		}
		a {
			color: #fa011e;
		}

	</style>

	</HEAD>
	<body>
		<br>
		<s:form action="school_list" namespace="/" method="post" theme="simple" id="Form1" name="Form1">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">

					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>班 级 列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" style="WIDTH: 100%" align="right">
							<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
							<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
							<span id="Label1"></span>
						</td>
					</tr>
					<s:if test="pageBean.list != null">
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="5%">
										序号
									</td>
									<td align="center" width="17%">
										班级
									</td>
									<td align="center" width="5%">
										查看学生
									</td>
								</tr>
								<s:iterator value="pageBean.list" var="c" status="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												<s:property value="#status.count"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:property value="#c.cname"/>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath }/student_findByCid.action?page=1&cid=<s:property value="#c.cid"/>">
													<img src="${pageContext.request.contextPath}/images/button_view.gif" border="0" style="CURSOR: hand">
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
								<a href="${pageContext.request.contextPath }/school_findAll.action?page=1">首页</a> |
								<a href="${pageContext.request.contextPath }/school_findAll.action?page=<s:property value="pageBean.page-1"/>">上一页</a> |
							</s:if>
							<s:if test="pageBean.page != pageBean.totalPage">
								<a href="${pageContext.request.contextPath }/school_findAll.action?page=<s:property value="pageBean.page+1"/>">下一页</a> |
								<a href="${pageContext.request.contextPath }/school_findAll.action?page=<s:property value="pageBean.totalPage"/>">尾页</a>
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

