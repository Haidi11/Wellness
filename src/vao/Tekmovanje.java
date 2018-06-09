package vao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import orodja.Oro;

@Entity
public class Tekmovanje {

	@Id
	@GeneratedValue
	private int id;

	private String tip;
	private int potrebneTocke;
	
	
	@ManyToMany(cascade = { 
	        CascadeType.PERSIST, 
	        CascadeType.MERGE
	    },fetch=FetchType.EAGER)
	@JoinTable(name = "tekmovanje_oseba",
	        joinColumns = @JoinColumn(name = "id"),
	        inverseJoinColumns = @JoinColumn(name = "idOseba")
	    )
	private Set<Oseba> zmagovalci= new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "fk_lastnik")
	private Oseba lastnik;

	private int mesec;
	private int leto;

	private String nagrada;

	public Tekmovanje() {
		this.mesec = Calendar.getInstance().get(Calendar.MONTH) + 1;
		this.leto = Calendar.getInstance().get(Calendar.YEAR);
		this.nagrada = "";
		this.lastnik = new Oseba();
		this.tip="";

	}
	@Transient
	public String getIzpisiMesec() {
		
		return Oro.mesec(mesec);
	}
	
	@Transient
	public String getIzpisZmagovalci() {
		String temp=" ";
		
		for(Oseba o : zmagovalci) {
			temp+=o.getIme() + " " + o.getPriimek() + ", ";
			
		}
		return temp.substring(0, temp.length()-1);
		
		
	}

	/*
	 * getterji setterji
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMesec() {
		return mesec;
	}

	public void setMesec(int mesec) {
		this.mesec = mesec;
	}

	public int getLeto() {
		return leto;
	}

	public void setLeto(int leto) {
		this.leto = leto;
	}

	public String getNagrada() {
		return nagrada;
	}

	public void setNagrada(String nagrada) {
		this.nagrada = nagrada;
	}

	public Oseba getLastnik() {
		return lastnik;
	}

	public void setLastnik(Oseba lastnik) {
		this.lastnik = lastnik;
	}

	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public int getPotrebneTocke() {
		return potrebneTocke;
	}
	public void setPotrebneTocke(int potrebneTocke) {
		this.potrebneTocke = potrebneTocke;
	}
	public Set<Oseba> getZmagovalci() {
		return zmagovalci;
	}
	public void setZmagovalci(Set<Oseba> zmagovalci) {
		this.zmagovalci = zmagovalci;
	}

}
