package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * Klasa koja predstavlja Twitter platformu
 * @author NikolaCukic
 * @version 1.0
 * 
 */
public class Twitter {
	/**
	 * Lista (atribut) koja sadrzi sve poruke
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Metoda koja vrace sve poruke
	 * @return sve poruke sa Twittera
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}
/**
 * Metoda za unosenje poruke na Twitter
 * @param korisnik Ime korisnika cija je poruka
 * @param poruka Poruka koju zelimo da unesemo
 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}

	/**
	 * Metoda koja vraca niz poruka sa datim tag-om
	 * @param maxBroj Maksimalan broj poruka koji moze da se vrati
	 * @param tag Tak prema kome se pretrazuju poruke
	 * @return Niz odredjenog broja poruka
	 * @throws java.lang.RuntimeException Tag ne sme biti null i mora biti unet
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}