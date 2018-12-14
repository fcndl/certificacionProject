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
import poo.admincampos.Lote;

/**
 *
 * @author facundo
 */
public class LotesDaoHibernateImpl implements LotesDao {

    private final SessionFactory sessionFactory;

    public LotesDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public Lote buscarPorNumeroLote(Integer numeroLote) {
        Session session = sessionFactory.openSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Lote> query = builder.createQuery(Lote.class);
        Root<Lote> root = query.from(Lote.class);
        query.select(root);
        query.where(builder.equal(root.get("numeroLote"), numeroLote));
        
        Lote lote = session.createQuery(query).uniqueResult();
        session.close();

        return lote;
    }

    @Override
    public boolean registrarLotes(List<Lote> lotes) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            for(Lote lote: lotes){
                session.save(lote);
            }
            
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
