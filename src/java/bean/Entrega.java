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

public class Entrega {

    private Integer id;
    private String hora;
    private Integer fk_pedido;
    private Integer fk_entregador;
    private String data;
    

    public Entrega() {
    }

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getFk_pedido() {
        return fk_pedido;
    }

    public void setFk_pedido(Integer fk_pedido) {
        this.fk_pedido = fk_pedido;
    }

    public Integer getFk_entregador() {
        return fk_entregador;
    }

    public void setFk_entregador(Integer fk_entregador) {
        this.fk_entregador = fk_entregador;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Entrega{" + "id=" + id + ", hora=" + hora + ", fk_pedido=" + fk_pedido + ", fk_entregador=" + fk_entregador + ", data=" + data + '}';
    }

    
    
}
