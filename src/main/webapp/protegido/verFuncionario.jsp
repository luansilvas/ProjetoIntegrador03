<%-- 
    Document   : verFuncionario
    Created on : 30/11/2020, 16:43:26
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
            <form class="col s12">
                <div class="row">
                    <div class="input-field col s4">
                        <input id="nome" type="text" class="" name="nome" value="${func.nome}" readonly>
                        <label for="nome">nome</label>
                    </div>
                    <div class="input-field col s4">
                        <input id="cpf" type="text" class="" name="cpf" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" required="" value="${func.cpf}" readonly>
                        <label for="cpf">CPF</label>
                    </div>
                    <div class="input-field col s4">
                        <input id="email" type="email" class="" name="email" value="${func.email}" readonly>
                        <label for="email">E-mail</label>
                    </div>
                    <div class="input-field col s4">
                        <input id="telefone" type="tel" class="" name="telefone" value="${func.celular}" readonly>
                        <label for="telefone">Telefone</label>
                    </div>
                    <div class="select-field col s4">
                        <label>unidade</label>
                        <select class="browser-default" id = "unidade" name="unidade" required="" readonly>
                            <option value="${func.codUnidade}" selected>${func.codUnidade}</option>

                        </select>
                    </div>
                </div>
                <div class="row">


                    <div class="select-field col s4">
                        <label>unidade</label>
                        <select class="browser-default" id = "cargo" name="cargo" required="" readonly>
                            <option value="${func.cargo}"selected>${func.cargo}</option>
                        </select>
                    </div>
                    <div class="input-field col s4">
                        <input id="nome" type="text" class="" name="login" value="${func.login}" readonly>
                        <label for="nome">login</label>

                    </div>

                </div>
                <input id="nome" type="text" class="" name="codFuncionario" style="display:none" value="${func.codFuncionario}">


            </form>

            <a class="waves-effect waves-light btn" href="<c:url value="/ListarFuncionario"/>"> <i class="material-icons left">arrow_back</i>Voltar</a>
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
