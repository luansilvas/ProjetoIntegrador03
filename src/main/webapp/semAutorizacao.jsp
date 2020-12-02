<%-- 
    Document   : semAutorizacao
    Created on : 01/12/2020, 10:56:17
    Author     : luans
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro</title>

        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link href="https://fonts.googleapis.com/css2?family=Mandali&display=swap" rel="stylesheet">
    </head>
    <body>
        <h1>Você não tem acesso a essa página</h1>
   
        <a href="<c:url value="/login.jsp"/>">Volte para o login</a>
    </body>
</html>
