/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Retailers;
import dao.Common;
import dao.retailer.RetailerDAOImpl;
import dao.retailer.RetailerDAOInterface;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Terance Wijesuriya
 */
public class RetailerService {

    private static RetailerDAOInterface retailerDAOInterface;

    public RetailerService() {
        retailerDAOInterface = new RetailerDAOImpl();
    }

    public Session getSession() {
        return retailerDAOInterface.openCurrentSession();
    }

    public Transaction getTransaction(Session session) {
        return retailerDAOInterface.openTransaction(session);
    }

    public List<Retailers> getAllRetailers() {
        Session session = getSession();
        Transaction transaction = null;
        List<Retailers> list = new ArrayList<>();
        try {
            transaction = getTransaction(session);
            list = retailerDAOInterface.getAllRetailers(session);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    public Retailers findRetailerById(int idRetailer) {
        Session session = getSession();
        Transaction transaction = null;
        Retailers retailers = new Retailers();
        try {
            transaction = getTransaction(session);
            retailers = retailerDAOInterface.findRetailerById(idRetailer, session);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return retailers;
    }

    public String saveRetailer(Retailers retailers) {
        Session session = getSession();
        Transaction transaction = null;
        String result = "";
        try {
            retailers.setDateCraeted(new Date());
            retailers.setLastUpdated(new Date());
            transaction = getTransaction(session);
            retailerDAOInterface.saveRetailer(retailers, session);
            transaction.commit();
            result = Common.SAVE_SUCCESS;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
                result = Common.SAVE_ROLLBACK;
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public String updateRetailer(Retailers retailers) {
        Session session = getSession();
        Transaction transaction = null;
        String result = "";
        try {
            retailers.setDateCraeted(new Date());
            retailers.setLastUpdated(new Date());
            transaction = getTransaction(session);
            retailerDAOInterface.updateRetailer(retailers, session);
            transaction.commit();
            result = Common.SAVE_SUCCESS;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
                result = Common.SAVE_ROLLBACK;
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
    
    public List<Retailers> getRetailers(){
        Session session = getSession();
        Transaction transaction = null;
        List<Retailers> list = new ArrayList<>();
        try {
            transaction = getTransaction(session);
            list = retailerDAOInterface.getRetailers(session);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

}
