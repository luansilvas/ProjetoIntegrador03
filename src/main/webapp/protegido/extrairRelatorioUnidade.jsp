<%-- 
    Document   : extrairRelatorio
    Created on : 25/10/2020, 14:51:55
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





    <div class="tabela">
        <h5>Visões</h5>

        <div class="row" id="links">
            <div class="col s12">
                <div class="select-field col s3"><a class="btn-flat"  id="" href="<c:url value="/ListarVendas"/>">geral<i class="material-icons right"></i></a></div>
                        <c:if  test="${sessionScope.usuario.codUnidade eq 1}">
                    <div class="select-field col s3"><a class="btn-flat"  id=""href="<c:url value="/ListarVendasUnidade"/>">unidade<i class="material-icons right"></i></a></div>
                        </c:if>
                <div class="select-field col s3"><a class="btn-flat"  id="" href="<c:url value="/ListarVendasCliente"/>">Cliente<i class="material-icons right"></i></a></div>
                <div class="select-field col s3"><a class="btn-flat"  id="" href="<c:url value="/ListarVendasCategoria"/>">Categoria<i class="material-icons right"></i></a></div>
            </div>
        </div>

        <h1>Relatório geral - Unidade</h1>
        <div class="row" id="formulario">

            <form class="col s12" action="<c:url value="/ListarVendasUnidade"/>" method="POST">

                <div class="select-field col s4">
                    <label>unidade</label>
                    <select class="browser-default" id = "unidade" name="codUnidade" style="border:none" required>
                        <option value="${sessionScope.usuario.codUnidade}" selected>Unidade</option>
                        <c:if  test="${sessionScope.usuario.codUnidade eq 1}">
                            <option value="1">Matriz</option>
                            <option value="2">Campina Grande</option>                           
                            <option value="3">Brasília</option>
                            <option value="4">Joinville</option>
                            <option value="5">Geral</option>
                        </c:if>
                    </select>
                </div>

                <div class="input-field col s4">
                    <input id="dia" type="date" class="validate" name="dia" required>

                </div>
        </div>
        <button class="btn waves-effect waves-light" type="submit" id="adicionar">Buscar
            <i class="material-icons right">search</i>
        </button>
    </form>
    <table class="striped">
        <thead style="text-align: left">
            <tr>
                <th>Transação</th>
                <th>Valor item</th>
                <th>CPF cliente</th>
                <th>data e hora</th>
                <th>Categoria</th>
                <th>Ver venda completa</th>
            </tr>
        </thead>
        <tbody> 

            <c:forEach var="venda" items="${listaVendas}">
                <tr style="text-align: center">
                    <td>${venda.codVenda}</td>
                    <td class="valorproduto">${venda.total}</td>
                    <td>${venda.CPF}</td>
                    <td>${venda.datahora}</td>
                    <td>${venda.produto_categoria}</td>

                    <td>
                        <a href="verVenda?codVenda=${venda.codVenda}" about="blank"><i class="material-icons">search</i></a>
                       <!-- <a href="AlterarProduto?codProduto=${produto.codProduto}" ><i class="material-icons">edit</i></a>
                        <a onClick="excluir(${produto.codProduto})"><i class="material-icons">delete</i></a>-->
                    </td>

                </tr>
            </c:forEach>
        <td>Total:</td>
        <td id="total"></td>

        </tbody>

    </table>

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

