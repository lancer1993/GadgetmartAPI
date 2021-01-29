/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.user;

import beans.User;
import dao.SessionFactoryBuilder;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Terance Wijesuriya
 */
public class UserDAOImpl implements UserDAOInterface {

    private final SessionFactoryBuilder sessionFactoryBuilder = SessionFactoryBuilder.getInstance();

    @Override
    public List<User> getAllUsers(Session session) {
        Query query = session.createQuery("FROM User u");
        List<User> users = (List<User>) query.list();
        return users;
    }

    @Override
    public User getUserByID(int idUser, Session session) {
        Query query = session.createQuery("FROM User u WHERE u.iduser =:idUser");
        query.setParameter("idUser", idUser);
        User user = (User) query.list().get(0);
        return user;
    }

    @Override
    public int saveUser(User user, Session session) {
        int result = -1;
        Serializable save = session.save(user);
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
    public User getUserByEmail(String email, Session session) {
        Query query = session.createQuery("FROM User u WHERE u.email =:email");
        query.setParameter("email", email);
        User user = (User) query.list().get(0);
        return user;
    }

    @Override
    public void updateUser(User user, Session session) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Query query = session.createSQLQuery("UPDATE user SET name=:name, phone=:userPhone, enabled=:isEnabled , last_updated=:updatedDate \n"
                + " WHERE iduser=:userId");
        query.setParameter("name", user.getName());
        query.setParameter("userPhone", user.getPhone());
        query.setParameter("isEnabled", user.getEnabled());
        query.setParameter("updatedDate", sdf.format(user.getLastUpdated()));
        query.setParameter("userId", user.getIduser());
        query.executeUpdate();
    }

    @Override
    public void updateUserPassword(User user, Session session) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Query query = session.createSQLQuery("UPDATE user SET password=:userPassword , salt=:userSalt , last_updated=:updatedDate WHERE iduser=:userId");
        query.setParameter("userPassword", user.getPassword());
        query.setParameter("userSalt", user.getSalt());
        query.setParameter("updatedDate", sdf.format(user.getLastUpdated()));
        query.setParameter("userId", user.getIduser());
        query.executeUpdate();
    }
    
    @Override
    public void resetPassword(User user, Session session) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Query query = session.createSQLQuery("UPDATE user SET password=:userPassword , salt=:userSalt , last_updated=:updatedDate WHERE email= :email");
        query.setParameter("userPassword", user.getPassword());
        query.setParameter("userSalt", user.getSalt());
        query.setParameter("updatedDate", sdf.format(user.getLastUpdated()));
        query.setParameter("email", user.getEmail());
        query.executeUpdate();
    }

}
