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
    
    <title>所有花品信息</title>
    
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
		<a href="managerUser.jsp">顾客账号管理</a><br><br>	
        <a href="logOut.action">注销</a>
		</div>
		
		<div class="right">
		 
			<s:iterator value="#request.flowers" id="flower">
				<div class="newflower">
					
					
					<form action="flowerAction" method="post">
       <img src="pic/<s:property value="#flower.picture"/>" />
						<br>
						<s:property value="#flower.flowername" />
						<br>
						<s:property value="#flower.price" />元
 <br>

	<input type="hidden" name="flowerid" value="<s:property value="#flower.flowerid" />">					
		
<input type="submit" value="修改" onclick="this.form.action='displayOneFlower'"/>
<input type="submit" value="删除" onclick="this.form.action='deleteOneFlower'"/>
</form>
					
				</div>
			</s:iterator>
		
		
			</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
  </body>
</html>
