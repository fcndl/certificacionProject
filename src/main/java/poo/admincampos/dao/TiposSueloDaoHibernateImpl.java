/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.admincampos.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.admincampos.TipoSuelo;

/**
 *
 * @author facundo
 */
public class TiposSueloDaoHibernateImpl implements TiposSueloDao {
    private final SessionFactory sessionFactory;

    public TiposSueloDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<TipoSuelo> obtenerTipoSuelos() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session session = sessionFactory.openSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TipoSuelo> query = builder.createQuery(TipoSuelo.class);
        Root<TipoSuelo> root = query.from(TipoSuelo.class);
        query.select(root);
        //query.where(builder.equal(root.get("nombre"), nombre));
        List<TipoSuelo> tiposSuelo = session.createQuery(query).list();
        session.close();

        return tiposSuelo;
    }
}
