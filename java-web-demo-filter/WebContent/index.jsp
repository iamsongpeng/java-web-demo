<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>首页</h2>
	<h3><a href="${pageContext.request.contextPath }/hello">访问servlet</a></h3>
	<h3><a href="${pageContext.request.contextPath }/demo01/lifecycle.jsp">测试 Filter 生命周期</a></h3>
	<h3><a href="${pageContext.request.contextPath }/demo01/encoding.jsp">应用一：统一全站字符编码过滤器</a></h3>
	<h3><a href="${pageContext.request.contextPath }/demo02/index.jsp">自动登录案例</a></h3>
</body>
</html>