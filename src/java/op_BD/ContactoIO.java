/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op_BD;

import bean.Contacto;
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
public class ContactoIO {
    
   private Statement statement;
   private ConnectionBD conexao;
   private PreparedStatement pStContacto ;

    public ContactoIO() {
        
        
        conexao = new ConnectionBD();
        
    }
    
   
    public  String selectContacto(int idPessoa) 
    {
        
         StringBuffer html = new StringBuffer();
          
        try
        {

            statement = conexao.getConnection().createStatement();
             
                     
            //abrir a tag select
            html .append("<select name=\"idContacto\" id=\"idContacto\" >\n");
            
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM contacto where fk_pessoa = "+idPessoa+";" );
            
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
    
    
    public Contacto getContacto(int idContacto) 
    {
        
         Contacto c = new Contacto();
          
        try
        {

            statement = conexao.getConnection().createStatement();
                        
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM contacto where id = '"+idContacto+"';" );
            
            while (resultSet.next())
            {
                
                c.setContacto(resultSet.getString(2));
                c.setFk_pessoa(Integer.parseInt(resultSet.getString(3)));
                c.setId(idContacto);
                                
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
        
        return c ;
    }
    
    
   public void salvarContacto(Contacto c)
    {
             
       try 
       {
           
           pStContacto = conexao.getConnection().prepareStatement("INSERT INTO public.contacto(contacto, fk_pessoa) VALUES (?, ?);");

           pStContacto.setString(1, c.getContacto());
           pStContacto.setInt(2, c.getFk_pessoa());
           
           pStContacto.executeUpdate();
            
           //fechar o cursor
           pStContacto.close();
           conexao.getConnection().close();
           
           
       } catch (SQLException ex) {
           Logger.getLogger(ContactoIO.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
   
    
   public void editarContacto(Contacto c)
    {
             
        try 
       {
           
           pStContacto = conexao.getConnection().prepareStatement("UPDATE public.contacto\n" +
                                                               "	SET contacto=?, fk_pessoa=?\n" +
                                                               "	WHERE id = "+c.getId()+";");

           pStContacto.setString(1, c.getContacto());
           pStContacto.setInt(2, c.getFk_pessoa());
           
           pStContacto.executeUpdate();
            
           //fechar o cursor
           pStContacto.close();
           conexao.getConnection().close();
           
           
       } catch (SQLException ex) {
           Logger.getLogger(ContactoIO.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
   
    
   public void eliminarContacto(Contacto c)
    {
           
        try 
       {
           
           pStContacto = conexao.getConnection().prepareStatement("DELETE FROM public.contacto WHERE id = "+c.getId()+";");

           pStContacto.executeUpdate();
            
           //fechar o cursor
           pStContacto.close();
           conexao.getConnection().close();
           
           
       } catch (SQLException ex) {
           Logger.getLogger(ContactoIO.class.getName()).log(Level.SEVERE, null, ex);
       }        
    }
}
