package com.company;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
		
		Group group1 = xmlToObject(readFromFile("group1.xml"));
        System.out.println(group1);
		writeToFile(objectToJson(group1), "group1.json");
    }
	
	public static Group xmlToObject(String xmlString) {
		XmlMapper xmlMapper = new XmlMapper();
        Group group = null;
        try {
            group = xmlMapper.readValue(xmlString, Group.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return group;
    }
	
	public static String objectToJson(Object object) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(object);
	}
	
    public static void writeToFile(String string, String fileName) {
        try {
            FileUtils.writeStringToFile(
                    new File(fileName),
                    string,
                    "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(String fileName) {
        String string = "";
        try {
            string = FileUtils.readFileToString(new File(fileName), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }
}
