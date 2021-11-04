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
public class Defesa 
{
    private int tipo;
    private int provincia;
    private String data1;
    private String data2;

    public Defesa() {
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getProvincia() {
        return provincia;
    }

    public void setProvincia(int provincia) {
        this.provincia = provincia;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    @Override
    public String toString() {
        return "Defesa{" + "tipo=" + tipo + ", provincia=" + provincia + ", data1=" + data1 + ", data2=" + data2 + '}';
    }
    
    
    
}
