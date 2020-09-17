package lab4;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testCube() {
		// check if cube function is working by testing against 3
		assertEquals(27, Calculator.cube(3));
	}
	
	@Test
	public void testMax() {
		int arr[] = {3, 5, 7, 1, 9, 10};
		
		// check if the find max functions is working or not by testing 
		// against dummy array with max 10
		assertEquals(10,  Calculator.findMax(arr));
	}
	
	@Test
	public void testRev() {
		String word = "program";
		
		// check if reverse function can successfully reverse the word
		// program
		// or not.
		
		assertEquals("margorp", Calculator.reverseWord(word));
	}
	
	// all tests are passed successfully.
	
}
