package biblioteka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import enumeracije.JezikOriginala;
import enumeracije.Pol;
import ljudi.Administrator;
import ljudi.Bibliotekar;
import ljudi.Clan;
import ljudi.TipClanarine;
import ljudi.Zaposleni;

public class Biblioteka {	
	
	
	
	
	

    protected String naziv;
    protected String adresa;
    protected String telefon;
    protected LocalDate radiOd;
    protected LocalDate radiDo;
    protected String id;
    protected ArrayList<Knjiga> knjige;
    protected ArrayList<ZanrKnjige> zanrovi;
    protected ArrayList<Administrator> admin;
    protected ArrayList<Clan> clanBiblioteke;
    protected ArrayList<Iznajmljivanje> iznajmljivanjeKnjige;
    protected ArrayList<TipClanarine> tipClanarine;
    protected ArrayList<PrimerakKnjige> primerakKnjige;
    protected ArrayList<Zaposleni> zaposleni;
    protected ArrayList<Bibliotekar> bibliotekar;

    
    public Biblioteka() {
    	
    	this.naziv = "";
    	this.adresa = "";
    	this.telefon = "";
    	this.id = "";
    	this.radiOd = null;
    	this.radiDo = null;
    	this.admin = new ArrayList<Administrator>();
    	this.knjige = new ArrayList<Knjiga>();
    	this.zanrovi = new ArrayList<ZanrKnjige>();
    	this.clanBiblioteke = new ArrayList<Clan>();
    	this.tipClanarine = new ArrayList<TipClanarine>();
    	this.iznajmljivanjeKnjige = new ArrayList<Iznajmljivanje>();
    	this.primerakKnjige = new ArrayList<PrimerakKnjige>();
    	this.zaposleni = new ArrayList<Zaposleni>();
    	this.bibliotekar = new ArrayList<Bibliotekar>();
    
    }
    
    public Biblioteka(String naziv, String adresa, String telefon, LocalDate radiOd, LocalDate radiDo, String id) {
    	
    	super();
    	this.naziv = naziv;
    	this.adresa = adresa;
    	this.telefon = telefon;
    	this.id = id;
    	this.radiOd = radiOd;
    	this.radiDo = radiDo;
    	this.admin = new ArrayList<Administrator>();
    	this.knjige = new ArrayList<Knjiga>();
    	this.zanrovi = new ArrayList<ZanrKnjige>();
    	this.clanBiblioteke = new ArrayList<Clan>();
    	this.tipClanarine = new ArrayList<TipClanarine>();
    	this.iznajmljivanjeKnjige = new ArrayList<Iznajmljivanje>();
    	this.primerakKnjige = new ArrayList<PrimerakKnjige>();
    	this.zaposleni = new ArrayList<Zaposleni>();
    	this.bibliotekar = new ArrayList<Bibliotekar>();
    }

