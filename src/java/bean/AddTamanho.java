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
public class AddTamanho {
    
    private int fk_pizza;
    private int fk_tamanho;

    public AddTamanho() {
    }

    public int getFk_pizza() {
        return fk_pizza;
    }

    public void setFk_pizza(int fk_pizza) {
        this.fk_pizza = fk_pizza;
    }

    public int getFk_tamanho() {
        return fk_tamanho;
    }

    public void setFk_tamanho(int fk_tamnho) {
        this.fk_tamanho = fk_tamnho;
    }

    @Override
    public String toString() {
        return "AddTamanho{" + "fk_pizza=" + fk_pizza + ", fk_tamnho=" + fk_tamanho + '}';
    }
    
}
