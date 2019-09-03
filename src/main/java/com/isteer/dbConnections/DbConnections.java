package com.isteer.dbConnections;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContext;


public class DbConnections {

	public static Connection getConnection() throws SQLException, ClassNotFoundException, IOException {
		System.out.println("in Connection class");
		
		
		
		//FileInputStream fis = new FileInputStream("src/main/resources/DB.properties");
				InputStream is = DbConnections.class.getResourceAsStream("DB.properties");
		        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
				Properties prop = new Properties();
				prop.load(reader);
				
				String u= prop.getProperty("URL");
				String user = prop.getProperty("username");
				String pass=prop.getProperty("password");
				String driver = prop.getProperty("driver");
			
				Class.forName(driver);
				Connection c = DriverManager.getConnection(u,user,pass);
				return c;
		/*
		 * FileInputStream fis = new FileInputStream( new File(
		 * getClass().getClassLoader().getResource("database.properties").getFile() ));
		 */
		
	//	DbConnections conn = new DbConnections();
	//	File file = conn.getFileFromResources("resources/DB.properties");
	//	FileInputStream fis = new FileInputStream(file);
	//	 ServletContext context = request.getSession().getServletContext();
		// InputStream is = context.getResourceAsStream("/db.properties");
		
		//FileInputStream fis=new FileInputStream("dbconnect/src/main/resources/DB.properties");
	////	Properties prop = new Properties();
		// prop.load(fis);
		//static  ClassLoader.getResourceAsStream ("resources/DB.properties");
		//  Class.getResourceAsStream ("/some/pkg/resource.properties");
		//  ResourceBundle.getBundle ("some.pkg.resource");

	//	String u = prop.getProperty("URL");
	//	String user = prop.getProperty("username");
	//	String pass = prop.getProperty("password");
	//	String driver = prop.getProperty("driver");
	//	Class.forName(driver);
	//	Connection con = DriverManager.getConnection(u, user, pass);
		

/*	private File getFileFromResources(String fileName) {
		File s=null;
		ClassLoader classloader = null;

		try {
			classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = DbConnections.class.getResourceAsStream("/DB.properties");

			System.out.println(is);
		} catch (Exception e) {

			System.out.println(e);// TODO: handle exception
		}

		ClassLoader classLoader = getClass().getClassLoader();

		URL resource = classloader.getResource("/DB.properties");

		try {
			URL filePath = new URL("D:/Spring%20Tool%20Programs/dbconnect/resources/DB.properties");
			System.out.println(filePath);
			 s= new File(filePath.getFile());

			//System.out.println("File loaded from filePath");
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return s;
		
	//	if (resource == null) {
	//		throw new IllegalArgumentException("file is not found!");
	//	} else {
	//		System.out.println("**********Error from resource file*******");
		//	return new File(resource.getFile());
	//	}*/
	}
	

}
