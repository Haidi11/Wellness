package vao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Nasvet {
	
	@Id
	@GeneratedValue
	private int idNasvet;
	private String naslov;
	private String avtor;
	private String nasvet;
	private long timeStamp;
	
	public Nasvet() {}
	
	public Nasvet( String naslov, String avtor,String nasvet) {
		this.naslov = naslov;
		this.avtor = avtor;
		this.nasvet = nasvet;
		this.timeStamp = new Date().getTime();
	}
	
	public int getIdNasvet() {
		return idNasvet;
	}
	public void setIdNasvet(int idNasvet) {
		this.idNasvet = idNasvet;
	}
	public String getNasvet() {
		return nasvet;
	}
	public void setNasvet(String nasvet) {
		this.nasvet = nasvet;
	}
	public String getAvtor() {
		return avtor;
	}
	public void setAvtor(String avtor) {
		this.avtor = avtor;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
}
