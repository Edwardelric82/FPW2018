<%-- 
    Document   : utente
    Created on : 10-apr-2018, 11.18.57
    Author     : Sary
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Il tuo profilo</title>
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
               
            <h3>Il tuo profilo:</h3>
            <section>
                <h4>Le tue informazioni personali</h4>
                <ul>
                    <li>${name} ${surname}</li>
                    <li>${email}</li>
                    <li>PhD student Computer Science</li>
                </ul>
            </section>
            <hr>
            <section>
                <h6> Ultimi post </h6>
                <table>
                    <tr class="headerrow">                    
                        <th>
                        Post:
                        </th>
                        <th>
                        Data:
                        </th>
                    </tr>

                    <tr>
                        <td>
                            Buffon ride
                        </td>
                        <td>
                            30/01/2018 
                        </td>
                    </tr>
                    
                    <tr class="evenrow"> <!-- Riga pari-->
                        <td>
                            Le hits dell'estate 2017
                        </td>
                        <td>
                            30/06/2017
                        </td>
                    </tr>
                    
                    <tr>
                        <td>
                            Nuova news esclusiva!!
                        </td>
                        <td>
                            30/01/2018 
                        </td>
                    </tr>
                    <tr class="evenrow"> <!-- Riga pari-->
                        <td>
                            Ultimissima news di martedi 20 Marzo!
                        </td>
                        <td>
                            20/03/2018 
                        </td>
                    </tr>
                </table>
                <hr>
            </section>
            </div>
        </article>
        <footer>Sito realizzato da Sara Casti</footer>
    </body>
</html>
