/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.order_deatils;

import beans.OrderDetails;
import dao.DAOConnectionInterface;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Terance Wijesuriya
 */
public interface OrderDetailDAOInterface extends DAOConnectionInterface {

    List<OrderDetails> getOrderDetailsByOrder(int idOrder, Session session);

    int saveOrderDetails(OrderDetails orderDetails, Session session);

}
