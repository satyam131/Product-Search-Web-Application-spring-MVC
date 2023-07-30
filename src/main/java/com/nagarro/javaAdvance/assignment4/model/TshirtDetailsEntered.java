package com.nagarro.javaAdvance.assignment4.model;

import com.nagarro.javaAdvance.assignment4.util.AppContextUtil;
import jakarta.validation.constraints.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class TshirtDetailsEntered {
    
    private String color;

    private String size;

    @NotEmpty
    private String gender;

    @Max(value = 2, message = "Choose valid entry")
    @Min(value = 1, message = "is required")
    private int outputPreference;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getOutputPreference() {
        return outputPreference;
    }

    public void setOutputPreference(int outputPreference) {
        this.outputPreference = outputPreference;
    }
			
    /**
     * This method provides the matching results from the database according to the outputPreference
     * @return
     */
    public List<Tshirt> getListOfMatchingTshirts() {
    	//HibernateTemplate provides a high-level API for performing common database operations with Hibernate.
        HibernateTemplate template = (HibernateTemplate) AppContextUtil.context.getBean("templateTshirt");
      
        String hql = "FROM Tshirt t WHERE t.color = :color AND t.size = :size AND t.gender = :gender";
                   

        Map<String, Object> params = new HashMap<>();
        params.put("color", getColor());
        params.put("size", getSize());
        params.put("gender", getGender());
        

        List<Tshirt> matchingTshirts = template.execute(session -> {
            Query<Tshirt> query = session.createQuery(hql, Tshirt.class);
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
            return query.getResultList();
        });

        final String finalHql;
        if (getOutputPreference() == 1) {
            finalHql = "FROM Tshirt t WHERE t.color = :color AND t.size = :size AND t.gender = :gender ORDER BY t.price ASC ";
                     
        } else if(getOutputPreference() == 2) {
            finalHql = "FROM Tshirt t WHERE t.color = :color AND t.size = :size AND t.gender = :gender ORDER BY t.rating ASC ";
        } else {
        	finalHql = "FROM Tshirt t WHERE t.color = :color AND t.size = :size AND t.gender = :gender ORDER BY t.price, t.rating ASC ";
        }

        matchingTshirts = template.execute(session -> {
            Query<Tshirt> query = session.createQuery(finalHql, Tshirt.class);
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
            return query.getResultList();
        });

        return matchingTshirts;
    }
}
