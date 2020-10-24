<%-- 
    Document   : alterarCliente
    Created on : 24/10/2020, 14:25:02
    Author     : Gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="menu.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Cliente</title>
    </head>
    <body>
        <div class="row" id="formulario">
            <form class="col s12" action="AlteraCliente" method="POST">
                <div class="row">
                    <div class="input-field col s4">
                        <input id="nome" type="text" class="" name="nome"  value="${cliente.nome}">
                        <label for="nome">nome</label>
                    </div>
                    <div class="input-field col s4">
                        <input id="cpf" type="text" class="" name="cpf" value="${cliente.cpf}" readonly="true" >
                        <label for="cpf">CPF</label>
                    </div>
                    <div class="input-field col s4">
                        <input id="email" type="text" class="" name="email" value="${cliente.email}">
                        <label for="email">E-mail</label>
                    </div>
                    <div class="input-field col s4">
                        <input id="telefone" type="tel" class="" name="telefone" value="${cliente.telefone}">
                        <label for="telefone">Telefone</label>
                    </div>
                    <div class="select-field col s4">
                        <label>unidade</label>
                        <select class="browser-default" id = "unidade" name="unidade">
                            <option value="" disabled selected></option>
                            <option value="1">Matriz</option>
                            <option value="2">Campina Grande</option>                           
                            <option value="3">Brasília</option>
                            <option value="4">Joinville</option>
                        </select>
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
