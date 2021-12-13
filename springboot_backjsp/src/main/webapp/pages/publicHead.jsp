<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"
import="java.util.*,com.hxzyyn.entity.*" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%--<%--%>
<%--request.setAttribute("date",new Date());--%>
<%--%>--%>
<div id="header">
    <div id="rightheader">
        <p>
            <fmt:formatDate value="<%=new Date()%>" pattern="yyyy年MM月dd日"/>
            <br />
        </p>
    </div>
    <div id="topheader">
        <h1 id="title">
            <a href="#">main</a>
        </h1>
    </div>
    <div id="navigation">
    </div>
</div>