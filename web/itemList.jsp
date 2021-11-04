<%-- 
    Document   : pessoaList
    Created on : Nov 20, 2019, 10:05:34 AM
    Author     : qraysoon
--%>
<%@page import="op_BD.ItemIO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Itens</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
    <body>
        <h1>Lista de Itens</h1>
           <form action = "itemView.jsp" method = "post">
            
            <p>Nome:
               <%=new ItemIO().selectItem() %></p>
            
            <input type = "submit" value = "Visualizar" />  
           </form>
    </body>
</html>
