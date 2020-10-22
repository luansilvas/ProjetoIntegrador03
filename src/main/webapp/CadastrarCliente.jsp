<%-- 
    Document   : CadastrarCliente
    Created on : 21/10/2020, 21:03:19
    Author     : Gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="CadastrarCliente" method="POST">
            <p>Nome</p>
            <input name="nome" class="form-control" required="true"/><br/>
            <p>CPF</p>
            <input name="cpf" class="form-control" required="true"/><br/>
            <p>Email</p>
            <input name="email" class="form-control" required="true"/><br/> 
            <p>Telefone</p>
            <input name="telefone" class="form-control" required="true"/><br/>
            
            <button type="submit" class="btn btn-primary">Enviar</button>
    </body>
</html>
