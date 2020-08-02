package com.proyecto.utils;

public class PasswordUtils {
	
	private static final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*()-_=+,<.>?";
	private static final int length = 15;

	
	public static String GenerateRandomPassword() {
		
		String password = "";
		
		for (int i = 0; i<length; i++) {
			password += characters.charAt((int) (Math.random()*characters.length()));
		}
		
		return password;
	}
}
