<%-- 
    Document   : login
    Created on : 24-apr-2018, 15.11.23
    Author     : Sary
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Homepage</title>
        <meta charset="UTF-8">
        <meta name="author" content="Sara Casti">
        <meta name="keywords" content="html, css, java, webapplication">
        <meta name="description" content="Images, tables and forms">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style1.css" media="screen">
        
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <hr>
        <jsp:include page="navbar.jsp" />
        <article>
            <div class="left-box">
            
            <h3>Lista ultime news</h3> 
            <ol>
                <li>Scandalo Facebook</li>
                <li>Pirati della strada investono bambino</li>
                <li>Nuovo samsung galaxy s9</li>
            </ol>
            <hr>
            <h3>
                Lista delle principali categorie
            </h3>
            <ol>
                <li>
                    Sport
                    <ol>
                        <li>Basket</li>
                        <li>Tennis</li>
                        <li>Calcio</li>
                    </ol>
                </li>
                <li>Musica</li>
                <li>Politica</li>
            </ol>
        </div>
        <div class="main-box">
            
            <h3>Login:</h3>
            
            <c:if test="${invalidData == true}">
                <p> Dati errati </p>
            </c:if>
            
            <form action="Login" method="post">
                <div>
                    <label for="userName">Email</label>
                    <input type="text" name="email" id="userName">
                </div>
                <div>
                    <label for="userPass">Password</label>
                    <input type="password" name="password" id="userPass">
                </div>
                <button type="submit">Invia</button>
            </form>
            
            <hr>
        </div>
        </article>
        <footer>Sito realizzato da Sara Casti! PhD Student at University of Cagliari</footer>
    </body>
</html>


