<%-- 
    Document   : pessoaList
    Created on : Nov 20, 2019, 10:05:34 AM
    Author     : qraysoon
--%>

<%@page import="op_BD.ClienteIO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
    <body>
        <h1>Lista de Clientes</h1>
           <form action = "ServletEliminarCL" method = "post">
            
            <p>Nome:
               <%=new ClienteIO().selectCliente()%></p>
            
            <input type = "submit" value = "Eliminar" />  
           </form>
    </body>
</html>
