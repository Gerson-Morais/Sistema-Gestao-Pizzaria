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

public class Cliente {


    private int id;
    private int fk_pessoa;
    

    public Cliente() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_pessoa() {
        return fk_pessoa;
    }

    public void setFk_pessoa(int fk_pessoa) {
        this.fk_pessoa = fk_pessoa;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", fk_pessoa=" + fk_pessoa + '}';
    }
    
}
