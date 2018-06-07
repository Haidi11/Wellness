package vao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Nasvet {
	
	@Id
	@GeneratedValue
	private int idNasvet;
	private String naslov;
	@ManyToOne
    @JoinColumn(name = "fk_avtor")
	private Oseba avtor;
	@Column(length=10000)
	private String nasvet;
	private long timeStamp;
	
	public Nasvet() {
		this.nasvet="";
		this.naslov="";
		
	}
	
	public Nasvet( String naslov, String avtor,String nasvet) {
		this.naslov = naslov;
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
	public Oseba getAvtor() {
		return avtor;
	}
	public void setAvtor(Oseba avtor) {
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