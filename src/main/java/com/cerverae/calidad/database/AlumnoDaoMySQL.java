package com.cerverae.calidad.database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import static java.sql.DriverManager.*;

import java.nio.channels.SelectableChannel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class AlumnoDaoMySQL implements DAO {
	
	

	public Connection getConnectionMySQL(){
        String url = "jdbc:mysql://localhost:3306/alumnos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String password = "Esteban";
        
        Connection connection = null;
        
        try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			//String querry = query;
			
			//Statement statement = connection.createStatement();
			//statement.executeQuery(querry);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return connection;

   
        	
  
	}
	
	public boolean addAlumno(Alumno a) {
		// TODO Auto-generated method stub
		
		Connection connection = getConnectionMySQL();
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.prepareStatement("insert INTO student(id, name, age, grade, email) values (?, ?, ?, ?, ?)");
			
			preparedStatement.setInt(1, a.getId());
			preparedStatement.setString(2, a.getName());
			preparedStatement.setInt(3, a.getAge());
			preparedStatement.setDouble(4, a.getGrade());
			preparedStatement.setString(5, a.getEmail());
			
			int status = preparedStatement.executeUpdate();
			
			
			
			connection.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		return false;
	}

	public boolean deleteAlumno(Alumno a) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getAllAlumnosCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Alumno getAlumno(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateAlumnoCalificacion(Alumno a, double calificacion) {
		// TODO Auto-generated method stub
		return false;
	}

}
