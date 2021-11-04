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
public class ServletAlterarF extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Funcionario f = new Funcionario();
        
        String id = request.getParameter("id");
        String tipo = request.getParameter("tipo");
        
        f.setId(Integer.parseInt(id));
        f.setFk_tipo(Integer.parseInt(tipo));
        
        new FuncionarioIO().editarFuncionario(f);
        response.sendRedirect("index.jsp");
    }


}
