package jms;

import java.io.Serializable;

public class Sporocilo implements Serializable {

	
	private String email;
	private String zadeva;
	private String telo;
	
	
	public Sporocilo(String email, String zadeva, String telo) {
		this.email=email;
		this.zadeva=zadeva;
		this.telo=telo;
		
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getZadeva() {
		return zadeva;
	}


	public void setZadeva(String zadeva) {
		this.zadeva = zadeva;
	}


	public String getTelo() {
		return telo;
	}


	public void setTelo(String telo) {
		this.telo = telo;
	}

	
	
	
	
}
