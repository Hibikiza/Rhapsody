package br.com.pibicjoaomir.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;

@Controller
public class PropertieController {
	
	private ArrayList<String> propList = new ArrayList<String>();
	private ArrayList<String> dataBaseList = new ArrayList<String>();
	private ArrayList<String> formatList = new ArrayList<String>();
	
	public void readProperties(String nome) {
		//InputStream file = PropertieController.class.getClassLoader().getResourceAsStream("Properties_"+nome+".properties");	
		Properties prop = new Properties();
		try {
			InputStream file = new ClassPathResource("Properties_"+nome+".properties").getInputStream();
			prop.load(file);
			Set<String> set = prop.stringPropertyNames();
			for (String string : set) {
				if(string.startsWith("feature")) {
					propList.add(string);
				}else if(string.startsWith("database")) {
					dataBaseList.add(string);
				}else if(string.startsWith("format")) {
					formatList.add(string);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getPropList() {
		return propList;
	}
	
	public ArrayList<String> getDataBaseList() {
		return dataBaseList;
	}
	
	public ArrayList<String> getFormatList() {
		return formatList;
	}
	
	public ArrayList<String> getPropertieValues(String[] features, String nome){
		ArrayList<String> featuresParam = new ArrayList<String>();
		Properties prop = new Properties();
		try {
			InputStream file = new ClassPathResource("Properties_"+nome+".properties").getInputStream();
			prop.load(file);
			for (String string : features) {
				featuresParam.add(prop.getProperty(string));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return featuresParam;
	}
	
	public String getDatabasePath(String dataBaseName, String nome){
		Properties prop = new Properties();
		try {
			InputStream file = new ClassPathResource("Properties_"+nome+".properties").getInputStream();
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(dataBaseName);
	}
	
	public String getFormatValue(String formatName, String nome){
		Properties prop = new Properties();
		try {
			InputStream file = new ClassPathResource("Properties_"+nome+".properties").getInputStream();
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(formatName);
	}
	
	public ArrayList<String> getToolNames(){
		ArrayList<String> lista = new ArrayList<>();
		lista.add("librosa");
		lista.add("essentia");
		return lista;
	}
}
