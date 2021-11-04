<%@page import="op_BD.ClienteIO"%>
<%@page import="op_BD.FuncionarioIO"%>
<%@page import="op_BD.PedidoIO"%>
<%@page import="bean.Pedido"%>
<%@page contentType ="text/html" import="java.util.Date,util.HtmlObj" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizacao de Pedido</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
    <%
        
         int idPedido = Integer.parseInt(request.getParameter("idPedido"));

         Pedido e = new PedidoIO().getPedido(idPedido);
    
    %>
    <body>
     <h1>Dados Gravados</h1>
        <form action = "ServletAlterarE" method = "post">

              <input type = "hidden" name = "id"  value="<%=idPedido%>"></p>
            <p>Funcionario:
              <%=new FuncionarioIO().selectFuncionario(1, e.getFk_funcionario() ) %></p>
            <p>Cliente:
                <%=new ClienteIO().selectCliente(e.getFk_cliente()) %></p>
           <p>Prazo do Pedido:
              <input type = "number" name = "tempoMaximo"  value="<%= e.getTempoMax() %>" min="5" step="1">
              minutos
           </p>
           <p>Data de Emissao:
              <input type = "text" name = "dataEmissao"  value="<%= e.getDataEmissao() %>"></p>
           <p>Hora de Emissao:
              <input type = "text" name = "horaEmissao"  value="<%= e.getHoraEmissao() %>">
            Formato(hh:mm:ss)</p>
           
             <input type = "submit" value = "Alterar" />
        </form>
              
        <p><form action = "ServletEliminarE" method = "post">
              <input type = "hidden" name = "id"  value="<%=idPedido%>">
              <input type = "submit" value = "Eliminar" />   
        </form></p>
    </body>
</html>
