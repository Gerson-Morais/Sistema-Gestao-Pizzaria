/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
/**
 *
 * @author qraysoon
 */
public class Pessoa {

    private String nome;
    private String sobrenome;
    private String dataNasc;
    private int fkMorada;
    private int fkSexo;
    private int id;

//Constructors
    public Pessoa() 
    {
    }

 
//Getters and Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public int getFkSexo() {
        return fkSexo;
    }

    public void setFkSexo(int fkSexo) {
        this.fkSexo = fkSexo;
    }
    
    public int getFkMorada() {
        return fkMorada;
    }

    public void setFkMorada(int fkMorada) {
        this.fkMorada = fkMorada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", sobrenome=" + sobrenome + ", dataNasc=" + dataNasc + ", fkMorada=" + fkMorada + ", fkSexo=" + fkSexo + ", id=" + id + '}';
    }

}
