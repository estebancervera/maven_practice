package com.cerverae.calidad;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.net.PasswordAuthentication;

import org.hamcrest.core.Is;
import org.junit.Test;

public class TestValidadorPassword {

	
	
	@Test
	public void testMaximo12characteres() {
		User user = new User();
		user.setPassword("1234567890123");
		String pswd = user.getPassword();
		
		 String err = user.validatePassword();
		 assertThat("La contraseña esta muy larga!", is(err));
			
	}
	@Test
	public void testMinimoUnaMayuscula() {
		User user = new User();
		user.setPassword("abAdefghijk");
		String pswd = user.getPassword();
		
		 String err = user.validatePassword();
		 assertThat("La contraseña necesita tener minimo una mayuscula!", is(err));
			
	}

}
