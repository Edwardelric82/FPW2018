<%-- 
    Document   : navbar
    Created on : 10-apr-2018, 11.30.44
    Author     : Sary
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav>
    <h3>Le pagine del sito</h3>
    <div id="div-search">
        <input type="text" id="search" name="search" value="Cerca..">
    </div>

    <div id="div-nav">
        <ul class="navbar">
            <li><a href="Index">Home</a></li>
            <!-- Controlla se l'utente è loggato visualizza un menu differente a seconda che l'utnte sia loggato oppure no -->
            <c:if test="${isLogged == false}">
                <li><a href="signup.html">Registrati</a></li>
                <li><a href='Login'>Login</a></li>
            </c:if>
            <c:if test="${isLogged == true}">
                <li><a href="User">Profilo</a></li>
                <li><a href="Login?logout=1">Logout</a></li>
            </c:if>
        </ul>
    </div>
</nav> 
