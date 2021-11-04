<!DOCTYPE HTML>
<html lang="pt-pt">
<head>
  <meta charset="UTF-8">
    <title>Menu</title>
     <!-- Chamada do arquivo css externo -->
    <link rel="stylesheet" type="text/css"  href="Menu.css" /> 
</head>
<body>
<nav>
  <ul class="menu">
      
        <li><a href="#">Pessoa</a>
            <ul>
                <li><a href="pessoaForm.jsp">Adicionar</a></li>
                <li><a href="contactoForm.jsp">Adicionar Contacto</a></li>
                <li><a href="pessoaList.jsp">Visualizar</a></li>  
            </ul> 
        </li>
        
        <li><a href="#">Cliente</a>
            <ul>
                <li><a href="clienteForm.jsp">Adicionar</a></li>
                <li><a href="clienteList.jsp">Visualizar</a></li>                  
            </ul>
        </li>
        
        <li><a href="#">Funcionario</a>
            <ul>
                <li><a href="funcionarioForm.jsp">Adicionar</a></li>
                <li><a href="funcionarioList.jsp">Visualizar Todos</a></li>
                <li><a href="atendenteCaixaList.jsp">Visualizar Atendentes do Caixa</a></li>
                <li><a href="entregadorList.jsp">Visualizar Entregadores</a></li>
            </ul>
        </li>
        
        <li><a href="#">Pizza</a>
            <ul>
                <li><a href="pizzaForm.jsp">Adicionar</a></li>
                <li><a href="pizzaList.jsp">Visualizar</a></li>
                <li><a href="addTamanhoForm.jsp">Adicionar Tamanho a pizza</a></li>
                <li><a href="addTamanhoList.jsp">Remover Tamanho a pizza</a></li>
                <li><a href="addIngredienteForm.jsp">Adicionar Ingrediente a pizza</a></li>
                <li><a href="addIngredienteList.jsp">Remover Ingrediente a pizza</a></li>
            </ul>
        </li>
     
        <li><a href="#">Pedido</a>
            <ul>
                <li><a href="pedidoForm.jsp">Adicionar</a></li>
                <li><a href="pedidoList.jsp">Visualizar</a></li>                  
            </ul>
        </li>
        
        <li><a href="#">Itens dos Pedidos</a>
            <ul>
                <li><a href="itemForm.jsp">Adicionar</a></li>
                <li><a href="itemList.jsp">Visualizar</a></li>                  
            </ul>
        </li>
        
        <li><a href="#">Entrega</a>
            <ul>
                <li><a href="entregaForm.jsp">Adicionar</a></li>
                <li><a href="entregaList.jsp">Visualizar</a></li>                  
            </ul>
        </li>
        
        <li><a href="#">Consulta</a>
            <ul>
                <li><a href="defesa.jsp">Defesa</a></li>
                <li><a href="teste.jsp">Teste</a></li>
                <li><a href="pratica.jsp">Pratica</a></li>
            </ul>
        </li>
</ul>
</nav>
</body>
</html>
