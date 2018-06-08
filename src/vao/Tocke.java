package vao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Tocke {
	
	private int stTock;
	private int idDogodek;
	private int idOseba;	
	
	/*
	 * getterji, setterji
	 */
	public Tocke(int tocke, int idDogodek, int idOseba) {
		this.stTock = tocke;
		this.idDogodek = idDogodek;
		this.idOseba = idOseba;
	}

	public Tocke() {
		// TODO Auto-generated constructor stub
	}

	public int getIdDogodek() {
		return idDogodek;
	}
	public void setIdDogodek(int idDogodek) {
		this.idDogodek = idDogodek;
	}
	public int getIdOseba() {
		return idOseba;
	}
	public void setIdOseba(int idOseba) {
		this.idOseba = idOseba;
	}
	public int getStTock() {
		return stTock;
	}
	public void setStTock(int stTock) {
		this.stTock = stTock;
	}
}
