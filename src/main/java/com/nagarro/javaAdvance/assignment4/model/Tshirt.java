package com.nagarro.javaAdvance.assignment4.model;

import javax.persistence.*;


import java.util.Date;

@Entity
public class Tshirt {
    @Id
    @GeneratedValue
	int id ;
    String tshirtId;
	String name ;
	String color;
	String gender ;
	String size;
	double price ;
	double rating ;
	boolean availability;
	
    @ManyToOne
    private Brand brand;

    public Tshirt() {

    }
    
	public Tshirt(String tshirtId, String name, String color, String gender,String size, double price, double rating,
			boolean availability, Brand brand) {
		super();
		this.tshirtId = tshirtId;
		this.name = name;
		this.color = color;
		this.gender = gender;
		this.size = size;
		this.price = price;
		this.rating = rating;
		this.availability = availability;
		this.brand = brand;
	}

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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}





	public boolean equals(Object obj) {
		Tshirt other = (Tshirt) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tshirtId == null) {
			if (other.tshirtId != null)
				return false;
		} else if (!tshirtId.equals(other.tshirtId))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (availability != other.availability)
			return false;
		return true;
		}
}
