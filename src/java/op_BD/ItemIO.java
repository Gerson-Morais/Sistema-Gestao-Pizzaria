/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op_BD;

import bean.Item;
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
public class ItemIO {
    
   private Statement statement;
   private ConnectionBD conexao;
   private PreparedStatement pStItem ;

    public ItemIO() {
        
        
        conexao = new ConnectionBD();
        
    }
    
   
    public  String selectItem() 
    {
        
         StringBuffer html = new StringBuffer();
          
        try
        {

            statement = conexao.getConnection().createStatement();
             
                     
            //abrir a tag select
            html .append("<select name=\"idItem\" id=\"idItem\" >\n");
            
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM public.item;" );
            
            while (resultSet.next())
            {
                html.append("<option value=\"" + resultSet.getInt(1) + "\" >"+ resultSet.getInt(2) + "</option>\n");  
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
    
    
    public Item getItem(int idItem) 
    {
        
         Item i = new Item();
          
        try
        {

            statement = conexao.getConnection().createStatement();
                        
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM item where id = '"+idItem+"';" );
            
            while (resultSet.next())
            {
                
                i.setQtd(resultSet.getInt(2));
                i.setFk_pizza(resultSet.getInt(3));
                i.setFk_pedido(resultSet.getInt(4));
                i.setId(idItem);
                                
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
        
        return i ;
    }
    
    
   public void salvarItem(Item i)
    {
             
        try
        {
           
      
           pStItem = conexao.getConnection().prepareStatement("INSERT INTO public.item(\n" +
                                                        "	qtd, fk_pizza, fk_pedido)\n" +
                                                        "	VALUES (?, ?, ?);");           
           
           pStItem.setInt(1, i.getQtd());
           pStItem.setInt(2, i.getFk_pizza());
           pStItem.setInt(3, i.getFk_pedido());
           
            
           pStItem.executeUpdate();
            
           //fechar o cursor
           pStItem.close();
           conexao.getConnection().close();
           
                
        }      
        catch(SQLException ex)
        {
           Logger.getLogger(HtmlObj.class.getName()).log(Level.SEVERE, null, ex);

        }  
    }
   
    
   public void editarItem(Item i)
    {
        
      try {
           
           pStItem = conexao.getConnection().prepareStatement("UPDATE public.item\n" +
                                            "	SET qtd=?, fk_pizza=?, fk_pedido=?\n" +
                                            "	WHERE id="+i.getId()+";");
           
           pStItem.setInt(1, i.getQtd());
           pStItem.setInt(2, i.getFk_pizza());
           pStItem.setInt(3, i.getFk_pedido());
           
           
           pStItem.executeUpdate();
           
           //fechar o cursor
           pStItem.close();
           conexao.getConnection().close();
           
       } catch (SQLException ex) {
           Logger.getLogger(ItemIO.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }
   
    
   public void eliminarItem(Item i)
    {
             
      try 
      {
           
           pStItem = conexao.getConnection().prepareStatement("DELETE FROM public.item WHERE id ="+i.getId()+";");
           
           pStItem.executeUpdate();
           
           //fechar o cursor
           pStItem.close();
           conexao.getConnection().close();
           
       } 
      catch (SQLException ex) 
      {
           Logger.getLogger(ItemIO.class.getName()).log(Level.SEVERE, null, ex);
      }
                   
        
    }
   
}
