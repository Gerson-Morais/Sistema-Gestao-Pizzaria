/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op_BD;

import bean.AddIngrediente;
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
public class AddIngredienteIO {
    
   private Statement statement;
   private ConnectionBD conexao;
   private PreparedStatement pStAddIngrediente ;

    public AddIngredienteIO() {
        
        
        conexao = new ConnectionBD();
        
    }
    
    
    public  String selectAddIngrediente(int idPizza) 
    {
        
         StringBuffer html = new StringBuffer();
          
        try
        {

            statement = conexao.getConnection().createStatement();
             
                     
            //abrir a tag select
            html .append("<select name=\"idIngrediente\" id=\"idIngrediente\" >\n");
            
            ResultSet resultSet = statement.executeQuery( "SELECT ingrediente.id, ingrediente.nome\n" +
                                            "FROM public.ingrediente INNER JOIN public.pizza_ingrediente \n" +
                                            "ON ingrediente.id=pizza_ingrediente.fk_ingrediente\n" +
                                            "WHERE pizza_ingrediente.fk_pizza = "+idPizza+";" );
            
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
    
    
    public void salvarAddIngrediente(AddIngrediente t)
    {
             
       try 
       {
           
           pStAddIngrediente = conexao.getConnection().prepareStatement("INSERT INTO public.pizza_ingrediente(fk_pizza, fk_ingrediente) VALUES (?, ?);");

           pStAddIngrediente.setInt(1, t.getFk_pizza());
           pStAddIngrediente.setInt(2, t.getFk_ingrediente());
           
           pStAddIngrediente.executeUpdate();
            
           //fechar o cursor
           pStAddIngrediente.close();
           conexao.getConnection().close();
           
           
       } catch (SQLException ex) {
           Logger.getLogger(AddIngredienteIO.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
   
    
   public void eliminarAddIngrediente(AddIngrediente t)
    {
           
        try 
       {
           
           pStAddIngrediente = conexao.getConnection().prepareStatement("DELETE FROM public.pizza_ingrediente WHERE fk_pizza = "+t.getFk_pizza()+" and fk_ingrediente="+t.getFk_ingrediente()+" ;");

           pStAddIngrediente.executeUpdate();
            
           //fechar o cursor
           pStAddIngrediente.close();
           conexao.getConnection().close();
           
           
       } catch (SQLException ex) {
           Logger.getLogger(AddIngredienteIO.class.getName()).log(Level.SEVERE, null, ex);
       }        
    }
}
