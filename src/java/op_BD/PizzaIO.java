/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op_BD;

import util.ConnectionBD;
import util.HtmlObj;
import bean.Pizza;
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
public class PizzaIO {
    
   private Statement statement;
   private ConnectionBD conexao;
   private PreparedStatement pStPizza ;

    public PizzaIO() {
        
        
        conexao = new ConnectionBD();
        
    }
    
   
    public  String selectPizza() 
    {
        
         StringBuffer html = new StringBuffer();
          
        try
        {

            statement = conexao.getConnection().createStatement();
             
                     
            //abrir a tag select
            html .append("<select name=\"idPizza\" id=\"idPizza\" >\n");
            
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM public.pizza;" );
            
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
    
    
    public Pizza getPizza(int idPizza) 
    {
        
         Pizza z = new Pizza();
          
        try
        {

            statement = conexao.getConnection().createStatement();
                        
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM pizza where id = '"+idPizza+"';" );
            
            while (resultSet.next())
            {
                
                z.setNome(resultSet.getString(2));
                z.setPreco(Double.parseDouble(resultSet.getString(3)));
                z.setId(idPizza);
                                
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
        
        return z ;
    }
    
    
   public void salvarPizza(Pizza z)
    {
             
        try
        {
           
      
           pStPizza = conexao.getConnection().prepareStatement("INSERT INTO public.pizza(\n" +
                                                                "	nome, preco)\n" +
                                                                "	VALUES (?, ?);");           
           pStPizza.setString(1, z.getNome());
           pStPizza.setDouble(2, z.getPreco());
          
           pStPizza.executeUpdate();
            
            //fechar o cursor
            pStPizza.close();
            conexao.getConnection().close();
           
                
        }      
        catch(SQLException ex)
        {
           Logger.getLogger(HtmlObj.class.getName()).log(Level.SEVERE, null, ex);

        }  
    }
   
    
   public void editarPizza(Pizza z)
    {
        
      try {
           
           pStPizza = conexao.getConnection().prepareStatement("UPDATE public.pizza\n" +
                                                                "	SET nome=?, preco=?\n" +
                                                                "	WHERE id = "+z.getId()+";");
           
           pStPizza.setString(1, z.getNome());
           pStPizza.setDouble(2, z.getPreco());
           
           
           
           pStPizza.executeUpdate();
           
           //fechar o cursor
           pStPizza.close();
           conexao.getConnection().close();
           
       } catch (SQLException ex) {
           Logger.getLogger(PizzaIO.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }
   
    
   public void eliminarPizza(Pizza z)
    {
             
      try 
      {
           
           pStPizza = conexao.getConnection().prepareStatement("DELETE FROM public.pizza WHERE id ="+z.getId()+";");
           
           pStPizza.executeUpdate();
           
           //fechar o cursor
           pStPizza.close();
           conexao.getConnection().close();
           
       } 
      catch (SQLException ex) 
      {
           Logger.getLogger(PizzaIO.class.getName()).log(Level.SEVERE, null, ex);
      }
            
           
        
    }
   
}
