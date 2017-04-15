package com.twitter.poruke;
/**
 Klasa koja oznacava twitter poruku
 
 @author NikolaCukic
 @version 1.0
 */
public class TwitterPoruka {
	/**
	 *Promenljiva koja sadrzi korisnicko ime osobe koja je objavila poruku
	   */
	private String korisnik;
	/**
	 *Promenljiva koja oznacava sadrzaj twitter poruke 
	 */
	private String poruka;
	
	/**
	 * Metoda koja vraca autora poruke
	 * @return Korisnicko ime osobe koja je objavila poruku
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Metoda za unosenje imena korisnika
	 * @param korisnik Korisnicko ime osobe koje zelimo da unesemo
	 * @throws java.lang.RuntimeException String korisnik ne sme biti null ili prazan
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik.isEmpty())
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	
	/**
	 * Metoda koja vraca zeljenu poruku
	 * @return Poruka korisnika kojeg smo zeleli
	 */
	public String getPoruka() {
		return poruka;
	}
	
	/**
	 * Metoda kojom se vrsi unos poruke za odredjenog korisnika
	 * @param poruka Sadrzaj poruke koji zelimo da postavimo
	 * @throws java.lang.RuntimeException Poruka ne sme biti null, prazna ili duza od 140 karaktera
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || poruka.isEmpty() || poruka.length()>140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	
	}
	/**
	 * Metoda koja konvertuje objekat klase TviterPoruka u tekstualni format
	 * 
	 * @return String koji sadrzi informacije o korisniku i njegovoj poruci
	 */
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	} 
}
