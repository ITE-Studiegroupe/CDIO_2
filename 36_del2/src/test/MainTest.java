package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import feltspil.Konto;

public class MainTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1001() {
		Konto konto = new Konto();
		konto.setBalance(1000);
		int tal = 0;
		int antalAfvist = 0;
		while(tal < 1000) {
			boolean indsæt = konto.indsætPenge(-1001);
			if(!indsæt) {
				antalAfvist++;
				tal++;
			}
			else {tal++;}
		}
		int actual = antalAfvist;
		int expected = 1000;
	System.out.println(konto.getBalance());
	assertEquals(expected,actual);
		}
	
	@Test
	public void test1000() {
		Konto konto = new Konto();
		konto.setBalance(1000);
		int tal = 0;
		int antalAfvist = 0;
		while(tal < 1000) {
			boolean indsæt = konto.indsætPenge(-1000);
			if(!indsæt) {
				antalAfvist++;
				tal++;
			}
			else {tal++;}
		}
		int actual = antalAfvist;
		int expected = 999;
	System.out.println(konto.getBalance());
	assertEquals(expected,actual);
		}
	
	@Test
	public void test100() {
		Konto konto = new Konto();
		konto.setBalance(1000);
		int tal = 0;
		int antalAfvist = 0;
		while(tal < 1000) {
			boolean indsæt = konto.indsætPenge(-100);
			if(!indsæt) {
				antalAfvist++;
				tal++;
			}
			else {tal++;}
		}
		int actual = antalAfvist;
		int expected = 990;
	System.out.println(konto.getBalance());
	assertEquals(expected,actual);
		}
	

	}

