/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import bean.Pizza;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import op_BD.PizzaIO;

/**
 *
 * @author qraysoon
 */
public class ServletAlterarZ extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Pizza z = new Pizza();
        
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String preco = request.getParameter("preco");
        
        z.setId(Integer.parseInt(id));
        z.setNome(nome);
        z.setPreco(Double.parseDouble(preco));
        
        new PizzaIO().editarPizza(z);
        response.sendRedirect("index.jsp");
    }
}
