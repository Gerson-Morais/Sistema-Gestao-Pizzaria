/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op_BD;

import bean.Funcionario;
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
public class FuncionarioIO {
    
   private Statement statement;
   private ConnectionBD conexao;
   private PreparedStatement pStFuncionario ;

    public FuncionarioIO() {
        
        
        conexao = new ConnectionBD();
        
    }
    
   
    public  String selectFuncionario() 
    {
        
         StringBuffer html = new StringBuffer();
          
        try
        {

            statement = conexao.getConnection().createStatement();
             
                     
            //abrir a tag select
            html .append("<select name=\"idFuncionario\" id=\"idFuncionario\" >\n");
            
            ResultSet resultSet = statement.executeQuery( "SELECT funcionario.id, pessoa.nome\n" +
                                                "FROM public.pessoa INNER JOIN public.funcionario ON pessoa.id=funcionario.fk_pessoa;" );
            
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
    
    
    public Funcionario getFuncionario(int idFuncionario) 
    {
        
         Funcionario f = new Funcionario();
          
        try
        {

            statement = conexao.getConnection().createStatement();
                        
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM funcionario where id = '"+idFuncionario+"';" );
            
            while (resultSet.next())
            {
                f.setFk_tipo(resultSet.getInt(2));
                f.setFk_pessoa(resultSet.getInt(3));
                f.setId(idFuncionario);
                                
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
        
        return f ;
    }
    
    
    public void salvarFuncionario(Funcionario f)
    {
             
       try 
       {
           
           pStFuncionario = conexao.getConnection().prepareStatement("INSERT INTO public.funcionario( fk_tipo, fk_pessoa) VALUES (?, ?);");

           pStFuncionario.setInt(1, f.getFk_tipo());
           pStFuncionario.setInt(2, f.getFk_pessoa());
           
           pStFuncionario.executeUpdate();
            
           //fechar o cursor
           pStFuncionario.close();
           conexao.getConnection().close();
           
           
       } catch (SQLException ex) {
           Logger.getLogger(FuncionarioIO.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
   
    public void editarFuncionario(Funcionario f)
    {
             
        try 
       {
           
           pStFuncionario = conexao.getConnection().prepareStatement("UPDATE public.funcionario\n" +
                                                                "	SET fk_tipo=? \n" +
                                                                "	WHERE id= "+f.getId()+";");

           pStFuncionario.setInt(1, f.getFk_tipo());
           
           pStFuncionario.executeUpdate();
            
           //fechar o cursor
           pStFuncionario.close();
           conexao.getConnection().close();
           
           
       } catch (SQLException ex) {
           Logger.getLogger(ContactoIO.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
   public void eliminarFuncionario(Funcionario f)
    {
           
        try 
       {
           
           pStFuncionario = conexao.getConnection().prepareStatement("DELETE FROM public.funcionario WHERE id = "+f.getId()+";");

           pStFuncionario.executeUpdate();
            
           //fechar o cursor
           pStFuncionario.close();
           conexao.getConnection().close();
           
           
       } catch (SQLException ex) {
           Logger.getLogger(FuncionarioIO.class.getName()).log(Level.SEVERE, null, ex);
       }        
    }
   
   public  String selectFuncionario(int tipo) 
    {
        
         StringBuffer html = new StringBuffer();
          
        try
        {

            statement = conexao.getConnection().createStatement();
             
                     
            //abrir a tag select
            html .append("<select name=\"idFuncionario\" id=\"idFuncionario\" >\n");
            
            ResultSet resultSet = statement.executeQuery( "SELECT funcionario.id, pessoa.nome\n" +
                                                        "FROM public.pessoa INNER JOIN public.funcionario ON pessoa.id=funcionario.fk_pessoa\n" +
                                                        "WHERE funcionario.fk_tipo="+tipo+";" );
            
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
   
    public  String selectFuncionario(int tipo, int idFuncionario) 
    {
        
         StringBuffer html = new StringBuffer();
          
        try
        {

            statement = conexao.getConnection().createStatement();
             
                     
            //abrir a tag select
            html .append("<select name=\"idFuncionario\" id=\"idFuncionario\" >\n");
            
            ResultSet resultSet = statement.executeQuery( "SELECT funcionario.id, pessoa.nome\n" +
                                                        "FROM public.pessoa INNER JOIN public.funcionario ON pessoa.id=funcionario.fk_pessoa\n" +
                                                        "WHERE funcionario.fk_tipo="+tipo+";" );
            
            while (resultSet.next())
            {
               
               String temp = "<option value=\"" + resultSet.getInt(1) + "\" ";
                
               if(resultSet.getInt(1) == idFuncionario )
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
