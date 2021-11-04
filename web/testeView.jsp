<%-- 
    Document   : index
    Created on : Sep 10, 2019, 11:20:27 AM
    Author     : fdelgado
--%>

<%@page import="bean.Defesa"%>
<%@page import="op_BD.DefesaIO"%>
<%@page contentType="text/html" import="op_BD.PessoaIO" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
    <% Defesa d = new Defesa();

        String tipo = request.getParameter("tamanho");
        String prov = request.getParameter("provincia");
        String data1 = request.getParameter("data1");
        String data2 = request.getParameter("data2");
        
        d.setTipo(Integer.parseInt(tipo));
        d.setProvincia(Integer.parseInt(prov));
        d.setData1(data1);
        d.setData2(data2); 
    %>
    <body>
        <h1>Listagem da Pesquisa</h1>
        <h1> </h1>
        <form action = "testeOther.jsp" method = "post">
            <p>Nome:
                <%= new DefesaIO().defesaPessoa(d)%></p>
            <input type = "hidden" name = "tipo"  value="<%= d.getTipo() %>"></p>
            <input type = "hidden" name = "prov"  value="<%= d.getProvincia() %>"></p>
            <input type = "hidden" name = "data1"  value="<%= d.getData1() %>"></p>
            <input type = "hidden" name = "data2"  value="<%= d.getData2() %>"></p>
            <input type = "submit" value = "Ver Pizzas" />  
        </form>
        <h1> </h1>
    </body>
</html>
