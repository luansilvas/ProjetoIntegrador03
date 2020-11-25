<%-- 
    Document   : verCliente
    Created on : 27/10/2020, 10:39:47
    Author     : Gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="menu.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Cliente</title>
    </head>
    <body>
        <div class="row" id="formulario">
            <div class="row">
                <div class="input-field col s4">
                    <input type="text"  value="${cliente.nome}" readonly="true">
                    <label for="nome">nome</label>
                </div>
                <div class="input-field col s4">
                    <input type="text" value="${cliente.cpf}" readonly="true" >
                    <label for="cpf">CPF</label>
                </div>
                <div class="input-field col s4">
                    <input type="text" value="${cliente.email}" readonly="true">
                    <label for="email">E-mail</label>
                </div>
                <div class="input-field col s4">
                    <input type="tel" value="${cliente.telefone}" readonly="true">
                    <label for="telefone">Telefone</label>
                </div>
                <div class="select-field col s4">
                    <label>unidade</label>
                    <select class="browser-default">
                        <option value=" " disabled="true" selected readonly="true">${unidade.nome}</option>
                    </select>
                </div>
            </div>
            <a href="ListarCliente">
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

