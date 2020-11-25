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
        <h1 style="text-align: center">Verifique se as informações estão corretas ou se o carrinho possui algum item.</h1>
        <div class="acoes" style="margin-left: 30%;margin-top: 5%;">


            <a class="waves-effect waves-light btn" href="FecharPedido"><i class="material-icons left">arrow_back</i>Tentar novamente</a>
            <a class="waves-effect waves-light btn" href="CancelarProdutoVenda"><i class="material-icons right">home</i>Nova venda</a>
        </div>
        </div>
    </body>
</html>
