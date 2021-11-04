/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op_BD;

import bean.AddTamanho;
import util.ConnectionBD;
import util.HtmlObj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fdelgado
 */
public class AddTamanhoIO {
    
   private Statement statement;
   private ConnectionBD conexao;
   private PreparedStatement pStAddTamanho ;

    public AddTamanhoIO() {
        
        
        conexao = new ConnectionBD();
        
    }
    
    
    public  String selectAddTamanho(int idPizza) 
    {
        
         StringBuffer html = new StringBuffer();
          
        try
        {

            statement = conexao.getConnection().createStatement();
             
                     
            //abrir a tag select
            html .append("<select name=\"idTamanho\" id=\"idTamanho\" >\n");
            
            ResultSet resultSet = statement.executeQuery( "SELECT tamanho.id, tamanho.tamanho\n" +
                                            "FROM public.tamanho INNER JOIN public.pizza_tamanho \n" +
                                            "ON tamanho.id=pizza_tamanho.fk_tamanho\n" +
                                            "WHERE pizza_tamanho.fk_pizza = "+idPizza+";" );
            
            while (resultSet.next())
            {
                html.append("<option value=\"" + resultSet.getString(1) + "\" >" + resultSet.getString(2) + "</option>\n");  
            }
            
            //fechar o cursor
            resultSet.close();
            statement.close();
            conexao.getConnection().close();
            
        }      
        catch(SQLException ex)
        {
           Logger.getLogger(HtmlObj.class.getName()).log(Level.SEVERE, null, ex);

        }  
        html.append("</select>");
        return html.toString();
    }
    
    
    public void salvarAddTamanho(AddTamanho a)
    {
             
       try 
       {
           
           pStAddTamanho = conexao.getConnection().prepareStatement("INSERT INTO public.pizza_tamanho(fk_pizza, fk_tamanho) VALUES (?, ?);");

           pStAddTamanho.setInt(1, a.getFk_pizza());
           pStAddTamanho.setInt(2, a.getFk_tamanho());
           
           pStAddTamanho.executeUpdate();
            
           //fechar o cursor
           pStAddTamanho.close();
           conexao.getConnection().close();
           
           
       } catch (SQLException ex) {
           Logger.getLogger(AddTamanhoIO.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
   
    
   public void eliminarAddTamanho(AddTamanho a)
    {
           
        try 
       {
           
           pStAddTamanho = conexao.getConnection().prepareStatement("DELETE FROM public.pizza_tamanho WHERE fk_pizza = "+a.getFk_pizza()+" and fk_tamanho="+a.getFk_tamanho()+" ;");

           pStAddTamanho.executeUpdate();
            
           //fechar o cursor
           pStAddTamanho.close();
           conexao.getConnection().close();
           
           
       } catch (SQLException ex) {
           Logger.getLogger(AddTamanhoIO.class.getName()).log(Level.SEVERE, null, ex);
       }        
    }
}
