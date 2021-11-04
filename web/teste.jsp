<%@page import="util.HtmlObj"%>
<%@page contentType ="text/html" import="java.util.Date" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Pesquisa</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
    <body>
        <form action = "testeView.jsp" method = "post">
           
               <p>Tipo de Pizza</p>
               <p><%=new HtmlObj().select("tamanho", "tamanho",0) %></p>
               <p>Provincia</p>
               <p><%=new HtmlObj().select("provincia", "provincia",0) %></p>
               <p>Data 1:
               <input type = "date" name = "data1" required="Preencha este campo por favor" /></p>
               <p>Data 2:
               <input type = "date" name = "data2" required="Preencha este campo por favor" /></p>
               
              <input type = "submit" value = "Pesquisar" />
           </p>
        </form>
    </body>
</html>
