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

public class Item {

    private int id;
    private int qtd;
    private int fk_pizza;
    private int fk_pedido;
    

    public Item() {
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getFk_pizza() {
        return fk_pizza;
    }

    public void setFk_pizza(int fk_pizza) {
        this.fk_pizza = fk_pizza;
    }

    public int getFk_pedido() {
        return fk_pedido;
    }

    public void setFk_pedido(int fk_pedido) {
        this.fk_pedido = fk_pedido;
    }

    
    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", qtd=" + qtd + ", fk_pizza=" + fk_pizza + ", fk_pedido=" + fk_pedido + '}';
    }

    
}
