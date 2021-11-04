<%-- 
    Document   : index
    Created on : Sep 10, 2019, 11:20:27 AM
    Author     : fdelgado
--%>

<%@page import="bean.Defesa"%>
<%@page import="op_BD.DefesaIO"%>
<%@page contentType="text/html" import="op_BD.PessoaIO" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
    <%
        int pizza = Integer.parseInt(request.getParameter("idPizza"));
        int ano = Integer.parseInt(request.getParameter("ano"));
        int mes1 = Integer.parseInt(request.getParameter("mes1"));
        int mes2 = Integer.parseInt(request.getParameter("mes2"));
    %>
    <body>
        <h1>Listagem da Pesquisa</h1>
        <h1> </h1>
        <form action = "index.jsp" method = "post">
            <p>Nome:
                <%= new DefesaIO().defesaCliente(pizza, ano, mes1, mes2) %></p>
                <input type = "submit" value = "Sair" /> 
        </form>
        <h1> </h1>
    </body>
</html>
