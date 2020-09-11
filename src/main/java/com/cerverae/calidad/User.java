package com.cerverae.calidad;

public class User {

	private String password = "";
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String pswd) {
		this.password = pswd;
	}
	
	public String validatePassword() {
		
		
		if(password.length() > 12) {
			return "La contraseņa esta muy larga!";
		}
		
		if(!password.matches("[^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$]")){
			return "La contraseņa necesita tener minimo una mayuscula!";
		}
		
		return "No Error Encontrado";
		
			
	}
	
}
