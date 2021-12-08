<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>update Emp</title>
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
                update Emp info:
            </h1>
            <form action="${pageContext.request.contextPath}/emp/updateEmp" method="post">
                <c:if test="${not empty emp}">
                    <table cellpadding="0" cellspacing="0" border="0"
                           class="form_table">
                        <tr>
                            <td valign="middle" align="right">
                                id:
                            </td>
                            <td valign="middle" align="left">
                                    ${emp.id}
                                <input type="hidden" name="id" value="${emp.id}"/>
                            </td>
                        </tr>
                        <tr>
                            <td valign="middle" align="right">
                                name:
                                <input value="${emp.name}" name="name"/>
                            </td>

                        </tr>
                        <tr>
                            <td valign="middle" align="right">
                                age:
                                <input value="${emp.age}" name="age"/>
                            </td>

                        </tr>
                        <tr>
                            <td valign="middle" align="right">
                                bir:
                                <fmt:formatDate value="${emp.bir}" var="date" pattern="yyyy/MM/dd"/>
                                <input value="${date}" name="bir" id="bir"/>
                            </td>

                        </tr>
                    </table>
                </c:if>
                <p>
                    <input type="submit" class="button" value="Confirm" onclick="return biroo()"/>
                </p>
                <p>
                    <input type="button" class="button" value="Return" onclick="location='${pageContext.request.contextPath}/user/empFindAll'"/>
                </p>
            </form>
        </div>
    </div>

    <%@include file="publicFoot.jsp" %>
</div>

<script>

    function biroo() {
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
