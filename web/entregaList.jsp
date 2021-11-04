<%-- 
    Document   : pessoaList
    Created on : Nov 20, 2019, 10:05:34 AM
    Author     : qraysoon
--%>

<%@page import="op_BD.EntregaIO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entregas</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
    <body>
        <h1>Lista de Entregas</h1>
           <form action = "entregaView.jsp" method = "post">
            
            <p>Nome:
               <%=new EntregaIO().selectEntrega()%></p>
            
            <input type = "submit" value = "Visualizar" />  
           </form>
    </body>
</html>
