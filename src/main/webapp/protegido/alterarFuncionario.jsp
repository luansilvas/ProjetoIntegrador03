<%-- 
    Document   : alterarFuncionario
    Created on : 30/11/2020, 12:30:03
    Author     : luans
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
                <form class="col s12" action="<c:url value="/AlterarFuncionario"/>" method="POST">
                    <div class="row">
                        <div class="input-field col s4">
                            <input id="nome" type="text" class="" name="nome" value="${func.nome}">
                            <label for="nome">nome</label>
                        </div>
                        <div class="input-field col s4">
                            <input id="cpf" type="text" class="" name="cpf" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" required="" value="${func.cpf}">
                            <label for="cpf">CPF</label>
                        </div>
                        <div class="input-field col s4">
                            <input id="email" type="email" class="" name="email" value="${func.email}">
                            <label for="email">E-mail</label>
                        </div>
                        <div class="input-field col s4">
                            <input id="telefone" type="tel" class="" name="telefone" value="${func.celular}">
                            <label for="telefone">Telefone</label>
                        </div>
                        <div class="select-field col s4">
                            <label>unidade</label>
                            <select class="browser-default" id="unidade" name="unidade" required="">
                                <option value="${func.codUnidade}" selected></option>
                                <option value="1">Matriz</option>
                                <option value="2">Campina Grande</option>                           
                                <option value="3">Brasília</option>
                                <option value="4">Joinville</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">


                        <div class="select-field col s4">
                            <label>cargo</label>
                            <select class="browser-default" id = "cargo" name="cargo" required="">
                                <option value="${func.cargo}"selected>${func.cargo}</option>
                                <option value="Gerente">Gerente</option>
                                <option value="Vendedor">Vendedor</option>                           
                                <option value="Analista BackOffice">Analista BackOffice</option>
                                <option value="Analista TI">Analista TI</option>
                            </select>
                        </div>
                        <div class="input-field col s4">
                            <input id="nome" type="text" class="" name="login" value="${func.login}">
                            <label for="nome">login</label>

                        </div>
                        <div class="input-field col s4">     
                            <input id="nome" type="password" class="" name="senha" required="">
                            <label for="nome">senha</label>
                        </div>
                    </div>
                    <input id="nome" type="text" class="" name="codFuncionario" style="display:none" value="${func.codFuncionario}">
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