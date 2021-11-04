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

public class Funcionario {

    private int id;
    private int fk_pessoa;
    private int fk_tipo;
    

    public Funcionario() {
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

    public int getFk_tipo() {
        return fk_tipo;
    }

    public void setFk_tipo(int fk_tipo) {
        this.fk_tipo = fk_tipo;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "id=" + id + ", fk_pessoa=" + fk_pessoa + ", fk_tipo=" + fk_tipo + '}';
    }  
}
