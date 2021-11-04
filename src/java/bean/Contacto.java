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

public class Contacto {

    
    private int id;
    private String contacto;
    private int fk_pessoa;

    public Contacto() 
    {
    }

    
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getFk_pessoa() {
        return fk_pessoa;
    }

    public void setFk_pessoa(int fk_pessoa) {
        this.fk_pessoa = fk_pessoa;
    }

    
    @Override
    public String toString() {
        return "Contacto{" + "id=" + id + ", contacto=" + contacto + ", fk_pessoa=" + fk_pessoa + '}';
    }    
}
