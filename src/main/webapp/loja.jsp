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
        <div class="row" id="formulario">

            <form class="col s12" action="Loja" method="POST">

                <div class="select-field col s4">
                    <label>unidade</label>
                    <select class="browser-default" id = "unidade" name="codUnidade" required>
                        <option value="" disabled selected>Unidade</option>
                        <option value="1">Matriz</option>
                        <option value="2">Campina Grande</option>                           
                        <option value="3">Brasília</option>
                        <option value="4">Joinville</option>

                    </select>
                </div>




        </div>
        <button class="btn waves-effect waves-light" type="submit" id="adicionar">Buscar
            <i class="material-icons right">search</i>
        </button>
    </form>
    <div class="tabela">
        <a class="btn-flat"  id="adicionar" href="CancelarProdutoVenda">Limpar<i class="material-icons right">remove_shopping_cart</i></a>
        <a class="btn-flat"  id="adicionar" href="FecharPedido">Retirada<i class="material-icons right">shopping_bag</i></a>
        <div class="col s12 m12 l9">
            <div  class="row">

                <!-- Card 1 -->
                <c:forEach var="produto" items="${listaProdutos}">
                    <div class="col s12 m6 l4">
                        <div class="card">
                            <div class="card-image waves-effect waves-block waves-light">
                                <img class="activator" src="">
                            </div>
                            <div class="card-content">
                                <span class="card-title activator grey-text text-darken-4">${produto.codProduto}. ${produto.titulo}<i class="material-icons right">more_vert</i></span>
                                <p>R$<b style="color:lightgreen">${produto.valor}</b></p>
                                <p>Disponíveis: ${produto.quantidade} </p>
                            </div>
                            <div class="card-action">
                                <a href="ComprarProduto?codProduto=${produto.codProduto}&valor=${produto.valor}" style="text-align: center;position: relative">Comprar esse item</a>
                                <a href="InsereProdutoVenda?codProduto=${produto.codProduto}&valor=${produto.valor}" style="text-align: center;position: relative">Adicionar ao carrinho</a>

                            </div>
                            <div class="card-reveal">
                                <span class="card-title grey-text text-darken-4">${produto.codProduto}. ${produto.titulo}<i class="material-icons right">close</i></span>
                                <p>${produto.descricao}</p>
                            </div>
                        </div>
                    </div>

                </c:forEach>


            </div>
        </div>
    </div>








    <script>

        function excluir(codProduto) {
            retorno = confirm("Você deseja realmente excluir esse produto?");
            if (retorno == true) {

                var destino = "ExcluirProduto?codProduto=";
                var tudo = destino + codProduto;
                window.location.href = tudo;

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











































