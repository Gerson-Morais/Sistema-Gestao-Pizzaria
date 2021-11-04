<%@page import="op_BD.PizzaIO"%>
<%@page import="bean.Pizza"%>
<%@page import="op_BD.AddTamanhoIO"%>
<%@page contentType ="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizacao de Tamanho</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
    <%
        
         int idPizza = Integer.parseInt(request.getParameter("idPizza"));

         Pizza z = new PizzaIO().getPizza(idPizza);
    
    %>
    <body>
     <h1>Dados Gravados</h1>
     
        <p><form action = "ServletEliminarA" method = "post">
              <input type = "hidden" name = "idPizza"  value="<%=idPizza%>"></p>
           <p>Pizza:
               <input type = "text" name = "nome"  value="<%=z.getNome()%>" readonly="readonly"></p>
           <p>Tamanho:
               <%=new AddTamanhoIO().selectAddTamanho(idPizza) %></p>
            <input type = "submit" value = "Eliminar" />   
        </form></p>
    </body>
</html>
