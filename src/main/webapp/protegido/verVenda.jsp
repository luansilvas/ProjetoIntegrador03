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


        <c:if test="${listaProdutoVenda != null}">
            <div class="tabela">

               
                <table class="striped">
                    <thead style="text-align: left">
                        <h1>Produtos da venda<h1>
                        <tr>
                            <th>Controle</th>
                            <th>Código Produto</th>
                            <th>Titulo</th>
                            <th>Valor</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody> 

                        <c:forEach var="produto" items="${listaProdutoVenda}">
                            <tr style="text-align: center">
                                <td>${produto.codProdutoVenda}</td>
                                <td>${produto.codProduto}</td>
                                <td>${produto.titulo}</td>
                                <td class="valorproduto">${produto.valor}</td>

                                <td>
                                    <a href="<c:url value="/verProduto?codProduto=${produto.codProduto}"/>" target="blank"><i class="material-icons">search</i></a>                                 
                                </td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>Total:</td>
                            <td id="total"></td>
                        </tr>
                    </tbody>

                </table>
                            <a class="waves-effect waves-light btn" href="<c:url value="/ListarVendas"/>"> <i class="material-icons left">arrow_back</i>Vendas</a>

            </div>
        </c:if>
        <c:if test="${listaProdutoVenda==null}">

            <h1>Seu carrinho está vazio!</h1>
        </c:if>




















        <script>

            function excluir(codProduto) {
                retorno = confirm("Você deseja realmente excluir esse produto da sua venda?");
                if (retorno == true) {

                    var destino = "ExcluirProdutoVenda?codProdutoVenda=";
                    var tudo = destino + codProduto;
                    window.location.href = tudo;

                }
            }

            $(function () {

                var valorCalculado = 0;

                $(".valorproduto").each(function () {
                    valorCalculado += parseInt($(this).text());
                });
                $("#total").text(valorCalculado);

            });





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











































