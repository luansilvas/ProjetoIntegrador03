<%-- 
    Document   : CadastrarCliente
    Created on : 21/10/2020, 21:03:19
    Author     : Gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="menu.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Cliente</title>
    </head>
    <body>
        <div class="row" id="formulario">
            <form class="col s12" action="CadastrarCliente" method="POST">
                <div class="row">
                    <div class="input-field col s4">
                        <input id="nome" type="text" class="" name="nome">
                        <label for="nome">nome</label>
                    </div>
                    <div class="input-field col s4">
                        <input id="cpf" type="text" class="" name="cpf">
                        <label for="cpf">CPF</label>
                    </div>
                    <div class="input-field col s4">
                        <input id="email" type="text" class="" name="email">
                        <label for="email">E-mail</label>
                    </div>
                    <div class="input-field col s4">
                        <input id="telefone" type="number" class="" name="telefone">
                        <label for="telefone">Telefone</label>
                    </div>
                </div>
                <button class="btn waves-effect waves-light" type="submit" id="adicionar">Enviar
                    <i class="material-icons right">send</i>
                </button>
        </div>
    </body>

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
