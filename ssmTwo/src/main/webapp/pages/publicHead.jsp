<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.*,java.util.*" %>

<%
request.setAttribute("date",new Date());
%>

<div id="header">
    <div id="rightheader">
        <c:if test="${not empty requestScope.date}">
<fmt:formatDate value="${requestScope.date}" pattern="yyyy年MM月dd日" var="dates"/>
        <p>
            ${dates}
            <br />
        </p>

        </c:if>
    </div>
    <div id="topheader">
        <h1 id="title">
            <a href="#">main</a>
        </h1>
    </div>
    <div id="navigation">
    </div>
</div>