package com.weltio.challenge.ejemplo.junit;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class AssetNotEqualsTeoria {
	
	@Test
	public void miTest() {
		//evalua que los valores no sean iguales
		assertNotEquals(2, 1);
	}
}
