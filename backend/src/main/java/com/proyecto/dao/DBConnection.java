package com.proyecto.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;


public class DBConnection {

	Connection con = null;

	static Logger log = Logger.getLogger(DBConnection.class.getName());

	private String url = "jdbc:mysql://localhost:3306/proyecto_final";
	private String user = "root";
	private String password = "patata123";

	public Connection getConnection() {

		if (con == null) {
			con = ConnectDB();
		}

		return con;
	}

	public Connection ConnectDB() {

		try {
			con = DriverManager.getConnection(url, user, password);
			boolean valid = con.isValid(50000);
			System.out.println(valid ? "Connection OK" : "Connection FAIL");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("No se ha podido conectar la BBDD.");
		}

		return con;

	}

}
