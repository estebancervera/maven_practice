package com.cerverae.calidad;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCalculadora2 {

	
	static Calculadora miCalculadora;
	
	@BeforeClass
	public static void setup() {
		System.out.println("Before test --->");
		miCalculadora = new Calculadora();
	}
	
	
	
	@Test
	public void SumaPositivosTest() {
		float sumando1 = 4;
		float sumando2 = 4;
		float expectedResult = 8;
		float resultado = -1;
		
		//end setup
		
		resultado = miCalculadora.suma(sumando1, sumando2);
		
		// end exercise
		
		assertEquals(expectedResult, resultado, 0); // ---> verify
		
	}
	
	@Test
	public void RestaPositivosTest() {
		float num1 = 30;
		float num2 = 50;
		float expectedResult = -20;
		float resultado = -1;
		
		resultado = miCalculadora.resta(num1, num2);
		
//		assertEquals(expectedResult, resultado, 0);
		
		assertThat(expectedResult, is(resultado));
	}
	
	@Test
	public void DivicionPositivosTest() {
		float num1 = 100;
		float num2 = 5;
		float expectedResult = 20;
		float resultado = -1;
		
		resultado = miCalculadora.division(num1, num2);
		
//		assertEquals(expectedResult, resultado, 0);
		
		assertThat(expectedResult, is(resultado));
	}
	
	@Test
	public void DivicionODenominador() {
		float num1 = 0;
		float num2 = 0;
		float expectedResult = Float.NaN;
		float resultado = -1;
		
		resultado = miCalculadora.division(num1, num2);
		
//		assertEquals(expectedResult, resultado, 0);
		
		assertThat(expectedResult, is(resultado));
	}
	
//	@After
//	
//	public void despues() {
//		System.out.println(">>> Despues de la prueba");
//	}
//	
//	@AfterClass
//	public static void fin() {
//		System.out.println(">>>> Ya termine");
//	}
//	
	

}
