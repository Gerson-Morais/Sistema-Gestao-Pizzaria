/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op_BD;

import util.ConnectionBD;
import util.HtmlObj;
import bean.Pessoa;
import java.sql.Date;
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
public class PessoaIO {
    
   private Statement statement;
   private ConnectionBD conexao;
   private PreparedStatement pStPessoa ;

    public PessoaIO() {
        
        
        conexao = new ConnectionBD();
        
    }
    
   
    public  String selectPessoa() 
    {
        
         StringBuffer html = new StringBuffer();
          
        try
        {

            statement = conexao.getConnection().createStatement();
             
                     
            //abrir a tag select
            html .append("<select name=\"idPessoa\" id=\"idPessoa\" >\n");
            
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM public.pessoa;" );
            
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
    
    
    public Pessoa getPessoa(int idPessoa) 
    {
        
         Pessoa p = new Pessoa();
          
        try
        {

            statement = conexao.getConnection().createStatement();
                        
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM pessoa where id = '"+idPessoa+"';" );
            
            while (resultSet.next())
            {
                
                p.setNome(resultSet.getString(2));
                p.setSobrenome(resultSet.getString(3));
                p.setDataNasc(resultSet.getString(4));
                p.setFkMorada(resultSet.getInt(5));
                p.setFkSexo(resultSet.getInt(6));
                p.setId(idPessoa);
                                
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
        
        return p ;
    }
    
    
   public void salvarPessoa(Pessoa p)
    {
             
        try
        {
           
      
           pStPessoa = conexao.getConnection().prepareStatement("INSERT INTO public.pessoa(\n" +
                                                      "	nome, sobrenome, data_nasc, fk_morada, fk_sexo)\n" +
                                                      "	VALUES (?, ?, ?, ?, ?);");           
           pStPessoa.setString(1, p.getNome());
           pStPessoa.setString(2, p.getSobrenome());
           pStPessoa.setDate(3, Date.valueOf(p.getDataNasc()));
           pStPessoa.setInt(4, p.getFkMorada());
           pStPessoa.setInt(5, p.getFkSexo());
           
            
           pStPessoa.executeUpdate();
            
            //fechar o cursor
            pStPessoa.close();
            conexao.getConnection().close();
           
                
        }      
        catch(SQLException ex)
        {
           Logger.getLogger(HtmlObj.class.getName()).log(Level.SEVERE, null, ex);

        }  
    }
   
    
   public void editarPessoa(Pessoa p)
    {
        
      try {
           
           pStPessoa = conexao.getConnection().prepareStatement("UPDATE public.pessoa\n" +
                                "	SET nome=?, sobrenome=?, data_nasc=?, fk_morada=?, fk_sexo=?\n" +
                                "	WHERE id="+p.getId()+" ;");
           
           pStPessoa.setString(1, p.getNome());
           pStPessoa.setString(2, p.getSobrenome());
           pStPessoa.setDate(3, Date.valueOf(p.getDataNasc()));
           pStPessoa.setInt(4, p.getFkMorada());
           pStPessoa.setInt(5, p.getFkSexo());
           
           
           pStPessoa.executeUpdate();
           
           //fechar o cursor
           pStPessoa.close();
           conexao.getConnection().close();
           
       } catch (SQLException ex) {
           Logger.getLogger(PessoaIO.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }
   
    
   public void eliminarPessoa(Pessoa p)
    {
             
      try 
      {
           
           pStPessoa = conexao.getConnection().prepareStatement("DELETE FROM public.pessoa WHERE id ="+p.getId()+";");
           
           pStPessoa.executeUpdate();
           
           //fechar o cursor
           pStPessoa.close();
           conexao.getConnection().close();
           
       } 
      catch (SQLException ex) 
      {
           Logger.getLogger(PessoaIO.class.getName()).log(Level.SEVERE, null, ex);
      }   
    }

}
