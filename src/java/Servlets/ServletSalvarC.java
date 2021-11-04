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
public class ServletSalvarC extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        Contacto c = new Contacto();
        
        String idPessoa = request.getParameter("idPessoa");
        String contacto = request.getParameter("contacto");
        
        c.setFk_pessoa(Integer.parseInt(idPessoa));
        c.setContacto(contacto);
        
        new ContactoIO().salvarContacto(c);
        response.sendRedirect("index.jsp");
        
        
    }

}
