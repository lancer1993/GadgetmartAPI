/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.Orders;
import beans.Retailers;
import beans.User;
import dao.order.OrderDAOImpl;
import dao.order.OrderDAOInterface;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Terance Wijesuriya
 */
public class OrderService {

    private static OrderDAOInterface orderDAOInterface;

    public OrderService() {
        orderDAOInterface = new OrderDAOImpl();
    }

    public Session getSession() {
        return orderDAOInterface.openCurrentSession();
    }

    public Transaction getTransaction(Session session) {
        return orderDAOInterface.openTransaction(session);
    }

    public List<Orders> getAllOrdersOfUser(int idUser) {
        Session session = getSession();
        Transaction transaction = null;
        List<Orders> orderses = new ArrayList<>();
        List<Orders> list = new ArrayList<>();

        try {
            transaction = getTransaction(session);
            orderses = orderDAOInterface.getAllOrdersOfUser(idUser, session);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();

            for (Orders orders : orderses) {

                User user = new User();
                User u = orders.getUser();
                user.setIduser(u.getIduser());
                user.setName(u.getName());
                user.setEmail(u.getEmail());
                user.setAddress(u.getAddress());
                user.setGender(u.getGender());
                user.setPhone(u.getPhone());
                user.setBirthday(u.getBirthday());
                user.setEnabled(u.getEnabled());
                user.setDateCreated(u.getDateCreated());
                user.setLastUpdated(u.getLastUpdated());
                orders.setUser(user);

                Retailers retailers = new Retailers();
                Retailers r = orders.getRetailers();
                retailers.setIdretailers(r.getIdretailers());
                retailers.setRetailerName(r.getRetailerName());
                retailers.setAddress(r.getAddress());
                retailers.setPhone(r.getPhone());
                retailers.setAvailable(r.getAvailable());
                retailers.setDateCraeted(r.getDateCraeted());
                retailers.setLastUpdated(r.getLastUpdated());
                orders.setRetailers(retailers);

                list.add(orders);

            }

        }

        return list;
    }

    public List<Orders> getAllOrdersOfRetailers(int idRetailer) {
        Session session = getSession();
        Transaction transaction = null;
        List<Orders> orderses = new ArrayList<>();
        List<Orders> list = new ArrayList<>();

        try {
            transaction = getTransaction(session);
            orderses = orderDAOInterface.getAllOrdersOfRetailers(idRetailer, session);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();

            for (Orders orders : orderses) {

                User user = new User();
                User u = orders.getUser();
                user.setIduser(u.getIduser());
                user.setName(u.getName());
                user.setEmail(u.getEmail());
                user.setAddress(u.getAddress());
                user.setGender(u.getGender());
                user.setPhone(u.getPhone());
                user.setBirthday(u.getBirthday());
                user.setEnabled(u.getEnabled());
                user.setDateCreated(u.getDateCreated());
                user.setLastUpdated(u.getLastUpdated());
                orders.setUser(user);

                Retailers retailers = new Retailers();
                Retailers r = orders.getRetailers();
                retailers.setIdretailers(r.getIdretailers());
                retailers.setRetailerName(r.getRetailerName());
                retailers.setAddress(r.getAddress());
                retailers.setPhone(r.getPhone());
                retailers.setAvailable(r.getAvailable());
                retailers.setDateCraeted(r.getDateCraeted());
                retailers.setLastUpdated(r.getLastUpdated());
                orders.setRetailers(retailers);

                list.add(orders);

            }

        }

        return list;
    }

