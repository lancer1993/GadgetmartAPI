/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.OrderDetails;
import beans.Orders;
import beans.Retailers;
import beans.User;
import custom_beans.MainOrder;
import custom_beans.MainOrderDetails;
import dao.Common;
import dao.order_deatils.OrderDetailDAOImpl;
import dao.order_deatils.OrderDetailDAOInterface;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Terance Wijesuriya
 */
public class OrderDetailsService {

    private static OrderDetailDAOInterface orderDetailDAOInterface;

    public OrderDetailsService() {
        orderDetailDAOInterface = new OrderDetailDAOImpl();
    }

    public Session getSession() {
        return orderDetailDAOInterface.openCurrentSession();
    }

    public Transaction getTransaction(Session session) {
        return orderDetailDAOInterface.openTransaction(session);
    }

    public List<OrderDetails> getOrderDetailsByOrder(int idOrder) {
        Session session = getSession();
        Transaction transaction = null;
        List<OrderDetails> orderDetailses = new ArrayList<>();
        List<OrderDetails> list = new ArrayList<>();

        try {
            transaction = getTransaction(session);
            orderDetailses = orderDetailDAOInterface.getOrderDetailsByOrder(idOrder, session);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.clear();
            for (OrderDetails orderDetails : orderDetailses) {
                Orders orders = new Orders();
                Orders od = orderDetails.getOrders();
                orders.setIdorder(od.getIdorder());
                orders.setOrderAmount(od.getOrderAmount());
                orders.setOrderDate(od.getOrderDate());
                orders.setDateCreated(od.getDateCreated());
                orders.setLastUpdated(od.getLastUpdated());
                orderDetails.setOrders(orders);
                list.add(orderDetails);
            }
        }

        return list;
    }

    public int saveOrderDetail(OrderDetails orderDetails) {
        int result = -1;
        Session session = getSession();
        Transaction transaction = null;

        try {
            transaction = getTransaction(session);
            result = orderDetailDAOInterface.saveOrderDetails(orderDetails, session);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

    public String saveOrderData(List<OrderDetails> list) {
        String result = "";
        int count = 0;
        int size = list.size();
        try {
            for (OrderDetails OrderDetails : list) {
                saveOrderDetail(OrderDetails);
                count++;
            }

            if (count == size) {
                result = Common.SAVE_SUCCESS;
            } else {
                result = Common.SAVE_ROLLBACK_FAILED;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public String saveOrder(MainOrder mainOrder) {
        String result = "";

        UserService userService = new UserService();
        OrderService orderService = new OrderService();
        RetailerService retailerService = new RetailerService();

        User user = userService.getUserById(mainOrder.getIdUser());
        Retailers retailers = retailerService.findRetailerById(mainOrder.getIdReatilers());

        if (user != null && retailers != null) {

            Orders orders = new Orders();
            orders.setUser(user);
            orders.setRetailers(retailers);
            orders.setOrderAmount(new BigDecimal(mainOrder.getTotalAmount()));
            orders.setOrderDate(new Date());
            orders.setDateCreated(new Date());
            orders.setLastUpdated(new Date());

            int orderId = orderService.saveOrder(orders);
            if (orderId > 0) {
                Orders o = orderService.getOrderDetailsById(orderId);

                List<MainOrderDetails> list = mainOrder.getList();
                List<OrderDetails> ods = new ArrayList<>();

                for (MainOrderDetails details : list) {
                    OrderDetails orderDetails = new OrderDetails();
                    orderDetails.setOrders(o);
                    orderDetails.setDeliveryPeriod(details.getDeliveryPeriod());
                    orderDetails.setProductImage(details.getProductImage());
                    orderDetails.setProductCode(details.getProductCode());
                    orderDetails.setQuantity(details.getQuantity());
                    orderDetails.setItemTotal(details.getItemTotal());
                    orderDetails.setProductWarrentyPeriod(details.getProductWarrentyPeriod());
                    orderDetails.setDeliveryPeriod(details.getDeliveryPeriod());
                    orderDetails.setCreatedDateTime(new Date());
                    orderDetails.setLastUpdatedDateTime(new Date());
                    ods.add(orderDetails);
                }

                result = saveOrderData(ods);
            }
        } else {
            result = Common.SAVE_ROLLBACK_FAILED;
        }

        return result;
    }

}
