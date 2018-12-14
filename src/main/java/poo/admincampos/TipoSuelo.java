/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.admincampos;

/**
 *
 * @author facundo
 */
public class TipoSuelo {
    Integer id;
    String nombre;
    
    public TipoSuelo(){
    }
    
    public TipoSuelo(String nombre){
        this.nombre = nombre;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre= nombre;
    }
    
    public String toString() {
        return nombre;
    }
}
