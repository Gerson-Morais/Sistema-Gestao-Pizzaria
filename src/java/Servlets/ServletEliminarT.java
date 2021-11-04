/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import bean.AddIngrediente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import op_BD.AddIngredienteIO;

/**
 *
 * @author qraysoon
 */
public class ServletEliminarT extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        AddIngrediente t = new AddIngrediente();
        
        String idPizza = request.getParameter("idPizza");
        String ingrediente = request.getParameter("idIngrediente");
        
        t.setFk_pizza(Integer.parseInt(idPizza));
        t.setFk_ingrediente(Integer.parseInt(ingrediente));
        
        new AddIngredienteIO().eliminarAddIngrediente(t);
        response.sendRedirect("index.jsp");
    }

}
