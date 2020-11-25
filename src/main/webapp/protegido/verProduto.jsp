<%-- 
    Document   : verProduto
    Created on : 18/10/2020, 12:56:51
    Author     : luans
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

        <div class="row" id="formulario">
           
                <div class="row">
                    <div class="input-field col s4">
                        <input type="text"value="${produto.titulo}" readonly="true">
                        <label for="titulo">Título</label>
                    </div>
                    <div class="input-field col s4">
                        <input type="text"  value="${produto.valor}" readonly="true">
                        <label for="valor">Valor</label>
                    </div>
                    <div class="input-field col s4">
                        <input type="number" value="${produto.quantidade}" readonly="true">
                        <label for="quantidade">Quantidade</label>
                    </div>
                </div>

                <div class="row" style="margin-left:25%">
                    <div class="select-field col s4">
                        <label>Categoria</label>
                        <select class="browser-default" id="categoria" name="categoria" readonly="true"> 
                            <option value="" disabled selected>${produto.categoria}</option>
                            
                        </select>


                    </div>
                    <div class="select-field col s4">
                        <label>unidade</label>
                        <select class="browser-default" id = "unidade" name="unidade">
                            <option value="" disabled selected readonly = "true">${produto.nomeUnidade}</option>


                        </select>


                    </div>
                </div>

                <div class="row" style="margin-left:5%;margin-right: 5%;">
                    <div class="input-field col s12">
                        <input type="text" value="${produto.descricao}" readonly="true">
                        <label for="descricao">Descrição</label>
                    </div>
                </div>
                <!--
                <div class="row" style="margin-left:20%;margin-right: 20%;">
                    <div class="file-field input-field">
                        <div class="btn">
                            <span>File</span>
                            <input type="file">
                        </div>
                        <div class="file-path-wrapper">
                            <input class="file-path validate" type="text">
                        </div>
                    </div>
                </div>-->

        

            <a href="ListarProdutos">
                <button class="btn waves-effect waves-light" type="submit" id="adicionar">Voltar
                    <i class="material-icons left">arrow_back</i>
                </button>
            </a>

        </div>

















        <script>
            $('#textarea1').val('New Text');
            M.textareaAutoResize($('#textarea1'));


        </script>
    </body>
    <style type="text/css">
        #formulario{
            margin: 5%;

        }
        #adicionar{
            margin-left: 40%;
            height: 30px;
            text-components: center;

        }

    </style>
</html>

