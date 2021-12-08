<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>regist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <%@include file="publicCss.jsp" %>

</head>
<body>
<div id="wrap">
    <div id="top_content">

        <%@include file="publicHead.jsp" %>


        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                注册
            </h1>
            <form action="${pageContext.request.contextPath}/pages/regist" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            用户名:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="username" required="required"/>
                        </td>
                    </tr>

                    <tr>
                        <td valign="middle" align="right">
                            密码:
                        </td>
                        <td valign="middle" align="left">
                            <input type="password" class="inputgri" name="password" required="required"/>
                        </td>
                    </tr>

                </table>
                <p>
                    <input type="submit" class="button" value="Submit &raquo;"/>
                </p>
                <p>
                    <input type="button" class="button" value="return &raquo;"
                           onclick="location='${pageContext.request.contextPath}/pages/login'"/>
                </p>
            </form>
        </div>
    </div>

    <%@include file="publicFoot.jsp" %>


</div>
</body>
</html>
