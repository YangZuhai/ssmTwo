<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="publicCss.jsp" %>

</head>

<body>
<div id="wrap">
    <div id="top_content">

        <%@ include file="publicHead.jsp" %>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                login
            </h1>
            <form action="${pageContext.request.contextPath}/pages/login" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            username:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="username" required="required"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            password:
                        </td>
                        <td valign="middle" align="left">
                            <input type="password" class="inputgri" name="password" required="required"/>
                        </td>
                    </tr>
                </table>
                <p>
                    <input type="submit" class="button" value="Submit &raquo;"/>
                    <input type="button" class="button"
                           onclick="location.href='${pageContext.request.contextPath}/pages/regist'"
                           value="Regist &raquo;"/>
                </p>
            </form>
        </div>
    </div>

    <%@ include file="publicFoot.jsp" %>


</div>
</body>
</html>
