package com.diego.testing.practices;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HappyLlamasTest {

	
	@Test
    public void testNormalTrampoline10() {
        // ARRANGE - for simple methods, this means setting up the parameters
        boolean isNasaFabric = false;
        int numTrampolines = 10;
        
        // ACT - for simple methods, this generally means calling the method under test
        // and then capturing its return to assert on
        boolean result = areTheLlamasHappy(isNasaFabric, numTrampolines);
        
        // ASSERT - basically just a conditional that proves the result is what
        // you expect it to be, plus an extra message to display if it doesn't match.
        //
        // There are a wide variety of assert types, here we
        // just want to assert that it returned false. But we could have also used
        // assertEquals and passed in a false value.
        
        assertFalse( result , "10 Llamas w/ Normal Trampolines should be Unhappy!" );
    }
	
	@Test
    public void testNormalTrampoline42() {
        // ARRANGE - setting up the parameters
        boolean isNasaFabric = false;
        int numTrampolines = 42;
        
        // ACT - calling the method under test
        boolean result = areTheLlamasHappy(isNasaFabric, numTrampolines);
        
        // ASSERT - basically just a conditional that proves the result is what
        // you expect it to be, plus an extra message to display if it doesn't match.
        assertTrue( result , "42 Llamas with Normal Trampolines should be happy!" );
        assertEquals(result, true);
    }
	
	
	@Test
    public void testUltraBouncyTrampoline55() {
        // ARRANGE - setting up the parameters
        boolean isNasaFabric = true;
        int numTrampolines = 55;
        
        // ACT - calling the method under test
        boolean result = areTheLlamasHappy(isNasaFabric, numTrampolines);
        
        // ASSERT - basically just a conditional that proves the result is what
        assertTrue( result , "55 Llamas with ultraBouncy Trampolines should be happy!" );
        assertEquals(result, true);
    }
	

	public static boolean areTheLlamasHappy(boolean ultraBouncy, int trampolines) {
		boolean happy;
		
		if (ultraBouncy == true && trampolines >=24) {
			happy = true;
		}else if(ultraBouncy == false && trampolines >= 24 && trampolines <=42) {
			
			happy = true;
		}else {
			happy = false; 
		}
		
		
		return happy; 
	}

}
