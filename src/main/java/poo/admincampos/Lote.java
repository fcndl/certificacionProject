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
public class Lote {
    
    private Integer numeroLote;
    private Integer superficie;
    private TipoSuelo tipoSuelo;
    private Campo campo;
    
    public Lote(){
        
    }
    
    public Lote(Integer numeroLote, Integer superficie, TipoSuelo tipoSuelo,Campo campo){
        this.numeroLote = numeroLote;
        this.superficie = superficie;
        this.tipoSuelo = tipoSuelo;
        this.campo = campo;
    }
    
    public void setNumeroLote(Integer numeroLote){
        this.numeroLote = numeroLote;
    }
    
    public Integer getNumeroLote(){
        return numeroLote;
    }
    
    public void setSuperficie(Integer superficie){
        this.superficie = superficie;
    }
    
    public Integer getSuperficie(){
        return superficie;
    }
    
    public void setTipoSuelo(TipoSuelo tipoSuelo){
        this.tipoSuelo = tipoSuelo;
    }
    
    public TipoSuelo getTipoSuelo(){
        return tipoSuelo;
    }
    
    public void setCampo(Campo campo){
        this.campo = campo;
    }
    
    public Campo getCampo(){
        return campo;
    }
    
    
}
