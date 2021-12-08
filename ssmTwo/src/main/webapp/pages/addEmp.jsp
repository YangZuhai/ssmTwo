<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>add Emp</title>
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
                add Emp info:
            </h1>
            <form action="${pageContext.request.contextPath}/emp/addEmp" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            name:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="name" required="required"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            age:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="age" required="required"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            bir:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="bir" id="bir"/>
                            <span style="color:red">*生日格式必须是yyyy/MM/dd</span>
                        </td>
                    </tr>
                </table>
                <p>
                    <input type="submit" class="button" value="Confirm" onclick="return biroo()"/>
                </p>
                <p>
                    <input type="button" class="button" value="Return"
                           onclick="location='${pageContext.request.contextPath}/user/empFindAll'"/>
                </p>
            </form>
        </div>
    </div>

    <%@include file="publicFoot.jsp" %>


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
</div>
</body>


</html>
