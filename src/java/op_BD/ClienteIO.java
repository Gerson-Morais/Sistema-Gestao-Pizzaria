/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op_BD;

import bean.Cliente;
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
public class ClienteIO {
    
   private Statement statement;
   private ConnectionBD conexao;
   private PreparedStatement pStCliente ;

    public ClienteIO() {
        
        
        conexao = new ConnectionBD();
        
    }
    
   
    public  String selectCliente() 
    {
        
         StringBuffer html = new StringBuffer();
          
        try
        {

            statement = conexao.getConnection().createStatement();
             
                     
            //abrir a tag select
            html .append("<select name=\"idCliente\" id=\"idCliente\" >\n");
            
            ResultSet resultSet = statement.executeQuery( "SELECT cliente.id, pessoa.nome\n" +
                                                "FROM public.pessoa INNER JOIN public.cliente ON pessoa.id=cliente.fk_pessoa;" );
            
            while (resultSet.next())
            {
                html.append("<option value=\"" + resultSet.getInt(1) + "\" >" + resultSet.getString(2) + "</option>\n");  
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
    
    
    public Cliente getCliente(int idCliente) 
    {
        
         Cliente cl = new Cliente();
          
        try
        {

            statement = conexao.getConnection().createStatement();
                        
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM cliente where id = '"+idCliente+"';" );
            
            while (resultSet.next())
            {
                
                cl.setFk_pessoa(resultSet.getInt(2));
                cl.setId(idCliente);
                                
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
        
        return cl ;
    }
    
    
    public void salvarCliente(Cliente cl)
    {
             
       try 
       {
           
           pStCliente = conexao.getConnection().prepareStatement("INSERT INTO public.cliente(fk_pessoa) VALUES (?);");

           pStCliente.setInt(1, cl.getFk_pessoa());
           
           pStCliente.executeUpdate();
            
           //fechar o cursor
           pStCliente.close();
           conexao.getConnection().close();
           
           
       } catch (SQLException ex) {
           Logger.getLogger(ClienteIO.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
   
    
   public void eliminarCliente(Cliente cl)
    {
           
        try 
       {
           
           pStCliente = conexao.getConnection().prepareStatement("DELETE FROM public.cliente WHERE id = "+cl.getId()+";");

           pStCliente.executeUpdate();
            
           //fechar o cursor
           pStCliente.close();
           conexao.getConnection().close();
           
           
       } catch (SQLException ex) {
           Logger.getLogger(ClienteIO.class.getName()).log(Level.SEVERE, null, ex);
       }        
    }
   
    public  String selectCliente(int idCliente) 
    {
        
         StringBuffer html = new StringBuffer();
          
        try
        {

            statement = conexao.getConnection().createStatement();
             
                     
            //abrir a tag select
            html .append("<select name=\"idCliente\" id=\"idCliente\" >\n");
            
            ResultSet resultSet = statement.executeQuery( "SELECT cliente.id, pessoa.nome\n" +
                                                "FROM public.pessoa INNER JOIN public.cliente ON pessoa.id=cliente.fk_pessoa;" );
            
            while (resultSet.next())
            {
               
               String temp = "<option value=\"" + resultSet.getInt(1) + "\" ";
                
               if(resultSet.getInt(1) == idCliente )
                  temp +=" selected >" ;
               else
                   temp +=" > ";
                        
                        
              temp += resultSet.getString(2) + "</option>\n";
                
                
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
