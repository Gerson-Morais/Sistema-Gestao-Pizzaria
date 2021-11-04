<%-- 
    Document   : defesaOther.jsp
    Created on : Dec 4, 2019, 9:07:36 AM
    Author     : qraysoon
--%>

<%@page import="bean.Defesa"%>
<%@page import="op_BD.DefesaIO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa 2</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
    <% 
        
        int idPessoa = Integer.parseInt(request.getParameter("idPessoa"));
        int tipo = Integer.parseInt(request.getParameter("tipo"));
        int prov = Integer.parseInt(request.getParameter("prov"));
        String d1 = request.getParameter("data1");
        String d2 = request.getParameter("data2");
        
        
        
    %>
    <body>
        <h1>Pizzas encomendadas</h1>
        <form action = "index.jsp" method = "post">
            <p>Nome:
                <%= new DefesaIO().defesaPizza(idPessoa, d1, d2, tipo, prov) %></p>
            <input type = "submit" value = "Sair" />  
        </form>
    </body>
</html>
