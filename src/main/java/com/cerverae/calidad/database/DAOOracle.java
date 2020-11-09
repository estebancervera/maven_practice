package com.cerverae.calidad.database;

import java.util.HashMap;

public class DAOOracle implements DAO {

	
	private HashMap<Integer, Alumno> database = new HashMap<Integer, Alumno>();

	public boolean addAlumno(Alumno a) {
		return false;
		// TODO Auto-generated method stub
		
	}

	public boolean deleteAlumno(Alumno a) {
		return false;
		// TODO Auto-generated method stub
		
	}

	public boolean updateAlumnoCalificacion(Alumno a, double calificacion) {
		return false;
		// TODO Auto-generated method stub
		
	}

	public int getAllAlumnosCount(){
		return 0;
		// TODO Auto-generated method stub
		
	}

	public Alumno getAlumno(int id) {
		return null;
		
	}

	public Alumno getAlumno() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public HashMap<Integer, Alumno> getDatabase() {
		return database;
	}
	
}
