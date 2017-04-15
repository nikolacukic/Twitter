package test.com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterPorukaTest {

	private TwitterPoruka poruka;
	
	@Before
	public void setUp() throws Exception {
		poruka = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetKorisnik() {
		poruka.setKorisnik("Jendvaproba");
		assertEquals("Jendvaproba", poruka.getKorisnik());
	}
	 	
	@Test(expected = java.lang.RuntimeException.class)
	 	public void testSetKorisnikEmpty() {
		poruka.setKorisnik("");
	}
	 	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		poruka.setKorisnik(null);
	}
	 
	@Test
	public void testSetPoruka() {
		poruka.setPoruka("Ovo je moj prvi tvit");
	}
	 	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
	 	poruka.setPoruka(null);
	}
	 	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaEmpty() {
	 	poruka.setPoruka("");
	}
	 	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaDuzina() {
	 	poruka.setPoruka("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
	 					+"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
	 					+"ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
	}
	 
	@Test
	public void testToString() {
	 	poruka.setKorisnik("Mali Alek");
	 	poruka.setPoruka("Tisina tamo");
	 	assertEquals("KORISNIK:Mali Alek PORUKA:Tisina tamo",poruka.toString());
	}
	 
}
