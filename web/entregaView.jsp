<%@page import="op_BD.PedidoIO"%>
<%@page import="op_BD.FuncionarioIO"%>
<%@page import="op_BD.EntregaIO"%>
<%@page import="bean.Entrega"%>
<%@page contentType ="text/html" import="java.util.Date,util.HtmlObj" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizacao de Entrega</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
    <%
        
         int idEntrega = Integer.parseInt(request.getParameter("idEntrega"));

         Entrega g = new EntregaIO().getEntrega(idEntrega);
    
    %>
    <body>
     <h1>Dados Gravados</h1>
        <form action = "ServletAlterarG" method = "post">

              <input type = "hidden" name = "id"  value="<%=idEntrega%>"></p>
            <p>Pedido:
                <%=new PedidoIO().selectPedido(g.getFk_pedido()) %></p>
            <p>Entregador:
               <%=new FuncionarioIO().selectFuncionario(2, g.getFk_entregador()) %></p>
            <p>Data de Entrega:
              <input type = "text" name = "dataEntrega"  value="<%= g.getData() %>"></p>
            <p>Hora de Entrega:
              <input type = "text" name = "horaEntrega"  value="<%= g.getHora() %>">
              Formato(hh:mm:ss)
            </p>
           
             <input type = "submit" value = "Alterar" />
        </form>
              
        <p><form action = "ServletEliminarG" method = "post">
              <input type = "hidden" name = "id"  value="<%=idEntrega%>">
              <input type = "submit" value = "Eliminar" />   
        </form></p>
    </body>
</html>
