/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op_BD;

import bean.Pedido;
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
public class PedidoIO {
    
   private Statement statement;
   private ConnectionBD conexao;
   private PreparedStatement pStPedido ;

    public PedidoIO() {
        
        
        conexao = new ConnectionBD();
        
    }
    
   
    public  String selectPedido() 
    {
        
         StringBuffer html = new StringBuffer();
          
        try
        {

            statement = conexao.getConnection().createStatement();
             
                     
            //abrir a tag select
            html .append("<select name=\"idPedido\" id=\"idPedido\" >\n");
            
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM public.pedido;" );
            
            while (resultSet.next())
            {
                html.append("<option value=\"" + resultSet.getString(1) + "\" >"+ resultSet.getString(3) + "</option>\n");  
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
    
    
    public Pedido getPedido(int idPedido) 
    {
        
         Pedido e = new Pedido();
          
        try
        {

            statement = conexao.getConnection().createStatement();
                        
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM pedido where id = '"+idPedido+"';" );
            
            while (resultSet.next())
            {
                
                
                e.setTempoMax(resultSet.getString(2));
                e.setDataEmissao(resultSet.getString(3));
                e.setHoraEmissao(resultSet.getString(4));
                e.setFk_funcionario(resultSet.getInt(5));
                e.setFk_cliente(resultSet.getInt(6));
                e.setId(idPedido);
                                
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
        
        return e ;
    }
    
    
   public void salvarPedido(Pedido e)
    {
             
        try
        {
           
      
           pStPedido = conexao.getConnection().prepareStatement("INSERT INTO public.pedido(\n" +
                                "	tempo_max, data_emissao, hora_emissao, fk_funcionario, fk_cliente)\n" +
                                "	VALUES (?, ?, ?, ?, ?);");           
           
           
           pStPedido.setString(1, e.getTempoMax());
           pStPedido.setDate(2, Date.valueOf(e.getDataEmissao()));
           pStPedido.setTime(3, Time.valueOf(e.getHoraEmissao()));
           pStPedido.setInt(4, e.getFk_funcionario());
           pStPedido.setInt(5, e.getFk_cliente());
           
            
           pStPedido.executeUpdate();
            
            //fechar o cursor
            pStPedido.close();
            conexao.getConnection().close();
           
                
        }      
        catch(SQLException ex)
        {
           Logger.getLogger(HtmlObj.class.getName()).log(Level.SEVERE, null, ex);

        }  
    }
   
    
   public void editarPedido(Pedido e)
    {
        
      try {
           
           pStPedido = conexao.getConnection().prepareStatement("UPDATE public.pedido\n" +
                                    "	SET tempo_max=?, data_emissao=?, hora_emissao=?, fk_funcionario=?, fk_cliente=?\n" +
                                    "	WHERE id="+e.getId()+" ;");
           
           pStPedido.setString(1, e.getTempoMax());
           pStPedido.setDate(2, Date.valueOf(e.getDataEmissao()));
           pStPedido.setTime(3, Time.valueOf(e.getHoraEmissao()));
           pStPedido.setInt(4, e.getFk_funcionario());
           pStPedido.setInt(5, e.getFk_cliente());
           
           
           pStPedido.executeUpdate();
           
           //fechar o cursor
           pStPedido.close();
           conexao.getConnection().close();
           
       } catch (SQLException ex) {
           Logger.getLogger(PedidoIO.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }
   
    
   public void eliminarPedido(Pedido e)
    {
             
      try 
      {
           
           pStPedido = conexao.getConnection().prepareStatement("DELETE FROM public.pedido WHERE id ="+e.getId()+";");
           
           pStPedido.executeUpdate();
           
           //fechar o cursor
           pStPedido.close();
           conexao.getConnection().close();
           
       } 
      catch (SQLException ex) 
      {
           Logger.getLogger(PedidoIO.class.getName()).log(Level.SEVERE, null, ex);
      }
                   
        
    }
   
    public  String selectPedido(int idPedido) 
    {
        
         StringBuffer html = new StringBuffer();
          
        try
        {

            statement = conexao.getConnection().createStatement();
             
                     
            //abrir a tag select
            html .append("<select name=\"idPedido\" id=\"idPedido\" >\n");
            
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM public.pedido;" );
            
            while (resultSet.next())
            {
               
               String temp = "<option value=\"" + resultSet.getInt(1) + "\" ";
                
               if(resultSet.getInt(1) == idPedido )
                  temp +=" selected >" ;
               else
                   temp +=" > ";
                        
                        
              temp += resultSet.getString(3) + "</option>\n";
                
                
                html.append(temp);  
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
   
}
