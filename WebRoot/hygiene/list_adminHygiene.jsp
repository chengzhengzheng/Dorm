<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>校园宿舍管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../Style/Style.css" rel="stylesheet" type="text/css" />
<script>
	var i = 0;
	function changeRadio(obj){
		i = obj.value;
	}
	function add() {
		window.location.href = "/dorm/hygiene/add_hygieneManager";
	}
	
	function submit(id){//宿舍id
		var obj = document.getElementById("week");
		var val;
		var v = obj.value;//第几周
		if (confirm("确认提交？")){
			window.location.href="dorm/hygiene/submit_hygieneManager.action?domitoryID="+id+"&&week_Number="+v+"&&grade="+i;
		}
	}
												
</script>
</head>
<body onload="first()">
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
											style="padding-left:25px;">宿舍管理</td>
									</tr>
									<tr style="margin-left:30px;">
										<td height="470" align="center" valign="top" bgcolor="#F6F9FE">
											<form name="form1" method="post"
												action="/dorm/hygiene/query_hygieneManager.action">
												<table width="100%% " border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="78%" style="padding-left:30px;">楼宇： <select
															onchange="first(${Building_ID})" name="Building_ID"
															id="Domitory_BuildingID">
																<option value="0">全部楼宇</option>
																<s:iterator value="all_Buildings" var="st" status = "s">
																	
																		
																		<option value="${building_ID}">${Building_Name}</option>
																</s:iterator>
														</select> <script>
																</script> <select name="week_Number" id="week"
															style="margin-left:30px;">

																<s:iterator status="st" id="w" value="week">

																	<s:if test="week_Number == #st.index +1">
																		<option value="${w}" selected="selected">第${w}周</option>
																	</s:if>
																	<s:else>
																		<option value="${w}">第${w}周</option>
																	</s:else>
																</s:iterator>
														</select> <input type="submit" name="button" id="button"
															value="点击查询" style="margin-left:50px;"></td>
													</tr>

												</table>
											</form>

											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr align="center" class="t1">
													<td height="25" bgcolor="#D5E4F4"><strong>楼宇号</strong>
													</td>
													<td bgcolor="#D5E4F4"><strong>寝室号</strong></td>
													<td bgcolor="#D5E4F4"><strong>等级</strong></td>
													<td bgcolor="#D5E4F4"><strong>操作</strong></td>
													<td bgcolor="#D5E4F4"><strong>评分人</strong></td>
												</tr>
												<s:iterator id="aa" value="all_Domitorys" status="ss">

													<tr align="center" id="t1">
														<td height="25" align="center">${building_Name}</td>
														<td>${domitory_Name}</td>
														<td>
															<form name="sub" method="post">
																<s:if test="score == 1">
																	<input type="radio" value="1" name="grade"
																		onchange="changeRadio(this)" checked="checked">优良
																	<input type="radio" value="2" name="grade"
																		onchange="changeRadio(this)">一般 <input
																		type="radio" value="3" name="grade"
																		onchange="changeRadio(this)">差
																</s:if>
																<s:elseif test="score == 2 ">
																	<input type="radio" value="1" name="grade"
																		onchange="changeRadio(this)">优良
																	<input type="radio" value="2" name="grade"
																		onchange="changeRadio(this)" checked="checked">一般 <input
																		type="radio" value="3" name="grade"
																		onchange="changeRadio(this)">差
																</s:elseif>
																<s:elseif test="score == 3">
																	<input type="radio" value="1" name="grade"
																		onchange="changeRadio(this)">优良
																	<input type="radio" value="2" name="grade"
																		onchange="changeRadio(this)">一般 <input
																		type="radio" value="3" name="grade"
																		onchange="changeRadio(this)" checked="checked">差
																</s:elseif>
																<s:else>
																	<input type="radio" value="1" name="grade"
																		onchange="changeRadio(this)">优良
																	<input type="radio" value="2" name="grade"
																		onchange="changeRadio(this)">一般 <input
																		type="radio" value="3" name="grade"
																		onchange="changeRadio(this)">差
																</s:else>
															</form>
														<td><input type="button" value="提交"
															onClick="submit(${domitory_ID})" /></td>
														<td align="center">${teacher_Name}</td>
													</tr>
												</s:iterator>
											</table></td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td height="35" background="Images/bootBg.jpg">&nbsp;</td>
			</tr>
		</table>
	</center>
</body>
</html>
