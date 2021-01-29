/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.order;

import beans.Orders;
import dao.DAOConnectionInterface;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Terance Wijesuriya
 */
public interface OrderDAOInterface extends DAOConnectionInterface {

    List<Orders> getAllOrdersOfUser(int idUser, Session session);

    int saveOrder(Orders orders, Session session);

    List<Orders> getAllOrdersOfRetailers(int idRetailer, Session session);

    List<Orders> getAllOrdersByRetailersForDay(int idRetailer, String startDay, String endDay, Session session);

    Orders getOrderDetailsById(int idOrder, Session session);
    
    List<Orders> getOrdersOfRetailersByDateDesc(int idRetailer, Session session);

}
