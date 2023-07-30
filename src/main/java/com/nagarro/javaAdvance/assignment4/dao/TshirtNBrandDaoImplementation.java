package com.nagarro.javaAdvance.assignment4.dao;

import com.nagarro.javaAdvance.assignment4.model.Brand;
import com.nagarro.javaAdvance.assignment4.model.Tshirt;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class TshirtNBrandDaoImplementation implements TshirtNBrandDao {

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
     *This method takes a Brand object as input and saves it to the database using the HibernateTemplate object
     */
    public void saveBrand(Brand brand) {
        Session session = template.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(brand);
        session.getTransaction().commit();
        session.close();
    }

    public List<Tshirt> getTshirts() {
        return template.loadAll(Tshirt.class);
    }
    /**
     * method takes a String representing the brand name as input, and deletes the corresponding Brand
     * object from the database using the HibernateTemplate object
     */
    public void deleteBrand(String brandName) {
        Session session = template.getSessionFactory().openSession();
        session.beginTransaction();

        @SuppressWarnings("unchecked")
        TypedQuery<Brand> query = session.createQuery("from Brand where name = :string");
        query.setParameter("string", brandName);
        try {
            Brand brand = query.getSingleResult();
            brand = session.load(Brand.class, brand.getId());
            session.delete(brand);
            session.getTransaction().commit();
            session.close();
        } catch (NoResultException e) {
            System.err.println("No Brand Found");
        }
    }
}
