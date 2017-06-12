<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>上传文件</h2>
	<!-- 1 表单必须是 method="post" -->
	<!-- 2 表单项必须有 name 属性 -->
	<!-- 3 form 标签增加 enctype="multipart/form-data" -->
	<form enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath }/simpleUpload">
		文件描述： <input type="text" name="description"><br/>
		文件上传：<input type="file" name="upload"><br/>
		<input type="submit" value="上传">
		<!-- 上传后在 eclipse 控制台查看上传结果！ -->
	</form>
</body>
</html>