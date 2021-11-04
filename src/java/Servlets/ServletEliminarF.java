/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import bean.Funcionario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import op_BD.FuncionarioIO;

/**
 *
 * @author qraysoon
 */
public class ServletEliminarF extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Funcionario f = new Funcionario();
        
        String id = request.getParameter("id");
        
        f.setId(Integer.parseInt(id));
        
        new FuncionarioIO().eliminarFuncionario(f);
        response.sendRedirect("index.jsp");
    }


}
