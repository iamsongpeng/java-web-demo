<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>应用一：统一全站字符编码过滤器</h2>
	<form action="${pageContext.request.contextPath }/encoding" method="post">
		请输入您的姓名: <input type="text" name="name">
		<button type="submit">提交</button>
	</form>
</body>
</html>