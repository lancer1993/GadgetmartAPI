/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.retailer;

import beans.Orders;
import beans.Retailers;
import dao.SessionFactoryBuilder;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Terance Wijesuriya
 */
public class RetailerDAOImpl implements RetailerDAOInterface {

    private final SessionFactoryBuilder sessionFactoryBuilder = SessionFactoryBuilder.getInstance();

    @Override
    public Retailers findRetailerById(int idRetailer, Session session) {
        Query query = session.createQuery("FROM Retailers r WHERE r.idretailers =:idRetailer");
        query.setParameter("idRetailer", idRetailer);
        Retailers retailers = (Retailers) query.list().get(0);
        return retailers;
    }

    @Override
    public int saveRetailer(Retailers retailers, Session session) {
        int result = -1;
        Serializable save = session.save(retailers);
        if (save != null) {
            result = (Integer) save;
        }
        return result;
    }

    @Override
    public void updateRetailer(Retailers retailers, Session session) {
        session.update(retailers);
    }

    @Override
    public Session openCurrentSession() {
        return sessionFactoryBuilder.getSessionFactory().openSession();
    }

    @Override
    public Transaction openTransaction(Session session) {
        Transaction transaction = session.beginTransaction();
        return transaction;
    }

    @Override
    public List<Retailers> getAllRetailers(Session session) {
        Query query = session.createQuery("FROM Retailers r WHERE r.available = true");
        List<Retailers> list = (List<Retailers>) query.list();
        return list;
    }

    @Override
    public List<Retailers> getRetailers(Session session) {
        Query query = session.createQuery("FROM Retailers r");
        List<Retailers> list = (List<Retailers>) query.list();
        return list;
    }

}
