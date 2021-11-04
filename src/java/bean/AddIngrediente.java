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
public class AddIngrediente {
    
    private int fk_pizza;
    private int fk_ingrediente;

    public AddIngrediente() {
    }

    public int getFk_pizza() {
        return fk_pizza;
    }

    public void setFk_pizza(int fk_pizza) {
        this.fk_pizza = fk_pizza;
    }

    public int getFk_ingrediente() {
        return fk_ingrediente;
    }

    public void setFk_ingrediente(int fk_ingrediente) {
        this.fk_ingrediente = fk_ingrediente;
    }

    @Override
    public String toString() {
        return "AddIngrediente{" + "fk_pizza=" + fk_pizza + ", fk_ingrediente=" + fk_ingrediente + '}';
    }
    
}
