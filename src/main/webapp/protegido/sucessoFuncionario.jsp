<%-- 
    Document   : sucessoFuncionário
    Created on : 01/12/2020, 21:55:36
    Author     : luans
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="menu.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro concluido</title>
    </head>
    <body>
        <div style="margin: 4%;">
            <h1>Sua operação foi feita com sucesso!</h1>
            <div class="acoes" style="margin-left: 30%;margin-top: 5%;">
                <a class="waves-effect waves-light btn" href="<c:url value="/ListarFuncionario"/>"><i class="material-icons left">arrow_back</i>Lista de Funcionários</a>
                <a class="waves-effect waves-light btn" href="index.jsp"><i class="material-icons right">home</i>Página Inicial</a>
            </div>
        </div>
    </body>
</html>

