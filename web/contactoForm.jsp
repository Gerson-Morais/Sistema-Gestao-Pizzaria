<%@page import="op_BD.PessoaIO"%>
<%@page contentType ="text/html" import="java.util.Date,util.HtmlObj" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Contacto</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
   
    <body>
        <h1>Dados do contacto</h1>
        <form action = "ServletSalvarC" method = "post">
            
            <p>Nome:
               <%=new PessoaIO().selectPessoa()%></p>
           <p>Telefone:
             <input type = "tel" name = "contacto" placeholder="Digite o seu contacto telefonico" required="Preencha este campo por favor" /></p>
           
              <input type = "submit" value = "Salvar" /></p>
        </form>
    </body>
    <footer>Engenharia de Telecomunicacoes 3ano UCAN-2019</footer>
</html>
