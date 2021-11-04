<%@page import="op_BD.PizzaIO"%>
<%@page import="op_BD.PedidoIO"%>
<%@page import="op_BD.ItemIO"%>
<%@page import="bean.Item"%>
<%@page contentType ="text/html" import="java.util.Date,util.HtmlObj" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizacao de Item</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
    <%
        
         int idItem = Integer.parseInt(request.getParameter("idItem"));

         Item i = new ItemIO().getItem(idItem);
    
    %>
    <body>
     <h1>Dados Gravados</h1>
        <form action = "ServletAlterarI" method = "post">

              <input type = "hidden" name = "id"  value="<%=idItem%>"></p>
            <p>Pedido:
                <%=new PedidoIO().selectPedido(i.getFk_pedido()) %></p>
            <p>Pizza:
                <%=new HtmlObj().select("pizza", "pizza", i.getFk_pizza()) %></p>
           <p>Quantidade da Pizza:
              <input type = "number" name = "qtd"  value="<%= i.getQtd() %>" min="1" step="1">
              minutos
           </p>
           
             <input type = "submit" value = "Alterar" />
        </form>
              
        <p><form action = "ServletEliminarI" method = "post">
              <input type = "hidden" name = "id"  value="<%=idItem%>">
              <input type = "submit" value = "Eliminar" />   
        </form></p>
    </body>
</html>
