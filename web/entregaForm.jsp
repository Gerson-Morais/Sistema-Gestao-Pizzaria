<%@page import="op_BD.FuncionarioIO"%>
<%@page import="op_BD.PedidoIO"%>
<%@page contentType ="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Entrega</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
   
    <body>
        <h1>Dados da Entrega</h1>
        <form action = "ServletSalvarG" method = "post">
            
           <p>Pedido:
              <%=new PedidoIO().selectPedido()%></p></p>
           <p>Entregador:
               <%=new FuncionarioIO().selectFuncionario(2) %></p>
           <p>Data da Entrega:
             <input type = "date" name = "dataEntrega" required="Preencha este campo por favor" />
           <p>Hora da Entrega:
             <input type = "text" name = "horaEntrega" required="Preencha este campo por favor" />
             Formato(hh:mm:ss)
           </p>
           
              <input type = "submit" value = "Salvar" />
           </p>
        </form>
    </body>
    <footer>Engenharia de Telecomunicacoes 3ano UCAN-2019</footer>
</html>
