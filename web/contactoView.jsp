<%@page import="op_BD.PessoaIO"%>
<%@page import="bean.Contacto"%>
<%@page import="op_BD.ContactoIO"%>
<%@page contentType ="text/html" import="java.util.Date,util.HtmlObj" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizacao de Contacto</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
    <%
        
         int idContacto = Integer.parseInt(request.getParameter("idContacto"));

         Contacto c = new ContactoIO().getContacto(idContacto);
    
    %>
    <body>
     <h1>Dados Gravados</h1>
        <form action = "ServletAlterarC" method = "post">

              <input type = "hidden" name = "id"  value="<%=idContacto%>"></p>
           <p>Telefone:
              <input type = "text" name = "contacto"  value="<%=c.getContacto()%>"></p>
           <p>Nome:
               <%=new HtmlObj().select("pessoa", "pessoa", Integer.parseInt(request.getParameter("idPessoa"))) %></p>
             <input type = "submit" value = "Alterar" />
        </form>
              
        <p><form action = "ServletEliminarC" method = "post">
              <input type = "hidden" name = "id"  value="<%=idContacto%>">
              <input type = "submit" value = "Eliminar" />   
        </form></p>
    </body>
</html>
