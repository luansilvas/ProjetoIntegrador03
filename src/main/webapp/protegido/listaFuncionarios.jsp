<%-- 
    Document   : listaFuncionarios
    Created on : 30/11/2020, 12:28:54
    Author     : luans
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
            <a class="btn-flat"  id="adicionar" href="protegido/cadastrarFuncionario.jsp">add<i class="material-icons right">add</i></a>
            <table class="striped">
                <thead style="text-align: left"> 
                <th>Nome</th>
                <th>Matricula</th>
                <th>E-mail</th>
                <th>Telefone</th>
                <th>Ações</th>
                </thead>
                <tbody>
                    <c:forEach items="${funcionarios}" var="c">
                        <tr style="text-align: center">
                            <td>${c.nome}</td>
                            <td>${c.codFuncionario}</td>
                            <td>${c.email}</td>
                            <td>${c.celular}</td>
                            <td>
                                <a href="<c:url value="/verFuncionario?codFuncionario=${c.codFuncionario}"/>"><i class="material-icons">search</i></a>
                                <a href="<c:url value="/AlterarFuncionario?codFuncionario=${c.codFuncionario}"/>"><i class="material-icons">edit</i></a>
                                <a href="<c:url value="/ExcluirFuncionario?codFuncionario=${c.codFuncionario}"/>"><i class="material-icons">delete</i></a>
                            </td>
                        </tr>
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
