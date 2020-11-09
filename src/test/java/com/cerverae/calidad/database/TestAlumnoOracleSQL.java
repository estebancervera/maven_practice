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

public class TestAlumnoOracleSQL extends DBTestCase {

	
	
	
	public TestAlumnoOracleSQL(String name) {
		super(name);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "oracle.jdbc.driver.OracleDriver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:oracle:thin:@localhost:1521:xe");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "dbunit");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "dbunit");	
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

	
	
	
	@Test
	public void testInsert() {
		Alumno alumno = new Alumno(4, "Esteban C", 23, 9, "esteban@gmail.com");
		AlumnoDaoOracleSQL daoMySQL = new AlumnoDaoOracleSQL();
		
		daoMySQL.addAlumno(alumno);
		
		//verify
		try {
			IDataSet databaseDataSet = getConnection().createDataSet();
			
			ITable actualTable = databaseDataSet.getTable("alumno");
			
			//InputStream xmlFileInputStream = getClass().getResourceAsStream("src/resources/insert_result.xml");
			IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src/resources/insert_result.xml"));
			ITable expectedTable = expectedDataSet.getTable("alumno");
			
			Assertion.assertEquals(expectedTable, actualTable);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

	 
	
	@Test
	
	public void testInsertCount() {
		
		Alumno alumno = new Alumno(5, "Esteban 3", 21, 10, "esteban@gmail.com");
		AlumnoDaoOracleSQL daoOracle = new AlumnoDaoOracleSQL();
		
		IDatabaseConnection connection;
		
		try {
			
			connection = getConnection();
			
			int actualRows = connection.getRowCount("alumno");
			daoOracle.addAlumno(alumno);
			assertEquals(actualRows + 1, connection.getRowCount("alumno"));
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected IDataSet getDataSet() throws Exception {
		// TODO Auto-generated method stub
		//InputStream xmlFile = getClass().getResourceAsStream("src/resources/alumno_init.xml");
		return new FlatXmlDataSetBuilder().build(new File("src/resources/alumno_init.xml"));
	}

}
 