<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>emplist</title>
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
                Welcome!
            </h1>

            <table class="table">
                <c:if test="${not empty empList}">
                    <tr class="table_header">
                        <td>
                            ID
                        </td>
                        <td>
                            Name
                        </td>
                        <td>
                            Age
                        </td>
                        <td>
                            Bir
                        </td>
                        <td>
                            Data
                        </td>
                    </tr>
                    <c:forEach items="${empList}" var="empLists" varStatus="hp">

                        <c:if test="${hp.index %2 ne 0}">
                            <tr style="background-color: #eb8c66;
                            ">
                        </c:if>

                        <c:if test="${hp.index %2 eq 0 }">
                            <tr style="background-color: #6f6c61">
                        </c:if>

                        <td>
                                ${empLists.id}
                        </td>
                        <td>
                                ${empLists.name}
                        </td>
                        <td>
                                ${empLists.age}
                        </td>
                        <td>
                            <fmt:formatDate value="${empLists.bir}" pattern="yyyy年MM月dd日"/>
                        </td>
                        <td >
                            <a href="${pageContext.request.contextPath}/pages/delete?id=${empLists.id}" onclick="return boos()" style="color:#c11d43;">delete emp</a>&nbsp;
                            <a href="${pageContext.request.contextPath}/pages/update?id=${empLists.id}" style="color:#c11d43;">update emp</a>
                        </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>


            <p>
                <input type="button" class="button" value="Add Employee"
                       onclick="location='${pageContext.request.contextPath}/pages/addEmps'"/>
            </p>
            <p>
                <input type="button" class="button" value="return" onclick="location='${pageContext.request.contextPath}/pages/login'"/>
            </p>
        </div>
    </div>


    <%@ include file="publicFoot.jsp" %>

</div>
<script>
    function boos() {
        var one = confirm("确认删除?")
        if (one == true) {
            return true
        } else {
            return false
        }
    }
</script>

</body>
</html>