<%-- 
    Document   : listaCliente
    Created on : 21/10/2020, 20:26:28
    Author     : Gustavo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="menu.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    </head>
    <body>

        <div class="tabela">
            <a class="btn-flat"  id="adicionar" href="CadastrarCliente.jsp">add<i class="material-icons right">add</i></a>
            <table class="striped">
                <thead style="text-align: left">
                <th>Nome</th>
                <th>CPF</th>
                <th>E-mail</th>
                <th>Telefone</th>         
                </thead>
                <tbody>
                    <c:forEach items="${listaClientes}" var="c">
                    <th style="text-align: center">
                    <td>${c.nome}</td>
                    <td>${c.cpf}</td>
                    <td>${c.email}</td>
                    <td>${c.telefone}</td>
                    <td>
                        <a href="verProduto?codProduto=${produto.codProduto}"><i class="material-icons">search</i></a>
                        <a href="AlterarProduto?codProduto=${produto.codProduto}" ><i class="material-icons">edit</i></a>
                        <a onClick="excluir(${produto.codProduto})"><i class="material-icons">delete</i></a>
                    </td>
                    </th>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
    <style>
        .botao{
            padding: 0px;

        }

        .side-nav li
        a {
            padding: 0 20px;

        }

        .row {
            margin-bottom: 0;

        }
        .social-icons {
        }
        a {
            opacity: 1;
            &:hover {
                background-color:inherit;
                opacity: 1;
            }
        }
        tr td,tr th{
            text-align: center            

        }
        .tabela{
            margin:6%;

        }
        #adicionar{
            margin-left: 82%;
            height: 30px;

            border-radius: 5%;
        }



    </style>



    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
</html>
