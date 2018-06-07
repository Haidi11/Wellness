package vao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import orodja.Oro;

@Entity(name = "Oseba")
public class Oseba {

	private int idOseba;
	private String ime;
	private String priimek;
	private String email;
	private String spol;
	private String oddelek;
	private int tocke;
	private Calendar datumRojstva;
	private Calendar datumZaposlitve;
	private String EMSO;
	private String telefonskaStevilka;
	private String davcnaStevilka;
	private String vloga;
	private String geslo;
	private String uporabniskoIme;
	private String ulica;
	private String hisnaStevilka;
	private String posta;
	private int postnaStevilka;
	private String drzava;

	@Transient
	private String udelezba;
	@Transient
	private boolean gumbUdelezba;
	@Transient
	private int stTockTaMesec;

	private List<Nasvet> nasveti = new ArrayList<>();
	private List<Dogodek> dogodki = new ArrayList<>();
	private List<Tekmovanje> tekmovanja = new ArrayList<>();

	// nastavi na prazno za resetiranje vnosnih polj
	public Oseba() {
		this.ime = "";
		this.priimek = "";
		this.email = "";
		this.spol = "";
		this.oddelek = "";
		this.telefonskaStevilka = "";
		this.tocke = 0;
		this.EMSO = "";
		this.datumRojstva = new GregorianCalendar();
		this.datumZaposlitve = new GregorianCalendar();
		this.vloga = "";
		this.ulica = "";
		this.hisnaStevilka = "";
		this.posta = "";
		this.postnaStevilka = 0;
		this.drzava = "";

	}

	public Oseba(int id) {
		this.idOseba = id;
	}

	/*
	 * za izpis datumov
	 */
	@Transient
	public String getIzpisiDatumRojstva() {
		return Oro.izpisiSamoDatum(datumRojstva);
	}

	@Transient
	public String getIzpisiDatumZaposlitve() {
		return Oro.izpisiSamoDatum(datumZaposlitve);
	}

	/*
	 * getterji/setterji
	 */



	

	

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPriimek() {
		return priimek;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdOseba() {
		return idOseba;
	}

	public void setIdOseba(int id) {
		this.idOseba = id;
	}

	public String getSpol() {
		return spol;
	}

	public void setSpol(String spol) {
		this.spol = spol;
	}

	public String getOddelek() {
		return oddelek;
	}

	public void setOddelek(String oddelek) {
		this.oddelek = oddelek;
	}

	public int getTocke() {
		return tocke;
	}

	public void setTocke(int tocke) {
		this.tocke = tocke;
	}



	@ManyToMany(mappedBy = "udelezenci")
	public List<Dogodek> getDogodki() {
		return dogodki;
	}

	public void setDogodki(List<Dogodek> dogodki) {
		this.dogodki = dogodki;
	}

	public Calendar getDatumRojstva() {
		return datumRojstva;
	}

	public void setDatumRojstva(Calendar datumRojstva) {
		this.datumRojstva = datumRojstva;
	}

	public Calendar getDatumZaposlitve() {
		return datumZaposlitve;
	}

	public void setDatumZaposlitve(Calendar datumZaposlitve) {
		this.datumZaposlitve = datumZaposlitve;
	}

	public String getEMSO() {
		return EMSO;
	}

	public void setEMSO(String eMSO) {
		EMSO = eMSO;
	}

	public String getTelefonskaStevilka() {
		return telefonskaStevilka;
	}

	public void setTelefonskaStevilka(String telefonskaStevilka) {
		this.telefonskaStevilka = telefonskaStevilka;
	}

	public String getDavcnaStevilka() {
		return davcnaStevilka;
	}

	public void setDavcnaStevilka(String davcnaStevilka) {
		this.davcnaStevilka = davcnaStevilka;
	}

	public String getVloga() {
		return vloga;
	}

	public void setVloga(String vloga) {
		this.vloga = vloga;
	}

	public String getGeslo() {
		return geslo;
	}

	public void setGeslo(String geslo) {
		this.geslo = geslo;
	}

	public String getUporabniskoIme() {
		return uporabniskoIme;
	}

	public void setUporabniskoIme(String uporabniskoIme) {
		this.uporabniskoIme = uporabniskoIme;
	}

	@Transient
	public String getUdelezba() {
		return udelezba;
	}

	public void setUdelezba(String udelezba) {
		this.udelezba = udelezba;
	}

	@Transient
	public boolean isGumbUdelezba() {
		return gumbUdelezba;
	}

	public void setGumbUdelezba(boolean gumbUdelezba) {
		this.gumbUdelezba = gumbUdelezba;
	}

	@OneToMany(mappedBy = "avtor", targetEntity = Nasvet.class, fetch = FetchType.EAGER)
	public List<Nasvet> getNasveti() {
		return nasveti;
	}

	public void setNasveti(List<Nasvet> nasveti) {
		this.nasveti = nasveti;
	}

	@Transient
	public int getStTockTaMesec() {
		return stTockTaMesec;
	}

	public void setStTockTaMesec(int stTockTaMesec) {
		this.stTockTaMesec = stTockTaMesec;
	}

	@OneToMany(mappedBy = "lastnik", targetEntity = Tekmovanje.class)
	public List<Tekmovanje> getTekmovanja() {
		return tekmovanja;
	}

	public void setTekmovanja(List<Tekmovanje> tekmovanja) {
		this.tekmovanja = tekmovanja;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getHisnaStevilka() {
		return hisnaStevilka;
	}

	public void setHisnaStevilka(String hisnaStevilka) {
		this.hisnaStevilka = hisnaStevilka;
	}

	public String getPosta() {
		return posta;
	}

	public void setPosta(String posta) {
		this.posta = posta;
	}

	public int getPostnaStevilka() {
		return postnaStevilka;
	}

	public void setPostnaStevilka(int postnaStevilka) {
		this.postnaStevilka = postnaStevilka;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
}