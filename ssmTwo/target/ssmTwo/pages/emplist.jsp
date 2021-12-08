<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Bootstrap 101 Template</title>


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">


    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
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
                Welcome!
            </h1>
            <table class="table table-bordered" style="position: relative;top: 0px;background-color: #eeeeee">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        Name
                    </td>
                    <td>
                        age
                    </td>
                    <td>
                        bir
                    </td>
                    <td>
                        data
                    </td>
                </tr>

                <c:if test="${not empty empList}">
                    <c:forEach items="${empList}" var="list" varStatus="hp">

                        <c:if test="${hp.index%2 ne 0}">

                            <tr style="background-color: #fededc8f">
                                <td>
                                    <input type="hidden" id="idoo" value="${list.id}"/>
                                        ${list.id}
                                </td>
                                <td>
                                        ${list.name}
                                </td>
                                <td>
                                        ${list.age}
                                </td>
                                <td>
                                    <fmt:formatDate value="${list.bir}" pattern="yyyy年MM月dd日"/>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/emp/delete?id=${list.id}"
                                       onclick="return del()">delete emp</a>
                                    &nbsp;<a
                                        href="${pageContext.request.contextPath}/emp/updateEmp?id=${list.id}">update
                                    emp</a>
                                </td>
                            </tr>
                        </c:if>
                        <c:if test="${hp.index%2 eq 0}">
                            <tr  style="background: #0ad7ed2b;">
                                <td>
                                    <input type="hidden" id="idoo" value="${list.id}"/>
                                        ${list.id}
                                </td>
                                <td>
                                        ${list.name}
                                </td>
                                <td>
                                        ${list.age}
                                </td>
                                <td>
                                    <fmt:formatDate value="${list.bir}" pattern="yyyy年MM月dd日"/>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/emp/delete?id=${list.id}"
                                       onclick="return del()">delete emp</a>
                                    &nbsp;<a
                                        href="${pageContext.request.contextPath}/emp/updateEmp?id=${list.id}">update emp</a>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </c:if>
            </table>
            <p>
                <%--                onclick="location= 默认get 没有post--%>
                <input type="button" class="button" value="Add Employee"
                       onclick="location='${pageContext.request.contextPath}/emp/addEmp'"/>
            </p>
            <p>
                <%--                onclick="location= 默认get 没有post--%>
                <input type="button" class="button" value="Return"
                       onclick="location='${pageContext.request.contextPath}/pages/login'" style="position: relative;right: -115px;top: -42px;" />
            </p>
        </div>
    </div>

    <%@include file="publicFoot.jsp" %>


</div>


<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"
        integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ"
        crossorigin="anonymous"></script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
        integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
        crossorigin="anonymous"></script>
</body>

<script>
    function del() {
        var idoo = document.getElementById("idoo").value;
        var on = confirm("是否删除该用户?");
        if (on == true) {
            return true;
        } else {
            return false;
        }
    }
</script>