package com.nagarro.javaAdvance.assignment4.controller;

import com.nagarro.javaAdvance.assignment4.model.Brand;
import com.nagarro.javaAdvance.assignment4.model.Tshirt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.StringTokenizer;
/**
 * This class implements a reading of a file using buffer reader and stores the content in a hashSet and return it
 *
 */
public class ReadBrandFromFile {
	/**
	 * This method reads the file using buffer reader and maps the contents according to Tshirt data using
	 * manipulateLine method and then stores it in a hashSet 
	 * @param file denotes the file to be read
	 * @return hashSet of the content of file mapped by brand
	 */
    public static Brand readFile(File file) {
        BufferedReader reader = null;
        Brand brand = new Brand();
        brand.setName(file.getName());
        HashSet<Tshirt> tshirt_Set = new HashSet<>();
        
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            line = reader.readLine();

            while (line != null) {
                Tshirt f = manipulateLine(line, brand);
                line = reader.readLine();
                tshirt_Set.add(f);
            }
        } catch (Exception e) {
            System.err.println("Could Not Read the File");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    System.err.println("Could Not Close the File");
                }
            }
        }
        brand.setTshirts(tshirt_Set);
        return brand;
    }
    /**
     * This method maps the particular line of a file and maps it with Tshirt accordingly
     * @param line denotes the line of content to be mapped
     * @param aObj denotes an object of brand
     * @return mapped content into tshirt
     */
    private static Tshirt manipulateLine(String line, Brand aObj) {

        StringTokenizer st = new StringTokenizer(line, "|");

        String id = st.nextToken();
        String name = st.nextToken();
        String color = st.nextToken();

        String gender = st.nextToken();

        String size = st.nextToken();
        double price = Double.parseDouble(st.nextToken());
        double rating = Double.parseDouble(st.nextToken());      
        String avail = st.nextToken();
        boolean availability;
        availability = avail.charAt(0) == 'Y';


        return new Tshirt(id, name, color, gender, size,
                price, rating, availability, aObj);
    }
}
