package Objektno;



public class Administrator extends Zaposleni {

	public Administrator() {
		super();
	}

	public Administrator(String id, String ime, String prezime, String jMBG, String adresa, EnumPol pol,
			String korisnickaSifra, String korisnickoIme) {
		super(id, ime, prezime, jMBG, adresa, pol, korisnickaSifra, korisnickoIme);
	}

	@Override
	public String toString() {
		return  id+ ";" + ime + ";" + prezime + ";" + JMBG + ";" + adresa + ";" + pol+ ";" + korisnickaSifra + ";" + korisnickoIme ;
	}
	
	public void DodatiNoveZaposlene() {
		
	}

}
