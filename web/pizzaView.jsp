<%@page import="op_BD.AddIngredienteIO"%>
<%@page import="op_BD.AddTamanhoIO"%>
<%@page import="op_BD.PizzaIO"%>
<%@page import="bean.Pizza"%>
<%@page contentType ="text/html" import="java.util.Date,util.HtmlObj" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizacao de Pizza</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
    <%
        
         int idPizza = Integer.parseInt(request.getParameter("idPizza"));

         Pizza z = new PizzaIO().getPizza(idPizza);
    
    %>
    <body>
     <h1>Dados Gravados</h1>
        <form action = "ServletAlterarZ" method = "post">

              <input type = "hidden" name = "id"  value="<%=idPizza%>"></p>
           <p>Nome:
              <input type = "text" name = "nome"  value="<%=z.getNome()%>"></p>
           <p>Preco:
              <input type = "number" name = "preco"  value="<%=z.getPreco()%>" min="500.00" step="0.05"></p>
           
             <input type = "submit" value = "Alterar" />
        </form>
              
        <p><form action = "ServletEliminarZ" method = "post">
              <input type = "hidden" name = "id"  value="<%=idPizza%>">
              <input type = "submit" value = "Eliminar" />   
        </form></p>
        
                <p>Tamanhos Disponiveis:
                <%=new AddTamanhoIO().selectAddTamanho(idPizza)%>
                <p>Ingredientes Disponiveis:
                <%=new AddIngredienteIO().selectAddIngrediente(idPizza) %>
        </form>
    </body>
</html>
