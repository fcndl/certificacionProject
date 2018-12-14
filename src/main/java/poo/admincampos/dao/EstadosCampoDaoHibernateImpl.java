/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.admincampos.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.admincampos.EstadoCampo;

/**
 *
 * @author facundo
 */
public class EstadosCampoDaoHibernateImpl implements EstadosCampoDao {
    private final SessionFactory sessionFactory;

    public EstadosCampoDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public EstadoCampo getEstadoCreado() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Session session = sessionFactory.openSession();
        EstadoCampo estadoCampo = session.get(EstadoCampo.class, 1);
        session.close();
        return estadoCampo;
    }
    
    
}
