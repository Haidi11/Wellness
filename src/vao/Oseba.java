package vao;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import orodja.Oro;

@Entity(name = "Oseba")
public class Oseba {

	private int idOseba;
	private String ime;
	private String priimek;
	private String email;
	private boolean kadrovskaSluzba;
	private boolean organizatorDogodkov;
	private String spol;
	private String oddelek;
	private int tocke;
	private Calendar datumRojstva;
	private Calendar datumZaposlitve;
	private String EMSO;
	private String telefonskaStevilka;
	private String davcnaStevilka;

	private List<Dogodek> dogodki;

	// nastavi na prazno za resetiranje vnosnih polj
	public Oseba() {
		this.ime = "";
		this.priimek = "";
		this.email = "";
		this.kadrovskaSluzba = false;
		this.organizatorDogodkov = false;
		this.spol = "";
		this.oddelek = "";
		this.telefonskaStevilka = "";
		this.tocke = 0;
		this.EMSO = "";
		this.datumRojstva = new GregorianCalendar();
		this.datumZaposlitve = new GregorianCalendar();

	}

	/*
	 * za izpis datumov
	 */
	@Transient
	public String getIzpisiDatumRojstva() {
		return Oro.izpisiDatum(datumRojstva);
	}

	@Transient
	public String getIzpisiDatumZaposlitve() {
		return Oro.izpisiDatum(datumZaposlitve);
	}

	/*
	 * getterji/setterji
	 */
	public boolean isOrganizatorDogodkov() {
		return organizatorDogodkov;
	}

	@Transient
	public boolean getOrganizatorDogodkov() {
		return organizatorDogodkov;
	}

	public void setOrganizatorDogodkov(boolean orgaizatorDoodkov) {
		this.organizatorDogodkov = orgaizatorDoodkov;
	}

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

	public boolean isKadrovskaSluzba() {
		return kadrovskaSluzba;
	}

	public void setKadrovskaSluzba(boolean kadrovskaSluzba) {
		this.kadrovskaSluzba = kadrovskaSluzba;
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
}