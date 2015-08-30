<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>校园宿舍管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../Style/Style.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery-1.4.3.js"></script>
</head>
<body>
	<center>
		<table width="900" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="60" bgcolor="#E6F5FF"
					style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">校园宿舍管理系统</td>
			</tr>
			<tr>
				<td height="30" background="../Images/MenuBg.jpg">&nbsp;</td>
			</tr>
			<tr>
				<td height="500" align="center" valign="top"><table width="900"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="191" height="500" align="center" valign="top"
								background="Images/leftbg.jpg"><%@ include
									file="../common/Left.jsp"%></td>
							<td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table
									width="709" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30" background="../Images/mainMenuBg.jpg"
											style="padding-left:25px;">宿舍管理</td>
									</tr>
									<tr>
										<td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form
												name="form1" method="post" action="/dorm/domitory/find.action">
												<table width="100%%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="22%" height="30" style="padding-left:20px;">
															功能导航： <a href="/dorm/domitory/add_domitoryManager.action">添加宿舍</a>
														</td>
														<td width="78%">查询： <select
															name="domitory_BuildingID" id="Domitory_BuildingID">
																<option value="0">全部楼宇</option>
																<s:iterator value="buildingList">
																	<option value="${Building_ID}">${Building_Name}</option>
																</s:iterator>
														</select> <select name="searchRow" id="SearchRow">
																<option value="Domitory_all">全部宿舍</option>
																<option value="Domitory_have">可住宿舍</option>
														</select>  <input type="submit"
															name="button" id="button" value="点击查询">
														</td>
													</tr>
												</table>
											</form>
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr align="center" class="t1">
													<td height="25" bgcolor="#D5E4F4"><strong>楼宇</strong>
													</td>
													<td bgcolor="#D5E4F4"><strong>寝室号</strong>
													</td>
													<td bgcolor="#D5E4F4"><strong>可住人数</strong>
													</td>
													<td bgcolor="#D5E4F4"><strong>已住人数</strong>
													</td>
													<td bgcolor="#D5E4F4"><strong>电话</strong>
													</td>
													<td bgcolor="#D5E4F4"><strong>操作</strong>
													</td>
												</tr>
												<s:iterator id="aa" value="domitorys">
													<tr align="center">
														<td height="25" align="center">${domitory_BuildingName}</td>
														<td>${Domitory_Name}</td>
														<td align="center">${domitory_totalNumber}</td>
														<td align="center">${domitory_Number}</td>
														<td align="center">${Domitory_Tel}</td>
														<td align="center"><a
															href="update_domitoryManager.action?domitory_ID=${Domitory_ID}">修改</a>
															<%-- <a href="del_domitoryManager.action?domitory_ID=${Domitory_ID}"
															onClick="return confirm('确定要删除该宿舍吗？')">删除</a> --%>
														</td>
													</tr>
												</s:iterator>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="35" background="Images/bootBg.jpg">&nbsp;</td>
			</tr>
		</table>

	</center>
</body>
</html>
