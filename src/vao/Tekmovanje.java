package vao;

import java.util.Calendar;

import javax.ejb.EJB;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import orodja.Oro;
import vmesniki.DogodekVmesnik;
import vmesniki.OsebaVmesnik;

@Entity
public class Tekmovanje {

	@Id
	@GeneratedValue
	private int id;
//	@Transient
//	@EJB
//	OsebaVmesnik ov;

	private int zmagovalec;

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
		this.zmagovalec = 0;
		this.lastnik = new Oseba();

	}
	@Transient
	public String getIzpisiMesec() {
		
		return Oro.mesec(mesec);
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

	public int getZmagovalec() {
		return zmagovalec;
	}

	public void setZmagovalec(int zmagovalec) {
		this.zmagovalec = zmagovalec;
	}

}
