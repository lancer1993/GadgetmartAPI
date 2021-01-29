/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.retailer;

import beans.Retailers;
import dao.DAOConnectionInterface;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Terance Wijesuriya
 */
public interface RetailerDAOInterface extends DAOConnectionInterface {

    List<Retailers> getAllRetailers(Session session);

    Retailers findRetailerById(int idRetailer, Session session);

    int saveRetailer(Retailers retailers, Session session);

    void updateRetailer(Retailers retailers, Session session);
    
    List<Retailers> getRetailers(Session session);
}
