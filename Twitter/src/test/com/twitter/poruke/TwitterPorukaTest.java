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
	 	assertEquals(java.lang.RuntimeException.class, poruka.getKorisnik());
	}
	 	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		poruka.setKorisnik(null);
	 	assertEquals(java.lang.RuntimeException.class, poruka.getKorisnik());
	}
	 
	@Test
	public void testSetPoruka() {
		poruka.setPoruka("Ovo je moj prvi tvit");
	 	assertEquals("Ovo je moj prvi tvit", poruka.getPoruka());
	}
	 	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
	 	poruka.setPoruka(null);
	 	assertEquals(java.lang.RuntimeException.class, poruka.getPoruka());
	}
	 	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaEmpty() {
	 	poruka.setPoruka("");
	 	assertEquals(java.lang.RuntimeException.class, poruka.getPoruka());
	}
	 	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaDuzina() {
	 	poruka.setPoruka("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
	 					+"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
	 					+"ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
	 	assertEquals(java.lang.RuntimeException.class, poruka.getPoruka());
	}
	 
	@Test
	public void testToString() {
	 	poruka.setKorisnik("Mali Alek");
	 	poruka.setPoruka("Tisina tamo");
	 	assertEquals("KORISNIK:Mali Alek PORUKA:Tisina tamo",poruka.toString());
	}
	 
}
