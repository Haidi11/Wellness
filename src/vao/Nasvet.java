package vao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Nasvet {
	
	@Id
	@GeneratedValue
	private int idNasvet;
	private String nasvet;
	private String avtor;
	private long timeStamp;
	
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
}
