
<%@page contentType ="text/html" import="java.util.Date,util.HtmlObj" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Pessoa</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
   
    <body>
        <h1>Dados Pessoais</h1>
        <form action = "ServletSalvar" method = "post">
            
           <p>Nome:
             <input type = "text" name = "nome" placeholder="Digite o seu primeiro nome" required="Preencha este campo por favor" /></p>
           <p>Sobrenome:
             <input type = "text" name = "sobreNome" placeholder="Digite o seu ultimo nome" required="Preencha este campo por favor" /></p>
           <p>Data de Nascimento:
             <input type = "date" name = "data" required="Preencha este campo por favor" /></p>
             
           <p>Sexo:
              <%=new HtmlObj().select("sexo", "sexo",0) %></p>
           <p>Morada:
              <%=new HtmlObj().select("morada", "morada",0) %></p>
               
              <input type = "submit" value = "Salvar" />
           </p>
        </form>
    </body>
    <footer>Engenharia de Telecomunicacoes 3ano UCAN-2019</footer>
</html>
