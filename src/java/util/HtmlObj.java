/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

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
public class HtmlObj {
    
    
   private Statement statement;
   private ConnectionBD conexao;
   private PreparedStatement pStPessoa ;
   
   
    public HtmlObj() {
        
        conexao = new ConnectionBD();
  
    }
    
    
    public  String select(String tabela, String nome , int id ) 
    {
        
         StringBuffer html = new StringBuffer();
          
        try
        {

            
            statement = conexao.getConnection().createStatement();
             
                     
            //abrir a tag select
           html .append("<select name=\"" + nome + "\" " + "id=\"" + nome + "\" >\n");
            
            
            //adicionar uma option vazia
           // html.append("<option value=\"\">-- escolha --</option>\n");
           
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM "+tabela +" ;" );
            
            //para cada registo seleccionado, gerar um OPTION
            while (resultSet.next())
            {
               
               String temp = "<option value=\"" + resultSet.getInt(1) + "\" ";
                
               if(resultSet.getInt(1) == id )
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
    
    
    public String getElement(String tabela, String id ) 
    {
        
         String valor = "";
          
        try
        {

            
            statement = conexao.getConnection().createStatement();
             
                    
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM "+tabela +" where id = "+id+" ;" );
            
            //para cada registo seleccionado, gerar um OPTION
            while (resultSet.next())
            {
               valor = resultSet.getString(2);
                       
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
        
        return valor.trim();
    }    
    
    
   
    
}
