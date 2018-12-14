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
import poo.admincampos.Campo;
import poo.admincampos.TipoSuelo;

/**
 *
 * @author facundo
 */
public class CamposDaoHibernateImpl implements CamposDao{

    private final SessionFactory sessionFactory;

    public CamposDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Campo buscarPorNombre(String nombre) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session session = sessionFactory.openSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Campo> query = builder.createQuery(Campo.class);
        Root<Campo> root = query.from(Campo.class);
        query.select(root);
        query.where(builder.equal(root.get("nombre"), nombre));
        
        Campo campo = session.createQuery(query).uniqueResult();
        session.close();

        return campo;
    }

    @Override
    public boolean registrarCampo(Campo campo) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(campo);
            session.getTransaction().commit();
            session.close();
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
}
