<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>目录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>



	<s:iterator value="#request.catalogs" id="catalog">
	<!-- 强制设置为第一页  currentPage=1                          #catalog[0]：Object对象方式获取                           target="_slft"在新页面中打开-->
	<%--<a href="browseFlowerPaging.action?catalogid=<s:property value="#catalog[0]"/>&currentPage=1" ><s:property value="#catalog[1]"/></a>   
     --%>
     
     <a href="browseFlowerPaging.action?catalogid=<s:property value="#catalog.catalogid"/>&currentPage=1" ><s:property value="#catalog.catalogname"/></a>   <br><br>
	</s:iterator>
</body>
</html>
