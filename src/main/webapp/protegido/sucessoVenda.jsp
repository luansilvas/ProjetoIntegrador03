<%-- 
    Document   : sucessoVenda
    Created on : 25/10/2020, 22:48:04
    Author     : eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="menu.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="margin: 4%;">
        <h1>Sua operação foi feita com sucesso!</h1>
        <div class="acoes" style="margin-left: 30%;margin-top: 5%;">


            <a class="waves-effect waves-light btn" href="<c:url value="/Loja"/>"><i class="material-icons left">arrow_back</i>Loja</a>
            <a class="waves-effect waves-light btn" href="<c:url value="index.jsp"/>"><i class="material-icons right">home</i>Página Inicial</a>
        </div>
        </div>
    </body>
</html>
