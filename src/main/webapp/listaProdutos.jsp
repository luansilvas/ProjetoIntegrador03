<%-- 
    Document   : listaProdutos
    Created on : 15/10/2020, 17:38:51
    Author     : luans
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <table class="table">
            <thead>
            <th>Titulo</th>
            <th>Valor</th>
            <th>Categoria</th>
        </thead>
        <tbody> 
        <c:forEach var="produto" items="${listaProdutos}">
            <tr>
                <td>${produto.titulo}</td>
                <td>${produto.valor}</td>
                <td>${produto.quantidade}</td>
        </c:forEach>

    </tbody>

</table>












</body>
</html>
