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

public class Pedido {

    
    private Integer id;
    private String tempoMax;
    private String dataEmissao;
    private int fk_funcionario;
    private int fk_cliente;
    private String horaEmissao;

    public Pedido() {
    }

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTempoMax() {
        return tempoMax;
    }

    public void setTempoMax(String tempoMax) {
        this.tempoMax = tempoMax;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public int getFk_funcionario() {
        return fk_funcionario;
    }

    public void setFk_funcionario(int fk_funcionario) {
        this.fk_funcionario = fk_funcionario;
    }

    public int getFk_cliente() {
        return fk_cliente;
    }

    public void setFk_cliente(int fk_cliente) {
        this.fk_cliente = fk_cliente;
    }

    public String getHoraEmissao() {
        return horaEmissao;
    }

    public void setHoraEmissao(String horaEmissao) {
        this.horaEmissao = horaEmissao;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", tempoMax=" + tempoMax + ", dataEmissao=" + dataEmissao + ", fk_funcionario=" + fk_funcionario + ", fk_cliente=" + fk_cliente + ", horaEmissao=" + horaEmissao + '}';
    }
    
}
