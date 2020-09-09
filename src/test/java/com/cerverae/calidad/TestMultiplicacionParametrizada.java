package com.cerverae.calidad;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;



@RunWith(Parameterized.class)
public class TestMultiplicacionParametrizada {
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object [][] {
			{4,2,2}, {6,3,2}, {5,5,1}, {10,5,2}
		});
	}
	
	private float multiplierOne;
	private float expected;
	private float multiplierTwo;
	private static Calculadora miCalculadora;
	
	@BeforeClass 
	
	public static void setup() {
		miCalculadora = new Calculadora();
	}
	
	public TestMultiplicacionParametrizada(float expected, float multiplierOne, float multiplierTwo) {
		this.multiplierOne = multiplierOne;
		this.multiplierTwo = multiplierTwo;
		this.expected = expected;
	}
	
	
	
	@Test
	public void test() {
		assertThat(expected, is(miCalculadora.multiplicacion(multiplierOne, multiplierTwo)));
	}

}
