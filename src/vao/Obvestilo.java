package vao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Obvestilo {
	
	@Id
	@GeneratedValue
	private int idObvestila;
	private int idOsebe;
	private int idDogodka;
	private long timeStamp;
	
	public Obvestilo() {} 
	
	public Obvestilo(int idOseba, int idDogodek) {
		this.idOsebe = idOseba;
		this.idDogodka = idDogodek;
		this.timeStamp = new Date().getTime();
	}
	
	public int getIdObvestila() {
		return idObvestila;
	}
	public void setIdObvestila(int idObvestila) {
		this.idObvestila = idObvestila;
	}
	public int getIdOsebe() {
		return idOsebe;
	}
	public void setIdOsebe(int idOsebe) {
		this.idOsebe = idOsebe;
	}
	public int getIdDogodka() {
		return idDogodka;
	}
	public void setIdDogodka(int idDogodka) {
		this.idDogodka = idDogodka;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
}
