/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.order;

import beans.Orders;
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
public class OrderDAOImpl implements OrderDAOInterface {

    private final SessionFactoryBuilder sessionFactoryBuilder = SessionFactoryBuilder.getInstance();

    @Override
    public List<Orders> getAllOrdersOfUser(int idUser, Session session) {
        Query query = session.createQuery("FROM Orders o WHERE o.user.iduser =:userId");
        query.setParameter("userId", idUser);
        List<Orders> list = (List<Orders>) query.list();
        return list;
    }

    @Override
    public int saveOrder(Orders orders, Session session) {
        int result = -1;
        Serializable save = session.save(orders);
        if (save != null) {
            result = (Integer) save;
        }
        return result;
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
    public List<Orders> getAllOrdersOfRetailers(int idRetailer, Session session) {
        Query query = session.createQuery("FROM Orders o WHERE o.retailers.idretailers =:retailerId");
        query.setParameter("retailerId", idRetailer);
        List<Orders> list = (List<Orders>) query.list();
        return list;
    }

    @Override
    public List<Orders> getAllOrdersByRetailersForDay(int idRetailer, String startDay, String endDay, Session session) {
        Query query = session.createQuery("FROM Orders o WHERE o.retailers.idretailers =:retailerId AND o.orderDate BETWEEN :startDtae AND :endDate");
        query.setParameter("retailerId", idRetailer);
        query.setParameter("startDtae", startDay);
        query.setParameter("endDate", endDay);
        List<Orders> list = (List<Orders>) query.list();
        return list;
    }

    @Override
    public Orders getOrderDetailsById(int idOrder, Session session) {
        Query query = session.createQuery("FROM Orders o WHERE o.idorder =:orderId");
        query.setParameter("orderId", idOrder);
        Orders orderses = (Orders) query.list().get(0);
        return orderses;
    }

    @Override
    public List<Orders> getOrdersOfRetailersByDateDesc(int idRetailer, Session session) {
        Query query = session.createQuery("FROM Orders o WHERE o.retailers.idretailers =:retailerId ORDER BY o.orderDate DESC");
        query.setParameter("retailerId", idRetailer);
        List<Orders> list = (List<Orders>) query.list();
        return list;
    }

}
