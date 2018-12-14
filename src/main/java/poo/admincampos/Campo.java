/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.admincampos;

import java.util.List;

/**
 *
 * @author facundo
 */
public class Campo {
    
    private Integer id;
    private String nombre;
    private EstadoCampo estado;
    private List<Lote> lotes;
    
    /**
     * Constructor por defecto de la clase Campo.
     */
    public Campo() {
    }
 
    /**
     * Constructor con todos los atributos de la clase Campo.
     * @param ingredientes
     * @param nombre 
     */
    public Campo(String nombre, EstadoCampo estado) {
        this.nombre = nombre;
        this.estado = estado;
        //this.lotes = lotes;
    }

    // A continuación se listan todos los métodos de seteo
    // de cada atributo de la clase
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public EstadoCampo getEstado() {
        return estado;
    }

    public void setEstado(EstadoCampo estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setLotes(List<Lote> lotes){
        this.lotes = lotes;
    }
    
    public List<Lote> getLotes(){
        return this.lotes;
    }
    
    public Integer getSuperficie(){
        Integer superficie = 0;
        for(Lote lote: lotes){
            superficie += lote.getSuperficie();
        }
        return superficie;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
}
