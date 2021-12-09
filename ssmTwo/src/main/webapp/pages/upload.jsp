<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>T文件上传</title>
</head>
<body>
<h1>文件上传</h1>
<form action="${pageContext.request.contextPath}/pages/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="img"/>
    <input type="file" name="img"/>
    <input type="file" name="img"/>
    <input type="submit" value="上传文件"/>
</form>
<h1>文件下载</h1>
<li>aa.txt</li>
<a href="${pageContext.request.contextPath}/pages/download?fileName=aa.txt">在线打开</a>
<br/>
<a href="${pageContext.request.contextPath}/pages/download?fileName=aa.txt&&openStyle=1">附件下载</a>
</body>
</html>
