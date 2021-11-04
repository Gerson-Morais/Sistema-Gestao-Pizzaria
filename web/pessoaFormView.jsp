<%@page import="op_BD.ContactoIO"%>
<%@page import="op_BD.PessoaIO"%>
<%@page import="bean.Pessoa"%>
<%@page contentType ="text/html" import="java.util.Date,util.HtmlObj" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizacao de Pessoa</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
    <%
        
         int idPessoa = Integer.parseInt(request.getParameter("idPessoa"));

         Pessoa p = new PessoaIO().getPessoa(idPessoa);
    
    %>
    <body>
     <h1>Dados Gravados</h1>
        <form action = "ServletAlterarP" method = "post">

              <input type = "hidden" name = "id"  value="<%=idPessoa%>"></p>
           <p>Nome:
               <input type = "text" name = "nome"  value="<%=p.getNome()%>" disabled="disabled"></p>
           <p>Sobrenome:
              <input type = "text" name = "sobreNome"  value="<%=p.getSobrenome()%>"></p>
           <p>Data de Nascimento:
              <input type = "date" name = "data"  value="<%=p.getDataNasc()%>"></p>
           
           <p>Sexo:
              <%=new HtmlObj().select("sexo", "sexo", p.getFkSexo()) %></p>
           <p>Morada:
              <%=new HtmlObj().select("morada", "morada", p.getFkMorada()) %></p>
           
             <input type = "submit" value = "Alterar" />
        </form>
              
        <p><form action = "ServletEliminarP" method = "post">
              <input type = "hidden" name = "id"  value="<%=idPessoa%>">
              <input type = "submit" value = "Eliminar" />   
        </form></p>
              
              <form action = "contactoView.jsp" method = "post">
                <p>Telefone:
                <%=new ContactoIO().selectContacto(idPessoa)%>
                <input type = "hidden" name = "idPessoa"  value="<%=idPessoa%>">
                
              <input type = "submit" value = "Ver Detalhes do Contacto" /></p>  
              </form>
    </body>
</html>
