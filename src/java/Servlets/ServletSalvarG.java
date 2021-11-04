/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import bean.Entrega;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import op_BD.EntregaIO;

/**
 *
 * @author qraysoon
 */
public class ServletSalvarG extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Entrega g = new Entrega();

        String pedido = request.getParameter("idPedido");
        String entregador = request.getParameter("idFuncionario");
        String data = request.getParameter("dataEntrega");
        String hora = request.getParameter("horaEntrega");
        
        g.setFk_pedido(Integer.parseInt(pedido));
        g.setFk_entregador(Integer.parseInt(entregador));
        g.setData(data);
        g.setHora(hora);
        
        new EntregaIO().salvarEntrega(g);
        response.sendRedirect("index.jsp");
    }
}
