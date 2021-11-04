/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import bean.Cliente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import op_BD.ClienteIO;

/**
 *
 * @author qraysoon
 */
public class ServletEliminarCL extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Cliente cl = new Cliente();
        
        String id = request.getParameter("idCliente");
        
        cl.setId(Integer.parseInt(id));
        
        new ClienteIO().eliminarCliente(cl);
        response.sendRedirect("index.jsp");
    }


}
