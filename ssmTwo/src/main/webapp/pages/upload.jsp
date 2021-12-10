
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h1>文件上传</h1>
<form action="${pageContext.request.contextPath}/pages/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="img"/>
    <input type="file" name="img"/>
    <input type="file" name="img"/>
    <input type="submit" value="上传文件"/>
</form>

<div>
    <h2>文件打开/下载</h2>
    <li>
        <span>aa.txt</span>
        <br/>
        <a href="${pageContext.request.contextPath}/pages/download?fileName=aa.txt">点我打开</a>
  <br/>
        <a href="${pageContext.request.contextPath}/pages/download?fileName=aa.txt&openStyle=1">点我下载</a>
    </li>
</div>

</body>
</html>
