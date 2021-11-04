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
public class ServletSalvarP extends HttpServlet {

    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Pessoa p = new Pessoa();

        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobreNome");
        String data = request.getParameter("data");
        String sexo = request.getParameter("sexo");
        String morada =  request.getParameter("morada");
        
        p.setNome(nome);
        p.setSobrenome(sobrenome);
        p.setDataNasc(data);
        p.setFkSexo(Integer.parseInt(sexo));
        p.setFkMorada(Integer.parseInt(morada));
        
        new PessoaIO().salvarPessoa(p);
        response.sendRedirect("index.jsp");
    }

}
