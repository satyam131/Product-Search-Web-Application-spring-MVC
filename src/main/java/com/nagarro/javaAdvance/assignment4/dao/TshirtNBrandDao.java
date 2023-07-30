package com.nagarro.javaAdvance.assignment4.dao;

import com.nagarro.javaAdvance.assignment4.model.Brand;
import com.nagarro.javaAdvance.assignment4.model.Tshirt;

import java.util.List;

public interface TshirtNBrandDao {
    public void saveBrand(Brand brand);

    public List<Tshirt> getTshirts();

    public void deleteBrand(String brandName);
}
