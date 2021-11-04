/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import bean.AddTamanho;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import op_BD.AddTamanhoIO;

/**
 *
 * @author qraysoon
 */
public class ServletEliminarA extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        AddTamanho a = new AddTamanho();
        
        String idPizza = request.getParameter("idPizza");
        String tamanho = request.getParameter("idTamanho");
        
        a.setFk_pizza(Integer.parseInt(idPizza));
        a.setFk_tamanho(Integer.parseInt(tamanho));
        
        new AddTamanhoIO().eliminarAddTamanho(a);
        response.sendRedirect("index.jsp");
    }

}
