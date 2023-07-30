package com.nagarro.javaAdvance.assignment4.dao;

import com.nagarro.javaAdvance.assignment4.model.User;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class UserDaoImplementation implements UserDao {
    HibernateTemplate template;
    
    /**
     * This method is a setter for the HibernateTemplate object, which is used by Spring to inject the object
     * into the DAO
     * @param template
     */
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
    
    /**
     * This method takes a User object as input and saves it to the database using the HibernateTemplate object
     */
    public void saveUser(User user) {
        Session session = template.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
    /**
     * This method is used to retrieve the data of matching userId from the user database 
     */
    public User getUser(String userId) throws DataAccessException {
        List<User> listUser = template.execute(session -> {
            @SuppressWarnings("unchecked")
            List<User> result = (List<User>) session.createQuery("from User where userId=" + "'" + userId + "'").list();
            return result;
        });
        if (listUser.isEmpty()) {
            return null;
        }
        return listUser.get(0);
    }
}
