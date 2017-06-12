<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>多文件上传</title>
<script type="text/javascript">
	
	// 实现方式1：innerHTML，此种实现方式有逻辑问题，如下：
	// appendChild是每次插入的内容都成为该元素的最后一个子元素。（插入）
	// innerHTML是整个重写该元素内的所有HTML代码，也就是说之前写的那些都会被覆盖。（覆盖）
	// 增加
	function addItem() {
		var uploadDiv = document.getElementById("uploadDiv");
		uploadDiv.innerHTML += '<div><input type="file" name="uploadfile"><a href="javascript:void(0)" onclick="delItem(this)">删除</a></div>';
	}
	 
	// 实现方式2：appendChild 和 createElement
	function addItem() {
		// 1 创建一个div <div></div>
		var _div = document.createElement("div");
		// 3 创建input标签 <input/> <input type="file" name="upload"/>
		var _input = document.createElement("input");
		// 3.1 增加type属性
		_input.setAttribute("type", "file");
		// 3.2 增加name属性
		_input.setAttribute("name", "upload");
		// 4 将input标签追加到 新的div中 <div><input/></div>
		_div.appendChild(_input);
		// 5 创建a标签 <a></a>
		// <a href="javascript:void(0)" onclick="_delItem(this)">删除</a>
		var _a = document.createElement("a");
		// 5.1 增加href属性
		_a.setAttribute("href", "javascript:void(0)");
		// 5.2 增加onclick属性
		_a.setAttribute("onclick", "_delItem(this)");
		// 5.3 增加内容
		_a.innerHTML = "删除";
		// 6 将a标签追加到 新的div中,  <div><input/><a></a></div>
		_div.appendChild(_a);
		// 2 将新的div 追加到 <div id="uploadDiv"></div>中
		document.getElementById("uploadDiv").appendChild(_div);
	}
	
	// 删除
	function _delItem(_a){
		// 获取要删除的div
		var _div = _a.parentNode;
		// 删除: 被删除的标签对象.父标签.removeChild(被删除的标签对象)
		_div.parentNode.removeChild(_div);
	}
</script>
</head>
<body>
	<h2>多文件上传</h2>
	<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/uploadFiles">
		<input type="button" value="添加附件" onclick="addItem()">
		<div id="uploadDiv">
		</div>
		<input type="submit" value="开始上传">
	</form>
</body>
</html>