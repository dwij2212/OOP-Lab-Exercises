package lab4;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

	@Test
	public void test() {
		Card c1 = new Card("ace", "hearts", 1);
		Card c2 = new Card("ace", "hearts", 1);
		Card c3 = new Card("ace", "hearts", 2);
		assertEquals(c1.getRank(), c2.getRank());
		assertEquals(c1.getSuit(), c2.getSuit());
		
		// This will not give any error because we are comparing only 
		// suit and rank(ace/king etc)
		assertTrue(c1.matches(c3));
	}
	

}
