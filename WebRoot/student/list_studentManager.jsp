<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>校园宿舍管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../Style/Style.css" rel="stylesheet" type="text/css" />
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
								background="../Images/leftbg.jpg"><%@ include
									file="../common/Left.jsp"%></td>
							<td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table
									width="709" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30" background="../Images/mainMenuBg.jpg"
											style="padding-left:25px;">学生管理</td>
									</tr>
									<tr>
										<td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form
												name="form1" method="post" action="queryManager.action" ">
												<table width="100%%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="28%" height="30" style="padding-left:20px;">
															功能导航： <a href="/dorm/student/add_studentManager.jsp">添加学生</a>
														</td>
														<td width="72%">查询： <select name="state" id="State">
																<option value="全部">全部</option>
																<option value="入住">入住</option>
																<option value="未入住">未入住</option>
														</select> <select name="searchRow" id="SearchRow">
																<option value="姓名">姓名</option>
																<option value="学号">学号</option>
																<option value="班级">班级</option>
														</select> <input name="searchKey" type="text" class="text1"
															id="SearchKey"> <input type="submit"
															name="button" id="button" value="点击查询">
														</td>
													</tr>
												</table>
											</form>
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr align="center" class="t1">
													<td height="25" bgcolor="#D5E4F4"><strong>学号</strong>
													</td>
													<td bgcolor="#D5E4F4"><strong>姓名</strong>
													</td>
													<td bgcolor="#D5E4F4"><strong>宿舍</strong>
													</td>
													<td bgcolor="#D5E4F4"><strong>班级</strong>
													</td>
													<td bgcolor="#D5E4F4"><strong>状态</strong>
													</td>
													<td bgcolor="#D5E4F4"><strong>操作</strong>
													</td>
												</tr>
												<s:iterator id="aa" value="students">
												
													<tr align="center">
														<td height="25" align="center">${Student_Username}</td>
														<td>${Student_Name}</td>
														<td>${domitory_Name}</td>
														<td>${Student_Class}</td>
														<td align="center">${Student_State}</td>
														<td align="center"><a
															href="update_studentManager.action?student_ID=${Student_ID}">修改</a>
															<a href="del_studentManager.action?student_ID=${Student_ID}"
															onClick="return confirm('确定要删除该学生吗？')">删除</a>
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
