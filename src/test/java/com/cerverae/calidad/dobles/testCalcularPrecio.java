package com.cerverae.calidad.dobles;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.hamcrest.Matcher;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;


import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.omg.CORBA.PUBLIC_MEMBER;

import  org.hamcrest.*;


public class testCalcularPrecio {
	
	private CalcularIVAYucatan ivaYucatan;
	private CalcularPrecio calculadora;
	
	@Before
	public void setupMocks() {
		ivaYucatan = mock(CalcularIVAYucatan.class);
		//dependency = new Dependency(new SubDependency());
		calculadora = new CalcularPrecio();
	}

	@Test
	public void testCalcular() {
		when(ivaYucatan.getIVA(anyFloat(), anyFloat())).thenReturn(16f);
		
		float total = calculadora.calcularIva(ivaYucatan);
		assertThat(total, is(116.0f));
		
		
	}

	

}
