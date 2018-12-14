/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.admincampos.controller;

import java.util.List;
import org.hibernate.SessionFactory;
import poo.admincampos.Campo;
import poo.admincampos.EstadoCampo;
import poo.admincampos.Lote;
import poo.admincampos.TipoSuelo;
import poo.admincampos.dao.CamposDao;
import poo.admincampos.dao.CamposDaoHibernateImpl;
import poo.admincampos.dao.EstadosCampoDao;
import poo.admincampos.dao.EstadosCampoDaoHibernateImpl;
import poo.admincampos.dao.LotesDao;
import poo.admincampos.dao.LotesDaoHibernateImpl;
import poo.admincampos.dao.TiposSueloDao;
import poo.admincampos.dao.TiposSueloDaoHibernateImpl;
import poo.admincampos.ui.PantallaRegistracionCampo;



/**
 *
 * @author facundo
 */
public class AdministradorCampos {
    
    private final SessionFactory sessionFactory;
    private final CamposDao camposDao;
    private final EstadosCampoDao estadosCampoDao;
    private final LotesDao lotesDao;
    private final TiposSueloDao tiposSueloDao;
    
    /**
     * Constructor por defecto.
     * @param sessionFactory
     */
    public AdministradorCampos(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        
        // creamos las instancias de los objetos de acceso a datos
        this.camposDao = new CamposDaoHibernateImpl(sessionFactory);
        this.estadosCampoDao = new EstadosCampoDaoHibernateImpl(sessionFactory);
        this.lotesDao = new LotesDaoHibernateImpl(sessionFactory);
        this.tiposSueloDao = new TiposSueloDaoHibernateImpl(sessionFactory);
    }

    public void run () {
        new PantallaRegistracionCampo(this).setVisible(true);
    }
    
    public List<TipoSuelo> obtenerTipoSuelos () {
        return tiposSueloDao.obtenerTipoSuelos();
    }
    
    public EstadoCampo getEstadoCreado(){
        return estadosCampoDao.getEstadoCreado();
    }
    
    public Campo buscarCampo(String nombre){
        return camposDao.buscarPorNombre(nombre);
    }
    
    public Lote buscarLote(Integer numeroLote){
        return lotesDao.buscarPorNumeroLote(numeroLote);
    }
    
    public boolean registrarCampo(List<Lote> lotes){
        
        Campo campo = lotes.get(0).getCampo();
        if(!camposDao.registrarCampo(campo)){
            return false;
        }
        if(!lotesDao.registrarLotes(lotes)){
            return false;
        }
        return true;
    }
}
