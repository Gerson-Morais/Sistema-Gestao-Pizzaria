/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import bean.Pedido;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import op_BD.PedidoIO;

/**
 *
 * @author qraysoon
 */
public class ServletAlterarE extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Pedido e = new Pedido();

        String id = request.getParameter("id");
        String funcionario = request.getParameter("idFuncionario");
        String cliente = request.getParameter("idCliente");
        String tempo = request.getParameter("tempoMaximo");
        String data = request.getParameter("dataEmissao");
        String hora = request.getParameter("horaEmissao");
        
        e.setId(Integer.parseInt(id));
        e.setFk_funcionario(Integer.parseInt(funcionario));
        e.setFk_cliente(Integer.parseInt(cliente));
        e.setTempoMax(tempo);
        e.setDataEmissao(data);
        e.setHoraEmissao(hora);
        
        
        new PedidoIO().editarPedido(e);
        response.sendRedirect("index.jsp");
    }

}
