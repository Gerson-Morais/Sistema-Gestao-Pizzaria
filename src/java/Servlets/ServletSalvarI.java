/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import bean.Item;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import op_BD.ItemIO;

/**
 *
 * @author qraysoon
 */
public class ServletSalvarI extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Item i = new Item();

        String pedido = request.getParameter("idPedido");
        String pizza = request.getParameter("pizza");
        String qtd = request.getParameter("qtd");
        
        i.setFk_pedido(Integer.parseInt(pedido));
        i.setFk_pizza(Integer.parseInt(pizza));
        i.setQtd(Integer.parseInt(qtd));
        
        new ItemIO().salvarItem(i);
        response.sendRedirect("index.jsp");
    }

}
