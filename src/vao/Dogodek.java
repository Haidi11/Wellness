package vao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import orodja.Oro;

import javax.persistence.JoinColumn;

@Entity
public class Dogodek {

	@Id
	@GeneratedValue
	private int idDogodek;
	private String naziv;
	private Calendar datumZacetka;
	private Calendar datumKonca;
	private int tocke;
	private int steviloPrijavljenih;
	private String opisDogodka;
	
	
	@ManyToMany(cascade = { 
	        CascadeType.PERSIST, 
	        CascadeType.MERGE
	    })
	@JoinTable(name = "dogodek_oseba",
	        joinColumns = @JoinColumn(name = "idDogodek"),
	        inverseJoinColumns = @JoinColumn(name = "idOseba")
	    )
	private List <Oseba> udelezenci = new ArrayList<>();
	
	
	
	
	public Dogodek () {
		this.datumKonca=new GregorianCalendar();
		this.datumZacetka=new GregorianCalendar();
		this.naziv="";
		this.tocke=0;
		this.opisDogodka="";
			
	}
	/*
	 * izpis datumov
	 */
	public String getIzpisiZacetek() {
		return Oro.izpisiDatum(datumZacetka);
	}
	public String getIzpisiKonca() {
		return Oro.izpisiDatum(datumKonca);
	}
	
	
	/*
	 * getterji, setterji
	 */
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getIdDogodek() {
		return idDogodek;
	}
	public void setIdDogodek(int idDogodek) {
		this.idDogodek = idDogodek;
	}
	
	public List<Oseba> getUdelezenci() {
		return udelezenci;
	}
	public void setUdelezenci(List<Oseba> udelezenci) {
		this.udelezenci = udelezenci;
	}
	public Calendar getDatumZacetka() {
		return datumZacetka;
	}
	public void setDatumZacetka(Calendar datumZacetka) {
		this.datumZacetka = datumZacetka;
	}
	public Calendar getDatumKonca() {
		return datumKonca;
	}
	public void setDatumKonca(Calendar datumKonca) {
		this.datumKonca = datumKonca;
	}
	public int getTocke() {
		return tocke;
	}
	public void setTocke(int tocke) {
		this.tocke = tocke;
	}
	public int getSteviloPrijavljenih() {
		return steviloPrijavljenih;
	}
	public void setSteviloPrijavljenih(int steviloPrijavljenih) {
		this.steviloPrijavljenih = steviloPrijavljenih;
	}
	public String getOpisDogodka() {
		return opisDogodka;
	}
	public void setOpisDogodka(String opisDogodka) {
		this.opisDogodka = opisDogodka;
	}
	
}
