<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>校园宿舍管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../Style/Style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
<script language="JavaScript">
	var check = false;
	function mycheck() {
		if (isNull(form1.Password.value)) {
			alert("请输入原密码！");
			return false;
		}
		if (isNull(form1.Password2.value)) {
			alert("请输入新密码！");
			return false;
		}
		if (isNull(form1.Password3.value)) {
			alert("请输入重复密码！");
			return false;
		}
		if (document.form1.Password2.value != document.form1.Password3.value) {
			alert("您两次输入的新密码不一致！请重新输入！");
			return false;
		}
	}
	function isNull(str) {
		if (str == "")
			return true;
		var regu = "^[ ]+$";
		var re = new RegExp(regu);
		return re.test(str);
	}
	
	

	/*$.getJSON(
	 "/T-GWAP/order/getReceive",
	 {"id":val},
	 function(receive){
	 $("#receiveName").val(receive.receive_name);
	 $("#fullAddress").val(receive.full_address);
	 $("#postalCode").val(receive.postal_code);
	 $("#phone").val(receive.phone);
	 $("#mobile").val(receive.mobile);
	 });
	 */
	//使用jquery+ajax技术动态验证密码是否正确
	$(function() {
	$("#Password").focus(function(){
		$("#onerror").html("");
	});
		$('#Password').blur(
				function() {
					$.getJSON("/dorm/check_password!check.action", {
						"password" : $('#Password').val()
					}, function(ok) {
						//ok:服务器返回的数据
						//浏览器会自动将xml文件转化成
						//$(data)将其包装成一个jQuery对象
						if (!ok) {
							//验证不通过
							$("#onerror").html(
									"<img src='/dorm/Images/onError.gif'>");
							check = false;
						} else {
							//验证通过
							$("#onerror").html(
									"<img src='/dorm/Images/onSuccess.gif'>");
									check = true;
						}
					});
				});
	});
	
	function check() {
		return mycheck();
	}
</script>
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
								background="../Images/leftbg.jpg"><%@ include file="Left.jsp"%>
								<br>
							</td>
							<td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table
									width="709" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30" background="../Images/mainMenuBg.jpg"
											style="padding-left:25px;">修改密码</td>
									</tr>
									<tr>
										<td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form
												name="form1" method="post"
												action="/dorm/update_password!update.action"
												onSubmit="return check()">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="33%" height="30" align="right">&nbsp;</td>
														<td width="67%">&nbsp;</td>
													</tr>
													<tr>
														<td height="30" align="right"><span
															style="color:red;">*</span>请输入原密码：</td>
														<td><input name="password" type="password"
															class="text2" id="Password"> <span id="onerror"></span>
														</td>
													</tr>
													<tr>
														<td height="30" align="right"><span
															style="color:red;">*</span>请输入新密码：</td>
														<td><input name="password2" type="password"
															class="text2" id="Password2">
														</td>
													</tr>
													<tr>
														<td height="30" align="right"><span
															style="color:red;">*</span>请重复新密码：</td>
														<td><input name="Password3" type="password"
															class="text2" id="Password3">
														</td>
													</tr>
													<tr>
														<td height="30">&nbsp;</td>
														<td><input type="submit" name="button" id="button"
															value="修改密码">
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
				<td height="35" background="Images/bootBg.jpg">&nbsp;</td>
			</tr>
		</table>

	</center>
</body>
</html>
