<%-- 
    Document   : alterarProduto
    Created on : 18/10/2020, 17:57:34
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
            <form class="col s12" action="AlterarProduto" method="POST">
                <div class="row">
                    <div class="input-field col s4">
                        <input id="titulo" type="text" class="" name="titulo" value="${produto.titulo}"> 
                        <label for="titulo">Título</label>
                    </div>
                    <div class="input-field col s4">
                        <input id="valor" type="text" class="validate" pattern="[0-9]{1,}.[0-9]{1,}" name="valor" value="${produto.valor}">
                        <label for="valor">Valor</label>
                    </div>
                    <div class="input-field col s4">
                        <input id="quantidade" type="number" class="validate" min="0" max="1000" name="quantidade" value="${produto.quantidade}">
                        <label for="quantidade">Quantidade</label>
                    </div>
                </div>

                <div class="row" style="margin-left:25%">
                    <div class="select-field col s4">
                        <label>Categoria</label>
                        <select class="browser-default" id="categoria" name="categoria">
                            <option value="${produto.categoria}" selected="">${produto.categoria}</option>
                            <option value="Mesa comum">Mesa comum</option>
                            <option value="Bancada com base">Bancada com base</option>                           
                            <option value="Bancada de parede">Bancada de parede</option>
                            <option value="Cadeira fixa">Cadeira fixa</option>
                            <option value="Cadeira giratória">Cadeira giratória</option>
                            <option value="Mesa planejada">Mesa planejada</option>
                            <option value="Armário">Armário</option>
                            <option value="Outro">Outro</option>
                        </select>


                    </div>
                    <div class="select-field col s4">
                        <label>unidade</label>
                        <select class="browser-default" id = "unidade" name="unidade">
                            <option value="${produto.codUnidade}"selected>${produto.nomeUnidade}</option>
                            <option value="1">Matriz</option>
                            <option value="2">Campina Grande</option>                           
                            <option value="3">Brasília</option>
                            <option value="4">Joinville</option>
                        </select>


                    </div>
                </div>

                <div class="row" style="margin-left:5%;margin-right: 5%;">
                    <div class="input-field col s12">
                        <input id="descricao" type="text" class="validate" name="descricao" value="${produto.descricao}">
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
                <div class="row" style="margin-left:5%;margin-right: 5%;">
                    <div class="input-field col s12">
                        <input id="codProduto" type="text" class="validate" name="codProduto" value="${produto.codProduto}" readonly="true">
                        <label for="CodProduto ">Código do produto</label>
                    </div>
                </div>
                <button class="btn waves-effect waves-light" type="submit" id="adicionar">Enviar
                    <i class="material-icons right">send</i>
                </button>

            </form>



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
