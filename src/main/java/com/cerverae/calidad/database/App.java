package com.cerverae.calidad.database;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Alumno alumno = new Alumno(2, "Esteban HOLA", 22, 9, "esteban@gmail.com");
		AlumnoDaoOracleSQL oracle = new AlumnoDaoOracleSQL();
		
		oracle.addAlumno(alumno);
		System.out.println(oracle.getAllAlumnosCount());
		System.out.println(oracle.getAlumno(2).getGrade());
		oracle.updateAlumnoCalificacion(alumno, 8);
		System.out.println(oracle.getAlumno(2).getGrade());
		oracle.deleteAlumno(alumno);
		System.out.println(oracle.getAllAlumnosCount());
		
		
		
	}

}
