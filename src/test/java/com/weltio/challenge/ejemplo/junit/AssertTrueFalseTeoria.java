package com.weltio.challenge.ejemplo.junit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AssertTrueFalseTeoria {
	
	@Test
	public void test1() {
		
		//comprueban que lo que le pase sea falso o verdadero
		
		assertTrue(true);
		
		assertFalse(false);
	}
	
	@Test
	public void test2() {
		
		boolean expresion = (4 == 4);
		
		assertTrue(expresion);
		assertFalse(!expresion);
	}
}
