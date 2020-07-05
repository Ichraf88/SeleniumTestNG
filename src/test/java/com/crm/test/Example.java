package com.crm.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Example {
	@Test
	public void printValues() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("src/main/java/com/crm/config/config.properties");
		prop.load(fis);
		String url=prop.getProperty("URL");
		System.out.println(url);
		}

}
