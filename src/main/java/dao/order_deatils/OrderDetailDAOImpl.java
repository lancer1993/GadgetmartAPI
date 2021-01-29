/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.order_deatils;

import beans.OrderDetails;
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
public class OrderDetailDAOImpl implements OrderDetailDAOInterface {

    private final SessionFactoryBuilder sessionFactoryBuilder = SessionFactoryBuilder.getInstance();

    @Override
    public List<OrderDetails> getOrderDetailsByOrder(int idOrder, Session session) {
        Query query = session.createQuery("FROM OrderDetails od WHERE od.orders.idorder =:orderId");
        query.setParameter("orderId", idOrder);
        List<OrderDetails> list = (List<OrderDetails>) query.list();
        return list;
    }

    @Override
    public int saveOrderDetails(OrderDetails orderDetails, Session session) {
        int result = -1;
        Serializable save = session.save(orderDetails);
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

}
