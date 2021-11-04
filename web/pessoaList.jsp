<%-- 
    Document   : pessoaList
    Created on : Nov 20, 2019, 10:05:34 AM
    Author     : qraysoon
--%>

<%@page contentType="text/html" import="op_BD.PessoaIO" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pessoa</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
    <body>
        <h1>Lista de Pessoas</h1>
           <form action = "pessoaFormView.jsp" method = "post">
            
            <p>Nome:
               <%=new PessoaIO().selectPessoa()%></p>
            
            <input type = "submit" value = "Visualizar" />  
           </form>
    </body>
</html>
