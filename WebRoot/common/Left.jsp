<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page import="shifan.util.*,shifan.pojo.*"%>
<link href="../Style/Style.css" rel="stylesheet" type="text/css" />
<table width="155" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="31" align="center" background="../Images/left1.jpg"><strong>系统选项</strong>
		</td>
	</tr>
	<tr>
		<td height="50" align="center" valign="top"><table width="150"
				border="0" cellspacing="0" cellpadding="0">

				<tr>
					<td height="5" align="center"><img src="../Images/ic.gif"
						width="1" height="1">
					</td>
				</tr>
				<tr>
					<td height="30" align="center" background="../Images/left2.jpg"
						style="text-align:left; padding-left:40px;"><a
						href="/dorm/common/Index.jsp">后台首页</a>
					</td>
				</tr>
				<tr>
					<td height="5" align="center"><img src="../Images/ic.gif"
						width="1" height="1">
					</td>
				</tr>
				<s:if test="#session.loginType.equals('系统管理员')">

					<tr>
						<td height="30" align="center" background="../Images/left2.jpg"
							style="text-align:left; padding-left:40px;"><a
							href="/dorm/teacher/list_teacherManager.action">楼宇管理员管理</a>
						</td>
					</tr>
					<tr>
						<td height="5" align="center"><img src="../Images/ic.gif"
							width="1" height="1">
						</td>
					</tr>
					<tr>
						<td height="30" align="center" background="../Images/left2.jpg"
							style="text-align:left; padding-left:40px;"><a
							href="/dorm/student/list_studentManager.action">学生管理</a>
						</td>
					</tr>
					<tr>
						<td height="5" align="center"><img src="../Images/ic.gif"
							width="1" height="1">
						</td>
					</tr>
					<tr>
						<td height="30" align="center" background="../Images/left2.jpg"
							style="text-align:left; padding-left:40px;"><a
							href="/dorm/building/list_buildingManager.action">楼宇管理</a>
						</td>
					</tr>
					<tr>
						<td height="5" align="center"><img src="../Images/ic.gif"
							width="1" height="1">
						</td>
					</tr>
					<tr>
						<td height="30" align="center" background="../Images/left2.jpg"
							style="text-align:left; padding-left:40px;"><a
							href="/dorm/domitory/list_domitoryManager.action">宿舍管理</a>
						</td>
					</tr>
					<tr>
						<td height="5" align="center"><img src="../Images/ic.gif"
							width="1" height="1">
						</td>
					</tr>
					<tr>
						<td height="30" align="center" background="../Images/left2.jpg"
							style="text-align:left; padding-left:40px;"><a
							href="/dorm/student/StudentRZ.action">学生入住登记</a>
						</td>
					</tr>
					<tr>
						<td height="5" align="center"><img src="../Images/ic.gif"
							width="1" height="1">
						</td>
					</tr>
					<tr>
						<td height="30" align="center" background="../Images/left2.jpg"
							style="text-align:left; padding-left:40px;"><a
							href="/dorm/student/StudentTH.jsp">学生寝室调换</a>
						</td>
					</tr>
					<tr>
						<td height="5" align="center"><img src="../Images/ic.gif"
							width="1" height="1">
						</td>
					</tr>
					<tr>
						<td height="30" align="center" background="../Images/left2.jpg"
							style="text-align:left; padding-left:40px;"><a
							href="/dorm/hygiene/list_hygieneManager.action">卫生管理</a>
						</td>
					</tr>
					<tr>
						<td height="5" align="center"><img src="../Images/ic.gif"
							width="1" height="1">
						</td>
					</tr>
					<tr>
						<td height="30" align="center" background="../Images/left2.jpg"
							style="text-align:left; padding-left:40px;"><a
							href="../common/PasswordUpdate.jsp">修改密码</a>
						</td>
					</tr>
					<tr>
						<td height="5" align="center"><img src="../Images/ic.gif"
							width="1" height="1">
						</td>
					</tr>
					<tr>
						<td height="30" align="center" background="../Images/left2.jpg"
							style="text-align:left; padding-left:40px;"><a
							href="Quit.action" onclick="return confirm('确定要退出系统吗？')">退出系统</a>
						</td>
					</tr>

				</s:if>
				
				<s:if test="#session.loginType.equals('楼宇管理员')">
					<tr>
						<td height="30" align="center" background="../Images/left2.jpg"
							style="text-align:left; padding-left:40px;">
									<!-- 首先进入的是楼宇选择页面  调用数据库经该教师所管理的所有楼宇拿出来 -->
									<a	href="../student/mybuilding_studentManager.action">学生管理</a>
						</td>
					</tr>
					<tr>
						<td height="5" align="center"><img src="../Images/ic.gif"
							width="1" height="1">
						</td>
					</tr>
					<tr>
						<td height="30" align="center" background="../Images/left2.jpg"
							style="text-align:left; padding-left:40px;"><a
							href="/dorm/hygiene/listMyHygiene_hygieneManager.action">卫生管理</a>
						</td>
					</tr>
					<tr>
						<td height="5" align="center"><img src="../Images/ic.gif"
							width="1" height="1">
						</td>
					</tr>
					<!-- <tr>
						<td height="30" align="center" background="../Images/left2.jpg"
							style="text-align:left; padding-left:40px;"><a
							href="StudentTH.jsp">学生寝室调换</a>
						</td>
					</tr> -->
					<tr>
						<td height="5" align="center"><img src="../Images/ic.gif"
							width="1" height="1">
						</td>
					</tr>
					<tr>
						<td height="30" align="center" background="../Images/left2.jpg"
							style="text-align:left; padding-left:40px;"><a
							href="../common/PasswordUpdate.jsp">修改密码</a>
						</td>
					</tr>
					<tr>
						<td height="5" align="center"><img src="../Images/ic.gif"
							width="1" height="1">
						</td>
					</tr>
					<tr>
						<td height="30" align="center" background="../Images/left2.jpg"
							style="text-align:left; padding-left:40px;"><a
							href="Quit.action" onclick="return confirm('确定要退出系统吗？')">退出系统</a>
						</td>
					</tr>
				</s:if>

			</table></td>
	</tr>
</table>