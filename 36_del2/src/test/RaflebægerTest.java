package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import feltspil.Raflebæger;

public class RaflebægerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/*
	 * Her tester vi om terningerne kun får værdier mellem 2-12. 
	 */

	@Test
	public void test() {
		Raflebæger raflebæger = new Raflebæger();
		int tal = 0;
		int antal = 0;
		while(tal>1000) {
			int sum = raflebæger.getSumterninger();
			if(sum>=1 && sum<=12) {
				antal++;
				tal++;
			}
			else {
				tal++;				
			}
			int expected = 1000;
			int actual = antal;
			assertEquals(expected,actual);
		}
	}
	/*
	 * Til denne her test, har vi brugt en test fra forrige CDIO opgave som skabelon.
	 * Vi tester her om vores terning er tilfældig.
	 */
	@Test
	public void testfordelling() {
	Raflebæger raflebæger = new Raflebæger();
		//int side1 = 0;
		int side2 = 0;
		int side3 = 0;
		int side4 = 0;
		int side5 = 0;
		int side6 = 0;
		int side7 = 0;
		int side8 = 0;
		int side9 = 0;
		int side10 = 0;
		int side11 = 0;
		int side12 = 0;
		
		for (int i = 0; i < 1000; i ++) {
		int kast = raflebæger.getSumterninger();
		if (2 == kast) side2++;
		else if (3 == kast) side3++;
		else if (4 == kast) side4++;
		else if (5 == kast) side5++;
		else if(6 == kast) side6++;
		else if(7== kast) side7++;
		else if (8 == kast) side8++;
		else if (9 == kast) side9++;
		else if (10 == kast) side10++;
		else if(11 == kast) side11++;
		else if(12== kast) side12++;
		}
		 
		System.out.println(" resultat "+"  " +side2 + " " + side3 + " "+ side4 + " " +side5+ " " +side6+ " " +side7 + " " +side8+ " " +side9+ " " +side10+ " " +side11+ " " +side12);

}
}
