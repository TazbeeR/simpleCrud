<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<a href="/user/add">ADD</a><br />

<c:forEach items="${users}" var="user">
    <br/>
    --------------------------------
    <br/>
    ${user.firstName}<br/>
    ${user.lastName}<br/>
    ${user.email}<br/>
    <br/>
    <a href="update/${user.id}">Edytuj </a>
    <a href="delete/${user.id}">Usuń </a>
    <br/>
    --------------------------------
    <br/>
</c:forEach>