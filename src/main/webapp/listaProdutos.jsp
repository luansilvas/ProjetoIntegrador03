<%-- 
    Document   : listaProdutos
    Created on : 15/10/2020, 17:38:51
    Author     : luans
--%>
<%-- 
    Document   : listaProdutos
    Created on : 15/10/2020, 17:38:51
    Author     : luans
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="menu.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter produtos</title>

        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/icon?family=Material+Icons">

    </head>





    <body>
        <!--Barra de navegação e menu -->



        <div class="tabela">

            <a class="btn-flat"  id="adicionar" href="cadastrarProduto.jsp">add<i class="material-icons right">add</i></a>
            <table class="striped">
                <thead style="text-align: left">
                    <tr>
                        <th>foto</th>
                        <th>foto</th>
                        <th>Titulo</th>
                        <th>Valor</th>
                        <th>quantidade</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody> 

                    <c:forEach var="produto" items="${listaProdutos}">
                        <tr style="text-align: center">
                            <td>${produto.codProduto}</td>
                            <td>${produto.foto}</td>
                            <td>${produto.titulo}</td>
                            <td>${produto.valor}</td>
                            <td>${produto.quantidade}</td>
                            <td>
                                <a href="verProduto?codProduto=${produto.codProduto}"><i class="material-icons">search</i></a>
                                <a href="AlterarProduto?codProduto=${produto.codProduto}" ><i class="material-icons">edit</i></a>
                                <a onClick="excluir(${produto.codProduto})"><i class="material-icons">delete</i></a>
                            </td>

                        </tr>
                    </c:forEach>

                </tbody>

            </table>

        </div>








        <script>

            function excluir(codProduto) {
                retorno = confirm("Você deseja realmente excluir esse produto?");
                if (retorno == true) {

                var destino = "ExcluirProduto?codProduto=";
                var tudo = destino+codProduto;
                window.location.href=tudo;

                }
            }
        </script>
    </body>
    <style>
        .botao{
            padding: 0px;

        }

        img{
            width: 160%;

        }
        .side-nav li
        a {
            padding: 0 16px;

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
            margin:5%;

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











































