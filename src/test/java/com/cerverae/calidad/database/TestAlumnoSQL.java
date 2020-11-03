package com.cerverae.calidad.database;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import java.io.File;
import java.io.InputStream;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;

public class TestAlumnoSQL extends DBTestCase {

	
	public TestAlumnoSQL(String name) {
		super(name);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.cj.jdbc.Driver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/alumnos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "Esteban");
		System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA,"alumnos.student");

		
		
	}
	
	@Before
	public void setUp() throws Exception{
		super.setUp();
		IDatabaseConnection connection = getConnection();
		try {
			DatabaseOperation.CLEAN_INSERT.execute(connection, getDataSet());
		} finally {
			connection.close();
		}
	}

	
	
	/*
	@Test
	public void testInsert() {
		Alumno alumno = new Alumno(3, "Esteban C", 23, 9.0, "esteban@gmail.com");
		
		AlumnoDaoMySQL daoMySQL = new AlumnoDaoMySQL();
		
		daoMySQL.addAlumno(alumno);
		
		//verify
		try {
			IDataSet databaseDataSet = getConnection().createDataSet();
			
			ITable actualTable = databaseDataSet.getTable("student");
			
			//InputStream xmlFileInputStream = getClass().getResourceAsStream("src/resources/insert_result.xml");
			IDataSet expectedTableDataSet = new FlatXmlDataSetBuilder().build(new File("src/resources/insert_result.xml"));
			ITable expectedTable = expectedTableDataSet.getTable("student");
			
			Assertion.assertEquals(expectedTable, actualTable);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

	 */
	
	@Test
	
	public void testInsertCount() {
		Alumno alumno = new Alumno(3, "Esteban C", 23, 9, "esteban@gmail.com");
		
		AlumnoDaoMySQL daoMySQL = new AlumnoDaoMySQL();
		
		IDatabaseConnection connection;
		
		try {
			
			connection = getConnection();
			
			int actualRows = connection.getRowCount("student");
			daoMySQL.addAlumno(alumno);
			assertEquals(actualRows + 1, connection.getRowCount("student"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	protected IDataSet getDataSet() throws Exception {
		// TODO Auto-generated method stub
		//InputStream xmlFile = getClass().getResourceAsStream("src/resources/alumno_init.xml");
		return new FlatXmlDataSetBuilder().build(new File("src/resources/alumno_init.xml"));
	}

}
 