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
public class EstadoCampo {
    
    private Integer id;
    private String nombre;
    
    /**
     * Constructor por defecto de la clase EstadoCampo.
     */
    public EstadoCampo() {
    }
 
    /**
     * Constructor con todos los atributos de la clase EstadoCampo.
     * @param nombre 
     */
    public EstadoCampo(String nombre) {
        this.nombre = nombre;
    }

    // A continuación se listan todos los métodos de seteo
    // de cada atributo de la clase
    
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
        this.nombre = nombre;
    }
}
