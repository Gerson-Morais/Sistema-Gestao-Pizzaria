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

public class Pizza {
    
    
    private Integer id;
    private String nome;
    private Double preco;

    public Pizza() {
    }

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    
    @Override
    public String toString() {
        return "Pizza{" + "id=" + id + ", nome=" + nome + ", preco=" + preco + '}';
    }

   
    
}