    public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public LocalDate getRadiOd() {
		return radiOd;
	}
	public void setRadiOd(LocalDate radiOd) {
		this.radiOd = radiOd;
	}
	public LocalDate getRadiDo() {
		return radiDo;
	}
	public void setRadiDo(LocalDate radiDo) {
		this.radiDo = radiDo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Knjiga> getKnjige() {
		return knjige;
	}
	public void setKnjige(ArrayList<Knjiga> knjige) {
		this.knjige = knjige;
	}
	public ArrayList<ZanrKnjige> getZanrovi() {
		return zanrovi;
	}
	public void setZanrovi(ArrayList<ZanrKnjige> zanrovi) {
		this.zanrovi = zanrovi;
	}
	public ArrayList<Administrator> getAdmin() {
		return admin;
	}
	public void setAdmin(ArrayList<Administrator> admin) {
		this.admin = admin;
	}
	public ArrayList<Clan> getClanBiblioteke() {
		return clanBiblioteke;
	}
	public void setClanBiblioteke(ArrayList<Clan> clanBiblioteke) {
		this.clanBiblioteke = clanBiblioteke;
	}
	public ArrayList<Iznajmljivanje> getIznajmljivanjeKnjige() {
		return iznajmljivanjeKnjige;
	}
	public void setIznajmljivanjeKnjige(ArrayList<Iznajmljivanje> iznajmljivanjeKnjige) {
		this.iznajmljivanjeKnjige = iznajmljivanjeKnjige;
	}
	public ArrayList<TipClanarine> getTipClanarine() {
		return tipClanarine;
	}
	public void setTipClanarine(ArrayList<TipClanarine> tipClanarine) {
		this.tipClanarine = tipClanarine;
	}
	public ArrayList<PrimerakKnjige> getPrimerakKnjige() {
		return primerakKnjige;
	}
	public void setPrimerakKnjige(ArrayList<PrimerakKnjige> primerakKnjige) {
		this.primerakKnjige = primerakKnjige;
	}
	public ArrayList<Zaposleni> getZaposleni() {
		return zaposleni;
	}
	public void setZaposleni(ArrayList<Zaposleni> zaposleni) {
		this.zaposleni = zaposleni;
	}
	public ArrayList<Bibliotekar> getBibliotekar() {
		return bibliotekar;
	}
	public void setBibliotekar(ArrayList<Bibliotekar> bibliotekar) {
		this.bibliotekar = bibliotekar;
	}

	public Zaposleni login(String korisnickoIme, String lozinka) {
			for (Bibliotekar bibliotekar : this.bibliotekar) {
				if(bibliotekar.getKorisnickoIme().equalsIgnoreCase(korisnickoIme)&& bibliotekar.getLozinka().equals(lozinka) && 
						!bibliotekar.isObrisan()) {
					return bibliotekar;
				}
			}
			for(Administrator admin : this.admin) {
				if(admin.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) &&
						admin.getLozinka().equals(lozinka) && !admin.isObrisan()) {
					return admin;
				}
			}
			return null;
		}
	
	
	public void citajClanarine() throws IOException{
		this.tipClanarine = new ArrayList<TipClanarine>();
		File file = new File("fajlovi/tipclanarine.txt");
		BufferedReader citanje = new BufferedReader(new FileReader(file));
		String line1 = null;
		while((line1 = citanje.readLine())!= null) {
			String[]nizClanova = line1.split("\\|");
			String id = nizClanova[0];
			String tip = nizClanova[1];
			int cena = Integer.parseInt(nizClanova[2]);
			TipClanarine tip2  = new TipClanarine(id, tip, cena, false);
			tipClanarine.add(tip2);
		}
		citanje.close();
	}
	public void upisiTipClanarine(TipClanarine t) throws IOException{
		File file = new File("fajlovi/tipclanarine.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
		String sb = t.getTip()+ "|"+ t.getId()+ "|"+t.getCena();
		writer.write(sb);
		writer.newLine();;
		writer.close();
	}
	public void sacuvajTipClanarine() throws IOException{
        File file=new File("projekatObjektno/tipclanarine.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for(TipClanarine c : this.tipClanarine) {
            String linija = c.getTip() + "|" +c.getId() + "|" +c.getCena();
            writer.write(linija);
            writer.newLine();
        }
        writer.close();
    }
	public ArrayList<TipClanarine> sviNeobrisaniTipovi() {
		ArrayList<TipClanarine> neobrisani = new ArrayList<TipClanarine>();
		for (TipClanarine tipovi : tipClanarine) {
			if(!tipovi.isObrisan()) {
				neobrisani.add(tipovi);
			}
		}
		return neobrisani;
	}
	public TipClanarine pronadjiTip(String id) {
		for (TipClanarine tip : this.tipClanarine) {
			if(tip.getId().equals(id)) {
				return tip;
			}
		}
		return null;
	}
	
	public void citajKnjige() throws IOException{
		this.knjige = new ArrayList<Knjiga>();
		File fajl = new File("fajlovi/knjige.txt");
		BufferedReader citaj = new BufferedReader(new FileReader(fajl));
		String line = null;
		while((line = citaj.readLine())!= null) {
			String [] niz = line.split("\\|");
			String naslov = niz[0];
			String originalniNaslov = niz[1];
			String pisac = niz[2];
			int godinaObjavljivanja = Integer.parseInt(niz[3]);
			String opisKnjige = niz[4];
			String id  = niz[5];
			String jezikOroginala = niz[7];
			JezikOriginala jezikOriginala = JezikOriginala.Engleski;
			for (JezikOriginala j: JezikOriginala.values()) {
				if(j.name().equalsIgnoreCase(jezikOroginala)){
					jezikOriginala = j;
				}
			}
			this.citajZanr();
			ZanrKnjige zanr = null;
			for (ZanrKnjige z : zanrovi) {
				if(z.getId().equals(niz[6])) {
					zanr = z;
				}
			}
			Boolean obrisan = Boolean.parseBoolean(niz[8]);
			Knjiga knjiga = new Knjiga(naslov, originalniNaslov, pisac, godinaObjavljivanja, opisKnjige, id, zanr, jezikOriginala, obrisan);
			knjige.add(knjiga);
		}
		citaj.close();
	}
	
	public void obrisiKnjigu(String id) throws IOException {
		Knjiga knjiga = null;
		for (Knjiga k : this.knjige) {
			if(k.getId().equals(id)) {
				knjiga = k;
			}
		}
		knjiga.setObrisan(true);
	}
	
	public void sacuvajKnjige() throws IOException{
        File file=new File("projekatObjektno/knjige.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for(Knjiga c : this.knjige) {
            String linija = c.getId() + "|" +c.getNaslov() + "|" +c.getOriginalniNaslov() + "|" +
                    c.getPisac()+ "|"+ c.getGodinaObjavljivanja()+ "|" +c.getJezikOriginala() + "|" + c.getOpisKnjige() + "|" + c.getZanr().getId() + "|" +c.isObrisan();
            writer.write(linija);
            writer.newLine();
        }
        writer.close();
    }
	public ArrayList<Knjiga> sveNeobrisaneKnjige() {
		ArrayList<Knjiga> neobrisani = new ArrayList<Knjiga>();
		for (Knjiga knjiga : knjige) {
			if(!knjiga.isObrisan()) {
				neobrisani.add(knjiga);
			}
		}
		return neobrisani;
	}

	public void upisiFajl(Knjiga k1) throws IOException{
		File file = new File("fajlovi/knjige.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
		String output = k1.getNaslov() +"|"+ k1.getOriginalniNaslov() + "|"+k1.getPisac()+ "|"+k1.getGodinaObjavljivanja() +"|"+ k1.getOpisKnjige()+ "|" + k1.getId()+"|"+k1.getZanr().getId()+"|"+k1.getJezikOriginala();
		writer.write(output);
		writer.newLine();
		writer.close();
		
	}
	public Knjiga pronadjiKnjigu(String id) {
		for (Knjiga knjiga : knjige) {
			if(knjiga.getId().equals(id)) {
				return knjiga;
			}
		}
		return null;
	}
	
	public void citajZanr() throws IOException{
		this.zanrovi = new ArrayList<ZanrKnjige>();
		File fajl = new File("fajlovi/zanrovi.txt");
		BufferedReader citaj = new BufferedReader(new FileReader(fajl));
		String line = null;
		while((line = citaj.readLine())!= null) {
			String [] niz = line.split("\\|");
			String oznaka = niz[0];
			String opisZanra = niz[1];
			String id = niz[2];
			Boolean obrisan = Boolean.parseBoolean(niz[3]);
			ZanrKnjige zanr = new ZanrKnjige(oznaka, opisZanra, id, obrisan);
			this.zanrovi.add(zanr);
		}
		citaj.close();
	}
	public void upisiZanr(ArrayList<ZanrKnjige>zanrovi) throws IOException{
		File file = new File("fajlovi/zanrovi.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for (ZanrKnjige zanr: zanrovi) {
		String output = zanr.getOznaka() + "|"+ zanr.getOpisZanra() + "|" + zanr.getId() +"|"+ zanr.isObrisan();;
			writer.write(output);
			writer.newLine();
		}
		writer.close();
	}
	
	public void praviZanrKnjige(String id,String oznaka, String opis,boolean jeObrisan) throws IOException {
		this.citajZanr();
		ZanrKnjige zanr = new ZanrKnjige(id,oznaka,opis,false);
		this.zanrovi.add(zanr);
		this.upisiZanr(zanrovi);		
	}
	
	public void obrisiZanr(String id) throws IOException {
		ZanrKnjige zanr = null;
		for (ZanrKnjige z : this.zanrovi) {
			if(z.getId().equals(id)) {
				zanr = z;
			}
		}
		zanr.setObrisan(true);
	}
	
	public void upisiFajl(Biblioteka k ) throws IOException{
		File file = new File("fajlovi/biblioteka.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
		String output = k.getAdresa() +"|"+ k.getId() +"|"+ k.getNaziv() + "|"+k.getTelefon()+ "|"+k.getRadiOd() +"|" +k.getRadiDo();
		writer.write(output);
		writer.newLine();
		writer.close();
	}
	public void sacuvajZanrKnjige() throws IOException{
        File file=new File("projekatObjektno/zanrovi.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for(ZanrKnjige c : this.zanrovi) {
            String linija = c.getId() + "|" +c.getOznaka() + "|" +c.getOpisZanra() + "|" + c.isObrisan();
            writer.write(linija);
            writer.newLine();
        }
        writer.close();
    }
	public ArrayList<ZanrKnjige> sviNeobrisaniZanrovi() {
		ArrayList<ZanrKnjige> neobrisani = new ArrayList<ZanrKnjige>();
		for (ZanrKnjige zanr : zanrovi) {
			if(!zanr.isObrisan()) {
				neobrisani.add(zanr);
			}
		}
		return neobrisani;
	}
	public ZanrKnjige pronadjiZanr(String id) {
		for (ZanrKnjige zanr : zanrovi) {
			if(zanr.getId().equals(id)) {
				return zanr;
			}
		}
		return null;
	}
	
	public void citajAdministratora() throws IOException{
		this.admin = new ArrayList<Administrator>();
		File fajl = new File("fajlovi/administartor.txt");
		BufferedReader citaj = new BufferedReader(new FileReader(fajl));
		String line = null;
		while((line = citaj.readLine())!= null) {
			String [] niz = line.split("\\|");
			String ime = niz[0];
			String prezime = niz[1];
			String jmbg = niz[2];
			String adresa = niz[3];
			String id = niz[4];
			String pol = niz[5];
			Pol defpol = Pol.MUSKO;
			for(Pol p:Pol.values()) {
				if(p.name().equalsIgnoreCase(pol)){
					defpol = p;
				}
			}
			String korisnickoIme = niz[6];
			String lozinka = niz[7];
			int plata = Integer.parseInt(niz[8]);
			Boolean obrisan = Boolean.parseBoolean(niz[9]);
			Administrator admin = new Administrator(ime,prezime,jmbg,adresa,id,defpol,korisnickoIme,lozinka,plata, obrisan	);
			this.admin.add(admin);
			}
		citaj.close();
	}
	public void upisiFajlAdministartor(ArrayList<Administrator>administartori) throws IOException{
		File file = new File("fajlovi/administartor.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
		for (Administrator admin: administartori) {
			String output = admin.getId() +"|"+ admin.getIme() + "|"+admin.getPrezime()+ "|"+admin.getJmbg() +"|"+ admin.getAdresa()+ "|" +admin.getPol()
			+"|"+admin.getKorisnickoIme()+"|"+admin.getLozinka() + "|" + admin.getPlata() + "|" + admin.isObrisan();
			writer.write(output);
			writer.newLine();
		}
		writer.close();
	}
	
	public void praviAdministatora(String ime, String prezime, String jmbg, String adresa,
    		String id, Pol pol, String korisnickoIme, String lozinka, int plata, boolean obrisan) throws IOException {
		this.citajAdministratora();
		Administrator administrator = new Administrator(id,ime,prezime,jmbg,adresa, pol,lozinka,korisnickoIme,plata,obrisan);
		this.admin.add(administrator);
		this.upisiFajlAdministartor(admin);
	}
	
	public void obrisiAdministratora(String id) throws IOException {
		Administrator administrator = null;
		for(Administrator a: this.admin) {
			if(administrator.getId().equals(id)) {
				administrator = a;
			}
		}
		administrator.setObrisan(true);
	}
	
	public Administrator pronadjiAdmina(String korisnickoIme) {
		for(Administrator admin:this.admin) {
			if(admin.getKorisnickoIme().equals(korisnickoIme)) {
				return admin;
			}	
		}
		return null;
	}
	
	public void sacuvajAdministatore() throws IOException{
        File file=new File("projekatObjektno/administrator.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for(Administrator c : this.admin) {
            String linija = c.getId() + "|" +c.getIme() + "|" +c.getPrezime() + "|" +
                    c.getJmbg()+ "|"+ c.getAdresa()+ "|" +c.getPol() + "|" + c.getLozinka() + "|" + c.getKorisnickoIme() + "|" + c.getPlata() + "|" +c.isObrisan();
            writer.write(linija);
            writer.newLine();
        }
        writer.close();
    }
	public ArrayList<Administrator> sviNeobrisaniAdministatori() {
		ArrayList<Administrator> neobrisani = new ArrayList<Administrator>();
		for (Administrator admini : admin) {
			if(!admini.isObrisan()) {
				neobrisani.add(admini);
			}
		}
		return neobrisani;
	}
	public void citajBibliotekara() throws IOException{
		this.bibliotekar = new ArrayList<Bibliotekar>();
		File fajl = new File("fajlovi/bibliotekar.txt");
		BufferedReader citaj = new BufferedReader(new FileReader(fajl));
		String line = null;
		while((line = citaj.readLine())!= null) {
			String [] niz = line.split("\\|");
			String ime = niz[0];
			String prezime = niz[1];
			String jmbg = niz[2];
			String adresa = niz[3];
			String id = niz[4];
			String poll = niz[5];
			Pol pol = Pol.MUSKO;
			for(Pol p:Pol.values()) {
				if(p.name().equalsIgnoreCase(poll)){
					pol = p;
				}
			}
			String korisnickoIme = niz[6];
			String lozinka = niz[7];
			int plata = Integer.parseInt(niz[8]);
			Boolean obrisan = Boolean.parseBoolean(niz[9]);
			Bibliotekar bibl = new Bibliotekar(id,ime,prezime,jmbg,adresa,pol,lozinka,korisnickoIme, plata, obrisan);
			this.bibliotekar.add(bibl);
			}
		citaj.close();
	}
	public void upisiBibliotekar(Bibliotekar b) throws IOException{
		File file = new File("fajlovi/bibliotekar.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
		String output = b.getId() +"|"+ b.getIme() + "|"+b.getPrezime()+ "|"+b.getJmbg()
		+"|"+ b.getAdresa()+ "|" +b.getPol() +"|"+b.getLozinka()+"|"+b.getKorisnickoIme() + "|" + b.isObrisan();
		writer.write(output);
		writer.newLine();
		writer.close();
	}
	
	public void obrisiBibliotekara(String id) throws IOException {
		Bibliotekar bibliotekar = null;
		for(Bibliotekar b:this.bibliotekar) {
			if(b.getId().equals(id)) {
				bibliotekar = b;
			}
		}
		bibliotekar.setObrisan(true);
	}
	
	public void sacuvajBibliotekre() throws IOException{
        File file=new File("projekatObjektno/bibliotekar.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for(Bibliotekar c : this.bibliotekar) {
            String linija = c.getId() + "|" +c.getIme() + "|" +c.getPrezime() + "|" +
                    c.getJmbg()+ "|"+ c.getAdresa()+ "|" +c.getPol() + "|" + c.getLozinka() + "|" + c.getKorisnickoIme() + "|" + c.getPlata() + "|" +c.isObrisan();
            writer.write(linija);
            writer.newLine();
        }
        writer.close();
    }
	public ArrayList<Bibliotekar> sviNeobrisaniBibliotekari() {
		ArrayList<Bibliotekar> neobrisani = new ArrayList<Bibliotekar>();
		for (Bibliotekar bibliotekari : bibliotekar) {
			if(!bibliotekari.isObrisan()) {
				neobrisani.add(bibliotekari);
			}
		}
		return neobrisani;
	}
	public Bibliotekar pronadjiBibliotekara(String id) {
		for (Bibliotekar bibliotekar : this.bibliotekar) {
			if(bibliotekar.getId().equals(id)) {
				return bibliotekar;
			}
		}
		return null;
	}
	
}