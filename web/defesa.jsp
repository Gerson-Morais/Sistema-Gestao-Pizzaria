<%@page import="op_BD.PizzaIO"%>
<%@page import="op_BD.DefesaIO"%>
<%@page contentType ="text/html" import="java.util.Date" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Pesquisa</title>
        <!-- Chamada do arquivo css externo -->
        <link rel="stylesheet" type="text/css"  href="Pizza.css" />
    </head>
    <body>
        <form action = "defesaView.jsp" method = "post">
            
               <p>Pizza:
               <%=new PizzaIO().selectPizza()%></p>
               <p>Ano:
               <input type = "number" name = "ano" required="Preencha este campo por favor" min="0" step="1" /></p>
               <p>Mes1:
               <select name="mes1" id="mes1" >
                <option value="01" >Janeiro</option>
                <option value="02" >Fevereiro</option>
                <option value="03" >Março</option>
                <option value="04" >Abril</option>
                <option value="05" >Maio</option>
                <option value="06" >Junho</option>
                <option value="07" >Julho</option>
                <option value="08" >Agosto</option>
                <option value="09" >Setembro</option>
                <option value="10" >Outubro</option>
                <option value="11" >Novembro</option>
                <option value="12" >Dezembro</option>
               </select></p>
               <p>Mes2:
               <select name="mes2" id="mes2" >
                <option value="01" >Janeiro</option>
                <option value="02" >Fevereiro</option>
                <option value="03" >Março</option>
                <option value="04" >Abril</option>
                <option value="05" >Maio</option>
                <option value="06" >Junho</option>
                <option value="07" >Julho</option>
                <option value="08" >Agosto</option>
                <option value="09" >Setembro</option>
                <option value="10" >Outubro</option>
                <option value="11" >Novembro</option>
                <option value="12" >Dezembro</option>
               </select></p>
               
              <input type = "submit" value = "Pesquisar" />
           </p>
        </form>
    </body>
</html>
