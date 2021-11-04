<%@page import="op_BD.ClienteIO"%>
<%@page import="op_BD.FuncionarioIO"%>
<%@page contentType ="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Pedido</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
   
    <body>
        <h1>Dados do Pedido</h1>
        <form action = "ServletSalvarE" method = "post">
            
           <p>Funcionario:
               <%=new FuncionarioIO().selectFuncionario(1) %></p>
           <p>Cliente:
              <%=new ClienteIO().selectCliente()%></p></p>
           <p>Prazo do Pedido:
             <input type = "number" name = "tempoMaximo" placeholder="Digite o prazo de entrega do pedido" required="Preencha este campo por favor" min="5" step="1" />
             minutos
           </p>
           <p>Data de emissao do Pedido:
             <input type = "date" name = "dataEmissao" required="Preencha este campo por favor" />
           <p>Hora de emissao do Pedido:
             <input type = "text" name = "horaEmissao" required="Preencha este campo por favor" />
             Formato(hh:mm:ss)
           </p>
           
              <input type = "submit" value = "Salvar" />
           </p>
        </form>
    </body>
    <footer>Engenharia de Telecomunicacoes 3ano UCAN-2019</footer>
</html>
