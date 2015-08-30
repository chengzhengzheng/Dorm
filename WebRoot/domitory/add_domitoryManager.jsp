<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>校园宿舍管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<script language="JavaScript">


function mycheck(){
   if(isNull(form1.Domitory_BuildingID.value)){  
   alert("请选择楼宇！"); 
   return false;
   }
   if(isNull(form1.Domitory_Name.value)){
   alert("请输入寝室号！");
   return false;
   }
   if(isNull(form1.Domitory_Type.value)){
   alert("请输入寝室类型！");
   return false;
   }
   if(isNull(form1.Domitory_Number.value)){
   alert("请输入人数！");
   return false;
   }
   if(isNull(form1.Domitory_Tel.value)){
   alert("请输入电话！");
   return false;
   }
}

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}
   
   
</script>
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
											style="padding-left:25px;">添加宿舍</td>
									</tr>
									<tr>
										<td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form
												name="form1" method="post"
												action="addsave_domitoryManager.action"
												onSubmit="return mycheck()">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="33%" height="30" align="right">&nbsp;</td>
														<td width="67%">&nbsp;</td>
													</tr>
													<tr>
														<td height="30" align="right"><span
															style="color:red;">*</span>楼宇：</td>
														<td><select name="domitory.domitory_BuildingID"
															id="Domitory_BuildingID">
																<option value="">请选择</option>
																<s:iterator id="aa" value="buildingList">
																	<option value="${Building_ID}">${Building_Name}</option>
																</s:iterator>
														</select></td>
													</tr>
													<tr>
														<td height="30" align="right"><span
															style="color:red;">*</span>寝室号：</td>
														<td><input name="domitory.domitory_Name" type="text"
															class="text2" id="Domitory_Name"></td>
													</tr>
													<tr>
														<td height="30" align="right"><span
															style="color:red;">*</span>可容纳人数：</td>
														<td><input name="domitory.domitory_totalNumber" type="text"
															class="text2" id="Domitory_Type"></td>
													</tr>
													
													<tr>
														<td height="30" align="right"><span
															style="color:red;">*</span>电话：</td>
														<td><input name="domitory.domitory_Tel" type="text"
															class="text2" id="Domitory_Tel"></td>
													</tr>
													<tr>
														<td height="30">&nbsp;</td>
														<td><input type="submit" name="button" id="button"
															value="添加宿舍"> &nbsp;&nbsp; <input type="button"
															name="button2" id="button2" value="返回上页"
															onClick="javascript:history.back(-1);"></td>
													</tr>
												</table>
											</form></td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td height="35" background="../Images/bootBg.jpg">&nbsp;</td>
			</tr>
		</table>

	</center>
</body>
</html>
