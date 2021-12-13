<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>update Emp</title>
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
                update Emp info:
            </h1>
            <form action="${pageContext.request.contextPath}/pages/update" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">

                    <c:if test="${not empty emps}">

                    <tr>
                        <td valign="middle" align="right">
                            id:
                        </td>
                        <td valign="middle" align="left">
                            ${emps.id}
                            <input type="hidden" value="${emps.id}" name="id"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            name:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="name" value="${emps.name}" required="required"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            age:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="age" value="${emps.age}" required="required"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            bir:
                        </td>
                        <td valign="middle" align="left">
                            <fmt:formatDate value="${emps.bir}" pattern="yyyy/MM/dd" var="bir"/>
                            <input type="text" class="inputgri" name="bir" id="bir" value="${bir}"/>
                        </td>
                    </tr>

                    </c:if>
                </table>
                <p>
                    <input type="submit" class="button" value="Confirm" onclick="return goos()"/>
                </p>
                <p>
                    <input type="button" class="button" value="return" onclick="location='${pageContext.request.contextPath}/pages/findAll'"/>
                </p>
            </form>
        </div>
    </div>

    <%@ include file="publicFoot.jsp" %>


</div>

<script>
    function goos() {
        var reg = /^(\d{4})[/](\d{2})[/](\d{2})$/;
        var str1 = document.getElementById("bir").value;
        var arr = reg.exec(str1);

        if (str1 == "") {
            alert("请输入日期");
            return false;
        } else if (!reg.test(str1) && RegExp.$2 <= 12 && RegExp.$3 <= 31) {
            alert("请保证输入的为yyyy/mm/dd日期格式");
            return false;
        } else {
            return true;
        }
    }

</script>

</body>
</html>
