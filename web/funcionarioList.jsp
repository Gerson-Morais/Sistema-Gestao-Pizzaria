<%-- 
    Document   : pessoaList
    Created on : Nov 20, 2019, 10:05:34 AM
    Author     : qraysoon
--%>
<%@page import="op_BD.FuncionarioIO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionarios</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
    <body>
        <h1>Lista de Funcionarios</h1>
           <form action = "funcionarioView.jsp" method = "post">
            
            <p>Nome:
               <%=new FuncionarioIO().selectFuncionario()%></p>
            
            <input type = "submit" value = "Visualizar" />  
           </form>
    </body>
</html>
