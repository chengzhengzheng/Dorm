<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>校园宿舍管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
<script type="text/javascript">
$(function(){
//利用ajax动态加载某个楼宇对应的宿舍号
$("#Building_ID").change(function(){
//删除上一次操作的结果
	//var selOpt = $("#Domitory_ID option");
 	//selOpt.remove();
 	$("#Domitory_ID").html("");
 	$("#Teacher_ID").html("");
	$.ajax({
		"url":"/dorm/domitory/findDomitoryByBuildingID.action",
		"type":"post",
		"data":{"current_BuildingID":$("#Building_ID").val()},
		"dataType":"json",
		"success":
		function(data,statusText){
			//data已经是java对象转换成json对象在由jQuery转换成了js对象
			$.each(data, function(i, n){
 				var selObj = $("#Domitory_ID");
				 var value=n.domitory_ID;
				 var text=n.domitory_Name;
				 selObj.append("<option value='"+value+"'>"+text+"</option>");
			});
		},
		"error":
		function(){
			alert("系统错误");
		}
	
	});
	
	
	$.ajax({
	"url":"/dorm/teacher/findTeacherByBuildingID.action",
		"type":"post",
		"data":{"current_BuildingID":$("#Building_ID").val()},
		"dataType":"json",
		"success":
		function(data,statusText){
			//data已经是java对象转换成json对象在由jQuery转换成了js对象
			$.each(data, function(i, n){
 				var selObj = $("#Teacher_ID");
				 var value=n.teacher_ID;
				 var text=n.teacher_Name;
				 selObj.append("<option value='"+value+"'>"+text+"</option>");
			});
		},
		"error":
		function(){
			alert("系统错误");
		}
	});
});
//利用ajax动态加载某个楼宇对应的楼宇管理员
});
</script>
<script type="text/javascript">
function mycheck(){
   if(isNull(form1.Building_ID.value)){
   alert("请选择楼宇！");
   return false;
   }
   if(isNull(form1.score.value)){  
		  alert("请输入分数！"); 
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
											style="padding-left:25px;">学生入住登记</td>
									</tr>
									<tr>
										<td height="470" align="center" valign="top" bgcolor="#F6F9FE">
											<form name="form1" method="post"
												action="/dorm/hygiene/updatesave_hygieneManager.action"
												onSubmit="return mycheck()">
												<!-- 隐藏域、用来向服务器提交数据
											list_adminHygiene将week数据从action传进来、隐藏域、获取到week数据、再次发送到
											action服务器中
											、也可以将week数据保存到session当中
											 -->
											 <input name="hygiene.id"  type="hidden" value="${hygiene.id}">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="33%" height="30" align="right">&nbsp;</td>
														<td width="67%">&nbsp;</td>
													</tr>
													<tr>
														<td height="30" align="right"><span
															style="color:red;">*</span>楼宇：</td>
														<td>
																<label>${hygiene.building_Name}</label>
														</td>
													</tr>
													<tr>
														<td height="30" align="right"><span
															style="color:red;">*</span>寝室：</td>
														<td>
															<label>${hygiene.domitory_Name}</label>
														</td>
													</tr>
													<tr>
														<td height="30" align="right"><span
															style="color:red;">*</span>登记人：</td>
														<td>
															<label>${hygiene.teacher_Name}</label>
														</td>
													</tr>
													<tr>
														<td height="30" align="right"><span
															style="color:red;">*</span>分数：</td>
														<td><label for="Student_ID"></label> <input
															type="text" name="hygiene.score" id="score" value="${hygiene.score}">
														</td>
													</tr>
													<tr>
														<td height="30">&nbsp;</td>
														<td><input type="submit" name="button" id="button"
															value="确认打分">
														</td>
													</tr>
												</table>
											</form>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="35" background="../Images/bootBg.jpg">&nbsp;</td>
			</tr>
		</table>

	</center>
</body>
</html>
