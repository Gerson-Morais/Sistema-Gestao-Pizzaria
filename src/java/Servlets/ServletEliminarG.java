/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import bean.Entrega;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import op_BD.EntregaIO;

/**
 *
 * @author qraysoon
 */
public class ServletEliminarG extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Entrega g = new Entrega();
        
        String id = request.getParameter("id");
        
        g.setId(Integer.parseInt(id));
        
        new EntregaIO().eliminarEntrega(g);
        response.sendRedirect("index.jsp");
    }

}
