package com.twitter;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {

	private Twitter t;
	private LinkedList<TwitterPoruka> poruke;
	private TwitterPoruka tp;
	private TwitterPoruka[] test;
	
	@Before
	public void setUp() throws Exception {
		 t = new Twitter();
		 tp = new TwitterPoruka();
		 poruke = new LinkedList<>();
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void unesiKorisnikProvera(){
		
		
		t.unesi("Filip", "Kosovo 1389");
		tp.setPoruka("Kosovo 1389");
		tp.setKorisnik("Filip");
		
		poruke.add(tp);
		
		assertEquals(poruke.getLast().getKorisnik(), t.vratiSvePoruke().getLast().getKorisnik());
		
	}
	@Test
	public void unesiPorukaProvera(){
		
		
		t.unesi("Visnjic", "Bregalnica 1913");
		tp.setPoruka("Bregalnica 1913");
		tp.setKorisnik("Visnjic");
		
		poruke.add(tp);
		
		assertEquals(poruke.getLast().getPoruka(), t.vratiSvePoruke().getLast().getPoruka());
		
	}
	@Test
	public void vratiSvePoruke(){
		
		t.unesi("Dr Dre", "Yeah");
		tp.setKorisnik("Dr Dre");
		tp.setPoruka("Yeah");
		
		poruke.addLast(tp);
		
		assertEquals(poruke.getFirst().toString(), t.vratiSvePoruke().getFirst().toString());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void vratiPorukeTagNull(){
		t.vratiPoruke(100,null);
			
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void vratiPorukeTagPrazan(){
		t.vratiPoruke(100,"");		
	}

	@Test
	public void vratiPorukeDaLiRadi(){
		TwitterPoruka tp1 = new TwitterPoruka();
		TwitterPoruka tp2 = new TwitterPoruka();
		test = new TwitterPoruka[3];
		
		t.unesi("Filip", "Kosovo 1389");
		tp.setPoruka("Kosovo 1389");
		tp.setKorisnik("Filip");
		poruke.add(tp);
		
		
		t.unesi("Dr Dre", "Yeah 1389");
		tp1.setPoruka("Yeah 1389");
		tp1.setKorisnik("Dr Dre");
		poruke.add(tp1);
		
		t.unesi("Visnjic", "Bregalnica nije 1389");
		tp2.setPoruka("Bregalnica nije 1389");
		tp2.setKorisnik("Visnjic");
		poruke.add(tp2);
		
		test[0] = tp;
		test[1] = tp1;
		test[2] = tp2;
 		
		assertEquals(Arrays.toString(test), Arrays.toString(t.vratiPoruke(3, "1389")));
		
		
			
	}

}
