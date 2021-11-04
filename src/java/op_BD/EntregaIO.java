/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op_BD;

import bean.Entrega;
import java.sql.Date;
import util.ConnectionBD;
import util.HtmlObj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fdelgado
 */
public class EntregaIO {
    
   private Statement statement;
   private ConnectionBD conexao;
   private PreparedStatement pStEntrega ;

    public EntregaIO() {
        
        
        conexao = new ConnectionBD();
        
    }
    
   
    public  String selectEntrega() 
    {
        
         StringBuffer html = new StringBuffer();
          
        try
        {

            statement = conexao.getConnection().createStatement();
             
                     
            //abrir a tag select
            html .append("<select name=\"idEntrega\" id=\"idEntrega\" >\n");
            
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM public.entrega;" );
            
            while (resultSet.next())
            {
                html.append("<option value=\"" + resultSet.getString(1) + "\" >"+ resultSet.getString(2) + "</option>\n");  
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
    
    
    public Entrega getEntrega(int idEntrega) 
    {
        
         Entrega g = new Entrega();
          
        try
        {

            statement = conexao.getConnection().createStatement();
                        
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM entrega where id = '"+idEntrega+"';" );
            
            while (resultSet.next())
            {
                
                g.setData(resultSet.getString(2));
                g.setHora(resultSet.getString(3));
                g.setFk_pedido(resultSet.getInt(4));
                g.setFk_entregador(resultSet.getInt(5));
                g.setId(idEntrega);
                                
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
        
        return g ;
    }
    
    
   public void salvarEntrega(Entrega g)
    {
             
        try
        {
           
      
           pStEntrega = conexao.getConnection().prepareStatement("INSERT INTO public.entrega(\n" +
                                                            "	data, hora, fk_pedido, fk_entregador)\n" +
                                                            "	VALUES (?, ?, ?, ?);");           
           
           pStEntrega.setDate(1, Date.valueOf(g.getData()));
           pStEntrega.setTime(2, Time.valueOf(g.getHora()));
           pStEntrega.setInt(3, g.getFk_pedido());
           pStEntrega.setInt(4, g.getFk_entregador());
           
           pStEntrega.executeUpdate();
            
            //fechar o cursor
            pStEntrega.close();
            conexao.getConnection().close();
           
                
        }      
        catch(SQLException ex)
        {
           Logger.getLogger(HtmlObj.class.getName()).log(Level.SEVERE, null, ex);

        }  
    }
   
    
   public void editarEntrega(Entrega g)
    {
        
      try {
           
           pStEntrega = conexao.getConnection().prepareStatement("UPDATE public.entrega\n" +
                                        "	SET data=?, hora=?, fk_pedido=?, fk_entregador=?\n" +
                                        "	WHERE id="+g.getId()+";");
           
           pStEntrega.setDate(1, Date.valueOf(g.getData()));
           pStEntrega.setTime(2, Time.valueOf(g.getHora()));
           pStEntrega.setInt(3, g.getFk_pedido());
           pStEntrega.setInt(4, g.getFk_entregador());
           
           
            
           pStEntrega.executeUpdate();
            
            //fechar o cursor
            pStEntrega.close();
            conexao.getConnection().close();
           
       } catch (SQLException ex) {
           Logger.getLogger(EntregaIO.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }
   
    
   public void eliminarEntrega(Entrega g)
    {
             
      try 
      {
           
           pStEntrega = conexao.getConnection().prepareStatement("DELETE FROM public.entrega WHERE id ="+g.getId()+";");
           
           pStEntrega.executeUpdate();
           
           //fechar o cursor
           pStEntrega.close();
           conexao.getConnection().close();
           
       } 
      catch (SQLException ex) 
      {
           Logger.getLogger(EntregaIO.class.getName()).log(Level.SEVERE, null, ex);
      }
            
           
        
    }
   
}
