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
public class ServletSalvarCL extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Cliente cl = new Cliente();
        
        String idPessoa = request.getParameter("idPessoa");
        
        cl.setFk_pessoa(Integer.parseInt(idPessoa));
        
        new ClienteIO().salvarCliente(cl);
        response.sendRedirect("index.jsp");
    }

}
