/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op_BD;

import bean.Defesa;
import java.sql.Date;
import util.ConnectionBD;
import util.HtmlObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fdelgado
 */
public class DefesaIO {
    
   private Statement statement;
   private ConnectionBD conexao;

    public DefesaIO() {
        
        
        conexao = new ConnectionBD();
        
    }
    
    
   
    public String defesaPessoa(Defesa d )
    {
        StringBuffer html = new StringBuffer() ;
        
        html.append("<select name=\"idPessoa\" id=\"idPessoa\" >\n");
        try
        {
            Date data1 = Date.valueOf(d.getData1());
            Date data2 = Date.valueOf(d.getData2());
            
            statement = conexao.getConnection().createStatement();
                        
            ResultSet resultSet = statement.executeQuery( "SELECT DISTINCT pessoa.id, pessoa.nome \n" +
"FROM public.pizza INNER JOIN public.item ON pizza.id=item.fk_pizza \n" +
"INNER JOIN public.pizza_tamanho ON pizza.id=pizza_tamanho.fk_pizza, public.pessoa INNER JOIN public.cliente ON pessoa.id=cliente.fk_pessoa \n" +
"INNER JOIN public.pedido ON cliente.id=pedido.fk_cliente\n" +
"INNER JOIN public.morada ON pessoa.fk_morada=morada.id\n" +
"INNER JOIN public.bairro ON morada.fk_bairro=bairro.id\n" +
"INNER JOIN public.municipio ON bairro.fk_municipio=municipio.id\n" +
"INNER JOIN public.provincia ON municipio.fk_provincia=provincia.id\n" +
"WHERE fk_tamanho = "+d.getTipo()+" AND item.fk_pedido=pedido.id AND provincia.id= "+d.getProvincia()+" \n" +
"AND pedido.data_emissao BETWEEN '"+data1+"' and '"+data2+"' ");

            while (resultSet.next())
            {  
                html.append( "<option value=\"" + resultSet.getInt(1) + "\"  >"+resultSet.getString(2) + "</option>\n");                   
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
        return html.toString() ;  
    }
    
     public String defesaPizza(int idPessoa, String data1,String data2, int tipo, int prov )
    {
        StringBuffer html = new StringBuffer() ;
        
        html.append("<select name=\"idPizza\" id=\"idPizza\" >\n");
        try
        {
            Date d1 = Date.valueOf(data1);
            Date d2 = Date.valueOf(data2);
            
            statement = conexao.getConnection().createStatement();
                        
            ResultSet resultSet = statement.executeQuery( "SELECT pizza.id, pizza.nome\n" +
"FROM public.pizza INNER JOIN public.item ON pizza.id=item.fk_pizza \n" +
"INNER JOIN public.pizza_tamanho ON pizza.id=pizza_tamanho.fk_pizza, public.pessoa INNER JOIN public.cliente ON pessoa.id=cliente.fk_pessoa \n" +
"INNER JOIN public.pedido ON cliente.id=pedido.fk_cliente\n" +
"INNER JOIN public.morada ON pessoa.fk_morada=morada.id\n" +
"INNER JOIN public.bairro ON morada.fk_bairro=bairro.id\n" +
"INNER JOIN public.municipio ON bairro.fk_municipio=municipio.id\n" +
"INNER JOIN public.provincia ON municipio.fk_provincia=provincia.id\n" +
"WHERE fk_tamanho = "+tipo+" AND item.fk_pedido=pedido.id AND provincia.id= "+prov+" \n" +
"AND pedido.data_emissao BETWEEN '"+d1+"' and '"+d2+"' AND pessoa.id="+idPessoa+"");

            while (resultSet.next())
            {  
                html.append( "<option value=\"" + resultSet.getInt(1) + "\"  >"+resultSet.getString(2) + "</option>\n");                   
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
        return html.toString() ;  
    }
     
    public String defesaPizza(int idFuncionario, int idCliente,int idEntregador,int idSexo, int ano, int mes1, int mes2)
    {
        StringBuffer html = new StringBuffer() ;
        
        html.append("<select name=\"idPizza\" id=\"idPizza\" >\n");
        try
        {
            
            statement = conexao.getConnection().createStatement();
                        
            ResultSet resultSet = statement.executeQuery( "SELECT pizza.id, pizza.nome\n" +
                    "FROM public.pizza INNER JOIN public.item ON pizza.id=item.fk_pizza\n" +
                    "INNER JOIN public.pedido ON item.fk_pedido=pedido.id\n" +
                    "INNER JOIN public.entrega ON pedido.id=entrega.fk_pedido\n" +
                    "INNER JOIN public.cliente ON pedido.fk_cliente=cliente.id\n" +
                    "INNER JOIN public.pessoa ON cliente.fk_pessoa=pessoa.id\n" +
"WHERE pedido.fk_funcionario ="+idFuncionario+" AND pedido.fk_cliente="+idCliente+" AND entrega.fk_entregador="+idEntregador+"\n" +
                    "AND pessoa.fk_sexo="+idSexo+" AND extract(year from data) = "+ano+" \n" +
                    "AND extract(month from data) BETWEEN "+mes1+" and "+mes2+";");

            while (resultSet.next())
            {  
                html.append( "<option value=\"" + resultSet.getInt(1) + "\"  >"+resultSet.getString(2) + "</option>\n");                   
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
        return html.toString() ;  
    }
    public  String selectEntregador(int tipo) 
    {
        
         StringBuffer html = new StringBuffer();
          
        try
        {

            statement = conexao.getConnection().createStatement();
             
                     
            //abrir a tag select
            html .append("<select name=\"idEntregador\" id=\"idEntregador\" >\n");
            
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
    
    public String defesaCliente(int pizza, int ano, int mes1, int mes2 )
    {
        StringBuffer html = new StringBuffer() ;
        
        html.append("<select name=\"idCliente\" id=\"idCliente\" >\n");
        try
        {
            
            statement = conexao.getConnection().createStatement();
                        
            ResultSet resultSet = statement.executeQuery( "SELECT DISTINCT cliente.id, pessoa.nome\n" +
                "FROM public.pessoa INNER JOIN public.cliente ON pessoa.id=cliente.fk_pessoa\n" +
                "INNER JOIN public.pedido ON cliente.id=pedido.fk_cliente\n" +
                "INNER JOIN public.item ON pedido.id=item.fk_pedido\n" +
                "WHERE item.fk_pizza="+pizza+"AND extract(year from pedido.data_emissao) = "+ano+" \n" +
                "AND extract(month from pedido.data_emissao) BETWEEN "+mes1+" and "+mes2+" ;");

            while (resultSet.next())
            {  
                html.append( "<option value=\"" + resultSet.getInt(1) + "\"  >"+resultSet.getString(2) + "</option>\n");                   
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
        return html.toString() ;  
    }
}
