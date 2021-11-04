<%@page import="op_BD.PizzaIO"%>
<%@page import="op_BD.PedidoIO"%>
<%@page contentType ="text/html" import="java.util.Date,util.HtmlObj" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Item</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
   
    <body>
        <h1>Dados do item</h1>
        <form action = "ServletSalvarI" method = "post">
            
           <p>Pedido:
               <%=new PedidoIO().selectPedido()%></p>
           <p>Pizza:
               <%=new HtmlObj().select("pizza", "pizza", 0) %></p>
           <p>Quantidade da Pizza:
               <input type = "number" name = "qtd" placeholder="Quantas pizzas deseja?" required="Preencha este campo por favor" min="1" step="1"/></p>
           
              <input type = "submit" value = "Salvar" /></p>
        </form>
    </body>
    <footer>Engenharia de Telecomunicacoes 3ano UCAN-2019</footer>
</html>
