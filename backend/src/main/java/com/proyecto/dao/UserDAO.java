package com.proyecto.dao;

import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.proyecto.beans.User;

@Repository
public class UserDAO {

	
	DBConnection dbConnection = new DBConnection();

	public User getUser(String username) {

		User u = new User();
		try {
			String query = "SELECT user, password, "
					+ " DATE_FORMAT(ultima_modificacion , '%d/%m/%Y - %H:%i') as ultima_modificacion "
					+ " FROM usuarios where user = '" + username + "'";

			Statement st = dbConnection.getConnection().createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				u.setUser(rs.getString("user"));
				u.setPassword(rs.getString("password"));
				u.setLastModifiedDate(rs.getString("ultima_modificacion"));

			}
			st.close();
		} catch (Exception e) {
			System.out.println("Error al recuperar el usuario");
		}

		return u;
	}
	
	
	public Boolean modifyUser(User user) {
		boolean rs = false;
		try {
			String query = "UPDATE usuarios SET password = '"+user.getPassword() +"' "
					+ " , ultima_modificacion  = current_timestamp where user  = '" + user.getUser() + "' ";

			Statement st = dbConnection.getConnection().createStatement();

			
			rs = st.executeUpdate(query) == 1 ? true : false;

		
			st.close();
		} catch (Exception e) {
			System.out.println("Error al actualizar el usuario");
		}

		return rs;
	}
	
	
	public Boolean createUser(String email, String password) {
		Boolean rs = false;
		try {
			String query = "INSERT INTO usuarios VALUES('', " +email+", " + password +", current_timestamp ";

			Statement st = dbConnection.getConnection().createStatement();

			
			rs = st.executeUpdate(query) == 1 ? true : false;

		
			st.close();
		} catch (Exception e) {
			System.out.println("Error al actualizar el usuario");
		}
		
		
		
		return rs;
	}
}
