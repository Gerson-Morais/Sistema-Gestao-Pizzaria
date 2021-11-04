/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import bean.Item;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import op_BD.ItemIO;

/**
 *
 * @author qraysoon
 */
public class ServletEliminarI extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Item i = new Item();
        
        String id = request.getParameter("id");
        
        i.setId(Integer.parseInt(id));
        
        new ItemIO().eliminarItem(i);
        response.sendRedirect("index.jsp");
    }

}
