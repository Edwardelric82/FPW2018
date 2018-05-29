<%-- 
    Document   : searchAjax
    Created on : 29-mag-2018, 12.14.06
    Author     : Sary
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%> 
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<json:array>
    <c:forEach var="news" items="${newsList}">
        <json:object>
            <json:property name="id" value="${news.getId()}"/> 
            <json:property name="titolo" value="${news.getTitolo()}"/>
            <json:property name="content" value="${news.getContent()}"/> 
        </json:object>
    </c:forEach>
</json:array>