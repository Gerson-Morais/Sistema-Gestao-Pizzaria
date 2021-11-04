/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import bean.Pessoa;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import op_BD.PessoaIO;

/**
 *
 * @author qraysoon
 */
public class ServletEliminarP extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        Pessoa p = new Pessoa();
        
        String id = request.getParameter("id");
        
        p.setId(Integer.parseInt(id));
        
        new PessoaIO().eliminarPessoa(p);
        response.sendRedirect("index.jsp");
    }

}
