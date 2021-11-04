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
public class ServletEliminarE extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Pedido e = new Pedido();

        String id = request.getParameter("id");
        
        e.setId(Integer.parseInt(id));
        
        new PedidoIO().eliminarPedido(e);
        response.sendRedirect("index.jsp");
        
    }
}
