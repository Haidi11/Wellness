package vao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tocke {
	@Id
	@GeneratedValue
	private int id;
	private int idDogodek;
	private int idOseba;	
	
	/*
	 * getterji, setterji
	 */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
}
