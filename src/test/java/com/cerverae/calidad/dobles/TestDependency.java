package com.cerverae.calidad.dobles;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;


import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.omg.CORBA.PUBLIC_MEMBER;

import static org.hamcrest.Matchers.*;


public class TestDependency {

	private Dependency dependency;
	
	@Before 
	public void setupMocks() {
		dependency = mock(Dependency.class);
		//dependency = new Dependency(new SubDependency());
	}
	
	
	@Test
	public void testDummy() {
		
		when(dependency.getClassName()).thenReturn("Dependency");
		
		
		assertThat(dependency.getClassName(), is("Dependency"));
		//assertNull(dependency.getClassName());
		//assertNull(dependency.getClassNameUpperCase());
		//assertNull(dependency.getSubDependencyClassName());
	}
	
	@Test
	public void testOtroNombre() {
		
		when(dependency.getClassName()).thenReturn("OtroNombre");
		
		
		assertThat(dependency.getClassName(), is("OtroNombre"));
	
	}
	@Test(expected = IllegalArgumentException.class)
	public void testException() {
		
		when(dependency.getClassName()).thenThrow(IllegalArgumentException.class);
		dependency.getClassName();
		
	
	}
	
	@Test
	public void testAddTwo() {
		
		when(dependency.addTwo(anyInt())).thenReturn(5);
		
		
		assertThat(dependency.addTwo(1), is(5));
		assertThat(dependency.addTwo(27), is(5));
	
	}
	
	@Test
	public void testAnswer() {
		when(dependency.addTwo(anyInt())).thenAnswer(new Answer<Integer>() {
			public Integer answer(InvocationOnMock invocation) throws Throwable {
			 int arg = (Integer) invocation.getArguments()[0];
			 return arg + 20;
			}
			
		});
		
		assertThat(dependency.addTwo(65), is(85));
	}
	
	@Test
	public void testMultiply() {
		when(dependency.multiply(anyInt(), anyInt())).thenAnswer(new Answer<Integer>() {
			public Integer answer(InvocationOnMock invocation) throws Throwable {
			 int arg1 = (Integer) invocation.getArguments()[0];
			 int arg2 = (Integer) invocation.getArguments()[1];
			 return arg1 * arg2;
			}
			
		});
		
		assertThat(dependency.multiply(3, 6), is(18));
	}
	
	

}
