<%-- 
    Document   : listarVenda
    Created on : 25/10/2020, 22:49:39
    Author     : eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
     <%@include file="menu.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Vendas</title>

        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/icon?family=Material+Icons">

    </head>





    <body>
        <!--Barra de navegação e menu -->



        <div class="tabela">

            <a class="btn-flat"  id="adicionar" href="cadastrarVenda.jsp">add<i class="material-icons right">add</i></a>
            <table class="striped">
                <thead style="text-align: left">
                    <tr>
                        <th>Código</th>
                        <th>Data da Venda</th>
                        <th>Valor Total</th>
                        
                    </tr>
                </thead>
                <tbody> 

                    <c:forEach var="venda" items="${listaVendas}">
                        <tr style="text-align: center">
                            <td>${venda.codVenda}</td>
                            <td>${venda.diahora}</td>
                            <td>${venda.total}</td>
                            <td>${produto.valor}</td>
                            <td>
                                <a href="verVenda?codVenda=${venda.codVenda}"><i class="material-icons">search</i></a>
                            </td>

                        </tr>
                    </c:forEach>

                </tbody>

            </table>

        </div>

    
    
    
    
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
