<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>挂失与解挂</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/jkxyflower.css">
	

  </head>
  
  <body>
 
   <div class="content">
		<div class="left">
			<a href="addFlower.action">添加新花品</a><br><br>
			<a href="managerFlower.action">管理花品</a><br><br>
	        <a href="logOut.action">注销</a>
		</div>
		
		<div class="right">
		
		<form action="userAction" method="post">
		
		
		
		
    	<td>测试账号：1</td>
    	<td>（挂失后该用户不能登陆）</td>
    	</tr>
		<br>
      请输入你要处理的账号 
	<input type="text" name="userid" >					
		
<input type="submit" value="挂失" onclick="this.form.action='guashiUser'"/>
<input type="submit" value="解挂" onclick="this.form.action='jieguaUser'"/>
</form>
		
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
  </body>
</html>
