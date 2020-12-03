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
                <a class="btn-flat"  id="loja" href="<c:url value="/Loja"/>">continuar<i class="material-icons left">shopping_cart</i></a>

                <a class="btn-flat"  id="adicionar" href="<c:url value="/CancelarProdutoVenda"/>">cancelar<i class="material-icons right">arrow_back</i></a>
                <table class="striped">
                    <thead style="text-align: left">
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
                                    <a href="<c:url value="/ExcluirProdutoVenda?codProdutoVenda=${produto.codProdutoVenda}"/>"><i class="material-icons">remove_shopping_cart</i></a>
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
                <a class="btn-flat"  id="adicionar" href="<c:url value="/ListarCliente"/>" target="blank">ver clientes<i class="material-icons right">person</i></a>

                <a class="btn-flat"  id="adicionar" href="<c:url value="/CadastrarCliente"/>" target="blank">novo cliente<i class="material-icons right">person_add</i></a>
                <form class="col s12" action="<c:url value="/RegistrarVenda"/>" method="POST">
                    <div class="row">


                        <div class="input-field col s3">
                            <input id="cpf" type="text" class="validate" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" name="cpf" required>
                            <label for="cpf">CPF cliente</label>

                        </div>

                    </div>
                    <button class="btn waves-effect waves-light" type="submit" id="adicionar">Fechar
                        <i class="material-icons right">arrow_forward_ios</i>
                    </button>
                </form>
            </div>
        </c:if>
        <c:if test="${listaProdutoVenda==null}">

            <h1>Seu carrinho está vazio!</h1>
        </c:if>




















        <script>


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











































