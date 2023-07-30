package com.nagarro.javaAdvance.assignment4.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Brand {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private Set<Tshirt> tshirts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Tshirt> getTshirts() {
        return tshirts;
    }

    public void setTshirts(Set<Tshirt> tshirts) {
        this.tshirts = tshirts;
    }
}
