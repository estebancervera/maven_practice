package com.cerverae.calidad.database;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Alumno alumno = new Alumno(2, "Esteban", 22, 9, "esteban@gmail.com");
		AlumnoDaoMySQL mySQL = new AlumnoDaoMySQL();
		
		mySQL.addAlumno(alumno);
		
		
	}

}
