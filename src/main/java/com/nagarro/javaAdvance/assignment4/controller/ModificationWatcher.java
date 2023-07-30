package com.nagarro.javaAdvance.assignment4.controller;

import com.nagarro.javaAdvance.assignment4.dao.TshirtNBrandDao;
import com.nagarro.javaAdvance.assignment4.model.Brand;
import com.nagarro.javaAdvance.assignment4.util.AppContextUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/**
 * This is a Java class implementing a Runnable that monitors the modification of a directory
 * and updates the database accordingly
 *
 */
public class ModificationWatcher implements Runnable {
	//The lastModifiedAt variable is a HashMap that maps a file name to the time it was last modified
    static HashMap<String, Long> lastModifiedAt = new HashMap<>();
    //The dir variable is a File object representing the directory being monitored
    File dir = new File("C:\\Users\\satyamprajapati\\Desktop\\Online product search\\AdvaanceJavaAssignment4\\CSV");

    static TshirtNBrandDao tshirtDao = (TshirtNBrandDao) AppContextUtil.context.getBean("tshirtDao");

    /**
     * For each file in the directory, the run() method checks if the file has been modified since the last time 
     * it was checked. If it has, it reads the data from the file using the ReadBrandFromFile class, saves the data
     * to the database using the tshirtDao object, and updates the lastModifiedAt map with the new modification time of the file.
     */
    public void run() {
        File[] files = dir.listFiles();
        //System.out.println(files);
        ArrayList<String> listOfFileNames = new ArrayList<>();
        for (File file : files) {
            if ((!(lastModifiedAt.containsKey(file.getName()))) || (file.lastModified() > lastModifiedAt.get(file.getName()))) {

                Brand brand = ReadBrandFromFile.readFile(file);
                if (lastModifiedAt.containsKey(file.getName())) {

                    tshirtDao.deleteBrand(file.getName());
                }
                tshirtDao.saveBrand(brand);
                lastModifiedAt.put(file.getName(), file.lastModified());
            }
            listOfFileNames.add(file.getName());
        }

        Set<String> fileNamesOfPast = new HashSet<>(lastModifiedAt.keySet());
        if (fileNamesOfPast.size() == listOfFileNames.size())
            return;
        for (String string : fileNamesOfPast) {
            if (!(listOfFileNames.contains(string))) {
                tshirtDao.deleteBrand(string);
                lastModifiedAt.remove(string);
            }
        }
    }
}
