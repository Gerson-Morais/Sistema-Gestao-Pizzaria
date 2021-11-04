<%@page import="op_BD.PessoaIO"%>
<%@page import="bean.Pessoa"%>
<%@page import="op_BD.FuncionarioIO"%>
<%@page import="bean.Funcionario"%>
<%@page contentType ="text/html" import="java.util.Date,util.HtmlObj" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizacao de Funcionario</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
    <%
        
         int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));

         Funcionario f = new FuncionarioIO().getFuncionario(idFuncionario);
         Pessoa p = new PessoaIO().getPessoa(f.getFk_pessoa());
    
    %>
    <body>
     <h1>Dados Gravados</h1>
        <form action = "ServletAlterarF" method = "post">

              <input type = "hidden" name = "id"  value="<%=idFuncionario%>"></p>
           <p>Nome:
              <input type = "text" name = "nome"  value="<%= p.getNome() %>" readonly="readonly"></p>
           <p>Tipo de Funcionario:
              <%=new HtmlObj().select("tipo", "tipo",f.getFk_tipo())%></p>
             <input type = "submit" value = "Alterar" />
        </form>
              
        <p><form action = "ServletEliminarF" method = "post">
              <input type = "hidden" name = "id"  value="<%=idFuncionario%>">
              <input type = "submit" value = "Eliminar" />   
        </form></p>
    </body>
</html>
