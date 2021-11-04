<%@page contentType ="text/html" import="java.util.Date,util.HtmlObj" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Pizza</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
   
    <body>
        <h1>Dados da Pizza</h1>
        <form action = "ServletSalvarZ" method = "post">
            
           <p>Nome:
             <input type = "text" name = "nome" placeholder="Digite o nome da Pizza" required="Preencha este campo por favor" /></p>
           <p>Preco:
             <input type = "number" name = "preco" placeholder="Digite o preco da Pizza" required="Preencha este campo por favor" min="500.00" step="0.05" /></p>
               
              <input type = "submit" value = "Salvar" />
           </p>
        </form>
    </body>
    <footer>Engenharia de Telecomunicacoes 3ano UCAN-2019</footer>
</html>