    public List<Orders> getAllOrdersByRetailersForDay(int idRetailer, String startDay, String endDay) {
        Session session = getSession();
        Transaction transaction = null;
        List<Orders> orderses = new ArrayList<>();
        List<Orders> list = new ArrayList<>();

        try {
            transaction = getTransaction(session);
            orderses = orderDAOInterface.getAllOrdersByRetailersForDay(idRetailer, startDay, endDay, session);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();

            for (Orders orders : orderses) {

                User user = new User();
                User u = orders.getUser();
                user.setIduser(u.getIduser());
                user.setName(u.getName());
                user.setEmail(u.getEmail());
                user.setAddress(u.getAddress());
                user.setGender(u.getGender());
                user.setPhone(u.getPhone());
                user.setBirthday(u.getBirthday());
                user.setEnabled(u.getEnabled());
                user.setDateCreated(u.getDateCreated());
                user.setLastUpdated(u.getLastUpdated());
                orders.setUser(user);

                Retailers retailers = new Retailers();
                Retailers r = orders.getRetailers();
                retailers.setIdretailers(r.getIdretailers());
                retailers.setRetailerName(r.getRetailerName());
                retailers.setAddress(r.getAddress());
                retailers.setPhone(r.getPhone());
                retailers.setAvailable(r.getAvailable());
                retailers.setDateCraeted(r.getDateCraeted());
                retailers.setLastUpdated(r.getLastUpdated());
                orders.setRetailers(retailers);

                list.add(orders);

            }

        }

        return list;
    }

    public int saveOrder(Orders orders) {
        Session session = getSession();
        Transaction transaction = null;
        int result = 0;
        try {
            transaction = getTransaction(session);
            result = orderDAOInterface.saveOrder(orders, session);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return result;
    }

    public Orders getOrderDetailsById(int idOrder) {
        Session session = getSession();
        Transaction transaction = null;
        Orders orders = new Orders();

        try {
            transaction = getTransaction(session);
            orders = orderDAOInterface.getOrderDetailsById(idOrder, session);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();

            User user = new User();
            User u = orders.getUser();
            user.setIduser(u.getIduser());
            user.setName(u.getName());
            user.setEmail(u.getEmail());
            user.setAddress(u.getAddress());
            user.setGender(u.getGender());
            user.setPhone(u.getPhone());
            user.setBirthday(u.getBirthday());
            user.setEnabled(u.getEnabled());
            user.setDateCreated(u.getDateCreated());
            user.setLastUpdated(u.getLastUpdated());
            orders.setUser(user);

            Retailers retailers = new Retailers();
            Retailers r = orders.getRetailers();
            retailers.setIdretailers(r.getIdretailers());
            retailers.setRetailerName(r.getRetailerName());
            retailers.setAddress(r.getAddress());
            retailers.setPhone(r.getPhone());
            retailers.setAvailable(r.getAvailable());
            retailers.setDateCraeted(r.getDateCraeted());
            retailers.setLastUpdated(r.getLastUpdated());
            orders.setRetailers(retailers);

        }

        return orders;
    }

    public List<Orders> getOrdersOfRetailersByDateDesc(int idRetailer) {
        Session session = getSession();
        Transaction transaction = null;
        List<Orders> orderses = new ArrayList<>();
        List<Orders> list = new ArrayList<>();

        try {
            transaction = getTransaction(session);
            orderses = orderDAOInterface.getOrdersOfRetailersByDateDesc(idRetailer, session);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();

            for (Orders orders : orderses) {

                User user = new User();
                User u = orders.getUser();
                user.setIduser(u.getIduser());
                user.setName(u.getName());
                user.setEmail(u.getEmail());
                user.setAddress(u.getAddress());
                user.setGender(u.getGender());
                user.setPhone(u.getPhone());
                user.setBirthday(u.getBirthday());
                user.setEnabled(u.getEnabled());
                user.setDateCreated(u.getDateCreated());
                user.setLastUpdated(u.getLastUpdated());
                orders.setUser(user);

                Retailers retailers = new Retailers();
                Retailers r = orders.getRetailers();
                retailers.setIdretailers(r.getIdretailers());
                retailers.setRetailerName(r.getRetailerName());
                retailers.setAddress(r.getAddress());
                retailers.setPhone(r.getPhone());
                retailers.setAvailable(r.getAvailable());
                retailers.setDateCraeted(r.getDateCraeted());
                retailers.setLastUpdated(r.getLastUpdated());
                orders.setRetailers(retailers);

                list.add(orders);

            }

        }

        return list;
    }
}
