/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import bean.Contacto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import op_BD.ContactoIO;

/**
 *
 * @author qraysoon
 */
public class ServletEliminarC extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Contacto c = new Contacto();
        
        String id = request.getParameter("id");
        
        c.setId(Integer.parseInt(id));
        
        new ContactoIO().eliminarContacto(c);
        response.sendRedirect("index.jsp");
    }

 
}
